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
        <script src="js/modifyemp.js"></script>	            
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
                        <li class="active"><a href="${ pageContext.request.contextPath }/StoreyServlet">楼层管理</a></li>
                        <li><a href="${ pageContext.request.contextPath }/GoodsTypeServlet">商品类别管理</a></li>
                        <li><a href="${ pageContext.request.contextPath }/GoodsInfoServlet">商品管理</a></li>
                        <li><a href="${ pageContext.request.contextPath }/vip.jsp">会员管理</a></li>
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
				<h1>修改楼层</h1>
			</div>
			<div id="breadcrumb">
				<a href="#" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>
				<a href="#">基础信息管理</a>
				<a href="#" class="current">楼层管理</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
						<div class="span12">
							<div class="widget-box">
								<div class="widget-title">
									<span class="icon">
										<i class="icon-align-justify"></i>									
									</span>
									<h5>楼层信息</h5>
								</div>
								<div class="widget-content nopadding">
									<form id="eform" action="${ pageContext.request.contextPath }/StoreyServlet?method=getUpdate" class="form-horizontal" method="post" >
	                                    <div id="info1" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	楼层号:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="sid" id="sid" value="${ sto.storey }"/>
	                                        </div>
	                                    </div>
	                                    <div id="info1" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	楼层名:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="sname" id="sname" value="${ sto.storeyname }"/>
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

            <div class="alert alert-error">
                保存失败
            </div>

            <div class="alert alert-success">
                保存成功
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