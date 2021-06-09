package algonquin.cst2335.inclassexamples_s21;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent fromPrevious = getIntent();
        String text = fromPrevious.getStringExtra("SomeInfo");
        EditText line = findViewById(R.id.editTextPhone);

        String fromMain = fromPrevious.getStringExtra("MyFloat");
        float test = fromPrevious.getFloatExtra("ABCDE", 1.0f);
        boolean t = fromPrevious.getBooleanExtra("IsTrue", false);

        Button call = findViewById(R.id.button);
        call.setOnClickListener(v -> {
//            Intent sendBack = new Intent();
//            sendBack.putExtra("Number", line.getText().toString());
//
//            setResult(345, sendBack);
//            finish();
            TextView top = findViewById(R.id.textView);



            Intent c = new Intent(Intent.ACTION_DIAL);
            c.setData(Uri.parse("tel:" + "613 123 3567"));
            startActivityForResult(c, 4735);
        });

        Button pict = findViewById(R.id.button2);
        pict.setOnClickListener( cl -> {
            Intent in = new Intent(Intent.ACTION_WEB_SEARCH);
            in.putExtra(SearchManager.QUERY, "Ottawa Ontario");
            startActivityForResult(in, 3535);

        });
        TextView top = findViewById(R.id.textView);

        top.setText("Email = " + fromMain );

        //line.setText(text);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}