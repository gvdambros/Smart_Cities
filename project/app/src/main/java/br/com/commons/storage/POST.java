package br.com.commons.storage;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import br.com.app.challenge.model.AppConstants;
import br.com.app.challenge.model.AppException;

public abstract class POST extends AsyncTask<String, Void, Boolean> {

    protected Exception exception;
    protected Map<String, String> postEntity;

    public abstract String getURL();
    public abstract Integer getSuccessfulResponse();


    @Override
    protected Boolean doInBackground(String... strings){

        URL url;
        HttpURLConnection urlConnection = null;
        StringBuilder result = new StringBuilder();

        String param = buildRequestString();

        try {
            url = new URL( getURL() );
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);

            OutputStreamWriter request = new OutputStreamWriter(urlConnection.getOutputStream());

            request.write(param);
            request.flush();
            request.close();

            int responseCode = urlConnection.getResponseCode();

            InputStreamReader in = new InputStreamReader( urlConnection.getInputStream() );

            BufferedReader reader = new BufferedReader(in);

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            if( responseCode != getSuccessfulResponse() ) {
                exception = new AppException(AppConstants.HTTP_STATUS_BAD_REQUEST, AppConstants.MESSAGE_INVALID_DATA_COMMON_USER);
            }

        } catch (Exception e) {
            e.printStackTrace();
            exception = new AppException(AppConstants.HTTP_STATUS_GENERIC_ERROR, AppConstants.MESSAGE_GENERIC_ERROR);
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
        else{
            System.out.println("OK");
        }
        super.onPostExecute(aBoolean);
    }

    private String buildRequestString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : postEntity.entrySet())
        {
            sb.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    public void setPostEntity(Map<String, String> postEntity) {
        this.postEntity = postEntity;
    }

}
