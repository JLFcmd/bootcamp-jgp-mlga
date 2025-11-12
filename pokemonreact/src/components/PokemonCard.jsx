import React from "react"


function cap(s) { return s.charAt(0).toUpperCase() + s.slice(1) }
function moreInfoUrl(name) { return `https://www.pokemon.com/es/pokedex/${name}` }


export default function PokemonCard({ p, onOpen, favorites, onFav }) {
    const sprite = p.sprites.other?.["official-artwork"]?.front_default || p.sprites.front_default || `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${p.id}.png`
    const isFav = favorites.includes(p.name)


    return (
        <article style={{ background: "#fff", borderRadius: 16, boxShadow: "0 4px 10px rgba(0,0,0,.1)", padding: 12, display: "flex", flexDirection: "column", alignItems: "center" }}>
            <div style={{ width: 128, height: 128, display: "grid", placeItems: "center", background: "#f3f3f3", borderRadius: 12, overflow: "hidden" }}>
                <img src={sprite} alt={p.name} style={{ width: 112, height: 112, objectFit: "contain" }} />
            </div>
            <p style={{ alignSelf: "flex-start", color: "#666", fontWeight: 700, marginTop: 8 }}>ID/{p.id}</p>
            <h2 style={{ fontSize: 18, fontWeight: 800, alignSelf: "flex-start" }}>{cap(p.name)}</h2>
            <div style={{ display: "flex", gap: 6, flexWrap: "wrap", textTransform: "uppercase", fontSize: 12, fontWeight: 700, color: "#6b7280", marginTop: 4, alignSelf: "flex-start" }}>
                {p.types.map(t => <span key={t.type.name} style={{ border: "1px solid #9ca3af", borderRadius: 6, padding: "2px 6px" }}>{cap(t.type.name)}</span>)}
            </div>
            {p.evolves_from && (
                <div style={{ marginTop: 8, fontSize: 14, borderLeft: "4px solid #8b5e34", paddingLeft: 8, color: "#8b5e34", width: "100%" }}>
                    Evoluciona de <span style={{ color: "#000", fontWeight: 700 }}>{cap(p.evolves_from)}</span>
                </div>
            )}
            <div style={{ display: "flex", gap: 8, alignItems: "center", justifyContent: "center", marginTop: 10 }}>
                <a href={moreInfoUrl(p.name)} target="_blank" rel="noreferrer noopener" style={{ background: "#3b4cca", color: "#fff", padding: "6px 10px", borderRadius: 8, fontSize: 14, textDecoration: "none" }}>Más información</a>
                <button onClick={() => onFav(p.name)} style={{ fontSize: 22, background: "none", border: "none", cursor: "pointer" }}>{isFav ? "❤️" : "🤍"}</button>
                <button onClick={() => onOpen(p)} style={{ border: "1px solid #ddd", padding: "6px 10px", borderRadius: 8, fontSize: 14, background: "#fff" }}>Ver detalle</button>
            </div>
        </article>
    )
}