package com.example.karmandroidlab;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Secondactivity extends AppCompatActivity {

    ImageButton profileImage;
    ActivityResultLauncher<Intent> cameraResult = registerForActivityResult(

            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @Override

                public void onActivityResult(ActivityResult result) {

                    if (result.getResultCode() == Activity.RESULT_OK) {

                        Intent data = result.getData();
                        File whereIam = getFilesDir();
                        Bitmap thumbnail = data.getParcelableExtra("data");

                        try {

                            FileOutputStream fOut = openFileOutput("Picture.png", Context.MODE_PRIVATE);
                            thumbnail.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                            fOut.flush();
                            fOut.close();

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        catch(IOException ioe){
                            Log.w("IOException", "not got png");
                        }

                        Log.i("Got bitmap", "image");
                        profileImage.setImageBitmap( thumbnail );
                    }
                    else if (result.getResultCode() == Activity.RESULT_CANCELED)
                        Log.w("Got bitmap", "User refused image");

                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent fromPrevious = getIntent();
        String emailAddress = fromPrevious.getStringExtra("EmailAddress");
        int age = fromPrevious.getIntExtra("Age", 0);
        String name = fromPrevious.getStringExtra("Name");
        String psCode = fromPrevious.getStringExtra("PostalCode");

        SharedPreferences pre = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        pre.getString("LoginName", emailAddress);
        pre.getInt("Age", age);
        pre.getString("Name", name);
        pre.getString("Postalcode", psCode);
        String edit_Text = pre.getString("LoginName", "");
        SharedPreferences.Editor editor = pre.edit();
        editor.putString("LoginName", emailAddress);
        editor.putInt("Age", age);
        editor.putString("Name", name);
        editor.putString("PostalCode", psCode);
        editor.apply();

            EditText number = findViewById(R.id.editTextPhone);
            Button dialer = findViewById(R.id.button);

            dialer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent call = new Intent(Intent.ACTION_DIAL);
                    call.setData(Uri.parse("tel:"+number.getText().toString()));
                    startActivity(call);
                }
            });
            ImageView camera = findViewById(R.id.imageView);
            Button camera1 = findViewById(R.id.button2);
        camera1.setOnClickListener(clk ->  {

            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            cameraResult.launch(cameraIntent);
        });
    }


}