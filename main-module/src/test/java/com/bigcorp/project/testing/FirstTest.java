package com.bigcorp.project.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.project.main.correction.Child;

public class FirstTest {
	

	@Test
	public void test1() {
		
		//Arrange
		int a = 4;
		int b = 3;
		
		//Act
		int c = a + b;
		
		//Assert
		Assertions.assertEquals(7, c);
		Assertions.assertEquals(3, b);
	}
	
	@Test
	public void test2() {
		Assertions.assertTrue(true);
	}
	
	@Test
	public void testException() {
		Tester tester = new Tester();
		
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> tester.exception(true));
		
		Assertions.assertDoesNotThrow(() -> tester.exception(false));
	}
	
	@Test
	public void testCarreAgeEnfant2() {
		Child c = new Child("jean", 2);
		
		int ageCarre = c.getAgeCarre();
		
		Assertions.assertEquals(4, ageCarre);
	}
	
	@Test
	public void testCarreAgeEnfant4() {
		Child c = new Child("jean", 4);
		
		int ageCarre = c.getAgeCarre();
		
		Assertions.assertEquals(16, ageCarre);
	}
	
}
