package labTest2;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LT2UnitTests {

	@Test
	public void test_01_NonPrivateFields_10pts() {
		Field[] fields = MenuItem.class.getDeclaredFields();
		//System.out.println(fields.length);
		for (Field field : fields) {
			assertTrue("MenuItem class: fields should be private or final", Modifier.isPrivate(field.getModifiers()) 
					|| Modifier.isFinal(field.getModifiers()));
		}
		fields = Bill.class.getDeclaredFields();
		//System.out.println(fields.length);
		for (Field field : fields) {
			assertTrue("Bill: fields should be private or final", Modifier.isPrivate(field.getModifiers()) 
					|| Modifier.isFinal(field.getModifiers()));
		}
		fields = BillItem.class.getDeclaredFields();
		//System.out.println(fields.length);
		for (Field field : fields) {
			assertTrue("BillItem: fields should be private or final", Modifier.isPrivate(field.getModifiers()) 
					|| Modifier.isFinal(field.getModifiers()));
		}
	}

	@Test
	public void test_02_MenuItemGetSetPrice_10pts() {
		MenuItem cake = new MenuItem("Cake", 1.99);
		assertTrue("MenuItem getPrice() fail", cake.getPrice() == 1.99);
		cake.setPrice(2.49);
		assertTrue("MenuItem setPrice() fail", cake.getPrice() == 2.49);
	}

	@Test
	public void test_03_MenuItemToString1_5_pts() {
		MenuItem sushi = new MenuItem("Sushi", 21.90);
		assertTrue("MenuItem toString incorrect1: " + sushi.toString(), sushi.toString().contains("Sushi"));
		assertTrue("MenuItem toString incorrect2: " + sushi.toString(), sushi.toString().contains("21.90"));
	}

	
	@Test
	public void test_04_BillItemComposition_10pts() {
		MenuItem cake = new MenuItem("Cake", 1.99);
		BillItem billItem = new BillItem(cake, 3);
		cake.setPrice(2.49);
		
		assertTrue("BillItem should own MenuItem",
				cake.getPrice() == 2.49 && billItem.getMenuItem().getPrice() == 1.99);
	}

	@Test
	public void test_05_BillItemGetSetPrice_10pts() {
		MenuItem cake = new MenuItem("Cake", 1.99);
		BillItem billItem = new BillItem(cake, 3);
		assertTrue("BillItem getPrice() fail", billItem.getQuantity() == 3);
		billItem.setQuantity(0);
		assertTrue("BillItem setPrice() fail", billItem.getQuantity() == 0);
	}

	@Test
	public void test_06_BillItemToString_5_pts() {
		MenuItem cake = new MenuItem("Cake", 1.99);
		BillItem billItem = new BillItem(cake, 3);
		assertTrue("BillItem toString incorrect1: " + billItem.toString(), billItem.toString().contains("Cake"));
		assertTrue("BillItem toString incorrect2: " + billItem.toString(), billItem.toString().contains("3"));
	}


	@Test
	public void test_07_BillToString1_10_pts() {
		MenuItem sushi = new MenuItem("Sushi", 21.99);
		MenuItem cake = new MenuItem("Cake", 1.99);
		MenuItem drink = new MenuItem("Drink", 0.98);

		Bill bill = new Bill();
		bill.addItem(sushi, 1);
		bill.addItem(cake, 3);
		bill.addItem(drink, 30);
		
		bill.addItem(cake, 44);
		System.out.println(bill);
		assertTrue("Bill toString incorrect1: " + bill.toString(), bill.toString().contains("Sushi"));
		assertTrue("Bill toString incorrect2: " + bill.toString(), bill.toString().contains("Cake"));
		assertTrue("Bill toString incorrect3: " + bill.toString(), bill.toString().contains("Drink") 
				&& bill.toString().contains("30"));
	}

	
	@Test
	public void test_08_BillToString2_5_pts() {
		MenuItem sushi = new MenuItem("Sushi", 21.99);
		MenuItem cake = new MenuItem("Cake", 1.99);
		MenuItem drink = new MenuItem("Drink", 0.98);

		Bill bill = new Bill();
		bill.addItem(sushi, 1);
		bill.addItem(cake, 3);
		bill.addItem(drink, 30);
		
		bill.addItem(cake, 44);

		assertTrue("Bill toString incorrect1: " + bill.toString(), bill.toString().contains("21.99"));
		assertTrue("Bill toString incorrect2: " + bill.toString(), bill.toString().contains("1.99"));
		assertTrue("Bill toString incorrect3: " + bill.toString(), bill.toString().contains(".98"));
	}

	@Test
	public void test_09_BillAddItemGetItems1_size_10pts() {
		MenuItem sushi = new MenuItem("Sushi", 21.99);
		MenuItem cake = new MenuItem("Cake", 1.99);
		MenuItem drink = new MenuItem("Drink", 0.98);

		Bill bill = new Bill();
		bill.addItem(sushi, 1);
		bill.addItem(cake, 3);
		bill.addItem(drink, 30);
		
		bill.addItem(cake, 1);
		//System.out.println(bill.getItems());
		assertTrue("Bill getList: wrong size", bill.getItems().size() == 4);
	}

	@Test
	public void test_10_BillGetItems2_notAlias_5pts() {
		MenuItem sushi = new MenuItem("Sushi", 21.99);
		MenuItem cake = new MenuItem("Cake", 1.99);

		Bill bill = new Bill();
		bill.addItem(sushi, 1);
		bill.addItem(cake, 3);
		
		assertTrue("Bill getList: no defensive copies", bill.getItems() != bill.getItems());
	}

	@Test
	public void test_11_BillGetItems3_deepCopy_10pts() {
		MenuItem cake = new MenuItem("Cake", 1.99);

		Bill bill = new Bill();
		bill.addItem(cake, 3);
		
		bill.getItems().get(0).setQuantity(1000);

		assertTrue("Bill getList: client can change quantity; deep copy required",
				bill.getItems().get(0).getQuantity() == 3);
	}

	@Test
	public void test_12_BillGetTotal_10pts() {
		MenuItem sushi = new MenuItem("Sushi", 21.99);
		MenuItem cake = new MenuItem("Cake", 1.99);
		MenuItem drink = new MenuItem("Drink", 0.98);

		Bill bill = new Bill();
		bill.addItem(sushi, 1);
		bill.addItem(cake, 3);
		bill.addItem(drink, 30);
		
		assertEquals("Bill getTotal: wrong value", 57.36, bill.getTotal(), 0.05);
	}



}
