<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
	<script type="text/javascript">
		var pagesize = 5;
        $(function() {
            $('#t1').datagrid({
                width:1000,
                height:400,
                remoteSort:false,
                singleSelect:true,
                nowrap:false,
                fitColumns:true,
                pagination : true,
                pageList : [ 5,10,15,20 ],
                pageSize : pagesize,
                toolbar : "#tb",
                fitColumns : true,
                singleSelect : true,
                url:"${pageContext.request.contextPath}/pic/getpictures.do",
                columns:[[
                    {field:'pictureId',title:'标识编号',align:'center'},
                    {field:'picturePath',title:'图片位置',sortable:true},
                    {field:'pictureName',title:'文件名',sortable:true},
                    {field:'pictureDescription',title:'描述信息',sortable:true},
                    {field:'pictureStatus',title:'轮播图状态',sortable:true},
                    {field:'pictureDate',title:'轮播图创建时间',align:'center'},
                    {field:'修改',title:'操作',align:'center'},
                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
					return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="' + rowData.picturePath +"/"+rowData.pictureName+ '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>Attribute: ' + rowData.pictureDescription + '</p>' +
                        '<p>Status: ' + rowData.pictureStatus + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            });
            $("#add").linkbutton({
                iconCls : "icon-add",
                text : "新增轮播图",
                onClick : function(){
                    $("#dialog").dialog({
                        width:500,
                        height:300,
                        title:"新增轮播图",
                        minimizable : true,
                        maximizable : true,
                        resizable : true,
                        href:"${pageContext.request.contextPath}/form.jsp",
                        buttons : [{
                            iconCls:"icon-save",
                            text : "提交",
                            handler : function(){
                                $("#ff").form("submit",{
                                    url : "${pageContext.request.contextPath}/pic/upload.do",
                                    onSubmit : function(){
                                        return $("#ff").form("validate");
                                    },
                                    success : function(result){
                                        console.log(result);
                                        if(result == "successful"){
                                            $.messager.show({
                                                title:"该窗口即将关闭",
                                                msg:"文件上传成功",
                                                timeout:5000,
                                                showType:"slider",
                                            });
                                            $('#t1').datagrid("load",{
                                                href : "${pageContext.request.contextPath}/pic/getpictures.do",
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
                                $.messager.confirm("确认对话框", "您想要退出登录吗？", function(r){
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
        });
	</script>

<table id="t1"></table>
<div id="tb">
	<a id="update"></a>
	<a id="add" ></a>
	<a id="delete"></a>
</div>
<div id="dialog"></div>
