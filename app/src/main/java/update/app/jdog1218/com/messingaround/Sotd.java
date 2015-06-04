package update.app.jdog1218.com.messingaround;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import java.io.IOException;

import static org.jsoup.Jsoup.*;

/*
 * Created by Joel on 5/28/2015.
 */
public class Sotd extends Activity {


    @Override
    protected void onStart() {
        super.onStart();
    }

    String title;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.sotd);
        final String url = "https://www.compasshb.com/api/v1/passages";
        Document doc = null;
        Element element = null;
        TextView textView = (TextView) findViewById(R.id.SOTD);
        try {
            doc = Jsoup.connect(url).get().clone();
            String paragraph = doc.title();
            element = doc.select("div").first();
            textView.setText(element.html());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Pull and Parse the HTML of Compass HB for SOTD.
     *
     * @return DocumentString
     * @throws IOException
     */
    protected String pullHTML() {
        super.onStart();
        final String url = "https://www.compasshb.com/api/v1/passages";
        Document doc = null;
        Element element = null;
        TextView textView = (TextView) findViewById(R.id.SOTD);
        try {
            doc = Jsoup.connect(url).get().clone();
            String paragraph = doc.title();
            element = doc.select("div").first();
            textView.setText(element.html());

            return paragraph;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }
}
