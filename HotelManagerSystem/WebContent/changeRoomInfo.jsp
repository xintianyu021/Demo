<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${ pageContext.request.contextPath }/CheckInManageServlet?method=changeRoomDone" method="post">
		<fieldset>
		<legend>确认换房信息</legend>
		<table>
			<tr>
				<td>入住人</td>
				<td><input readonly name="guest" value="${ param.guest }" /></td>
			</tr>
			<tr>
				<td>身份证号</td>
				<td><input readonly name="idcard" value="${ param.idcard }" /></td>
			</tr>
			<tr>
				<td>原房间号</td>
				<td><input readonly name="roomid" value="${ param.roomid }"/></td>
			</tr>
			<tr>
				<td>原房间类型</td>
				<td><input readonly name="typename" value="${ param.typename }"/></td>
			</tr>
			<tr>
				<td>新房间号</td>
				<td><input readonly name="newroomid" value="${ param.newroomid }"/></td>
			</tr>
			<tr>
				<td>新房间类型</td>
				<td><input readonly name="newtypename" value="${ param.newroomtype }"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="确认"/>
					<input type="button" id = "btn1" value="返回"/>
				</td>
				
			</tr>
		
		</table>
		</fieldset>
	</form>
</body>
<script type="text/javascript" src="js/jquery-3.4.1.js" ></script>
<script type="text/javascript">
$(function(){
	if(${!(empty n1) && !(empty n2)}){
		if(${ n1==1 && n2==1 }){
			alert("成功更换房间!");
		}else{
			alert("更换房间失败!");
		}
		window.close();
	}
	$("#btn1").click(function(){
		window.close();
	})
	
	
})
</script>
</html>