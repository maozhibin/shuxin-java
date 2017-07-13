package com.baoquan.shuxin.service.impl.product.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.baoquan.shuxin.config.product.api.ShengdaConfig;
import com.baoquan.shuxin.service.spi.product.api.ShengDaService;
import com.baoquan.shuxin.util.product.api.shengda.HttpMas;

@Named
public class ShengDaServiceImpl implements ShengDaService {
    @Inject
    private ShengdaConfig shengdaConfig;

    private String URL;

    private String MERCHANT_NO;

    private String SIGN_TYPE;

    private String KEY;

    private String CHARSET;

    @PostConstruct
    public void init() {
        this.URL = shengdaConfig.getShengdaUrl();
        this.MERCHANT_NO = shengdaConfig.getShengdaMerchantNo();
        this.SIGN_TYPE = shengdaConfig.getShengdaSignType();
        if (SIGN_TYPE.toLowerCase().equals("md5")) {
            this.KEY = shengdaConfig.getShengdaKey();
        } else {
            this.KEY = shengdaConfig.getShengdaRsaKey();
        }
        this.CHARSET = shengdaConfig.getShengdaCharset();
    }


    public String idcard_two_apply(String identityNo, String trueName) {
        //测试环境
        String url = URL + "idcard_two_apply";
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new HashMap<String, String>();

        String key = KEY;
        body.put("signType", SIGN_TYPE);

        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("charset", CHARSET);
        body.put("identityNo", identityNo);
        body.put("merchantNo", merchantNo);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        return HttpMas.post(url, body, key);
    }

    public String mobile_items_apply(String identityNo, String trueName, String mobile) {
        //测试环境
        String url = URL + "mobile_items_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);
        body.put("mobile", mobile);


        return HttpMas.post(url, body, key);
    }

    public String three_items_apply(String identityNo, String trueName, String cardNo, String mobile) {
        //测试环境
        String url = URL + "three_items_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("idType", "IC");
        body.put("trueName", trueName);
        body.put("cardNo", cardNo);
        body.put("identityNo", identityNo);
        body.put("mobile", mobile);

        return HttpMas.post(url, body, key);
    }

    public String four_items_apply(String identityNo, String trueName, String mobile, String cardNo) {
        //测试环境
        String url = URL + "four_items_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("idType", "IC");
        body.put("trueName", trueName);
        body.put("cardNo", cardNo);
        body.put("identityNo", identityNo);
        body.put("mobile", mobile);
        return HttpMas.post(url, body, key);
    }

    public String idcard_badinfo_apply(String identityNo, String trueName) {
        //测试环境
        String url = URL + "idcard_badinfo_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("signType", "RSA");
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("idType", "IC");
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);
        return HttpMas.post(url, body, key);
    }

    public String education_items_apply(String identityNo, String trueName) {
        //测试环境
        String url = URL + "education_items_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();

        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("signType", "RSA");
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);
        return HttpMas.post(url, body, key);
    }

    public String photo_comp_apply(String identityNo, String trueName, String photo) {
        //测试环境
        String url = URL + "photo_comp_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("signType", "RSA");
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);
        body.put("photo", photo);
        return HttpMas.post(url, body, key);
    }

    public String mobile_status_apply(String mobile) {
        //测试环境
        String url = URL + "mobile_status_apply";
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("signType", "RSA");
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("mobile", mobile);
        return HttpMas.post(url, body, key);
    }

    public String mobile_time_apply(String mobile) {

        //测试环境
        String url = URL + "mobile_time_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        //body.put("signType", "RSA");
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("mobile", mobile);
        return HttpMas.post(url, body, key);
    }

    public String mutidebit_items_apply(String identityNo, String trueName, String mobile) {
        //测试环境
        String url = URL + "mutidebit_items_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);
        body.put("mobile", mobile);
        return HttpMas.post(url, body, key);
    }

    public String black_items_apply(String identityNo, String trueName, String mobile) {
        //测试环境
        String url = URL + "black_items_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("signType", "RSA");
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);
        body.put("mobile", mobile);
        return HttpMas.post(url, body, key);
    }

    public String interview_items_apply(String identityNo, String trueName, String mobile) {
        //测试环境
        String url = URL + "interview_items_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("signType", "RSA");
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);
        body.put("mobile", mobile);
        return HttpMas.post(url, body, key);
    }

    public String personflight_items_apply(String identityNo, String trueName, String month) {
        //测试环境
        String url = URL + "personflight_items_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("signType", "RSA");
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);
        body.put("month", month);//最近乘机月份范围，只能输入3，6，9
        return HttpMas.post(url, body, key);
    }

    public String residence_items_apply(String identityNo, String trueName) {
        // 测试环境
        String url = URL + "residence_items_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("signType", "RSA");
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);
        return HttpMas.post(url, body, key);
    }

    public String banktrade_items_apply(String identityNo, String trueName, String cardNo, String mobile) {
        // 测试环境
        String url = URL + "banktrade_items_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("signType", "RSA");
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);
        body.put("cardNo", cardNo);
        body.put("mobile", mobile);
        return HttpMas.post(url, body, key);
    }

    public String personinvest_items_apply(String identityNo, String trueName) {
        // 测试环境
        String url = URL + "personinvest_items_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("signType", "RSA");
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);
        return HttpMas.post(url, body, key);
    }

    public String badinfo_detail_apply(String identityNo, String trueName) {
        // 测试环境
        String url = URL + "badinfo_detail_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("charset", CHARSET);
        body.put("merchantNo", merchantNo);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);

        return HttpMas.post(url, body, key);
    }

    public String person_face_apply(String photo, String image) {
        // 测试环境
        String url = URL + "person_face_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("photo", photo);
        body.put("image", image);
        //MD5加密
        body.put("signType", "MD5");
        //RSA加密
        //m.put("signType", "RSA");
        return HttpMas.post(url, body, key);
    }

    public String drive_five_items_apply(String identityNo, String trueName, String archiveNo, String firstRecDate,
            String permitModel) {
        //测试环境
        String url = URL + "drive_five_items_apply";
        //测试key
        String merchantNo = MERCHANT_NO;
        Map<String, String> body = new LinkedHashMap<String, String>();
        String key = KEY;
        body.put("signType", SIGN_TYPE);
        body.put("requestTime",
                String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime())));
        body.put("signType", "RSA");
        body.put("merchantNo", merchantNo);
        body.put("charset", CHARSET);
        body.put("merchantOrderNo", "T" + System.currentTimeMillis());
        body.put("trueName", trueName);
        body.put("identityNo", identityNo);
        body.put("archiveNo", archiveNo);
        body.put("firstRecDate", firstRecDate);
        body.put("permitModel", permitModel);
        return HttpMas.post(url, body, key);
    }
}
