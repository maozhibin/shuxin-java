package com.baoquan.shuxin.service.spi.product.api;

/**
 * Created by Administrator on 2017/5/9.
 */
public interface GeotmtService {
    public String real_1_dimension_name_verify(String cid, String idNumber, String realName);

    public String real_2_dimension_name_verify(String cid, String idNumber, String realName);

    public String cellphone_online_time(String cid, String idNumber, String realName);

    public String cellphone_online_status(String cid, String idNumber, String realName);

    public String cellphone_own_numbers(String cid, String idNumber, String realName);

    public String cellphone_change_frequency(String cid, String idNumber, String realName);

    public String cellphone_month_consumption(String cid, String idNumber, String realName);

    public String cellphone_3month_consumption_sum(String cid, String idNumber, String realName, String month);

    public String cellphone_location(String cid, String idNumber, String realName, String usualaddress);

    public String real_3_dimension_name_verify(String cid, String idNumber, String realName);

    public String cellphone_work_location(String cid, String idNumber, String realName);

    public String cellphone_frequent_contacts_verify(String cid, String idNumber, String realName, String cid2);

    public String cellphone_3_month_stop(String cid, String idNumber, String realName);

    public String cellphone_arrears(String cid, String idNumber, String realName);

    public String cellphone_rest_location(String cid, String idNumber, String realName);

    public String cellphone_work_location_offset(String cid, String idNumber, String realName, String longitude,
            String latitude);

    public String cellphone_rest_location_offset(String cid, String idNumber, String realName, String longitude,
            String latitude);

    public String cellphone_realtime_location_offset(String cid, String idNumber, String realName, String longitude,
            String latitude);

    public String cellphone_month_data_usage(String cid, String idNumber, String realName);

    public String cellphone_age(String cid, String idNumber, String realName);

    public String cellphone_gender(String cid, String idNumber, String realName);

    public String cellphone_month_top_call_city(String cid, String idNumber, String realName, String month);

    public String cellphone_month_payment(String cid, String idNumber, String realName);

    public String cellphone_terminal_type(String cid, String idNumber, String realName);

    public String cellphone_contract_count(String cid, String idNumber, String realName, String cid2);

    public String cellphone_identity_verify(String cid, String idNumber, String realName);

    public String cellphone_company_verify(String cid, String idNumber, String realName);

    public String cellphone_prepaid(String cid, String idNumber, String realName);

    public String cellphone_month_arrears(String cid, String idNumber, String realName, String month);

    public String cellphone_blacklist_verify(String cid, String idNumber, String realName);

    public String cellphone_user_level(String cid, String idNumber, String realName);

    public String financial_stability_evaluation(String cid, String idNumber, String realName);

    public String highest_education(String cid, String idNumber, String realName);

    public String name_identity_verify(String cid, String idNumber, String realName);

    public String name_identity_verify_with_photo(String cid, String idNumber, String realName);

    public String identity_hit_dishonest(String cid, String idNumber, String realName);

    public String identity_hit_execution(String cid, String idNumber, String realName);

    public String identity_hit_after_loan_management(String cid, String idNumber, String realName);

    public String identity_hit_blacklist(String cid, String idNumber, String realName);

    public String identity_hit_drag_or_fugitive(String cid, String idNumber, String realName);

    public String identity_hit_fraud(String cid, String idNumber, String realName);

    public String identity_hit_bank(String cid, String idNumber, String realName);

    public String identity_hit_insurance_fraud(String cid, String idNumber, String realName);

    public String identity_hit_p2p(String cid, String idNumber, String realName);

    public String identity_hit_overdue(String cid, String idNumber, String realName);

    public String cellphone_hit_dishonest(String cid, String idNumber, String realName);

    public String cellphone_hit_execution(String cid, String idNumber, String realName);

    public String cellphone_hit_blacklist(String cid, String idNumber, String realName);

    public String cellphone_hit_drag_or_fugitive(String cid, String idNumber, String realName);

    public String cellphone_hit_fraud(String cid, String idNumber, String realName);

    public String cellphone_hit_bank(String cid, String idNumber, String realName);

    public String cellphone_hit_insurance_fraud(String cid, String idNumber, String realName);

    public String cellphone_hit_p2p(String cid, String idNumber, String realName);

    public String cellphone_hit_overdue(String cid, String idNumber, String realName);

    public String cellphone_hit_intermediary(String cid, String idNumber, String realName);

    public String overdue_query(String cid, String idNumber, String cycle, String realName);

    public String identity_3_day_apply(String cid, String idNumber, String realName);

    public String identity_7_day_apply(String cid, String idNumber, String realName);

    public String identity_1_month_apply(String cid, String idNumber, String realName);

    public String identity_3_month_apply(String cid, String idNumber, String realName);

    public String cellphone_3_day_apply(String cid, String idNumber, String realName);

    public String cellphone_7_day_apply(String cid, String idNumber, String realName);

    public String cellphone_1_month_apply(String cid, String idNumber, String realName);

    public String cellphone_3_month_apply(String cid, String idNumber, String realName);
}