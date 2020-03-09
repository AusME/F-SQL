package name.ben.shepley.fsql._harness.database.h2.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Orders {
    private Integer ordNum;
    private BigDecimal ordAmount;
    private BigDecimal advanceAmount;
    private LocalDate ordDate;
    private String custCode;
    private String agentCode;
    private String ordDescription;

    public Integer getOrdNum() {
        return ordNum;
    }
    public void setOrdNum(Integer ordNum) {
        this.ordNum = ordNum;
    }

    public BigDecimal getOrdAmount() {
        return ordAmount;
    }
    public void setOrdAmount(BigDecimal ordAmount) {
        this.ordAmount = ordAmount;
    }

    public BigDecimal getAdvanceAmount() {
        return advanceAmount;
    }
    public void setAdvanceAmount(BigDecimal advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public LocalDate getOrdDate() {
        return ordDate;
    }
    public void setOrdDate(LocalDate ordDate) {
        this.ordDate = ordDate;
    }

    public String getCustCode() {
        return custCode;
    }
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getAgentCode() {
        return agentCode;
    }
    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getOrdDescription() {
        return ordDescription;
    }
    public void setOrdDescription(String ordDescription) {
        this.ordDescription = ordDescription;
    }
}
