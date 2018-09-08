package login.com.girish.sharefontdemo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private SeekBar seekBar;
    private TextView textViewNews;
    private int fontSize = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        textViewNews = findViewById(R.id.textViewNews);

        seekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref",MODE_PRIVATE);
        fontSize = sharedPreferences.getInt("fontSize",fontSize);
        seekBar.setProgress(fontSize);
        textViewNews.setTextSize(fontSize);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("fontSize",fontSize);
        editor.apply();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        textViewNews.setTextSize(i);
        fontSize = i;


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
