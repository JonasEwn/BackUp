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

	@EmbeddedId
	VacationRatingKey id;
	
	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "id")
	FamilyMember familyMember;
	
	@ManyToOne
	@MapsId("vacationWishId")
	@JoinColumn(name = "vacation_wish_id")
	VacationWish vacationWish;
	
	int rating;

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
