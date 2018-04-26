<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/sjzq/sjzq/detailtbstsjzq.js'></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#detailPageButtonsFt'">
		<form id="detailtbstsjzqform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<table style="width:100%">
				  <tr>
					<th><label>寻亲类别:</label></th>
					<td><input class="easyui-textbox" name="xqlb"
						data-options="required:true"></input></td>
			
					<th><label>寻亲编号:</label></th>
					<td><input class="easyui-textbox" name="xqbh"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>姓名:</label></th>
					<td><input class="easyui-textbox" name="xm"
						data-options="required:true"></input></td>
	
					<th><label>性别:</label></th>
					<td><input class="easyui-textbox" name="xb"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>出生日期:</label></th>
					<td><input class="easyui-textbox" name="csrq"
						data-options="required:true"></input></td>
		
					<th><label>失踪时身高:</label></th>
					<td><input class="easyui-textbox" name="szssg"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>失踪时间:</label></th>
					<td><input class="easyui-textbox" name="szsj"
						data-options="required:true"></input></td>

					<th><label>失踪人所在地:</label></th>
					<td><input class="easyui-textbox" name="szrszd"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>失踪地点:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="szdd" style='width:80%'
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>寻亲者特征描述:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="xqztzms" style='width:80%'
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>其他资料:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="qtzl" style='width:80%'
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>注册时间:</label></th>
					<td><input class="easyui-textbox" name="zcsj"
						data-options="required:true"></input></td>
			
					<th><label>跟进志愿者:</label></th>
					<td><input class="easyui-textbox" name="gjzyz"
						data-options="required:true"></input></td>
				  </tr>
			</table>
		</form>
		<form  id="picForm" method="post" enctype="multipart/form-data">
		 	<table>
			 	<tr>
			 		<td style="width:100%">
				 		<div style="text-align: center;">
							<img id='picPreView1' style="width:150px;height:150px;" src="${basepath}skin/images/timg.jpg"/>
						</div>
					</td>
				</tr>
			</table>
		</form>
</div>
<div id='detailPageButtonsFt' style="text-align:center; padding:2px; top:0px">
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'">关闭</a>
</div>
</body>
</html>