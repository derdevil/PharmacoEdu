package projas.wse.elektro.um.pharmacoedu.tts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import projas.wse.elektro.um.pharmacoedu.R;
import projas.wse.elektro.um.pharmacoedu.tts.adapter.RvTtsAdapter;
import projas.wse.elektro.um.pharmacoedu.tts.pojo.RvTtsItemClickListener;

public class TTSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tts);

        ArrayList<String> listTts = new ArrayList<>();
        for (int i=1; i<=7; i++) listTts.add(getString(R.string.title_tts) + " " + i);

        RvTtsItemClickListener clickListener = new RvTtsItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(TTSActivity.this, BoardActivity.class);
                intent.putExtra("pos", position);
                startActivity(intent);
            }
        };

        RvTtsAdapter rvAdapter = new RvTtsAdapter(listTts, clickListener);

        RecyclerView rvTts = (RecyclerView) findViewById(R.id.tts_rv);
        rvTts.setAdapter(rvAdapter);
        rvTts.setLayoutManager(new LinearLayoutManager(TTSActivity.this));
    }
}
