package project.vacation.rating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationRatingController {

	@Autowired
	VacationRatingService vacationRatingService;
	
	@RequestMapping("/VacationRating")
	public List<VacationRating> getVacationRatingList(){
		return vacationRatingService.getVacationRatingList();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/VacationRating")
	public void addVacationRating(@RequestBody VacationRatingObjekt vacationRatingObjekt) {
		vacationRatingService.addVacationRating(vacationRatingObjekt);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/VacationRating/{rating}")
	public void updateVacationRating(@PathVariable int rating, @RequestBody VacationRating vacationRating) {
		vacationRatingService.updateVacationRating(rating, vacationRating);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/VacationRating/{rating}")
	public void deleteVacationRating(@PathVariable VacationRatingKey vacationRatingKey) {
		vacationRatingService.deleteVacationRating(vacationRatingKey);
	}
}
