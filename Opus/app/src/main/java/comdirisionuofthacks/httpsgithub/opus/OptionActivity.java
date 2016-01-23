package comdirisionuofthacks.httpsgithub.opus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OptionActivity extends AppCompatActivity {

    EditText editor;
    EditText editor2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        editor =(EditText)findViewById(R.id.statLGT);
        editor2 =(EditText)findViewById(R.id.statWPM);
        Button reset=(Button)findViewById(R.id.resetButton);
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                editor.setText(0);
                editor2.setText(0);
            }
        });

    }
}
