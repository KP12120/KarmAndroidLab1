package com.example.karmandroidlab;

import static android.widget.CompoundButton.*;
import static com.example.karmandroidlab.R.id.*;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView topView = findViewById(hellotext);
        EditText myedit = findViewById(myedittext);
        //Button
         Button b = findViewById(mybutton);
         b.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view){
                 topView.setText("Your edit text: " + myedit.getText());
             }
         });
        CheckBox ch = findViewById(R.id.checkBox);
        ch.setOnCheckedChangeListener( ( a, k) ->{
            Toast.makeText(getApplicationContext(), "You Clicked on the Checkbox" , Toast.LENGTH_LONG).show();
        });

        //Switch
        Switch w = findViewById(switch1);
        w.setOnCheckedChangeListener( ( a, k) ->{
            Toast.makeText(getApplicationContext(), "You Clicked on the Switch" , Toast.LENGTH_SHORT).show();
        });


        //Radiobutton
        RadioButton r = findViewById(R.id.radioButton);
        r.setOnCheckedChangeListener( ( a, k) ->{
            Toast.makeText(getApplicationContext(), "You selected the RadioButton" , Toast.LENGTH_SHORT).show();
        });


       //Imageview
        ImageView i = findViewById(R.id.logo);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //Imagebutton
        ImageButton n = findViewById( R.id.myimagebutton );
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int width = n.getWidth();
                int height = view.getHeight();
                Toast.makeText(getApplicationContext(), "The width = " + width + " and height = " + height, Toast.LENGTH_LONG).show();
            }
        });




    }

}

