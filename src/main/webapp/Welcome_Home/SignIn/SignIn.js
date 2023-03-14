function signIn() {
    let password, username;
    document.getElementById("SignInButton").onclick = function () {
        password = document.getElementById("Password").value;
        username = document.getElementById("Username").value;
        console.log('hi ' + username + "!");

        let xmlhttp = new XMLHttpRequest();
        var api="http://localhost:8080/ICAIapp_war_exploded/api/users/" + username + "/" + password;

        xmlhttp.open("GET",api );
        xmlhttp.onreadystatechange = function () {
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                let response = JSON.parse(this.responseText);
                console.log("Welcome Back " + response.username);
                this.window.open("../../User.Home/HomePage.html");
            } else {
                console.error("Sign-in failed");
            }
        };

        xmlhttp.send();
    };
}
