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
		<div id="header"><h1></h1></div>
		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse">
                    <a href="#">
                        <i class="icon icon-user"></i>
                        <span class="text">
                            张三
                        </span>
                    </a>
                </li>
                <li class="btn btn-inverse">
                    <a href="login.html">
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
                <li class="submenu"  class="active">
                    <a href="#">
                        <i class="icon icon-tag"></i> 
                        <span>基础信息管理</span>
                    </a>
                    <ul>
                        <li><a href="#">客房类型管理</a></li>
                        <li><a href="#">楼层管理</a></li>
                        <li><a href="${ pageContext.request.contextPath }/GoodsTypeServlet">商品类别管理</a></li>
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
                        <i class="icon icon-time"></i> 
                        <span>休假管理</span> 
                        <!--
                        <span class="label">2</span>
                        -->
                    </a>
                    <ul>
                        <li><a href="#">申请休假</a></li>
                        <li><a href="#">审批休假</a></li>
                        <li><a href="#">查看休假记录</a></li>
                        <li><a href="#">查看审批记录</a></li>
                        <li><a href="#">休假记录统计</a></li>
                        <li><a href="#">休假报表</a></li>
                        <li><a href="vtypelist.html">假期类型管理</a></li>
                    </ul>
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
                <li>
                    <a href="joblist.html">
                        <i class="icon icon-briefcase"></i> 
                        <span>职位信息管理</span> 
                    </a>
                </li>
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
				<a href="#" class="current">商品类型管理</a>
			</div>
			<!-- <form action="#" method="post" name="searchForm">
			<input type="hidden" name="pagenum" id="pagenum"/>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="control-group">
						<span class="span3">
							名称：<input id="ename" name="ename" type="text" style="width:65%"/>
						</span>
						<span class="span3">
							状态：<select id="eflag" name="eflag" style="width:70%">
									<option value="-1">=请选择=</option>
									<option value="1">活动</option>
                                    <option value="2">撤销</option>
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
			</form>
			<hr/> -->
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
										<th>类型号</th>
										<th>商品类型</th>
										<th>备注</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${ infoInPage }" var="dateU">
										<tr>
	                                        <td>${ dateU.goodtype }</td>
	                                        <td>${ dateU.typename }</td>
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
            		<a tabindex="0" href="${ pageContext.request.contextPath }/GoodsTypeServlet?method=getPage&pageNum=${ n }" class="fg-button ui-button ui-state-default">${ n }</a>
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
	     });
	                                            	
		function gotodelete(){
			if(!confirm("是否删除？")){
				return;
			}
			var goodtype = $(this).parent().siblings().eq(0).text();
	        location.href="${ pageContext.request.contextPath }/GoodsTypeServlet?method=delete&goodtype="+goodtype+"&pageNum=${ pageNum }";
	   };
	   function gotochange(){
		   var goodtype = $(this).parent().siblings().eq(0).text();
	        location.href="${ pageContext.request.contextPath }/GoodsTypeServlet?method=getUnitInfo&goodtype="+goodtype+"&pageNum=${ pageNum }";
	   };
	   function gotoadd(){
		   location.href="${ pageContext.request.contextPath }/addGoodType.jsp?pageNum=${ pageNum }";
	   }
	   
	 </script>
</html>