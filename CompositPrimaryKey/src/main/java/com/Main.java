package com;

import com.botanicalnames.idclass.BotanicalNamesService;
import com.customerloan.embeddedid.CustomerLoanService;

import java.util.Scanner;

public class Main {

    private static BotanicalNamesService botanicalNamesService = new BotanicalNamesService();
    private static CustomerLoanService customerLoanService = new CustomerLoanService();

    public static void main(String[] args) {

        HibernateUtil.initSessionFactory();
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        loop1:
        while (true) {
            System.out.printf("%n%n%8s%s%n", "press 1:", "for Botanical Garden Services");
            System.out.printf("%8s%s%n", " 2:", "for Customer loan services");
            System.out.printf("%8s%s%n", " 0:", "To Exit");
            opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    botanicalNamesService.botanicalNamesServices();
                    break;
                case 2:
                    customerLoanService.customerLoanService();
                    break;
                default:
                    break loop1;

            }
        }
    }
}
