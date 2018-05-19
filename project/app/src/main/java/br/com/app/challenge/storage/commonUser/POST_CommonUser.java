package br.com.app.challenge.storage.commonUser;

import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.app.challenge.activity.MainActivity;
import br.com.app.challenge.model.AppException;
import br.com.app.challenge.model.CommonUser;

public class POST_CommonUser extends AsyncTask<String, Void, Boolean> {

    Exception exception;

    @Override
    protected Boolean doInBackground(String... strings){
        CommonUser commonUser = null;

        URL url;
        HttpURLConnection urlConnection = null;
        StringBuilder result = new StringBuilder();

        String param = "email=gvdambros@gmail.com&name=gustavo&phone=1&experience=0";

        try {
            url = new URL("http://192.168.0.11/commonUsers/post.php");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);

            OutputStreamWriter request = new OutputStreamWriter(urlConnection.getOutputStream());

            request.write(param);
            request.flush();

            int responseCode = urlConnection.getResponseCode();

            if( responseCode != 201 ) throw new AppException();

            InputStreamReader in = new InputStreamReader( urlConnection.getInputStream() );

            BufferedReader reader = new BufferedReader(in);

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            System.out.println(result.toString());

        } catch (Exception e) {
            e.printStackTrace();
            exception = e;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if(exception != null){
            System.out.println("ERROR");
        }

        System.out.println("OK");

        super.onPostExecute(aBoolean);
    }
}