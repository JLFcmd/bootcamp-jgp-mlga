import React from "react"


export default function DetailView({ p, onBack, favorites, onFav }) {
    const sprite = p.sprites.other?.["official-artwork"]?.front_default || p.sprites.front_default || `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${p.id}.png`
    const isFav = favorites.includes(p.name)


    return (
        <section style={{ width: "100%", maxWidth: 1000, margin: "0 auto", background: "#fff", borderRadius: 24, boxShadow: "0 8px 24px rgba(0,0,0,.12)", padding: 24 }}>
            <div style={{ display: "flex", gap: 24, flexDirection: "column" }}>
                <div style={{ display: "flex", gap: 24, flexDirection: "column" }}>
                    <div style={{ width: 224, height: 224, display: "grid", placeItems: "center", background: "#f3f3f3", borderRadius: 16, overflow: "hidden", margin: "0 auto" }}>
                        <img src={sprite} alt={p.name} style={{ width: 208, height: 208, objectFit: "contain" }} />
                    </div>
                    <div>
                        <div style={{ display: "flex", alignItems: "center", gap: 8, justifyContent: "center" }}>
                            <h1 style={{ fontSize: 28, fontWeight: 900 }}>{cap(p.name)}</h1>
                            <button onClick={() => onFav(p.name)} style={{ fontSize: 28, background: "none", border: "none", cursor: "pointer" }}>{isFav ? "❤️" : "🤍"}</button>
                        </div>
                        <p style={{ textAlign: "center", color: "#6b7280", fontWeight: 700, marginTop: 4 }}>ID/{p.id}</p>
                        <div style={{ display: "flex", gap: 6, flexWrap: "wrap", justifyContent: "center", marginTop: 8 }}>
                            {p.types.map(t => <span key={t.type.name} style={{ border: "1px solid #9ca3af", borderRadius: 6, padding: "2px 6px", textTransform: "uppercase", fontSize: 12, fontWeight: 700, color: "#6b7280" }}>{cap(t.type.name)}</span>)}
                        </div>
                        {p.evolves_from && (
                            <p style={{ marginTop: 8, color: "#8b5e34", borderLeft: "4px solid #8b5e34", paddingLeft: 8, textAlign: "center" }}>Evoluciona de <span style={{ color: "#000", fontWeight: 700 }}>{cap(p.evolves_from)}</span></p>
                        )}
                    </div>
                </div>


                <div style={{ display: "grid", gap: 12, gridTemplateColumns: "repeat(auto-fit,minmax(180px,1fr))", marginTop: 8 }}>
                    <div style={{ background: "#f8fafc", borderRadius: 12, padding: 12 }}>
                        <p style={{ fontWeight: 700 }}>Altura</p>
                        <p>{p.height / 10} m</p>
                    </div>
                    <div style={{ background: "#f8fafc", borderRadius: 12, padding: 12 }}>
                        <p style={{ fontWeight: 700 }}>Peso</p>
                        <p>{p.weight / 10} kg</p>
                    </div>
                    <div style={{ background: "#f8fafc", borderRadius: 12, padding: 12 }}>
                        <p style={{ fontWeight: 700 }}>Habilidades</p>
                        <p>{p.abilities.map(a => cap(a.ability.name)).join(", ")}</p>
                    </div>
                </div>


                <div style={{ marginTop: 16, display: "flex", gap: 12, flexWrap: "wrap", justifyContent: "center" }}>
                    <a href={moreInfoUrl(p.name)} target="_blank" rel="noreferrer noopener" style={{ background: "#3b4cca", color: "#fff", padding: "10px 16px", borderRadius: 10, textDecoration: "none" }}>Página oficial</a>
                    <button onClick={onBack} style={{ border: "1px solid #ddd", padding: "10px 16px", borderRadius: 10, background: "#fff" }}>Volver al listado</button>
                </div>
            </div>
        </section>
    )
}


