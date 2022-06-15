package project.vacation.vacationWish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationWishService {

	@Autowired
	private VacationWishRepository vacationWishRepository;
	
	public List<VacationWish>getVacationWishList(){
		ArrayList<VacationWish> VacationWishList = new ArrayList<>();
		Iterator<VacationWish> itVacationWish = vacationWishRepository.findAll().iterator();
		while (itVacationWish.hasNext())
			VacationWishList.add(itVacationWish.next());
		return VacationWishList;
	}
	
	public VacationWish getVacationWish(String vacationWishId) {
		
		return vacationWishRepository.findById(vacationWishId).orElse(null);
	}
	
	public void addVacationWish(VacationWish vacationWish) {
		
		vacationWishRepository.save(vacationWish);
	}
	
	public void updateVacationWish(String vacationWishId, VacationWish vacationWish) {
		  
		vacationWishRepository.save(vacationWish);
	}
	  
	public void deleteVacationWish(String vacationWishId) {
	    
		vacationWishRepository.deleteById(vacationWishId);
	}
}