package breakout;

import javax.swing.JFrame;

public class MyScreen extends JFrame {

	
	public static void main(String[] args) {
	/* I learned from the tutorials that there is no difference
		between using obj. and this (like we did before) 
		so I will be using obj. just because I learned how
		to make breakout that way
		*/
		
	MyScreen obj = new MyScreen(); 
	MyCanvas gamePlay = new MyCanvas();
	obj.setBounds(10,10,700,600); //set the size
	obj.setTitle("Pong against yourself 1.0");  //title of the window
	obj.add(gamePlay);
	obj.setVisible(true);
	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	obj.setResizable(false); //made it so the player cant resize my frame
	
	

}
}