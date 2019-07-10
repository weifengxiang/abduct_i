package org.sky.sys.utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.SocketException;
 
 
public class FTPUtils {  
    
    public static String ftpHost;  
    public static int port;  
    public static String userName;  
    public static String passWord;  
    public static String ftpEncode="UTF-8"; 
    public static int defaultTimeout=30000; 
 
    public FTPUtils(String ftpHost,int port,String userName,String passWord) {
    	this.ftpHost = ftpHost;
    	this.port = port;
    	this.userName = userName;
    	this.passWord = passWord;
    }
	/** 
     * 上传ftp 
     * @param path  文件存入FTP 的路径
     * @param localFile  文件在本地的路径
     * @param fileNewName 文件上传FTP后名字
     * @return 成功返回true   失败返回false
     * @throws SocketException 
     * @throws IOException 
     */  
    public String uploadFile(String path ,File localFile,String fileNewName) {  
        boolean flag=true;  
        //获得文件流  
        FileInputStream is;
		try {
			is = new FileInputStream(localFile);
			  //保存至Ftp  
	        FTPClient ftpClient = new FTPClient();// ftpHost为FTP服务器的IP地址，port为FTP服务器的登陆端口,ftpHost为String型,port为int型。  
	        ftpClient.setControlEncoding(ftpEncode); // 中文支持  
	        ftpClient.connect(ftpHost);  
	        ftpClient.login(userName, passWord);// userName、passWord分别为FTP服务器的登陆用户名和密码  
	        ftpClient.setDefaultPort(port);  
	        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);  
	        ftpClient.enterLocalPassiveMode(); // 用被动模式传输,解决linux服务长时间等待，导致超时问题  
	        ftpClient.setDefaultTimeout(defaultTimeout);// 设置默认超时时间  
	        ftpClient.setBufferSize(1024*1024);//设置缓存区，默认缓冲区大小是1024，也就是1K  
	        //切换目录，目录不存在创建目录  
	        boolean chagenDirFlag=ftpClient.changeWorkingDirectory(path);  
	        if(chagenDirFlag==false){  
	            ftpClient.makeDirectory(path);  
	            ftpClient.changeWorkingDirectory(path);  
	        }  
	        //上传至Ftp  
	        flag=ftpClient.storeFile(fileNewName, is);  
	        is.close();  
	        //关闭连接  
	        ftpClient.logout();  
	        ftpClient.disconnect();  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return "FileNotFound";
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			return "SocketNotSuccess";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "SocketNotSuccess";
		}  
        return "SUCCESS";  
    }  
      
    /** 
     * 下载FTP 
     * @param ftpName  ftp上的文件名 
     * @param localFile  保存的本地地址 
     * @param path ftp上的文件路径
     *  @return 成功返回true   失败返回false
     * @throws SocketException 
     * @throws IOException 
     */  
    public String  downloadFileq(String path,String ftpName,File localFile) {  
        boolean flag=true;  
        //保存至Ftp  
        FTPClient ftpClient = new FTPClient();// ftpHost为FTP服务器的IP地址，port为FTP服务器的登陆端口,ftpHost为String型,port为int型。  
        ftpClient.setControlEncoding(ftpEncode); // 中文支持  
        try {
			ftpClient.connect(ftpHost);
			 ftpClient.login(userName, passWord);// userName、passWord分别为FTP服务器的登陆用户名和密码  
		        ftpClient.setDefaultPort(port);  
		        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);  
		        ftpClient.enterLocalPassiveMode(); // 用被动模式传输,解决linux服务长时间等待，导致超时问题  
		        ftpClient.setDefaultTimeout(defaultTimeout);// 设置默认超时时间  
		        ftpClient.setBufferSize(1024*1024);//设置缓存区，默认缓冲区大小是1024，也就是1K  
		        //切换目录，目录不存在创建目录  
		        ftpClient.changeWorkingDirectory(path);  
		        OutputStream os = new FileOutputStream(localFile);  
		        flag = ftpClient.retrieveFile(ftpName, os);  
		        //关闭流
		        os.flush();  
		        os.close();  
		        //关闭连接  
		        ftpClient.logout();  
		        ftpClient.disconnect();  
		        System.out.println("FTP文件名——"+ftpName);  
		} catch (SocketException e) {
			return "SocketNotSuccess";
		} catch (IOException e) {
			return "SocketNotSuccess";
		}  
        return "SUCCESS"; 
    }  
      
    /** 
     * 删除FTP 
     * @param ftpName  ftp上的文件名 
     *  @param path  ftp上的文件路径 
     *  @return 成功返回true   失败返回false
     * @throws SocketException 
     * @throws IOException 
     */  
    public String deleteFile(String path,String ftpName) {  
        boolean flag=true;  
        //保存至Ftp  
        FTPClient ftpClient = new FTPClient();// ftpHost为FTP服务器的IP地址，port为FTP服务器的登陆端口,ftpHost为String型,port为int型。  
        ftpClient.setControlEncoding(ftpEncode); // 中文支持  
        try {
			ftpClient.connect(ftpHost);
			 ftpClient.login(userName, passWord);// userName、passWord分别为FTP服务器的登陆用户名和密码  
		        ftpClient.setDefaultPort(port);  
		        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);  
		        ftpClient.enterLocalPassiveMode(); // 用被动模式传输,解决linux服务长时间等待，导致超时问题  
		        ftpClient.setDefaultTimeout(defaultTimeout);// 设置默认超时时间  
		        //切换目录，目录不存在创建目录  
		        ftpClient.changeWorkingDirectory(path);  
		        flag = ftpClient.deleteFile(ftpName);  
		        //关闭连接  
		        ftpClient.logout();  
		        ftpClient.disconnect();  
		} catch (SocketException e) {
			return "SocketNotSuccess";
		} catch (IOException e) {
			return "SocketNotSuccess";
		}  
        return "SUCCESS"; 
    }  
  
 
	
	/**
    * byte[] 转 file 
    * 
    * @param bytes
    * @param path
    */
   public static void byteToFile(InputStream inStream, String path)
   {
       try
       {
           // 输出流InputStream inStream
			File localFile = new File(path);
			if(!localFile.exists()){
				if(!localFile.getParentFile().exists()) {
					localFile.getParentFile().mkdir();
				}
				localFile.createNewFile();
			}
			OutputStream outStream = new FileOutputStream(localFile);
			byte[] b = new byte[1024];
			int len = -1;
			while((len=inStream.read(b)) != -1){
				outStream.write(b, 0, len);
			}
			outStream.flush();
           inStream.close();
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
   }
    
    
    public static void main(String[] args) { 
        /** 
        FTPUtils util = new FTPUtils();  
        //上传测试  
        File localFile=new File("D:/testFTP/20170915.csv");  
        String path = "/root/update/";
        String flag=util.uploadFile(path,localFile, "20170915.csv");  
        System.out.println(flag +"   判断上传结果");  
        **/
        /**  
        //下载测试  
        File localFile=new File("D:/testFTP/15.csv");  
        localFile.createNewFile();  
        String flag=util.downloadFileq("/root/update/","20170915.csv",localFile);              
        System.out.println(flag +"   判断下载结果");  
          
        //删除测试  
        String flag=util.deleteFile("/root/update/","1.jpg");  
        System.out.println(flag +"   判断删除结果");  
        
        //获取测试  
    	JSONObject   json=util.findFile("/root/update/","Y");  
        System.out.println(json.toJSONString() +"   文件夹下目录");  
        **/
    } 
}  