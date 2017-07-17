package com.baoquan.shuxin.third.util.fahai;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/2.
 */
public class Type {
    private static Map<String, String> typeMap = new HashMap<String, String>() {
        {
            //裁判文书
            put("CPWS", "cpws");
            //执行公告
            put("ZXGG", "zxgg");
            //失信公告
            put("SXGG", "shixin");
            //开庭公告
            put("KTGG", "ktgg");
            //法院公告
            put("FYGG", "fygg");
            //网贷黑名单
            put("FDHMD", "wdhmd");
            //案件流程信息
            put("AJLC", "ajlc");
            //曝光台
            put("BGT", "bgt");
        }
    };
}
