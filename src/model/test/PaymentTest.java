package model.test;
import model.Item;
import model.Payment;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
class PaymentTest {

	@Test
	void test() {
		ArrayList list = new ArrayList();
		Item item1 = new Item (111, 50, "Item1");
		list.add(item1);
		Item item2 = new Item (222, 99, "Item2");
		list.add(item2);
		Item item3 = new Item (333, 20, "Item3");
		list.add(item3);
		Item item4 = new Item (444, 199, "Item4");
		list.add(item4);
		Item item5 = new Item (555, 14, "Item5");
		list.add(item5);
		Item item6 = new Item (666, 40, "Item6");
		list.add(item6);

		Payment payment = new Payment(list);
		double total = payment.getTotal();
		System.out.println(total);
		assertEquals(422.0, total);
	}

}
