<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $('#guru_t1').datagrid({
            width:1100,
            height:500,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            pagination : true,
            pageList : [ 5,10,15,20 ],
            pageSize : 5,
            toolbar : "#guru_tb",
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
    });
</script>

<table id="articl_t1"></table>
<div id="article_tb">
    <a id="article_update"></a>
    <a id="article_add" ></a>
    <a id="article_addmore"></a>
    <input id="article_ss"></input>
    <div id="atricle_mm" style="width:120px;display: none">
        <div data-options="name:'guruName',iconCls:'icon-ok'">法名</div>
        <div data-options="name:'guruSummary'">简介</div>
    </div>
</div>
<div id="article_dialog"></div>
