package project.vacation.vacationWish;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import project.vacation.rating.VacationRating;
import project.vacation.vacationPeriod.VacationPeriod;

//Klasse erstellt die Tabelle VacationWish

@Entity
public class VacationWish {

	// Attribute der Tabelle VacationWish
	@Id		// Legt Primärschlüssel fest
	private String vacationWishId;
	private String description;
	private String place;
	
	@OneToMany(mappedBy = "vacationWish")// Die m-zu-n Beziehung aufgeteilt in zwei 1-zu-n Beziehungen
	@JsonIgnore		//Verhindert Rekursion
	Set<VacationRating> ratings;
	
	@ManyToOne	// 1-zu-m Beziehung zu VacationPeriod
	@JoinColumn(name = "vacationId")
	private VacationPeriod vacationFinal;
	
	public VacationWish() {
		// TODO Auto-generated constructor stub
	}
	

	public VacationWish(String vacationWishId, String description, String place, Set<VacationRating> ratings,
			VacationPeriod vacationFinal) {
		super();
		this.vacationWishId = vacationWishId;
		this.description = description;
		this.place = place;
		this.ratings = ratings;
		this.vacationFinal = vacationFinal;
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


	public Set<VacationRating> getRatings() {
		return ratings;
	}


	public void setRatings(Set<VacationRating> ratings) {
		this.ratings = ratings;
	}


	public VacationPeriod getVacationFinal() {
		return vacationFinal;
	}


	public void setVacationFinal(VacationPeriod vacationFinal) {
		this.vacationFinal = vacationFinal;
	}
}