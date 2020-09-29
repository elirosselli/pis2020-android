package com.pack.sdk;

import java.util.List;

import types.TypeResponse;
import types.ErrorResponse;
import types.AuthenticationRequest;
import android.content.Context;
import android.content.Intent;

public class ContUsuario implements InterfazUsuario{

    @Override
    public ErrorResponse initialize(String client_id, String client_secret, String redirect_uri) {//, String response_type, String id_token, String token_type, String authorization_code, String access_token, Integer expires_in, String state, String nonce, String prompt, String grant_type, String acr_values, String scope, Boolean update_token) {
        ContConfiguracion intConf = ContConfiguracion.getInstance();
        intConf.setClient_id(client_id);
        intConf.setClient_secret(client_secret);
        intConf.setRedirect_uri(redirect_uri);
        return null;
    }

    @Override
    public TypeResponse listenLoginResponse(Intent intent, Context context) {
        Requests req = Requests.getInstance(context);
        return(req.listenLoginResponse(intent));
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
    public TypeResponse getToken() {
        return null;
    }

    @Override
    public TypeResponse refreshToken(String refresh_token) {
        return null;
    }

    @Override
    public TypeResponse getUserInfo() {
        return null;
    }

    @Override
    public TypeResponse logout() {
        return null;
    }
}