package name.ben.shepley.fsql._harness.database.h2.model;

import java.math.BigDecimal;

public class Customer {
    private String custCode;
    private String custName;
    private String custCity;
    private String workingArea;
    private String custCountry;
    private Integer grade;
    private BigDecimal openingAmtNumber;
    private BigDecimal receiveAmt;
    private BigDecimal paymentAmt;
    private BigDecimal outstandingAmt;
    private String phoneNo;
    private String agentCode;

    public String getCustCode() {
        return custCode;
    }
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustCity() {
        return custCity;
    }
    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getWorkingArea() {
        return workingArea;
    }
    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public String getCustCountry() {
        return custCountry;
    }
    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }

    public Integer getGrade() {
        return grade;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public BigDecimal getOpeningAmtNumber() {
        return openingAmtNumber;
    }
    public void setOpeningAmtNumber(BigDecimal openingAmtNumber) {
        this.openingAmtNumber = openingAmtNumber;
    }

    public BigDecimal getReceiveAmt() {
        return receiveAmt;
    }
    public void setReceiveAmt(BigDecimal receiveAmt) {
        this.receiveAmt = receiveAmt;
    }

    public BigDecimal getPaymentAmt() {
        return paymentAmt;
    }
    public void setPaymentAmt(BigDecimal paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public BigDecimal getOutstandingAmt() {
        return outstandingAmt;
    }
    public void setOutstandingAmt(BigDecimal outstandingAmt) {
        this.outstandingAmt = outstandingAmt;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAgentCode() {
        return agentCode;
    }
    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }
}
