package com.pack.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import removeProduction.HttpsTrustManager;
import types.AuthenticationRequest;
import types.AuthenticationResponse;
import types.ErrorResponse;
import types.TypeRequest;
import types.TypeResponse;

public class Requests implements InterfaceRequests {

    private Context context;
    private static Requests instance;

    public static Requests getInstance(Context context) {
        if(instance == null)
            instance = new Requests(context);
        return instance;
    }

    private Requests(Context context) {
        this.context = context;
    }

    public TypeResponse listenLoginResponse(Intent intent){
        String action = intent.getAction();
        Uri data = intent.getData();
        //Uri uri = getIntent().getData();

        Log.i("err","err");
        if(data!=null){
            final String code = data.getQueryParameter("code");
            if(code!=null) {// el usuario final acepto
                Log.i("code", code);
                ContConfiguracion.getInstance().setAuthorization_code(code);
                return new AuthenticationResponse(code);
            }else // el usuario final cancelo
                Log.i("Not code", "Fue cancelado");
        }

        return new ErrorResponse();
    }

    public void makeRequest(TypeRequest rq, RequestsCallback callback){
        if(rq.getClass().equals(AuthenticationRequest.class)){ // Authentication Request

            ContConfiguracion conf = ContConfiguracion.getInstance();
            String redirect_uri = conf.getRedirect_uri();
            String scope = "";
            for (String sc : conf.getScope()){
                scope += sc + "+";
            }
            String client_id = conf.getClient_id();

            String url = "https://auth-testing.iduruguay.gub.uy/oidc/v1/authorize?scope="+ scope +"&response_type=code&client_id="+client_id+"&redirect_uri="+redirect_uri;
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(browserIntent);

        }else{ //Other requests
            HttpsTrustManager.allowAllSSL(); //TODO Remove in production
            RequestQueue requestQueue;

            // Instantiate the cache
            Cache cache = new DiskBasedCache(context.getCacheDir(),1024*1024);
            Network network = new BasicNetwork(new HurlStack());
            requestQueue = new RequestQueue(cache, network);
            requestQueue.start();

            RequestFuture future = RequestFuture.newFuture();
            StringRequest jsonObjRequest = rq.doRequest(callback);
            jsonObjRequest.setRetryPolicy(new DefaultRetryPolicy(500, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            requestQueue.add(jsonObjRequest);
        }

    }
}
