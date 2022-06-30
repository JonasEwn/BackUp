package project.vacation.rating;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.vacation.familyMember.FamilyMember;
import project.vacation.familyMember.FamilyMemberService;
import project.vacation.vacationWish.VacationWish;
import project.vacation.vacationWish.VacationWishService;

// Lässt den beutzer ratings hinzufügen

@Service
public class VacationRatingService {

	@Autowired
	VacationWishService vacationWishService;
	
	@Autowired
	FamilyMemberService familyMemberService;
	
	@Autowired
	private VacationRatingRepository vacationRatingRepository;
	
	
	public List<VacationRating> getVacationRatingList(){
		ArrayList<VacationRating> RatingList = new ArrayList<>();
		Iterator<VacationRating> itRating = vacationRatingRepository.findAll().iterator();
		while (itRating.hasNext())
			RatingList.add(itRating.next());
		return RatingList;
	}
	
	public VacationRating getVacationRating(VacationRatingKey vacationRatingKey) {
		return vacationRatingRepository.findById(vacationRatingKey).orElse(null);
	}
	
	public void addVacationRating(VacationRatingObjekt vacationRatingObjekt) {
		FamilyMember familyMember = familyMemberService.getFamilyMember(vacationRatingObjekt.getId());		// Nimmt den FamilyMember mit der eingegebenen id
		VacationWish vacationWish = vacationWishService.getVacationWish(vacationRatingObjekt.getVacationWishId());	// Nimmt den VacationWish mit der eingegebenen id
		
		VacationRatingKey vacationRatingKey = new VacationRatingKey(familyMember.getId(), vacationWish.getVacationWishId());	// Erstelltt neuen KEy aus den beiden ids
		
		VacationRating vacationRating = new VacationRating(vacationRatingKey, familyMember, vacationWish, vacationRatingObjekt.getRating());	// Erstellt neues rating aus dem Key und dem rating
		vacationRatingRepository.save(vacationRating);
	}
	
	
	
	public void updateVacationRating(int rating, VacationRatingObjekt vacationRatingObjekt) {
		FamilyMember familyMember = familyMemberService.getFamilyMember(vacationRatingObjekt.getId());	// Nimmt den FamilyMember mit der eingegebenen id
		VacationWish vacationWish = vacationWishService.getVacationWish(vacationRatingObjekt.getVacationWishId());	// Nimmt den VacationWish mit der eingegebenen id
		
		VacationRatingKey vacationRatingKey = new VacationRatingKey(familyMember.getId(), vacationWish.getVacationWishId());	// Erstelltt neuen KEy aus den beiden ids
		
		VacationRating vacationRating = new VacationRating(vacationRatingKey, familyMember, vacationWish, rating +  vacationRatingObjekt.getRating());// Erstellt neues rating aus dem Key und dem rating und fügt es dem alten rating hinzu
		//VacationRating vacationRating = new VacationRating(vacationRatingKey, familyMember, vacationWish, vacationRatingObjekt.getRating());
		vacationRatingRepository.save(vacationRating);
	}
	
	public void deleteVacationRating(VacationRatingKey vacationRatingKey) {
;
		vacationRatingRepository.deleteById(vacationRatingKey);
	}
}
