function getWebSocket() {
    var webSocket = new WebSocket('ws://localhost:8080/chat');

    webSocket.onopen = function (event) {
        console.log('WebSocket open connection');
    };

    webSocket.onmessage = function (event) {
        console.log('WebSocket Receives：%c' + event.data, 'color:green');

    };

    webSocket.onclose = function (event) {
        console.log('WebSocket close connection.');
    };

    webSocket.onerror = function (event) {
        console.log('WebSocket exception.');
    };

    return webSocket;
}

var webSocket = getWebSocket();

function sendMsgToServer() {
    var usernameT = document.getElementById('username').value;
    var message = document.getElementById('message').value;

    if (message.length > 0) {
        webSocket.send(JSON.stringify({username: usernameT, msg: message}));
        message = clearMsg();
    }
}

function clearMsg() {
    var message = document.getElementById('message');
    message.value = "";
}

document.onkeydown = function (event) {
    var e = event || window.event || arguments.callee.caller.arguments[0];
    e.keyCode === 13 && sendMsgToServer();
};
