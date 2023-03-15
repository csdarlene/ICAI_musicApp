const url = "http://localhost:8080/ICAIapp_war_exploded/api/users/"


async function getUsers() {
    for (let i = 1; i < 7; i++) {
        let getURL = url + i
        console.log(getURL)
        await loopUsers(getURL);

    }

    async function loopUsers(url) {
        const response = await fetch(url)
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
}


async function getUser() {
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
    data.forEach(users => {
        const usersList =
            `<li>${users.username}
            </li>`;
        document.querySelector('ol').insertAdjacentHTML('beforeend', usersList);
    })
}