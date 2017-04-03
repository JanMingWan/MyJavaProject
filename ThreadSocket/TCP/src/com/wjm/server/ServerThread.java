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
 * @author ������
 * @className ServerThread.java
 * @createTime 2013-12-9
 * @version 1.0
 * @function �������߳�
 */
public class ServerThread extends Thread{
	//�ͻ����׽Ӷ˿�
    private Socket clientSocket;
    //�ͻ���������
    private InputStream clientInput;
    //�ͻ��������
    private OutputStream clientOutPut;
    
    public ServerThread(Socket socket) throws IOException{//���캯��
    	clientSocket=socket;
    	clientInput=clientSocket.getInputStream();
    	clientOutPut=clientSocket.getOutputStream();
    	this.start();//�����߳�
    }
    
    public void run(){
    	//��������������
    	try {
    		BufferedReader bufReader=new BufferedReader(new InputStreamReader(clientInput));//����ͻ���������
			String strLine=bufReader.readLine();//��ȡ��������
			PrintWriter printWriter=new PrintWriter(clientOutPut,true);
			if("OVER".equalsIgnoreCase(strLine)){//��Сд�����жԱ�
				printWriter.println("OVER");
			}else{
				printWriter.println("���Է�������"+strLine);
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
