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
	@MapsId("familyMember_id")
	@JoinColumn(name = "familyMember_id")
	FamilyMember familyMembers; // Könnte zu Problemen führen, da wir diesen namen schon in FamilyMemberService verwenden
	
	@ManyToOne
	@MapsId("vacationWish_vacationWishId")
	@JoinColumn(name = "vacationWish_vacationWishId")
	VacationWish vacationWishes;  // Gleiche Problem wie bei familyMember
	
	int rating;

	public VacationRating(VacationRatingKey id, FamilyMember familyMembers, VacationWish vacationWishes, int rating) {
		super();
		this.id = id;
		this.familyMembers = familyMembers;
		this.vacationWishes = vacationWishes;
		this.rating = rating;
	}

	public VacationRatingKey getId() {
		return id;
	}

	public void setId(VacationRatingKey id) {
		this.id = id;
	}

	public FamilyMember getFamilyMember() {
		return familyMembers;
	}

	public void setFamilyMember(FamilyMember familyMembers) {
		this.familyMembers = familyMembers;
	}

	public VacationWish getVacationWish() {
		return vacationWishes;
	}

	public void setVacationWish(VacationWish vacationWishes) {
		this.vacationWishes = vacationWishes;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
