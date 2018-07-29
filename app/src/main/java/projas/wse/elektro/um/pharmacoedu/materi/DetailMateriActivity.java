package projas.wse.elektro.um.pharmacoedu.materi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import projas.wse.elektro.um.pharmacoedu.R;
import projas.wse.elektro.um.pharmacoedu.materi.pojo.Materi;

public class DetailMateriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_materi);

        Materi materi = (Materi) getIntent().getParcelableExtra("materi");

        TextView tvTitle = (TextView) findViewById(R.id.detail_materi_tv_title);
        tvTitle.setText(materi.getTitle());

        PDFView pdfView = (PDFView) findViewById(R.id.pdf_view);
        pdfView.fromAsset(materi.getFileSource())
                .enableSwipe(true)
                .swipeHorizontal(true)
                .enableDoubletap(false)
                .pageFitPolicy(FitPolicy.WIDTH)
                .spacing(0)
                .load();
    }
}
