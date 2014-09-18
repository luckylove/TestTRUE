package com.trues;


import com.trues.webservice.service.TRUEWService;
import org.codehaus.jackson.map.ObjectMapper;
import th.co.tit.ccbint.mcp.webservices.SearchAllCustomerProfile;
import th.co.tit.ccbint.mcp.webservices.SearchTmvProfile;
import th.co.tit.ccbint.mcp.webservices.SearchTruProfile;
import th.co.tit.ccbint.mcp.webservices.SearchTvsProfile;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * User: son.nguyen
 * Date: 11/3/13
 * Time: 6:47 PM
 */
public class WebService {

    protected static ObjectMapper mapper = new ObjectMapper();

    public static void testWebService(Scanner scanner) throws Exception {

        Utils.clearConsole();
        System.out.println("===================     TRUE Web Service  =====================");
        System.out.println("===================     1. searchTmvProfile ");
        System.out.println("===================     2. searchTruProfile ");
        System.out.println("===================     3. searchTvsProfile ");
        System.out.println("===================     4. searchAllCustomerProfile ");



        System.out.println("Please Select: ");
        String service = scanner.nextLine();
        if ("1".equals(service)) {
            searchTmvProfile(scanner);
        } else if ("2".equals(service)) {
            searchTruProfile(scanner);
        }  else if ("3".equals(service)) {
            searchTvsProfile(scanner);
        }  else if ("4".equals(service)) {
            searchAllCustomerProfile(scanner);
        }  else {
            MainClass.mainMenu(scanner);
        }
    }
    public static void searchAllCustomerProfile(Scanner scanner) throws Exception {

        Utils.clearConsole();
        System.out.println("===================     4. searchAllCustomerProfile    =====================");

        SearchAllCustomerProfile log = new SearchAllCustomerProfile();
        Map<String, Object> input = new HashMap<String, Object>();
        Field[] fields = log.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(String.format("Please input param (%s  - %s): ", field.getName(), Utils.getTypeName(field.getGenericType().toString())));
            input.put(field.getName(), Utils.getNextNll(scanner, Utils.getTypeName(field.getGenericType().toString())));
        }
        Utils.map2Object(log, input);
        TRUEWService.searchAllCustomerProfile(MainClass.SESSIONID, log);
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }

    public static void searchTvsProfile(Scanner scanner) throws Exception {

        Utils.clearConsole();
        System.out.println("===================     3. searchTvsProfile    =====================");

        SearchTvsProfile log = new SearchTvsProfile();
        Map<String, Object> input = new HashMap<String, Object>();
        Field[] fields = log.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(String.format("Please input param (%s  - %s): ", field.getName(), Utils.getTypeName(field.getGenericType().toString())));
            input.put(field.getName(), Utils.getNextNll(scanner, Utils.getTypeName(field.getGenericType().toString())));
        }
        Utils.map2Object(log, input);
        TRUEWService.searchTvsProfile(MainClass.SESSIONID, log);
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }

    public static void searchTruProfile(Scanner scanner) throws Exception {

        Utils.clearConsole();
        System.out.println("===================     2. searchTruProfile   =====================");

        SearchTruProfile log = new SearchTruProfile();
        Map<String, Object> input = new HashMap<String, Object>();
        Field[] fields = log.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(String.format("Please input param (%s  - %s): ", field.getName(), Utils.getTypeName(field.getGenericType().toString())));
            input.put(field.getName(), Utils.getNextNll(scanner, Utils.getTypeName(field.getGenericType().toString())));
        }
        Utils.map2Object(log, input);
        TRUEWService.searchTruProfile(MainClass.SESSIONID, log);
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }

    public static void searchTmvProfile(Scanner scanner) throws Exception {

        Utils.clearConsole();
        System.out.println("===================     1.searchTmvProfile    =====================");

        SearchTmvProfile log = new SearchTmvProfile();
        Map<String, Object> input = new HashMap<String, Object>();
        Field[] fields = log.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(String.format("Please input param (%s  - %s): ", field.getName(), Utils.getTypeName(field.getGenericType().toString())));
            input.put(field.getName(), Utils.getNextNll(scanner, Utils.getTypeName(field.getGenericType().toString())));
        }
        Utils.map2Object(log, input);
        TRUEWService.searchTmvProfile(MainClass.SESSIONID, log);
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }

}
