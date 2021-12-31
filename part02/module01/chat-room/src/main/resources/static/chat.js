function getWebSocket() {
    var webSocket = new WebSocket('ws://localhost:8080/chat/' + username.value);

    webSocket.onopen = function (event) {
        console.log('WebSocket open connection');
    };

    webSocket.onmessage = function (event) {
        console.log('WebSocket Receives：%c' + event.data, 'color:green');
        var allData = JSON.parse(event.data);
        changeOnlineCount(allData.onlineCount);
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
    var username = document.getElementById('username').value;
    var message = document.getElementById('message').value;

    if (message.length > 0) {
        webSocket.send(JSON.stringify({username, message}));
        message = clearMsg();
    }
}

function clearMsg() {
    var message = document.getElementById('message');
    message.value = "";
}

function changeOnlineCount(num) {
    var onlineCount = document.getElementById('onlineCount');
    onlineCount.innerText = num;
}

document.onkeydown = function (event) {
    var e = event || window.event || arguments.callee.caller.arguments[0];
    e.keyCode === 13 && sendMsgToServer();
};
