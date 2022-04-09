package com.sriv.shivam.twinmouseremote;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.sriv.shivam.twinmouseremote.utils.API;
import com.sriv.shivam.twinmouseremote.utils.CONSTANTS;

import org.javacord.api.entity.channel.TextChannel;

import java.util.Optional;
import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {
    View trackpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        trackpad = findViewById(R.id.trackpad);
        
        trackpad.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    int x = Math.round(motionEvent.getX());
                    int y = Math.round(motionEvent.getY());
                    
                    postData(x, y);
                }
                return true;
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void postData(int x, int y) {
        Optional<TextChannel> channel = API.api.getTextChannelById(CONSTANTS.GENERAL_CHANNEL);
        String data = x + "&" + y;
        Log.i("data", "DATA: " + data);

        channel.ifPresent(textChannel -> textChannel.sendMessage(data));
    }
}