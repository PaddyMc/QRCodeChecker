package com.org.hhh.qrcodechecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        Button capture = (Button) findViewById(R.id.button);
        capture.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setUpCameraIntent();
            }
        });
    }

    private void setUpCameraIntent() {
        new IntentIntegrator(this).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
        Log.d("CameraDemo", "Pic saved");


    }
}
