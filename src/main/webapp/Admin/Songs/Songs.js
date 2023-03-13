const url = "http://localhost:8080/ICAIapp_war_exploded/api/songs"

async function getSongs() {
    const response = await fetch(url)
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