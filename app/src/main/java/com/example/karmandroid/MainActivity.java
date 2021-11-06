package com.example.karmandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.karmandroidlab.R;


/** Description: login page app which checks user input meets the correct requirment
 * for the password
 * @author Karm Patel
 */

public class MainActivity extends AppCompatActivity {
    TextView tv = null;
    EditText et = null;
    Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        /**
         * Using OnClickListener function
         */
        btn.setOnClickListener( clk ->{
            String password = et.getText().toString();

            if(checkPasswordComplexity( password )) {
                tv.setText("Your password is correct");
            }
            else
                tv.setText("password is incorrect");
        });
    }

    /** below funtion is to check if there are any numbers, uppercase letter, lower case letter or special character
     *
     * @param p string we want to check
     * @return true if password is correct or false if its incorrect
     */
    private boolean checkPasswordComplexity( String p ){
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

        /**
         * loop to check step by step
         */

        for (int i = 0; i<p.length(); i++){
            char c = p.charAt(i);
            Log.i("Looking at char:", ""+c);

            if  ( Character.isDigit(c))
                foundNumber = true;
            else if  (Character.isUpperCase(c))
                foundUpperCase = true;
            else if (Character.isLowerCase(c))
                foundLowerCase = true;
            else if (isSpecialCharacter(c))
                foundSpecial = true;
        }

        /**
         * if the previous elseif statement doest work then show pop up message
         */

        if( ! foundNumber)
        {
            Toast.makeText(getApplicationContext(), "You need to have number" , Toast.LENGTH_SHORT).show();
        }

        else if( ! foundUpperCase)
        {
            Toast.makeText(getApplicationContext(), "You need to have upper case letter " , Toast.LENGTH_SHORT).show();
            return false;
        }

        else if( ! foundLowerCase)
        {
            Toast.makeText(getApplicationContext(), "you need to have lower case letter" , Toast.LENGTH_SHORT).show();
            return false;
        }

        else if(! foundSpecial)
        {
            Toast.makeText(getApplicationContext(), "You need to have special charcters" , Toast.LENGTH_SHORT).show();
            return false;
        }

        else
            return true;

        return foundNumber && foundUpperCase && foundLowerCase && foundSpecial;
    }
    /**
     *
     * @param ca
     * @return   return true if there is a special character #$%^&*!@?
     * else it will return false
     */
    private boolean isSpecialCharacter(char ca)
    {
        switch (ca)
        {
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
                return true;

            default:

                return false;
        }
    }
}


