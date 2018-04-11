<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/ywbl/ajdj/detailtbstajdjxx.js'></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#detailPageButtonsFt'">
		<form id="detailtbstajdjxxform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<table style="width:100%">
				  <tr>
					<th><label>案件编号:</label></th>
					<td><input class="easyui-textbox" name="ajbh"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>报警时间:</label></th>
					<td><input class="easyui-textbox" name="bjsj"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>所属分局:</label></th>
					<td><input class="easyui-textbox" name="ssfj"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>联系电话:</label></th>
					<td><input class="easyui-textbox" name="lxdh"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>报警方式:</label></th>
					<td><input class="easyui-textbox" name="bjfs"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>报警类别:</label></th>
					<td><input class="easyui-textbox" name="bjlb"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>报警类型:</label></th>
					<td><input class="easyui-textbox" name="bjlx"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>报警细类:</label></th>
					<td><input class="easyui-textbox" name="bjxl"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>事发地址:</label></th>
					<td><input class="easyui-textbox" name="sfdz"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>来话类别:</label></th>
					<td><input class="easyui-textbox" name="lhlb"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>报警人:</label></th>
					<td><input class="easyui-textbox" name="bjr"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>事件详情:</label></th>
					<td><input class="easyui-textbox" name="sjxq"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>辖区单位:</label></th>
					<td><input class="easyui-textbox" name="xqdw"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>行政区划:</label></th>
					<td><input class="easyui-textbox" name="xzqh"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>出警人:</label></th>
					<td><input class="easyui-textbox" name="cjr"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>到场时间:</label></th>
					<td><input class="easyui-textbox" name="dcsj"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>到场情况:</label></th>
					<td><input class="easyui-textbox" name="dcqk"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>反馈内容:</label></th>
					<td><input class="easyui-textbox" name="fknr"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>处理结果:</label></th>
					<td><input class="easyui-textbox" name="cljg"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>事件状态(-1:无效;0:登记;1:分流:2:受理;3:办结;4:结案):</label></th>
					<td><input class="easyui-textbox" name="sjzt"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>警务区:</label></th>
					<td><input class="easyui-textbox" name="jwq"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>案发地址类别:</label></th>
					<td><input class="easyui-textbox" name="afdzlb"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>事件发生地址:</label></th>
					<td><input class="easyui-textbox" name="sjfsdz"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>当前单位:</label></th>
					<td><input class="easyui-textbox" name="dqdw"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>案件来源:</label></th>
					<td><input class="easyui-textbox" name="ajly"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>登记人:</label></th>
					<td><input class="easyui-textbox" name="djr"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>登记单位:</label></th>
					<td><input class="easyui-textbox" name="djdw"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>登记时间:</label></th>
					<td><input class="easyui-textbox" name="djsj"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>线索编号:</label></th>
					<td><input class="easyui-textbox" name="xsbh"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>备注:</label></th>
					<td><input class="easyui-textbox" name="bz"
						data-options="required:true"></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='detailPageButtonsFt' style="text-align:center; padding:2px; top:0px">
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'">关闭</a>
</div>
</body>
</html>