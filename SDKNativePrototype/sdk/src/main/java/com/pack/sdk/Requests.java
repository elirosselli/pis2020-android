package com.pack.sdk;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import androidx.annotation.RequiresApi;
import removeProduction.HttpsTrustManager;
import types.TypeRequest;

public class Requests {

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

    public void makeRequest(TypeRequest rq){
        HttpsTrustManager.allowAllSSL(); //TODO Remove in production
        RequestQueue requestQueue;

        // Instantiate the cache
        Cache cache = new DiskBasedCache(context.getCacheDir(),1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        RequestFuture future = RequestFuture.newFuture();
        StringRequest jsonObjRequest = rq.doRequest(future);
        jsonObjRequest.setRetryPolicy(new DefaultRetryPolicy(500, 5, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(jsonObjRequest);

        try {
            JSONObject response = null;
            response = new JSONObject((String) future.get(2, TimeUnit.SECONDS));
            ContInterfaceConfiguracion conf = ContInterfaceConfiguracion.getInstance();

            //Procesar respuesta del endpoint
            rq.processResponse(response); //TODO return response

        } catch (InterruptedException e) {
            // exception handling
            Log.i("Token", "Interrupted");
        } catch (ExecutionException e) {
            // exception handling
            Log.i("Token", "Execution");
        } catch (TimeoutException e) {
            // exception handling
            Log.i("Token", "Timeout");
        } catch (Throwable t){

        }

    }
}
