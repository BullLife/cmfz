<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $("#article_author").combobox({
            url : "${pageContext.request.contextPath}/guru/getAllGurus.do",
            valueField : "guruId",
            textField : "guruName",
            value : "暂无",
            onSelect : function(rec) {
                console.log(rec.guruId);
            }
        });
        $("#article_submit").linkbutton({
            iconCls: 'icon-table_save',
            onClick : function () {
                var temp =editor.txt.html();
                $("#article_in").val(temp);
                $("#article_ff").form("submit",{
                    url : "${pageContext.request.contextPath}/article/addarticle.do",
                    onSubmit : function(){
                        return $("#article_ff").form("validate");
                    },
                    success : function(result){
                        console.log(result);
                        //刷新页面
                        if(result == "successful"){
                            alert("创建文章成功");
                        }else{
                            alert("创建文章失败");
                        }
                    }
                });
                //console.log(CKEDITOR.instances.editor.getData());
            }
        });
        $("#article_rest").linkbutton({
            iconCls: 'icon-bullet_cross',
            onClick : function () {
                $("#article_ff").form("reset");

            }
        });
    })
</script>

<form id="article_ff" method="post" enctype="multipart/form-data" style="margin-left: 50px;margin-top: 50px">
    文章标题：<input class="easyui-textbox" data-options="iconCls:'icon-edit',required:true" style="width:150px"
                placeholder="请您输入文章的标题" name="articleName"><br><br>
    <!-- 创建下拉列框（作者上师） -->
    文章作者：<input id="article_author" name="guruId"><br><br>
    文章状态：<%--<select id="article_status" class="easyui-combobox" name="dept" data-options="required:true"style="width:150px;">
                <option value="上架">上架</option>
                <option value="未上架">未上架</option>
              </select> <br><br>--%>
            <input class="easyui-switchbutton" data-options="onText:'上架',offText:'未上架'" name="articleStatus"><br><br>
    文章内容：<br>
    <input type="hidden" name="introduction" id="article_in"><!-- 内容的隐藏域 -->
    <div id="editor">
        <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
    </div>

    <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
    <script type="text/javascript">
        var E = window.wangEditor
        var editor = new E('#editor');
        editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload.do';  // 上传图片到服务器
        editor.customConfig.uploadFileName = 'files'; //上传图片的名称

        editor.create()
    </script>
    <br><br>
    <a id="article_submit">创建文章</a>
    <a id="article_rest">重置内容</a>
</form>
