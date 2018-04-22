/**
 * 案件信息Main页面初始化方法
 * @param paramOpts
 * @returns
 */
function initDjxxMain(){
	var url=basepath+"ywbl/TbStAjdjxx/getTbStAjdjxxByAjbh?ajbh="+ajbh;
	$('#detailtbstajdjxxform').form('options').onLoadSuccess=function(data){
		onAjxxLoadSuccess(data);
	};
	$('#detailtbstajdjxxform').form('load',SKY.urlCSRF(url));
}
/**
 * 案件信息加载成功监听事件
 * @param data
 * @returns
 */
function onAjxxLoadSuccess(djxx){
	viewTxxx(djxx);
	createBLXX(djxx);
	createJASHXX(djxx);
}
/**
 * 创建办理信息grid
 * @returns
 */
function createBLXX(djxx){
	$('#mainDetailTab').tabs('add',{
		title: '办理信息',
		selected:false,
		content:'<table id="blxxdg" style="width: 100%; height: 100%"></table>'
	});
	$('#blxxdg').datagrid({    
	    url:SKY.urlCSRF(basepath+'/ywbl/TbStAjblxx/getTbStAjblxxByPage'),
	    pagination:true,
		rownumbers: true,
		checkbox:true,
		nowrap:false,
		singleSelect:true,
		selectOnCheck:false,
		checkOnSelect:false,
		queryParams: {
			page:1,
			rows:10,
			filter:function(){
				var ft=new HashMap();
				ft.put("ajbh@=",djxx.ajbh);
				return ft.getJSON();
			},
			sortfield:" create_time desc"
		},
		onLoadSuccess : function () {
    		$(this).datagrid('fixRownumber');
    		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
		},
	    columns:[[    
	        {field:'bljg',title:'办理结果',width:100},    
	        {field:'blyj',title:'办理意见',width:150}, 
	        {field:'blsj',title:'办理时间',width:150},
	        {field:'blr',title:'办理人',width:360},
	        {field:'bldw',title:'办理单位',width:100}
	    ]]    
	}); 
}
/**
 * 结案审核信息
 * @param djxx
 * @returns
 */
function createJASHXX(djxx){
	$('#mainDetailTab').tabs('add',{
		title: '结案审核信息',
		selected:false,
		content:'<table id="jashxxdg" style="width: 100%; height: 100%"></table>'
	});
	$('#jashxxdg').datagrid({    
	    url:SKY.urlCSRF(basepath+'/ywbl/TbStAjjashxx/getTbStAjjashxxByPage'),
	    pagination:true,
		rownumbers: true,
		checkbox:true,
		nowrap:false,
		singleSelect:true,
		selectOnCheck:false,
		checkOnSelect:false,
		queryParams: {
			page:1,
			rows:10,
			filter:function(){
				var ft=new HashMap();
				ft.put("ajbh@=",djxx.ajbh);
				return ft.getJSON();
			},
			sortfield:" create_time desc"
		},
		onLoadSuccess : function () {
    		$(this).datagrid('fixRownumber');
    		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
		},
	    columns:[[    
	        {field:'shjg',title:'审核结果',width:100},    
	        {field:'shyj',title:'审核意见',width:150}, 
	        {field:'shsj',title:'审核时间',width:150},
	        {field:'shenhr',title:'审核人',width:360},
	        {field:'shdw',title:'审核单位',width:100}
	    ]]    
	}); 
}
/**
 * 显示图像信息
 * @returns
 */
function viewTxxx(data){
	var url = basepath+'ywbl/com/viewTxxx/AJXX/'+data.ajbh;
	$.ajax({
		url:SKY.urlCSRF(url),
		type: "POST",
		dataType:'json',
		success:function(data){
			if(!data){
				return;
			}
			$.each(data,function(i,node){
				//$('#pic'+(i+1)).val(node.txmc);
				$('#picPreView'+(i+1)).attr('src',node.txnr);
			});
		}
	});
}