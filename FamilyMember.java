package project.vacation.familyMember;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import project.vacation.rating.VacationRating;

// Klasse erstellt die Tabelle FamilyMember

@Entity
public class FamilyMember {

	// Attribute der Tabelle FamilyMember
	@Id		// Legt Primärschlüssel fest
	private String id;
	private String name;
	private String birthdate;
	
	@OneToMany(mappedBy = "familyMember")	// Die m-zu-n Beziehung aufgeteilt in zwei 1-zu-n Beziehungen
	@JsonIgnore		//Verhindert Rekursion
	Set<VacationRating> ratings;
	
	public FamilyMember() {
		
	}
	
	public FamilyMember(String name, String birthdate, String id) {
		
		super();
		this.birthdate = birthdate;
		this.id = id;
		this.name = name;
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}