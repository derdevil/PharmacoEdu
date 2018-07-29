package projas.wse.elektro.um.pharmacoedu.tts.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;

import projas.wse.elektro.um.pharmacoedu.R;
import projas.wse.elektro.um.pharmacoedu.tts.helper.PuzzleHelper;
import projas.wse.elektro.um.pharmacoedu.tts.pojo.CrossWord;

/**
 * A simple {@link Fragment} subclass.
 */
public class PuzzleFourFragment extends Fragment implements View.OnClickListener {

    private PuzzleHelper helper;

    private int activeBoxId;

    private View vParent;
    private TextView tvQuestion;
    private TextView tvAnswer1A;
    private TextView tvAnswer1B;
    private TextView tvAnswer1C;
    private TextView tvAnswer1D;
    private TextView tvAnswer1E;
    private TextView tvAnswer1F;
    private TextView tvAnswer1G;
    private TextView tvAnswer2A;
    private TextView tvAnswer2B;
    private TextView tvAnswer2C;
    private TextView tvAnswer2D;
    private TextView tvAnswer2E;
    private TextView tvAnswer2F;
    private TextView tvAnswer2G;

    public PuzzleFourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        prepareData();
        vParent = inflater.inflate(R.layout.fragment_puzzle_four, container, false);
        fetchLayout();
        tvQuestion.setText("");
        setAnswerKeyText("TTKKKNA##OE##A");
        return vParent;
    }

    private void fetchLayout() {
        tvQuestion = vParent.findViewById(R.id.key_tv_question);

        TextView tvClear = vParent.findViewById(R.id.key_tv_clear);
        tvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearActiveForm();
            }
        });
        tvClear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getContext(), "Hapus Semua", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        TextView tvCheck = vParent.findViewById(R.id.key_tv_check);
        tvCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });
        tvCheck.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getContext(), "Periksa Jawaban", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        tvAnswer1A = vParent.findViewById(R.id.key_tv_answer_1a);
        tvAnswer1A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer1A.getText().toString());
            }
        });
        tvAnswer1B = vParent.findViewById(R.id.key_tv_answer_1b);
        tvAnswer1B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer1B.getText().toString());
            }
        });
        tvAnswer1C = vParent.findViewById(R.id.key_tv_answer_1c);
        tvAnswer1C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer1C.getText().toString());
            }
        });
        tvAnswer1D = vParent.findViewById(R.id.key_tv_answer_1d);
        tvAnswer1D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer1D.getText().toString());
            }
        });
        tvAnswer1E = vParent.findViewById(R.id.key_tv_answer_1e);
        tvAnswer1E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer1E.getText().toString());
            }
        });
        tvAnswer1F = vParent.findViewById(R.id.key_tv_answer_1f);
        tvAnswer1F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer1F.getText().toString());
            }
        });
        tvAnswer1G = vParent.findViewById(R.id.key_tv_answer_1g);
        tvAnswer1G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer1G.getText().toString());
            }
        });

        tvAnswer2A = vParent.findViewById(R.id.key_tv_answer_2a);
        tvAnswer2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer2A.getText().toString());
            }
        });
        tvAnswer2B = vParent.findViewById(R.id.key_tv_answer_2b);
        tvAnswer2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer2B.getText().toString());
            }
        });
        tvAnswer2C = vParent.findViewById(R.id.key_tv_answer_2c);
        tvAnswer2C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer2C.getText().toString());
            }
        });
        tvAnswer2D = vParent.findViewById(R.id.key_tv_answer_2d);
        tvAnswer2D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer2D.getText().toString());
            }
        });
        tvAnswer2E = vParent.findViewById(R.id.key_tv_answer_2e);
        tvAnswer2E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer2E.getText().toString());
            }
        });
        tvAnswer2F = vParent.findViewById(R.id.key_tv_answer_2f);
        tvAnswer2F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer2F.getText().toString());
            }
        });
        tvAnswer2G = vParent.findViewById(R.id.key_tv_answer_2g);
        tvAnswer2G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserTyping(tvAnswer2G.getText().toString());
            }
        });

        TableLayout board = vParent.findViewById(R.id.puzzle_four_board);
        board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deactivateBox();
            }
        });

        for (CrossWord crossWord : helper.listWord) {
            for (int anAPuzzleBoxIdMap : crossWord.getBoxId()) {
                if (anAPuzzleBoxIdMap == -1) continue;

                TextView tvBox = vParent.findViewById(anAPuzzleBoxIdMap);
                tvBox.setOnClickListener(this);
            }
        }
    }

    private void activateBox(int boxId) {
        activeBoxId = boxId;

//        int pos[] = helper.findBoxPositionById(boxId);
//        ArrayList<Integer> neighbours = helper.findBoxNeighbour(pos[0], pos[1]);

        CrossWord crossWord = helper.findObjectById(boxId);

        if (crossWord == null) {
            int[] i = helper.findBoxPositionById(boxId);
            Log.d("PuzzleOneFragment", "row: "+i[0]+", col: "+i[1]);
            return;
        }

        TextView tvBox = vParent.findViewById(activeBoxId);
        tvBox.setBackgroundResource(helper.BG_ACTIVE_BOX);

        for (int id : crossWord.getBoxId()) {
            if (id == activeBoxId) continue;
            tvBox = vParent.findViewById(id);
            tvBox.setBackgroundResource(helper.BG_PASSIVE_BOX);
        }

        tvQuestion.setText(crossWord.getQuestion());
        setAnswerKeyText(crossWord.getRandomKey());
    }

    private void deactivateBox() {
        if (activeBoxId == -1) return;

//        int pos[] = helper.findBoxPositionById(activeBoxId);
//        ArrayList<Integer> neighbours = helper.findBoxNeighbour(pos[0], pos[1]);

        CrossWord crossWord = helper.findObjectById(activeBoxId);

        TextView tvBox = vParent.findViewById(activeBoxId);
        tvBox.setBackground(null);

        for (int id : crossWord.getBoxId()) {
            tvBox = vParent.findViewById(id);
            tvBox.setBackground(null);
        }

        activeBoxId = -1;
        tvQuestion.setText("");
        setAnswerKeyText("TTKKKNA##OE##A");
    }

    private void setAnswerKeyText(String text) {
        if (text.length() < 14) text = helper.addTextPadding(text);

        tvAnswer1A.setText(String.valueOf(text.charAt(12)));
        tvAnswer1B.setText(String.valueOf(text.charAt(1)));
        tvAnswer1C.setText(String.valueOf(text.charAt(10)));
        tvAnswer1D.setText(String.valueOf(text.charAt(3)));
        tvAnswer1E.setText(String.valueOf(text.charAt(13)));
        tvAnswer1F.setText(String.valueOf(text.charAt(5)));
        tvAnswer1G.setText(String.valueOf(text.charAt(11)));
        tvAnswer2A.setText(String.valueOf(text.charAt(7)));
        tvAnswer2B.setText(String.valueOf(text.charAt(4)));
        tvAnswer2C.setText(String.valueOf(text.charAt(9)));
        tvAnswer2D.setText(String.valueOf(text.charAt(0)));
        tvAnswer2E.setText(String.valueOf(text.charAt(6)));
        tvAnswer2F.setText(String.valueOf(text.charAt(2)));
        tvAnswer2G.setText(String.valueOf(text.charAt(8)));
    }

    private void onUserTyping (String answer) {
        if (activeBoxId == -1) return;

        TextView tvBox = vParent.findViewById(activeBoxId);
        tvBox.setText(answer);

        int tempId = activeBoxId;
        deactivateBox();
        activeBoxId = helper.findNextNeighbourId(tempId);
        activateBox(activeBoxId);
    }

    private void clearActiveForm() {
        if (activeBoxId == -1) return;

        CrossWord crossWord = helper.findObjectById(activeBoxId);
        int[] boxes = crossWord.getBoxId();
        for (int i=boxes.length-1; i>=0; i--) {
            TextView tvBox = vParent.findViewById(boxes[i]);
            tvBox.setText("");
        }
    }

    private void checkAnswer() {
        TextView tvBox;
        boolean correct = true;
        for (CrossWord crossWord : helper.listWord) {
            String answer = "";
            for (int id : crossWord.getBoxId()) {
                tvBox = vParent.findViewById(id);
                answer += tvBox.getText();
            }

            if (!answer.equals(crossWord.getKey())) {
                correct = false;
                break;
            }
        }

        if (correct) showFinishDialog();
        else Toast.makeText(getContext(), "Masih ada jawaban yang salah / kosong :(", Toast.LENGTH_SHORT).show();
    }

    private void showFinishDialog() {
        new FancyGifDialog.Builder(getActivity())
                .setTitle("Selamat !!!")
                .setMessage("Semua jawaban TTS kamu benar semua :)")
                .setGifResource(R.drawable.gif_quiz_finish)
                .setPositiveBtnText("Ulangi")
                .setPositiveBtnBackground("#8BC34A")
                .setNegativeBtnText("Keluar")
                .setNegativeBtnBackground("#F44336")
                .isCancellable(false)
                .OnPositiveClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {
                        getActivity().recreate();
                    }
                })
                .OnNegativeClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {
                        getActivity().finish();
                    }
                }).build();
    }

    private void prepareData() {
        activeBoxId = -1;

        String[] question = getResources().getStringArray(R.array.soal_tts_4),
                key = getResources().getStringArray(R.array.kunci_tts_4);

        ArrayList<CrossWord> listWord = new ArrayList<>();
        int i = 0;
        CrossWord crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_1a, R.id.puzzle_four_tv_box_2f,
                        R.id.puzzle_four_tv_box_3a, R.id.puzzle_four_tv_box_4a,
                        R.id.puzzle_four_tv_box_5f
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_1b, R.id.puzzle_four_tv_box_2k,
                        R.id.puzzle_four_tv_box_3d, R.id.puzzle_four_tv_box_4c,
                        R.id.puzzle_four_tv_box_5k, R.id.puzzle_four_tv_box_6c,
                        R.id.puzzle_four_tv_box_7i
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_2a, R.id.puzzle_four_tv_box_2b,
                        R.id.puzzle_four_tv_box_2c, R.id.puzzle_four_tv_box_2d,
                        R.id.puzzle_four_tv_box_2e, R.id.puzzle_four_tv_box_2f,
                        R.id.puzzle_four_tv_box_2g
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_2h, R.id.puzzle_four_tv_box_2i,
                        R.id.puzzle_four_tv_box_2j
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_2i, R.id.puzzle_four_tv_box_3b,
                        R.id.puzzle_four_tv_box_4b, R.id.puzzle_four_tv_box_5j,
                        R.id.puzzle_four_tv_box_6b, R.id.puzzle_four_tv_box_7f,
                        R.id.puzzle_four_tv_box_8b, R.id.puzzle_four_tv_box_9k,
                        R.id.puzzle_four_tv_box_10b
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_3c, R.id.puzzle_four_tv_box_3d,
                        R.id.puzzle_four_tv_box_3e, R.id.puzzle_four_tv_box_3f,
                        R.id.puzzle_four_tv_box_3g, R.id.puzzle_four_tv_box_3h
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_4d, R.id.puzzle_four_tv_box_5l,
                        R.id.puzzle_four_tv_box_6e, R.id.puzzle_four_tv_box_7m,
                        R.id.puzzle_four_tv_box_8d, R.id.puzzle_four_tv_box_9m,
                        R.id.puzzle_four_tv_box_10k
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_5a, R.id.puzzle_four_tv_box_5b,
                        R.id.puzzle_four_tv_box_5c, R.id.puzzle_four_tv_box_5d,
                        R.id.puzzle_four_tv_box_5e, R.id.puzzle_four_tv_box_5f,
                        R.id.puzzle_four_tv_box_5g, R.id.puzzle_four_tv_box_5h,
                        R.id.puzzle_four_tv_box_5i
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_5h, R.id.puzzle_four_tv_box_6a,
                        R.id.puzzle_four_tv_box_7b, R.id.puzzle_four_tv_box_8a,
                        R.id.puzzle_four_tv_box_9i, R.id.puzzle_four_tv_box_10a,
                        R.id.puzzle_four_tv_box_11j, R.id.puzzle_four_tv_box_12a,
                        R.id.puzzle_four_tv_box_13h, R.id.puzzle_four_tv_box_14b,
                        R.id.puzzle_four_tv_box_15b, R.id.puzzle_four_tv_box_16c
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_6d, R.id.puzzle_four_tv_box_7j,
                        R.id.puzzle_four_tv_box_8c, R.id.puzzle_four_tv_box_9l,
                        R.id.puzzle_four_tv_box_10g, R.id.puzzle_four_tv_box_11l,
                        R.id.puzzle_four_tv_box_12b, R.id.puzzle_four_tv_box_13j,
                        R.id.puzzle_four_tv_box_14d
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_7a, R.id.puzzle_four_tv_box_7b,
                        R.id.puzzle_four_tv_box_7c, R.id.puzzle_four_tv_box_7d,
                        R.id.puzzle_four_tv_box_7e, R.id.puzzle_four_tv_box_7f,
                        R.id.puzzle_four_tv_box_7g, R.id.puzzle_four_tv_box_7h,
                        R.id.puzzle_four_tv_box_7i
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_7k, R.id.puzzle_four_tv_box_7l,
                        R.id.puzzle_four_tv_box_7m, R.id.puzzle_four_tv_box_7n,
                        R.id.puzzle_four_tv_box_7o
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_9a, R.id.puzzle_four_tv_box_9b,
                        R.id.puzzle_four_tv_box_9c, R.id.puzzle_four_tv_box_9d,
                        R.id.puzzle_four_tv_box_9e, R.id.puzzle_four_tv_box_9f,
                        R.id.puzzle_four_tv_box_9g, R.id.puzzle_four_tv_box_9h,
                        R.id.puzzle_four_tv_box_9i, R.id.puzzle_four_tv_box_9j
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_10b, R.id.puzzle_four_tv_box_10c,
                        R.id.puzzle_four_tv_box_10d, R.id.puzzle_four_tv_box_10e,
                        R.id.puzzle_four_tv_box_10f, R.id.puzzle_four_tv_box_10g,
                        R.id.puzzle_four_tv_box_10h, R.id.puzzle_four_tv_box_10i,
                        R.id.puzzle_four_tv_box_10j, R.id.puzzle_four_tv_box_10k
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_11a, R.id.puzzle_four_tv_box_11b,
                        R.id.puzzle_four_tv_box_11c, R.id.puzzle_four_tv_box_11d,
                        R.id.puzzle_four_tv_box_11e, R.id.puzzle_four_tv_box_11f,
                        R.id.puzzle_four_tv_box_11g, R.id.puzzle_four_tv_box_11h,
                        R.id.puzzle_four_tv_box_11i, R.id.puzzle_four_tv_box_11j,
                        R.id.puzzle_four_tv_box_11k
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_13a, R.id.puzzle_four_tv_box_13b,
                        R.id.puzzle_four_tv_box_13c, R.id.puzzle_four_tv_box_13d,
                        R.id.puzzle_four_tv_box_13e, R.id.puzzle_four_tv_box_13f,
                        R.id.puzzle_four_tv_box_13g, R.id.puzzle_four_tv_box_13h,
                        R.id.puzzle_four_tv_box_13i
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_13d, R.id.puzzle_four_tv_box_14a,
                        R.id.puzzle_four_tv_box_15a, R.id.puzzle_four_tv_box_16a,
                        R.id.puzzle_four_tv_box_17a, R.id.puzzle_four_tv_box_18a,
                        R.id.puzzle_four_tv_box_19a, R.id.puzzle_four_tv_box_20a
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                        R.id.puzzle_four_tv_box_14c, R.id.puzzle_four_tv_box_15c,
                        R.id.puzzle_four_tv_box_16h
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i],
                new int[]{
                        R.id.puzzle_four_tv_box_16b, R.id.puzzle_four_tv_box_16c,
                        R.id.puzzle_four_tv_box_16d, R.id.puzzle_four_tv_box_16e,
                        R.id.puzzle_four_tv_box_16f, R.id.puzzle_four_tv_box_16g,
                        R.id.puzzle_four_tv_box_16h, R.id.puzzle_four_tv_box_16i,
                        R.id.puzzle_four_tv_box_16j
                });
        listWord.add(crossWord);

        helper = new PuzzleHelper(listWord);
    }

    @Override
    public void onClick(View view) {
        deactivateBox();
        activateBox(view.getId());
    }
}
