import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculator {
	public int int1;
	public int int2;
	JLabel answer = new JLabel();
	JTextField text1 = new JTextField();
	JTextField text2 = new JTextField();
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
		add.setText("add");
		sub.setText("subtract");
		mult.setText("multiply");
		div.setText("divide");
	}
}
