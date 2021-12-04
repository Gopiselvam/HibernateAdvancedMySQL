package inheritance.joined;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ORNAMENTAL_PLANT_JOINED")
public class OrnamentalPlantEntity extends PlantEntity {

	private String flowerColor;

	public OrnamentalPlantEntity() {
	}

	public OrnamentalPlantEntity(String plantname, String kind, String flowerColor) {
		super(plantname, kind);
		this.flowerColor = flowerColor;
	}

	public String getFlowerColor() {
		return flowerColor;
	}

	public void setFlowerColor(String flowerColor) {
		this.flowerColor = flowerColor;
	}

	@Override
	public String toString() {
		return "OrnamentalPlantEntity{" +
				"plantName'"+ super.getPlantName() + '\'' +"\t"+
				"plantKind'"+ super.getKind() + '\'' +"\t"+
				"flowerColor='" + flowerColor + '\'' +
				'}';
	}
}
