package inheritance;

import inheritance.joined.PlantServiceJoined;
import inheritance.singletable.PlantServiceSingleTable;

public class MainPlantApplication {

    private static PlantServiceSingleTable serviceSingleTable = new PlantServiceSingleTable();
    private static PlantServiceJoined serviceJoined = new PlantServiceJoined();

    public static void main(String[] args) {
        HibernateUtils.createSessionFactory();
//        serviceSingleTable.plantService();
        serviceJoined.plantService();
    }
}
