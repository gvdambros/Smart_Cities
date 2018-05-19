package br.com.commons.storage;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.app.challenge.model.AppConstants;
import br.com.app.challenge.model.AppException;
import br.com.app.challenge.model.CommonUser;

public abstract class GET extends AsyncTask <String, Void, CommonUser> {

    private Exception exception;

    public abstract String getURL();
    public abstract Integer getSuccessfulResponse();

    @Override
    protected CommonUser doInBackground(String... strings){
        CommonUser commonUser = null;

        URL url;
        HttpURLConnection urlConnection = null;
        StringBuilder result = new StringBuilder();
        Gson gson = new Gson();

        try {
            url = new URL(getURL() + "id=" + strings[0]);

            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();

            int responseCode = urlConnection.getResponseCode();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            if( responseCode != getSuccessfulResponse() ) {
                exception = new AppException(AppConstants.HTTP_STATUS_BAD_REQUEST, AppConstants.MESSAGE_INVALID_DATA_COMMON_USER);
            }

            commonUser = gson.fromJson(result.toString(), CommonUser.class);

        } catch (Exception e) {
            e.printStackTrace();
            exception = new AppException(AppConstants.HTTP_STATUS_GENERIC_ERROR, AppConstants.MESSAGE_GENERIC_ERROR);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return commonUser;
    }

    @Override
    protected void onPostExecute(CommonUser commonUser) {

        if(exception != null){
            System.out.println("ERROR");
        }
        else{
            System.out.println("OK");
        }

        super.onPostExecute(commonUser);
    }
}
