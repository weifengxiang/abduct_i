package org.sky.sound.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sky.sys.model.SysFile;
import org.sky.sys.model.SysUser;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.CommonUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.JsonUtils;
import org.sky.sys.utils.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @ClassName:  SoundController   
 * @Description:TODO(语音上传)   
 * @author: weifx 
 * @date:   2018年5月10日 上午10:37:42   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
@Controller
public class SoundController {
	@RequestMapping(value = "/sound/SoundController/initSoundPage", method =RequestMethod.GET)
	public String initSoundPage(
			HttpServletRequest request, 
			HttpServletResponse response){
		return "jsp/sound/sound";
	}
	@RequestMapping(value = "/sound/SoundController/upload", method =RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public @ResponseBody ResultData upload(
			HttpServletRequest request, 
			HttpServletResponse response){
		ResultData rd= new ResultData();
		try {
			// 创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = (CommonsMultipartResolver)BspUtils.getBean("multipartResolver");
			// 判断 request 是否有文件上传,即多部分请求
			if (multipartResolver.isMultipart(request)) {
				// 转换成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)multipartResolver.resolveMultipart(request);
				Map<String, Object> paramMap = new HashMap();
				List<SysFile> list = new ArrayList<SysFile>();
				// 取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				
				while (iter.hasNext()) {
					// 记录上传过程起始时的时间，用来计算上传时间
					int pre = (int) System.currentTimeMillis();
					// 取得上传文件
					MultipartFile attachfile = multiRequest.getFile(iter.next());
					if (attachfile != null) {
						// 取得当前上传文件的文件名称
						String fileName = attachfile.getOriginalFilename();
						// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
						if (fileName.trim() != "") {
							// 定义上传路径
							String path = ConfUtils.getValue("ATTACHMENT_DIR")
									+ "sound" + File.separator
									+ "123" + ".mp3";
							File localFile = new File(path);
							if (!localFile.getParentFile().exists()) {
								localFile.getParentFile().mkdirs();
							}
							attachfile.transferTo(localFile);
						}
					}
					// 记录上传该文件后的时间
					int finaltime = (int) System.currentTimeMillis();
					System.out.println(finaltime - pre);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd.setCode(ResultData.code_error);
			rd.setName("上传失败<br>" + e.getMessage());
			return rd;
		}
		String mp3Name=request.getParameter("mp3Name");
		String file = request.getParameter("file");
		System.out.println(file);
		rd.setCode("1");
		rd.setName("上传成功");
		return rd;
	}

}
