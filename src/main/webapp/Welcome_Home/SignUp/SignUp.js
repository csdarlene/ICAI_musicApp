document.getElementById("SignUpButton").onclick = function() {
    name = document.getElementById("Name").value;
    email = document.getElementById("Email").value;
    birthday = document.getElementById("Birthday").value;
    password = document.getElementById("Password").value;
    username = document.getElementById("Username").value;

    const data = {
        name: name,
        email: email,
        birthday: birthday,
        password: password,
        username: username
    };
console.log("hi "+ name)

};
