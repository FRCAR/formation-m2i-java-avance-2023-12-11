package com.bigcorp.project.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bigcorp.project.main.correction.Child;

public class ChildTest {

	@Test
	public void testJoueAPierreFeuilleCiseaux() {
		//Arrange
		Child c1 = new Child("Jeannot", 10);
		Child c2 = new Child("Jeannette", 11);
		
		//Act
		Child vainqueur = c1.joueAPierreFeuilleCiseaux(c2);
		
		//Assert
		Assertions.assertNotNull(vainqueur);
		
		float f = 1/3f - 1/2f;
		Assertions.assertEquals(-1/6f, f);
		
		
		
	}
	
}
