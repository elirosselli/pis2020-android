package com.pack.sdk;

import java.util.List;

public interface InterfaceConfiguracion {
    String getClient_id();
    void setClient_id(String client_id);
    String getRedirect_uri();
    void setRedirect_uri(String redirect_uri);
    String getResponse_type();
    void setResponse_type(String response_type);
    String getId_token();
    void setId_token(String id_token);
    String getToken_type();
    void setToken_type(String token_type);
    String getAuthorization_code();
    void setAuthorization_code(String code);
    String getAccess_token();
    void setAccess_token(String access_token);
    String getRefresh_token();
    void setRefresh_token(String refresh_token);
    Integer getExpires_in();
    void setExpires_in(Integer expires_in);
    String getState();
    void setState(String state);
    String getNonce();
    void setNonce(String nonce);
    String getPrompt();
    void setPrompt(String prompt);
    String getClient_secret();
    void setClient_secret(String client_secret);
    String getGrant_type();
    void setGrant_type(String grant_type);
    String getAcr_values();
    void setAcr_values(String acr_values);
    List<String> getScope();
    void setScope(List<String> scope);
    Boolean getUpdate_token();
    void setUpdate_token(Boolean update_token);
    //JWK getKey();
    //void setKey(JWK key);
    void clearParametros();
}
