/*
 * TODO: Name
 * TODO: Date
 * TODO: Class Period
 * TODO: Program Description
 */
import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyProgram {
	public static int val = 0;
	public static void main(String[] args) {

		int limitTrackA = 100000, limitTrackB = 100000, limitTrackC = 100000;
	
		Scanner x = new Scanner(System.in);
		String name ="";
		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			name = x.nextLine();
			System.out.println(name);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		//TRACK0
		Queue <Train> track0 = new LinkedList <Train> ();
		while(name.equals("END") == false)
		{
			if (name.indexOf("CAR")>=0){
				track0.add(new Train(name, x.nextLine(), x.nextLine(), x.nextLine(), x.nextInt(), x.nextInt()));
				x.nextLine();
				name = x.nextLine();

			}
			if (name.indexOf("ENG")>=0){
				track0.add(new Train(name, x.nextLine()));
				name = x.nextLine();
			}
		}
		//while (!track0.isEmpty())
		//System.out.println(track0.remove());


		//TRACK1
		Queue <Train> track1 = new LinkedList <Train> ();
		Queue <Train> trackA = new LinkedList <Train> ();
		int trentonWeight = 0;
		while (!track0.isEmpty())
		{
			Train current = track0.remove();
			if(current.getMiles()>700)
			{
				System.out.println(current);
				track1.add(current);
			}//if
/* */		//TRENTON
			if(current.getDest().equals("Trenton")) 
			{
	
			// if it going to trenton
				if(current.getName().indexOf("ENG")>=0)
				{
					System.out.println(current.getName()+ " leaving for Trenton with the following cars:");
					while (!trackA.isEmpty())
					{
						System.out.println(trackA.peek().toString());
						trackA.remove();
					}
				}
				// if its a CAR -- matches else				     
				else if (trentonWeight+ current.getWeight()< limitTrackA) // if destination is Trenton and it is a car not an engine
					{
						if(current.getDest().equals("Trenton") && current.getName().indexOf("CAR")>=0)
						{
							trentonWeight += current.getWeight();
							trackA.add(track0.remove());
						}//if
					}//if
				else
					{
						System.out.println("ENG00000 leaving for Trenton with the following cars:");
						while (!trackA.isEmpty())
						{
							System.out.println(trackA.peek().toString());
							trackA.remove();
						}
						// add the car to the now empty track
					}//else
				} // end if Trenton
			*/
		}//for


		//CHARLOTTE
		Queue <Train> trackB = new LinkedList <Train> ();
		int charlotteWeight = 0;
		while (!track0.isEmpty())
		{
			if (charlotteWeight < limitTrackB)
			{
				if(current.getDest().equals("Charlotte") && current.getName().indexOf("CAR")>=0)
				{
					charlotteWeight += current.getWeight();
					trackB.add(track0.remove());
				}//if
				else if(current.getDest().equals("Charlotte") && current.getName().indexOf("ENG")>=0)
				{
					System.out.println(current.getName()+ " leaving for Charlotte with the following cars:");
					while (!trackB.isEmpty())
					{
						System.out.println(trackB.peek().toString());
						trackB.remove();
					}
				}

			}//if
			else
			{
				System.out.println("ENG00000 leaving for Charlotte with the following cars:");
				while (!trackB.isEmpty())
				{
					System.out.println(trackB.peek().toString());
					trackB.remove();
				}
			}//else
			
		}//for


	}//main
}//class
