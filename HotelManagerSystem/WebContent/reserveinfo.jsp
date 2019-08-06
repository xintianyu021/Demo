<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${ pageContext.request.contextPath }/MoveInServlet?method=reserve" method="post">
		<fieldset>
		<legend>客房预定</legend>
		<table>
			<tr>
				<td>房间类型</td>
				<td><input readonly="readonly" name="roomtype" value="${ param.roomtype }" /></td>
			</tr>
			<tr>
				<td>房间号</td>
				<td><input readonly="readonly" name="roomid" value="${ param.roomid }" /></td>
			</tr>
			<tr>
				<td>身份证号：</td>
				<td><input name="idcard" /></td>
			</tr>
			<tr>
				<td>客户名</td>
				<td><input name="guest" /></td>
			</tr>
			<tr>
				<td>会员号</td>
				<td><input name="vipid" /></td>
			</tr>
			<tr>
				<td>联系方式</td>
				<td><input name="tel" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="预定"/>
					<input type="reset" value="重置"/>
				</td>
				
			</tr>
		
		</table>
		</fieldset>
	</form>
</body>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script >
	$(function(){
		if(${ param.msg != null }){
			if(${ param.msg=="reserved" }){
				alert("该客户已预订房间");
			}
			else if(${ param.msg=="checked" }){
				alert("该客户有在住的房间");
			}
			else if(${ param.msg=="success" }){
				alert("预订成功");
				
			}
			window.close();
		}
	});

</script>

</html>