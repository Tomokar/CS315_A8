package com.example.cs315_a8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
//    public ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton = this.findViewById(R.id.parseButton);
//        mImageView = this.findViewById(R.id.monsterImageView);

        if(mButton != null)
        {
            mButton.setOnClickListener(view ->
            {
                ParseThemInfo parseTI = new ParseThemInfo();
                parseTI.ParseIt(this);
            }
            );
        }

//        updateContent();
    }

//    private void updateContent()
//    {
//        mImageView.setImageBitmap();
//    }
}