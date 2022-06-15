package project.vacation.rating;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VacationRatingKey implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "familyMember_id")
	String familyMemberId;
	
	@Column(name = "vacationWish_vacationWishId")
	String vacationWishVacationWishId;

	
	public VacationRatingKey(String familyMemberId, String vacationWishVacationWishId) {
		super();
		this.familyMemberId = familyMemberId;
		this.vacationWishVacationWishId = vacationWishVacationWishId;
	}

	public String getFamilyMemberId() {
		return familyMemberId;
	}

	public void setFamilyMemberId(String familyMemberId) {
		this.familyMemberId = familyMemberId;
	}

	public String getVacationWishVacationWishId() {
		return vacationWishVacationWishId;
	}

	public void setVacationWishVacationWishId(String vacationWishVacationWishId) {
		this.vacationWishVacationWishId = vacationWishVacationWishId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(familyMemberId, vacationWishVacationWishId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VacationRatingKey other = (VacationRatingKey) obj;
		return Objects.equals(familyMemberId, other.familyMemberId)
				&& Objects.equals(vacationWishVacationWishId, other.vacationWishVacationWishId);
	}
	
}
