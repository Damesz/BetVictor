<!DOCTYPE html>
<html>
<head>
    <title>BetVictor Exercise</title>
    <script src="http://cdn.sockjs.org/sockjs-0.3.4.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function(event) {
            connect();
        });
        var stompClient = null;
        function setConnected(connected) {
            document.getElementById('betVictorDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }
        function connect() {
            var socket = new SockJS('/add');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                stompClient.subscribe('/topic/showResult', function(calResult){
                    showResult(JSON.parse(calResult.body).message);
                });
            });
        }

        function sendComment() {
            var comment = document.getElementById('comment').value;
            stompClient.send("/saveObject/add", {}, JSON.stringify({ 'comment': comment}));
        }
        function showResult(message) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(message));
            response.appendChild(p);
        }
    </script>
</head>
<body>
<div>
    <div id="betVictorDiv">
        <label>Comment (optional):</label><input type="text" id="comment" /><br/>
        <button id="sendComment" onclick="sendComment();">Create Entity manual</button>
        <p id="response"></p>
    </div>
</div>
</body>
</html>