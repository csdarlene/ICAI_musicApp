async function getArtistSong() {
    const song = prompt('Type in a song');
    const response = await fetch('http://localhost:8080/ICAIapp_war_exploded/api/songs/songArtist/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: song
    });
    const data = await response.json();
    const table = document.getElementById('artistTable');
    data.forEach(artist => {
        const row = table.insertRow();
        const nameCell = row.insertCell(0);
        nameCell.innerHTML = artist.name;
    });
}

async function getUserPlaylist() {
    const name = prompt('Type in a username');
    const response = await fetch('http://localhost:8080/ICAIapp_war_exploded/api/playlists/userPlaylist', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: name
    });
    const data = await response.json();
    const table = document.getElementById('playlistTable');
    data.forEach(playlist => {
        const row = table.insertRow();
        const nameCell = row.insertCell(0);
        nameCell.innerHTML = playlist;
    });
}


async function GetPlaylistSong() {
    const playlist = prompt('Type in a playlist');
    const response = await fetch('http://localhost:8080/ICAIapp_war_exploded/api/playlists/playlistSongs/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: playlist
    });
    const data = await response.json();
    const table = document.getElementById('songTable');
    data.forEach(song => {
        const row = table.insertRow();
        const nameCell = row.insertCell(0);
        nameCell.innerHTML = song.name;
    });
}






