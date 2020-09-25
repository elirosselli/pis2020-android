package com.pack.app;

import androidx.appcompat.app.AppCompatActivity;
import types.TypeRequest;
import types.TokenRequest;
import types.UserInfoRequest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.pack.sdk.ContInterfaceConfiguracion;
import com.pack.sdk.Requests;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Requests rq = Requests.getInstance(getApplicationContext());
                rq.login();
            }
        });

        ContInterfaceConfiguracion contConf = ContInterfaceConfiguracion.getInstance();
        contConf.setClient_id("ID");
        contConf.setClient_secret("Secret");
        contConf.setRedirect_uri("sdkIdU.testing://auth");
        contConf.setScope("openid+email+profile+");
        //El tema de la uri cuando se hace el redirect. En el manifest esta configurado el deep linking
        Intent intent = getIntent();
        Requests rq = Requests.getInstance(getApplicationContext());
        rq.listenLoginResponse(intent);

        if(rq.listenLoginResponse(intent)){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Requests rq = Requests.getInstance(getApplicationContext());
                    TokenRequest nReq = new TokenRequest();
                    rq.makeRequest(nReq);

                    UserInfoRequest uReq = new UserInfoRequest();
                    rq.makeRequest(uReq);
                }
            });
            thread.start();
        }
    }

}