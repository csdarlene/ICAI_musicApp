function signIn() {
    let password, username;
    document.getElementById("SignInButton").onclick = function () {
        password = document.getElementById("Password").value;
        username = document.getElementById("Username").value;
        console.log('hi ' + username+"!");
        let user = {"username": username, "password": password};

        let xmlhttp = new XMLHttpRequest();
        xmlhttp.open("GET", "http://localhost:8080/ICAIapp_war_exploded/api/users", true);
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify(user));

        xmlhttp.onreadystatechange = function () {
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                let response = JSON.parse(this.responseText);
                console.log("Welcome Back " + response.username);
                window.open("../../User.Home/HomePage.html")
            } else {
                console.error("Sign-in failed");
            }
        }
    }
}
