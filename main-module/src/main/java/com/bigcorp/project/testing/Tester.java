package com.bigcorp.project.testing;

public class Tester {
	
	public void exception(boolean b) {
		if(b) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

}
