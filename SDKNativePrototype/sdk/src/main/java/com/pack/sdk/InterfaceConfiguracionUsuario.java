package com.pack.sdk;
import types.Error;

public interface InterfaceConfiguracionUsuario {

    Error setClient_id(String client_id);
    String getClient_id();
    Error setClient_secret(String client_secret);
    String getClient_secret();
    Error setRedirect_uri(String redirect_uri);
    String getRedirect_uri();
    Error setResponse_type(String response_type);
    String getResponse_type();
    Error setId_token(String id_token);
    String id_token();
    Error setToken_type(String token_type);
    String token_type();
    Error setAuthorization_code(String authorization_code);
    String getAuthorization_code();
    Error setAccess_token(String access_token);
    String getAccess_token();
    Error setExpires_in(Integer expires_in);
    Integer getExpires_in();
    Error setState(String state);
    String getState();
    Error setNonce(String nonce);
    String getNonce();
    Error setPrompt(String prompt);
    String getPrompt();
    Error setGrant_type(String grant_type);
    String getGrant_type();
    Error setAcr_values(String acr_values);
    String getAcr_values();
    Error setScope(String scope);
    String getScope();
    Error setUpdate_token(Boolean update_token);
    Boolean getUpdate_token();
    // setter de JWK //TODO
    // getter de JWK

}
