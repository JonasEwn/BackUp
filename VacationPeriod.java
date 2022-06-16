package project.vacation.vacationPeriod;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import project.vacation.vacationWish.VacationWish;

@Entity
public class VacationPeriod {

	@Id
	private String vacationId;
	private String title;
	private String timePeriod;
	
	@OneToMany(mappedBy = "vacationFinal")
	private Set<VacationWish> vacations;
	
	public VacationPeriod() {
		// TODO Auto-generated constructor stub
	}

	public VacationPeriod(String vacationId, String title, String timePeriod, Set<VacationWish> vacations) {
		super();
		this.vacationId = vacationId;
		this.title = title;
		this.timePeriod = timePeriod;
		this.vacations = vacations;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVacationId() {
		return vacationId;
	}

	public void setVacationId(String vacationId) {
		this.vacationId = vacationId;
	}

	public String getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}

	public Set<VacationWish> getVacations() {
		return vacations;
	}

	public void setVacations(Set<VacationWish> vacations) {
		this.vacations = vacations;
	}
	
	
}