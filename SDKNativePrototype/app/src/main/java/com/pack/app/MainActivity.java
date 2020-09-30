package com.pack.app;

import androidx.appcompat.app.AppCompatActivity;
import types.TypeResponse;
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
import com.pack.sdk.RequestsCallback;

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
        TypeResponse tr = contUser.listenLoginResponse(intent, getApplicationContext());
        if(tr.isSucceed()){
            contUser.getToken(getApplicationContext(), new RequestsCallback() {
                @Override
                public void onSuccess(TypeResponse response) {

                    contUser.getUserInfo(getApplicationContext(), new RequestsCallback() {
                        @Override
                        public void onSuccess(TypeResponse response) {
                            UserInfoResponse urp = (UserInfoResponse) response;


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

                        @Override
                        public void onError(TypeResponse response) {
                            Log.i("request2", "error");
                        }
                    });
                }

                @Override
                public void onError(TypeResponse response) {
                    Log.i("request", "error");
                }
            });



        }

    }

}