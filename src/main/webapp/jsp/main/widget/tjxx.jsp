<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<security:csrfMetaTags />
<style type="text/css">
</style>
<script type="text/javascript" src="${basepath}skin/plugins/echarts/echarts.min.js"></script>
<script type="text/javascript" src="${basepath}skin/plugins/echarts/shine.js"></script>
<script>
$(function() {
	var dom = document.getElementById("chart");
		var myChart = echarts.init(dom);
		var app = {};
		option = null;
		//app.title = '坐标轴刻度与标签对齐';
		option = {
			color : [ '#3398DB' ],
			tooltip : {
				trigger : 'axis',
				axisPointer : { // 坐标轴指示器，坐标轴触发有效
					type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '15%',
				top:'10%',
				containLabel : true
			},
			xAxis : [ {
				type : 'category',
				data : [ 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun' ],
				axisTick : {
					alignWithLabel : true
				}
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '数量',
				type : 'bar',
				barWidth : '60%',
				data : [ 10, 52, 200, 334, 390, 330, 220 ]
			} ]
		};
		if (option && typeof option === "object") {
			myChart.setOption(option, true);
		}
		loadData(myChart);
	});
function loadData(chart){
	var url = SKY.urlCSRF(basepath+'widget/WidgetController/selectBjfs');
	$.ajax({
		url:url,
		type: "POST",
		dataType:'json',
		success:function(data){
			if(data){
				var xData = new Array();
				var barData=new Array();
				
				$.each(data,function(i,node){
					xData.push(node.NAME);
					barData.push({
						code:node.CODE,
						name:node.NAME,
						value:node.VALUE
					});
				});
				var option = chart.getOption();
				option.xAxis[0].data = xData;
			    option.series[0].data = barData;  
				chart.setOption(option);
				
			}
		}
	});
}
</script>
</head>
<body >
	<div id='chart' style="width:500px;height:250px;">
	</div>
</body>
</html>