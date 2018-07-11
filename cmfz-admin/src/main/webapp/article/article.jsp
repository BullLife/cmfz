<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $('#articl_ttt').datagrid({
            width:1100,
            height:500,
            remoteSort:false,
            nowrap:false,
            pagination : true,
            pageList : [ 5,10,15,20 ],
            pageSize : 5,
            toolbar : "#article_tb",
            fitColumns : true,
            singleSelect : true,
            rownumbers : true,
            url:"${pageContext.request.contextPath}/article/getallarticles.do",
            columns:[[
                {field:'articleId',title:'文章编号',align:'center'},
                {field:'articleName',title:'文章标题',sortable:true},
                {field:'articleStatus',title:'状态',sortable:true},
                {field:'publishDate',title:'创建时间',sortable:true},
                {field:'guruName',title:'所属上师',sortable:true},
                {field:'operate',title:'操作',width:50,
                    formatter : function(value,row,index){
                    console.log("row:"+row);
                    console.log("row:"+row.articleId);
                    console.log("index:"+index);
                    var str1 = "<a name='update' class='easyui-linkbutton'></a>";
                    return str1;
                }},
            ]],
            onLoadSuccess : function (data) {
                $("a[name='update']").linkbutton({
                    text : "查看文章详情",
                    plain : true,
                    iconCls : 'icon-edit',
                });
            }
        });
    });
</script>

<table id="articl_ttt"></table>
<div id="article_tb">
    <a id="article_update"></a>
    <a id="article_add" ></a>
    <a id="article_addmore"></a>
    <input id="article_ss" type="hidden"></input>
    <div id="atricle_mm" style="width:120px;display: none">
        <div data-options="name:'guruName',iconCls:'icon-ok'">法名</div>
        <div data-options="name:'guruSummary'">简介</div>
    </div>
</div>
<div id="article_dialog"></div>
