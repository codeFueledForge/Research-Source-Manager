package sourcedatatypes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTitle {
/*
	@Test
	public void testTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTitle() {
		fail("Not yet implemented");
	}

*/
	@Test
	public void testParseTitle() {
		String fakeTitle1 = "The Title: Easy Mode!";
		String[] expectedResult1 = {"The", "Title", "Easy", "Mode"};
		String[] obtainedResult1 = Title.parseTitle(fakeTitle1);
		
		assertTrue(expectedResult1.length == obtainedResult1.length);
		for(int i = 0; i< expectedResult1.length; i++){
			assertTrue(expectedResult1[i].equals(obtainedResult1[i]));
		}

		String fakeTitle2 = "h3r$':>e ''';;we ' 50!!!!!";
		String[] expectedResult2 = {"h3r", "e", "we", "50"};
		String[] obtainedResult2 = Title.parseTitle(fakeTitle2);
		
		assertTrue(expectedResult2.length == obtainedResult2.length);
		for(int i = 0; i< expectedResult2.length; i++){
			//DEBUG: System.out.println("Expected: " + expectedResult2[i] + "\tGot: " + obtainedResult2[i]);
			assertTrue(expectedResult2[i].equals(obtainedResult2[i]));
		}
	}

}
