const url = "http://localhost:8080/ICAIapp_war_exploded/api/albums"

async function getAlbums() {
    const response = await fetch(url)
    if (!response.ok) {
        throw new Error(
            "HTTP ERROR! STATUS :${response.status}"
        );
    }
    const data = await response.json();
    data.forEach(albums => {
        const albumsList =
            `<li>${albums.name}, ${albums.year}
            </li>`;
        document.querySelector('ol').insertAdjacentHTML('beforeend', albumsList);
    })

}