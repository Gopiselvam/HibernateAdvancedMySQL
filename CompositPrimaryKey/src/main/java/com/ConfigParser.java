package com;

import com.alibaba.fastjson.JSON;
import com.customerloan.embeddedid.CustomerLoan;
import com.customerloan.embeddedid.CustomerLoanPK;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    public static List<CustomerLoan> getListFromInput(String customerLoanFilePath) {
        List<CustomerLoan> list = new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(Paths.get(customerLoanFilePath));
            lines.forEach(str -> {
                String[] arr = str.split("\\|");
                CustomerLoan loan = new CustomerLoan();
                CustomerLoanPK pk = new CustomerLoanPK();
                pk.setCustomerId(Integer.parseInt(arr[0].trim()));
                pk.setLoanId(arr[1].trim());

                loan.setCustomerLoanPK(pk);
                loan.setAvailedAmount(Double.parseDouble(arr[2].trim()));
                loan.setEligibleAmount(Double.parseDouble(arr[3].trim()));
                loan.setTenureInYears(Float.parseFloat(arr[4].trim()));

                list.add(loan);

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
