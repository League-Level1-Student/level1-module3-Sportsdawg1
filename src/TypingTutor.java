import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TypingTutor extends KeyAdapter{
	static JFrame frame = new JFrame();
	static JLabel letterLabel = new JLabel();
	static char currentLetter;
	boolean correctkey = false;
	public void createUI () {
		frame.setVisible(true);
		frame.add(letterLabel);
		frame.addKeyListener(this);
		frame.pack();
	}
	public void keyPressed (KeyEvent e) {
		System.out.println("you typed: " + e.getKeyChar());
		if (e.getKeyChar() == (currentLetter)) {
			System.out.println("correct");
			correctkey = true;
			frame.setBackground(Color.green);
		} else {
			frame.setBackground(Color.red);
			correctkey = false;
		}
	}
	public void keyReleased (KeyEvent e) {
		if (correctkey) {
			currentLetter = generateRandomLetter();
			letterLabel.setText(currentLetter + "");
			letterLabel.setFont(letterLabel.getFont().deriveFont(30.0f));
			letterLabel.setHorizontalAlignment(JLabel.CENTER);
		}
	}
	public static void main(String[] args) {
		TypingTutor tutor = new TypingTutor();
		tutor.createUI();
		currentLetter = generateRandomLetter();
		letterLabel.setText(currentLetter + "");
		letterLabel.setFont(letterLabel.getFont().deriveFont(30.0f));
		letterLabel.setHorizontalAlignment(JLabel.CENTER);
		
	}
	static char generateRandomLetter() {
	      Random r = new Random();
	      return (char) (r.nextInt(26) + 'a');
	}
	
}

 