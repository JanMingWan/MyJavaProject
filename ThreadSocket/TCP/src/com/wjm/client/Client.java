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
 * @author 王嘉明
 * @className Client.java
 * @createTime 2013-12-9
 * @version 1.0
 * @function 客户通讯端
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket serverSocket = new Socket("127.0.0.1", 10086);// 设置服务器socket  IP/端口
		Scanner keyInput = new Scanner(System.in);// 扫描器获取键盘输入内容
		String strLine = keyInput.nextLine();// 获取内容
		OutputStream out = serverSocket.getOutputStream();// 获取服务端输出流
		InputStream in = serverSocket.getInputStream();// 服务器输入流
		PrintWriter printWriter = new PrintWriter(out, true);//封装输出流到服务器
		printWriter.println(strLine);//设置输出内容
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(in));//设置服务器输入流缓存
		System.out.println(bufReader.readLine());//打印输入流内容
		serverSocket.close();

	}
}
