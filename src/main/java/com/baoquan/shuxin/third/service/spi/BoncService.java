package com.baoquan.shuxin.third.service.spi;

/**
 * Created by Administrator on 2017/5/18.
 */
public interface BoncService {
    public String groupNameFlag(String mobile);

    public String talkTimeLengthLabel(String mobile, String month);

    public String callCountTop5Label(String mobile, String month);

    public String roamCountIn3MonthsLabel(String mobile, String month);

    public String talkTimeLengthDawnPtgScore(String mobile, String month);

    public String abnormalContactScore(String mobile, String month);
}
