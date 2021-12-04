package inheritance.singletable;

import javax.persistence.*;

@Entity
@Table(name="plantinheritance")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="planttype")
public class PlantEntity {
	@Id
	private String plantName;
	private String kind;

	public PlantEntity() {
	}

	public PlantEntity(String plantname, String kind) {
		this.plantName = plantname;
		this.kind = kind;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "PlantEntity{" +
				"plantName='" + plantName + '\'' +
				", kind='" + kind + '\'' +
				'}';
	}
}
