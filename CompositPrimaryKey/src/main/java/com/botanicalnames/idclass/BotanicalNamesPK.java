package com.botanicalnames.idclass;

import javax.persistence.Id;
import java.io.Serializable;

public class BotanicalNamesPK implements Serializable {

    private String genericName;

    private String speciesName;

    public BotanicalNamesPK(String genericName, String speciesName) {
        System.out.println("using BotanicalNamesPK consturcutor");
        this.genericName = genericName;
        this.speciesName = speciesName;
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
}
