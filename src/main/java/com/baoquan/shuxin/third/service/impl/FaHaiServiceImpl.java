package com.baoquan.shuxin.third.service.impl;

import java.net.URI;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import com.baoquan.shuxin.config.product.api.FahaiConfig;
import com.baoquan.shuxin.third.service.spi.FaHaiService;
import com.baoquan.shuxin.third.util.fahai.FaHaiHttpClient;

/**
 * Created by Administrator on 2017/5/2.
 */
@Named
public class FaHaiServiceImpl implements FaHaiService {
    @Inject
    private FahaiConfig fahaiConfig;

    private URI uri;

    private static Logger logger = Logger.getLogger(FaHaiServiceImpl.class);

    public String fullQuery(String keyWord, String dataType, String pageNo) {
        try {
            URIBuilder uriBuilder = new URIBuilder()
                    .setScheme(fahaiConfig.getFahaiScheme())
                    .setHost(fahaiConfig.getFahaiHost())
                    .setPath("/fhfk/query.jsp")
                    .setParameter("authCode", fahaiConfig.getFahaiAuthCode())
                    .setParameter("q", keyWord);
            if (dataType != null) {
                uriBuilder = uriBuilder.setParameter("datatype", dataType);
            }

            if (pageNo != null) {
                uriBuilder = uriBuilder.setParameter("pageno", pageNo);
            }

            uri = uriBuilder.build();

            CloseableHttpClient httpClient = HttpClients.createDefault();

            FaHaiHttpClient faHaiHttpClient = new FaHaiHttpClient();
            return faHaiHttpClient.Get(httpClient, uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String detail(String id, String searchType, String dataType) {
        try {
            URIBuilder uriBuilder = new URIBuilder()
                    .setScheme(fahaiConfig.getFahaiScheme())
                    .setHost(fahaiConfig.getFahaiHost())
                    .setPath("/fhfk/entry.jsp")
                    .setParameter("authCode", fahaiConfig.getFahaiAuthCode())
                    .setParameter("id", id);

            if (searchType != null) {
                uriBuilder = uriBuilder.setParameter("searchType", "abstract");
            }

            if (dataType != null) {
                uriBuilder = uriBuilder.setParameter("datatype", "party");
            }
            uri = uriBuilder.build();

            CloseableHttpClient httpClient = HttpClients.createDefault();

            FaHaiHttpClient faHaiHttpClient = new FaHaiHttpClient();
            return faHaiHttpClient.Get(httpClient, uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String companyQuery(String name, String identityNo, String dataType, String pageNo, String range) {
        try {
            URIBuilder uriBuilder = new URIBuilder()
                    .setScheme(fahaiConfig.getFahaiScheme())
                    .setHost(fahaiConfig.getFahaiHost())
                    .setPath("/fhfk/query.jsp")
                    .setParameter("authCode", fahaiConfig.getFahaiAuthCode())
                    .setParameter("q", "pname:" + name);

            if (dataType != null) {
                uriBuilder = uriBuilder.setParameter("datatype", dataType);
            }

            if (pageNo != null) {
                uriBuilder = uriBuilder.setParameter("pageno", pageNo);
            }

            if (range != null) {
                uriBuilder = uriBuilder.setParameter("range", range);
            }
            uri = uriBuilder.build();

            CloseableHttpClient httpClient = HttpClients.createDefault();

            FaHaiHttpClient faHaiHttpClient = new FaHaiHttpClient();
            return faHaiHttpClient.Get(httpClient, uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public String personQuery(String name, String identityNo, String dataType, String pageNo, String range) {
        try {
            URIBuilder uriBuilder = new URIBuilder()
                    .setScheme(fahaiConfig.getFahaiScheme())
                    .setHost(fahaiConfig.getFahaiHost())
                    .setPath("/fhfk/person.jsp")
                    .setParameter("authCode", fahaiConfig.getFahaiAuthCode())
                    .setParameter("pname", name)
                    .setParameter("idcardNo", identityNo);

            if (dataType != null) {
                uriBuilder = uriBuilder.setParameter("datatype", dataType);
            }

            if (pageNo != null) {
                uriBuilder = uriBuilder.setParameter("pageno", pageNo);
            }

            if (range != null) {
                uriBuilder = uriBuilder.setParameter("range", range);
            }
            uri = uriBuilder.build();

            CloseableHttpClient httpClient = HttpClients.createDefault();

            FaHaiHttpClient faHaiHttpClient = new FaHaiHttpClient();
            return faHaiHttpClient.Get(httpClient, uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
