import java.util.Random;

public class MovingCell extends AbstractCell {


    public MovingCell (int r, int c, ConwayWorld w)
    {
        super(r, c, w);
    }
    
    
    

    public boolean willBeAliveInNextGeneration() {
		int nc = neighborCount();
		
		if(getIsAlive() && nc == 0)
        {
            //System.out.println('l');
            return true;
        }
        else return false;
	}

    public void move (MovingCell m)
    {
        world.replaceCell(m);
    }
	
	public AbstractCell cellForNextGeneration() {
        Random rand = new Random();
        int moveC = rand.nextInt(2);
        int moveR = rand.nextInt(2);
        int ifNeg = rand.nextInt(2);
        int ifNeg2 = rand.nextInt(2);


        

        if (ifNeg == 1)
        {
            moveC *= -1;
        }
        if (ifNeg2 == 1)
        {
            moveR *= -1;
        }
        

       
        
        MovingCell next = new MovingCell(getRow()+moveR, getColumn() + moveC, world);
       // System.out.println(next1.getRow());

        next.setIsAlive(willBeAliveInNextGeneration());
        if(getRow() > 0 && getColumn() > 0 && getRow() < 19 && getColumn() < 19 )
        {
            world.replaceCell(next);
        }

		return next;
	}

    public char displayCharacter ()
    {
        if (getIsAlive())
        return '~';
        else
        return '.';
    }


    public int neighborCount() {
		int count = 0;
		
		int row = getRow();
		int column = getColumn();
		
		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				if (world.isAlive(row + dr, column + dc) && !(dr == 0 && dc == 0)) {
					count++;
                    
				}
			}
		}
		//System.out.println(count);
		return count;
	}

}
