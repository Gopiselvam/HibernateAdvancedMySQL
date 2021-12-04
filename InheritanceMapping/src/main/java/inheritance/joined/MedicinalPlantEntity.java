package inheritance.joined;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICINE_PLANT_JOINED")
public class MedicinalPlantEntity extends PlantEntity {

	private String usefulPart;

	public MedicinalPlantEntity() {
	}

	public MedicinalPlantEntity(String plantname, String kind, String usefulPart) {
		super(plantname, kind);
		this.usefulPart = usefulPart;
	}

	public String getUsefulPart() {
		return usefulPart;
	}

	public void setUsefulPart(String usefulPart) {
		this.usefulPart = usefulPart;
	}

	@Override
	public String toString() {
		return "MedicinalPlantEntity{" +
				"plantName'"+ super.getPlantName() + '\'' +"\t" +
				"plantKind'"+ super.getKind() + '\'' +"\t"+
				"usefulPart='" + usefulPart + '\'' +
				'}';
	}
}
