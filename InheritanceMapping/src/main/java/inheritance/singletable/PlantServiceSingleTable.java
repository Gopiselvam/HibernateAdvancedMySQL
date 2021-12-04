package inheritance.singletable;

import java.util.Scanner;

public class PlantServiceSingleTable {

    private PlantsDaoSingleTable dao = new PlantsDaoSingleTable();
    private Scanner sc = new Scanner(System.in);
    public void plantService(){

        while(true){
            System.out.println("press \n1 to add plants\n2 to get plants");
            int input = sc.nextInt();
            sc.nextLine();
            if(1 == input){
                addPlant();
            }else if(2 == input){
                getPlant();
            }else{
                System.out.println("Exiting application");
                break;
            }

        }

    }

    private void addPlant() {
        System.out.println("Enter plant name");
        String plantName = sc.nextLine();
        System.out.println("Enter planet kind");
        String plantKind = sc.nextLine();
        System.out.println("press 1: medicinal plant, 2: ornamental plant");
        int medororn = sc.nextInt();
        sc.nextLine();
        PlantEntity plantEntity = null;
        switch (medororn){
            case 1:
                System.out.println("Enter the usefulPart");
                String usefulpart = sc.nextLine();
                plantEntity = new MedicinalPlantEntity(plantName, plantKind, usefulpart);
                break;
            case 2:
                System.out.println("Enter the flowerColor");
                String flowerColour = sc.nextLine();
                plantEntity = new OrnamentalPlantEntity(plantName, plantKind, flowerColour);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
        dao.addPlant(plantEntity);
        System.out.println("plant details saved successfully");

    }


    private void getPlant() {
        System.out.println("Enter the plant name");
        String plantName = sc.nextLine();

        PlantEntity plantEntity = dao.getPlant(plantName);
        if(null == plantEntity){
            System.out.println("Plant name not found");
            return;
        }
        System.out.println(plantEntity);
    }
}
