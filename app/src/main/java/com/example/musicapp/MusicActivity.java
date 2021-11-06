package com.example.musicapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;



public class MusicActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvSoBai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_layout);

        tvSoBai = (TextView) findViewById(R.id.tvsobai);
        Intent intent = getIntent();
        int Index = intent.getIntExtra("Index",1);
        initView();

        getView();

        tvSoBai.setText("" + Index);
        

    }

    private void initView() {
        Button btnChon = (Button) findViewById(R.id.btnchon);
        btnChon.setOnClickListener(this);
    }

    private void getView() {
        tvSoBai=findViewById(R.id.tvsobai);
    }

    public void SelectSong(View view){
        Button btn = (Button) view;
        tvSoBai.setText(btn.getText());

    }
    public void changeSong(View view) {
        int id = Integer.parseInt(tvSoBai.getText().toString());
        Bundle bundle= new Bundle();
        Intent intent = new Intent(this, MainActivity.class);
        if (id==1){
            bundle.putInt("data",id);
            intent.putExtras(bundle);
        }
        if (id==2){
            bundle.putInt("data",id);
            intent.putExtras(bundle);
        }
        if (id==3){
            bundle.putInt("data",id);
            intent.putExtras(bundle);
        }
        if (id==4){
            bundle.putInt("data",id);
            intent.putExtras(bundle);
        }
        if (id==5){
            bundle.putInt("data",id);
            intent.putExtras(bundle);
        }
        if (id==6){
            bundle.putInt("data",id);
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch ( view.getId()){
            case R.id.btnchon:
                Intent intent = new Intent();
                intent.setClass(this,MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
