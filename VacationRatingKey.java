package project.vacation.rating;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VacationRatingKey implements Serializable{

	//Ist nicht unbedingt notwendig
		private static final long serialVersionUID = 1L;

		@Column(name = "id")
		String id;
		
		@Column(name = "vacation_wish_id")
		String vacationWishId;
		
		public VacationRatingKey() {
			
		}

		public VacationRatingKey(String id, String vacationWishId) {
			super();
			this.id = id;
			this.vacationWishId = vacationWishId;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getVacationWishId() {
			return vacationWishId;
		}

		public void setVacationWishId(String vacationWishId) {
			this.vacationWishId = vacationWishId;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, vacationWishId);
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
			return Objects.equals(id, other.id) && Objects.equals(vacationWishId, other.vacationWishId);
		}
}
