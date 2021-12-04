package inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Medicinal plant")
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
