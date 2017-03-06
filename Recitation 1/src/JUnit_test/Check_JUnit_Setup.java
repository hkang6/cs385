package JUnit_test;

import static org.junit.Assert.assertEquals;

public class Check_JUnit_Setup {
	
	String message = "Hello World";
	MessageUtil messageUtil = new MessageUtil(message);
	
	@Test(expected = AssertionError.class)
	public void testPrintMessage() {
		
		fail();
	}

}
