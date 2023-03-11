const url = "http://localhost:8080/ICAIapp_war_exploded/api/artists"

async function getArtists() {
    const response = await fetch(url)
    if (!response.ok) {
        throw new Error(
            "HTTP ERROR! STATUS :${response.status}"
        );
    }
    const data = await response.json();
    data.forEach(artists => {
        const artistsList =
            `<li>${artists.name}
            </li>`;
        document.querySelector('ol').insertAdjacentHTML('beforeend', artistsList);
    })
}

function displayArtistNames() {
    let artists = getArtists();
    artists.array.forEach(element => {
        console.log('Artist name: ' + element.name);
    });
}