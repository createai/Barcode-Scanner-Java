package imaginecup.com.barcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String Contents,Format;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void scanResult(View view){
        Intent intent = new Intent("com.google.zxing.client.android.SCAN"); intent.putExtra("com.google.zxing.client.android.SCAN.SCAN_MODE", "QR_CODE_MODE"); startActivityForResult(intent, 0);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(requestCode == 0){
            if(resultCode == RESULT_OK){
                String contents = intent.getStringExtra("SCAN_RESULT");
                Contents=contents;
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                Format=format;
                Log.i("xZing", "contents: " + contents + " format: " + format); // Handle successful scan
            }
            else if(resultCode == RESULT_CANCELED){ // Handle cancel
                Log.i("xZing", "Cancelled");
            }
        }
    }

    public void PrintOnScreen(View view){
        TextView t1,t2;
        t1 = (TextView)findViewById(R.id.Contents_screen);
        t1.setText(Contents);
        t2 = (TextView)findViewById(R.id.Result_screen);
        t2.setText(Format);


    }
}
