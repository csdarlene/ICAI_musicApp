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

async function deleteUserDetail() {
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


async function updateUserDetailN() {
    let id = document.getElementById("idUpN").value;
    let name = document.getElementById("nameUpN").value;
    console.log(id)
    let getURL = url + "name/" + id
    console.log(getURL)


    fetch(getURL, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: (name),
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


async function updateUserDetailE() {
    let id = document.getElementById("idUpE").value;
    let email = document.getElementById("emailUpE").value;
    console.log(id)
    let getURL = url + "email/" + id
    console.log(getURL)


    fetch(getURL, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: (email),
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

