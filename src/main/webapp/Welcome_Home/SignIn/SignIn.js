// function signIn() {
//     let password, username;
//     document.getElementById("SignInButton").onclick = function () {
//         password = document.getElementById("Password").value;
//         username = document.getElementById("Username").value;
//         console.log('hi ' + username + "!");
//
//         let xmlhttp = new XMLHttpRequest();
//         var api = "http://localhost:8080/ICAIapp_war_exploded/api/users/" + username + "/" + password;
//
//         xmlhttp.open("GET", api);
//         xmlhttp.onreadystatechange = function () {
//             if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
//                 let response = JSON.parse(this.responseText);
//                 console.log("Welcome Back " + response.username);
//                 this.window.open("../../User.Home/HomePage.html");
//             } else {
//                 console.error("Sign-in failed");
//             }
//         };
//
//         xmlhttp.send();
//     };
// }
//
// async function getUsers() {
//     for (let i = 1; i < 7; i++) {
//         let getURL = url + i
//         console.log(getURL)
//         await loopUsers(getURL);
//
//     }
//
//     async function loopUsers(url) {
//         const response = await fetch(url)
//         if (!response.ok) {
//             throw new Error(
//                 "HTTP ERROR! STATUS :${response.status}"
//             );
//         }
//         const data = await response.json();
//         data.forEach(users => {
//             const usersList =
//                 `<li>${users.username}
//             </li>`;
//             document.querySelector('ol').insertAdjacentHTML('beforeend', usersList);
//         })
//     }
// }
function signIn() {
    document.getElementById("SignInButton").onclick = async function () {
        const username = document.getElementById('Username').value;
        const password = document.getElementById('Password').value;
        let url = "http://localhost:8080/ICAIapp_war_exploded/api/users/" + username + "/" + password;

        const response = await fetch(url)
        console.log(url)
        if (!response.ok) {
            alert("try again")
            // location.reload(true);
        }
        const data = await response.json();
        window.open("http://localhost:8080/ICAIapp_war_exploded/User.Home/HomePage.html");
    }}