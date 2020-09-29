package com.pack.sdk;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import types.TypeResponse;
import types.Error;
import types.TokenResponse;
import types.UserInfoResponse;
import types.AuthenticationRequest;
import android.content.Context;

public class ContUsuario implements InterfazUsuario{

    @Override
    public Error initialize(String client_id, String client_secret, String redirect_uri) {//, String response_type, String id_token, String token_type, String authorization_code, String access_token, Integer expires_in, String state, String nonce, String prompt, String grant_type, String acr_values, String scope, Boolean update_token) {
        ContConfiguracion intConf = ContConfiguracion.getInstance();
        intConf.setClient_id(client_id);
        intConf.setClient_secret(client_secret);
        intConf.setRedirect_uri(redirect_uri);
        return null;
    }

    @Override
    public TypeResponse login(Context context) {
        Requests requestsClass = Requests.getInstance(context);
        AuthenticationRequest authReq = new AuthenticationRequest();
        ContConfiguracion intConf = ContConfiguracion.getInstance();
        String client_id = intConf.getClient_id();
        String redirect_uri = intConf.getRedirect_uri();
        List<String> scope = intConf.getScope();
        String response_type = intConf.getResponse_type();
        String delim = " ";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < scope.size() - 1) {
            sb.append(scope.get(i));
            sb.append(delim);
            i++;
        }
        sb.append(scope.get(i));
        String scope_string = sb.toString();

        authReq.setClient_id(client_id);
        authReq.setRedirect_uri(redirect_uri);
        authReq.setScope(scope_string);
        authReq.setResponse_type(response_type);
        // TODO: other parameters
        // TODO: validate response

        return requestsClass.makeRequest(authReq);
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