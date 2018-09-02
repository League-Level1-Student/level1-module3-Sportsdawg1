import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class WhackAMole implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton mole = new JButton("mole");
	int counter = 0;
	
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
			}
		if (counter == 10) {
			System.out.println("you win");
		} else {
		
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
}
