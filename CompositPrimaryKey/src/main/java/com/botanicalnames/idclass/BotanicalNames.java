package com.botanicalnames.idclass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(BotanicalNamesPK.class)
public class BotanicalNames {

	@Id
	private String genericName;
	@Id
	private String speciesName;
	private String family;
	private String commonName;

	public BotanicalNames() {
	}

	public BotanicalNames(String genericName, String speciesName, String family, String commonName) {
		this.genericName = genericName;
		this.speciesName = speciesName;
		this.family = family;
		this.commonName = commonName;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
}
