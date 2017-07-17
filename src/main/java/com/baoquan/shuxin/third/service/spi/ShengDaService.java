package com.baoquan.shuxin.third.service.spi;

public interface ShengDaService {

    public String idcard_two_apply(String identityNo, String trueName);

    public String mobile_items_apply(String identityNo, String trueName, String mobile);

    public String three_items_apply(String identityNo, String trueName, String cardNo, String mobile);

    public String four_items_apply(String identityNo, String trueName, String mobile, String cardNo);

    public String idcard_badinfo_apply(String identityNo, String trueName);

    public String education_items_apply(String identityNo, String trueName);

    public String photo_comp_apply(String identityNo, String trueName, String photo);

    public String mobile_status_apply(String mobile);

    public String mobile_time_apply(String mobile);

    public String mutidebit_items_apply(String identityNo, String trueName, String mobile);

    public String black_items_apply(String identityNo, String trueName, String mobile);

    public String interview_items_apply(String identityNo, String trueName, String mobile);

    public String personflight_items_apply(String identityNo, String trueName, String month);

    public String residence_items_apply(String identityNo, String trueName);

    public String banktrade_items_apply(String identityNo, String trueName, String cardNo, String mobile);

    public String personinvest_items_apply(String identityNo, String trueName);

    //以下为无文档接口
    public String badinfo_detail_apply(String identityNo, String trueName);

    public String person_face_apply(String photo, String image);

    public String drive_five_items_apply(String identityNo, String trueName, String archiveNo, String firstRecDate,
            String permitModel);
}
