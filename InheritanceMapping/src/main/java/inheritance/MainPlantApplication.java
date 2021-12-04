package inheritance;

import inheritance.singletable.PlantService;

public class MainPlantApplication {

    private static  PlantService service = new PlantService();

    public static void main(String[] args) {
        HibernateUtils.createSessionFactory();
        service.plantService();
    }
}
