<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<security:csrfMetaTags />
<style type="text/css">
</style>
<script type="text/javascript"
	src="${basepath}skin/plugins/echarts/echarts.min.js"></script>
<script type="text/javascript"
	src="${basepath}skin/plugins/echarts/shine.js"></script>

<script>
//var orgcode =  '';
// 地图统计构建图形
var chart = null;
function initMap() {
	$.getJSON(
		basepath + "/skin/plugins/echarts/map/js/370100.json",
		function(data) {
			chart = echarts.init($('#map')[0]);
			echarts.registerMap('jinan', data);
			var option = {
				tooltip : {
					trigger : 'item'
				},
				dataRange : {
					min : 800,
					max : 50000,
					text : [ 'High', 'Low' ],
					realtime : false,
					calculable : true,
					color : [ '#254d8c', '#32c3ff', '#32e4ff', '#4477c4',
							'#329cff' ],
					show : false
				},
				series : [ {
					type : 'map',
					map : 'jinan',
					layoutCenter : [ '50%', '50%' ],
					layoutSize :250,
					itemStyle : {
						normal : {
							borderWidth : 1, //区域边框宽度
							borderColor : '#12446d', //区域边框颜色
							label : {
								show : true,
								color : '#fff'
							},
							areaColor : [ '#2c74d3' ]
						},
						emphasis : {
							label : {
								show : true,
								color : '#fff'
							},
							areaColor : '#32fdff'
						}
					},
					data : [ {
						name : '历下区',
						value : 48000
					}, {
						name : '历城区',
						value : 20000
					} ]
				} ]
			};
			chart.setOption(option);
			
			//鼠标点击事件
			/**
			chart.on('click', function(params) {
				var cityName = params.name;
				var cityValue = params.value;
				alert(cityName + "***" + cityValue);
			});**/
		}
	);
}
function loadData(){
	var url = SKY.urlCSRF(basepath+'widget/WidgetController/selectAjArea');
	$.ajax({
		url:url,
		type: "POST",
		dataType:'json',
		success:function(data){
			if(data){
				var areaData=new Array();
				$.each(data,function(i,node){
					areaData.push({
						code:node.CODE,
						name:node.NAME,
						value:node.NUM
					});
				});
				//alert(JSON.stringify(areaData));
				var option = chart.getOption();
			    option.series[0].data = areaData;  
				chart.setOption(option);
				//轮播展示
				var currentIndex = -1;
				setInterval(function() {
					var dataLen = option.series[0].data.length;
					// 取消之前高亮的图形
					chart.dispatchAction({
						type : 'downplay',
						seriesIndex : 0, //表示series中的第几个data数据循环展示
						dataIndex : currentIndex
					});
					currentIndex = (currentIndex + 1) % dataLen; //+1表示每次跳转一个
					// 高亮当前图形
					chart.dispatchAction({
						type : 'highlight',
						seriesIndex : 0,
						dataIndex : currentIndex
					});
					// 显示 tooltip
					chart.dispatchAction({
						type : 'showTip',
						seriesIndex : 0,
						dataIndex : currentIndex
					});
				}, 1000);
			}
		}
	});
}
$(function() {
	initMap();
	loadData();
});
</script>
</head>
<body>
	<div id='map' style="width: 500px;height:100%;"></div>
</body>
</html>