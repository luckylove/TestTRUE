package com.trues;


import com.trues.service.TRUEDBService;
import com.trues.webservice.service.TRUEWService;
import org.codehaus.jackson.map.ObjectMapper;
import th.co.tit.ccbint.mcp.webservices.SearchAllCustomerProfile;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * User: son.nguyen
 * Date: 11/3/13
 * Time: 6:47 PM
 */
public class DBService {

    protected static ObjectMapper mapper = new ObjectMapper();

    public static void testWebService(Scanner scanner) throws Exception {

        Utils.clearConsole();
        System.out.println("===================     TRUE Web Service  =====================");
        System.out.println("===================     1. GetQemRoute ");



        System.out.println("Please Select: ");
        String service = scanner.nextLine();
        if ("1".equals(service)) {
            GetQemRoute(scanner);
        }  else {
            MainClass.mainMenu(scanner);
        }
    }
    public static void GetQemRoute(Scanner scanner) throws Exception {

        Utils.clearConsole();
        System.out.println("===================     1. GetQemRoute    =====================");
        System.out.println("Please input param (product  - string): ");
        String product = scanner.nextLine();
        if ("".equals(product)) {
            product = null;
        }

        System.out.println("Please input param (grading  - string): ");
        String grading = scanner.nextLine();
        if ("".equals(grading)) {
            grading = null;
        }

        System.out.println("Please input param (subject  - string): ");
        String subject = scanner.nextLine();
        if ("".equals(subject)) {
            subject = null;
        }

        TRUEDBService.GetQemRoute(MainClass.SESSIONID, product, grading, subject);
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }


}
