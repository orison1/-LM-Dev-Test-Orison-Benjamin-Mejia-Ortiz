package com.prueba.pojo.product.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"cuenta"
})
public class ProductRequest {

@JsonProperty("cuenta")
private String cuenta;

@JsonProperty("cuenta")
public String getCuenta() {
return cuenta;
}

@JsonProperty("cuenta")
public void setCuenta(String cuenta) {
this.cuenta = cuenta;
}

}