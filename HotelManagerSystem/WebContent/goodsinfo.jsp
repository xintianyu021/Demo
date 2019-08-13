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
       	<script src="js/jquery-3.4.1.js"></script>
       	
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
                        <li class="active"><a href="${ pageContext.request.contextPath }/GoodsInfoServlet">商品管理</a></li>
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
				<h1>商品类型管理</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.html" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>
                <a href="#" >
                	<!-- <i class="icon-home"></i> -->
                                                    基本信息管理
                </a>
				<a href="#" class="current">商品管理</a>
			</div>
			<form action="#" method="post" name="searchForm"><!--${ pageContext.request.contextPath }/GoodsInfoServlet?pageNum=1&method=getPageByType-->
			<input type="hidden" name="pagenum" id="pagenum"/>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="control-group">
						<!-- <span class="span3">
							名称：<input id="ename" name="ename" type="text" style="width:65%"/>
						</span> -->
						<span class="span3">
							商品类别筛选：<select id="eflag" name="goodtype" style="width:70%">
									<option value="-1">=全部=</option>
									<c:forEach items="${ typeList }" var="type">
										<c:if test="${ type.goodtype !=goodtype }">
											<option value="${ type.goodtype }">${ type.typename }</option>
										</c:if>
										<c:if test="${ type.goodtype ==goodtype }">
											<option value="${ type.goodtype }" selected="selected" >${ type.typename }</option>
										</c:if>
									</c:forEach>
									
									<!-- <option value="1">活动</option>
                                    <option value="2">撤销</option> -->
								</select>
						</span>
                        <span class="span3">
							<button class="btn btn-info" type="button" id="subbtn" ><!-- onclick="submitForm(1);" -->
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
			</form>
			<hr/>
			<div class="row-fluid">
				<div class="span12" style="padding-left:30px;">
					<button class="btn btn-info" onclick="gotoadd();">
						<i class="icon-white icon-plus"></i>
						新增
					</button>
					<script type="text/javascript">
						function addDept(){
							location.href="addDept.html";
						}
					</script>
				</div>
				<div class="span12">
					<div class="widget-box">
						<div class="widget-content nopadding">
							<table class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>商品号</th>
										<th>商品名称</th>
										<th>商品类型</th>
										<th>单价</th>
										<th>单位</th>
										<th>备注</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${ infoInPage }" var="dateU">
										<tr>
											<%-- <input type="hidden" value="${ dateU.id }"/> --%>
	                                        <td>${ dateU.goodid }</td>
	                                        <td>${ dateU.goodname }</td>
	                                        <td>${ dateU.goodstype.typename }</td>
	                                        <td>${ dateU.price }</td>
	                                        <td>${ dateU.unit }</td>
	                                        <td>${ dateU.notes }</td>
	                                        <td class="tip1">
	                                            	<button class="btn btn-warning" onclick="gotochange()">
	                                              	  <i class="icon-white icon-refresh"></i>
	                                                	修改
	                                        	    </button>
	                                            
	                                            
	                                       	  	    <button class="btn btn-danger" >
	                                              	  <i class="icon-white icon-minus"></i>
	                                                	删除
	                                            	</button>
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
			<a tabindex="0" href="javascript:"+method+"(1)" class="first ui-corner-tl ui-corner-bl fg-button ui-button ui-state-default">首页</a>
			<a tabindex="0" href="#" class="previous fg-button ui-button ui-state-default">上一页</a>
            <c:forEach begin="1" end="${ pages }" var="n">
            	<c:if test="${ n != pageNum }">
            		<c:if test="${ goodtype != null }">
            			<a tabindex="0" href="${ pageContext.request.contextPath }/GoodsInfoServlet?method=getPageByType&pageNum=${ n }&goodtype=${ goodtype }" class="fg-button ui-button ui-state-default">${ n }</a>
            		</c:if>
            		<c:if test="${ goodtype == null }">
            			<a tabindex="0" href="${ pageContext.request.contextPath }/GoodsInfoServlet?method=getPage&pageNum=${ n }" class="fg-button ui-button ui-state-default">${ n }</a>
            		</c:if>
            		
            	</c:if>
            	<c:if test="${ n == pageNum }">
            		<a tabindex="0" class="fg-button ui-button ui-state-default ui-state-disabled">${ n }</a>
            	</c:if>
            </c:forEach>
            
            <!-- <a tabindex="0" href="#" class="fg-button ui-button ui-state-default">1</a>
            <a tabindex="0" class="fg-button ui-button ui-state-default ui-state-disabled">2</a>
            <a tabindex="0" href="#" class="fg-button ui-button ui-state-default">3</a> -->
            <a tabindex="0" href="#" class="previous fg-button ui-button ui-state-default">下一页</a>
			<a tabindex="0" href="#" class="last ui-corner-tr ui-corner-br fg-button ui-button ui-state-default">尾页</a>
			
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
	<script src="js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
	     $(function(){
	     	for(var i in $(".tip1")){
	    		$(".tip1").eq(i).children().eq(1).click(gotodelete);
	    		$(".tip1").eq(i).children().eq(0).click(gotochange);
	    		
	     	}
	     	$("#subbtn").click(function(){
				var gt = $("#eflag").val();
				location = "${ pageContext.request.contextPath }/GoodsInfoServlet?pageNum=1&method=getPageByType&goodtype="+gt;
			});
	     });
	     
	                                            	
		function gotodelete(){
			if(!confirm("是否删除？")){
				return;
			}
			var goodid = $(this).parent().siblings().eq(0).text();
			
			var tail = "";
			if(${ goodtype!=null }){
				tail = "&goodtype=${goodtype}";
			}
			
	        location.href="${ pageContext.request.contextPath }/GoodsInfoServlet?method=delete&goodid="+goodid+"&pageNum=${ pageNum }"+tail;
	   };
	   function gotochange(){
		   var goodid = $(this).parent().siblings().eq(0).text();
		   
		   var tail = "";
			if(${ goodtype!=null }){
				tail = "&goodtype=${goodtype}";
			}
		   
	       location.href="${ pageContext.request.contextPath }/GoodsInfoServlet?method=getUnitInfo&goodid="+goodid+"&pageNum=${ pageNum }"+tail;
	   };
	   function gotoadd(){
		   
		   var tail = "";
			if(${ goodtype!=null }){
				tail = "&goodtype=${goodtype}";
			}
		   
		   location.href="${ pageContext.request.contextPath }/GoodsInfoServlet?pageNum=${ pageNum }&method=getListInfo"+tail;
	   }
	   
	 </script>
</html>