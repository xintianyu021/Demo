<%@page import="com.neu.entity.Storey"%>
<%@page import="java.util.List"%>
<%@page import="com.neu.service.StoreyServiceImpl"%>
<%@page import="com.neu.service.StoreyService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<h1>楼层管理</h1>
			</div>
			<div id="breadcrumb">
				<a href="#" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>酒店管理系统
                <a href="#" >基础信息管理</a>
				<a href="#" class="current">楼层管理</a>
			</div>
			<!-- <form action="#" method="post" name="searchForm">
			<input type="hidden" name="pagenum" id="pagenum"/>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="control-group">
						<span class="span3">
							姓名：<input id="ename" name="ename" type="text" style="width:65%"/>
						</span>
						<span class="span3">
							性别：<select id="sex" name="sex" style="width:70%">
									<option value="-1">=请选择=</option>
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
						</span>
						<span class="span3">
							职位：<select id="job" name="job" style="width:70%">
									<option value="-1">=请选择=</option>
									<option value="1">软件工程师</option>
                                    <option value="2">高级软件工程师</option>
								</select>
						</span>
						<span class="span3">
							部门：<select id="dept" name="dept" style="width:70%">
									<option value="-1">=请选择=</option>
									<option value="1">研发一部</option>
                                    <option value="2">研发二部</option>
								</select>
						</span>
					</div>
					<div class="control-group">

						<span class="span6">
							入职日期：
							<input readonly id="sdate" name="sdate" type="text" data-date-format="yyyy-mm-dd" class="datepicker"/>  
							<input readonly id="edate" name="edate" type="text" data-date-format="yyyy-mm-dd" class="datepicker"/>
                        </span>   
						<span class="span3">
							状态：<select id="eflag" name="eflag" style="width:70%">
									<option value="-1">=请选择=</option>
									<option value="1">在职</option>
                                    <option value="2">离职</option>
								</select>
						</span>
                        <span class="span3">
							<button class="btn btn-info" onclick="submitForm(1);">
								<i class="icon-white icon-search"></i>
								查询
							</button>
							<button type="button" class="btn btn-info" onclick="resetForm();">
								<i class="icon-white icon-repeat"></i>
								重置
							</button>
						</span>
					</div>
				</div>
			</div>
			</form> -->
			<hr/>
			<div class="row-fluid">
				<div class="span12" style="padding-left:30px;">
					<button class="btn btn-info" onclick="addStorey();">
						<i class="icon-white icon-plus"></i>
						新增
					</button>
					<script type="text/javascript">
						function addStorey(){
							location.href="addStorey.jsp";
						}
					</script>
				</div>
				<div class="span12">
					<div class="widget-box">
						<div class="widget-content nopadding">
							<table class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>楼层号</th>
										<th>楼层名</th>
									</tr>
								</thead>
								<tbody>
                                    <c:forEach items="${ sto }" var="sto">
                                   	<tr>
                                        <td>${ sto.storey }</td>
                                        <td>${ sto.storeyname }</td>
                                        <td>
                                        	<h2>${ msg }</h2>	
                                            <button class="btn btn-warning" onclick="gotomodify(${ sto.storey })">
                                                <i class="icon-white icon-refresh"></i>
                                                修改
                                            </button>
                                            <button class="btn btn-success" onclick="gotoDelete(${ sto.storey })">
                                                <i class="icon-white icon-share"></i>
                                                删除
                                            </button> 
                                            <script type="text/javascript">
											  
                                              function gotomodify(storey){
                                                  location.href="${ pageContext.request.contextPath }/StoreyServlet?method=getModify&storey="+storey; 
                                              }
											  function gotoDelete(storey){
												  if(confirm("是否删除!")){
													  location.href = "${ pageContext.request.contextPath}/StoreyServlet?method=getDel&storey="+storey;  
												  }
                                                 
                                              }
                                            </script>
                                            <script type="text/javascript">
                                              
                                            </script>
                                        </td>
                                        </tr>
                                     </c:forEach>
								</tbody>
							</table>							
						</div>
					</div>
				</div>
			</div>
			<div class="fg-toolbar ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix">
				<div class="dataTables_paginate fg-buttonset ui-buttonset fg-buttonset-multi ui-buttonset-multi paging_full_numbers">
			<c:if test="${ pageNum == 1 }">
					首页 上一页 
			</c:if>
			<c:if test="${ pageNum > 1 }">
					<a href="${ pageContext.request.contextPath }/StoreyServlet?method=getAll&pageNum=1" class="first ui-corner-tl ui-corner-bl fg-button ui-button ui-state-default">首页</a>
					<a href="${ pageContext.request.contextPath }/StoreyServlet?method=getAll&pageNum=${ pageNum - 1 }" class="previous fg-button ui-button ui-state-default">上一页</a>
			</c:if>
			
			<c:forEach begin="1" end="${ page }" var="pageNum">
				<a href="${ pageContext.request.contextPath }/StoreyServlet?method=getAll&pageNum=${ pageNum }" class="fg-button ui-button ui-state-default">${ pageNum }</a>
			</c:forEach>
			<c:if test="${ pageNum == page }">
					下一页 末页
			</c:if>
			<c:if test="${ pageNum < page }">
					<a href="${ pageContext.request.contextPath }/StoreyServlet?method=getAll&pageNum=${ pageNum + 1 }" class="previous fg-button ui-button ui-state-default">下一页</a>
					<a href="${ pageContext.request.contextPath }/StoreyServlet?method=getAll&pageNum=${ page }" class="last ui-corner-tr ui-corner-br fg-button ui-button ui-state-default">末页</a>
			</c:if>
			<!-- <a tabindex="0" href="javascript:"+method+"(1)" class="first ui-corner-tl ui-corner-bl fg-button ui-button ui-state-default">首页</a>
			<a tabindex="0" href="#" class="previous fg-button ui-button ui-state-default">上一页</a>
            <a tabindex="0" href="#" class="fg-button ui-button ui-state-default">1</a>
            <a tabindex="0" class="fg-button ui-button ui-state-default ui-state-disabled">2
            </a>
            <a tabindex="0" href="#" class="fg-button ui-button ui-state-default">3</a>
            <a tabindex="0" href="#" class="previous fg-button ui-button ui-state-default">下一页</a>
			<a tabindex="0" href="#" class="last ui-corner-tr ui-corner-br fg-button ui-button ui-state-default">尾页</a> -->
			
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