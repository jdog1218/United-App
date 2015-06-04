package update.app.jdog1218.com.messingaround;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.widget.TextView;

import org.jsoup.Jsoup;
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


    String title;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.sotd);
        Intent activityThatCalled = getIntent();
        startActivity(activityThatCalled);

    }


    /**
     * Pull and Parse the HTML of Compass HB for SOTD.
     *
     * @return DocumentString
     * @throws IOException
     */
    public void pullHTML() {
        final String url = "https://www.compasshb.com/api/v1/passages";
        Document doc = null;
        Text textView = (Text) findViewById(R.id.SOTD);
        try {
            doc = Jsoup.connect(url).get();
            textView.appendData(doc.ownText());
            title = doc.title();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
