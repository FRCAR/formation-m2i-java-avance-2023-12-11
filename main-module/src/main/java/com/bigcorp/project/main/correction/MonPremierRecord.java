package com.bigcorp.project.main.correction;

import java.io.Serializable;
import java.time.LocalDate;

public record MonPremierRecord(Integer id, String name, LocalDate date) implements Serializable 
{


	
}