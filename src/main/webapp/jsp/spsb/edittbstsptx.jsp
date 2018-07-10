<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/spsb/edittbstsptx.js'></script>
<script type="text/javascript" src="${basepath}skin/js/utils.js"></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#editPageButtonsFt'">
		<form id="addedittbstsptxform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<input type='hidden' name='txnr' id='txnr'/>
			<table style="width:100%">
				  <tr>
					<th style="width:100px"><label>视频编号:</label></th>
					<td><input class="easyui-textbox" name="spbh" id='spbh' style='width:200px'
						data-options="required:true"></input></td>
				  </tr>
			</table>
		</form>
		<form class="easyui-form" method="post" 
			data-options="novalidate:true">
			<table style="width:100%">
				  <tr>
					<th style="width:100px"><label>图片:</label></th>
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
		onclick="submitAddEditTbStSpTxForm()">保存</a> 
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'>关闭</a>
</div>
</body>
</html>