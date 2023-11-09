var ws;
let menuContent = document.getElementById("rightMenuBarContent");
let menuChat = document.getElementById("rightMenuBarChat");
let backBtn = document.getElementById("rightMenuBarTopBackBtn");

ws = new WebSocket();
//function wsOpen(){
//웹소켓 전송시 현재 방의 번호를 넘겨서 보낸다.
function openChat(roomNumber){
    menuContent.style.display = "none";
    menuChat.style.display = "block";
    backBtn.style.display = "block";
    ws = new WebSocket("ws://" + location.host + "/chating/"+roomNumber);
    $("rightMenuBarChat").load(window.location.href + "rightMenuBarChat");
}

function closeChat(){
    menuContent.style.display = "block";
    menuChat.style.display = "none";
    backBtn.style.display = "none";
    ws.close();
}

// wsEvt();
// }

// function wsEvt() {
ws.onopen = function(data){
    //소켓이 열리면 동작
}

ws.onmessage = function(data) {
    //메시지를 받으면 동작
    var msg = data.data;
    if(msg != null && msg.trim() != ''){
        var d = JSON.parse(msg);
        if(d.type == "getId"){
            var si = d.sessionId != null ? d.sessionId : "";
            if(si != ''){
                $("#sessionId").val(si);
                $('#chating').scrollTop($('#chating')[0].scrollHeight);
            }
        }else if(d.type == "message"){
            if(d.sessionId == $("#sessionId").val()){
                $("#chating").append("<div class='chatBack'><div class='me'>" + d.msg + "</div></div>");
                $('#chating').scrollTop($('#chating')[0].scrollHeight);
            }else{
                $("#chating").append("<div class='chatBack'><div class='othersPro'>"+d.userName+"</div><div class='others'>" + d.msg + "</div></div>");
                $('#chating').scrollTop($('#chating')[0].scrollHeight);
            }

        }else{
            console.warn("unknown type!")
        }
    }
}

document.addEventListener("keypress", function(e){
    if(e.keyCode == 13){ //enter press
        send();
    }
});
// }

function chatName(){
    var userName = $("#userName").val();
    if(userName == null || userName.trim() == ""){
        alert("사용자 이름을 입력해주세요.");
        $("#userName").focus();
    }else{
        // wsOpen();
        $("#yourName").hide();
        $("#yourMsg").show();
    }
}

function send() {
    if($("#chatting").val() != "" && $("#chatting").val() != null){
        var option ={
            type: "message",
            roomNumber: $("#roomNumber").val(),
            sessionId : $("#sessionId").val(),
            userName : $("#userName").val(),
            msg : $("#chatting").val()
        }
        ws.send(JSON.stringify(option))
        $('#chatting').val("");
    }
}