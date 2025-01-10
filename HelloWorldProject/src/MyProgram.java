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
		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			String name = x.nextLine();
			System.out.println(name);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		ArrayList <Train> track0 = new ArrayList <Train> ();
		while(name.equals("END") == false)
		{
			if (name.indexOf("CAR")==1){
				track0.add(new Train(name, x.nextLine(), x.nextLine(), x.nextLine(), x.nextLine(), x.nextLine()));
				name = x.nextLine();

			}
			if (name.indexOf("ENG")==1){
				track0.add(new Train(name, x.nextLine()));
				name = x.nextLine();
			}
		}
		for(Train temp: track0)
			if(temp)

	}
}
