package update.app.jdog1218.com.messingaround;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Sotd extends Activity {

    static String url = "https://www.compasshb.com/api/v1/passages";

    static String stockSymbol;
    static String stockTitle;
    static String stockBody;
    static String verse;
    static String end;

    MyAsyncTask asyncTask;


    public Sotd() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sotd);

        new MyAsyncTask().doInBackground();
    }

    public class MyAsyncTask extends AsyncTask<String, String, String> {
        protected String doInBackground(String... Prams) {

            DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());

            HttpPost httppost = new HttpPost(url);

            httppost.setHeader("Content-type", "application/json");

            InputStream inputStream = null;

            String result = null;

            try {

                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                inputStream = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                StringBuilder theStringBuilder = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null) {

                    theStringBuilder.append(line + "\n");
                }
                result = theStringBuilder.toString();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inputStream != null) inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            JSONObject jsonObject;

            try {
                //Log.v("JsonParser Result ", result);

                jsonObject = new JSONObject(result);

                JSONObject jsonTitle = jsonObject.getJSONObject("title");

                stockTitle = jsonTitle.getString("title");

                JSONObject html = jsonObject.getJSONObject("verses");

                stockBody = html.getString("verses");

                Document doc = Jsoup.parse(stockBody);

                Elements body = doc.getElementsByClass("esv");

                stockBody = body.text();

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }


        @Override
        protected void onPostExecute(String result) {
            TextView title = (TextView) findViewById(R.id.text_view);
            TextView body = (TextView) findViewById(R.id.body);

            title.setText("Title: " + stockTitle);
            body.setText("body: " + stockBody);
        }
    }

    public String makeServiceCall(String url, int method) {


        return this.makeServiceCall(url, method);
    }


}