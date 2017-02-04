import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Random generator = new Random();	
		String ss= "aaa";
		final char[] alphabet = { 'a', 'b', 'c', 'd', 'e','f','g','h','i','j','k','l','m','n','o','p','r','s','t','u','w','x','y','z'};
		char[] alphabet2 = new char[alphabet.length];
		ArrayList<Character> vectorAlphabet = new ArrayList<Character>(); //alphabet,alphabet+alphabet.length 
		int a;

		private static void genCode() {
			int i = 0;
			while(vectorAlphabet.size() != 1){
				double randomIndex = generator.nextDouble() * vectorAlphabet.size()-1;
				alphabet2[i] = vectorAlphabet[randomIndex];
				vectorAlphabet.remove(randomIndex);
				i++
				}
			alphabet2[i] = vectorAlphabet[0];
			
		}
		
		private static void showMainMenu() {
			System.out.println("Wybierz operacje: ");
			System.out.println("1.Zaszyfruj");
			System.out.println("2.Odszyfruj");
			System.out.println("3.Wyswietl szyfr");
			Scanner sc = new Scanner(System.in);
			String operationNum = sc.nextLine();
			
		}
		genCode();
		for (;;) {
			showMainMenu();
			switch (operationNum) {
			case 1:
				System.out.println("Podaj slowo:");
				Scanner sc = new Scanner(System.in);
				String word = sc.nextLine();
				System.out.print("Rozmiar: ");
				System.out.println(word.length());
				for (int i = 0; i < word.length(); i++) {
					for (int j = 0; j < alphabet.length; j++) {
						if (alphabet[j] == word[i]) {
							word[i] = alphabet2[j];
							break;
						}
					}
				}
				System.out.println("Zaszyfrowane slowo: ");
				System.out.println(word);
				break;
			case 2:
				System.out.print("Podaj slowo: ");
				Scanner sc = new Scanner(System.in);
				word = sc.nextLine();
				for (int i = 0; i < word.length(); i++) {
					for (int j = 0; j < alphabet.length; j++) {
						if (alphabet2[j] == word[i] ) {
							word[i] = alphabet[j];
							break;
						}
					}
				}
				System.out.println("Odszyfrowane slowo: ");
				System.out.println(word);
				break;
			case 3:
				System.out.print("Rozmiar: ");
				System.out.println(alphabet.length);
				for (int i = 0; i <alphabet.length; i++) {
					System.out.print(alphabet[i]);
					System.out.print("=");
					System.out.println(alphabet2[i]);
				}
				break;
			default:
				System.out.print("Koniec programu");
				system("pasue");
				return 0;
			}
		}
		
		
}	
}

	