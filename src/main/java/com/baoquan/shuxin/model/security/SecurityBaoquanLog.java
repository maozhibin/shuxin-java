package com.baoquan.shuxin.model.security;

public class SecurityBaoquanLog {
    private Integer id;

    private Byte type;

    private String typeId;

    private String contract;

    private String recordNo;

    private Integer securityTime;

    private Integer successTime;

    private Integer status;

    private Integer userId;

    private Integer userType;

    private String mobile;

    private String idcard;

    private String uscc;

    private String modelNo;

    private String filePath;

    private Integer downloadType;

    private String securityData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract == null ? null : contract.trim();
    }

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo == null ? null : recordNo.trim();
    }

    public Integer getSecurityTime() {
        return securityTime;
    }

    public void setSecurityTime(Integer securityTime) {
        this.securityTime = securityTime;
    }

    public Integer getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Integer successTime) {
        this.successTime = successTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getUscc() {
        return uscc;
    }

    public void setUscc(String uscc) {
        this.uscc = uscc == null ? null : uscc.trim();
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo == null ? null : modelNo.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Integer getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(Integer downloadType) {
        this.downloadType = downloadType;
    }

    public String getSecurityData() {
        return securityData;
    }

    public void setSecurityData(String securityData) {
        this.securityData = securityData == null ? null : securityData.trim();
    }
}