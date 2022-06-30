package project.vacation.vacationWish;

import org.springframework.data.repository.CrudRepository;

//Speichert die VacationWish Tabelle

public interface VacationWishRepository extends CrudRepository<VacationWish, String> {

}
