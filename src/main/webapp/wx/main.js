/**
 * 微信登录主页面
 */
var mainReg=(function(){
	var _obj=new Object();
	//旋转角度
	var _currentDeg = 0; 
	//初始化登记页面
	_obj.initRegPage=function(){
		$('#formSubmitBtn').on('click',function(){
			submitForm();
		});
		$('#formResetBtn').on('click',function(){
			resetForm();
		});
		$("#sfsj").datetimePicker({title:"选择日期",
								   format: 'yyyy-mm-dd hh:ii:ss',
								   autoclose: true,
								   minView: 0,
								   minuteStep:1});
		$("#dangerPic").uploadPreview({ Img: 'dangerPicPreView', Width: 210, Height: 210 });
		$('#dangerPicPreView').on('click',function(){           
			_currentDeg = (_currentDeg+90)%360;
            this.style.transform = 'rotate('+_currentDeg+'deg)';
		});
	};
	
	var submitForm=function(){
		var sfsj = $("input[name=sfsj]").val();
		if(!sfsj){
			$.toast("保存失败:请填写事发时间", "forbidden");
			return;
		}else{
			if(sfsj.length==16){
				$("input[name=sfsj]").val(sfsj+":00");
			}
		}
		var sfd = $("textarea[name=sfd]").val();
		if(!sfd){
			$.toast("保存失败:请填写事发地", "forbidden");
			return;
		}
		var jbr = $("input[name=jbr]").val();
		if(!jbr){
			$.toast("保存失败:请填写联系人", "forbidden");
			return;
		}
		var dh = $("input[name=dh]").val();
		if(!dh){
			$.toast("保存失败:请填写联系电话", "forbidden");
			return;
		}
		if($("#dangerPicPreView").attr("src").indexOf("skin/images/timg.jpg")!=-1){
			$.toast("保存失败:请选择照片或拍照", "forbidden");
			return;
		}
		$.showLoading("正在保存数据,请稍等...");
		var options = { 
			       beforeSubmit:function(data){
			       },   
			       data:{
			    	   dangerPicData:compress($('#dangerPicPreView')[0]),
			    	   currentDeg:_currentDeg
			       },
			       success:function(data){
			    	   $.hideLoading();
		    		   if(data.code=='1'){
		    			   $.confirm("照片已上传成功");
		    			   resetForm();
		    		   }     	 
			       },
			       error:function(e){
			    	   $.hideLoading();
			    	   $.toast("保存失败:"+JSON.stringify(e), "forbidden");
			       },
			       url:SKY.urlCSRF(basepath+'wx/xsxx/addXsxx'), 
			       type:'post',   
			       dataType:'json',   
			       timeout:-1    
				};  
				$('#xsxxform').ajaxSubmit(options);
	};
	var resetForm=function(){
		$('#xsxxform').resetForm();
		$('#dangerCheckPic').resetForm();
		$("#dangerPicPreView").attr("src",basepath+"skin/images/timg.jpg");
	};
	//原始大小太大
	var uploadImg=function (param){
		$.showLoading("正在上传图片,请稍等...");
		var options = { 
		    data:{
	    	   "data":function(){
	    		   return JSON.stringify(param);
	    	   }
	        },   
	        beforeSubmit:function(data){
	        },   
	        success:function(data){
	        	$.hideLoading();
	        	$.confirm("照片已上传成功,是否继续添加?", "继续添加?", 
	        			  function() {
	        				//continueAdd();
	              		  }, 
	              		  function() {
	              			//取消操作
	              		  }
	              		  );
	        },
	        error:function(e){
	        	$.hideLoading();
	        	$.toast('上传失败!'+JSON.stringify(e), "forbidden");
	        },
	        url:SKY.urlCSRF(basepath+'sys/SysFile/upLoadFiles'), 
	        type:'post',   
	        dataType:'json',   
	        timeout:-1    
		};  
		$('#dangerCheckPic').ajaxSubmit(options); 
	};
	var compress = function (img) {
         var width = img.width;    //图片resize宽度
         var height = img.height;
         quality = 0.7,  //图像质量
         canvas = document.createElement("canvas"),
         drawer = canvas.getContext("2d");
         if(width>height){
        	 canvas.width = 960;
        	 canvas.height = height*(960/width);
         }else{
        	 canvas.height = 960;
        	 canvas.width = width*(960/height);
         }
		 drawer.drawImage(img, 0, 0, canvas.width, canvas.height);
		 var cropStr = canvas.toDataURL("image/jpeg", quality);

        return cropStr;
    };
	return _obj;
}());
/*
*名称:图片上传本地预览插件 v1.1
*作者:周祥
*时间:2013年11月26日
*介绍:基于JQUERY扩展,图片上传预览插件 目前兼容浏览器(IE 谷歌 火狐) 不支持safari
*插件网站:http://keleyi.com/keleyi/phtml/image/16.htm
*参数说明: Img:图片ID;Width:预览宽度;Height:预览高度;ImgType:支持文件类型;Callback:选择文件显示图片后回调方法;
*使用方法: 
<div>
<img id="ImgPr" width="120" height="120" /></div>
<input type="file" id="up" />
把需要进行预览的IMG标签外 套一个DIV 然后给上传控件ID给予uploadPreview事件
$("#up").uploadPreview({ Img: "ImgPr", Width: 120, Height: 120, ImgType: ["gif", "jpeg", "jpg", "bmp", "png"], Callback: function () { }});
*/
jQuery.fn.extend({
    uploadPreview: function (opts) {
        var _self = this,
            _this = $(this);
        opts = jQuery.extend({
            Img: "ImgPr",
            Width: 100,
            Height: 100,
            ImgType: ["gif", "jpeg", "jpg", "bmp", "png"],
            Callback: function () {}
        }, opts || {});
        _self.getObjectURL = function (file) {
            var url = null;
            if (window.createObjectURL != undefined) {
                url = window.createObjectURL(file)
            } else if (window.URL != undefined) {
                url = window.URL.createObjectURL(file)
            } else if (window.webkitURL != undefined) {
                url = window.webkitURL.createObjectURL(file)
            }
            return url
        };
        _this.change(function () {
            if (this.value) {
                if (!RegExp("\.(" + opts.ImgType.join("|") + ")$", "i").test(this.value.toLowerCase())) {
                    alert("选择文件错误,图片类型必须是" + opts.ImgType.join("，") + "中的一种");
                    this.value = "";
                    return false
                }
                if ($.browser.msie) {
                    try {
                        $("#" + opts.Img).attr('src', _self.getObjectURL(this.files[0]))
                    } catch (e) {
                        var src = "";
                        var obj = $("#" + opts.Img);
                        var div = obj.parent("div")[0];
                        _self.select();
                        if (top != self) {
                            window.parent.document.body.focus()
                        } else {
                            _self.blur()
                        }
                        src = document.selection.createRange().text;
                        document.selection.empty();
                        obj.hide();
                        obj.parent("div").css({
                            'filter': 'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)',
                            'width': opts.Width + 'px',
                            'height': opts.Height + 'px'
                        });
                        div.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src
                    }
                } else {
                    $("#" + opts.Img).attr('src', _self.getObjectURL(this.files[0]))
                }
                opts.Callback()
            }
        })
    }
});