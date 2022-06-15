package project.vacation.vacationWish;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import project.vacation.familyMember.FamilyMember;

@Entity
public class VacationWish {

	@Id
	private String vacationWishId;
	private String description;
	private String place;
	
	@ManyToMany(mappedBy = "favouriteVacation")
	Set<FamilyMember> likes;
	
	@OneToMany(mappedBy = "vacationWishes")
	Set<VacationWish> ratings;

	public Set<FamilyMember> getLikes() {
		return likes;
	}

	public void setLikes(Set<FamilyMember> likes) {
		this.likes = likes;
	}
	//-------------------------------------------------------

	public VacationWish() {
		// TODO Auto-generated constructor stub
	}
	
	public VacationWish(String description, String place, String vacationWishId) {
		
		super();
		this.vacationWishId = vacationWishId;
		this.description =  description;
		this.place = place;
	}

	public String getVacationWishId() {
		return vacationWishId;
	}

	public void setVacationWishId(String vacationWishId) {
		this.vacationWishId = vacationWishId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
}