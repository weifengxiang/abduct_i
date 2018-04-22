<%@page import="org.sky.sys.utils.DictUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/ywbl/xsgl/detailtbstxsxx.js'></script>
<script type="text/javascript">
var zjlx = <%=DictUtils.getDictItem("017") %>;
var xsly = <%=DictUtils.getDictItem("XSLY") %>;
var xszt = <%=DictUtils.getDictItem("XSZT") %>;
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#detailPageButtonsFt'">
		<form id="detailtbstxsxxform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<input type='hidden' name='djr' id='djr'/>
			<input type='hidden' name='djdw' id='djdw'/>
			<table style="width:100%">
				  <tr>
					<th><label>线索编号:</label></th>
					<td><input class="easyui-textbox" name="xsbh" id='xsbh' style='width:160px'
						data-options="required:true,
									  readonly:true"></input></td>
		
					<th><label>举报人:</label></th>
					<td><input class="easyui-textbox" name="jbr"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>举报人证件类型:</label></th>
					<td><input class="easyui-combobox" name="zjlx"
						data-options="required:true,
									  valueField:'code',
									  textField:'name',
									  data:zjlx
									 "></input></td>
			
					<th><label>举报人证件号码:</label></th>
					<td><input class="easyui-textbox" name="zjhm"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>举报人电话:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="dh" style='width:300'
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>事发地:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="sfd" style='width:300;height:50'
						data-options="required:true,multiline:true"></input></td>
				  </tr>
				  <tr>
					<th><label>事件详情:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="sjxq" style='width:300;height:50'
						data-options="required:true,multiline:true"></input></td>
				  </tr>
				  <tr>
					<th><label>线索来源:</label></th>
					<td><input class="easyui-combobox" name="xsly"
						data-options="required:true,
									  valueField:'code',
									  textField:'name',
									  data:xsly"></input></td>
			
					<th><label>登记人:</label></th>
					<td><input class="easyui-textbox" name="djrName" id="djrName"
						data-options="required:true,readonly:true"></input></td>
				  </tr>
				  <tr>
					<th><label>登记单位:</label></th>
					<td><input class="easyui-textbox" name="djdwName" id="djdwName"
						data-options="required:true,readonly:true"></input></td>
				 
					<th><label>登记时间:</label></th>
					<td><input class="easyui-datetimebox" name="djsj" id='djsj'
						data-options="required:true,readonly:true"></input></td>
				  </tr>
				  <tr>
					<th><label>状态:</label></th>
					<td><input class="easyui-combobox" name="zt"
						data-options="required:true,
									  valueField:'code',
									  textField:'name',
									  data:xszt"></input></td>
				  </tr>
				  <tr>
					<th><label>备注:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="bz" style='width:300;height:50'
						data-options="required:true,multiline:true"></input></td>
				  </tr>
			</table>
		</form>
		<form  id="picForm" method="post" enctype="multipart/form-data">
		 	<table>
			 	<tr>
			 		<td style="width:33%">
				 		<div style="text-align: center;">
							<img id='picPreView1' style="width:150px;height:150px;" src="${basepath}skin/images/timg.jpg"/>
							<br/>
							<input id='pic1' name='dangerPic' type="file" accept="image/*" name='拍照'/>
						</div>
					</td>
					<td  style="width:33%">
						<div style="text-align: center;">
							<img id='picPreView2' style="width:150px;height:150px;" src="${basepath}skin/images/timg.jpg"/>
							<br/>
							<input id='pic2' name='dangerPic' type="file" accept="image/*" name='拍照'/>
						</div>
					</td>
					<td  style="width:33%">
						<div style="text-align: center;">
							<img id='picPreView3' style="width:150px;height:150px;" src="${basepath}skin/images/timg.jpg"/>
							<br/>
							<input id='pic3' name='dangerPic' type="file" accept="image/*" name='拍照'/>
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