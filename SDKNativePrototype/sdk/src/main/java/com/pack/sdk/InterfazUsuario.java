package com.pack.sdk;
import types;
import types.Error;
import types.TokenResponse;
import types.UserInfoResponse;
// import types.ProviderConfigResponse, //TODO
import javafx.util.Pair; // Returning multiple values

public interface InterfazUsuario {

    //TODO JWK key param
    Error initialize(String client_id, String client_secret, String redirect_uri, String response_type, String id_token, String token_type, String authorization_code, String access_token, Integer expires_in, String state, String nonce, String prompt, String grant_type, String acr_values, String scope, Boolean update_token);
    Error login();
    Pair<TokenResponse, Error> getToken();
    Pair<TokenResponse, Error> refreshToken(String refresh_token);
    Pair<UserInfoResponse, Error> getUserInfo();
    Error logout();
    //public ProviderConfigResponse getOIDConfig(),  //TODO

}

