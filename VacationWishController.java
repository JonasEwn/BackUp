package project.vacation.vacationWish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Klasse beinhaltet die Controller für die VacationWish Tabelle

@RestController
public class VacationWishController {

	@Autowired
	VacationWishService vacationWishService;
	
	@RequestMapping("/VacationWish")
	public List<VacationWish> getVacationWish(){
		return vacationWishService.getVacationWishList();
	}
	
	@RequestMapping("/VacationWish/{vacationWishId}")
	public VacationWish getVacationWish(@PathVariable String vacationWishId) {
		return vacationWishService.getVacationWish(vacationWishId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/VacationWish")
	public void addVacationWish(@RequestBody VacationWish vacationWish) {
		vacationWishService.addVacationWish(vacationWish);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/VacationWish/{vacationWishId}")
	public void updateVacationWish(@PathVariable String vacationWishId, @RequestBody VacationWish vacationWish) {
		vacationWishService.updateVacationWish(vacationWishId, vacationWish);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/VacationWish/{vacationWishId}")
	public void deleteVacationWish(@PathVariable String vacationWishId) {
		vacationWishService.deleteVacationWish(vacationWishId);
	}
}