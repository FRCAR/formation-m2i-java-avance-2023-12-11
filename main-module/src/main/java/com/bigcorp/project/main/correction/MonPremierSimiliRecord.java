package com.bigcorp.project.main.correction;

import java.time.LocalDate;
import java.util.Objects;

public class MonPremierSimiliRecord {

	private final Integer id;
	private final String name;
	private final LocalDate date;

	public MonPremierSimiliRecord(Integer id, String name, LocalDate date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public Integer id() {
		return id;
	}

	public String name() {
		return name;
	}

	public LocalDate date() {
		return date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonPremierSimiliRecord other = (MonPremierSimiliRecord) obj;
		return Objects.equals(date, other.date) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
	
	

}