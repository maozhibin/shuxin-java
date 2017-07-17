package com.baoquan.shuxin.third.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.baoquan.shuxin.config.product.api.GeotmtConfig;
import com.baoquan.shuxin.third.service.spi.GeotmtService;
import com.baoquan.shuxin.third.util.cfca.JsonUtils;
import com.baoquan.shuxin.third.util.geotmt.Client;

/**
 * Created by Administrator on 2017/5/9.
 */
@Named
public class GeotmtServiceImpl implements GeotmtService {
    private static Logger logger = Logger.getLogger(GeotmtServiceImpl.class);

    @Inject
    private GeotmtConfig geotmtConfig;

    private String server = "http://yz.geotmt.com:80";
    private int encrypted = 1;
    private String encryptionType = "AES";
    private String encryptionKey = "sqkj123456";
    private String username = "sqkj";
    private String password = "sqkj@geo";
    private String uno = "200375";
    private String etype = "RSA";
    private int dsign = 0;

    @PostConstruct
    public void init() {
        this.server = geotmtConfig.getGeotmtServer();
        this.encrypted = geotmtConfig.getGeotmtEncrypted();
        this.encryptionType = geotmtConfig.getGeotmtEncryptionType();
        this.encryptionKey = geotmtConfig.getGeotmtEncryptionKey();
        this.username = geotmtConfig.getGeotmtUsername();
        this.password = geotmtConfig.getGeotmtPassword();
        this.etype = geotmtConfig.getGeotmtEtype();
        this.dsign = geotmtConfig.getGeotmtDsign();
    }

    // 构造客户端(线程安全)
    public Client client = new Client();  // 如果接入只是一个账号的话那么该类的构造只需在启动的时候构造一次即可

    {
        client.setServer(server);
        client.setEncrypted(encrypted);
        client.setEncryptionType(encryptionType);
        client.setEncryptionKey(encryptionKey);
        client.setUsername(username);
        client.setPassword(password);
        client.setUno(uno);
        client.setEtype(etype);
        client.setDsign(dsign);
    }

    public String real_1_dimension_name_verify(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "A1");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String real_2_dimension_name_verify(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "A2");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_online_time(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "A3");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_online_status(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "A4");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_own_numbers(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "A5");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_change_frequency(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "A6");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_month_consumption(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "B1");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_3month_consumption_sum(String cid, String idNumber, String realName, String month) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "B2");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("month", month);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_location(String cid, String idNumber, String realName, String usualaddress) {
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "B3");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("usualaddress", usualaddress);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String real_3_dimension_name_verify(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "B7");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_work_location(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "B8");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_frequent_contacts_verify(String cid, String idNumber, String realName, String cid2) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "B11");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("cid2", cid2);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_arrears(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "B14");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_3_month_stop(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "B13");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_rest_location(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "B15");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    private String simplyOutput(String data) {
        try {
            Map response = JsonUtils.json2Obj(data, Map.class);
            if ("200".equals(response.get("code"))) {
                return JsonUtils.obj2Json(response.get("data"));
            } else {
                logger.error("查询失败");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public String cellphone_work_location_offset(String cid, String idNumber, String realName, String longitude,
            String latitude) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "B18");
        params.put("longitude", longitude);
        params.put("latitude", latitude);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_rest_location_offset(String cid, String idNumber, String realName, String longitude,
            String latitude) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "B19");
        params.put("longitude", longitude);
        params.put("latitude", latitude);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_realtime_location_offset(String cid, String idNumber, String realName, String longitude,
            String latitude) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "B20");
        params.put("longitude", longitude);
        params.put("latitude", latitude);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_month_data_usage(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "B21");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_age(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "C2");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_gender(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "C3");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_month_top_call_city(String cid, String idNumber, String realName, String month) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("month", month);
        params.put("innerIfType", "C4");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_month_payment(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "C5");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_terminal_type(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "C6");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_contract_count(String cid, String idNumber, String realName, String cid2) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("cid2", cid2);
        params.put("innerIfType", "C7");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_identity_verify(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "C8");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_company_verify(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "C9");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_prepaid(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "C10");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_month_arrears(String cid, String idNumber, String realName, String month) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("month", month);
        params.put("innerIfType", "C11");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_blacklist_verify(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "C12");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_user_level(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "C13");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String financial_stability_evaluation(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("cid", cid);
        if (idNumber != null) {
            params.put("idNumber", idNumber);
        }
        if (realName != null) {
            params.put("realName", realName);
        }
        params.put("innerIfType", "Z2");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String highest_education(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "G1");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String name_identity_verify(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "Y1");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String name_identity_verify_with_photo(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);
        params.put("innerIfType", "Y1");

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_hit_dishonest(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10101");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_hit_execution(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10102");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_hit_after_loan_management(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10103");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_hit_blacklist(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10104");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_hit_drag_or_fugitive(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10105");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_hit_fraud(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10106");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_hit_bank(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10107");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_hit_insurance_fraud(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10108");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_hit_p2p(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10109");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_hit_overdue(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10110");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_hit_dishonest(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10201");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_hit_execution(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10202");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_hit_blacklist(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10204");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_hit_drag_or_fugitive(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10205");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_hit_fraud(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10206");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_hit_bank(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10207");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_hit_insurance_fraud(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10208");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_hit_p2p(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10209");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_hit_overdue(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10210");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_hit_intermediary(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T10211");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String overdue_query(String cid, String idNumber, String cycle, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T2");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("cycle", cycle);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_3_day_apply(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T40101");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_7_day_apply(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T40102");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_1_month_apply(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T40103");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String identity_3_month_apply(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T40104");
        if (cid != null) {
            params.put("cid", cid);
        }
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_3_day_apply(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T40201");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_7_day_apply(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T40202");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_1_month_apply(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T40303");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }

    public String cellphone_3_month_apply(String cid, String idNumber, String realName) {
        logger.info(client);
        // 请求地址
        String path = server + "/civp/getview/api/u/queryUnify";
        // 请求参数(client里面会自动加密,所以这里请使用明文)
        Map<String, String> params = new HashMap<String, String>();
        params.put("innerIfType", "T40404");
        params.put("cid", cid);
        params.put("idNumber", idNumber);
        params.put("realName", realName);

        params.put("authCode", client.rpad(uno + ":" + params.get("cid"), 32));
        // 请求数据接口返回json
        String data = client.getData(path, params);
        return simplyOutput(data);
    }
}