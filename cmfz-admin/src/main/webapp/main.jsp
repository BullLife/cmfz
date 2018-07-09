<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/columns-ext.js"></script>
<script type="text/javascript">
	function addTab(menuName,menuUrl){
	    console.log(menuUrl);
        var b = $("#tt").tabs("exists",menuName);
        if(!b){
            $("#tt").tabs("add",{
                title : menuName,
                select : false,
				href : "${pageContext.request.contextPath}/"+menuUrl,
                closable : true,
            });
            $("#tt").tabs("select",menuName);
		}else{
            $("#tt").tabs("select",menuName);
		}
    }
	$(function () {
		$.ajax({
			url : "${pageContext.request.contextPath}/menu/getmenus.do",
			success : function (result) {
				for(var key in  result){
                    $('#aa').accordion('add', {
                        title: result[key].menuName,
                        iconCls : result[key].menuIcon,
                        content: function () {
							var temp = result[key].menus;
							var length = result[key].menus.length;
							for(var i = 0; i<length ; i++){
                                $(this).append("<a class='easyui-linkbutton' data-options=\"iconCls:'"+temp[i].menuIcon+"'\" " +
									"style='text-align: center;align-content: center;padding:10px;width: 210px'  onclick=\"addTab('"+temp[i].menuName+"','"+temp[i].menuUrl+"')\">"+temp[i].menuName+"</a></br>");
                            }
                        },
                        selected: false,
                    });
                }
            },
            error : function () {
                console.log(123);
            }
		});
		var admin = "${sessionScope.manager.mgrName}";
		console.log(admin);
		if(admin == ""){
			$("#logout").linkbutton({
                disabled : true
			})
		}else {
            $("#logout").linkbutton({
                iconCls : "icon-01",
                onClick : function () {
                    $.messager.confirm("确认对话框", "您想要退出登录吗？", function(r){
                        if (r){
                            // 退出操作，出现消息窗口 并关闭对话框
                            $.messager.show({
                                title:"该窗口即将关闭",
                                msg:"对话框将在5秒后关闭",
                                timeout:5000,
                                showType:"slider",
                            });
                            window.location.href = "${pageContext.request.contextPath}/mgr/logout.do";
                        }
                    });
                }
            });
		};

    })
</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.manager.mgrName} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a id="logout">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>   
       
    <div  data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion"  data-options="fit:true">

		</div>
    </div>
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood'"  style="background-image:url(${pageContext.request.contextPath}/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>

	<div id="dd" style="display: none"></div>
</body> 
</html>