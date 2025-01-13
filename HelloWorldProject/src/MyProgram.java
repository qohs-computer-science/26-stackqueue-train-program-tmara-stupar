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
		ArrayList <Train> track0 = new ArrayList <Train> ();
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

		//TRACK1
		ArrayList <Train> track1 = new ArrayList <Train> ();
		for(Train temp: track0)
			if(temp.getMiles()>700)
			{
				track1.add(temp);
				track0.remove(temp);
			}//if

		//TRENTON
		ArrayList <Train> trackA = new ArrayList <Train> ();
		int trentonWeight = 0;
		for(Train temp: track0)
		{
			if (trentonWeight < limitTrackA)
			{
				if(temp.getDest().equals("Trenton") && temp.getName().indexOf("CAR")>=0)
				{
					trackA.add(temp);
					track0.remove(temp);
					trentonWeight += temp.getWeight();
				}//if
				else if(temp.getDest().equals("Trenton") && temp.getName().indexOf("ENG")>=0)
				{
					System.out.println(temp.getName()+ " leaving for Trenton with the following cars:");
					for(Train tempA: trackA)
					{
						System.out.println(tempA.toString());
						trackA.remove(tempA);
					}
				}

			}//if
			else
			{
				System.out.println("ENG00000 leaving for Trenton with the following cars:");
				for(Train tempA: trackA)
				{
					System.out.println(tempA.toString());
					trackA.remove(tempA);
				}
			}//else
			
		}//for


		//CHARLOTTE
		ArrayList <Train> trackB = new ArrayList <Train> ();
		int charlotteWeight = 0;
		for(Train temp: track0)
		{
			if (charlotteWeight < limitTrackB)
			{
				if(temp.getDest().equals("Charlotte") && temp.getName().indexOf("CAR")>=0)
				{
					trackB.add(temp);
					track0.remove(temp);
					charlotteWeight += temp.getWeight();
				}//if
				else if(temp.getDest().equals("Charlotte") && temp.getName().indexOf("ENG")>=0)
				{
					System.out.println(temp.getName()+ " leaving for Charlotte with the following cars:");
					for(Train tempB: trackB)
					{
						System.out.println(tempB.toString());
						trackB.remove(tempB);
					}
				}

			}//if
			else
			{
				System.out.println("ENG00000 leaving for Charlotte with the following cars:");
				for(Train tempB: trackB)
				{
					System.out.println(tempB.toString());
					trackB.remove(tempB);
				}
			}//else
			
		}//for






	}//main
}//class
