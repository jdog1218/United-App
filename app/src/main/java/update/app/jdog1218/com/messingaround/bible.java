package update.app.jdog1218.com.messingaround;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class bible extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int result = 1;

        setContentView(R.layout.sotd);

        Intent calledBible = getIntent();

        TextView callingActivityMessage = (TextView) findViewById(R.id.SOTD);


    }

    public void sendUserNextPage(View view) {
        EditText usernameET = (EditText) findViewById(R.id.edit_txt);
        String userName = String.valueOf(usernameET.getText());
        Intent goingBack = new Intent();

        goingBack.putExtra("UserName", userName);
        setResult(RESULT_OK, goingBack);
        finish();
    }
}