package inputlinetest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static boolean dansLeDico(char [] prop) {

		FileInputStream file;
		try {
			file = new FileInputStream("dictionnaire.txt");
			Scanner sc = new Scanner(file);
			String p = new String(prop);
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				if(line.equals(p)) {					
					return true;
				}
			}
			
			return false;

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean bonnesLettres(char [] prop, char [] tirage){
		boolean ok = true;
		char [] mot  = tirage.clone();
		
		int j = 0;
		while( ok && j < prop.length ) {
			int k = 0;
			while( k < mot.length && prop[j]!=mot[k]) {
				k++;
			}			
			if(k==mot.length) {
				ok = false;
			}else {
				mot[k]=' ';
				j++;
			}			
		}

		return ok;
	}
	
	public static void afficher(char [] mot) {
		for (char c : mot) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	public static char[] melanger(char[] mot) {
		Random rd = new Random();
		for(int i=0;i<mot.length;i++) {
			int nbr1 = rd.nextInt(mot.length);
			int nbr2 = rd.nextInt(mot.length);
			char temp = mot[nbr1];
			mot[nbr1] = mot[nbr2];
			mot[nbr2] = temp;
		}
		return mot;
	}
	
	public static char[] tirerMotAleatoirement() {
		final int MAX_LINE = 22506;
		Random rd = new Random();
		int alea = rd.nextInt(MAX_LINE)+1;
		System.out.println(alea);
		FileInputStream tre;
		try {
			tre = new FileInputStream("dictionnaire.txt");
			Scanner sc = new Scanner(tre);
			int compteur = 1;
			String mot = "";
			while(sc.hasNextLine()) {
				mot = sc.nextLine();	
				if(compteur==alea) {
					break;
				}
				compteur++;
			}
			System.out.println(mot);
			return mot.toUpperCase().toCharArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void main(String[] args) {
		char [] mot = tirerMotAleatoirement();	
		afficher(mot);
		char [] melange = melanger(mot);		
		afficher(melange);
		System.out.println("Entrez une proposition");
		Scanner sc = new Scanner(System.in);
		char [] prop = sc.nextLine().toUpperCase().toCharArray();
		boolean f = bonnesLettres(prop, melange);
		if(f) {
			if(dansLeDico(prop)) {
				System.out.println("Bravo! le mot dans dico");
			}else {
				System.out.println("Le mot n'existe pas dans dico");
			}
		}else {
			System.out.println("Pas bonne lettres");
		}
		
		System.out.println("Fin");
	}
}
