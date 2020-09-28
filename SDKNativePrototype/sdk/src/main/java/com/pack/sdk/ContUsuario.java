package com.pack.sdk;

import java.util.Map;

import types.Error;
import types.TokenResponse;
import types.UserInfoResponse;
import com.pack.sdk.InterfaceConfiguracion;
import com.pack.sdk.ContInterfaceConfiguracion;

public class ContUsuario implements InterfazUsuario{

    @Override
    public Error initialize(String client_id, String client_secret, String redirect_uri) {//, String response_type, String id_token, String token_type, String authorization_code, String access_token, Integer expires_in, String state, String nonce, String prompt, String grant_type, String acr_values, String scope, Boolean update_token) {
        ContInterfaceConfiguracion intConf = ContInterfaceConfiguracion.getInstance();
        intConf.setClient_id(client_id);
        intConf.setClient_secret(client_secret);
        intConf.setRedirect_uri(redirect_uri);
        return null;
    }

    @Override
    public Error login() {
        return null;
    }

    @Override
    public Map<TokenResponse, Error> getToken() {
        return null;
    }

    @Override
    public Map<TokenResponse, Error> refreshToken(String refresh_token) {
        return null;
    }

    @Override
    public Map<UserInfoResponse, Error> getUserInfo() {
        return null;
    }

    @Override
    public Error logout() {
        return null;
    }
}