package project.vacation.vacationPeriod;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VacationPeriod {

	@Id
	private String vacationId;
	private String title;
	private String timePeriod;
	
	public VacationPeriod() {
		// TODO Auto-generated constructor stub
	}
	
	public VacationPeriod(String title, String vacationId, String timePeriod) {
		
		super();
		this.timePeriod = timePeriod;
		this.title = title;
		this.vacationId = vacationId;
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