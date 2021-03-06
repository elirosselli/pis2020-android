package com.pack.sdk;
import android.content.Context;
import android.content.Intent;

import types.TypeResponse;
import types.ErrorResponse;
// import types.ProviderConfigResponse, //TODO

public interface InterfazUsuario {

    //TODO JWK key param
    ErrorResponse initialize(String client_id, String client_secret, String redirect_uri);//, String response_type, String id_token, String token_type, String authorization_code, String access_token, Integer expires_in, String state, String nonce, String prompt, String grant_type, String acr_values, String scope, Boolean update_token);
    TypeResponse listenLoginResponse(Intent intent, Context context);
    TypeResponse login(Context context);
    void getToken(Context context, RequestsCallback callback);
    void refreshToken(String refresh_token, Context context, RequestsCallback callback);
    void getUserInfo(Context context, RequestsCallback callback);
    TypeResponse logout();
    //public ProviderConfigResponse getOIDConfig(),  //TODO

}

