package hibernatecache;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOUR_ENTITY")
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
public class TourEntity {
	@Id
	private String tripId;
	private String tripFrom;
	private String tripTo;
	private Integer days;
	private Integer tripFare;
	private Integer headCount;

	public TourEntity() {
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	public String getTripFrom() {
		return tripFrom;
	}

	public void setTripFrom(String tripFrom) {
		this.tripFrom = tripFrom;
	}

	public String getTripTo() {
		return tripTo;
	}

	public void setTripTo(String tripTo) {
		this.tripTo = tripTo;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Integer getTripFare() {
		return tripFare;
	}

	public void setTripFare(Integer tripFare) {
		this.tripFare = tripFare;
	}

	public Integer getHeadCount() {
		return headCount;
	}

	public void setHeadCount(Integer headCount) {
		this.headCount = headCount;
	}

	@Override
	public String toString() {
		return "TourEntity{" +
				"tripId='" + tripId + '\'' +
				", tripFrom='" + tripFrom + '\'' +
				", tripTo='" + tripTo + '\'' +
				", days=" + days +
				", tripFare=" + tripFare +
				", headCount=" + headCount +
				'}';
	}
}
