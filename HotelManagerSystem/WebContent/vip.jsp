<%@page import="com.neu.entity.Vip"%>
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
				<h1>VIP会员管理</h1>
			</div>
			<div id="breadcrumb">
				<a href="#" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>
                <a href="#" class="current">基础信息管理</a>
				<a href="#" class="current">会员管理</a>
			</div>
			<form action="${ pageContext.request.contextPath }/SearchVipServlet?pageNum=1" method="post" name="searchForm">
				<input type="hidden" name="pagenum" id="pagenum"/>
				<div class="container-fluid">
					<div class="row-fluid">
						<div class="control-group">
							<span class="span3">
								会员编号：<input id="vipid" class="vipinput" name="vipid" type="text" style="width:65%"/>
							</span>
							<span class="span3">
								会员姓名：<input id="guest" class="vipinput" name="guest" type="text" style="width:65%"/>
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
				<div class="span12" style="padding-left:30px;">
					<button class="btn btn-info" onclick="addVip();">
						<i class="icon-white icon-plus"></i>
						新增
					</button>
					<script type="text/javascript">
						function addVip(){
							location.href="addVip.jsp";
						}
					</script>
				</div>
				<div class="span12">
					<div class="widget-box">
						<div class="widget-content nopadding">
							<table class="table table-bordered table-striped">
								
								<tr>
									<th>会员编号</th>
									<th>会员姓名</th>
									<th>身份证号</th>
									<th>性别</th>
									<th>密码</th>
									<th>电话</th>
									<th>地址</th>
									<th>积分</th>
									<th>会员等级</th>
									<th>备注</th>
									<th>操作</th>
								</tr>
							<c:choose>
								<c:when test="${ (empty vip) && !(empty list) }">
									<c:forEach items="${ list }" var="vip">
										<tr>
	                                      <td>${ vip.vipid }</td>
	                                      <td class="gname">${ vip.guest }</td>
	                                      <td>${ vip.idcard }</td>
	                                      <td>${ vip.gender }</td>
	                                      <td>${ vip.password }</td>
	                                      <td>${ vip.tel }</td>
	                                      <td>${ vip.address }</td>
	                                      <td>${ vip.point }</td>
	                                      <td>${ vip.grade }</td>
	                                      <td>${ vip.vip_note }</td>
	                                      <td>
	                                          <button class="btn btn-info" onclick="updateVip(this)">
	                                          		<i class="icon-white icon-eye-open"></i>
	                                             	 修改
	                                          </button>
	                                          <button class="btn btn-warning" onclick="deleteVip(this)">
	                                          		<i class="icon-white icon-refresh"></i>
	                                             	 删除
	                                          </button>
	                                           
	                                          <script type="text/javascript">
	                                          	function updateVip(th){
	                                          		var vipid = $(th).parent().siblings().eq(0).text();
	                                                 location.href="${ pageContext.request.contextPath }/UpdateVipServlet?vipid="+vipid;
	                                             }
	                                            function deleteVip(){
	                                                if(confirm("是否删除")){
	                                                	var vipid = $(th).parent().siblings().eq(0).text();
	                                                	location.href="${ pageContext.request.contextPath }/DeleteVipServlet?vipid="+vipid;
	                                                }
	                                            	
	                                            }
	                                          </script>
		                                         
		                                      </td>
		                                  </tr>
									</c:forEach>
								</c:when>
								<c:when test="${ !(empty vip) && (empty list) }">
									<tr>
	                                      <td>${ vip.vipid }</td>
	                                      <td>${ vip.guest }</td>
	                                      <td>${ vip.idcard }</td>
	                                      <td>${ vip.gender }</td>
	                                      <td>${ vip.password }</td>
	                                      <td>${ vip.tel }</td>
	                                      <td>${ vip.address }</td>
	                                      <td>${ vip.point }</td>
	                                      <td>${ vip.grade }</td>
	                                      <td>${ vip.vip_note }</td>
	                                      <td>
	                                          <button class="btn btn-info" onclick="updateVip()">
	                                          		<i class="icon-white icon-eye-open"></i>
	                                             	 修改
	                                          </button>
	                                          <button class="btn btn-warning" onclick="deleteVip()">
	                                          		<i class="icon-white icon-refresh"></i>
	                                             	 删除
	                                          </button>
	                                           
	                                        <script type="text/javascript">
	                                          	function updateVip(){
	                                                 location.href="${ pageContext.request.contextPath }/UpdateVipServlet?vipid=${ vip.vipid }";
	                                             }
	                                            function deleteVip(){
	                                                if(confirm("是否删除")){
	                                                	location.href="${ pageContext.request.contextPath }/DeleteVipServlet?vipid=${ vip.vipid }";
	                                                }
	                                            	
	                                            }
	                                          </script>
		                                         
		                                      </td>
		                                  </tr>
								</c:when>
							
							</c:choose>
								
							</table>							
						</div>
					</div>
				</div>
			</div>
			<c:choose>
				<c:when test="${ !empty list }">
					<div class="fg-toolbar ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix">
				<div class="dataTables_paginate fg-buttonset ui-buttonset fg-buttonset-multi ui-buttonset-multi paging_full_numbers">
					
					<a tabindex="0" href="${ pageContext.request.contextPath }/SearchVipServlet?pageNum=1&guest=${ sessionScopeScope.searchGuest }" class="first ui-corner-tl ui-corner-bl fg-button ui-button ui-state-default">首页</a>
					<%-- <a tabindex="0" href="${ pageContext.request.contextPath }/SearchVipServlet?pageNum=${ requestScope.pageNum==1?1:requestScope.pageNum-1 }&guest=${ sessionScopeScope.searchGuest }" class="previous fg-button ui-button ui-state-default">上一页</a> --%>
					
					<c:choose>
			           	<c:when test="${param.pageNum>1}">
			               	<a href="${ pageContext.request.contextPath }/SearchVipServlet?pageNum=${ param.pageNum-1 }&guest=${ sessionScopeScope.searchGuest }" class="previous fg-button ui-button ui-state-default">上一页</a>
			           	</c:when>
		
		          		<c:otherwise>
		             		  	上一页
		           		</c:otherwise>
		      		 </c:choose>


					<c:forEach begin="1" end="${ page }" var="pageNum">
						<a tabindex="0" href="${ pageContext.request.contextPath }/SearchVipServlet?pageNum=${ pageNum }&guest=${ sessionScopeScope.searchGuest }" class="fg-button ui-button ui-state-default">[${ pageNum }]</a>
					</c:forEach>
					<c:choose>
			           	<c:when test="${param.pageNum<requestScope.page}">
			               	<a href="${ pageContext.request.contextPath }/SearchVipServlet?pageNum=${ param.pageNum+1 }&guest=${ sessionScopeScope.searchGuest }" class="previous fg-button ui-button ui-state-default">下一页</a>
			           	</c:when>
		
		          		<c:otherwise>
		             		  	下一页
		           		</c:otherwise>
		      		 </c:choose>
            		<%-- <a tabindex="0" href="${ pageContext.request.contextPath }/SearchVipServlet?pageNum=${ requestScope.pageNum==page?page:requestScope.pageNum+1 }&guest=${ sessionScopeScope.searchGuest }" class="previous fg-button ui-button ui-state-default">下一页</a> --%>
					<a tabindex="0" href="${ pageContext.request.contextPath }/SearchVipServlet?pageNum=${ page }&guest=${ sessionScopeScope.searchGuest }" class="last ui-corner-tr ui-corner-br fg-button ui-button ui-state-default">尾页</a>
			
				</div>
			</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			
			
			
			
		</div>		
        <div class="row-fluid">&nbsp;</div>
        <div class="row-fluid">
            <div id="footer" class="span12">
                2019 &copy; 酒店管理系统
            </div>
        </div>
</body>
</html>