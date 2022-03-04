package inputlinetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class testecrire {
	
	public static void ecrire(String filename) {
		try {
			FileWriter file = new FileWriter(filename);
			file.write("Salut toi!");

			file.flush();
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void lire(String filename) {
	        
	        try {
	            FileInputStream file = new FileInputStream(filename);
	            Scanner sc = new Scanner(file);
	            while(sc.hasNextLine()) {
	                System.out.println(sc.nextLine());
	                System.out.println();
	            }
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	public static void main(String[] args) {
		ecrire("allo_allo.txt");
		lire("allo_allo.txt");
	}

}
