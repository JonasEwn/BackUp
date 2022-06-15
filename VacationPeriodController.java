package project.vacation.vacationPeriod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationPeriodController {

	@Autowired
	VacationPeriodService vacationService;
	
	@RequestMapping("/Vacation")
	public List<VacationPeriod> getVacation(){
		return vacationService.getVacationPeriodList();
	}
	
	@RequestMapping("/Vacation/{vacationId}")
	public VacationPeriod getVacation(@PathVariable String vacationId) {
		return vacationService.getVacation(vacationId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Vacation")
	public void addVaction(@RequestBody VacationPeriod vacation) {
		vacationService.addVacation(vacation);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Vacation/{vacationId}")
	public void updateVacation(@PathVariable String vacationId, @RequestBody VacationPeriod vacation) {
		vacationService.updateVacation(vacationId, vacation);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Vacation/{vacationId}")
	public void deleteVacation(@PathVariable String vacationId) {
		vacationService.deleteVacation(vacationId);
	}
}
