<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>企业人事管理平台</title>
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
        <script type="text/javascript">
        	$(document).ready(function (){
        		$("form input").blur(function (){
        			validateInput(this);
        		});
        		
        		/* $("form textarea").blur(function (){
        			validateInput(this);
        		}); */
        		
        		$("form").submit(function (){
        			var f = true;

        			var a = $("form input"); 
        			
        			for(var i = 0; i < a.size(); i++){
        				var t = validateInput(a.get(i));
        				f = f && t;
        			}
        			return f;
        		});
        		/* $("#userid").bind("input", function (){
        			var userid = $(this).val();
        			if(userid == 1045){
        				$("#span1").html("李建国");
        			}else{
        				$("#span1").html("员工姓名");
        			}
        		}) */
        	});

        	function validateInput(obj){
        		var v = $(obj).val();
    			if(v == ""){
    				$(obj).parent().parent().removeClass("success");
					$(obj).parent().parent().addClass("error");
					return false;
    			}else{
    				$(obj).parent().parent().removeClass("error");
					$(obj).parent().parent().addClass("success");
					return true;
    			}
        	}
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
				<h1>修改商品类别</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.html" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>
				<a href="#">基础信息管理</a>
				<a href="${ pageContext.request.contextPath }/GoodsTypeServlet" >商品类别管理</a>
				<a href="#" class="current">修改商品类别</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
						<div class="span12">
							<div class="widget-box">
								<div class="widget-title">
									<span class="icon">
										<i class="icon-align-justify"></i>									
									</span>
									<h5>部门信息</h5>
								</div>
								<!--<th>商品号</th>
									<th>商品名称</th>
									<th>商品类型</th>
									<th>单价</th>
									<th>单位</th>
									<th>备注</th>
									<th>操作</th> -->
								<div class="widget-content nopadding">
									<form id="eform" action="${ pageContext.request.contextPath }/GoodsInfoServlet" class="form-horizontal" method="post" >
	                                    <div id="info1" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	商品号:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="goodid" readonly="readonly" id="goodid" value="${ goodsInfo.goodid }" />
	                                        </div>
	                                    </div>
	                                    <div id="info2" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	商品名称:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="goodname" id="goodname" value="${ goodsInfo.goodname }" />
	                                            <span id="span1"></span>
	                                        </div>
	                                    </div>
	                                    <div id="info3" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	商品类型:
	                                        </label>
	                                        <div class="controls">
	                                            <select id="goodtype1" name="goodtype1">
	                                            	<option value="-1">请选择</option>
	                                            	<c:forEach items="${ typeList }" var="type">
	                                            		<c:if test="${ goodsInfo.goodstype.goodtype != type.goodtype }">
	                                            			<option value="${ type.goodtype }" >${ type.typename }</option>
	                                            		</c:if>
	                                            		<c:if test="${ goodsInfo.goodstype.goodtype == type.goodtype }">
	                                            			<option value="${ type.goodtype }" selected="selected" >${ type.typename }</option>
	                                            		</c:if>
	                                            	</c:forEach>
	                                            	
	                                            	
	                                            	<!-- <option value="100">研发中心</option>
	                                            	<option value="102">研发二部</option> -->
	                                            </select>
	                                        </div>
	                                    </div>
	                                    <div id="info4" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	单价:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="price" id="price" value="${ goodsInfo.price }" />
	                                            <span id="span2"></span>
	                                        </div>
	                                    </div>
	                                    <div id="info5" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	单位:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="unit" id="unit" value="${ goodsInfo.unit }" />
	                                            <span id="span1"></span>
	                                        </div>
	                                    </div>
	                                    <div id="info6" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	备注:
	                                        </label>
	                                        <div class="controls">
	                                            <textarea rows="8" cols="20" name="notes" >${ goodsInfo.notes }</textarea>
	                                            <input type="hidden" name="pageNum" value="${ param.pageNum }" />
	                                            <input type="hidden" name="method"  value="update" />
	                                            <c:if test="${ param.goodtype != null }">
	                                            	<input type="hidden" name="goodtype" value="${ param.goodtype }"/>
	                                            </c:if>
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
                2016 &copy; 企业人事管理平台
            </div>
        </div>
		
	</body>
</html>