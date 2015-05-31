package update.app.jdog1218.com.messingaround;

import android.app.Activity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import static org.jsoup.Jsoup.*;

/*
 * Created by Joel on 5/28/2015.
 */
public class Sotd extends Activity {

    public Document pullHTML() {
        String url = "https://www.compasshb.com/read";
        String value = null;
        Document doc = null;
        Elements HrefElse = null;

        try {
            doc = Jsoup.connect(url).get();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
