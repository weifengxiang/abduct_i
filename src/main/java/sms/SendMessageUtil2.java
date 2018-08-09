package sms;
//SendMessage.java - Sample application.

import org.sky.sys.utils.ConfUtils;
import org.sky.sys.utils.schedule.StreamGobbler;

//短信发送测试程序
//This application shows you the basic procedure for sending messages.
//You will find how to send synchronous and asynchronous messages.
//
//For asynchronous dispatch, the example application sets a callback
//notification, to see what's happened with messages.

import org.smslib.AGateway;
import org.smslib.AGateway.Protocols;
import org.smslib.IOutboundMessageNotification;
import org.smslib.Library;
import org.smslib.Message.MessageEncodings;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

public class SendMessageUtil2 {
	public void doIt(String tel,String content) throws Exception {
		String path=ConfUtils.getValue("SEND_MSG_EXE");
		String[] cmd = {path,"3",tel,"\""+content+"\""};
		ProcessBuilder pb = new ProcessBuilder(cmd);
		Process proc = pb.start();
		//如果不读取返回值,exe会卡主
		StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "Error");            
        StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "Output");
        errorGobbler.start();
        outputGobbler.start();
        //调用waitfor会等待执行完成后再执行下一个
        proc.waitFor();
	}
	public static void main(String args[]) {
		SendMessageUtil app = new SendMessageUtil();
		try {
			app.doIt("15253182880","123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
