package project.vacation.familyMember;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import project.vacation.rating.VacationRating;
import project.vacation.vacationWish.VacationWish;

@Entity
public class FamilyMember {

	@Id
	private String id;
	private String name;
	private String birthdate;
	
	@ManyToMany
	@JoinTable(
			name = "vacationWish_like",
			joinColumns = @JoinColumn(name = "familyMember_id"),
			inverseJoinColumns = @JoinColumn(name = "vacationWish_vacationWishId"))
	Set<VacationWish> favouriteVacation;
	
	@OneToMany(mappedBy = "familyMembers")
	Set<VacationRating> ratings;
	
	public Set<VacationWish> getFavouriteVacation() {
		return favouriteVacation;
	}

	public void setFavouriteVacation(Set<VacationWish> favouriteVacation) {
		this.favouriteVacation = favouriteVacation;
	}
	//-------------------------------------------------------

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