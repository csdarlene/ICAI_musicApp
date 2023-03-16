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
        });}

