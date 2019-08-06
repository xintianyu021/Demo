<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>酒店管理系统</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="css/colorpicker.css" />
        <link rel="stylesheet" href="css/datepicker.css" />
		<link rel="stylesheet" href="css/uniform.css" />	
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />	          
		<script src="js/jquery.min.js"></script>
       	<script src="js/jquery.ui.custom.js"></script>
       	<script src="js/bootstrap.min.js"></script>
       	<script src="js/bootstrap-colorpicker.js"></script>
       	<script src="js/bootstrap-datepicker.js"></script>
       	<script src="js/jquery.uniform.js"></script>
       	<script src="js/unicorn.js"></script>
		<script type="text/javascript" language="javascript">
			$(document).ready(function(){
				$('input[type=checkbox],input[type=radio],input[type=file]').uniform();
				$('.datepicker').datepicker();

			});
	
		</script>
	</head>	
	<body>
		<div id="header"><h1>酒店管理系统</h1></div>
		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse">
                    <a href="SysuserGradeServlet">
                        <i class="icon icon-user"></i>
                        <span class="text">
                           	${ sessionScope.sysuser.username }
                        </span>
                    </a>
                </li>
                <li class="btn btn-inverse">
                    <a href="LogoutServlet">
                        <i class="icon icon-share-alt"></i>
                        <span class="text">注销</span>
                    </a>
                </li>
            </ul>
        </div>
        <div id="sidebar">
            <ul>
                <li>
                    <a href="main.html">
                        <i class="icon icon-home"></i> 
                        <span>首页</span>
                    </a>
                </li>
                <li class="submenu">
                    <a href="#">
                        <i class="icon icon-time"></i> 
                        <span>基础信息管理</span>
                    </a>
                     <ul>
                        <li><a href="#">客房类型管理</a></li>
                        <li><a href="#">楼层管理</a></li>
                        <li><a href="#">商品类型管理</a></li>
                        <li><a href="#">商品管理</a></li>
                        <li><a href="#">会员管理</a></li>
                    
                    </ul>
                </li>
                <li>
                    <a href="changePassword.html">
                        <i class="icon icon-ok-circle"></i> 
                        <span>修改登录密码</span>
                    </a>
                </li>
                <li class="submenu">
                    <a href="#">
                        <i class="icon icon-user"></i> 
                        <span>休假管理</span> 
                        <!--
                        <span class="label">2</span>
                        -->
                    </a>
                    
                </li>
                <li>
                    <a href="emplist.html">
                        <i class="icon icon-user"></i> 
                        <span>员工信息管理</span> 
                    </a>
                </li>
                <li>
                    <a href="deptlist.html">
                        <i class="icon icon-flag"></i> 
                        <span>部门信息管理</span> 
                    </a>
                </li>
                <!--<li class="active">
                    <a href="joblist.html">
                        <i class="icon icon-briefcase"></i> 
                        <span>职位信息管理</span> 
                    </a>
                </li>-->
            </ul>
        </div>
        
		<div id="content">
			<div id="content-header">
				<h1>入住管理</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.html" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>
				<a href="#" class="current">VIP会员管理</a>
			</div>
			<form action="${ pageContext.request.contextPath }/CheckInManageServlet?method=getParts" method="post" name="searchForm">
				<input type="hidden" name="pagenum" id="pagenum"/>
				<div class="container-fluid">
					<div class="row-fluid">
						<div class="control-group">
							<span class="span3">
								身份证号：<input id="idcard" class="vipinput" name="idcard" type="text" style="width:65%"/>
							</span>
							<span class="span3">
								房间号：<input id="roomid" class="vipinput" name="roomid" type="text" style="width:65%"/>
							</span>
	                        <span class="span3">
								<input type="submit" value="提交" class="btn btn-info"/>
								<input type="reset" value="重置" class="btn btn-info"/>
							</span>
						</div>
					</div>
				</div>
			</form>
			<hr/>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-content nopadding">
							<table class="table table-bordered table-striped">
								<tr>
									<th>订单号</th>
									<th>客房号</th>
									<th>客房名称</th>
									<th>订单状态</th>
									<th>操作类型</th>
									<th>入住人</th>
									<th>身份证</th>
									<th>会员编号</th>
									<th>电话</th>
									<th>时间</th>
									<th>更新状态</th>
								</tr>
								
								<c:forEach items="${ list }" var="order">
									 <tr>
										 <td>${ order.orderid }</td>
										 <td>${ order.roomid }</td>
										 <td>${ order.roomtype }</td>
										 <td>${ order.orderstate }</td>
										 <td>${ order.optype }</td>
										 <td>${ order.guest }</td>
										 <td>${ order.idcard }</td>
										 <td>${ order.vipid }</td>
										 <td>${ order.tel }</td>	
										 <td>${ order.time }</td>
										 <td>${ order.newstate }</td>
										 <td>
	                                          <button class="btn btn-info" onclick="ChangeRoom(this)">
	                                          		<i class="icon-white icon-eye-open"></i>
	                                             	换房
	                                          </button>
	                                          <button class="btn btn-warning" onclick="Payment(this)">
	                                          		<i class="icon-white icon-refresh"></i>
	                                             	结账
	                                          </button>
	                                           <script type="text/javascript" src="js/jquery-3.4.1.js" ></script>
	                                          <script type="text/javascript">
	                                          	function OpenReserveInfo(th){
	                                          		var idcard = $(th).parent().siblings().eq(6).text();
	                                                 window.open("CheckInManageServlet?method=changeRoomFirst&idcard="+idcard,"changeRoom","width=1000,height=800,top=100,left=200")
	                                             }
	                                            function OpenCheckIn(th){
	                                            	var idcard = $(th).parent().siblings().eq(6).text();
	                                            	window.open("CheckInManageServlet?method=paymentFirst&idcard="+idcard,"payment","width=1000,height=800,top=100,left=200")
	                                            }
	                                          </script>
		                                         
		                                 </td>
	                                 </tr>
								</c:forEach>
								
							</table>							
						</div>
					</div>
				</div>
			</div>
			
				<c:if test="${ n==1 }">
					<div class="fg-toolbar ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix">
						<div class="dataTables_paginate fg-buttonset ui-buttonset fg-buttonset-multi ui-buttonset-multi paging_full_numbers">
						
								<a tabindex="0" href="${ pageContext.request.contextPath }/CheckInManageServlet?pageNum=1&method=getAll" class="first ui-corner-tl ui-corner-bl fg-button ui-button ui-state-default">首页</a>
								<c:choose>
				           			<c:when test="${pageNum>1}">
				               			<a href="${ pageContext.request.contextPath }/CheckInManageServlet?pageNum=${ param.pageNum-1 }&method=getAll" class="previous fg-button ui-button ui-state-default">上一页</a>
				           			</c:when>
			          				<c:otherwise>
			             		  			上一页
			           				</c:otherwise>
			      				</c:choose>

								<c:forEach begin="1" end="${ page }" var="pageNum">
									<a tabindex="0" href="${ pageContext.request.contextPath }/CheckInManageServlet?pageNum=${ pageNum }&method=getAll" class="fg-button ui-button ui-state-default">[${ pageNum }]</a>
								</c:forEach>
								
								<c:choose>
						           	<c:when test="${pageNum<requestScope.page}">
						               	<a href="${ pageContext.request.contextPath }/CheckInManageServlet?pageNum=${ param.pageNum+1 }&method=getAll" class="previous fg-button ui-button ui-state-default">下一页</a>
						           	</c:when>
					
					          		<c:otherwise>
					             		  	下一页
					           		</c:otherwise>
					      		 </c:choose>
								<a tabindex="0" href="${ pageContext.request.contextPath }/CheckInManageServlet?pageNum=${ page }&method=getAll" class="last ui-corner-tr ui-corner-br fg-button ui-button ui-state-default">尾页</a>	
						</div>
					</div>
				</c:if>

		</div>		
        <div class="row-fluid">&nbsp;</div>
        <div class="row-fluid">
            <div id="footer" class="span12">
                2016 &copy; 酒店管理系统
            </div>
        </div>
</body>
</html>