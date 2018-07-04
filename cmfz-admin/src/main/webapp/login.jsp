<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"
		 pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
	<script type="text/javascript">
        var codeStatus=false;
		function checkCode(){
            var code = $("#enCode").val();
            $.post("${pageContext.request.contextPath}/mgr/checkCode.do", {code:code},
                function(data){
                    $("#vcodeInfo").html(data);
                    if(data=='验证码正确'){
                        codeStatus=true;
					}else {
                        codeStatus=false;
					}

                });
        }
		$(function(){
			/*$("#captchaImage").click(function(){//点击更换验证码
			 $("#captchaImage").attr("src","/code/getCode.do?"+timer());
			 });*/
			//  form 表单提交
			$("#loginForm").bind("submit",function(){
				/*checkCode();
				return codeStatus;*/
			});

		});
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/mgr/login.do" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td>
								<span id="vcodeInfo"  style="color: red;"></span>
							</td>
						</tr>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="${pageContext.request.contextPath}/img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text"  name="mgrId" class="text" value="${mgrId}" maxlength="40"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="mgrPwd" class="text"  maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="code" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/mgr/createVcode.do" title="点击更换验证码"
									 onclick="document.getElementById('captchaImage').src='${pageContext.request.contextPath}/mgr/createVcode.do?<%=Math.random()%>'"/>
							</td>

						</tr>

					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<label>
								<input type="checkbox" id="isRememberUsername" name="remember" value="true"/> 记住用户名
							</label>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>