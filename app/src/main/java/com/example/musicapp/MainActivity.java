package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ActivityOptions;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvIndex, tvName, tvTime;
    MediaPlayer music;
    List<Songclass> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initSong();
        getView();

        Intent intent = getIntent();
        int id = (int)intent.getIntExtra("data",1);
        updateView(id);
    }

    private void initView() {
        TextView Chon = findViewById(R.id.tvChonBai);
        Chon.setOnClickListener(this);

    }


    private void initSong() {
        songs = new ArrayList<>();
        songs.add(new Songclass(1, R.raw.buocquamuacodon, "Bước qua mùa cô đơn"));
        songs.add(new Songclass(2, R.raw.happyforyou, "Happy for you"));
        songs.add(new Songclass(3, R.raw.homnaytoibuon, "Hôm nay tôi buồn"));
        songs.add(new Songclass(4, R.raw.trentinhbanduoitinhyeu, "Trên tình bạn dưới tình yêu"));
        songs.add(new Songclass(5, R.raw.tuchoinhenhang, "Từ chố nhẹ nhàng"));
        songs.add(new Songclass(6, R.raw.xuannayconkhongve, "Xuân này con không về"));

    }
    private void getView() {
        tvIndex = findViewById(R.id.tvIndex);
        tvName = findViewById(R.id.tvTenbai);

    }

    private void updateView(int id) {
        tvIndex.setText("Bài " + id);
        tvName.setText(getSong().getName());
        music = MediaPlayer.create(MainActivity.this, getSong().getResourceId());
          music.start();
    }

    private Songclass getSong() {
        String sIndex = tvIndex.getText().toString().split(" ")[1];
        Integer index = Integer.parseInt(sIndex);
//        music.pause();
        return songs.get(index - 1);

    }




    public void musicplay(View v) {
        music.start();
    }

    // Pausing the music
    public void musicpause(View v) {
        if (music != null)
            music.pause();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvChonBai:
                music.pause();
                Intent intent2 = new Intent();
                intent2.setClass(this, MusicActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}

