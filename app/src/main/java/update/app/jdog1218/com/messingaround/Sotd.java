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

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Sotd extends Activity {

    static String sotd;
    static TextView textView;

    MyAsyncTask asyncTask;


    public Sotd() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sotd);

        textView = (TextView) findViewById(R.id.body);

        new MyAsyncTask().execute();
        textView.setText(sotd);
    }

    public class MyAsyncTask extends AsyncTask<String, String, String> {
        protected String doInBackground(String... Prams) {

            EasyHttpClient client = new EasyHttpClient();

            sotd = client.get("https://www.compasshb.com/api/v1/passages");
            //textView.setText(sotd);
            return sotd;
        }

    }

}