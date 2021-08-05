public class AlternatingCell extends AbstractCell{
    

    private int counter;

    private void initiliazeCounter ()
    {
        if (getIsAlive())
        counter = 0;
        else 
        counter =1;
    }

    public AlternatingCell (int r, int c, ConwayWorld w)
    {
        super(r, c, w);
        initiliazeCounter();
    }

    public AbstractCell cellForNextGeneration() {
		BlinkerCell next = new BlinkerCell(getRow(), getColumn(), world);
		
        //System.out.println (willBeAliveInNextGeneration());
		next.setIsAlive(willBeAliveInNextGeneration());
		
		return next;
        
	}

    public boolean willBeAliveInNextGeneration ()
    {
       if(counter == 0)
       {
           counter = 1;
           return true;
       }
       else
       {
           counter = 0;
           return false;
       }
    }
}
