/*
Priyam Banerjee
The University of Texas at Arlington
Citation : 
http://www.mathcs.emory.edu/~cheung/Courses/554/Syllabus/8-recv+serial/deadlock-compare.html
https://cs.nyu.edu/courses/fall15/CSCI-GA.2433-001/slides/Unit12.pdf
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class TwoPhaseLocking
{
	public static HashMap<Integer, TransactionTable> transMap = new HashMap<Integer, TransactionTable>();
	public static HashMap<String, LockTable> lockMap = new HashMap<String, LockTable>();
	public static Queue<Integer> q = new PriorityQueue<Integer>();
	public static String[] data = new String[20];
	
	public static void main(String args[])
	{

		TwoPhaseLocking obj1 = new TwoPhaseLocking();
		data = obj1.ReadFile();
		System.out.println("************************************************************");
		System.out.println("Implementation of Rigorous 2PL With the Wait-Die Procedure");
		System.out.println("************************************************************");		
		TransactionTable T1 = new TransactionTable();
		T1.ReadTransactions();

	}

	public String[] ReadFile()
	{
		// reading file line by line
		FileInputStream fis = null;
		BufferedReader reader = null;
		String[] myarray;
		myarray = new String[100];
		try {
			fis = new FileInputStream("C:/Users/priya/Desktop/DB2_Project1_RigorousLocking/src/input_3.txt");
			reader = new BufferedReader(new InputStreamReader(fis));
			int i = 0;
			String line = reader.readLine();

			while (line != null)
			{
				myarray[i] = line;
				line = reader.readLine();
				i++;
			}
			reader.close();
		}

		catch (Exception e)
		{
			System.out.println("Error");
		}
		return myarray;
	}
}