async function getArtistSong() {
    var url1 = "http://localhost:8080/ICAIapp_war_exploded/api/songs/SongArtist/"
    let song = prompt('Type in a song');
    var getUrl1 = url1 + song
    console.log(getUrl1)
    const response = await fetch(getUrl1)
    if (!response.ok) {
        throw new Error(
            "HTTP ERROR! STATUS :${response.status}"
        );
    }

    const data = await response.json()
    console.log(data)
    data.forEach(artist => {
    const artistsList =
        `<li>${artist}
            </li>`;
    document.querySelector('ol').insertAdjacentHTML('beforeend', artistsList + " - " + song);
    })

    let bar = confirm('Refresh page: Confirm or deny');
    location.reload(bar);
}

async function getUserPlaylist() {
    var url2 = "http://localhost:8080/ICAIapp_war_exploded/api/playlists/UserPlaylist/"
    let username = prompt('Type in a username');
    var getUrl2 = url2 + username
    console.log(getUrl2)
    const response = await fetch(getUrl2)
    if (!response.ok) {
        throw new Error(
            "HTTP ERROR! STATUS :${response.status}"
        );
    }
    const data = await response.json();
    console.log(data)
    data.forEach(playlist => {
        const playlistList =
            `<li>${playlist.name}, ${playlist.modified}
            </li>`;
        document.querySelector('ol').insertAdjacentHTML('beforeend', playlistList);
    })

    let bar = confirm('Refresh page: Confirm or deny');
    location.reload(bar);
}

async function getYear() {
    var url3 = "http://localhost:8080/ICAIapp_war_exploded/api/songs/"
    let year = prompt('Type in a year');
    const response = await fetch(url3)
    if (!response.ok) {
        throw new Error(
            "HTTP ERROR! STATUS :${response.status}"
        );
    }
    const data = await response.json();
    console.log(data)
    data.forEach(album => {
        if (album.year === year) {
            // const albumList = { name: album.name, year: album.year };
            const yearY = `<li>${albumList.name}, ${albumList.year}</li>`;
            document.querySelector('ol').insertAdjacentHTML('beforeend', yearY);
            console.log(album.name, album.year);
        }
    });
    // let bar = confirm('Refresh page: Confirm or deny');
    // location.reload(bar);

}

async function GetPlaylistSong() {
    const url4 = "http://localhost:8080/ICAIapp_war_exploded/api/playlists/";
    const playlist = prompt('Type in a Playlist');
    const response = await fetch(url4);
    if (!response.ok) {
        throw new Error(`HTTP ERROR! STATUS: ${response.status}`);
    }
    const data = await response.json();
    console.log(data)
    const albumList = [];
    data.forEach(playlist => {
        albumList.push({id: playlist.id, name: playlist.name});
    });
    for (const obj of albumList) {
        if (obj.name === playlist) {
            console.log(obj.id);
            const id = obj.id;
            const getURL4 = url4 + id;
            console.log(getURL);
            const response = await fetch(getURL4);
            if (!response.ok) {
                throw new Error(`HTTP ERROR! STATUS: ${response.status}`);
            }
            const data = await response.json();
            data.forEach(playlists => {
                const playlistsList = `<li>${playlists.songSet.name}</li>`;
                document.querySelector('ol').insertAdjacentHTML('beforeend', playlistsList);
            });
        }
    }
    const bar = confirm('Refresh page: Confirm or deny');
    location.reload(bar);
}






