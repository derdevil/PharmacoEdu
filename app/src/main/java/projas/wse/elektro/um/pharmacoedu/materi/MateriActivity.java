package projas.wse.elektro.um.pharmacoedu.materi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import projas.wse.elektro.um.pharmacoedu.R;
import projas.wse.elektro.um.pharmacoedu.materi.adapter.RvMateriAdapter;
import projas.wse.elektro.um.pharmacoedu.materi.pojo.Materi;
import projas.wse.elektro.um.pharmacoedu.materi.pojo.RvMateriItemClickListener;

public class MateriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        RvMateriItemClickListener clickListener = new RvMateriItemClickListener() {
            @Override
            public void onItemClick(Materi materi) {
                Intent intent = new Intent(MateriActivity.this, DetailMateriActivity.class);
                intent.putExtra("materi", materi);
                startActivity(intent);
            }
        };
        ArrayList<Materi> listMateri = new ArrayList<>();
        Materi materi = new Materi("Pengantar Farmakologi", "Slide presentasi, 21 halaman.", "materi1.pdf");
        listMateri.add(materi);
        materi = new Materi("Obat", "Slide presentasi, 31 halaman.", "materi2.pdf");
        listMateri.add(materi);
        materi = new Materi("Respon Penderita Terhadap Obat", "Slide presentasi, 24 halaman.", "materi3.pdf");
        listMateri.add(materi);
        materi = new Materi("Antibiotika", "Slide presentasi, 22 halaman.", "materi4.pdf");
        listMateri.add(materi);
        materi = new Materi("Analgesik Antipiretik Anestetik", "Slide presentasi, 25 halaman.", "materi5.pdf");
        listMateri.add(materi);
        materi = new Materi("Obat Sistem Syaraf", "Slide presentasi, 21 halaman.", "materi6.pdf");
        listMateri.add(materi);
        materi = new Materi("Vitamin", "Slide presentasi, 20 halaman.", "materi7.pdf");
        listMateri.add(materi);

        RvMateriAdapter rvAdapter = new RvMateriAdapter(listMateri, clickListener);
        RecyclerView rv = (RecyclerView) findViewById(R.id.materi_rv);
        rv.setAdapter(rvAdapter);
        rv.setLayoutManager(new LinearLayoutManager(MateriActivity.this));
    }
}
