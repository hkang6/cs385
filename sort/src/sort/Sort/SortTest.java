package sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {

	@Test
	public void testsort() {
		Integer[] a = {1, 4, 34, 5, 2, 7};
		Integer[] b = {5, 3, 33, 9, 2, 73};
		Integer[] c = {2, 34, 234, 59, 10, 7};
		Sort.sort(a);
		Sort.sort(b);
		Sort.sort(c);
		Integer[] d = {1, 2, 4, 5, 7, 34};
		Integer[] e = {2, 3, 5, 9, 33, 73};
		Integer[] f = {2, 7, 10, 34, 59, 234};
		assertArrayEquals(a,d);
		assertArrayEquals(b,e);
		assertArrayEquals(c,f);
		
	
	}

	

}
