package project.vacation.vacationWish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//DIe Methoden die für das Bearbeiten der VacationWish Tabelle benötigt wird

@Service
public class VacationWishService {

	@Autowired
	private VacationWishRepository vacationWishRepository;	// Methoden in dieser Klasse bearbeiten dieses Repository
	
	// Holt alle Objekte aus VacationWishRepository und gibt diese aus
	public List<VacationWish>getVacationWishList(){
		ArrayList<VacationWish> VacationWishList = new ArrayList<>();
		Iterator<VacationWish> itVacationWish = vacationWishRepository.findAll().iterator();
		while (itVacationWish.hasNext())
			VacationWishList.add(itVacationWish.next());
		return VacationWishList;
	}
	
	// Gibt VacationWish mit ausgewälter id aus. Wenn keine gefunden wird nichts
	public VacationWish getVacationWish(String vacationWishId) {
		
		return vacationWishRepository.findById(vacationWishId).orElse(null);
	}
	
	// Fügt neue VacationWish hinzu
	public void addVacationWish(VacationWish vacationWish) {
		
		vacationWishRepository.save(vacationWish);
	}
	
	//Lässt den Benutzer VacationWish bearbeiten
	public void updateVacationWish(String vacationWishId, VacationWish vacationWish) {
		  
		vacationWishRepository.save(vacationWish);
	}
	
	// Lässt den Benutzer VacationWish löschen
	public void deleteVacationWish(String vacationWishId) {
	    
		vacationWishRepository.deleteById(vacationWishId);
	}
}