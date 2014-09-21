package com.trues;

import com.trues.service.TRUEDBService;
import com.trues.webservice.service.TRUEWService;

import java.util.Scanner;

/**
 * User: son.nguyen
 * Date: 11/2/13
 * Time: 3:48 PM
 */
public class MainClass {


    public static final String SESSIONID = "aa123aaaaaaa123468";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        mainMenu(scanner);
    }

    public static void mainMenu(Scanner scanner) throws Exception {
        System.out.println("===================     TRUE Testing function    =====================");
        System.out.println("===================     1. Web Service   =====================");
        System.out.println("===================     2. DB Service   =====================");
        System.out.println("Please Select: ");
        String service = scanner.nextLine();
        if ("1".equals(service)) {
            //init AIS service
            TRUEWService.initService();
            WebService.testWebService(scanner);
        } else if ("2".equals(service)) {
            //init AIS service
            TRUEDBService.initService();
            DBService.testWebService(scanner);
        }  else {
            System.exit(0);
        }
    }


}
