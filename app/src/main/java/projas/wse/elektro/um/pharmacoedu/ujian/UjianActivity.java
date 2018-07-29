package projas.wse.elektro.um.pharmacoedu.ujian;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;

import projas.wse.elektro.um.pharmacoedu.R;
import projas.wse.elektro.um.pharmacoedu.ujian.pojo.Quiz;

public class UjianActivity extends AppCompatActivity {

    private int currNo;
    private StringBuffer lembarJwbn;
    private ArrayList<Quiz> listQuiz;

    private Snackbar snackbar;
    private MenuItem menuNext;
    private ViewFlipper vfParent;
    private ScrollView svGenap, svGanjil;
    private TextView tvSoalGenap, tvSoalGanjil;
    private RadioGroup rgJwbnGenap, rgJwbnGanjil;
    private RadioButton rbGenapA, rbGenapB, rbGenapC, rbGenapD, rbGenapE,
            rbGanjilA, rbGanjilB, rbGanjilC, rbGanjilD, rbGanjilE;
    private FancyAlertDialog.Builder fadQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ujian);

        prepareData();
        fetchLayout();
        showQuiz(listQuiz.get(currNo));
        if (currNo != 0 && currNo%2 != 0) {
            vfParent.setOutAnimation(this, R.anim.out_to_left);
            vfParent.setInAnimation(this, R.anim.in_from_right);
            vfParent.showNext();
        }
    }

    @Override
    public void onBackPressed() {
        saveProgress();
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ujian_op_menu, menu);
        menuNext = menu.getItem(1);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.ujian_op_left:
                if (currNo - 1 < 0) return true;

                showQuiz(listQuiz.get(--currNo));
                vfParent.setOutAnimation(this, R.anim.out_to_right);
                vfParent.setInAnimation(this, R.anim.in_from_left);
                vfParent.showPrevious();
                return true;
            case R.id.ujian_op_right:
                if (currNo + 1 >= listQuiz.size()) {
                    showFinishDialog();
                    return true;
                }

                Quiz quiz = listQuiz.get(currNo);
                if (quiz.getPilihan().equals("-")) lembarJwbn.insert(currNo, quiz.getPilihan());

                showQuiz(listQuiz.get(++currNo));
                vfParent.setOutAnimation(this, R.anim.out_to_left);
                vfParent.setInAnimation(this, R.anim.in_from_right);
                vfParent.showNext();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void prepareData() {
        listQuiz = new ArrayList<>();
        lembarJwbn = new StringBuffer(getSharedPreferences("pharmacoedu_ujian_pref", MODE_PRIVATE)
                            .getString("lembar_jwbn", ""));
        currNo = lembarJwbn.length();

        String[] soal = getResources().getStringArray(R.array.soal_ujian),
                kunci = getResources().getStringArray(R.array.kunci_ujian),
                jwbnA = getResources().getStringArray(R.array.jwbn_ujian_a),
                jwbnB = getResources().getStringArray(R.array.jwbn_ujian_b),
                jwbnC = getResources().getStringArray(R.array.jwbn_ujian_c),
                jwbnD = getResources().getStringArray(R.array.jwbn_ujian_d),
                jwbnE = getResources().getStringArray(R.array.jwbn_ujian_e);

        for (int i=0; i<soal.length; i++) {
            Quiz quiz = new Quiz(soal[i], jwbnA[i], jwbnB[i], jwbnC[i], jwbnD[i], jwbnE[i], kunci[i]);
            if (i < lembarJwbn.length()) quiz.setPilihan(String.valueOf(lembarJwbn.charAt(i)));
            listQuiz.add(quiz);
        }
    }

    private void fetchLayout() {
        vfParent = (ViewFlipper) findViewById(R.id.ujian_vf_parent);

        snackbar = Snackbar.make(vfParent, "Maaf, jawabanmu belum tepat :(", Snackbar.LENGTH_LONG);
        snackbar.setAction("Coba Lagi", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });

        fadQuiz = new FancyAlertDialog.Builder(this)
                .setPositiveBtnText("Lanjut")
                .setPositiveBtnBackground(Color.parseColor("#8BC34A"))
                .setNegativeBtnText("Tutup")
                .setNegativeBtnBackground(Color.parseColor("#F44336"))
                .setAnimation(Animation.POP)
                .isCancellable(false)
                .OnPositiveClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {
                        onOptionsItemSelected(menuNext);
                    }
                })
                .OnNegativeClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {

                    }
                });

        svGenap = (ScrollView) findViewById(R.id.item_ujian_genap_sv_parent);
        svGanjil = (ScrollView) findViewById(R.id.item_ujian_ganjil_sv_parent);

        tvSoalGenap = (TextView) findViewById(R.id.item_ujian_genap_tv_soal);
        tvSoalGanjil = (TextView) findViewById(R.id.item_ujian_ganjil_tv_soal);

        rgJwbnGenap = (RadioGroup) findViewById(R.id.item_ujian_genap_rg_jawaban);
        rgJwbnGanjil = (RadioGroup) findViewById(R.id.item_ujian_ganjil_rg_jawaban);

        rbGenapA = (RadioButton) findViewById(R.id.item_ujian_genap_rb_a);
        rbGenapB = (RadioButton) findViewById(R.id.item_ujian_genap_rb_b);
        rbGenapC = (RadioButton) findViewById(R.id.item_ujian_genap_rb_c);
        rbGenapD = (RadioButton) findViewById(R.id.item_ujian_genap_rb_d);
        rbGenapE = (RadioButton) findViewById(R.id.item_ujian_genap_rb_e);

        rbGanjilA = (RadioButton) findViewById(R.id.item_ujian_ganjil_rb_a);
        rbGanjilB = (RadioButton) findViewById(R.id.item_ujian_ganjil_rb_b);
        rbGanjilC = (RadioButton) findViewById(R.id.item_ujian_ganjil_rb_c);
        rbGanjilD = (RadioButton) findViewById(R.id.item_ujian_ganjil_rb_d);
        rbGanjilE = (RadioButton) findViewById(R.id.item_ujian_ganjil_rb_e);

        rbGenapA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Quiz quiz = listQuiz.get(currNo);
                    quiz.setPilihan("A");
                    quiz.increaseJmlMenjawab();
                    checkAnswer();
                }
            }
        });
        rbGenapB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Quiz quiz = listQuiz.get(currNo);
                    quiz.setPilihan("B");
                    quiz.increaseJmlMenjawab();
                    checkAnswer();
                }
            }
        });
        rbGenapC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Quiz quiz = listQuiz.get(currNo);
                    quiz.setPilihan("C");
                    quiz.increaseJmlMenjawab();
                    checkAnswer();
                }
            }
        });
        rbGenapD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Quiz quiz = listQuiz.get(currNo);
                    quiz.setPilihan("D");
                    quiz.increaseJmlMenjawab();
                    checkAnswer();
                }
            }
        });
        rbGenapE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Quiz quiz = listQuiz.get(currNo);
                    quiz.setPilihan("E");
                    quiz.increaseJmlMenjawab();
                    checkAnswer();
                }
            }
        });

        rbGanjilA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Quiz quiz = listQuiz.get(currNo);
                    quiz.setPilihan("A");
                    quiz.increaseJmlMenjawab();
                    checkAnswer();
                }
            }
        });
        rbGanjilB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Quiz quiz = listQuiz.get(currNo);
                    quiz.setPilihan("B");
                    quiz.increaseJmlMenjawab();
                    checkAnswer();
                }
            }
        });
        rbGanjilC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Quiz quiz = listQuiz.get(currNo);
                    quiz.setPilihan("C");
                    quiz.increaseJmlMenjawab();
                    checkAnswer();
                }
            }
        });
        rbGanjilD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Quiz quiz = listQuiz.get(currNo);
                    quiz.setPilihan("D");
                    quiz.increaseJmlMenjawab();
                    checkAnswer();
                }
            }
        });
        rbGanjilE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Quiz quiz = listQuiz.get(currNo);
                    quiz.setPilihan("E");
                    quiz.increaseJmlMenjawab();
                    checkAnswer();
                }
            }
        });
    }

    private void showQuiz(Quiz quiz) {
        getSupportActionBar().setTitle(String.format(getResources().getString(R.string.title_soalno), (currNo+1)+""));
        snackbar.dismiss();
        if (currNo%2 == 0) {
            // no genap
            svGenap.fullScroll(ScrollView.FOCUS_UP);
            tvSoalGenap.setText(quiz.getSoal());
            rgJwbnGenap.clearCheck();
            rbGenapA.setText(quiz.getJwbnA());
            rbGenapB.setText(quiz.getJwbnB());
            rbGenapC.setText(quiz.getJwbnC());
            rbGenapD.setText(quiz.getJwbnD());
            rbGenapE.setText(quiz.getJwbnE());

            if (!quiz.getPilihan().equals("-")) {
                // terjawab
                quiz.decreaseJmlMenjawab();
                switch (quiz.getPilihan()) {
                    case "A":
                        rbGenapA.setChecked(true);
                        break;
                    case "B":
                        rbGenapB.setChecked(true);
                        break;
                    case "C":
                        rbGenapC.setChecked(true);
                        break;
                    case "D":
                        rbGenapD.setChecked(true);
                        break;
                    case "E":
                        rbGenapE.setChecked(true);
                        break;
                    default:
                        quiz.increaseJmlMenjawab();
                        rgJwbnGenap.clearCheck();
                        break;
                }
            }

            disableChoice(quiz.isLimitReached());

        } else {
            // no ganjil
            svGanjil.fullScroll(ScrollView.FOCUS_UP);
            tvSoalGanjil.setText(quiz.getSoal());
            rgJwbnGanjil.clearCheck();
            rbGanjilA.setText(quiz.getJwbnA());
            rbGanjilB.setText(quiz.getJwbnB());
            rbGanjilC.setText(quiz.getJwbnC());
            rbGanjilD.setText(quiz.getJwbnD());
            rbGanjilE.setText(quiz.getJwbnE());

            if (!quiz.getPilihan().equals("-")) {
                // terjawab
                switch (quiz.getPilihan()) {
                    case "A":
                        rbGanjilA.setChecked(true);
                        break;
                    case "B":
                        rbGanjilB.setChecked(true);
                        break;
                    case "C":
                        rbGanjilC.setChecked(true);
                        break;
                    case "D":
                        rbGanjilD.setChecked(true);
                        break;
                    case "E":
                        rbGanjilE.setChecked(true);
                        break;
                    default:
                        rgJwbnGanjil.clearCheck();
                        break;
                }
            }

            disableChoice(quiz.isLimitReached());
        }
    }

    private void checkAnswer() {
        snackbar.dismiss();
        Quiz quiz = listQuiz.get(currNo);
        disableChoice(quiz.isLimitReached());

        if (quiz.isLimitReached()) {
            lembarJwbn.setCharAt(currNo, quiz.getPilihan().charAt(0));
            if (quiz.getPilihan().equalsIgnoreCase(quiz.getKunci())) {
                // jwbn benar
                fadQuiz.setTitle("Hoorayyy !")
                        .setMessage("Jawabanmu benar, ayo lanjut ke soal selanjutnya !")
                        .setBackgroundColor(Color.parseColor("#4CAF50"))
                        .setIcon(R.drawable.ic_check_white_48dp, Icon.Visible)
                        .build();
            } else {
                // jwbn salah
                fadQuiz.setTitle("Salah Lagi :(")
                        .setMessage("Yah, jawabanmu masih salah.\nJawaban yang benar adalah "+quiz.getKunci())
                        .setBackgroundColor(Color.parseColor("#F44336"))
                        .setIcon(R.drawable.ic_close_white_48dp, Icon.Visible)
                        .build();
            }
        } else {
            lembarJwbn.insert(currNo, quiz.getPilihan());
            if (quiz.getPilihan().equalsIgnoreCase(quiz.getKunci())) {
                // jwbn benar
                fadQuiz.setTitle("Hoorayyy !")
                        .setMessage("Jawabanmu benar, ayo lanjut ke soal selanjutnya !")
                        .setBackgroundColor(Color.parseColor("#4CAF50"))
                        .setIcon(R.drawable.ic_check_white_48dp, Icon.Visible)
                        .build();
            } else {
                // jwbn salah
                snackbar.show();
            }
        }
    }

    private void saveProgress() {
        SharedPreferences.Editor editor = getSharedPreferences("pharmacoedu_ujian_pref", MODE_PRIVATE).edit();
        editor.putString("lembar_jwbn", lembarJwbn.toString());
        editor.apply();
    }

    private void clearProgress() {
        SharedPreferences.Editor editor = getSharedPreferences("pharmacoedu_ujian_pref", MODE_PRIVATE).edit();
        editor.putString("lembar_jwbn", "");
        editor.apply();
    }

    private void showFinishDialog() {
        new FancyGifDialog.Builder(UjianActivity.this)
                .setTitle("Selamat !!!")
                .setMessage("Akhirnya kamu berhasil menyelesaikan semua soal ujian :)")
                .setGifResource(R.drawable.gif_quiz_finish)
                .setPositiveBtnText("Ulangi")
                .setPositiveBtnBackground("#8BC34A")
                .setNegativeBtnText("Keluar")
                .setNegativeBtnBackground("#F44336")
                .isCancellable(false)
                .OnPositiveClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {
                        clearProgress();
                        recreate();
                    }
                })
                .OnNegativeClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {
                        clearProgress();
                        finish();
                    }
                }).build();
    }

    private void disableChoice(boolean isDisable) {
        if (currNo%2 == 0) {
            for (int i=0; i<rgJwbnGenap.getChildCount(); i++)
                rgJwbnGenap.getChildAt(i).setEnabled(!isDisable);
        } else {
            for (int i=0; i<rgJwbnGanjil.getChildCount(); i++)
                rgJwbnGanjil.getChildAt(i).setEnabled(!isDisable);
        }
    }
}

