<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
        <script src="js/addemp.js"></script>	            
	</head>	
	<body>
		<div id="header"><h1>酒店管理系统</h1></div>
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
				<h1>新增会员</h1>
			</div>
			<div id="breadcrumb">
				<a href="main.html" class="tip-bottom">
                	<i class="icon-home"></i>
                                                    首页
                </a>
                
				<a href="emplist.html">会员信息</a>
				<a href="#" class="current">新增会员</a>
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
									<form id="eform" action="AddVipServlet" class="form-horizontal" method="post" />
	                                    <div id="info1" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	会员编号:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="vipid" id="vipid" />
	                                        </div>
	                                    </div>
	                                    <div id="info2" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	会员姓名:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="guest" id="guest" />
	                                        </div>
	                                    </div>
	                                    <div id="info3" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	身份证号:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="idcard" id="idcard" />
	                                        </div>
	                                    </div>
	                                    <div id="info4" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	性别:
	                                        </label>
	                                        <div class="controls">
	                                            <select id="gender" name="gender">
	                                            	
	                                            	<option value="男">男</option>
	                                            	<option value="女">女</option>
	                                            </select>
	                                        </div>
	                                    </div>
	                                    <div id="info5" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	密码:
	                                        </label>
	                                         <div class="controls">
	                                            <input type="text" name="password" id="password" />
	                                        </div>
	                                    </div>
	                                    <div id="info6" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	电话:
	                                        </label>
	                                         <div class="controls">
	                                            <input type="text" name="tel" id="tel" />
	                                        </div>
	                                    </div>
	                                    <div id="info7" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	地址:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="address" id="address" />
	                                        </div>
	                                    </div>
	                                    <div id="info8" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	邮箱:
	                                        </label>
	                                        <div class="controls">
	                                            <input type="text" name="email" id="email" />
	                                        </div>
	                                    </div>
	                                    <div id="info9" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	积分:
	                                        </label>
	                                         <div class="controls">
	                                            <input type="text" name="point" id="point" />
	                                        </div>
	                                    </div>
	                                    <div id="info10" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	会员等级:
	                                        </label>
	                                        <div class="controls">
	                                            <select id="grade" name="grade">
	                                            	
	                                            	<option value="普通">普通</option>
                                                    <option value="VIP">VIP</option>
	                                            </select>
	                                        </div>
	                                    </div>
                                        <div id="info11" class="control-group">
	                                        <label class="control-label">
	                                        	<span style="color: red">*</span>
	                                        	备注:
	                                        </label>
	                                         <div class="controls">
	                                            <input type="text" name="notes" id="notes" />
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
                2016 &copy; 企业人事管理平台
            </div>
        </div>
</body>
</html>