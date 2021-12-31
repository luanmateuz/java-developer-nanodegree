function getWebSocket() {
    var webSocket = new WebSocket('ws://localhost:8080/chat/' + username.value);

    webSocket.onopen = function (event) {
        console.log('WebSocket open connection');
    };

    webSocket.onmessage = function (event) {
        console.log('WebSocket Receives：%c' + event.data, 'color:green');
        var allData = JSON.parse(event.data);

        chatMessages(allData);
        changeOnlineCount(allData);
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

function changeOnlineCount(allData) {
    var number = allData.onlineCount;
    var onlineCount = document.getElementById('onlineCount');

    onlineCount.innerText = number;
}

function chatMessages(allData) {
    var { type, username, message } = allData;
    var chatMessages = document.getElementById('chat-messages');

    if (type === 'SPEAK') {
        var div = document.createElement('div');
        div.className = 'border border-primary rounded mt-3';

        div.innerHTML = `
            <p class="fs-6 fw-light no-margin text-primary mt-1 mb-1">${username}</p>
            <p class="no-margin mb-1 text-break">${message}</p>
        `;

        chatMessages.appendChild(div);
    }

}

document.onkeydown = function (event) {
    var e = event || window.event || arguments.callee.caller.arguments[0];
    e.keyCode === 13 && sendMsgToServer();
};
