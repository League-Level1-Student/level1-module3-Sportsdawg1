import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel image1 = new JLabel();
	JLabel image2 = new JLabel();
	JLabel image3 = new JLabel();
	ImageIcon icon1 = new ImageIcon(SlotMachine.class.getResource("cherry.jpg"));
	ImageIcon icon2 = new ImageIcon(SlotMachine.class.getResource("lemon.jpg"));
	ImageIcon icon3 = new ImageIcon(SlotMachine.class.getResource("strawberry.jpg"));
	JButton spin = new JButton("spin");
	
	Random random  = new Random();
	int randomNumber;
	int randomNumber2;
	int randomNumber3;
	
	void createUI() {
		spin.addActionListener(this);
		image1.setIcon(icon1);
		image2.setIcon(icon2);
		image3.setIcon(icon3);
		panel.add(image1);
		panel.add(image2);
		panel.add(image3);
		panel.add(spin);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
	
	void randomImages() {
		randomNumber = random.nextInt(3);
		System.out.println(randomNumber);
		if (randomNumber == 0) {
			image1.setIcon(icon1);
		} else if (randomNumber == 1) {
			image1.setIcon(icon2);
		} else if (randomNumber == 2) {
			image1.setIcon(icon3);
		}
		randomNumber2 = random.nextInt(3);
		if (randomNumber2 == 0) {
			image2.setIcon(icon1);
		} else if (randomNumber2 == 1) {
			image2.setIcon(icon2);
		} else if (randomNumber2 == 2) {
			image2.setIcon(icon3);
		}
		randomNumber3 = random.nextInt(3);
		if (randomNumber3 == 0) {
			image3.setIcon(icon1);
		} else if (randomNumber3 == 1) {
			image3.setIcon(icon2);
		} else if (randomNumber3 == 2) {
			image3.setIcon(icon3);
		}
		frame.pack();
		if (randomNumber == randomNumber2 && randomNumber2 == randomNumber3) {
			JOptionPane.showMessageDialog(null, "you win");
		}
		
	}
	public static void main(String[] args) {
		SlotMachine slot = new SlotMachine();
		slot.createUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		randomImages();
		
	}
}
