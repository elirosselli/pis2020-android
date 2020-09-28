package com.pack.sdk;
import types.Error;

public class ContConfiguracionUsuario {

    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String response_type;
    private String id_token;
    private String token_type;
    private String authorization_code;
    private String access_token;
    private Integer expires_in;
    private String state;
    private String nonce;
    private String prompt;
    private String grant_type;
    private String acr_values;
    private String scope;
    private Boolean update_token;
    //private JWK key; //TODO

    // Constructor
    public ContConfiguracionUsuario(){
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
        // JWK key; //TODO
    }


    // Getter & Setter for client_id
    public Error setClient_id(String client_id){
        this.client_id = client_id;
        return new Error("0", "Success");
    }
    public String getClient_id(){
        return this.client_id;
    }

    // Getter & Setter for client_secret
    public Error setClient_secret(String client_secret){
        this.client_secret = client_secret;
        return new Error("0", "Success");
    }
    public String getClient_secret(){
        return this.client_secret;
    }

    // Getter & Setter for redirect_uri
    public Error setRedirect_uri(String redirect_uri){
        this.redirect_uri = redirect_uri;
        return new Error("0", "Success");
    }
    public String getRedirect_uri(){
        return this.redirect_uri;
    }

    // Getter & Setter for response_type
    public Error setResponse_type(String response_type){
        this.response_type = response_type;
        return new Error("0", "Success");
    }
    public String getResponse_type(){
        return this.response_type;
    }

    // Getter & Setter for id_token
    public Error setId_token(String id_token){
        this.id_token = id_token;
        return new Error("0", "Success");
    }
    public String id_token(){
        return this.id_token;
    }

    // Getter & Setter for token_type
    public Error setToken_type(String token_type){
        this.token_type = token_type;
        return new Error("0", "Success");
    }
    public String token_type(){
        return this.token_type;
    }

    // Getter & Setter for authorization_code
    public Error setAuthorization_code(String authorization_code){
        this.authorization_code = authorization_code;
        return new Error("0", "Success");
    }
    public String getAuthorization_code(){
        return this.authorization_code;
    }

    // Getter & Setter for access_token
    public Error setAccess_token(String access_token){
        this.access_token = access_token;
        return new Error("0", "Success");
    }
    public String getAccess_token(){
        return this.access_token;
    }

    // Getter & Setter for expires_in
    public Error setExpires_in(Integer expires_in){
        this.expires_in = expires_in;
        return new Error("0", "Success");
    }
    public Integer getExpires_in(){
        return this.expires_in;
    }

    // Getter & Setter for expires_in
    public Error setState(String state){
        this.state = state;
        return new Error("0", "Success");
    }
    public String getState(){
        return this.state;
    }

    // Getter & Setter for nonce
    public Error setNonce(String nonce){
        this.nonce = nonce;
        return new Error("0", "Success");
    }
    public String getNonce(){
        return this.nonce;
    }

    // Getter & Setter for prompt
    public Error setPrompt(String prompt){
        this.prompt = prompt;
        return new Error("0", "Success");
    }
    public String getPrompt(){
        return this.prompt;
    }

    // Getter & Setter for grant_type
    public Error setGrant_type(String grant_type){
        this.grant_type = grant_type;
        return new Error("0", "Success");
    }
    public String getGrant_type(){
        return this.grant_type;
    }

    // Getter & Setter for acr_values
    public Error setAcr_values(String acr_values){
        this.acr_values = acr_values;
        return new Error("0", "Success");
    }
    public String getAcr_values(){
        return this.acr_values;
    }

    // Getter & Setter for scope
    public Error setScope(String scope){
        this.scope = scope;
        return new Error("0", "Success");
    }
    public String getScope(){
        return this.scope;
    }

    // Getter & Setter for update_token
    public Error setUpdate_token(Boolean update_token){
        this.update_token = update_token;
        return new Error("0", "Success");
    }
    public Boolean getUpdate_token(){
        return this.update_token;
    }

    // Getter & Setter for JWK key //TODO
    // TODO
    // TODO

}
