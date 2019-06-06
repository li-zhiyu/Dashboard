

"use strict";
var $bootstrapTable;
var R_editor;/* 发布 */
var M_editor;/* 修改 */

$(document).ready(function () {
    "use strict";
    KindEditor.ready(function (K) {
        R_editor = K.create('#txt-body2', {
            items: ['formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', '|',
                'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist', 'insertunorderedlist', '|',
                'removeformat', 'undo', 'redo', 'fullscreen', 'source', 'about'],
            themeType: 'simple',
            autoHeightMode: true,
            minHeight: 300
        });


    });
    KindEditor.ready(function (K) {
        M_editor = K.create('#txt-body', {
            items: ['formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', '|',
                'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist', 'insertunorderedlist', '|',
                'removeformat', 'undo', 'redo', 'fullscreen', 'source', 'about'],
            themeType: 'simple',
            autoHeightMode: true,
            minHeight: 300
        });


    });

    $bootstrapTable = $('#table_js_1').bootstrapTable({
        url: '/statistic/getAllNotice',
        method: 'POST',
        toolbar: '#toolbar',
        clickToSelect: true,
        height: 650,
        columns: [{
            radio: true,
            visible: true                  //是否显示复选框  
        }, {
            field: 'TOPIC',
            title: '主题',
            width: 600,
        }, {
            field: 'TYPE',
            title: '通知类型',
            width: 100,
            align: 'center'
        }, {
            field: 'LEVEL',
            title: '等级',
            width: 100,
            align: 'center'
        }, {
            field: 'PUBLISHER',
            title: '发布者',
            width: 100,
            align: 'center'
        }, {
            field: 'PUBLISH_DATE',
            title: '发布日期',
            align: 'center',
            width: 200,
            sortable: true
        }, {
            field: 'ID',
            title: '操作',
            width: 100,
            align: 'center',
            valign: 'middle',
            formatter: actionFormatter
        }]
    });
});

function actionFormatter(value, row, index) {
    var id = value;
    var formatter = "";
    formatter += "<a href='javascript:;' class='icon-container' onclick=\"EditById('" + id + "')\" title='编辑'><span class='glyphicon glyphicon-pencil'></span></a>";
    formatter += "<a href='javascript:;' class='icon-container' onclick=\"DeleteByIds('" + id + "')\" title='删除'><span class='glyphicon glyphicon-remove'></span></a>";

    return formatter;
}


/* 公告删除 */
function DeleteByIds(id) {
    $("#myModal3").modal("show");
    $("#selectId").val(id);
}

function DeleteNotice(){
    var id = $("#selectId").val();
    Ext.Ajax.request({
        async: false,
        url: '/statistic/delNoticeById',
        timeout: 100000000,// 最大等待时间,超出则会触发超时
        params: { ID: id },//传入参数
        success: function (response) {
            alert("删除成功！");
        },
        failure: function (data) {

        }
    });
    $("#myModal3").modal("hide");
    $bootstrapTable.bootstrapTable('refresh');
}
/* 公告删除 */


/* 公告修改 */
function EditById(id) {
    $("#myModal").modal("show");
    document.getElementById("noticeForm").reset();//清空表单内容
    $("#id").val(id);
    Ext.Ajax.request({
        async: false,
        url: '/statistic/queryNoticeById',
        timeout: 100000000,// 最大等待时间,超出则会触发超时
        params: { ID: id },//传入参数
        success: function (response) {
            var respText = Ext.util.JSON.decode(response.responseText);
            if (respText.code != "OK") {
                return;
            }
            $("#noticeTopic").val(respText.topic);
            M_editor.html(respText.body);
            $("input[name='noticeType'][value=" + respText.type + "]").attr("checked", true);
            $("input[name='noticeLevel'][value=" + respText.level + "]").attr("checked", true);
        },
        failure: function (data) {

        }
    });

}

function saveById() {
    M_editor.sync();//将 KindEditor编辑框中的内容同步到textarea
    var value_content = $("#txt-body").val();
    var value_topic = $("#noticeTopic").val();
    var id = $("#id").val();
    if (value_content == "") {
        alert("通知内容不能为空白，无法保存！");
        return;
    }
    if (value_content == "") {
        alert("通知主题不能为空白，无法保存！");
        return;
    }
    Ext.Ajax.request({
        url: '/statistic/saveNoticeInfoById',
        //method : 'post', 
        params: { ID: id },//传入参数 
        form: 'noticeForm', // 指定表单  
        success: function (response) {
            alert("修改成功！");
        },
        failure: function () {
            alert("保存失败，请联系管理员！");
        }
    });
    $("#myModal").modal("hide");
    $bootstrapTable.bootstrapTable('refresh');
}
/* 公告修改 */

/* 公告发布 */
function addNotice() {
    $("#myModal2").modal("show");
    document.getElementById("noticeForm2").reset();//清空表单内容
    R_editor.html("");//清空文本域
}

function noticeInfoSubmit() {
    R_editor.sync();//将 KindEditor编辑框中的内容同步到textarea
    var value_content = $("#txt-body2").val();
    var value_topic = $("#noticeTopic2").val();
    if (value_content == "") {
        alert("通知内容不能为空白，请填写后再发布！");
        return;
    }
    if (value_content == "") {
        alert("通知主题不能为空白，请填写后再发布！");
        return;
    }
    Ext.Ajax.request({
        url: '/statistic/createNoticeInfo',
        //method : 'post',  
        form: 'noticeForm2', // 指定提交表单  
        success: function (response) {
            var respText = Ext.util.JSON.decode(response.responseText);
            if (respText.code != "OK") {
                return;
            }
            alert("发布成功！");
            $("#myModal2").modal("hide");
            $bootstrapTable.bootstrapTable('refresh');
        },
        failure: function () {
            alert("发布失败，请联系管理员！");
        }
    });
}
/* 公告发布 */