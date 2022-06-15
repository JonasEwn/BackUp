package project.vacation.vacationPeriod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationPeriodService {

	@Autowired
	private VacationPeriodRepository vacationRepository;

	public List<VacationPeriod> getVacationPeriodList() {
		ArrayList<VacationPeriod> vacationList = new ArrayList<>();
		Iterator<VacationPeriod> itVacation = vacationRepository.findAll().iterator();
		while (itVacation.hasNext())
			vacationList.add(itVacation.next());
		return vacationList;
	}

	public VacationPeriod getVacation(String title) {
		return vacationRepository.findById(title).orElse(null);
	}

	public void addVacation(VacationPeriod vacationPeriod) {
		vacationRepository.save(vacationPeriod);
	}

	public void updateVacation(String titel, VacationPeriod vacationPeriod) {
		vacationRepository.save(vacationPeriod);
	}

	public void deleteVacation(String vacationId) {
		vacationRepository.deleteById(vacationId);
	}

	// public List<VacationPeriod> getAllVacationPeriodsOfZeitraum

}