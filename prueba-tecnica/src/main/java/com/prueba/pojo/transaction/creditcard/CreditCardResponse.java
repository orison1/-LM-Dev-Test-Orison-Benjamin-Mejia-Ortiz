
package com.prueba.pojo.transaction.creditcard;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "startDate",
    "endDate",
    "limit",
    "available",
    "interestRate",
    "interestAmount",
    "MonthlyCut",
    "transactions"
})
public class CreditCardResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("available")
    private Float available;
    @JsonProperty("interestRate")
    private Float interestRate;
    @JsonProperty("interestAmount")
    private Float interestAmount;
    @JsonProperty("MonthlyCut")
    private Integer monthlyCut;
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

    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @JsonProperty("available")
    public Float getAvailable() {
        return available;
    }

    @JsonProperty("available")
    public void setAvailable(Float available) {
        this.available = available;
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

    @JsonProperty("MonthlyCut")
    public Integer getMonthlyCut() {
        return monthlyCut;
    }

    @JsonProperty("MonthlyCut")
    public void setMonthlyCut(Integer monthlyCut) {
        this.monthlyCut = monthlyCut;
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
