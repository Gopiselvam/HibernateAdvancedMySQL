package criteriaAPI.movieEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIES_CRITERIA")
public class MovieEntity {

	@Id
	private String movieId;
	private String movieName;
	private String language;
	private Integer releasedIn;
	private Integer revenueInDollars;

	public MovieEntity() {
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getReleasedIn() {
		return releasedIn;
	}

	public void setReleasedIn(Integer releasedIn) {
		this.releasedIn = releasedIn;
	}

	public Integer getRevenueInDollars() {
		return revenueInDollars;
	}

	public void setRevenueInDollars(Integer revenueInDollars) {
		this.revenueInDollars = revenueInDollars;
	}

	@Override
	public String toString() {
		return "MovieEntity{" +
				"movieId='" + movieId + '\'' +
				", movieName='" + movieName + '\'' +
				", language='" + language + '\'' +
				", releasedIn=" + releasedIn +
				", revenueInDollars=" + revenueInDollars +
				'}';
	}
}
