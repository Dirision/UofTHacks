package comdirisionuofthacks.httpsgithub.opus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button yourButton = (Button) findViewById(R.id.button);

        yourButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(YourCurrentActivity.this, YourNewActivity.class));
            }
        });
    }
}
