package org.sky.sys.utils.schedule;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.sky.msg.client.TbStMsgMapper;
import org.sky.msg.model.TbStMsg;
import org.sky.msg.model.TbStMsgExample;
import org.sky.sys.utils.BspUtils;
import org.sky.sys.utils.ConfUtils;
import org.sky.utils.Base64Img;
import org.sky.ywbl.client.TbStTxxxMapper;
import org.sky.ywbl.model.TbStTxxx;
import org.sky.ywbl.model.TbStTxxxExample;

import sms.SendMessageUtil;
import sms.SendMessageUtil2;
/**
 * 
 * @ClassName:  SendMsgJob   
 * @Description:TODO(创建案件失踪人口图像库)   
 * @author: weifx 
 * @date:   2018年5月5日 下午1:06:14   
 * @version V1.0    
 * @Copyright: 2018 XXX. All rights reserved.
 */
public class SendMsgJob implements Job {
	private final Logger logger=Logger.getLogger(CreateAjTxxxFilesJob.class);
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		TbStMsgMapper msgMapper = BspUtils.getBean(TbStMsgMapper.class);
		TbStMsgExample eam = new TbStMsgExample();
		eam.createCriteria().andStateEqualTo("0");
		List<TbStMsg> list = msgMapper.selectByExample(eam);
		for(TbStMsg msg:list) {
			SendMessageUtil2 app = new SendMessageUtil2();
			try {
				app.doIt(msg.getReceiverTel(),msg.getContent());
			} catch (Exception e) {
				e.printStackTrace();
				msg.setState("-1");
			}catch(IllegalAccessError e) {
				e.printStackTrace();
				msg.setState("-1");
			}
			msg.setState("1");
			msgMapper.updateByPrimaryKey(msg);
		}
	}

}
