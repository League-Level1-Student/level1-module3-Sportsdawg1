

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.IOException;

public class SimonSays extends KeyAdapter {

	// Complete steps 1 - 7 before you test
	// 1. Declare a JFrame variable
	JFrame frame;
	
	HashMap<Integer, String> images = new HashMap<Integer, String>();
	private int imageIndex;
	private int tries = 0;
	private boolean simonSays = false;
	String image;
	Date timeAtStart;
	
	private void makeAlbum() {
		// 2. Add the four images that match keyboard keys like this: 
		images.put(new Integer(KeyEvent.VK_UP), "up.jpg");
		images.put(new Integer(KeyEvent.VK_DOWN), "down.jpg");
		images.put(new Integer(KeyEvent.VK_LEFT), "left.jpg");
		images.put(new Integer(KeyEvent.VK_RIGHT), "right.jpg");

		// 3. Use a JOptionPane to tell the user the rules: "Press the matching key when
		// 'Simon says' otherwise press a different key"
		JOptionPane.showMessageDialog(null, "Press the matching key when 'Simon says' otherwise press a different key");
		// 4. Call the showImage method to show an image
		showImage();
	}

	public void keyPressed(KeyEvent e) {
		// 15. Make a points variable to track the score.
		int score = 0;
		setImage();
		
		// 16. If the keyCode matches the imageIndex and "Simon says"
		if (e.getKeyCode() == imageIndex && simonSays) {
			
		
		
			// 17. Increase the value of score
		score++;
		
			// 18. Use the speak method to tell the user they were correct
		speak("correct");
		} else if (e.getKeyCode() != imageIndex && !simonSays) {
		// 19. If the keyCode doesn't match the imageIndex and "Simon didn't say..."
		
			// 20.  Increase the value of score
			score++;
		
			// 21. Use the speak method to tell the user they were correct
			speak("correct");
		
		// 22. Increment tries by 1
		}
		tries++;
		// 25. If tries is greater than 9 (or however many you want)...
		if (tries > 9) {
			
		
			// 26. Tell the user their score
			speak(score + "");
		
			// 27. Exit the program
			System.exit(1);
			
		}
		// 23. Dispose of the frame
			frame.dispose();

		// 24. Call the showImage method to show a new image
			showImage();
		
	}

	private void showImage() {
		// 5. Initialize your frame to a new JFrame()
		frame = new JFrame();
		// 6. Set the frame to visible
		frame.setVisible(true);
		// 7. Uncomment the following line to add a random image to your frame
		frame.add(getNextRandomImage());

		// 8. Set the name of your frame
		frame.setName("simon says");

		// 9. Pack the frame
		frame.pack();
		// 10. Set the defaultCloseOperation of your from to JFrame.EXIT_ON_CLOSE
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 11. Add a key listener to the frame
		frame.addKeyListener(this);
		// 12. Create a new instance of Random
		Random random = new Random();
		
		// 13. Use the Random and the speak method to either say 
		// "Simon says press this key" or "Press this key"
		
		if (random.nextInt(2) == 1) {
			simonSays = true;
		} else {
			simonSays = false;
		}
		setImage();
		if(simonSays) {
			speak("simon says press" + image);
		} else {
			speak("press" + image);
		}
		// 14. Above, set the value of simonSays to true/false appropriately
		
		
	}

	private Component getNextRandomImage() {
		this.imageIndex = new Random().nextInt(4) + 37;
		return loadImage(images.get(imageIndex));
	}

	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new SimonSays().makeAlbum();
	}
	void setImage() {
		if (imageIndex == 37) {
			image = "left";
		} else if (imageIndex == 38) {
			image = "up";
		} else if (imageIndex == 39) {
			image = "right";
		} else if (imageIndex == 40) {
			image = "down";
		}
	}
}
/*
 * BONUS!
 * Add a timer :
 * ~~~ where the code starts running ~~~ 
 * timeAtStart = newDate();
 *
 * ~~~ where the code ends ~~~ 
 * Date timeAtEnd = new Date();
 * System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
 * System.exit(0);
 */
