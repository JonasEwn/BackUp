package project.vacation.vacationPeriod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// DIe Methoden die für das Bearbeiten der VacationPeriod Tabelle benötigt wird

@Service
public class VacationPeriodService {

	@Autowired
	private VacationPeriodRepository vacationRepository;		// Methoden in dieser Klasse bearbeiten dieses Repository

	// Holt alle Objekte aus VacationPeriodRepository und gibt diese aus
	public List<VacationPeriod> getVacationPeriodList() {
		ArrayList<VacationPeriod> vacationList = new ArrayList<>();
		Iterator<VacationPeriod> itVacation = vacationRepository.findAll().iterator();
		while (itVacation.hasNext())
			vacationList.add(itVacation.next());
		return vacationList;
	}

	// Gibt VacationPeriod mit ausgewälter id aus. Wenn keine gefunden wird nichts
	public VacationPeriod getVacation(String title) {
		return vacationRepository.findById(title).orElse(null);
	}

	// Fügt neue VacationPeriod hinzu
	public void addVacation(VacationPeriod vacationPeriod) {
		vacationRepository.save(vacationPeriod);
	}

	//Lässt den Benutzer VacationPeriod bearbeiten
	public void updateVacation(String titel, VacationPeriod vacationPeriod) {
		vacationRepository.save(vacationPeriod);
	}

	// Lässt den Benutzer VacationPeriod löschen
	public void deleteVacation(String vacationId) {
		vacationRepository.deleteById(vacationId);
	}

}