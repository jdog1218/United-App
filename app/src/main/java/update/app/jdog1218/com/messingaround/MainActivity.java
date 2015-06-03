package update.app.jdog1218.com.messingaround;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.net.URLConnection;


public class MainActivity extends Activity {

    private Button answer_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout bible = new RelativeLayout(this);
        answer_Button = (Button) findViewById(R.id.go_button);


        setContentView(bible);


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
        int id = item.getItemId();
        DialogFragment myfragment = new DialogFragment();
        myfragment.show(getFragmentManager(), "The Best Cancel");
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.menu.menu_main) {
            finish();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void getButton_Response(View view){
        String userName = String.valueOf(R.id.go_button);
        String yourYesResponse = "That is great " + userName;
        Toast.makeText(this,yourYesResponse,Toast.LENGTH_SHORT).show();
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

        TextView userNameMessage = (TextView) findViewById(R.id.go_button);

        String nameSentBack = data.getStringExtra("UsersName");
        userNameMessage.append(" " + nameSentBack);
    }

    public void sendUserNextPage(View view) {
        Intent button_Click = new Intent(this, bible.class);

        final int result = 1;

        button_Click.putExtra("called", "MainActvity");
    }

    public void gotoSetting(MenuItem item) {
        Intent setting = new Intent(this, Settings.class);

    }

    public void sendtovideos(MenuItem item) {
        Intent clickedVideos = new Intent(this, Videos.class);
        clickedVideos.putExtra("Pulled Content", Youtube.class);
    }

    public void sendtoYoutube(MenuItem item) {
        Intent clickedYoutube = new Intent(this, Youtube.class);
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

