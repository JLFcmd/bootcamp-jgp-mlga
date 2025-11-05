// configuración
const API_BASE = "https://pokeapi.co/api/v2";
const PAGE_SIZE = 20;

// estado
let offset = 0;
let allPokemon = [];
let favorites = JSON.parse(localStorage.getItem("favorites")) || [];

//funciones auxiliares
const cap = (s) => s.charAt(0).toUpperCase() + s.slice(1);
const moreInfoUrl = (name) => `https://www.pokemon.com/es/pokedex/${name}`;

// crear tarjeta
function createTypeChips(types) {
  const wrap = document.createElement("div");
  wrap.className = "type-pokemon";
  types.forEach((t) => {
    const p = document.createElement("p");
    p.textContent = cap(t.type.name);
    wrap.appendChild(p);
  });
  return wrap;
}
//más info
function createMoreInfoBtn(name) {
  const a = document.createElement("a");
  a.className = "more-btn";
  a.href = moreInfoUrl(name);
  a.target = "_blank";
  a.rel = "noopener noreferrer";
  a.textContent = "Más información";
  return a;
}
//favoritos 
function createFavoriteBtn(pokemonName) {
  const btn = document.createElement("button");
  btn.className = "fav-btn";
  const isFav = favorites.includes(pokemonName);
  btn.textContent = isFav ? "❤️" : "🤍";

  btn.addEventListener("click", () => {
    const idx = favorites.indexOf(pokemonName);
    if (idx >= 0) {
      favorites.splice(idx, 1);
    } else {
      favorites.push(pokemonName);
    }
    localStorage.setItem("favorites", JSON.stringify(favorites));
    btn.textContent = favorites.includes(pokemonName) ? "❤️" : "🤍";
  });

  return btn;
}

//los favoritos los puedes ver en el localStorage del navegador





function createCard(p) {
  const card = document.createElement("article");
  card.className = "pokemon";

  // Imagen + ID
  const imgC = document.createElement("div");
  imgC.className = "img-container";

  const img = document.createElement("img");
  const sprite =
    p.sprites.other?.["official-artwork"]?.front_default ||
    p.sprites.front_default ||
    `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${p.id}.png`;
  img.src = sprite;
  img.alt = cap(p.name);

  const idP = document.createElement("p");
  idP.textContent = `ID/${p.id}`;

  imgC.appendChild(img);
  imgC.appendChild(idP);

  // Info
  const info = document.createElement("div");
  info.className = "info-container";

  const h2 = document.createElement("h2");
  h2.textContent = cap(p.name);

  const types = createTypeChips(p.types);

  info.appendChild(h2);
  info.appendChild(types);

  if (p.evolves_from) {
    const evo = document.createElement("div");
    evo.className = "evolution-pokemon";
    evo.innerHTML = `<p>Evoluciona de <span>${cap(p.evolves_from)}</span></p>`;
    info.appendChild(evo);
  }

  // Botones
  const btns = document.createElement("div");
  btns.className = "btns";
  btns.appendChild(createMoreInfoBtn(p.name));
  btns.appendChild(createFavoriteBtn(p.name));

  info.appendChild(btns);
  card.appendChild(imgC);
  card.appendChild(info);
  return card;
}

//renderizar
function render(list) {
  const container = document.getElementById("pokemons");
  const frag = document.createDocumentFragment();
  list.forEach((p) => frag.appendChild(createCard(p)));
  container.appendChild(frag);
}

//fetch datos
async function getPokemonPage(offset = 0, limit = PAGE_SIZE) {
  const res = await fetch(`${API_BASE}/pokemon?offset=${offset}&limit=${limit}`);
  if (!res.ok) throw new Error("Error al cargar Pokémon.");
  const data = await res.json();
  return data.results;
}
//fetch datos completos
async function getPokemonFullData(entry) {
  const res = await fetch(entry.url);
  const p = await res.json();

  const resSpecies = await fetch(`${API_BASE}/pokemon-species/${p.id}`);
  let evolvesFrom = null;
  if (resSpecies.ok) {
    const sp = await resSpecies.json();
    evolvesFrom = sp.evolves_from_species ? sp.evolves_from_species.name : null;
  }

  return {
    id: p.id,
    name: p.name,
    sprites: p.sprites,
    types: p.types,
    evolves_from: evolvesFrom,
  };
}

//cargar página
async function loadNextPage() {
  const entries = await getPokemonPage(offset, PAGE_SIZE);
  const batch = await Promise.all(entries.map(getPokemonFullData));
  allPokemon.push(...batch);
  render(batch);

  offset += PAGE_SIZE;

  if (entries.length < PAGE_SIZE) {
    document.getElementById("load-more").style.display = "none";
  }
}

// buscar
function setupSearch() {
  const input = document.getElementById("search-input");
  input.addEventListener("input", (e) => {
    const q = e.target.value.trim().toLowerCase();
    const container = document.getElementById("pokemons");
    container.innerHTML = "";
    const filtered = allPokemon.filter((p) => p.name.includes(q));
    render(filtered);
  });
}

// inicializar
document.addEventListener("DOMContentLoaded", () => {
  setupSearch();
  loadNextPage();

  document.getElementById("load-more").addEventListener("click", loadNextPage);
});
