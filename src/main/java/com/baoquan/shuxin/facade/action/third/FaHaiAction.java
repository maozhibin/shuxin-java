package com.baoquan.shuxin.facade.action.third;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baoquan.shuxin.bean.JsonBean;
import com.baoquan.shuxin.third.service.spi.FaHaiService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * Created by Administrator on 2017/5/2.
 */
@Controller
@RequestMapping("/fahai")
@Api(value = "fa-hai-api", description = "法海风控", position = 0)
public class FaHaiAction {
    @Inject
    private FaHaiService faHaiServiceImpl;

    @ResponseBody
    @RequestMapping("/fullQuery")
    @ApiOperation(value = "全文检索", httpMethod = "POST", response = JsonBean.class, notes = "全文检索(模糊查询)")
    public JsonBean fullQuery(
            @ApiParam(name = "q", value = "关键字", required = true) @RequestParam(value = "q", required = true) String q,
            @ApiParam(name = "datatype", value = "数据类型", required = false)
            @RequestParam(value = "datatype", required = false) String datatype,
            @ApiParam(name = "pageno", value = "页码", required = false) @RequestParam(value = "pageno", required = false)
                    String pageno) {
        JsonBean jsonBean = new JsonBean();
        try {
            Logger logger = Logger.getLogger(FaHaiAction.class);
            logger.debug("datetype is " + datatype + " and pageno is " + pageno);
            String str = faHaiServiceImpl.fullQuery(q, datatype, pageno);

            System.out.println(str);
            jsonBean.setCode(10000);
            jsonBean.setData(JSON.parse(str));

        } catch (Exception e) {
            e.printStackTrace();
            jsonBean.setCode(-1);
            jsonBean.setMessage(e.getMessage());
        }
        return jsonBean;
    }

    @ResponseBody
    @RequestMapping("/fullDetail")
    @ApiOperation(value = "详情查询", httpMethod = "POST", response = JsonBean.class, notes = "详情查询(模糊查询)")
    public JsonBean fullDetail(
            @ApiParam(name = "id", value = "ID", required = true) @RequestParam(value = "id", required = true)
                    String id,
            @ApiParam(name = "searchType", value = "摘要查询", required = false, allowableValues = "abstract")
            @RequestParam(value = "searchType", required = false) String searchType,
            @ApiParam(name = "dataType", value = "根据partyId查询", required = false, allowableValues = "party")
            @RequestParam(value = "dataType", required = false) String dataType) {
        return queryDetail(id, searchType, dataType);
    }

    @ResponseBody
    @RequestMapping("/companyQuery")
    @ApiOperation(value = "企业关键词查询", httpMethod = "POST", response = JsonBean.class, notes = "企业关键词查询")
    public JsonBean companyQuery(
            @ApiParam(name = "name", value = "公司名称", required = true) @RequestParam(value = "name", required = true)
                    String name, @ApiParam(name = "idcardNo", value = "组织机构代码", required = false)
    @RequestParam(value = "idcardNo", required = false) String idcardNo,
            @ApiParam(name = "datatype", value = "数据类型", required = false)
            @RequestParam(value = "datatype", required = false) String datatype,
            @ApiParam(name = "pageno", value = "页码", required = false) @RequestParam(value = "pageno", required = false)
                    String pageno,
            @ApiParam(name = "range", value = "每页返回", required = false) @RequestParam(value = "range", required = false)
                    String range) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = faHaiServiceImpl.companyQuery(name, idcardNo, datatype, pageno, range);

            jsonBean.setCode(10000);
            jsonBean.setData(JSON.parse(str));

        } catch (Exception e) {
            e.printStackTrace();
            jsonBean.setCode(-1);
            jsonBean.setMessage(e.getMessage());
        }
        return jsonBean;
    }

    @ResponseBody
    @RequestMapping("/companyDetail")
    @ApiOperation(value = "企业详细查询", httpMethod = "POST", response = JsonBean.class, notes = "企业详细查询")
    public JsonBean companyDetail(
            @ApiParam(name = "id", value = "ID", required = true) @RequestParam(value = "id", required = true)
                    String id,
            @ApiParam(name = "searchType", value = "摘要查询", required = false, allowableValues = "abstract")
            @RequestParam(value = "searchType", required = false) String searchType,
            @ApiParam(name = "dataType", value = "根据partyId查询", required = false, allowableValues = "party")
            @RequestParam(value = "dataType", required = false) String dataType) {
        return queryDetail(id, searchType, dataType);
    }

    @ResponseBody
    @RequestMapping("/personQuery")
    @ApiOperation(value = "个人关键词查询", httpMethod = "POST", response = JsonBean.class, notes = "个人关键词查询")
    public JsonBean personQuery(
            @ApiParam(name = "name", value = "姓名", required = true) @RequestParam(value = "name", required = true)
                    String name, @ApiParam(name = "idcardNo", value = "身份证号码", required = false)
    @RequestParam(value = "idcardNo", required = false) String idcardNo,
            @ApiParam(name = "datatype", value = "数据类型", required = false)
            @RequestParam(value = "datatype", required = false) String datatype,
            @ApiParam(name = "pageno", value = "页码", required = false) @RequestParam(value = "pageno", required = false)
                    String pageno,
            @ApiParam(name = "range", value = "每页返回", required = false) @RequestParam(value = "range", required = false)
                    String range) {
        JsonBean jsonBean = new JsonBean();
        try {
            String str = faHaiServiceImpl.personQuery(name, idcardNo, datatype, pageno, range);

            jsonBean.setCode(10000);
            jsonBean.setData(JSON.parse(str));

        } catch (Exception e) {
            e.printStackTrace();
            jsonBean.setCode(-1);
            jsonBean.setMessage(e.getMessage());
        }
        return jsonBean;
    }

    @ResponseBody
    @RequestMapping("/personDetail")
    @ApiOperation(value = "个人详细查询", httpMethod = "POST", response = JsonBean.class, notes = "个人详细查询")
    public JsonBean personDetail(
            @ApiParam(name = "id", value = "ID", required = true) @RequestParam(value = "id", required = true)
                    String id,
            @ApiParam(name = "searchType", value = "摘要查询", required = false, allowableValues = "abstract")
            @RequestParam(value = "searchType", required = false) String searchType,
            @ApiParam(name = "dataType", value = "根据partyId查询", required = false, allowableValues = "party")
            @RequestParam(value = "dataType", required = false) String dataType) {
        return queryDetail(id, searchType, dataType);
    }

    private JsonBean queryDetail(String id, String searchType, String dataType) {
        JsonBean jsonBean = new JsonBean();

        try {
            String str = faHaiServiceImpl.detail(id, searchType, dataType);

            jsonBean.setCode(10000);
            jsonBean.setData(JSON.parse(str));

        } catch (Exception e) {
            e.printStackTrace();
            jsonBean.setCode(-1);
            jsonBean.setMessage(e.getMessage());
        }

        return jsonBean;
    }
}
