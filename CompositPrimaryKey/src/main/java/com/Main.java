package com;

import com.botanicalnames.idclass.BotanicalNames;
import com.botanicalnames.idclass.BotanicalNamesService;

public class Main {

    private static BotanicalNamesService botanicalNamesService = new BotanicalNamesService();
    public static void main(String[] args) {
        HibernateUtil.initSessionFactory();
        botanicalNamesService.botanicalNamesServices();
    }
}
