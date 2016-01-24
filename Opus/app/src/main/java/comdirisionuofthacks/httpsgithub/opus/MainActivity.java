package comdirisionuofthacks.httpsgithub.opus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

=======
>>>>>>> origin/master
        final Button workButton = (Button) findViewById(R.id.button);
        workButton.setOnClickListener(this);

        final Button statsButton =(Button) findViewById(R.id.button2);
        statsButton.setOnClickListener(this);

        final Button optionButton =(Button) findViewById(R.id.button3);
        optionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button :
                Intent intent = new Intent(this, WorkActivity.class);
                startActivity(intent);
                break;

            case R.id.button2 :
                Intent intent2 = new Intent(this , StatsActivity.class);
                startActivity(intent2);
                break;

            case R.id.button3 :
                Intent intent3 = new Intent(this , OptionActivity.class);
                startActivity(intent3);
                break;
        }
<<<<<<< HEAD
=======

        Button yourButton = (Button) findViewById(R.id.button);

        yourButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                startActivity(new Intent(MainActivity.this, WorkActivity.class));
            }
        });

>>>>>>> origin/master
    }
}
