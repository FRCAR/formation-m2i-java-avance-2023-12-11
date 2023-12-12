package com.bigcorp.project.main.correction;

import java.time.LocalDate;

public class MonPremierRecordTester {

	public static void main(String[] args) {
		
		LocalDate now = LocalDate.now();
		MonPremierRecord monPremierRecord = new MonPremierRecord(3, "Salut", now);
		MonPremierRecord monDeuxiemeRecord = new MonPremierRecord(2, "Salut", now);
		
		System.out.println(monPremierRecord.id());
		System.out.println(monPremierRecord.name());
		System.out.println(monPremierRecord.date());
		
		System.out.println(monPremierRecord.toString());
		
		System.out.println("monPremierRecord == monDeuxiemeRecord ? : " + (monPremierRecord == monDeuxiemeRecord));
		System.out.println("monPremierRecord.equals(monDeuxiemeRecord) ? : " + (monPremierRecord.equals(monDeuxiemeRecord)));
		
		System.out.println("hashCode du premier record : " + monPremierRecord.hashCode());
		System.out.println("hashCode du deuxieme record : " + monDeuxiemeRecord.hashCode());
		
	}

}
