package com.pack.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                click_btn_login("https://auth-testing.iduruguay.gub.uy/oidc/v1/authorize?scope=openid+email&response_type=code&client_id=894329&redirect_uri=sdkIdU.testing://auth");
            }
        });

        //El tema de la uri cuando se hace el redirect. En el manifest esta configurado el deep linking
        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();
        //Uri uri = getIntent().getData();
        if(data!=null){
            String code = data.getQueryParameter("code");
            if(code!=null) // el usuario final acepto
                Toast.makeText(this, "Tu code es:"+code,Toast.LENGTH_LONG).show();
            else // el usuario final cancelo
                Toast.makeText(this, "No le diste a aceptar",Toast.LENGTH_LONG).show();
        }
    }

    //Para que se abra el navegador
    public void click_btn_login(String uri){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

}