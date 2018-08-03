import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener {
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JButton trick = new JButton();
	private JButton treat = new JButton();
	private void start() {
		frame.setVisible(true);
		trick.setText("trick");
		treat.setText("treat");
		panel.add(trick);
		panel.add(treat);
		frame.add(panel);
		trick.addActionListener(this);
		treat.addActionListener(this);
		frame.pack();
	}
	
	public static void main(String[] args) {
		new NastySurprise().start();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed.equals(trick)) {
			showPictureFromTheInternet("https://www.lipstiq.com/wp-content/uploads/2016/07/gallery-1469138599-evolvedhuman-760x490.jpg");
		} else if (buttonPressed.equals(treat)){
			showPictureFromTheInternet("https://img.buzzfeed.com/buzzfeed-static/static/2017-04/25/4/enhanced/buzzfeed-prod-fastlane-02/enhanced-12174-1493109051-1.jpg?downsize=1300:*&output-format=auto&output-quality=auto");
				
		}
	}
	private void showPictureFromTheInternet(String imageUrl) {
	     try {
	          URL url = new URL(imageUrl);
	          Icon icon = new ImageIcon(url);
	          JLabel imageLabel = new JLabel(icon);
	          JFrame frame = new JFrame();
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (MalformedURLException e) {
	          e.printStackTrace();
	     }
	}
}
