package com.wjm.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * @author 王嘉明
 * @className ServerThread.java
 * @createTime 2013-12-9
 * @version 1.0
 * @function 服务器线程
 */
public class ServerThread extends Thread{
	//客户端套接端口
    private Socket clientSocket;
    //客户端输入流
    private InputStream clientInput;
    //客户端输出流
    private OutputStream clientOutPut;
    
    public ServerThread(Socket socket) throws IOException{//构造函数
    	clientSocket=socket;
    	clientInput=clientSocket.getInputStream();
    	clientOutPut=clientSocket.getOutputStream();
    	this.start();//启动线程
    }
    
    public void run(){
    	//构造输入流缓存
    	try {
    		BufferedReader bufReader=new BufferedReader(new InputStreamReader(clientInput));//缓存客户端输入流
			String strLine=bufReader.readLine();//读取输入内容
			PrintWriter printWriter=new PrintWriter(clientOutPut,true);
			if("OVER".equalsIgnoreCase(strLine)){//大小写不敏感对比
				printWriter.println("OVER");
			}else{
				printWriter.println("来自服务器："+strLine);
			}
			clientInput.close();
			clientOutPut.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
