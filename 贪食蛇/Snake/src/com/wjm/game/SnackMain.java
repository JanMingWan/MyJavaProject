package com.wjm.game;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SnackMain extends JFrame {
	public SnackMain() {
		SnackWin swin = new SnackWin();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screen = kit.getScreenSize();
		int h = (int) screen.getHeight();
		int w = (int) screen.getWidth();
		setTitle("小明贪食蛇  bata1.0----<挽手版>");
		Image img=kit.getImage("D:\\workspace\\Snake\\img\\ws.jpg");
		setIconImage(img);
		setSize(435, 490);
		setLocation(w/2, 200);
		this.add(swin);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SnackMain();
	}
}
