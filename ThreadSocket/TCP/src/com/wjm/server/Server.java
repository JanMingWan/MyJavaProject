package com.wjm.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author ������
 * @className Server.java
 * @createTime 2013-12-9
 * @version 1.0
 * @function ͨѶ�߳����
 */
public class Server {
	public static void main(String[] args) {
      System.out.println("�ȴ�����ͻ���");
      try {
		ServerSocket serverSocket=new ServerSocket(10086);
		Socket clientSocket=null;
		//�����ͻ���
		while (true) {
			clientSocket=serverSocket.accept();//�ȴ��ͻ��˵�����
			new ServerThread(clientSocket);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
