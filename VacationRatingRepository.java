package project.vacation.rating;

import org.springframework.data.repository.CrudRepository;

// HIer wird das rating und alle dafür benötigten Werte gespeichert

public interface VacationRatingRepository extends CrudRepository<VacationRating, VacationRatingKey>{

}
