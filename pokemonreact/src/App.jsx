import React, { useEffect, useMemo, useState } from "react"



function toggleFav(name) {
    setFavorites(v => v.includes(name) ? v.filter(x => x !== name) : [...v, name])
}


const visible = useMemo(() => {
    let list = items
    if (q.trim()) {
        const t = q.trim().toLowerCase()
        list = list.filter(p => p.name.includes(t) || String(p.id).includes(t))
    }
    if (typeFilter !== "all") {
        list = list.filter(p => p.types.some(t => t.type.name === typeFilter))
    }
    if (onlyFavs) {
        list = list.filter(p => favorites.includes(p.name))
    }
    return list
}, [items, q, typeFilter, onlyFavs, favorites])


return (
    <div className="min-h-screen" style={{ background: "#ffe628", color: "#333" }}>
        <header className="max-w-6xl mx-auto" style={{ padding: "24px 16px" }}>
            <h1 style={{ fontSize: 28, fontWeight: 900 }}>Pokédex</h1>
            <div className="grid" style={{ display: "grid", gap: 12, gridTemplateColumns: "repeat(auto-fit,minmax(220px,1fr))", marginTop: 12 }}>
                <input value={q} onChange={e => setQ(e.target.value)} placeholder="Filtra por nombre o ID..." className="shadow" style={{ padding: 10, borderRadius: 10, border: "1px solid #ddd" }} />
                <select value={typeFilter} onChange={e => setTypeFilter(e.target.value)} style={{ padding: 10, borderRadius: 10, border: "1px solid #ddd" }}>
                    <option value="all">Todos los tipos</option>
                    {types.map(t => <option key={t} value={t}>{cap(t)}</option>)}
                </select>
                <label style={{ display: "inline-flex", alignItems: "center", gap: 8 }}>
                    <input type="checkbox" checked={onlyFavs} onChange={e => setOnlyFavs(e.target.checked)} />
                    Ver solo favoritos
                </label>
                <button onClick={() => { setQ(""); setTypeFilter("all"); setOnlyFavs(false) }} style={{ padding: 10, borderRadius: 10, border: "1px solid #ddd", background: "#fff" }}>Limpiar filtros</button>
            </div>
        </header>


        <main className="max-w-6xl mx-auto" style={{ padding: "0 16px 60px" }}>
            {selected ? (
                <DetailView p={selected} onBack={closeDetail} favorites={favorites} onFav={toggleFav} />
            ) : (
                <>
                    {error && <div style={{ background: "#fee2e2", color: "#991b1b", border: "1px solid #fecaca", padding: 12, borderRadius: 12, marginBottom: 16 }}>{error}</div>}
                    <section style={{ display: "grid", gap: 16, gridTemplateColumns: "repeat(auto-fit,minmax(220px,1fr))" }}>
                        {visible.map(p => (
                            <PokemonCard key={p.id} p={p} onOpen={openDetail} favorites={favorites} onFav={toggleFav} />
                        ))}
                    </section>
                    <div style={{ display: "grid", placeItems: "center", marginTop: 24 }}>
                        <button onClick={loadNext} disabled={loading} style={{ background: "#e3350d", color: "#fff", fontWeight: 700, padding: "12px 20px", border: "none", borderRadius: 12, opacity: loading ? 0.6 : 1 }}>
                            {loading ? "Cargando..." : "Cargar más"}
                        </button>
                    </div>
                </>
            )}
        </main>
    </div>
)
