import java.awt.Color;
import java.util.Random;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class Gridworld {
	public static void main(String[] args) {
		World world = new World();
		world.show();
		Random rr = new Random();
		Random rc = new Random();
		Location randomLocation = new Location(rr.nextInt(10), rc.nextInt(10));
		//Bug bug = new Bug();
		//Bug bug1 = new Bug(Color.BLUE);
		//world.add(randomLocation, bug1);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Location location = new Location(i,j);
				Flower flower = new Flower();
				world.add(location, flower);
			}
		}
	}
}
