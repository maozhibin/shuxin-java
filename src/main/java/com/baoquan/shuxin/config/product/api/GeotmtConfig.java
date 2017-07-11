package com.baoquan.shuxin.config.product.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/5/22.
 */
@Component("geotmtConfig")
public class GeotmtConfig {

    @Value("${geotmt.server}")
    private String geotmtServer;

    @Value("${geotmt.encrypted}")
    private int geotmtEncrypted;

    @Value("${geotmt.encryptionType}")
    private String geotmtEncryptionType;

    @Value("${geotmt.encryptionKey}")
    private String geotmtEncryptionKey;

    @Value("${geotmt.username}")
    private String geotmtUsername;

    @Value("${geotmt.password}")
    private String geotmtPassword;

    @Value("${geotmt.uno}")
    private String geotmtUno;

    @Value("${geotmt.etype}")
    private String geotmtEtype;

    @Value("${geotmt.dsign}")
    private int geotmtDsign;

    public String getGeotmtServer() {
        return geotmtServer;
    }

    public int getGeotmtEncrypted() {
        return geotmtEncrypted;
    }

    public String getGeotmtEncryptionType() {
        return geotmtEncryptionType;
    }

    public String getGeotmtEncryptionKey() {
        return geotmtEncryptionKey;
    }

    public String getGeotmtUsername() {
        return geotmtUsername;
    }

    public String getGeotmtPassword() {
        return geotmtPassword;
    }

    public String getGeotmtUno() {
        return geotmtUno;
    }

    public String getGeotmtEtype() {
        return geotmtEtype;
    }

    public int getGeotmtDsign() {
        return geotmtDsign;
    }
}
