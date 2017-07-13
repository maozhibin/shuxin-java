package com.baoquan.shuxin.service.impl.product.api;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.net.ssl.SSLContext;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;

import com.baoquan.shuxin.config.product.api.HuntianConfig;
import com.baoquan.shuxin.service.spi.product.api.HuntianService;
import com.baoquan.shuxin.util.product.api.fahai.FaHaiHttpClient;
import com.baoquan.shuxin.util.product.api.huntian.SHA256;

/**
 * Created by Administrator on 2017/5/4.
 */
@Named
public class HuntianServiceImpl implements HuntianService {
    @Inject
    private HuntianConfig huntianConfig;

    private String UUID;

    private String SecretKey;

    private String scheme;

    private String host;

    private String path;

    @PostConstruct
    public void init() {
        this.UUID = huntianConfig.getHuntianUuid();
        this.SecretKey = huntianConfig.getHuntianAppSecret();
        this.scheme = huntianConfig.getHuntianScheme();
        this.host = huntianConfig.getHuntianHost();
        this.path = huntianConfig.getHuntianPath();
    }

    public String antiFraud(String scene, String phone, String ip, String imei, String imsi, String idcard, String name,
            String bankcard, String qq, String wechat, String email, String tel, String address, String url,
            String context) {
        try {
            URI uri;

            URIBuilder uriBuilder = new URIBuilder()
                    .setScheme(scheme)
                    .setHost(host)
                    .setPath(path);

            TreeMap<String, String> params = new TreeMap<String, String>();
            params.put("timestamp", String.valueOf(System.currentTimeMillis()));
            params.put("uuid", UUID);
            params.put("action", "fraud");
            params.put("scene", scene);
            params.put("phone", phone);

            pushMap(params, "imsi", imsi);
            pushMap(params, "imei", imei);
            pushMap(params, "idcard", idcard);
            pushMap(params, "name", name);
            pushMap(params, "bankcard", bankcard);
            pushMap(params, "qq", qq);
            pushMap(params, "wechat", wechat);
            pushMap(params, "email", email);
            pushMap(params, "tel", tel);
            pushMap(params, "address", address);
            pushMap(params, "url", url);
            pushMap(params, "context", context);

            System.out.println(params);

            SHA256 sha256 = new SHA256();
            String token = sha256.sign(params, SecretKey);

            params.put("token", token.toLowerCase());

            for (String key : params.keySet()) {
                uriBuilder = uriBuilder.setParameter(key, params.get(key));
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

            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);

            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(
                    sslConnectionSocketFactory).build();


            FaHaiHttpClient faHaiHttpClient = new FaHaiHttpClient();
            return faHaiHttpClient.Get(httpClient, uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void pushMap(TreeMap<String, String> params, String key, String value) {
        if (value != null) {
            try {
                params.put(key, URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                System.out.println("Unsupported encoding");
            }

        }
    }

    public String identityVerify(String name, String identityNo, String validityBegin, String validityEnd) {
        try {
            URI uri;

            URIBuilder uriBuilder = new URIBuilder()
                    .setScheme(scheme)
                    .setHost(host)
                    .setPath(path);

            TreeMap<String, String> params = new TreeMap<String, String>();
            params.put("timestamp", String.valueOf(System.currentTimeMillis()));
            params.put("uuid", UUID);
            params.put("action", "identity_verify");
            params.put("name", URLEncoder.encode(name, "UTF-8"));
            params.put("id_no", identityNo);

            pushMap(params, "validity_begin", validityBegin);
            pushMap(params, "validity_end", validityEnd);

            SHA256 sha256 = new SHA256();
            String token = sha256.sign(params, SecretKey);

            params.put("token", token.toLowerCase());

            for (String key : params.keySet()) {
                uriBuilder = uriBuilder.setParameter(key, params.get(key));
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

            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);

            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(
                    sslConnectionSocketFactory).build();


            FaHaiHttpClient faHaiHttpClient = new FaHaiHttpClient();
            return faHaiHttpClient.Get(httpClient, uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String statistics() {
        try {
            URI uri;

            URIBuilder uriBuilder = new URIBuilder()
                    .setScheme(scheme)
                    .setHost(host)
                    .setPath(path);

            TreeMap<String, String> params = new TreeMap<String, String>();
            params.put("timestamp", String.valueOf(System.currentTimeMillis()));
            params.put("uuid", UUID);
            params.put("action", "statistics");

            SHA256 sha256 = new SHA256();
            String token = sha256.sign(params, SecretKey);

            params.put("token", token.toLowerCase());

            for (String key : params.keySet()) {
                uriBuilder = uriBuilder.setParameter(key, params.get(key));
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

            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);

            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(
                    sslConnectionSocketFactory).build();

            FaHaiHttpClient faHaiHttpClient = new FaHaiHttpClient();
            return faHaiHttpClient.Get(httpClient, uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
