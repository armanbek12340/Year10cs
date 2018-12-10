package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.Timer;

import javax.swing.JPanel;

public class MyCanvas extends JPanel implements KeyListener , ActionListener {
/* I have added KeyListener to move the paddle and Action Listener
 * to program the Ball
 */
private boolean play = false; //so the game will not play when we launch it




private int delay = 10 ; // //sets how fast the ball travels
private int playerX= 310; //starting position of the paddle playerX=Paddle's x coordinate
private int ballposX = 120;//starting position of the ball
private int ballposY = 350;
private int ballxdir = -1;
private int ballydir = -2;
private Timer timer; //sets how fast the ball travels
public int score;



public MyCanvas() {
	addKeyListener(this);
	setFocusable(true);
	timer = new Timer(delay, this);
	timer.start();
	}

//public int elapsedSeconds;
 
public void paint(Graphics g) {
	//background
	g.setColor(Color.gray);
	g.fillRect(1, 1, 692, 592);

	//borders
	g.setColor(Color.red);
	g.fillRect(0, 0, 3, 592);
	g.fillRect(0, 0, 692, 3);
	g.fillRect(691, 0, 3, 592);
	
	//score
	score ++;
	g.setColor(Color.white);
	g.setFont(new Font("serif", Font.BOLD, 25));
	g.drawString(score + "ms", 590, 30);
	

	//the paddle
	g.setColor(Color.green);
	g.fillRect(playerX, 550, 100, 8);
	
	//the ball
	g.setColor(Color.yellow);
	g.fillOval(ballposX, ballposY, 20, 20);
	
	
	if(ballposY > 570) {
		play = false;
		ballxdir = 0;
		ballydir = 0;
		g.setColor(Color.RED);
		g.setFont(new Font("serif", Font.BOLD, 30));
		g.drawString("Game Over", 190, 60);
	}
	
	
	
	g.dispose();

}




@Override
public void actionPerformed(ActionEvent e) {
	timer.start(); 
	if(play) {
		if(new Rectangle(ballposX, ballposY, 20, 20).intersects(playerX, 550, 100, 8)) //makes the ball bounce when contacts the paddle
			ballydir = -ballydir;
		
		
		ballposX += ballxdir;// makes the ball bounce off the edge
		ballposY += ballydir;
		if(ballposX < 0) {
			ballxdir = -ballxdir;
		}
		if(ballposY < 0) {
			ballydir = -ballydir;
		}
		if(ballposX > 670) {
			ballxdir = -ballxdir;
		}
	
	
	}
	
	
	repaint();
	
}
@Override
public void keyReleased(KeyEvent e) {}
@Override
public void keyTyped(KeyEvent e)  {} //keyTyped and Released are not needed

@Override
public void keyPressed(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_RIGHT) { //VK stands for virtual key and it is
	if (playerX >=600) {					 // is easier to use it when programming objects moving in 2d 
		playerX= 600; // so that the paddle stays in the screen
	}else {
		moveRight();
	}
	}

	if(e.getKeyCode() == KeyEvent.VK_LEFT) {
		if (playerX < 10) {
			playerX = 10;
		} else {
			moveLeft();
		}
		}
}

public void moveRight() {
	play = true;
	playerX+=20; // moves the paddle 20 to the right
}
public void moveLeft() {
	play = true;
	playerX-=20; //move the paddle to the left
	
	
	
	
	
	
	
	
}
}
		
		
		
		
		
		
		
		
