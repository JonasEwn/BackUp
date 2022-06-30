package project.vacation.rating;

//Fügt das rating zu den beiden Ids

public class VacationRatingObjekt {

	private String id;
	private String vacationWishId;
	private int rating;
	
	public VacationRatingObjekt() {
		
	}
	
	public VacationRatingObjekt(String id, String vacationWishId, int rating) {
		super();
		this.id = id;
		this.vacationWishId = vacationWishId;
		this.rating = rating;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVacationWishId() {
		return vacationWishId;
	}
	public void setVacationWishId(String vacationWishId) {
		this.vacationWishId = vacationWishId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = this.rating + rating;	// Zählt altes rating zu neuem hinzu
	}
	
}
