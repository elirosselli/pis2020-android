package com.pack.sdk;

public interface InterfaceConfiguracionUsuario {

    public void setClient_id(String client_id);
    public String getClient_id();
    public void setClient_secret(String client_secret);
    public String getClient_secret();
    public void setRedirect_uri(String redirect_uri);
    public String getRedirect_uri();
    public void setResponse_type(String response_type);
    public String getResponse_type();
    public void setId_token(String id_token);
    public String id_token();
    public void setToken_type(String token_type);
    public String token_type();
    public void setAuthorization_code(String authorization_code);
    public String getAuthorization_code();
    public void setAccess_token(String access_token);
    public String getAccess_token();
    public void setExpires_in(Integer expires_in);
    public Integer getExpires_in();
    public void setState(String state);
    public String getState();
    public void setNonce(String nonce);
    public String getNonce();
    public void setPrompt(String prompt);
    public String getPrompt();
    public void setGrant_type(String grant_type);
    public String getGrant_type();
    public void setAcr_values(String acr_values);
    public String getAcr_values();
    public void setScope(String scope);
    public String getScope();
    public void setUpdate_token(Boolean update_token);
    public Boolean getUpdate_token();
    // setter de JWK
    // getter de JWK

}
