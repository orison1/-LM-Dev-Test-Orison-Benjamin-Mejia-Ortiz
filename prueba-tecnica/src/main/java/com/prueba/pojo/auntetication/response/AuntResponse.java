
package com.prueba.pojo.auntetication.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tokenSession"
})
public class AuntResponse {

    @JsonProperty("tokenSession")
    private String tokenSession;

    @JsonProperty("tokenSession")
    public String getTokenSession() {
        return tokenSession;
    }

    @JsonProperty("tokenSession")
    public void setTokenSession(String tokenSession) {
        this.tokenSession = tokenSession;
    }

}
