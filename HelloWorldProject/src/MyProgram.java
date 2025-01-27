/*
 * TODO: Tamara Stupar
 * TODO: 1/17
 * TODO: 7
 * TODO: stacks and queues train program
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
		System.out.println();

		//TRACK1
		Queue <Train> track1 = new LinkedList <Train> ();
		Stack <Train> trackA = new Stack <Train> ();
		Stack <Train> trackB = new Stack <Train> ();
		Stack <Train> trackC = new Stack <Train> ();
		Stack <Train> trackD = new Stack <Train> ();


		int trentonWeight = 0;
		int charlotteWeight = 0;
		int baltimoreWeight = 0;

		while (!track0.isEmpty())
		{
			Train current = track0.remove();

/*TRACK 1*/	
			if(current.getMiles()>700)
			{
				track1.add(current);
			}//if

/*TRENTON*/	
			if(current.getDest().equals("Trenton")) 
			{
	
			// if it going to trenton
				if(current.getName().indexOf("ENG")>=0)
				{
					System.out.println(current.getName()+ " leaving for Trenton with the following cars:");
					trentonWeight = 0;
					while (!trackA.isEmpty())
					{
						System.out.println(trackA.pop());
					}
					System.out.println();
				}
				// if its a CAR -- matches else				     
				else if (trentonWeight+ current.getWeight()< limitTrackA) 
				{
					trentonWeight += current.getWeight();
					trackA.push(current);
				}//if
				else
				{
					System.out.println("ENG00000 leaving for Trenton with the following cars:");
					trentonWeight = 0;
					while (!trackA.isEmpty())
					{
						System.out.println(trackA.pop());
					}
					System.out.println();

					trentonWeight += current.getWeight();
					trackA.push(current);
					
				}//else
			} // end if TRENTON
			
/*CHARLOTTE*/	
			else if(current.getDest().equals("Charlotte")) 
			{
				if(current.getName().indexOf("ENG")>=0)
				{
					System.out.println(current.getName()+ " leaving for Charlotte with the following cars:");
					charlotteWeight = 0;
					while (!trackB.isEmpty())
					{
						System.out.println(trackB.pop());
					}
					System.out.println();
				}
				// if its a CAR -- matches else				     
				else if (charlotteWeight+ current.getWeight()< limitTrackB) 
				{
					charlotteWeight += current.getWeight();
					trackB.push(current);
				}//if
				else
				{
					System.out.println("ENG00000 leaving for Charlotte with the following cars:");
					charlotteWeight = 0;
					while (!trackB.isEmpty())
					{
						System.out.println(trackB.pop());
					}
					System.out.println();
					charlotteWeight += current.getWeight();
					trackB.push(current);
				}//else
		} // end if CHARLOTTE

/*BALTIMORE*/	
			else if(current.getDest().equals("Baltimore")) 
			{
				if(current.getName().indexOf("ENG")>=0)
				{
					System.out.println(current.getName()+ " leaving for Baltimore with the following cars:");
					baltimoreWeight = 0;
					while (!trackC.isEmpty())
					{
						System.out.println(trackC.pop());
					}
					System.out.println();
				}
				// if its a CAR -- matches else				     
				else if (baltimoreWeight+ current.getWeight()< limitTrackC) 
				{
					baltimoreWeight += current.getWeight();
					trackC.push(current);
				}//if
				else
				{
					System.out.println("ENG00000 leaving for Baltimore with the following cars:");
					baltimoreWeight = 0;
					while (!trackC.isEmpty())
					{
						System.out.println(trackC.pop());
					}
					System.out.println();
					baltimoreWeight += current.getWeight();
					trackC.push(current);
				}//else
			} // end if BALTIMORE

/*TRACK D*/
			else
				trackD.push(current);
		}//while

/*proccessing of track 1*/
		while (!track1.isEmpty())
		{
			Train current = track1.remove();
			current.setMiles(100);

		//trenton		
			if(current.getDest().equals("Trenton")) 
			{
				if (trentonWeight+ current.getWeight()< limitTrackA) 
				{
					trentonWeight += current.getWeight();
					trackA.push(current);
				}//if
				else
				{
					System.out.println("ENG00000 leaving for Trenton with the following cars:");
					trentonWeight = 0;
					while (!trackA.isEmpty())
					{
						System.out.println(trackA.pop());
					}
					System.out.println();

					trentonWeight += current.getWeight();
					trackA.push(current);
				}//else
			}//if trenton 

		//charlotte		
			else if(current.getDest().equals("Charlotte")) 
			{
				if (charlotteWeight+ current.getWeight()< limitTrackB) 
				{
					charlotteWeight += current.getWeight();
					trackB.push(current);
				}//if
				else
				{
					System.out.println("ENG00000 leaving for Charlotte with the following cars:");
					charlotteWeight = 0;
					while (!trackB.isEmpty())
					{
						System.out.println(trackB.pop());
					}
					System.out.println();
	
					charlotteWeight += current.getWeight();
					trackB.push(current);
				}//else
			}//if charlotte 

		//baltimore		
			else if(current.getDest().equals("Baltimore")) 
			{
				if (baltimoreWeight+ current.getWeight()< limitTrackC) 
				{
					baltimoreWeight += current.getWeight();
					trackC.push(current);
				}//if
				else
				{
					System.out.println("ENG00000 leaving for Baltimore with the following cars:");
					baltimoreWeight = 0;
					while (!trackC.isEmpty())
					{
						System.out.println(trackC.pop());
					}
					System.out.println();
	
					baltimoreWeight += current.getWeight();
					trackC.push(current);
				}//else
			}//if baltimore 
			else
				trackD.push(current);
		}//2nd while


/*END OF PROG*/
			System.out.println("End of program");
			System.out.println();
		//trenton
			if(!trackA.isEmpty())
			{
				System.out.println("ENG00000 leaving for Trenton with the following cars:");
				trentonWeight = 0;
				while (!trackA.isEmpty())
					System.out.println(trackA.pop());
				System.out.println();
			}//if

		//charlotte
			if(!trackB.isEmpty())
			{
				System.out.println("ENG00000 leaving for Charlotte with the following cars:");
				charlotteWeight = 0;
				while (!trackB.isEmpty())
					System.out.println(trackB.pop());
				System.out.println();
			}//if

		//baltimore
			if(!trackC.isEmpty())
			{
				System.out.println("ENG00000 leaving for Baltimore with the following cars:");
				baltimoreWeight = 0;
				while (!trackC.isEmpty())
					System.out.println(trackC.pop());
				System.out.println();
			}//if
			
			System.out.println("status of the station ");
			System.out.println("trains left in track D (other destinations): ");
			while (!trackD.isEmpty())
			{
				Train current = trackD.pop(); 
				System.out.println(current + " to " + current.getDest());
			}//while


	}//main
}//class
