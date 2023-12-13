package com.bigcorp.project.main.correction;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public record RecordExercice(Integer identifiant, String nom, String prenom,
		LocalDate dateNaissance,  AutreRecord autre) {

	public void faitUnTruc() {
		System.out.println(this.identifiant * 42);
	}
	
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		RecordExercice jeanDubois = new RecordExercice(1, "Jean", "Dubois", LocalDate.of(2000, 3, 1), new AutreRecord("Jeanne"));
		System.out.println(jeanDubois.toString());
		jeanDubois.faitUnTruc();
		
		ObjectMapper objectMapper = JsonMapper.builder()
			    .addModule(new JavaTimeModule())
			    .build();
		objectMapper.writeValue(new File("jean-dubois.json"), jeanDubois);
		
		RecordExercice jeanDuFichier = objectMapper.readValue(new File("jean-dubois.json"), RecordExercice.class);
		
		System.out.println("Le fichier lu contient : " + jeanDuFichier);
		
	}
	
}