package es.starfallstudios.fallenlegends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash_screen);
        Thread background = new Thread(() -> {
            try {
                // Thread will sleep for 5 seconds
                Thread.sleep(5*1000);

                System.out.println("Thread is running");

                // After 5 seconds redirect to another intent
                Intent i = new Intent(MainActivity.this,HomeScreen.class);
                startActivity(i);

                //Remove activity
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        // start thread
        background.start();
    }
}