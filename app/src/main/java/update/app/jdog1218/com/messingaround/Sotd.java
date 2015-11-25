package update.app.jdog1218.com.messingaround;

import android.app.Activity;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.Element;
import android.view.Menu;
import android.widget.TextView;

import net.sf.json.JSON;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.json.*;
import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;

public class Sotd extends Activity {

    static String sotd, content, titleString, body;



    Document doc;

    MyAsyncTask asyncTask;


    public Sotd() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sotd);
        TextView textView = (TextView) findViewById(R.id.text_view);
        titleString = "";
        body = "";
        Element element;
        asyncTask = new MyAsyncTask();
        asyncTask.execute();
        try {
            content = asyncTask.get();
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            body = ParseHTML(content);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            doc = Jsoup.parse(content);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try{
            body = doc.body().text();
        }catch(Exception e){
            e.printStackTrace();
        }
        textView.setText(titleString);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    /*
    protected String Parse_JSON() throws JSONException{
        JSONObject json = new JSONObject(content);
        String extracted = obj.
    }
*/
    public class MyAsyncTask extends AsyncTask<String, String, String> {
        protected String doInBackground(String... Prams) {

            EasyHttpClient client = new EasyHttpClient();

            //TextView textView = ;

            sotd = client.get("https://www.compasshb.com/api/v1/passages");
            //text.setText(sotd);
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
/*
    public String ParsePlain (String content) throws IOException {
        Element element = new Element(new Tag(), content);

        HtmlToPlainText obj = new HtmlToPlainText();

        try{
            content = obj.getPlainText(content);
        }
    }*/

}