package com.example.spamtool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ClipboardManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Introducing variables
    String spamText;
    String spammedText;
    String numberStr;
    int spamNumber;

    TextView text;
    EditText number;

    Button spamButton;
    Button copyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) throws NumberFormatException{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Defining variables

        text = findViewById(R.id.spamText);
        number = findViewById(R.id.spamNumber);

        spamButton = findViewById(R.id.spamButton);
        copyButton = findViewById(R.id.copyButton);

        //On button click, triggers onClick() function
        spamButton.setOnClickListener(this);
        copyButton.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) throws NumberFormatException{

        //Check which button was pressed
        switch (view.getId())
        {
            //SPAM button pressed
            case R.id.spamButton:

                spamText = text.getText().toString();
                spammedText = "";
                numberStr = number.getText().toString();

                //Check if the number string isn't null
                if(!"".equals(numberStr))
                {
                    spamNumber = Integer.valueOf(number.getText().toString());

                    if(spamNumber != 0) {
                        for (int x = 1; x <= spamNumber; x++) {
                            if (x == 1) {
                                spammedText = spamText;
                            } else {
                                spammedText = spammedText + " " + spamText;
                            }
                        }


                        //Set text into the spammed text
                        text.setText(spammedText);
                        Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show();
                        copyButton.setVisibility(View.VISIBLE);
                    }
                    else
                        {
                            Toast.makeText(this, "You can't make it zero", Toast.LENGTH_SHORT).show();
                        }
                    if(spamNumber == 103)
                    {
                        Toast.makeText(this, 	"\ud83d\udda4",Toast.LENGTH_LONG).show();
                    }
                    break;

                }
                else {
                    Toast.makeText(this, "You didn't enter a number", Toast.LENGTH_SHORT).show();
                    break;
                    }

            //Copy button pressed
            case R.id.copyButton:
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("simple text", spammedText);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();

                break;


        }

    }
}
