package lab5.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lab5.BorrowingServices;
import lab5.Member;

class TestMembersBorrowingService {
	BorrowingServices service = BorrowingServices.getInstance();

	@Test
	void TestMemberServices() {
		Member member1 = new Member("Member 1", service);
		Member member2 = new Member("Member 2", service);
		assertEquals(member1.getBorrowingService(), member2.getBorrowingService(),
				"Members have two different borrowing services");
	}
	@Test
	void TestBorrowingServices() {
		Member member1 = new Member("Member 1", service);
		assertEquals(member1.getBorrowingService(), service);
	}
}