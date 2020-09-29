package com.pack.app;

import androidx.appcompat.app.AppCompatActivity;
import types.AuthenticationRequest;
import types.AuthenticationResponse;
import types.ErrorResponse;
import types.TokenRequest;
import types.TypeResponse;
import types.UserInfoRequest;
import types.UserInfoResponse;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.pack.sdk.ContConfiguracion;
import com.pack.sdk.ContUsuario;
import com.pack.sdk.InterfazUsuario;
import com.pack.sdk.Requests;

import java.util.Arrays;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    static InterfazUsuario contUser = new ContUsuario(); //TODO factory

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        contUser.initialize(BuildConfig.CLIENT_ID,BuildConfig.CLIENT_SECRET,"sdkIdU.testing://auth");


        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                contUser.login(getApplicationContext());
            }
        });

        ContConfiguracion contConf = ContConfiguracion.getInstance();
        contConf.setScope(Arrays.asList("openid","email","profile","document"));

        Intent intent = getIntent();
        //El tema de la uri cuando se hace el redirect. En el manifest esta configurado el deep linking
        Requests rq = Requests.getInstance(getApplicationContext());
        rq.listenLoginResponse(intent);
        if(rq.listenLoginResponse(intent).isSucceed()){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Requests rq = Requests.getInstance(getApplicationContext());
                    TokenRequest nReq = new TokenRequest();
                    rq.makeRequest(nReq);

                    UserInfoRequest uReq = new UserInfoRequest();
                    TypeResponse rp = rq.makeRequest(uReq);
                    UserInfoResponse urp = (UserInfoResponse) rp;


                    Intent openData = new Intent(MainActivity.this, UserInfoActivity.class);
                    String data = "";
                    for(Map.Entry<String, Map<String,String>> entrada:  urp.getInfo().entrySet()){
                        data += entrada.getKey()+"\n";
                        for(Map.Entry<String,String> value : entrada.getValue().entrySet()){
                            data += "       "+value.getKey() + " -> " + value.getValue() +"\n";
                        }
                    }
                    openData.putExtra("data", data);
                    startActivity(openData);
                    Log.i("MainUI",urp.getInfo().toString());
                }
            });
            thread.start();
        }
    }

}