package com.wjm.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 
 * @author ������
 * @className Client.java
 * @createTime 2013-12-9
 * @version 1.0
 * @function �ͻ�ͨѶ��
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket serverSocket = new Socket("127.0.0.1", 10086);// ���÷�����socket  IP/�˿�
		Scanner keyInput = new Scanner(System.in);// ɨ������ȡ������������
		String strLine = keyInput.nextLine();// ��ȡ����
		OutputStream out = serverSocket.getOutputStream();// ��ȡ����������
		InputStream in = serverSocket.getInputStream();// ������������
		PrintWriter printWriter = new PrintWriter(out, true);//��װ�������������
		printWriter.println(strLine);//�����������
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(in));//���÷���������������
		System.out.println(bufReader.readLine());//��ӡ����������
		serverSocket.close();

	}
}
