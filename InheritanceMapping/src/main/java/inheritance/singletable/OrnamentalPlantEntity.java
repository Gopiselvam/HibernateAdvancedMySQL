package inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Ornamental plant")
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
