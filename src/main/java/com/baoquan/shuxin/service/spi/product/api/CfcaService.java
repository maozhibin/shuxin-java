package com.baoquan.shuxin.service.spi.product.api;

public interface CfcaService {
    public String checkCompanyName(String companyMID, String companyName, String registrationNumber, String personName);

    public String checkCompanyType(String companyMID, String companyName, String registrationNumber, String personName);

    public String checkPOSBalanceMax(String companyMID, String companyName, String registrationNumber,
            String personName);

    public String searchPOSCardAcceptance(String companyMID, String companyName, String registrationNumber,
            String personName);

    public String searchPOSAnnulusGrowth(String companyMID, String companyName, String registrationNumber,
            String personName);

    public String searchPOSMoMIncrease(String companyMID, String companyName, String registrationNumber,
            String personName);

    public String cardConsumingFrequentCity(String personName, String cardNumber, String identityType,
            String identityNumber, String cellPhoneNumber,
            String email, String address);

    public String repaymentAbility(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address);

    public String cardLevel(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address);

    public String lastPaymentArea(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address);

    public String lastPaymentAmount(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address);

    public String yearPaymentSum(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address);

    public String consumptionLocationInfo(String personName, String cardNumber, String identityType,
            String identityNumber, String cellPhoneNumber,
            String email, String address);

    public String overseaPaymentSum(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address);

    public String cardChargeOffSum(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address);

    public String enterInAccountSum(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address);

    public String chargeOffMCC(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address);

    public String housePayment(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address);

    public String vehiclePayment(String personName, String cardNumber, String identityType, String identityNumber,
            String cellPhoneNumber,
            String email, String address);

    public String cellphoneAccountBalance(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String cellphoneOnlineMonths(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String checkDeviceNumber(String personName, String identityType, String identityNumber,
            String cellPhoneNumber, String deviceNumber);

    public String checkPersonalCellphoneNumbers(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String checkRoamingTimes(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String checkDataUsage(String personName, String identityType, String identityNumber, String cellPhoneNumber);

    public String check2YearNumberChanges(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String check3YearPhoneChanges(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String checkPhoneBrand(String personName, String identityType, String identityNumber, String
            cellPhoneNumber);

    public String checkBlacklistId(String personName, String identityType, String identityNumber);

    public String checkBlacklistAccount(String personName, String identityType, String identityNumber,
            String cardNumber);

    public String checkPersonalId(String personName, String identityType, String identityNumber);

    public String checkPersonalAccount(String cardNumber, String bankId, String cardType, String validDate, String cvn2,
            String personName,
            String identityType, String identityNumber, String cellPhoneNumber);

    public String cellphoneAccountOverdue(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String cellphoneAccountRewardPoints(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String checkSim(String personName, String identityType, String identityNumber, String cellPhoneNumber,
            String imsi);

    public String check1YearNumberChanges(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String check1YearPhoneChanges(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String checkHighQualityEducation(String personName, String identityType, String identityNumber,
            String cellPhoneNumber,
            String highestEducation, String graduateInstitution, String graduateYear);

    public String educationBackgroundInfo(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String checkPhoneNumberLocation(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String checkDepositBank(String personName, String identityType, String identityNumber, String cardNumber);

    public String checkPersonalIdT2(String personName, String identityType, String identityNumber, String cardNumber,
            String photo);

    public String checkBlacklistIdT2(String personName, String identityType, String identityNumber);

    public String checkBlacklistAccountT2(String personName, String identityType, String identityNumber,
            String cardNumber);

    public String checkBlacklistCellphoneT2(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String searchPersonalJudgmentDocument(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String searchPersonalExecutionDocument(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String checkPersonalDiscreditInfo(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String searchPersonalP2PBlacklistInfo(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String personalFlightStatistic(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String companyRegistrationAndSupervisionReport(String companyName, String uniformCreditCode);

    public String searchLawpersonCompanyReport(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String educationInfoWithPhoto(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String checkPersonalAccountInfo(String personName, String identityType, String identityNumber,
            String cellPhoneNumber,
            String cardType, String validDate, String cvn2, String cardNumber);

    public String companyRegistrationInfo(String companyName, String uniformCreditCode);

    public String checkPersonPlateNum(String plateNumber, String vehicleType, String personName,
            String cellPhoneNumber);

    public String checkPersonEngineNumPlateNum(String plateNumber, String vehicleType, String engineNumber,
            String personName, String cellPhoneNumber);

    public String checkLegalDrivingVehicle(String drivingLicence, String personName, String vehicleType,
            String cellPhoneNumber);

    public String checkRegisteredDrivingVehicle(String plateNumber, String plateType, String personName,
            String registrationDate, String cellPhoneNumber);

    public String checkRegisteredDriver(String drivingLicence, String personName, String registrationDate,
            String cellPhoneNumber);

    public String checkRegisteredDriver1(String drivingLicence, String personName, String documentID,
            String cellPhoneNumber);

    public String checkPersonalIdentity(String personName, String identityType, String identityNumber,
            String cellPhoneNumb, String cardNumber,
            String vehicleType, String highestEducation, String photo);

    public String companyJudgmentDocument(String companyName, String uniformCreditCode);

    public String companyExecutionDocument(String companyName, String uniformCreditCode);

    public String checkCompanyDiscreditInfo(String companyName, String uniformCreditCode);

    public String companyOwingTax(String companyName, String uniformCreditCode);

    public String abnormalCompanyTaxpayerId(String companyName, String uniformCreditCode);

    public String cellphoneReadNameRegistration(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String censusRegistrationInfo(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String censusRegistrationPhoto(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String SMSDeliver(String destinationPhoneNumber, String SMSContent, String SMSSender);

    public String checkCellphoneLocation2(String personName, String identityType, String identityNumber,
            String cellPhoneNumber,
            String longitude, String latitude);

    public String checkBlacklistMerchantT2(String merchantName, String merchantIdType, String merchantId,
            String uniformCreditCode);

    public String uniRoamingTimes(String personName, String identityType, String identityNumber, String
            cellPhoneNumber);

    public String uniMonthlyConsumption(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String uniMonthlyDataUsage(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String uniLastUsingTime(String personName, String identityType, String identityNumber,
            String cellPhoneNumber);

    public String checkPersonalAccountInfo(String personName, String cellPhoneNumber);
}
