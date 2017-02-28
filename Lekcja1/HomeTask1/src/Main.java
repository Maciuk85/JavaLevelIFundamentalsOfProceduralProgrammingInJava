import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static Random generator = new Random();
	public static String ss = "aaa";
	public static final char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'r', 's', 't', 'u', 'w', 'x', 'y', 'z' };
	public static char[] alphabet2 = new char[alphabet.length];
	public static ArrayList<Character> vectorAlphabet = new ArrayList<Character>(); // alphabet,alphabet+alphabet.length
	public static int a;
	public static int operationNum;
	public static void main(String[] args) {
		genCode();

		for (;;)

		{
			showMainMenu();
			switch (operationNum) {
			case 1:
				System.out.println("Podaj slowo:");
				Scanner sc = new Scanner(System.in);
				char[] word = sc.next().toCharArray();
				System.out.print("Rozmiar: ");
				System.out.println(word.length);
				for (int i = 0; i < word.length; i++) {
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
				Scanner sc2 = new Scanner(System.in);
				char[] word2 = sc2.next().toCharArray();
				for (int i = 0; i < word2.length; i++) {
					for (int j = 0; j < alphabet.length; j++) {
						if (alphabet2[j] == word2[i]) {
							word2[i] = alphabet[j];
							break;
						}
					}
				}
				System.out.println("Odszyfrowane slowo: ");
				System.out.println(word2);
				break;
			case 3:
				System.out.print("Rozmiar: ");
				System.out.println(alphabet.length);
				for (int i = 0; i < alphabet.length; i++) {
					System.out.print(alphabet[i]);
					System.out.print("=");
					System.out.println(alphabet2[i]);
				}
				break;
			default:
				System.out.print("Koniec programu");
			}
		}

	}

	public static void genCode() {
		for (int i = 0; i < alphabet.length; i++) {
			vectorAlphabet.add(alphabet[i]);
		}
		int i = 0;
		while (!vectorAlphabet.isEmpty()) {
			int randomIndex = generator.nextInt(vectorAlphabet.size());

			alphabet2[i] = vectorAlphabet.get(randomIndex);
			vectorAlphabet.remove(randomIndex);
			i++;
		}
		System.out.println(alphabet);
		System.out.println(alphabet2);
		System.out.println(vectorAlphabet);

	}

	public static void showMainMenu() {
		System.out.println("Wybierz operacje: ");
		System.out.println("1.Zaszyfruj");
		System.out.println("2.Odszyfruj");
		System.out.println("3.Wyswietl szyfr");
		Scanner sc = new Scanner(System.in);
		operationNum = sc.nextInt();

	}

}
