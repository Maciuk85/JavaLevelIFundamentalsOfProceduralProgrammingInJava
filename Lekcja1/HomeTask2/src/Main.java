import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 int numberOfElements;
		String menu;
		 int element;
		String elementv2;
		 
		 final String validateInput(String fieldName, int value) {
			System.out.print(fieldName);
			System.out.print("=");
				while (!(cin >> value)) {
					System.out.print("Blad. Wprowadz ponownie ");
					System.out.print(fieldName);
					System.out.print("=");
				}
			}
		final String chceckIndexesIsInList(String comunicate) {
			validateInput(comunicate, element);
			while (element >= list.size()) {
				System.out.print("Blad, nie ma elementu ze wskazanym indeksem");
					validateInput(comunicate, element);
			}
		}
		 void addElement() {
			chceckIndexesIsInList("Podaj na ktora pozycje ma zostac wstawiony nowy element");
			validateInput("Podaj nowy element", elementv2);
			//list.insert(list.begin() + element, elementv2);

		}
		void changeElement() {	
				chceckIndexesIsInList("Podaj ktory element ma zostac podmnieony: ");
				System.out.print("Wprowadz nowy element: ");
				Scanner sc = new Scanner(System.in);
				 elementv2 = sc.nextLine();
			//list.erase(list.begin() + element);
			//list.insert(list.begin() + element, elementv2);
		} 
		void deleteElement() {
			chceckIndexesIsInList("Podaj element ktory ma zostac usuniety");
				//list.erase(list.begin() + element);
		}
		void readList() {
			validateInput("Podaj ile przedmiotow ma liczyc lista", numberOfElements);
			for (int i = 0; i < numberOfElements; i++) {
				validateInput("Wartosc elementu",element);
				//list.push_back(element);	
			}
		}
		void createmenu() {
			System.out.println("1.Usun wybrany element(indeksy od 0)");
			System.out.println("2. Dodaj element na dowolne miejsce");
			System.out.println("3. Podmien dowolny element");
			System.out.println("4. Zobacz rozmiar listy");
			System.out.println("5. Wyswietl liste");
			System.out.println("Wybierz operacje: " );
			Scanner sc = new Scanner(System.in);
			 menu = sc.nextLine();
			}
		void showList() {
			System.out.println(list[i]);
			for (int i = 0; i < list.size(); i++) {
			}
		}
		int main() {
			readList();
			for (;;) {
				createmenu();
				switch (menu) {
				case 1:
					deleteElement();
					break;
				case 2:
					addElement();
					break;
				case 3:
					changeElement();
					break;
				case 4:
					System.out.print("Rozmiar listy: " );
					System.out.println(list.size() );
					break;
				case 5:
					showList();
					break;
				default:
					System.out.println("Brak takiej operacji - koniec programu"  );
				}
			}
	}
}
