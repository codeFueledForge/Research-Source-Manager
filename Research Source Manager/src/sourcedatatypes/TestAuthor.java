package sourcedatatypes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAuthor {

	@Test
	public void testCompareTo() {
		Author a1 = new Author("Mr.", "Test");
		
		//equivalent authors
		assertTrue(a1.compareTo(a1) == 0);
		
		//The second author has no name: Vacuously True
		assertTrue(a1.compareTo(new Author(null, null)) == 1);	
		
		//a1 has 1 name match, and the other name of the second author is empty
		assertTrue(a1.compareTo(new Author("Mr.", null)) == 1);
		assertTrue(a1.compareTo(new Author(null, "Test")) == 1);
		
		
		//a1 has at least 1 mismatch with the other author
		assertTrue(a1.compareTo(new Author("Mr.", "fail")) == -1);
		assertTrue(a1.compareTo(new Author("fail", "Test")) == -1);
		assertTrue(a1.compareTo(new Author("fail", "fail")) == -1);
		
	}

}
