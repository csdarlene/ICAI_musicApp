const url = "http://localhost:8080/ICAIapp_war_exploded/api/artists/"


async function getArtists() {
    for (let i = 1; i < 11; i++) {
        let getURL = url + i
        console.log(getURL)
        await loopArtists(getURL);

    }

    async function loopArtists(url) {

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
}


async function getArtist() {
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
    data.forEach(artists => {
        const artistsList =
            `<li>${artists.name}
            </li>`;
        document.querySelector('ol').insertAdjacentHTML('beforeend', artistsList);
    })
}