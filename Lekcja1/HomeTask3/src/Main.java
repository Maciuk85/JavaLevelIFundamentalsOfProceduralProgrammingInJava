
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static Scanner scInt = new Scanner(System.in);
	public static ArrayList<Integer> prices = new ArrayList<Integer>();
	public static ArrayList<String> products = new ArrayList<String>();
	public static Random generator = new Random();

	public static void main(String[] args) {

		int menu;

		for (;;) {

			if (products.size() >= 10) {
				System.out.println("Twoja lista ma juz 10 produktow, przejscie do podsumowania");
				menu = 3;
			} else {
				menu = showMenu();
			}
			switch (menu) {
			case 1:
				addProduct();
				break;
			case 2:
				if (products.isEmpty()) {
					System.out.println("Lista jest pusta");
				} else {
					products.remove(products.size() - 1);
				}
				break;
			case 3:
				setPrices();
				showList();
				System.out.print("Do zaplaty: ");
				System.out.print(calculateSum());
				System.out.println("zl");
				break;
			default:
				System.out.println("Brak takiej pozycji w menu");
				break;
			}
		}

	}

	public static int showMenu() {
		System.out.println("1. Dodaj produkt");
		System.out.println("2. Usun produkt(ostatnio dodany)");
		System.out.println("3. Przejdz do podsumowania.");
		return validateInputInt("Wybierz co chcesz zrobic: ");
	}

	static void addProduct() {
		System.out.print("Nazwa produktu: ");
		String product = sc.nextLine();
		products.add(product);
	}

	public static void setPrices() {
		for (int i = 0; i < products.size(); i++) {
			prices.add(generator.nextInt(25) + 1);
		}
	}

	public static void showList() {
		for (int i = 0; i < products.size(); i++) {
			System.out.print(products.get(i));
			System.out.print("-");
			System.out.print(prices.get(i));
			System.out.println("zl");
		}
	}

	public static int calculateSum() {
		int sum = 0;
		for (int i = 0; i < prices.size(); i++) {
			sum = sum + prices.get(i);

		}
		return sum;
	}
	
	public static int validateInputInt(String comunicate) {
		Scanner sc = new Scanner(System.in);
		int number;
		do {
			System.out.println(comunicate);
			while (!sc.hasNextInt()) {
				String input = sc.next();
				System.out.printf("%s pozycja nie jest poprawna pozycja \n", input);
				System.out.println(comunicate);
			}
			number = sc.nextInt();
		} while (number < 0);
		return number;

	}
	
}