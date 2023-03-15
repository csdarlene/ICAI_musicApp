const url = "http://localhost:8080/ICAIapp_war_exploded/api/userDetails/"

async function getUserDetails() {
    const response = await fetch(url)
    if (!response.ok) {
        throw new Error(
            "HTTP ERROR! STATUS :${response.status}"
        );
    }
    const data = await response.json();
    data.forEach(userDetails => {
        const userDetailsList =
            `<li>${userDetails.name}, ${userDetails.email}, ${userDetails.birthday}
            </li>`;
        document.querySelector('ol').insertAdjacentHTML('beforeend', userDetailsList);
    })

}