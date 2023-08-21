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
		Field[] fields = CircuitComponent.class.getDeclaredFields();
		//System.out.println(fields.length);
		for (Field field : fields) {
			assertTrue("CircuitComponent class: fields should be private or final", Modifier.isPrivate(field.getModifiers()) 
					|| Modifier.isFinal(field.getModifiers()));
		}
		fields = ComponentList.class.getDeclaredFields();
		//System.out.println(fields.length);
		for (Field field : fields) {
			assertTrue("ComponentList: fields should be private or final", Modifier.isPrivate(field.getModifiers()) 
					|| Modifier.isFinal(field.getModifiers()));
		}
		fields = ComponentListEntry.class.getDeclaredFields();
		//System.out.println(fields.length);
		for (Field field : fields) {
			assertTrue("ComponentListEntry: fields should be private or final", Modifier.isPrivate(field.getModifiers()) 
					|| Modifier.isFinal(field.getModifiers()));
		}
	}

	@Test
	public void test_02_CircuitComponentGetSetPrice_10pts() {
		CircuitComponent d = new CircuitComponent("Diode", 1.99);
		assertTrue("CircuitComponent getPrice() fail", d.getPrice() == 1.99);
		d.setPrice(2.49);
		assertTrue("CircuitComponent setPrice() fail", d.getPrice() == 2.49);
	}

	@Test
	public void test_03_CircuitComponentToString1_5_pts() {
		CircuitComponent d = new CircuitComponent("Diode", 21.90);
		assertTrue("CircuitComponent toString incorrect1: " + d.toString(), d.toString().contains("Diode"));
		assertTrue("CircuitComponent toString incorrect2: " + d.toString(), d.toString().contains("21.90"));
	}

	
	@Test
	public void test_04_ComponentListEntryComposition_10pts() {
		CircuitComponent d = new CircuitComponent("Diode", 1.99);
		ComponentListEntry listEntry = new ComponentListEntry(d, 3);
		d.setPrice(2.49);
		
		assertTrue("ComponentListEntry should not own CircuitComponent",
				/*d.getPrice() == 2.49 &&*/ listEntry.getComponent().getPrice() == 2.49);
	}

	@Test
	public void test_05_ComponentListItemGetSetPrice_10pts() {
		CircuitComponent d = new CircuitComponent("Diode", 1.99);
		ComponentListEntry listEntry = new ComponentListEntry(d, 3);
		assertTrue("ComponentListEntry getQuantity() fail", listEntry.getQuantity() == 3);
		listEntry.setQuantity(0);
		assertTrue("ComponentListEntry setQuantity() fail", listEntry.getQuantity() == 0);
	}

	@Test
	public void test_06_ComponentListItemToString_5_pts() {
		CircuitComponent d = new CircuitComponent("Diode", 1.99);
		ComponentListEntry listEntry = new ComponentListEntry(d, 3);
		assertTrue("ComponentListEntry toString incorrect1: " + listEntry.toString(), listEntry.toString().contains("Diode"));
		assertTrue("ComponentListEntry toString incorrect2: " + listEntry.toString(), listEntry.toString().contains("3"));
	}


	@Test
	public void test_07_ComponentListToString1_10_pts() {
		CircuitComponent t = new CircuitComponent("Transistor", 7.99);
		CircuitComponent r = new CircuitComponent("Resistor", 4.99);
		CircuitComponent c = new CircuitComponent("Capacitor", 1.98);

		ComponentList list = new ComponentList();
		list.addComponent(t, 2);
		list.addComponent(r, 1);
		list.addComponent(c, 2);
		
		list.addComponent(c, 1234);

		System.out.println(list);
		assertTrue("ComponentList toString incorrect1: " + list.toString(), list.toString().contains("Transistor"));
		assertTrue("ComponentList toString incorrect2: " + list.toString(), list.toString().contains("Resistor"));
		assertTrue("ComponentList toString incorrect3: " + list.toString(), list.toString().contains("Capacitor") 
				&& list.toString().contains("1234"));
	}

	
	@Test
	public void test_08_ComponentListToString2_5_pts() {
		CircuitComponent t = new CircuitComponent("Transistor", 7.99);
		CircuitComponent r = new CircuitComponent("Resistor", 4.99);
		CircuitComponent c = new CircuitComponent("Capacitor", 1.98);

		ComponentList list = new ComponentList();
		list.addComponent(t, 2);
		list.addComponent(r, 1);
		list.addComponent(c, 2);
		
		list.addComponent(c, 1234);

		//System.out.println(list);
		assertTrue("ComponentList toString incorrect1: " + list.toString(), list.toString().contains("7.99"));
		assertTrue("ComponentList toString incorrect2: " + list.toString(), list.toString().contains("4.99"));
		assertTrue("ComponentList toString incorrect3: " + list.toString(), list.toString().contains("1.98")); 
	}

	@Test
	public void test_09_ComponentListAddItemGetItems1_size_10pts() {
		CircuitComponent t = new CircuitComponent("Transistor", 7.99);
		CircuitComponent r = new CircuitComponent("Resistor", 4.99);
		CircuitComponent c = new CircuitComponent("Capacitor", 1.98);

		ComponentList list = new ComponentList();
		list.addComponent(t, 2);
		list.addComponent(r, 1);
		list.addComponent(c, 2);
		
		list.addComponent(c, 1234);
		//System.out.println(list.getItems());
		assertTrue("ComponentList getList: wrong size", list.getItems().size() == 4);
	}

	@Test
	public void test_10_ComponentListGetItems2_notAlias_5pts() {
		CircuitComponent t = new CircuitComponent("Transistor", 7.99);
		CircuitComponent r = new CircuitComponent("Resistor", 4.99);

		ComponentList list = new ComponentList();
		list.addComponent(t, 2);
		list.addComponent(r, 1);
		
		assertTrue("ComponentList getList: no defensive copies", list.getItems() != list.getItems());
	}

	@Test
	public void test_11_ComponentListGetItems3_deepCopy_10pts() {
		CircuitComponent t = new CircuitComponent("Transistor", 7.99);

		ComponentList list = new ComponentList();
		list.addComponent(t, 3);
		
		list.getItems().get(0).setQuantity(1000);

		assertTrue("ComponentList getList: client can change quantity; deep copy required",
				list.getItems().get(0).getQuantity() == 3);
	}

	@Test
	public void test_12_ComponentListGetTotal_10pts() {
		CircuitComponent t = new CircuitComponent("Transistor", 7.99);
		CircuitComponent r = new CircuitComponent("Resistor", 4.99);
		CircuitComponent c = new CircuitComponent("Capacitor", 1.98);

		ComponentList list = new ComponentList();
		list.addComponent(t, 2);
		list.addComponent(r, 1);
		list.addComponent(c, 2);

		assertEquals("ComponentList getTotal: wrong value", 24.93, list.getTotal(), 0.05);
	}

}
