// Login
function login() {
    var username = document.getElementById("username").value;
    var url = location.href + "index?username=" + username;

    location.href = url;
}

// Enter login
document.onkeydown = function(event) {
    var e = event || window.event || arguments.callee.caller.arguments[0];
    e.keyCode === 13 && login();
}