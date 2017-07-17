package com.baoquan.shuxin.third.service.spi;

/**
 * Created by Administrator on 2017/5/4.
 */
public interface UnionPaySmartService {
    public String info_executed(String entityName, String entityId);

    public String info_dishonesty(String entityName, String entityId);

    public String info_judgement(String entityName, String type);

    public String info_judgement_detail(String id);

    public String info_court(String entityName, String type);

    public String info_court_detail(String id);

    public String info_personal_invest(String cid);
}
