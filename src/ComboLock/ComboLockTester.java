package ComboLock;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class tests the ComboLock class.
 */
public class ComboLockTester
{
	public static void main(String[] args)
	{
		ArrayList<Integer> combination = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		int input=-999;
		String inputAsText;
		int goodInput = 0;
		
		System.out.println("This is a virtual combination lock!");
		System.out.print("Let's set your combination.\r\r");
		do
		{
			System.out.print("Please enter a number between 0 and 39: ");
			inputAsText = in.next();
			
			if(inputAsText.contains("[a-zA-Z]+") == false)
			{
				try {
					   input = Integer.parseInt(inputAsText);
					}
					catch (NumberFormatException e)
					{
						System.out.println("That was not a number.");
					}
			}
			
			if(input >= 0 && input <= 39)
			{
				goodInput++;
				System.out.println("Combination number " + goodInput + " has been set.");
				combination.add(input);
			}
			else if(input == -999) continue;
			else
			{
				System.out.println("That number was not between 0 and 39.");
			}
			
		}while(goodInput<3);
		
		ComboLock myLock = new ComboLock(combination.get(0),combination.get(1),combination.get(2));
		System.out.println("Your combination has been set!");		
		System.out.println("\rYour lock is closed.");
		
		while(!myLock.open())
		{
			System.out.println("The dial is pointing to " + myLock.getDial() +".");
			System.out.println("Would you like to turn right, turn left, "
					+ "or reset the dial back to zero?");
			do
			{
				System.out.print("Please enter your selection (right/left/zero): ");
				inputAsText = in.next();
			}while(!inputAsText.toUpperCase().equals("RIGHT") && !inputAsText.toUpperCase().equals("LEFT") && !inputAsText.toUpperCase().equals("ZERO"));
			
			if(inputAsText.toUpperCase().equals("ZERO"))
			{
				myLock.reset();
				System.out.println("Your dial was reset.");
			}
			else if(inputAsText.toUpperCase().equals("RIGHT"))
			{	
				do
				{
					System.out.print("Number of ticks: ");
					inputAsText = in.next();
		
					if(inputAsText.contains("[a-zA-Z]+") == false)
					{
						try {
							   input = Integer.parseInt(inputAsText);
							}
							catch (NumberFormatException e)
							{
								System.out.println("That was not a number.");
								input = -999;
							}
					}
					else input = -999;
					
					if(input == -999) continue;
					else if(input <= 0)
					{
						System.out.println("Please enter a positive number.");
					}
					
					
				}while(input<=0);
				
				myLock.turnRight(input);
			}
			else if(inputAsText.toUpperCase().equals("LEFT"))
			{
				do
				{
					System.out.print("Number of ticks: ");
					inputAsText = in.next();
		
					if(inputAsText.contains("[a-zA-Z]+") == false)
					{
						try {
							   input = Integer.parseInt(inputAsText);
							}
							catch (NumberFormatException e)
							{
								System.out.println("That was not a number.");
								input = -999;
							}
					}
					else input = -999;
					
					if(input == -999) continue;
					else if(input <= 0)
					{
						System.out.println("Please enter a positive number.");
					}
				}while(input<=0);
				myLock.turnLeft(input);
			}
		}
		
		System.out.println("\rYou unlocked your lock!");
		in.close();
	}	
}

/*
This is a virtual combination lock!
Let's set your combination.

Please enter a number between 0 and 39: 0
Combination number 1 has been set.
Please enter a number between 0 and 39: 0
Combination number 2 has been set.
Please enter a number between 0 and 39: 0
Combination number 3 has been set.
Your combination has been set!

Your lock is closed.
The dial is pointing to 0.
Would you like to turn right, turn left, or reset the dial back to zero?
Please enter your selection (right/left/zero): right
Number of ticks: 40
The dial is pointing to 0.
Would you like to turn right, turn left, or reset the dial back to zero?
Please enter your selection (right/left/zero): left
Number of ticks: 40
The dial is pointing to 0.
Would you like to turn right, turn left, or reset the dial back to zero?
Please enter your selection (right/left/zero): right
Number of ticks: 40

You unlocked your lock!
*/
