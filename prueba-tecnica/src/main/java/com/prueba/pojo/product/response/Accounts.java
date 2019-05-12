
package com.prueba.pojo.product.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "prestamo",
    "creditCard",
    "ahorro"
})
public class Accounts {

    @JsonProperty("prestamo")
    private List<Prestamo> prestamo = null;
    @JsonProperty("creditCard")
    private List<CreditCard> creditCard = null;
    @JsonProperty("ahorro")
    private List<Ahorro> ahorro = null;

    @JsonProperty("prestamo")
    public List<Prestamo> getPrestamo() {
        return prestamo;
    }

    @JsonProperty("prestamo")
    public void setPrestamo(List<Prestamo> prestamo) {
        this.prestamo = prestamo;
    }

    @JsonProperty("creditCard")
    public List<CreditCard> getCreditCard() {
        return creditCard;
    }

    @JsonProperty("creditCard")
    public void setCreditCard(List<CreditCard> creditCard) {
        this.creditCard = creditCard;
    }

    @JsonProperty("ahorro")
    public List<Ahorro> getAhorro() {
        return ahorro;
    }

    @JsonProperty("ahorro")
    public void setAhorro(List<Ahorro> ahorro) {
        this.ahorro = ahorro;
    }

}
