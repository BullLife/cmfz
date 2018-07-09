<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $('#log_ttt').datagrid({
            width:1100,
            height:500,
            remoteSort:false,
            nowrap:false,
            pagination : true,
            pageList : [ 5,10,15,20 ],
            pageSize : 5,
            toolbar : "#log_tb",
            fitColumns : true,
            singleSelect : true,
            rownumbers : true,
            url:"${pageContext.request.contextPath}/log/getlogs.do",
            columns:[[
                {field:'logId',title:'日志编号',align:'center'},
                {field:'managerName',title:'操作人',sortable:true},
                {field:'time',title:'操作时间',sortable:true},
                {field:'resource',title:'操作资源',sortable:true},
                {field:'action',title:'操作类型',sortable:true},
                {field:'message',title:'操作详情',sortable:true},
                {field:'result',title:'操作结果',sortable:true},
                {field:'operate',title:'操作',width:50,
                    formatter : function(value,row,index){
                        console.log("row:"+row);
                        console.log("row:"+row.articleId);
                        console.log("index:"+index);
                        var str1 = "<a name='update' class='easyui-linkbutton' value='"+row.articleId+"'></a>";
                        return str1;
                    }},
            ]],
            onLoadSuccess : function (data) {
                $("a[name='update']").linkbutton({
                    text : "修改内容",
                    plain : true,
                    iconCls : 'icon-edit',
                    onClick : function () {
                        console.log($(this).val());
                    }
                });
            }
        });
    });
</script>

<table id="log_ttt"></table>
<div id="log_tb">
    <a id="log_update"></a>
    <a id="log_add" ></a>
    <a id="log_addmore"></a>
    <input id="log_ss" type="hidden"></input>
</div>
<div id="log_dialog"></div>
