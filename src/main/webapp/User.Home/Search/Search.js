const url = "http://localhost:8080/ICAIapp_war_exploded/api/"
async function getUser() {

    let id = document.getElementById("id").value;
    console.log(id)
    let getURL = url +"users/"+ id
    console.log(getURL)
    const response = await fetch(getURL)
    if (!response.ok) {
        throw new Error(
            "HTTP ERROR! STATUS :${response.status}"
        );
    }
    const data = await response.json();
    data.forEach(users => {
        const usersList =
            `<li>${users.username}
            </li>`;
        document.querySelector('ol').insertAdjacentHTML('beforeend', usersList);
    })
}
async function getRecordLabel() {
    let id = document.getElementById("id").value;
    console.log(id)
    let getURL = url +"recordLabels/"+ id
    console.log(getURL)
    const response = await fetch(getURL)
    if (!response.ok) {
        throw new Error(
            "HTTP ERROR! STATUS :${response.status}"
        );
    }
    const data = await response.json();
    data.forEach(recordlabels => {
        const recordlabelsList =
            `<li>${recordlabels.name}
            </li>`;
        document.querySelector('ol').insertAdjacentHTML('beforeend', recordlabelsList);
    })
}

async function getPlaylist() {
    let id = document.getElementById("id").value;
    console.log(id)
    let getURL = url +"playlists/"+ id
    console.log(getURL)
    const response = await fetch(getURL)
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
async function getArtist() {
    let id = document.getElementById("id").value;
    console.log(id)
    let getURL = url +"artists/"+ id
    console.log(getURL)
    const response = await fetch(getURL)
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

async function getAlbum() {
    let id = document.getElementById("id").value;
    console.log(id)
    let getURL = url +"albums/"+ id
    console.log(getURL)
    const response = await fetch(getURL)
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

async function getSong() {
    let id = document.getElementById("id").value;
    console.log(id)
    let getURL = url +"songs/"+ id
    console.log(getURL)
    const response = await fetch(getURL)
    if (!response.ok) {
        throw new Error(
            "HTTP ERROR! STATUS :${response.status}"
        );
    }
    const data = await response.json();
    data.forEach(songs => {
        const songsList =
            `<li>${songs.name}, ${songs.time}
            </li>`;
        document.querySelector('ol').insertAdjacentHTML('beforeend', songsList);
    })
}