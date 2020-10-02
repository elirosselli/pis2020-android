package com.pack.sdk;
import types.ErrorResponse;

public class ContConfiguracionUsuario {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String responseType;
    private String idToken;
    private String tokenType;
    private String authorizationCode;
    private String accessToken;
    private Integer expiresIn;
    private String state;
    private String nonce;
    private String prompt;
    private String grantType;
    private String acrValues;
    private String scope;
    private Boolean updatetoken;
    //private JWK key; //TODO

    // Constructor
    public ContConfiguracionUsuario(){
        this.clientId = null;
        this.clientSecret = null;
        this.redirectUri = null;
        this.responseType = null;
        this.idToken = null;
        this.tokenType = null;
        this.authorizationCode = null;
        this.accessToken = null;
        this.expiresIn = null;
        this.state = null;
        this.nonce = null;
        this.prompt = null;
        this.grantType = null;
        this.acrValues = null;
        this.scope = null;
        this.updatetoken = null;
        // JWK key; //TODO
    }


    // Getter & Setter for client_id
    public ErrorResponse setClientId(String clientId){
        this.clientId = clientId;
        return new ErrorResponse("0", "Success");
    }
    public String getClientId(){
        return this.clientId;
    }

    // Getter & Setter for clientSecret
    public ErrorResponse setClientSecret(String clientSecret){
        this.clientSecret = clientSecret;
        return new ErrorResponse("0", "Success");
    }
    public String getClientSecret(){
        return this.clientSecret;
    }

    // Getter & Setter for redirectUri
    public ErrorResponse setRedirectUri(String redirectUri){
        this.redirectUri = redirectUri;
        return new ErrorResponse("0", "Success");
    }
    public String getRedirectUri(){
        return this.redirectUri;
    }

    // Getter & Setter for responseType
    public ErrorResponse setResponseType(String responseType){
        this.responseType = responseType;
        return new ErrorResponse("0", "Success");
    }
    public String getResponseType(){
        return this.responseType;
    }

    // Getter & Setter for idToken
    public ErrorResponse setIdToken(String idToken){
        this.idToken = idToken;
        return new ErrorResponse("0", "Success");
    }
    public String idToken(){
        return this.idToken;
    }

    // Getter & Setter for tokenType
    public ErrorResponse setToken_type(String tokenType){
        this.tokenType = tokenType;
        return new ErrorResponse("0", "Success");
    }
    public String tokenType(){
        return this.tokenType;
    }

    // Getter & Setter for authorizationCode
    public ErrorResponse setauthorizationCode(String authorizationCode){
        this.authorizationCode = authorizationCode;
        return new ErrorResponse("0", "Success");
    }
    public String getAuthorizationCode(){
        return this.authorizationCode;
    }

    // Getter & Setter for accessToken
    public ErrorResponse setAccessToken(String accessToken){
        this.accessToken = accessToken;
        return new ErrorResponse("0", "Success");
    }
    public String getAccessToken(){
        return this.accessToken;
    }

    // Getter & Setter for expiresIn
    public ErrorResponse setExpiresIn(Integer expiresIn){
        this.expiresIn = expiresIn;
        return new ErrorResponse("0", "Success");
    }
    public Integer getExpiresIn(){
        return this.expiresIn;
    }

    // Getter & Setter for expires_in
    public ErrorResponse setState(String state){
        this.state = state;
        return new ErrorResponse("0", "Success");
    }
    public String getState(){
        return this.state;
    }

    // Getter & Setter for nonce
    public ErrorResponse setNonce(String nonce){
        this.nonce = nonce;
        return new ErrorResponse("0", "Success");
    }
    public String getNonce(){
        return this.nonce;
    }

    // Getter & Setter for prompt
    public ErrorResponse setPrompt(String prompt){
        this.prompt = prompt;
        return new ErrorResponse("0", "Success");
    }
    public String getPrompt(){
        return this.prompt;
    }

    // Getter & Setter for grantType
    public ErrorResponse setGrantType(String grantType){
        this.grantType = grantType;
        return new ErrorResponse("0", "Success");
    }
    public String getGrantType(){
        return this.grantType;
    }

    // Getter & Setter for acrValues
    public ErrorResponse setAcrValues(String acrValues){
        this.acrValues = acrValues;
        return new ErrorResponse("0", "Success");
    }
    public String getAcrValues(){
        return this.acrValues;
    }

    // Getter & Setter for scope
    public ErrorResponse setScope(String scope){
        this.scope = scope;
        return new ErrorResponse("0", "Success");
    }
    public String getScope(){
        return this.scope;
    }

    // Getter & Setter for updateToken
    public ErrorResponse setupdateToken(Boolean updateToken){
        this.updatetoken = updateToken;
        return new ErrorResponse("0", "Success");
    }
    public Boolean getUpdatetoken(){
        return this.updatetoken;
    }

    // Getter & Setter for JWK key //TODO
    // TODO
    // TODO

}
