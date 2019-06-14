function openUserChoose() {
    openOrgTree(function(rst,selectedUser){
        if(rst){
            var userName="";
            if(selectedUser.length>0){
				for ( var i = 0; i <selectedUser.length; i++){
                    userName +=selectedUser[i].name+',';
				}
                userName=userName.substr(0,userName.length-1);
            }
            $("#userChoose").val(userName);
        }
    });

}

/* var pathName = document.location.pathname;
var index = pathName.substr(1).indexOf("/");
var contextPath = pathName.substr(0, index + 1); */
document.write("<script type='text/javascript' src='/js/layer/layer.js'></script>");
function openOrgTree(callback) {
    //var treeurl = "http://localhost:8080/ext/userChoose";
    var html="../userSelect/userChoose.html"
    userlist = null;
    layer.open({
        title: false,
        type: 2,
        area: ['700px', '520px'],
        fixed: false, //不固定
        maxmin: 0,
        scrollbar: false,
        closeBtn: 0,
        content: [html, 'no'],
        end: function () {
            var ok = userlist ? true : false;
            callback(ok, userlist);
        }
    });
}

var userlist;
function setLayerRst(parm) {
    userlist = parm;
}

function getUserList() {
    return userlist;
}

