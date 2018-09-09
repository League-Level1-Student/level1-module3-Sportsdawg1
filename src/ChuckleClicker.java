import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton joke = new JButton("joke");
	JButton punchline = new JButton("punchline");
	
	public static void main(String[] args) {
		ChuckleClicker clicker = new ChuckleClicker();
		clicker.makeButtons();
	}
	
	public void makeButtons() {
		frame.setVisible(true);
		panel.add(joke);
		panel.add(punchline);
		frame.add(panel);
		frame.pack();
		joke.addActionListener(this);
		punchline.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == joke) {
			JOptionPane.showMessageDialog(null, "A ham sandwich walks into a bar and orders a beer.");
		} else if (buttonPressed == punchline) {
			JOptionPane.showMessageDialog(null, "the bartender says, 'sorry, we don't serve food here.'");
		}
	}
}
