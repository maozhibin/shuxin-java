package com.baoquan.shuxin.third.service.spi;

/**
 * Created by Administrator on 2017/5/2.
 */
public interface FaHaiService {
    public String fullQuery(String keyWord, String dataType, String pageNo);

    public String detail(String id, String searchType, String dataType);

    public String companyQuery(String name, String identityNo, String dataType, String pageNo, String range);

    public String personQuery(String name, String identityNo, String dataType, String pageNo, String range);

}
