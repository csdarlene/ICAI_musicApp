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

async function deleteUser() {
    let id = document.getElementById("idDel").value;
    console.log(id)
    let getURL = url + id
    console.log(getURL)
    fetch(getURL, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            alert('Record deleted successfully:', data);
        })
        .catch(error => {
            console.error('Error deleting record:', error);
        });}




async function updateUserU() {
    let id = document.getElementById("idUpU").value;
    let username = document.getElementById("usernameUpU").value;
    console.log(id)
    let getURL = url + "username/" + id
    console.log(getURL)


    fetch(getURL, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: (username),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

        })
        .catch(error => {
            console.error('Error updating record:', error);
        });
}

async function updateUserP() {
    let id = document.getElementById("idUpP").value;
    let password = document.getElementById("passwordUpP").value;
    console.log(id)
    let getURL = url + "password/" + id
    console.log(getURL)


    fetch(getURL, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: (password),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }

        })
        .catch(error => {
            console.error('Error updating record:', error);
        });
}