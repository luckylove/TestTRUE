package com.trues;


import com.trues.webservice.service.AISWService;
import com.trues.webservice.service.a_getcusinfo.Fml32_A_GetCCCustInfo_Out;
import com.trues.webservice.service.csr.a_dcupd_autoem.Fml32_A_DCUpdAutoEm_Out;
import com.trues.webservice.service.csr.d_getccs_limitba.Fml32_D_GetCCSLimitBa_Out;
import com.trues.webservice.service.d_getcusivrpwd.Fml32_D_GetCustIVRPwd_Out;
import com.trues.webservice.service.etws_reversal.ReversalRequest;
import com.trues.webservice.service.etws_reversal.ReversalResponse;
import com.trues.webservice.service.interaction_campaign.OBJResponse;
import com.trues.webservice.service.model.WSObject;
import com.trues.webservice.service.payment.a_lstpm_mobdtl.Fml32_A_LstPMMobDtl_Out;
import com.trues.webservice.service.payment.d_getpm_cc_accbal.Fml32_D_GetPMCCAccBal_Out;
import com.trues.webservice.service.payment.d_getpm_ccver.Fml32_D_GetPMCCVer_Out;
import com.trues.webservice.service.sftonline_billinginterface.BillingHeaderType;
import com.trues.webservice.service.sftonline_billinginterface.GetAccountBalanceRequestMessageType;
import com.trues.webservice.service.sftonline_billinginterface.GetAccountBalanceResponseMessageType;
import org.codehaus.jackson.map.ObjectMapper;

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
        System.out.println("===================     1. Inquiry ROM reference number of top-up(ETWS_Reversal_Inquiry_Rom)");



        System.out.println("Please Select: ");
        String service = scanner.nextLine();
        if ("1".equals(service)) {
            ETWS_Reversal_Inquiry_Rom(scanner);
        }  else {
            MainClass.mainMenu(scanner);
        }
    }

    public static void D_GetPMCCVer(Scanner scanner) throws Exception {
        Utils.clearConsole();
        System.out.println("===================     13. D_GetPMCCVer    =====================");

        System.out.println("Please input param (PM_BILLING_ACC_NUM  - string): ");
        String PM_BILLING_ACC_NUM = scanner.nextLine();
        if ("".equals(PM_BILLING_ACC_NUM)) {
            PM_BILLING_ACC_NUM = null;
        }
        System.out.println("Please input param (PM_CREDIT_CARD_NUM  - string): ");
        String PM_CREDIT_CARD_NUM = scanner.nextLine();
        if ("".equals(PM_CREDIT_CARD_NUM)) {
            PM_CREDIT_CARD_NUM = null;
        }
        System.out.println("Please input param (PM_EXPIRED_DATE  - string): ");
        String PM_EXPIRED_DATE = scanner.nextLine();
        if ("".equals(PM_EXPIRED_DATE)) {
            PM_EXPIRED_DATE = null;
        }

        System.out.println("Please input param (PM_SERVICE_OPTION  - string): ");
        String PM_SERVICE_OPTION = scanner.nextLine();
        if ("".equals(PM_SERVICE_OPTION)) {
            PM_SERVICE_OPTION = null;
        }

        WSObject<Fml32_D_GetPMCCVer_Out> rs = AISWService.Payment_D_GetPMCCVer(MainClass.SESSIONID, PM_BILLING_ACC_NUM, PM_CREDIT_CARD_NUM, PM_EXPIRED_DATE, PM_SERVICE_OPTION);
        if (rs != null) {
            System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(rs));
        }
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }


    public static void D_GetPMCCAccBal(Scanner scanner) throws Exception {
        Utils.clearConsole();
        System.out.println("===================     14. D_GetPMCCAccBal    =====================");

        System.out.println("Please input param (PM_BILLING_ACC_NUM  - string): ");
        String PM_BILLING_ACC_NUM = scanner.nextLine();
        if ("".equals(PM_BILLING_ACC_NUM)) {
            PM_BILLING_ACC_NUM = null;
        }
        System.out.println("Please input param (PM_SERVICE_OPTION  - string): ");
        String PM_SERVICE_OPTION = scanner.nextLine();
        if ("".equals(PM_SERVICE_OPTION)) {
            PM_SERVICE_OPTION = null;
        }


        WSObject<Fml32_D_GetPMCCAccBal_Out> rs = AISWService.Payment_D_GetPMCCAccBal(MainClass.SESSIONID, PM_BILLING_ACC_NUM, PM_SERVICE_OPTION);
        if (rs != null) {
            System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(rs));
        }
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }

    public static void A_LstPMMobDtl(Scanner scanner) throws Exception {
        Utils.clearConsole();
        System.out.println("===================     15. A_LstPMMobDtl    =====================");

        System.out.println("Please input param (PM_MOBLIE_NUM  - string): ");
        String PM_MOBLIE_NUM = scanner.nextLine();
        if ("".equals(PM_MOBLIE_NUM)) {
            PM_MOBLIE_NUM = null;
        }
        System.out.println("Please input param (PM_BILLING_ACC_NUM  - string): ");
        String PM_BILLING_ACC_NUM = scanner.nextLine();
        if ("".equals(PM_BILLING_ACC_NUM)) {
            PM_BILLING_ACC_NUM = null;
        }

        System.out.println("Please input param (PM_3G_FLAG  - string): ");
        String PM_3G_FLAG = scanner.nextLine();
        if ("".equals(PM_3G_FLAG)) {
            PM_3G_FLAG = null;
        }


        WSObject<Fml32_A_LstPMMobDtl_Out> rs = AISWService.Payment_A_LstPMMobDtl(MainClass.SESSIONID, PM_MOBLIE_NUM, PM_3G_FLAG, PM_BILLING_ACC_NUM);
        if (rs != null) {
            System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(rs));
        }
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }

    public static void GetAccountBalance(Scanner scanner) throws Exception {
        Utils.clearConsole();
        System.out.println("===================     3. SFFToOnlineBillingInterface.GetAccountBalance");
        BillingHeaderType log = new BillingHeaderType();
        Map<String, Object> input = new HashMap<String, Object>();
        Field[] fields = BillingHeaderType.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("__equalsCalc") || field.getName().equals("__hashCodeCalc") || field.getName().equals("typeDesc") || field.getName().equals("status"))
                continue;
            System.out.println(String.format("Please input param (%s  - %s): ", field.getName(), Utils.getTypeName(field.getGenericType().toString())));
            input.put(field.getName(), Utils.getNextNll(scanner, Utils.getTypeName(field.getGenericType().toString())));
        }
        Utils.map2Object(log, input);

        input = new HashMap<String, Object>();
        GetAccountBalanceRequestMessageType log1 = new GetAccountBalanceRequestMessageType();
        fields = GetAccountBalanceRequestMessageType.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("__equalsCalc") || field.getName().equals("__hashCodeCalc") || field.getName().equals("typeDesc"))
                continue;
            System.out.println(String.format("Please input param (%s  - %s): ", field.getName(), Utils.getTypeName(field.getGenericType().toString())));
            input.put(field.getName(), Utils.getNextNll(scanner, Utils.getTypeName(field.getGenericType().toString())));
        }

        Utils.map2Object(log1, input);
        WSObject<GetAccountBalanceResponseMessageType> wsObject = AISWService.GetAccountBalance(MainClass.SESSIONID, log, log1);
        System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(wsObject));

        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);
    }

    public static void ETWS_Reversal_Rom_Topup(Scanner scanner) throws Exception {
        Utils.clearConsole();
        System.out.println("===================     2. ROM Top-up reversal(ETWS_Reversal_Rom_Topup)");
        ReversalRequest log = new ReversalRequest();
        Map<String, Object> input = new HashMap<String, Object>();
        Field[] fields = ReversalRequest.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("__equalsCalc") || field.getName().equals("__hashCodeCalc") || field.getName().equals("typeDesc"))
                continue;
            System.out.println(String.format("Please input param (%s  - %s): ", field.getName(), Utils.getTypeName(field.getGenericType().toString())));
            input.put(field.getName(), Utils.getNextNll(scanner, Utils.getTypeName(field.getGenericType().toString())));
        }

        Utils.map2Object(log, input);
        WSObject<ReversalResponse> wsObject = AISWService.ETWS_Reversal_Rom_Topup(MainClass.SESSIONID, log);
        System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(wsObject));

        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);
    }

    public static void ETWS_Reversal_Inquiry_Rom(Scanner scanner) throws Exception {
        Utils.clearConsole();
        System.out.println("===================     1. Inquiry ROM reference number of top-up(ETWS_Reversal_Inquiry_Rom)");
        ReversalRequest log = new ReversalRequest();
        Map<String, Object> input = new HashMap<String, Object>();
        Field[] fields = ReversalRequest.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("__equalsCalc") || field.getName().equals("__hashCodeCalc") || field.getName().equals("typeDesc"))
                continue;
            System.out.println(String.format("Please input param (%s  - %s): ", field.getName(), Utils.getTypeName(field.getGenericType().toString())));
            input.put(field.getName(), Utils.getNextNll(scanner, Utils.getTypeName(field.getGenericType().toString())));
        }

        Utils.map2Object(log, input);
        WSObject<ReversalResponse> wsObject = AISWService.ETWS_Reversal_Inquiry_Rom(MainClass.SESSIONID, log);
        System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(wsObject));

        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);
    }


    public static void A_DCUpdAutoEm(Scanner scanner) throws Exception {
        Utils.clearConsole();
        System.out.println("===================     8. A_DCUpdAutoEm    =====================");

        System.out.println("Please input param (DCC_BILLING_ACC_NUM  - string): ");
        String DCC_BILLING_ACC_NUM = scanner.nextLine();
        if ("".equals(DCC_BILLING_ACC_NUM)) {
            DCC_BILLING_ACC_NUM = null;
        }
        System.out.println("Please input param (DCC_USER_ID  - string): ");
        String DCC_USER_ID = scanner.nextLine();
        if ("".equals(DCC_USER_ID)) {
            DCC_USER_ID = null;
        }
        System.out.println("Please input param (DCC_EFFECTIVE_DAT  - string): ");
        String DCC_EFFECTIVE_DAT = scanner.nextLine();
        if ("".equals(DCC_EFFECTIVE_DAT)) {
            DCC_EFFECTIVE_DAT = null;
        }

        WSObject<Fml32_A_DCUpdAutoEm_Out> rs = AISWService.CSR_A_DCUpdAutoEm(MainClass.SESSIONID, DCC_BILLING_ACC_NUM, DCC_USER_ID, DCC_EFFECTIVE_DAT);
        if (rs != null) {
            System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(rs));
        }
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }

    public static void D_GetCCSLimitBa(Scanner scanner) throws Exception {
        Utils.clearConsole();
        System.out.println("===================     9. D_GetCCSLimitBa    =====================");

        System.out.println("Please input param (CSR_BILLING_ACCOUNT_NO  - string): ");
        String CSR_BILLING_ACCOUNT_NO = scanner.nextLine();
        if ("".equals(CSR_BILLING_ACCOUNT_NO)) {
            CSR_BILLING_ACCOUNT_NO = null;
        }
        System.out.println("Please input param (CSR_SERVICE_OPTION  - string): ");
        String CSR_SERVICE_OPTION = scanner.nextLine();
        if ("".equals(CSR_SERVICE_OPTION)) {
            CSR_SERVICE_OPTION = null;
        }
        WSObject<Fml32_D_GetCCSLimitBa_Out> rs = AISWService.CSR_D_GetCCSLimitBa(MainClass.SESSIONID, CSR_BILLING_ACCOUNT_NO, CSR_SERVICE_OPTION);
        if (rs != null) {
            System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(rs));
        }
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }

    public static void A_GetCCCustInfo(Scanner scanner) throws Exception {
        Utils.clearConsole();
        System.out.println("===================     10. A_GetCCCusInfo    =====================");

        System.out.println("Please input param (mobileNo  - string): ");
        String mobileNo = scanner.nextLine();
        if ("".equals(mobileNo)) {
            mobileNo = null;
        }

        WSObject<Fml32_A_GetCCCustInfo_Out> rs = AISWService.A_GetCCCusInfo(MainClass.SESSIONID, mobileNo);
        if (rs != null) {
            System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(rs));
        }
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }

    public static void D_GetCustIVRPwd(Scanner scanner) throws Exception {
        Utils.clearConsole();
        System.out.println("===================     11. D_GetCustIVRPwd    =====================");

        System.out.println("Please input param (mobileNo  - string): ");
        String mobileNo = scanner.nextLine();
        if ("".equals(mobileNo)) {
            mobileNo = null;
        }

        System.out.println("Please input param (password  - string): ");
        String password = scanner.nextLine();
        if ("".equals(password)) {
            password = null;
        }

        WSObject<Fml32_D_GetCustIVRPwd_Out> rs = AISWService.D_GetCustIVRPwd(MainClass.SESSIONID, mobileNo, password);
        if (rs != null) {
            System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(rs));
        }
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }

    public static void INTERACTIVECAMPAIGN(Scanner scanner) throws Exception {
        Utils.clearConsole();
        System.out.println("===================     12. INTERACTIVECAMPAIGN    =====================");

        System.out.println("Please input param (mobileNo  - string): ");
        String mobileNo = scanner.nextLine();
        if ("".equals(mobileNo)) {
            mobileNo = null;
        }
        WSObject<OBJResponse> rs = AISWService.InteractionCampaign(MainClass.SESSIONID, mobileNo);
        if (rs != null) {
            System.out.println(mapper.defaultPrettyPrintingWriter().writeValueAsString(rs));
        }
        System.out.println("Enter to next: ");
        scanner.nextLine();
        testWebService(scanner);

    }
}
