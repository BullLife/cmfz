<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
    });
</script>

<form id="ff" method="post" enctype="multipart/form-data">
    <input type="hidden" name="guruId" style="display: none;" />
    <input type="hidden" name="guruPic" style="display: none;" />
    <input type="hidden" name="guruPicName" style="display: none;" />
    上师法名:<input class="easyui-validatebox" name="guruName" data-options="required:true"/><br>
    上师简述:<input class="easyui-validatebox" name="guruSummary" data-options="required:true"/><br>
    上传头像:<input class="easyui-filebox" name="myFile"/><br>
</form>
