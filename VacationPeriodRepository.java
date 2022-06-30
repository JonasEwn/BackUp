package project.vacation.vacationPeriod;

import org.springframework.data.repository.CrudRepository;

//Speichert die VacationPeriod Tabelle

public interface VacationPeriodRepository extends CrudRepository<VacationPeriod, String> {

}
