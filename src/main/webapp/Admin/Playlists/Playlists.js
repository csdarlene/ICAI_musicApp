const url = "http://localhost:8080/ICAIapp_war_exploded/api/playlists"

async function getPlaylists() {
    const response = await fetch(url)
    if (!response.ok) {
        throw new Error(
            "HTTP ERROR! STATUS :${response.status}"
        );
    }
    const data = await response.json();
    data.forEach(playlists => {
        const playlistsList =
            `<li>${playlists.name}
            </li>`;
        document.querySelector('ol').insertAdjacentHTML('beforeend', playlistsList);
    })

}