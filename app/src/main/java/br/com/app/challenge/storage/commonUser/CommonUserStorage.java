package br.com.app.challenge.storage.commonUser;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.app.challenge.model.CommonUser;

public class CommonUserStorage extends AsyncTask<String, Void, CommonUser> {

    @Override
    protected CommonUser doInBackground(String... strings){
        CommonUser commonUser = null;

        URL url;
        HttpURLConnection urlConnection = null;
        StringBuilder result = new StringBuilder();
        Gson gson = new Gson();

        try {
            url = new URL("http://192.168.0.105/getCommonUsers.php$?id=" + strings[0]);

            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            commonUser = gson.fromJson(result.toString(), CommonUser.class);

            System.out.println(result.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return commonUser;
    }

}