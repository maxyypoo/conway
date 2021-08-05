import java.util.*;

public class ConwayMain {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ConwayWorld world = new ConwayWorld();
		
	/*	// Add some live conway cells, in a horizontal line		
		for (int i = 0; i < 8; i++) {
			ConwayCell c = new ConwayCell(5, 5 + i, world);
			c.setIsAlive(true);
			world.replaceCell(c);
		}*/
		
		// Add an always-alive cells
		AbstractCell a = new AlwaysAliveCell(12, 12, world);
		world.replaceCell(a);
			
		// Add an always-alive cells
		AbstractCell n = new NeverAliveCell(17, 17, world);
		world.replaceCell(n);
			
		//Blinker Cell test
		AbstractCell b = new BlinkerCell(18, 19, world);
		b.setIsAlive(true);
		world.replaceCell(b);

		/*//Moving Cell test
		AbstractCell w = new MovingCell(15, 12, world);
		w.setIsAlive(true);
		world.replaceCell(w);*/

		//Moving Cell test
		AbstractCell u = new AlternatingCell(16, 17, world);
		u.setIsAlive(true);
		world.replaceCell(u);
		AbstractCell d = new AlternatingCell(18, 17, world);
		d.setIsAlive(true);
		world.replaceCell(d);

		AbstractCell r = new AlternatingCell(17, 16, world);
		r.setIsAlive(false);
		world.replaceCell(r);
		AbstractCell l = new AlternatingCell(17, 18, world);
		l.setIsAlive(false);
		world.replaceCell(l);

		// Go!	
		do {
			world.display();
			world.advanceToNextGeneration();
			
			System.out.print("Another? (y/n): ");
		} while (input.nextLine().charAt(0) == 'y');
	}
}