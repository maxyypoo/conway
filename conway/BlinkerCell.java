public class BlinkerCell extends AbstractCell
{
    BlinkerCell(int r, int c, ConwayWorld w)
    {
        super(r,c,w);
    }

    public AbstractCell cellForNextGeneration() {
		BlinkerCell next = new BlinkerCell(getRow(), getColumn(), world);
		
        //System.out.println (willBeAliveInNextGeneration());
		next.setIsAlive(willBeAliveInNextGeneration());
		
		return next;
        
	}

    public boolean willBeAliveInNextGeneration ()
    {
        boolean alive = true;
        //System.out.println ("bool: " + alive);
        if (getIsAlive() == true)
        {
            alive = false;
        }
        else if (getIsAlive() == false)
        {
            alive = true;
        }
        return alive;
    }
}

