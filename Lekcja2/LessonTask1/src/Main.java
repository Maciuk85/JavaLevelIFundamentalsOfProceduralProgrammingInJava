
public class Main {

	public static void main(String[] args) {
	
Product produkt1 = new Product();
System.out.println(produkt1.name);
System.out.println(produkt1.price);
Product produkt2 = new Product("Tshirt",100);
System.out.println(produkt2.name);
System.out.println(produkt2.price);
System.out.println();
produkt1 = produkt2;
System.out.println(produkt1.name);
System.out.println(produkt1.price);
System.out.println(produkt2.name);
System.out.println(produkt2.price);
System.out.println();
produkt1.name = "Halina";
System.out.println(produkt1.name);
System.out.println(produkt1.price);
System.out.println(produkt2.name);
System.out.println(produkt2.price);


	}
}
