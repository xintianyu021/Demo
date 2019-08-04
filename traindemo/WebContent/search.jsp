<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function del(){
		var list =new Array();
		var j = 0;
		for(var i = 0 ;i<document.forms[0].del.length;i++){
			if(document.forms[0].del[i].checked){
				list[j]=document.forms[0].del[i].value;
				j++;
			}
		}
		if(list.length==0){
			alert("请选择车次！");
			return;
		}else{
			location.href="<%= request.getContextPath()%>/DelTrainnoServlet?list="+list;
		}
	}
</script>

</head>
<body>
	<form>
		<table border="1" width="700">
			<tr>
				<th><a href="#" onclick="del()">删除</a></th>
				<th>车次</th>
				<th>发车--到达</th>
				<th>发时--到时</th>
				<th>车型</th>
				<th>运行时间（小时）</th>
			</tr>
			<c:forEach items="${ list }" var="train" varStatus="status">
				<tr>
					<td><input type="checkbox" name="del" value="${ train.trainno }"></td>
					<td name="no"><a href="<%= request.getContextPath() %>/GetInfoServlet?no=${ train.trainno }">${ train.trainno }</a></td>
					<td>${ train.startstation }——${ train.arrivalstation }</td>
					<td>${ train.starttime }——${ train.arrivaltime }</td>
					<td>${ train.type }</td>
					<td>${ train.runtime }</td>
				</tr>
			</c:forEach>
		
			<tr>
				<td colspan="6">
					<c:forEach begin="1" end="${ page }" var="pageNum">
						<a href="${ pageContext.request.contextPath }/SearchTrainServlet?pageNum=${ pageNum }">[${ pageNum }]</a>
					</c:forEach>
				</td>
			</tr>
			
		
		
		
		</table>
	</form>
</body>
</html>