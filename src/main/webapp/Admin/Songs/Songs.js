const url = "http://localhost:8080/ICAIapp_war_exploded/api/songs/"


async function getSongs() {
    for (let i = 1; i < 12; i++) {
        let getURL = url + i
        console.log(getURL)
        await loopSongs(getURL);

    }

    async function loopSongs(url) {

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
}


async function getSong() {
    let id = document.getElementById("id").value;
    console.log(id)
    let getURL = url + id
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