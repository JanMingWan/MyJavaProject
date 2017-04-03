package com.wjm.game;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * ��Ϸ���
 * 
 * @author ������
 * 
 */
public class SnackWin extends JPanel implements ActionListener, KeyListener {
	JButton newGame, stopGame;// 2����ť
	int score, speed;// �ɼ����ٶ�
	int foolX = 0, foolY = 0;// ʳ���������
	Random random = new Random();
	boolean beginGame = false;

	List<SnackModel> list = new ArrayList<SnackModel>();

	public SnackWin() {
		newGame = new JButton("����Ϸ");
		stopGame = new JButton("ֹͣ");
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(newGame);
		this.add(stopGame);
		this.setBackground(Color.white);
		this.addKeyListener(this);
		newGame.addActionListener(this);
		stopGame.addActionListener(this);
	}

	/**
	 * ��ͼ
	 */
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(10, 40, 400, 400);
		g.drawString("����:" + score, 180, 23);
		g.drawString("�ٶ�:" + speed, 260, 23);
		if (beginGame) {
			try {
				BufferedImage img = ImageIO.read(new File(
						"D:\\workspace\\Snake\\img\\li.png"));
				g.drawImage(img, 10 + foolX * 10, 40 + foolY * 10, 20, 20, null);
				for (int i = 0; i < list.size(); i++) {
					if (i == 0) {
						BufferedImage tou = ImageIO.read(new File(
								"D:\\workspace\\Snake\\img\\tou.jpg"));
						g.drawImage(tou, 10 + list.get(i).getX() * 10,
								40 + list.get(i).getY() * 10, 20, 20, null);
					} else {
						g.fillRect(10 + list.get(i).getX() * 10,
								40 + list.get(i).getY() * 10, 20, 20);
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ����¼�
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == newGame) {
			newGame.setEnabled(false);// ���ᰴť
			beginGame = true;
			foolX = random.nextInt(39);
			foolY = random.nextInt(39);
			SnackModel sm = new SnackModel();
			sm.setX(20);
			sm.setY(15);
			list.add(sm);

			requestFocus(true);
			repaint();

		} else if (e.getSource() == stopGame) {
			newGame.setEnabled(true);

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * ���̼���
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (beginGame) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:

				move(0, -1);
				break;
			case KeyEvent.VK_DOWN:
				move(0, 1);
				break;
			case KeyEvent.VK_LEFT:
				move(-1, 0);
				break;
			case KeyEvent.VK_RIGHT:
				move(1, 0);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * �ƶ�
	 */
	public void move(int x, int y) {
		if (partCheck(list.get(0).getX() + x, list.get(0).getY() + y)) {
			list.get(0).setX(list.get(0).getX() + x);
			list.get(0).setY(list.get(0).getY() + y);
			eat();
			repaint();
		} else {

		}

	}

	/**
	 * �ֲ��ж�
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean partCheck(int x, int y) {
		if (overallSituationCheck(x, y)) {
			return true;
		} else {
			return false;

		}

	}

	/**
	 * ȫ���ж�
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean overallSituationCheck(int x, int y) {
		if (x < 0 || x >= 39 || y < 0 || y >= 39) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * ��
	 */
	public void eat() {
		if (foolX == list.get(0).getX() && foolY == list.get(0).getY()) {
			foolX = random.nextInt(39);
			foolY = random.nextInt(39);
			SnackModel sm=new SnackModel();
			sm.setX(list.get(list.size()-1).getX());
			sm.setY(list.get(list.size()-1).getY());
			list.add(sm);
			repaint();
		}
	}

}
