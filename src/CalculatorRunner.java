import javax.swing.JOptionPane;
public class CalculatorRunner {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.int1 = Integer.parseInt(JOptionPane.showInputDialog("int1"));
		calculator.int2 = Integer.parseInt(JOptionPane.showInputDialog("int2"));
		System.out.println(calculator.add());
		System.out.println(calculator.subtract());
		System.out.println(calculator.multiply());
		System.out.println(calculator.divide());

	}

}
