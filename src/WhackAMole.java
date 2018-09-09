import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class WhackAMole implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton mole = new JButton("mole");
	int counter = 0;
	int missCounter = 0;
	
	static Random random = new Random();
	void drawButtons (Random r) {
		int place = r.nextInt((23) + 0);
		frame.setVisible(true);
		mole.addActionListener(this);
		//panel = new JPanel();
		panel.setLayout(new GridLayout(8,3));
		for (int i = 0; i < 24; i++) {
			JButton b = new JButton();
			b.addActionListener(this);
			if (i == place) {
				panel.add(mole);
			} else {
				panel.add(b);
			}
		}
		frame.pack();
		frame.add(panel);
		frame.pack();
	}
	Date date = new Date();
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				 WhackAMole m = new WhackAMole();
					m.drawButtons(random);
			}
		});
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
			if (buttonPressed == mole) {
				counter++;
			} else {
				speak("you missed");
				missCounter++;
			}
		if (counter == 10) {
			System.out.println("you win");
			endGame(date,10);
		} else {
		
		}
		
		if (missCounter == 5) {
			System.out.println("you lose");
			endGame(date,5);
		}
		
		
		//frame.dispose();
		//frame.remove(panel);
		panel.removeAll();
		//frame.repaint();
		frame.pack();
		//frame = new JFrame();
		drawButtons(random);
		
	}
	void speak(String words) {
	     try {
	          Runtime.getRuntime().exec("say " + words).waitFor();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
	
	private void endGame(Date timeAtStart, int molesWhacked) {
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " moles per second.");
	}
}
