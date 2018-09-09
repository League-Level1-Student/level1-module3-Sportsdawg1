
public class Netflix {
	public static void main(String[] args) {
		Movie shrek = new Movie("shrek", 6);
		Movie shrek2 = new Movie("shrek 2", 5);
		Movie shrekforeverafter = new Movie("shrek forever after", 3);
		Movie shrek3 = new Movie("shrek 3", 4);
		Movie boots = new Movie("puss in boots", 3);
		
		String shrekPrice = shrek.getTicketPrice();
		System.out.println(shrekPrice);
		NetflixQueue queue = new NetflixQueue();
		
		queue.addMovie(shrek);
		queue.addMovie(shrek2);
		queue.addMovie(shrekforeverafter);
		queue.addMovie(shrek3);
		queue.addMovie(boots);
		
		queue.printMovies();
		
		System.out.println("the best movie is " + queue.getBestMovie());
		System.out.println("the second best movie is " + queue.getSecondBestMovie());
	}
}
