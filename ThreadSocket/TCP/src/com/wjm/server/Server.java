package com.wjm.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author 王嘉明
 * @className Server.java
 * @createTime 2013-12-9
 * @version 1.0
 * @function 通讯线程入口
 */
public class Server {
	public static void main(String[] args) {
      System.out.println("等待接入客户端");
      try {
		ServerSocket serverSocket=new ServerSocket(10086);
		Socket clientSocket=null;
		//监听客户端
		while (true) {
			clientSocket=serverSocket.accept();//等待客户端的链接
			new ServerThread(clientSocket);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
