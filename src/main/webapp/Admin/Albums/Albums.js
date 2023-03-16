const url = "http://localhost:8080/ICAIapp_war_exploded/api/albums/"
const buttonChoose = document.querySelectorAll(".myButton");
const idNum = 1;

async function getAlbums() {
    for (let i = 0; i < buttonChoose.length; i++) {
        let sum = null;
        buttonChoose[i].addEventListener("click", async function () {
            sum += idNum;

            let getURL = url + sum
            console.log(getURL)
            const response = await fetch(getURL)
            if (!response.ok) {
                throw new Error(
                    "HTTP ERROR! STATUS :${response.status}"
                );
            }
            const data = await response.json();
            data.forEach(albums => {
                const albumsList =
                    `<li>${albums.name}, ${albums.year}
             </li>`;
                document.querySelector('ol').insertAdjacentHTML('beforeend', albumsList);
            })
            console.log(sum);
        });

    }
}

async function getAlbum() {
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
    data.forEach(albums => {
        const albumsList =
            `<li>${albums.name}, ${albums.year}
            </li>`;
        document.querySelector('ol').insertAdjacentHTML('beforeend', albumsList);
    })
}

async function deleteAlbum() {
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
        });
}

async function updateAlbumY() {
    let id = document.getElementById("idUpY").value;
    let year = document.getElementById("yearUpY").value;
    console.log(id)
    let getURL = url + "year/" + id
    console.log(getURL)


    fetch(getURL, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(year),
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

async function updateAlbumN() {
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

