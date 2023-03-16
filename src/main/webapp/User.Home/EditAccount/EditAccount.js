const url = "http://localhost:8080/ICAIapp_war_exploded/api/users/"

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
    alert("Updated")
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
    alert("Updated")
}