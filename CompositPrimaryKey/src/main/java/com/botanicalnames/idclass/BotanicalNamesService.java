package com.botanicalnames.idclass;

import com.ConfigParser;
import com.alibaba.fastjson.JSON;

import java.util.List;

public class BotanicalNamesService {

    private final static String filePathBotanicalName = "src/main/resources/inputBotanicalName.json";

    private BotanicalDao botanicalDao = new BotanicalDao();

    public void botanicalNamesServices() {
        addBotanicalNames();

    }

    private void addBotanicalNames() {

        List<BotanicalNames> list = ConfigParser.parseJsonArray(filePathBotanicalName, BotanicalNames.class);
        botanicalDao.addBotanicalNames(list);

    }
}
