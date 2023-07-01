package ComboLock;
/**
 * A combination lock that can be set and unlocked.
 */
public class ComboLock
{
	private boolean isOpen;
	private boolean rightFirst;
	private boolean leftSecond;
	private boolean rightThird;
	private int secret1;
	private int secret2;
	private int secret3;
	private int dial;
	
	/**
	 * Constructs a ComboLock object with the combination as the passed values.
	 * @param secret1 First combination number.
	 * @param secret2 Second combination number.
	 * @param secret3 Third combination number.
	 */
    public ComboLock(int secret1, int secret2, int secret3)
    {
	   this.isOpen = false;
	   this.rightFirst = false;
	   this.leftSecond = false;
	   this.rightThird = false;
	   this.secret1 = secret1;
	   this.secret2 = secret2;
	   this.secret3 = secret3;
	   this.dial = 0;
    }
   
    /**
     * Resets the combination and dial back to zero.
     */
    public void reset()
    {
	   this.rightFirst = false;
	   this.leftSecond = false;
	   this.rightThird = false;
	   this.dial = 0;
    }
   
    /**
     * Turns the dial to the left by the passed number of ticks.
     * @param tick Number of ticks to turn the dial by.
     */
    public void turnLeft(int tick)
    {
	   for(int i=0; i<tick; i++)
	   {
		   if(this.dial==-1) this.dial=39;
		   this.dial--;
	   }
	   
	   if(this.dial==-1) this.dial=39;
	   
	   if(this.rightFirst && !this.rightThird && !this.leftSecond)
	   {
		   if(this.dial == this.secret2)
		   {
			   this.leftSecond = true;
		   }
		   else
		   {
			   this.leftSecond = false;
			   this.rightFirst = false;
			   this.rightThird = false;
		   }
	   }
	   else
	   {
		   this.leftSecond = false;
		   this.rightFirst = false;
		   this.rightThird = false;
	   }
    }
   
    /**
     * Turns the dial to the right by the passed number of ticks.
     * @param tick Number of ticks to turn the dial by.
     */
    public void turnRight(int tick)
    {
	   for(int i=0; i<tick; i++)
	   {
		   if(this.dial==40) this.dial=0;
		   this.dial++;
	   }
	   
	   if(this.dial==40) this.dial=0;
	   
	   if(!this.rightFirst && !this.leftSecond && !this.rightThird)
	   {
		   if(this.dial == this.secret1)
		   {
			   this.rightFirst = true;
		   }
		   else
		   {
			   this.leftSecond = false;
			   this.rightFirst = false;
			   this.rightThird = false;
		   }
	   }
	   else if(this.rightFirst && this.leftSecond)
	   {
		   if(this.dial == this.secret3)
		   {
			   this.rightThird = true;
		   }
		   else
		   {
			   this.leftSecond = false;
			   this.rightFirst = false;
			   this.rightThird = false;
		   }
	   }
	   else
	   {
		   this.leftSecond = false;
		   this.rightFirst = false;
		   this.rightThird = false;
	   }
    }
   
    /**
     * Checks to see if lock is open.
     * @return	Whether or not the lock is open.
     */
    public boolean open()
    {
	   if(this.rightFirst && this.leftSecond && this.rightThird)
		   {
		   		this.isOpen = true;
		   }

	   return isOpen;
    }
   
    /**
     * Retrieves the current dial location.
     * @return The current location of the dial.
     */
    public int getDial()
    {
	   return this.dial;
    }
}
