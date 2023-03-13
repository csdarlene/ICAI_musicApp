const url = "http://localhost:8080/ICAIapp_war_exploded/api/users"

async function getUsers() {
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