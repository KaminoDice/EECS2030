

public class InvoiceTester {
	public static void main(String[] args) {
		Product cake = new Product("Chocolate Cake", 21.99);
		Product cookies = new Product("Oatmeal Cookies", 1.99);
		Product chocolates = new Product("Tasty Chocolates", 0.98);

		Invoice invoice = new Invoice();
		invoice.addItem(cake, 1);
		invoice.addItem(cookies, 3);
		invoice.addItem(chocolates, 30);
		
		cookies.setPrice(2.49);
		invoice.addItem(cookies, 1);
		
		invoice.getItems().get(3).setQuantity(1000);
		invoice.getItems().get(3).getProduct().setPrice(0);

		System.out.println("[Testing Product toString]\n" + cake);
		System.out.println("[Testing Product getName]\n" + cake.getName());
		System.out.println("[Testing Product price]\n" + cake.getPrice());

		System.out.println("[Testing Invoice.getItems + InvoiceItem.toString]");
		System.out.println(invoice.getItems());
		System.out.println(invoice.getItems() == invoice.getItems()); //should it be true or false?
		System.out.println(invoice.getItems().equals(invoice.getItems())); //should it be true or false?
		System.out.println();

		System.out.println("[Testing Invoice toString]");
		System.out.println(invoice);

	}
}
