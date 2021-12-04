package inheritance;

import inheritance.joined.PlantServiceJoined;
import inheritance.singletable.PlantServiceSingleTable;
import inheritance.tableperclass.PlantDaoTablePerClass;
import inheritance.tableperclass.PlantServiceTablePerClass;

public class MainPlantApplication {

    private static PlantServiceSingleTable serviceSingleTable = new PlantServiceSingleTable();
    private static PlantServiceJoined serviceJoined = new PlantServiceJoined();
    private static PlantServiceTablePerClass tablePerClass = new PlantServiceTablePerClass();

    public static void main(String[] args) {
        HibernateUtils.createSessionFactory();
//        serviceSingleTable.plantService();
//        serviceJoined.plantService();
        tablePerClass.plantService();
    }
}
