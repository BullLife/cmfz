
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">

    $(function() {
        /*$('#cc').combobox({
            url:'combobox_data.json',
            valueField:'id',
            textField:'text'
        });*/
    });
</script>

<form id="ff" method="post" enctype="multipart/form-data">
    <input type="hidden" name="pictureId" style="display: none;" />
    <input type="hidden" name="picturePath" style="display: none;" />
    <input type="hidden" name="pictureName" style="display: none;" />

    轮播图描述:<input class="easyui-validatebox" name="pictureDescription" data-options="required:true"/><br>
    轮播图状态:<select id="cc" class="easyui-combobox" name="pictureStatus" data-options="required:true" style="width:200px;">
                <option value="展示中">展示中</option>
                <option value="未展示">未展示</option>
                </select> <br>
    上传轮播图:<input class="easyui-filebox" name="myFile"/><br>
</form>
