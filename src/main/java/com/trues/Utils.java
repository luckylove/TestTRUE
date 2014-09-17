package com.trues;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

/**
 * User: son.nguyen
 * Date: 11/3/13
 * Time: 6:48 PM
 */
public class Utils {

    public static Object getNext(Scanner scanner, String type) {
        Object ob = null;
        if ("string".equals(type)) {
            ob = scanner.nextLine();
        } else if ("integer".equals(type)) {
            ob = scanner.nextLine();
            if (!"".equals(ob)) {
                try {
                    ob = Integer.parseInt((String)ob);
                } catch (Exception e) {
                    System.out.println("Please enter an integer number: ");
                    ob = getNext(scanner, type);
                }
            } else {
                ob = 0;
            }

        } else if ("long".equals(type)) {
            ob = scanner.nextLine();
            if (!"".equals(ob)) {
                try {
                    ob = Long.parseLong((String) ob);
                } catch (Exception e) {
                    System.out.println("Please enter an long number: ");
                    ob = getNext(scanner, type);
                }
            } else {
                ob = 0l;
            }
        }
        return ob;
    }

    public static Object getNextNll(Scanner scanner, String type) {
        Object ob = null;
        if ("string".equals(type)) {
            ob = scanner.nextLine();
        } else if ("integer".equals(type)) {
            ob = scanner.nextLine();
            if (!"".equals(ob)) {
                try {
                    ob = Integer.parseInt((String)ob);
                } catch (Exception e) {
                    System.out.println("Please enter an integer number: ");
                    ob = getNext(scanner, type);
                }
            } else {
                ob = 0;
            }

        } else if ("long".equals(type)) {
            ob = scanner.nextLine();
            if (!"".equals(ob)) {
                try {
                    ob = Long.parseLong((String) ob);
                } catch (Exception e) {
                    System.out.println("Please enter an long number: ");
                    ob = getNext(scanner, type);
                }
            } else {
                ob = 0l;
            }
        }
        else if ("double".equals(type)) {
            ob = scanner.nextLine();
            if (!"".equals(ob)) {
                try {
                    ob = Double.parseDouble((String) ob);
                } catch (Exception e) {
                    System.out.println("Please enter an double number: ");
                    ob = getNext(scanner, type);
                }
            } else {
                ob = 0d;
            }
        }
        if ("".equals(ob) || Long.valueOf(0).equals(ob) || Integer.valueOf(0).equals(ob) || Double.valueOf(0).equals(ob)) {
            return null;
        }
        return ob;
    }

    public static void clearConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception exception) {
            //  Handle exception.
        }
    }

    public static String getTypeName(String type) {
        int i = type.lastIndexOf(".");
        return type.substring(i + 1).toLowerCase();
    }

    public static <T> void map2Object(T config, Map<String, Object> map) {
        Field[] fields = config.getClass().getDeclaredFields();
        Map<String, Field> mapFields = new HashMap<String, Field>();
        for (Field field : fields) {
            mapFields.put(field.getName(), field);
        }
        //get one level supper class
        if (config.getClass().getSuperclass() != null) {
            Field[] supperFields = config.getClass().getSuperclass().getDeclaredFields();
            for (Field field : supperFields) {
                mapFields.put(field.getName(), field);
            }
        }
        Set set = map.keySet();
        Iterator it = set.iterator();
        Method method;
        String key, key1, key2;
        Type type;

        while (it.hasNext()) {
            key = (String) it.next();
            key1 = upperCaseFirst(key);
            Object obv = map.get(key);
            Field configField = mapFields.get(key);
            if (configField != null) {
                try {
                    method = config.getClass().getMethod(
                            "set" + key1, new Class[]{configField.getType()});
                    method.invoke(config, obv);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static <T> void map2ObjectNull(T config, Map<String, Object> map) {
        Field[] fields = config.getClass().getDeclaredFields();
        Map<String, Field> mapFields = new HashMap<String, Field>();
        for (Field field : fields) {
            mapFields.put(field.getName(), field);
        }
        //get one level supper class
        if (config.getClass().getSuperclass() != null) {
            Field[] supperFields = config.getClass().getSuperclass().getDeclaredFields();
            for (Field field : supperFields) {
                mapFields.put(field.getName(), field);
            }
        }
        Set set = map.keySet();
        Iterator it = set.iterator();
        Method method;
        String key, key1, key2;
        Type type;

        while (it.hasNext()) {
            key = (String) it.next();
            key1 = upperCaseFirst(key);
            Object obv = map.get(key);
            Field configField = mapFields.get(key);
            if (configField != null) {
                try {
                    method = config.getClass().getMethod(
                            "set" + key1, new Class[]{configField.getType()});
                    method.invoke(config, obv);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public static String upperCaseFirst(String str) {
        if (StringUtils.isNotEmpty(str)) {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        return "";
    }
}
