package com.pack.sdk;
import types.ErrorResponse;

public interface InterfaceConfiguracionUsuario {

    ErrorResponse setClient_id(String client_id);
    String getClient_id();
    ErrorResponse setClient_secret(String client_secret);
    String getClient_secret();
    ErrorResponse setRedirect_uri(String redirect_uri);
    String getRedirect_uri();
    ErrorResponse setResponse_type(String response_type);
    String getResponse_type();
    ErrorResponse setId_token(String id_token);
    String id_token();
    ErrorResponse setToken_type(String token_type);
    String token_type();
    ErrorResponse setAuthorization_code(String authorization_code);
    String getAuthorization_code();
    ErrorResponse setAccess_token(String access_token);
    String getAccess_token();
    ErrorResponse setExpires_in(Integer expires_in);
    Integer getExpires_in();
    ErrorResponse setState(String state);
    String getState();
    ErrorResponse setNonce(String nonce);
    String getNonce();
    ErrorResponse setPrompt(String prompt);
    String getPrompt();
    ErrorResponse setGrant_type(String grant_type);
    String getGrant_type();
    ErrorResponse setAcr_values(String acr_values);
    String getAcr_values();
    ErrorResponse setScope(String scope);
    String getScope();
    ErrorResponse setUpdate_token(Boolean update_token);
    Boolean getUpdate_token();
    // setter de JWK //TODO
    // getter de JWK

}
