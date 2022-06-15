package project.vacation.vacationWish;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import project.vacation.rating.VacationRating;

@Entity
public class VacationWish {

	@Id
	private String vacationWishId;
	private String description;
	private String place;
	
	@OneToMany(mappedBy = "vacationWish")
	Set<VacationRating> ratings;

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