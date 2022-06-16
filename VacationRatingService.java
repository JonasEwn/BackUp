package project.vacation.rating;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationRatingService {

	@Autowired
	private VacationRatingRepository vacationRatingRepository;
	
	public List<VacationRating> getVacationRatingList(){
		ArrayList<VacationRating> RatingList = new ArrayList<>();
		Iterator<VacationRating> itRating = vacationRatingRepository.findAll().iterator();
		while (itRating.hasNext())
			RatingList.add(itRating.next());
		return RatingList;
	}
	
	public VacationRating getVacationRating(int rating) {
		return vacationRatingRepository.findById(rating).orElse(null);
	}
	
	public void addVacationRating(VacationRating vacationRating) {
		vacationRatingRepository.save(vacationRating);
	}
	
	public void updateVacationRating(int rating, VacationRating vacationRating) {
		vacationRatingRepository.save(vacationRating);
	}
	
	public void deleteVacationRating(int rating) {
		vacationRatingRepository.deleteById(rating);
	}
}
