package com;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigParser {

    public static <T> List<T> parseJsonArray(String filePath, Class<T> className) {

        try {
            String jsonStr = FileUtils.readFileToString(new File(filePath));
            return JSON.parseArray(jsonStr, className);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(0);
    }
}
