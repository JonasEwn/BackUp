package project.vacation.vacationPeriod;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import project.vacation.vacationWish.VacationWish;

// Klasse erstellt die Tabelle VacationPEriod

@Entity
public class VacationPeriod {

	// Attribute der Tabelle FamilyMember
	@Id		// Legt Primärschlüssel fest
	private String vacationId;
	private String title;
	private String timePeriod;
	
	@OneToMany(mappedBy = "vacationFinal")	//1-zu-n Beziehung zu VacationWish
	private Set<VacationWish> vacations;
	
	public VacationPeriod() {
		
	}

	public VacationPeriod(String vacationId, String title, String timePeriod) {
		super();
		this.vacationId = vacationId;
		this.title = title;
		this.timePeriod = timePeriod;
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
}