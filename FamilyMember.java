package project.vacation.familyMember;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import project.vacation.rating.VacationRating;

@Entity
public class FamilyMember {

	@Id
	private String id;
	private String name;
	private String birthdate;
	
	@OneToMany(mappedBy = "familyMember")
	@JsonIgnore
	Set<VacationRating> ratings;
	
	public FamilyMember() {
		
	}
	
	public FamilyMember(String name, String birthdate, String id) {
		
		super();
		this.birthdate = birthdate;
		this.id = id;
		this.name = name;
		
	}
	
	// N -to-M Relationship erstellen

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