import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	public int int1;
	public int int2;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	int answerNum;
	JLabel answer = new JLabel("hi");
	JTextField text1 = new JTextField(10);
	JTextField text2 = new JTextField(10);
	JButton add = new JButton();
	JButton sub = new JButton();
	JButton mult = new JButton();
	JButton div = new JButton();
	public int add () {
		return int1 + int2;
	}
	public int subtract () {
		return int1 - int2;
	}
	public int multiply () {
		return int1 * int2;
	}
	public int divide () {
		return int1 / int2;
	}
	void createUI () {
		frame.setVisible(true);
		text1.setEditable(true);
		text2.setEditable(true);
		add.setText("add");
		sub.setText("subtract");
		mult.setText("multiply");
		div.setText("divide");
		add.addActionListener(this);
		sub.addActionListener(this);
		mult.addActionListener(this);
		div.addActionListener(this);
		panel.add(text1);
		panel.add(text2);
		panel.add(add);
		panel.add(sub);
		panel.add(mult);
		panel.add(div);
		panel.add(answer);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == add) {
			int1 = Integer.parseInt(text1.getText());
			int2 = Integer.parseInt(text2.getText());
			answerNum = int1 + int2;
			answer.setText(answerNum + "");
		} else if (buttonPressed == sub) {
			int1 = Integer.parseInt(text1.getText());
			int2 = Integer.parseInt(text2.getText());
			answerNum = int1 - int2;
			answer.setText(answerNum + "");
		} else if (buttonPressed == mult) {
			int1 = Integer.parseInt(text1.getText());
			int2 = Integer.parseInt(text2.getText());
			answerNum = int1 * int2;
			answer.setText(answerNum + "");
		} else if (buttonPressed == div) {
			int1 = Integer.parseInt(text1.getText());
			int2 = Integer.parseInt(text2.getText());
			answerNum = int1 / int2;
			answer.setText(answerNum + "");
		}
	}
}
