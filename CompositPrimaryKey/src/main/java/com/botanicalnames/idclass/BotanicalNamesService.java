package com.botanicalnames.idclass;

import com.ConfigParser;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;

public class BotanicalNamesService {

    private final static String filePathBotanicalName = "src/main/resources/inputBotanicalName.json";

    private BotanicalDao botanicalDao = new BotanicalDao();

    public void botanicalNamesServices() {
        System.out.println("Welcome to BOTANICAL GARDEN");
        int opt = 0;
        Scanner sc = new Scanner(System.in);
        String genericName = "";
        String speciesName = "";
        loop1:
        while (true) {
            System.out.printf("%n%n%8s%s%n", "press 1:", "To populate the Botanical Names table");
            System.out.printf("%8s%s%n", " 2:", "To find the species details");
            System.out.printf("%8s%s%n", " 0:", "To Exit");
            opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    addBotanicalNames();
                    break;
                case 2:
                    // Allium cepa
                    System.out.println("Enter the generic name: ");
                    genericName = sc.nextLine();
                    System.out.println("Enter the species name: ");
                    speciesName = sc.nextLine();
                    retriveBotanicalNames(genericName, speciesName);
                    break;
                default:
                    break loop1;

            }
        }
    }

    private void addBotanicalNames() {
        try {
            List<BotanicalNames> list = ConfigParser.parseJsonArray(filePathBotanicalName, BotanicalNames.class);
            botanicalDao.addBotanicalNames(list);
        } catch (Exception ex) {
            System.err.println("Table might already been populated");
        }
    }

    private void retriveBotanicalNames(String genericName, String speciesName) {
        BotanicalNames obj = botanicalDao.getPlantDetails(genericName.trim(), speciesName.trim());
        if(null == obj){
            System.err.println("No objects found");
            return;
        }
        for (Field field : obj.getClass().getDeclaredFields()) {
            System.out.printf("%20s", field.getName());
        }
        System.out.println();

        System.out.printf("%20s%20s%20s%20s%n", obj.getGenericName(), obj.getSpeciesName(), obj.getFamily(), obj.getCommonName());

    }
}
