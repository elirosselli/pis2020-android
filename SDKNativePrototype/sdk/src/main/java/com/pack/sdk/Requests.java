package com.pack.sdk;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
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
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.RequiresApi;
import removeProduction.HttpsTrustManager;

public class Requests {

    Context context;
    String code;

    public Requests(Context context, String code) {
        this.context = context;
        this.code = code;
    }

    public void makeRequest(){
        HttpsTrustManager.allowAllSSL(); //Remove in production
        RequestQueue requestQueue;

        Log.i("Info_", code);

        // Instantiate the cache
        Cache cache = new DiskBasedCache(context.getCacheDir(),1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        String apiLink = "https://auth-testing.iduruguay.gub.uy/oidc/v1/token";

        StringRequest jsonObjRequest = new StringRequest(Request.Method.POST, apiLink,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String s;
                        s = response.trim();
                        JSONObject obj = null;
                        try {
                            obj = new JSONObject(s);
                        } catch (Throwable t) {
                        }
                       Log.i("data",obj.toString());

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("volley", "Error: " + error.getMessage());
                        NetworkResponse networkResponse = error.networkResponse;
                        if (networkResponse != null && networkResponse.data != null) {
                            String jsonError = new String(networkResponse.data);
                            Log.i("data",jsonError);
                        }
                        error.printStackTrace();
                    }
                }) {

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        String USERNAME = "894329";
                        String PASSWORD = "cdc04f19ac0f28fb3e1ce6d42b37e85a63fb8a654691aa4484b6b94b";
                        Map<String, String> headerMap = new HashMap<String, String>();
                        String credentials = USERNAME+":"+PASSWORD;
                        String auth = "Basic "
                                + Base64.encodeToString(credentials.getBytes(),
                                Base64.NO_WRAP);
                        headerMap.put("Authorization", auth);
                        headerMap.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

                        return headerMap;
                    }

                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    protected Response<String> parseNetworkResponse(NetworkResponse response) {
                        String parsed;
                        parsed = new String(response.data, StandardCharsets.UTF_8);
                        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
                    }

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("grant_type", "authorization_code");
                        params.put("code", code);
                        params.put("redirect_uri", "sdkIdU.testing://auth");
                        return params;
                    }
        };

        requestQueue.add(jsonObjRequest);
    }
}
