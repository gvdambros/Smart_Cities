package br.com.app.challenge.storage.commonUser;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.app.challenge.model.CommonUser;
import br.com.commons.storage.GET;

public class GET_CommonUser extends GET {

    @Override
    public String getURL() {
        return "http://192.168.0.11/getCommonUsers.php";
    }

    @Override
    public Integer getSuccessfulResponse() {
        return 200;
    }
}