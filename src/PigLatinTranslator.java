import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatinTranslator implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JTextField text = new JTextField(10);
	JLabel label = new JLabel("hi");
	void createUI () {
		frame.setVisible(true);
		button.setText("translate");
		panel.add(text);
		panel.add(button);
		panel.add(label);
		button.addActionListener(this);
		frame.add(panel);
		frame.pack();
	}
	
	public static void main(String[] args) {
		PigLatinTranslator ui = new PigLatinTranslator();
		ui.createUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		Translator translator = new Translator();
		if (buttonPressed == button) {
			 String answer = translator.translate(text.getText());
			 System.out.println(answer);
			 label.setText(answer);
			 frame.pack();
		}
	}
}
