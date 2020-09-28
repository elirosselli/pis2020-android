package com.pack.sdk;

import android.util.Log;

import java.util.List;

public class ContInterfaceConfiguracion implements InterfaceConfiguracion{

    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String response_type;
    private String id_token;
    private String token_type;
    private String authorization_code;
    private String access_token;
    private String refresh_token;
    private Integer expires_in;
    private String state;
    private String nonce;
    private String prompt;
    private String grant_type;
    private String acr_values;
    private List<String> scope;
    private Boolean update_token;
    //private JWK key;
    private static ContInterfaceConfiguracion instance;

    // Constructor
    private ContInterfaceConfiguracion(){
        this.client_id = null;
        this.client_secret = null;
        this.redirect_uri = null;
        this.response_type = null;
        this.id_token = null;
        this.token_type = null;
        this.authorization_code = null;
        this.access_token = null;
        this.expires_in = null;
        this.state = null;
        this.nonce = null;
        this.prompt = null;
        this.grant_type = null;
        this.acr_values = null;
        this.scope = null;
        this.update_token = null;
        this.refresh_token = null;
        // JWK key;
    }

    public static ContInterfaceConfiguracion getInstance(){
        if(instance == null)
            instance = new ContInterfaceConfiguracion();
        return instance;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAuthorization_code() {
        return authorization_code;
    }

    public void setAuthorization_code(String authorization_code) {
        this.authorization_code = authorization_code;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getAcr_values() {
        return acr_values;
    }

    public void setAcr_values(String acr_values) {
        this.acr_values = acr_values;
    }

    public List<String> getScope() {
        return scope;
    }

    public void setScope(List<String> scope) {
        this.scope = scope;
    }

    public Boolean getUpdate_token() {
        return update_token;
    }

    public void setUpdate_token(Boolean update_token) {
        this.update_token = update_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public void clearParametros() {
        this.client_id = null;
        this.redirect_uri = null;
        this.response_type = null;
        this.id_token = null;
        this.token_type = null;
        this.authorization_code = null;
        this.access_token = null;
        this.refresh_token = null;
        this.expires_in = null;
        this.state = null;
        this.nonce = null;
        this.prompt = null;
        this.client_secret = null;
        this.grant_type = null;
        this.acr_values = null;
        this.scope = null;
        this.update_token = null;
        // JWK key;
    }

}
