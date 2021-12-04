package inheritance.tableperclass;

import javax.persistence.*;

@Entity
@Table(name="PLANT_TABLEPERCLASS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
