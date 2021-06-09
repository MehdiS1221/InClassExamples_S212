package algonquin.cst2335.inclassexamples_s21;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = findViewById(R.id.nextPageButton);
        Log.w("MainActivity", "In onCreate() - Loading Widgets" );

        loginBtn.setOnClickListener( clk -> {

            et = findViewById(R.id.inputEditText);
            Intent nextPage = new Intent(MainActivity.this, SecondActivity.class);

            nextPage.putExtra("SomeInfo", et.getText().toString());
            nextPage.putExtra("MyFloat", et.getText().toString());
            nextPage.putExtra("IsTrue", false);

            Intent call = new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
            //call.setData(Uri.parse("tel:" + "613 123 3567"));
            startActivityForResult( nextPage, 123 );
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String path = getFilesDir().getPath();
        if(requestCode == 123) {
            if (resultCode == RESULT_OK) {
                Bitmap thumbnail = data.getParcelableExtra("data");
                FileOutputStream fOut = null;

                try {
                    fOut = openFileOutput("Picture.png", Context.MODE_PRIVATE);
                    thumbnail.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                fOut.flush();
                fOut.close();

                } catch (Exception e){
                    e.printStackTrace();

                }
                Log.w("MainActivity", "Coming back from next page");
            }
        }
    }


    //Cntl + o = overide

    @Override
    protected void onStart() {
        super.onStart();

        Log.w("MainActivity", "In onStart() - now visible" );

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("MainActivity", "in onResume() - Listen for input" );

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}