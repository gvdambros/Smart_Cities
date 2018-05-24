package br.com.app.challenge.storage;

import com.google.gson.Gson;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import br.com.app.challenge.model.CommonUser;
import br.com.commons.storage.RestAPI;
import cz.msebera.android.httpclient.Header;

public class CommonUserStorage  {

    public CommonUser commonUser;

    public CommonUser get(){

        RequestParams rp = new RequestParams();

        RestAPI.get("http://192.168.0.11:8080/commonUsers/55", rp, new JsonHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    Gson gson = new Gson();
                    String data = response.get("data").toString();
                    commonUser = gson.fromJson(data, CommonUser.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        });
        return commonUser;
    }
}