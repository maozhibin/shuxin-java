package com.baoquan.shuxin.third.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.config.product.api.CfcaConfig;
import com.baoquan.shuxin.service.spi.RedisService;
import com.baoquan.shuxin.third.service.spi.CfcaService;
import com.baoquan.shuxin.third.util.cfca.HttpUtils;
import com.baoquan.shuxin.third.util.cfca.JsonUtils;

@Named
public class CfcaServiceImpl implements CfcaService {
    @Inject
    private CfcaConfig cfcaConfig;

    @Inject
    private RedisService<String> stringRedisService;

    private final static String REDIS_PREFIX = "dsj_cfca_";

    public static String getRedisPrefix() {
        return REDIS_PREFIX;
    }

    private final static int SLEEP_TIME = 5;

    private String getUserAccountKey() {
        String lastKey = stringRedisService.get(REDIS_PREFIX + "last_key");
        String arr[] = lastKey.split(",");
        return arr[0];
    }

    public String checkCompanyName(String companyMID, String companyName, String registrationNumber,
            String personName) {
        String transactionCode = "CF209a0005";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("companyMID", companyMID);
        if (companyName != null) {
            params.put("companyName", companyName);
        }
        if (registrationNumber != null) {
            params.put("registrationNumber", registrationNumber);
        }
        if (personName != null) {
            params.put("personName", personName);
        }
        try {
            Map response = httpUtils.requestNotEncryptedAsync(transactionCode, "check-company-name.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkCompanyType(String companyMID, String companyName, String registrationNumber,
            String personName) {
        String transactionCode = "CF209a0006";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("companyMID", companyMID);
        if (companyName != null) {
            params.put("companyName", companyName);
        }
        if (registrationNumber != null) {
            params.put("registrationNumber", registrationNumber);
        }
        if (personName != null) {
            params.put("personName", personName);
        }
        try {
            Map response = httpUtils.requestNotEncryptedAsync(transactionCode, "check-company-type.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkPOSBalanceMax(String companyMID, String companyName, String registrationNumber,
            String personName) {
        String transactionCode = "CF209a0007";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("companyMID", companyMID);
        params.put("companyName", companyName);
        if (registrationNumber != null) {
            params.put("registrationNumber", registrationNumber);
        }
        if (personName != null) {
            params.put("personName", personName);
        }
        try {
            Map response = httpUtils.requestNotEncryptedAsync(transactionCode, "check-POS-balance-max.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String searchPOSCardAcceptance(String companyMID, String companyName, String registrationNumber,
            String personName) {
        String transactionCode = "CF209a0008";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("companyMID", companyMID);
        params.put("companyName", companyName);
        if (registrationNumber != null) {
            params.put("registrationNumber", registrationNumber);
        }
        if (personName != null) {
            params.put("personName", personName);
        }
        try {
            Map response = httpUtils.requestNotEncryptedAsync(transactionCode, "search-POS-card-acceptance.json",
                    params, SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String searchPOSAnnulusGrowth(String companyMID, String companyName, String registrationNumber,
            String personName) {
        String transactionCode = "CF209a0009";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("companyMID", companyMID);
        params.put("companyName", companyName);
        if (registrationNumber != null) {
            params.put("registrationNumber", registrationNumber);
        }
        if (personName != null) {
            params.put("personName", personName);
        }
        try {
            Map response = httpUtils.requestNotEncryptedAsync(transactionCode, "POS-annulus-growth.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String searchPOSMoMIncrease(String companyMID, String companyName, String registrationNumber,
            String personName) {
        String transactionCode = "CF209a0010";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("companyMID", companyMID);
        params.put("companyName", companyName);
        if (registrationNumber != null) {
            params.put("registrationNumber", registrationNumber);
        }
        if (personName != null) {
            params.put("personName", personName);
        }
        try {
            Map response = httpUtils.requestNotEncryptedAsync(transactionCode, "POS-MoM-increase.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String cardConsumingFrequentCity(String personName, String cardNumber, String identityType,
            String identityNumber, String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b0010";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "card-consuming-frequent-city.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String repaymentAbility(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b0011";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "repayment-ability.json", params, SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String cardLevel(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b0012";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "card-level.json", params, SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String lastPaymentArea(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b0013";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "last-payment-area.json", params, SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String lastPaymentAmount(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b0014";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "last-payment-amount.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String yearPaymentSum(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b001SLEEP_TIME";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "year-payment-sum.json", params, SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String consumptionLocationInfo(String personName, String cardNumber, String identityType,
            String identityNumber, String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b0016";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "consumption-location-info.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String overseaPaymentSum(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b0017";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "oversea-payment-sum.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String cardChargeOffSum(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b0018";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "card-charge-off-sum.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String enterInAccountSum(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b0019";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "enter-in-account-sum.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String chargeOffMCC(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b0020";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "charge-off-MCC.json", params, SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String housePayment(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b0021";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "house-payment.json", params, SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String vehiclePayment(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address) {
        String transactionCode = "CF209b0022";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("cardNumber", cardNumber);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        if (email != null) {
            params.put("email", email);
        }
        if (address != null) {
            params.put("address", address);
        }
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "vehicle-payment.json", params, SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String cellphoneAccountBalance(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0003";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "cellphone-account-balance.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String cellphoneOnlineMonths(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0007";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "cellphone-online-months.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkDeviceNumber(String personName, String identityType, String identityNumber,
            String cellPhoneNumber, String deviceNumber) {
        String transactionCode = "CF211b0009";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        params.put("deviceNumber", deviceNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-device-number.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkPersonalCellphoneNumbers(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0010";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-personal-cellphone-numbers.json",
                    params, SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkRoamingTimes(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0011";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-roaming-times.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkDataUsage(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0012";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-data-usage.json", params, SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String check2YearNumberChanges(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0014";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-2year-number-changes.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String check3YearPhoneChanges(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0017";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-3year-phone-changes.json", params,
                    SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkPhoneBrand(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0019";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-phone-brand.json", params, SLEEP_TIME);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkBlacklistId(String personName, String identityType, String identityNumber) {
        String transactionCode = "CF201b0004";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        try {
            Map response = httpUtils.requestEncryptSync(transactionCode, "check-blacklist-id.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkBlacklistAccount(String personName, String identityType, String identityNumber,
            String cardNumber) {
        String transactionCode = "CF201b0005";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cardNumber", cardNumber);
        try {
            Map response = httpUtils.requestEncryptSync(transactionCode, "check-blacklist-account.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkPersonalId(String personName, String identityType, String identityNumber) {
        String transactionCode = "CF206b0001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        try {
            Map response = httpUtils.requestEncryptSync(transactionCode, "check-personal-id.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkPersonalAccount(String cardNumber, String bankId, String cardType, String validDate, String cvn2,
            String personName,
            String identityType, String identityNumber, String cellPhoneNumber) {
        String transactionCode = "CF207b0001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("cardNumber", cardNumber);
        if (bankId != null) {
            params.put("bankId", bankId);
        }
        params.put("cardType", cardType);
        if (validDate != null) {
            params.put("validDate", validDate);
        }
        if (cvn2 != null) {
            params.put("cvn2", cvn2);
        }
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptSync(transactionCode, "check-personal-account.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //    cfca数据服务产品接口第二期
    public String cellphoneAccountOverdue(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0004";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "cellphone-account-overdue.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String cellphoneAccountRewardPoints(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0005";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "cellphone-account-reward-points.json",
                    params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkSim(String personName, String identityType, String identityNumber, String cellPhoneNumber,
            String imsi) {
        String transactionCode = "CF211b0008";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        params.put("imsi", imsi);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-sim.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String check1YearNumberChanges(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0013";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-1year-number-changes.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String check1YearPhoneChanges(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0016";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-1year-phone-changes.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkHighQualityEducation(String personName, String identityType, String identityNumber,
            String cellPhoneNumber,
            String highestEducation, String graduateInstitution, String graduateYear) {
        String transactionCode = "CF213b0001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        params.put("highestEducation", highestEducation);
        params.put("graduateInstitution", graduateInstitution);
        params.put("graduateYear", graduateYear);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-highest-quality-education.json",
                    params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String educationBackgroundInfo(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF213b0002";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "education-background-info.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkPhoneNumberLocation(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b0001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestNotEncryptSync(transactionCode, "check-phone-number-location.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkDepositBank(String personName, String identityType, String identityNumber, String cardNumber) {
        String transactionCode = "CF209b0009";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cardNumber", cardNumber);
        try {
            Map response = httpUtils.requestEncryptSync(transactionCode, "check-deposit-bank.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkPersonalIdT2(String personName, String identityType, String identityNumber, String cardNumber,
            String photo) {
        String transactionCode = "CF209b0009";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cardNumber", cardNumber);
        params.put("Photo", photo);
        try {
            Map response = httpUtils.requestEncryptSync(transactionCode, "check-personal-id-T2.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkBlacklistIdT2(String personName, String identityType, String identityNumber) {
        String transactionCode = "CF201b0001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        try {
            Map response = httpUtils.requestEncryptSync(transactionCode, "check-blacklist-id-T2.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkBlacklistAccountT2(String personName, String identityType, String identityNumber,
            String cardNumber) {
        String transactionCode = "CF201b0002";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cardNumber", cardNumber);
        try {
            Map response = httpUtils.requestEncryptSync(transactionCode, "check-blacklist-account-T2.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkBlacklistCellphoneT2(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF201b0003";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptSync(transactionCode, "check-blacklist-cellphone-T2.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //    CFCA数据服务产品接口
    public String searchPersonalJudgmentDocument(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF218b0002";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "search-personal-Judgment-document.json",
                    params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String searchPersonalExecutionDocument(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF218b0001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "search-personal-execution-document.json",
                    params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkPersonalDiscreditInfo(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF218b0003";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-personal-discredit-info.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String searchPersonalP2PBlacklistInfo(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF218b0004";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "search-personal-P2P-blacklist-info.json",
                    params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String personalFlightStatistic(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF214b0001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "personal-flight-statistic.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String companyRegistrationAndSupervisionReport(String companyName, String uniformCreditCode) {
        String transactionCode = "CF102a0001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        if (companyName != null)
            params.put("companyName", companyName);

        if (uniformCreditCode != null)
            params.put("uniformCreditCode", uniformCreditCode);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode,
                    "company-registration-and-supervision-report.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String searchLawpersonCompanyReport(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF102a0002";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "search-lawperson-company-report.json",
                    params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String educationInfoWithPhoto(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF213b0003";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "education-info-with-photo.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkPersonalAccountInfo(String personName, String identityType, String identityNumber,
            String cellPhoneNumber,
            String cardType, String validDate, String cvn2, String cardNumber) {
        String transactionCode = "CF207b0004";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);
        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        if (cellPhoneNumber != null)
            params.put("cellPhoneNumber", cellPhoneNumber);
        params.put("cardType", cardType);
        if (validDate != null)
            params.put("validDate", validDate);
        if (cvn2 != null)
            params.put("cvn2", cvn2);
        params.put("cardNumber", cardNumber);
        try {
            Map response = httpUtils.requestEncryptSync(transactionCode, "check-personal-account-info.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String companyRegistrationInfo(String companyName, String uniformCreditCode) {
        String transactionCode = "CF102a0003";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        if (companyName != null)
            params.put("companyName", companyName);

        if (uniformCreditCode != null)
            params.put("uniformCreditCode", uniformCreditCode);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "company-registration-info.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //    CFCA数据服务产品接口（第二期第四版）
    public String checkPersonPlateNum(String plateNumber, String vehicleType, String personName,
            String cellPhoneNumber) {
        String transactionCode = "CF212b0001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("plateNumber", plateNumber);
        params.put("vehicleType", vehicleType);
        params.put("personName", personName);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-person-plateNum.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkPersonEngineNumPlateNum(String plateNumber, String vehicleType, String engineNumber,
            String personName, String cellPhoneNumber) {
        String transactionCode = "CF212b0002";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("plateNumber", plateNumber);
        params.put("vehicleType", vehicleType);
        params.put("engineNumber", engineNumber);
        params.put("personName", personName);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-person-engineNum-plateNum.json",
                    params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkLegalDrivingVehicle(String drivingLicence, String personName, String vehicleType,
            String cellPhoneNumber) {
        String transactionCode = "CF212b0003";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("drivingLicence", drivingLicence);
        params.put("vehicleType", vehicleType);
        params.put("personName", personName);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-legal-driving-vehicle.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkRegisteredDrivingVehicle(String plateNumber, String plateType, String personName,
            String registrationDate, String cellPhoneNumber) {
        String transactionCode = "CF212b0004";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("plateNumber", plateNumber);
        params.put("plateType", plateType);
        if (personName != null)
            params.put("personName", personName);

        params.put("registrationDate", registrationDate);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-registered-driving-vehicle.json",
                    params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkRegisteredDriver(String drivingLicence, String personName, String registrationDate,
            String cellPhoneNumber) {
        String transactionCode = "CF212b0005";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("drivingLicence", drivingLicence);
        params.put("personName", personName);
        params.put("registrationDate", registrationDate);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-registered-driver.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkRegisteredDriver1(String drivingLicence, String personName, String documentID,
            String cellPhoneNumber) {
        String transactionCode = "CF212b0006";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("drivingLicence", drivingLicence);
        params.put("personName", personName);
        params.put("documentID", documentID);
        params.put("cellPhoneNumber", cellPhoneNumber);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-registered-driver1.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkPersonalIdentity(String personName, String identityType, String identityNumber,
            String cellPhoneNumb, String cardNumber,
            String vehicleType, String highestEducation, String photo) {
        String transactionCode = "CF206b0003";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumb", cellPhoneNumb);
        params.put("cardNumber", cardNumber);
        if (vehicleType != null)
            params.put("vehicleType", vehicleType);
        if (highestEducation != null)
            params.put("highestEducation", highestEducation);
        params.put("Photo", photo);
        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-personal-Identity.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String companyJudgmentDocument(String companyName, String uniformCreditCode) {
        String transactionCode = "CF218a0001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        if (companyName != null)
            params.put("companyName", companyName);

        if (uniformCreditCode != null)
            params.put("uniformCreditCode", uniformCreditCode);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "company-judgment-document.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String companyExecutionDocument(String companyName, String uniformCreditCode) {
        String transactionCode = "CF218a0002";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        if (companyName != null)
            params.put("companyName", companyName);

        if (uniformCreditCode != null)
            params.put("uniformCreditCode", uniformCreditCode);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "company-execution-document.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkCompanyDiscreditInfo(String companyName, String uniformCreditCode) {
        String transactionCode = "CF218a0003";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        if (companyName != null)
            params.put("companyName", companyName);

        if (uniformCreditCode != null)
            params.put("uniformCreditCode", uniformCreditCode);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-campany-discredit-info.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String companyOwingTax(String companyName, String uniformCreditCode) {
        String transactionCode = "CF218a0004";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        if (companyName != null)
            params.put("companyName", companyName);

        if (uniformCreditCode != null)
            params.put("uniformCreditCode", uniformCreditCode);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "campany-owing-tax.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String abnormalCompanyTaxpayerId(String companyName, String uniformCreditCode) {
        String transactionCode = "CF218a0005";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        if (companyName != null)
            params.put("companyName", companyName);

        if (uniformCreditCode != null)
            params.put("uniformCreditCode", uniformCreditCode);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "abnormal-company-taxpayerId.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //    CFCA数据服务接口第二期第五版
    public String cellphoneReadNameRegistration(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b1000";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "cellphone-real-name-registration.json",
                    params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String censusRegistrationInfo(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF206b0005";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "census-registration-info", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String censusRegistrationPhoto(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF206b0005";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "census-registration-photo", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String SMSDeliver(String destinationPhoneNumber, String SMSContent, String SMSSender) {
        String transactionCode = "CF206a0001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("destinationPhoneNumber", destinationPhoneNumber);
        params.put("SMSContent", SMSContent);
        params.put("SMSSender", SMSSender);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "SMS-deliver", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkCellphoneLocation2(String personName, String identityType, String identityNumber,
            String cellPhoneNumber,
            String longitude, String latitude) {
        String transactionCode = "CF206a0002";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);
        params.put("longitude", longitude);
        params.put("latitude", latitude);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-cellphone-location2.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //	CACF数据服务产品接口（第三期第一版）
    public String checkBlacklistMerchantT2(String merchantName, String merchantIdType, String merchantId,
            String uniformCreditCode) {
        String transactionCode = "CF201a0001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("merchantName", merchantName);
        params.put("merchantIdType", merchantIdType);
        if (merchantId != null)
            params.put("merchantId", merchantId);
        if (uniformCreditCode != null)
            params.put("uniformCreditCode", uniformCreditCode);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-blacklist-merchant-T2.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String uniRoamingTimes(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b1001";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "uni-roaming-times.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String uniMonthlyConsumption(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b1002";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "uni-monthly-consumption.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String uniMonthlyDataUsage(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b1003";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "uni-monthly-data-usage.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String uniLastUsingTime(String personName, String identityType, String identityNumber,
            String cellPhoneNumber) {
        String transactionCode = "CF211b1004";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        params.put("personName", personName);
        params.put("identityType", identityType);
        params.put("identityNumber", identityNumber);
        params.put("cellPhoneNumber", cellPhoneNumber);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "uni-last-useing-time.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkPersonalAccountInfo(String personName, String cellPhoneNumber) {
        String transactionCode = "CF211b1005";
        Map<String, String> params = new HashMap<String, String>();
        HttpUtils httpUtils = new HttpUtils(cfcaConfig);

        if (personName != null)
            params.put("personName", personName);
        params.put("cellPhoneNumber", cellPhoneNumber);

        try {
            Map response = httpUtils.requestEncryptAsync(transactionCode, "check-personal-account-info.json", params);
            return JsonUtils.obj2Json(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

