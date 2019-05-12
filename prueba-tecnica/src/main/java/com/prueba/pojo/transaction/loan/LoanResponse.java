
package com.prueba.pojo.transaction.loan;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "startDate",
    "endDate",
    "total",
    "debt",
    "interestRate",
    "interestAmount",
    "transactions"
})
public class LoanResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("debt")
    private Float debt;
    @JsonProperty("interestRate")
    private Float interestRate;
    @JsonProperty("interestAmount")
    private Float interestAmount;
    @JsonProperty("transactions")
    private List<Transaction> transactions = null;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("debt")
    public Float getDebt() {
        return debt;
    }

    @JsonProperty("debt")
    public void setDebt(Float debt) {
        this.debt = debt;
    }

    @JsonProperty("interestRate")
    public Float getInterestRate() {
        return interestRate;
    }

    @JsonProperty("interestRate")
    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    @JsonProperty("interestAmount")
    public Float getInterestAmount() {
        return interestAmount;
    }

    @JsonProperty("interestAmount")
    public void setInterestAmount(Float interestAmount) {
        this.interestAmount = interestAmount;
    }

    @JsonProperty("transactions")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @JsonProperty("transactions")
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
