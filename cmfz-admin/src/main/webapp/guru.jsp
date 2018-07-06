<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $('#t1').datagrid({
            width:1100,
            height:500,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            pagination : true,
            pageList : [ 5,10,15,20 ],
            pageSize : 5,
            toolbar : "#tb",
            fitColumns : true,
            singleSelect : true,
            url:"${pageContext.request.contextPath}/guru/getallgurus.do",
            columns:[[
                {field:'guruId',title:'标识编号',align:'center'},
                {field:'guruName',title:'上师法名',sortable:true},
                {field:'guruSummary',title:'上师简介',sortable:true},
                {field:'guruPicName',title:'头像文件名',sortable:true},
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/guruPic/'+rowData.guruPicName +'" style="height:150px;"></td>' +
                    '</tr></table>';
            },
        });
        $("#add").linkbutton({
            iconCls : "icon-add",
            text : "新增上师信息",
            onClick : function(){
                $("#dialog").dialog({
                    width:500,
                    height:300,
                    title:"新增上师信息",
                    minimizable : true,
                    maximizable : true,
                    resizable : true,
                    href:"${pageContext.request.contextPath}/guruForm.jsp",
                    buttons : [{
                        iconCls:"icon-table_save",
                        text : "提交",
                        handler : function(){
                            $("#ff").form("submit",{
                                url : "${pageContext.request.contextPath}/guru/addguru.do",
                                onSubmit : function(){
                                    return $("#ff").form("validate");
                                },
                                success : function(result){
                                    console.log(result);
                                    if(result == "successful"){
                                        $.messager.show({
                                            title:"该窗口即将关闭",
                                            msg:"信息添加成功",
                                            timeout:5000,
                                            showType:"slider",
                                        });
                                        $('#t1').datagrid("load",{
                                            href : "${pageContext.request.contextPath}/guru/getallgurus.do",
                                        });
                                        $("#dialog").dialog("close");
                                    }
                                },
                            });
                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            // 关闭对话框窗口
                            $.messager.confirm("确认对话框", "您确定要退出添加吗？", function(r){
                                if (r){
                                    // 退出操作，出现消息窗口 并关闭对话框
                                    $.messager.show({
                                        title:"该窗口即将关闭",
                                        msg:"对话框将在5秒后关闭",
                                        timeout:5000,
                                        showType:"slider",
                                    });
                                    $("#dialog").dialog("close");
                                }
                            });
                        }
                    }],
                });
            }
        });
        $("#update").linkbutton({
            iconCls : "icon-edit",
            text : "修改上师信息",
            onClick : function(){
                $("#dialog").dialog({
                    width:500,
                    height:300,
                    title:"上师信息修改",
                    minimizable : true,
                    maximizable : true,
                    resizable : true,
                    //在对话框加载远程数据的时候触发，给表单赋值
                    onLoad : function(){
                        var select = $("#t1").datagrid("getSelected");
                        $.ajax({
                            url : "${pageContext.request.contextPath}/guru/queryguru.do",
                            data : {"guruId" : select.guruId},
                            type : "POST",
                            success: function(result){
                                console.log(result);
                                if(result.guruName != ""){
                                    $("#ff").form("load",result);
                                }else{
                                    alert("获取数据失败");
                                }
                            }
                        });
                    },
                    href:"${pageContext.request.contextPath}/guruForm.jsp",
                    buttons : [{
                        iconCls:"icon-table_save",
                        text : "提交",
                        handler : function(){
                            $("#ff").form("submit",{
                                url : "${pageContext.request.contextPath}/guru/updateguru.do",
                                onSubmit : function(){
                                    return $("#ff").form("validate");
                                },
                                success : function(result){
                                    console.log(result);
                                    //刷新页面
                                    if(result == "successful"){
                                        $("#t1").datagrid("load",{
                                            href : "${pageContext.request.contextPath}/guru/getallgurus.do",
                                        });
                                        $("#dialog").dialog("close");
                                    }else{
                                        alert("修改失败");
                                        $("#dialog").dialog("close");
                                    }
                                },
                            });
                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            // 关闭对话框窗口
                            $.messager.confirm("确认对话框", "您想要取消修改吗？", function(r){
                                if (r){
                                    // 退出操作，出现消息窗口 并关闭对话框
                                    $.messager.show({
                                        title:"该窗口即将关闭",
                                        msg:"对话框将在5秒后关闭",
                                        timeout:5000,
                                        showType:"slider",
                                    });
                                    $("#dialog").dialog("close");
                                }
                            });
                        }
                    }],
                });
            }
        });
        $('#ss').searchbox({
            menu:'#mm',
            prompt:'请输入查找条件',
            searcher:function(value,name){
                console.log(value);
                var url = "${pageContext.request.contextPath}/guru/querytrim.do?trim="+name+"&value="+value;
                $('#t1').datagrid({
                    width:1100,
                    height:500,
                    remoteSort:false,
                    singleSelect:true,
                    nowrap:false,
                    fitColumns:true,
                    pagination : true,
                    pageList : [ 5,10,15,20 ],
                    pageSize : 5,
                    toolbar : "#tb",
                    fitColumns : true,
                    singleSelect : true,
                    url:encodeURI(url),
                    columns:[[
                        {field:'guruId',title:'标识编号',align:'center'},
                        {field:'guruName',title:'上师法名',sortable:true},
                        {field:'guruSummary',title:'上师简介',sortable:true},
                        {field:'guruPicName',title:'头像文件名',sortable:true},
                    ]],
                    view: detailview,
                    detailFormatter: function(rowIndex, rowData){
                        return '<table><tr>' +
                            '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/guruPic/'+rowData.guruPicName +'" style="height:150px;"></td>' +
                            '</tr></table>';
                    },
                });
            },
        });
    });
</script>

<table id="t1"></table>
<div id="tb">
    <a id="update"></a>
    <a id="add" ></a>
    <input id="ss"></input>
    <div id="mm" style="width:120px;display: none">
        <div data-options="name:'guruName',iconCls:'icon-ok'">法名</div>
        <div data-options="name:'guruSummary'">简介</div>
    </div>
</div>
<div id="dialog"></div>
