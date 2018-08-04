<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/txbk/edittbsttxbk.js'></script>
<script type="text/javascript" src="${basepath}skin/js/utils.js"></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
var txbh ='${txbh}';
$(function() {
	
});
</script> 
<style type="text/css">
th{
	width:100px
}
</style>
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#editPageButtonsFt'">
		<form id="addedittbsttxbkform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<input type='hidden' name='bkk' id='bkk'/>
			<table style="width:100%">
				  <tr>
					<th><label>视频编号:</label></th>
					<td><input class="easyui-textbox" name="txbh" id='txbh' style='width:300px'
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>视频名称:</label></th>
					<td><input class="easyui-textbox" name="txmc" style='width:300px'
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>布控库:</label></th>
					<td>
						<input type='checkbox' name='bkk1' value='10' checked>案件库</input>
						<input type='checkbox' name='bkk2' value='01' checked>线索库</input>
					</td>
				  </tr>
				  <tr>
					<th><label>备注:</label></th>
					<td><input class="easyui-textbox" name="bz"  
						style='width:300;height:60'
						data-options="multiline:true"></input></td>
				  </tr>
			</table>
		</form>
		<form class="easyui-form" method="post" 
			data-options="novalidate:true">
			<table style="width:100%">
				  <tr>
					<th><label>图片:</label></th>
					<td>
						<div style="text-align: center;width:200px">
							<img id='picPreView' style="width:150px;height:150px;" src="${basepath}skin/images/timg.jpg"/>
							<br/>
							<input id='pic' name='pic' type="file" accept="image/*" name='选择照片' multiple="multiple"/>
						</div>
					</td>
				  </tr>
			</table>
		</form>
</div>
<div id='editPageButtonsFt' style="text-align:center; padding:0px; top:0px">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-save'
		onclick="submitAddEditTbStTxbkForm()">保存</a> 
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'>关闭</a>
</div>
</body>
</html>