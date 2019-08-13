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
	<head>
		<title>酒店管理系统</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="css/uniform.css" />
		<link rel="stylesheet" href="css/datepicker.css" />	
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />			
		<script src="js/jquery.min.js"></script>
        <script src="js/jquery.ui.custom.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.uniform.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/jquery.validate.js"></script>
        <script src="js/unicorn.js"></script>
        <script src="js/addemp.js"></script>	            
	</head>	
	<body>
		<div id="header" ><h1></h1></div>
		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse">
                    <a href="#">
                        <i class="icon icon-user"></i>
                        <span class="text">
                            ${ sessionScope.username==null?"testtext":sessionScope.username }
                        </span>
                    </a>
                </li>
                <li class="btn btn-inverse">
                    <a href="${ pageContext.request.contextPath }/LogoutServlet">
                        <i class="icon icon-share-alt"></i>
                        <span class="text">注销</span>
                    </a>
                </li>
            </ul>
        </div>
        <div id="sidebar">
            <ul>
                <li>
                    <a href="main.jsp">
                        <i class="icon icon-home"></i> 
                        <span>首页</span>
                    </a>
                </li>
                <c:if test="${ sessionScope.usertype=='超级管理员' || sessionScope.usertype==null }">
                <li class="submenu" >
                    <a href="#">
                        <i class="icon icon-tag"></i> 
                        <span>基础信息管理</span>
                    </a>
                    <ul>
                        <li><a href="${ pageContext.request.contextPath }/RoomTypeServlet">客房类型管理</a></li>
                        <li><a href="${ pageContext.request.contextPath }/StoreyServlet">楼层管理</a></li>
                        <li><a href="${ pageContext.request.contextPath }/GoodsTypeServlet">商品类别管理</a></li>
                        <li><a href="${ pageContext.request.contextPath }/GoodsInfoServlet">商品管理</a></li>
                        <li class="active"><a href="${ pageContext.request.contextPath }/vip.jsp">会员管理</a></li>
                    </ul>
                </li>
                </c:if>
                
                <c:if test="${ sessionScope.usertype=='超级管理员' || sessionScope.usertype==null }">
                <li class="submenu">
                    <a>
                        <i class="icon icon-ok-circle"></i> 
                        <span>系统管理</span>
                    </a>
                    <ul>
                        <li><a href="${ pageContext.request.contextPath }/OperationServletAll">日志管理</a></li>
                    </ul>
                </li>
                </c:if>
                <c:if test="${ sessionScope.usertype=='超级管理员' || sessionScope.usertype==null }">
                <li class="submenu">
                    <a href="#">
                        <i class="icon icon-flag"></i> 
                        <span>客房管理</span> 
                        <!--
                        <span class="label">2</span>
                        -->
                    </a>
                    <ul>
                        <li><a href="${ pageContext.request.contextPath }/GuestRoomServlet1">客房信息管理</a></li>
                    </ul>
                </li>
                </c:if>
                <c:if test="${ sessionScope.usertype=='超级管理员' || sessionScope.usertype=='经理' || sessionScope.usertype==null }">
                <li class="submenu">
                    <a href="#">
                        <i class="icon icon-time"></i> 
                        <span>报表管理</span> 
                        <!--
                        <span class="label">2</span>
                        -->
                    </a>
                    <ul>
                        <li><a href="${ pageContext.request.contextPath }/TableReserveServlet">预定客人报表</a></li>
                        <li><a href="${ pageContext.request.contextPath }/TableHereServlet">在住客人报表</a></li>
                        <li><a href="${ pageContext.request.contextPath }/TableLeaveServlet">离店客人报表</a></li>
                        <li><a href="${ pageContext.request.contextPath }/TableBillServlet">财务进账报表</a></li>
                    </ul>
                </li>
                </c:if>
                <c:if test="${ sessionScope.usertype=='超级管理员' || sessionScope.usertype=='前台' || sessionScope.usertype==null }">
                <li class="submenu">
                    <a href="#">
                        <i class="icon icon-user"></i> 
                        <span>客人管理</span> 
                    </a>
                    <ul>
                        <li><a href="${ pageContext.request.contextPath }/CheckInHotelServlet">入住及预订</a></li>
                        <li><a href="${ pageContext.request.contextPath }/ReserveServlet">预定信息和操作</a></li>
                        <li><a href="${ pageContext.request.contextPath }/CheckInManageServlet">入住信息和操作</a></li>
                    </ul>
                </li>
                </c:if>
                <c:if test="${ sessionScope.usertype=='超级管理员' || sessionScope.usertype=='前台' || sessionScope.usertype==null }">
                <li>
                    <a href="${ pageContext.request.contextPath }/BillServlet">
                        <i class="icon icon-briefcase"></i> 
                        <span>消费管理</span> 
                    </a>
                </li>
                </c:if>
            </ul>
        </div>
		<div id="content">
			<div id="content-header">
				<h1>修改会员</h1>
			</div>
			<div id="breadcrumb">
				<a href="#" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>
                
				<a href="#">基础信息管理</a>
				<a href="#" class="current">会员管理</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
						<div class="span12">
							<div class="widget-box">
								<div class="widget-title">
									<span class="icon">
										<i class="icon-align-justify"></i>									
									</span>
									<h5>会员信息</h5>
								</div>
								<div class="widget-content nopadding">
									<form id="eform" action="ModifyVipServlet" class="form-horizontal" method="post" />
	                                    <div id="info1" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	会员编号:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="vipid" id="vipid" value="${ vip.vipid }"/>
	                                        </div>
	                                    </div>
	                                    <div id="info2" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	会员姓名:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="guest" id="guest" value="${ vip.guest }"/>
	                                        </div>
	                                    </div>
	                                    <div id="info3" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	身份证号:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="idcard" id="idcard" value="${ vip.idcard }"/>
	                                        </div>
	                                    </div>
	                                    <div id="info4" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	性别:
	                                        </label>
	                                        <div class="controls">
	                                            <select id="gender" name="gender">
	                                            	
	                                            	<option value=男>男</option>
	                                            	<option value=女>女</option>
	                                            </select>
	                                        </div>
	                                         <script>
	                                        	$(function(){
	                                        		
	                                        		$("#gender")[0].value="${ vip.gender }";
	                                        		
	                                        	})
	                                        </script>
	                                    </div>
	                                    <div id="info5" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	密码:
	                                        </label>
	                                         <div class="controls">
	                                            <input type="text" name="password" id="password" value="${ vip.password }"/>
	                                        </div>
	                                    </div>
	                                    <div id="info6" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	电话:
	                                        </label>
	                                         <div class="controls">
	                                            <input type="text" name="tel" id="tel" value="${ vip.tel }"/>
	                                        </div>
	                                    </div>
	                                    <div id="info7" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	地址:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="address" id="address" value="${ vip.address }"/>
	                                        </div>
	                                    </div>
	                                    <div id="info8" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	邮箱:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="email" id="email" value="${ vip.email }"/>
	                                        </div>
	                                    </div>
	                                    <div id="info9" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	积分:
	                                        </label>
	                                         <div class="controls">
	                                            <input type="text" name="point" id="point" value="${ vip.point }"/>
	                                        </div>
	                                    </div>
	                                    <div id="info10" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	会员等级:
	                                        </label>
	                                        <div class="controls">
	                                            <select id="grade" name="grade">
	                                            	
	                                            	<option value=普通>普通</option>
                                                    <option value=VIP>VIP</option>
	                                            </select>
	                                        </div>
	                                        <script>
	                                        	$(function(){
	                                        		
	                                        		$("#grade")[0].value=${ vip.grade };
	                                        		
	                                        	})
	                                        </script>
	                                    </div>
                                        <div id="info11" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	备注:
	                                        </label>
	                                         <div class="controls">
	                                            <input type="text" name="notes" id="notes" value="${ vip.vip_note }"/>
	                                        </div>
	                                    </div>
	                                    <div class="form-actions">
	                                        <input type="submit" value="提交" class="btn btn-primary" />
	                                        <input type="reset" value="重置" class="btn btn-primary" />
	                                    </div>
	                                </form>
								</div>
							</div>			
						</div>
				</div>	
			</div>	
	
		</div>		
        <div class="row-fluid">&nbsp;</div>
        <div class="row-fluid">
            <div id="footer" class="span12">
                2019 &copy; 酒店管理系统
            </div>
        </div>
</body>
</html>