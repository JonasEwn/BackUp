package project.vacation.rating;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import project.vacation.familyMember.FamilyMember;
import project.vacation.vacationWish.VacationWish;

@Entity
public class VacationRating {

	@EmbeddedId		//Zusammengesetzte id der n-zu-m Beziehung
	VacationRatingKey id;
	
	// 1-zu-m Beziehung zu der Tabelle FamilyMemeber
	@ManyToOne	
	@MapsId("id")	//Wählt FamilyMember nach id aus
	@JoinColumn(name = "id")	//id aus FamilyMember
	FamilyMember familyMember;
	
	// 1-zu-m Beziehung zu der Tabelle VacationWish
	@ManyToOne
	@MapsId("vacationWishId")	//Wählt VacationWish nach vacationWishId aus
	@JoinColumn(name = "vacation_wish_id")		//id aus VacationWish
	VacationWish vacationWish;
	
	int rating;	//Composite Key
	
	public VacationRating() {
		
	}

	public VacationRating(VacationRatingKey id, FamilyMember familyMember, VacationWish vacationWish, int rating) {
		super();
		this.id = id;
		this.familyMember = familyMember;
		this.vacationWish = vacationWish;
		this.rating = rating;
	}

	public VacationRatingKey getId() {
		return id;
	}

	public void setId(VacationRatingKey id) {
		this.id = id;
	}

	public FamilyMember getFamilyMember() {
		return familyMember;
	}

	public void setFamilyMember(FamilyMember familyMember) {
		this.familyMember = familyMember;
	}

	public VacationWish getVacationWish() {
		return vacationWish;
	}

	public void setVacationWish(VacationWish vacationWish) {
		this.vacationWish = vacationWish;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
