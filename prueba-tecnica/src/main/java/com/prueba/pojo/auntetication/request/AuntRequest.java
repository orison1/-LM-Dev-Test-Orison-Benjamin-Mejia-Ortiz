
package com.prueba.pojo.auntetication.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "user",
    "pass"
})
public class AuntRequest {

    @JsonProperty("user")
    private String user;
    @JsonProperty("pass")
    private String pass;

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonProperty("pass")
    public String getPass() {
        return pass;
    }

    @JsonProperty("pass")
    public void setPass(String pass) {
        this.pass = pass;
    }

}
