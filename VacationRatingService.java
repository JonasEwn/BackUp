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
		FamilyMember familyMember = familyMemberService.getFamilyMember(vacationRatingObjekt.getId());
		VacationWish vacationWish = vacationWishService.getVacationWish(vacationRatingObjekt.getVacationWishId());
		
		VacationRatingKey vacationRatingKey = new VacationRatingKey(familyMember.getId(), vacationWish.getVacationWishId());
		
		VacationRating vacationRating = new VacationRating(vacationRatingKey, familyMember, vacationWish, vacationRatingObjekt.getRating());
		vacationRatingRepository.save(vacationRating);
	}
	
	
	
	public void updateVacationRating(int rating, VacationRatingObjekt vacationRatingObjekt) {
		FamilyMember familyMember = familyMemberService.getFamilyMember(vacationRatingObjekt.getId());
		VacationWish vacationWish = vacationWishService.getVacationWish(vacationRatingObjekt.getVacationWishId());
		
		VacationRatingKey vacationRatingKey = new VacationRatingKey(familyMember.getId(), vacationWish.getVacationWishId());
		
		VacationRating vacationRating = new VacationRating(vacationRatingKey, familyMember, vacationWish, rating +  vacationRatingObjekt.getRating());
		//VacationRating vacationRating = new VacationRating(vacationRatingKey, familyMember, vacationWish, vacationRatingObjekt.getRating());
		vacationRatingRepository.save(vacationRating);
	}
	
	public void deleteVacationRating(VacationRatingKey vacationRatingKey) {

		vacationRatingRepository.deleteById(vacationRatingKey);
	}
}
