package update.app.jdog1218.com.messingaround;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Sotd extends Activity {

    static String sotd, content;


    MyAsyncTask asyncTask;


    public Sotd() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sotd);
        TextView textView = (TextView) findViewById(R.id.body);
        asyncTask = new MyAsyncTask();
        asyncTask.execute();
        try {
            content = asyncTask.get();
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            content = ParseHTML(content);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        textView.setText(content);
    }

    public class MyAsyncTask extends AsyncTask<String, String, String> {
        protected String doInBackground(String... Prams) {

            EasyHttpClient client = new EasyHttpClient();

            sotd = client.get("https://www.compasshb.com/api/v1/passages");
            //textView.setText(sotd);
            return sotd;
        }

    }

    public String ParseHTML(String content) throws JSONException {
        JSONObject obj = new JSONObject(content);
        try {
            String body = obj.getJSONObject("body").getString("body");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return content;

    }

}