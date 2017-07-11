package com.baoquan.shuxin.service.impl.product.api;

import java.net.URI;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Named;
import javax.net.ssl.SSLContext;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.log4j.Logger;

import com.baoquan.shuxin.service.spi.product.api.UnionPaySmartService;
import com.baoquan.shuxin.util.MD5Util;
import com.baoquan.shuxin.util.product.api.cfca.JsonUtils;
import com.baoquan.shuxin.util.product.api.fahai.FaHaiHttpClient;

/**
 * Created by Administrator on 2017/5/4.
 */
@Named
public class UnionPaySmartImpl implements UnionPaySmartService {
    private static Logger logger = Logger.getLogger(UnionPaySmartImpl.class);

    public final static String TEST_URL = "222.72.248.198";

    private final static String TEST_TAL_ACCOUNT = "T99999";

    private final static String TEST_TAL_SECRECT_KEY = "dbf9b1be199abd09a4a75f1bb08a37a8";

    private final static String TEST_ACCOUNT = "T202009";

    private final static String TEST_SECRECT_KEY = "T202009";

    //法院信息查询
    public String info_executed(String entityName, String entityId) {
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("account", TEST_ACCOUNT);
        if (entityName == null && entityId == null) {
            throw new RuntimeException("参数不能同时为空");
        }
        if (entityName != null) {
            params.put("entityName", entityName);
        }
        if (entityId != null) {
            params.put("entityId", entityId);
        }
        return HttpSend("/info/executed", params);
    }

    public String info_judgement(String entityName, String type) {
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("account", TEST_ACCOUNT);
        params.put("entityName", entityName);
        if (type != null) {
            params.put("type", type);
        }
        return HttpSend("/info/judgement", params);
    }

    public String info_judgement_detail(String id) {
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("account", TEST_ACCOUNT);
        params.put("id", id);
        return HttpSend("/info/court", params);
    }

    public String info_court(String entityName, String type) {
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("account", TEST_ACCOUNT);
        params.put("entityName", entityName);
        if (type != null) {
            params.put("type", type);
        }
        return HttpSend("/info/judgementDetail", params);
    }

    public String info_court_detail(String id) {
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("account", TEST_ACCOUNT);
        params.put("id", id);
        return HttpSend("/info/courtDetail", params);
    }

    public String info_dishonesty(String entityName, String entityId) {
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("account", TEST_ACCOUNT);
        if (entityName == null && entityId == null) {
            throw new RuntimeException("参数不能同时为空");
        }
        if (entityName != null) {
            params.put("entityName", entityName);
        }
        if (entityId != null) {
            params.put("entityId", entityId);
        }
        return HttpSend("/info/dishonesty", params);
    }

    //个人信息查询
    public String info_personal_invest(String cid) {
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("account", TEST_ACCOUNT);
        params.put("cid", cid);
        return HttpSend("/info/personalInvest", params);
    }

    private String HttpSend(String path, TreeMap<String, String> params) {
        try {
            URI uri;

            URIBuilder uriBuilder = new URIBuilder()
                    .setScheme("https")
                    .setHost(TEST_URL)
                    .setPath(path);


            StringBuilder str = new StringBuilder();
            //HashMap默认已经排好序
            for (String key : params.keySet()) {
                String value = URLEncoder.encode(params.get(key), "UTF-8");
                str.append(value);
            }
            str.append(TEST_SECRECT_KEY);

            String token = MD5Util.MD5(str.toString());

            if (token == null) {
                System.out.println("empty sign result");
            } else {
                params.put("sign", token.toUpperCase());
            }

            for (String key : params.keySet()) {
                uriBuilder = uriBuilder.setParameter(key, URLEncoder.encode(params.get(key), "UTF-8"));
            }
            uri = uriBuilder.build();

            SSLContext sslContext = SSLContexts.custom().useProtocol("TLS").loadTrustMaterial(null,
                    new TrustStrategy() {
                        public boolean isTrusted(X509Certificate[] x509Certificates, String s)
                                throws CertificateException {
                            //默认都信任
                            return true;
                        }
                    }).build();

            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
                    NoopHostnameVerifier.INSTANCE);

            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(
                    sslConnectionSocketFactory).build();

            FaHaiHttpClient faHaiHttpClient = new FaHaiHttpClient();
            String result = faHaiHttpClient.Get(httpClient, uri);
            logger.info(result);
            Map response = JsonUtils.json2Obj(result, Map.class);
            if ("0000".equals(response.get("resCode"))) {
                return JsonUtils.obj2Json(response.get("data"));
            } else {
                logger.error("查询失败");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
