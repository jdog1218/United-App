package update.app.jdog1218.com.messingaround;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import static update.app.jdog1218.com.messingaround.R.drawable.the_rendered_background;


public class MainActivity extends Activity {

    private Button answer_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout bible = new LinearLayout(this);

        ImageView image = (ImageView) findViewById(R.id.background);
        image.setAlpha(125);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return super.onOptionsItemSelected(item);
    }

    public void gotoInbeddedBible(MenuItem item) {
        Intent bibleclass = new Intent(this, bible.class);

        final int result = 1;

        bibleclass.putExtra("callingActivity", "MainActivity");

        startActivity(bibleclass);
        startActivityForResult(bibleclass, result);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    public void exit(MenuItem item) {
        Button exitProcess = (Button) findViewById(R.id.submit);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    public void sotd(MenuItem item) {
        Intent clickedSotd = new Intent(this, Sotd.class);

        int result = 1;

        startActivity(clickedSotd);

    }
}

