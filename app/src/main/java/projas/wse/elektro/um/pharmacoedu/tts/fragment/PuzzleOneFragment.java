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
import java.util.Arrays;

import projas.wse.elektro.um.pharmacoedu.R;
import projas.wse.elektro.um.pharmacoedu.tts.helper.PuzzleHelper;
import projas.wse.elektro.um.pharmacoedu.tts.pojo.CrossWord;

/**
 * A simple {@link Fragment} subclass.
 */
public class PuzzleOneFragment extends Fragment implements View.OnClickListener {

    private PuzzleHelper helper;

    private int activeBoxId;

    private View vParent;
    private TextView tvQuestion, tvClear, tvCheck,
            tvAnswer1A, tvAnswer1B, tvAnswer1C, tvAnswer1D, tvAnswer1E, tvAnswer1F, tvAnswer1G,
            tvAnswer2A, tvAnswer2B, tvAnswer2C, tvAnswer2D, tvAnswer2E, tvAnswer2F, tvAnswer2G;

    public PuzzleOneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        prepareData();
        vParent = inflater.inflate(R.layout.fragment_puzzle_one, container, false);
        fetchLayout();
        tvQuestion.setText("");
        setAnswerKeyText("TTKKKNA##OE##A");
        return vParent;
    }

    private void fetchLayout() {
        tvQuestion = vParent.findViewById(R.id.key_tv_question);

        tvClear = vParent.findViewById(R.id.key_tv_clear);
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
        tvCheck = vParent.findViewById(R.id.key_tv_check);
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

        TableLayout board = vParent.findViewById(R.id.puzzle_one_board);
        board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deactivateBox();
            }
        });

        for (int[] aPuzzleBoxIdMap : helper.puzzleBoxIdMap) {
            for (int anAPuzzleBoxIdMap : aPuzzleBoxIdMap) {
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

        int[][] puzzleBoxIdMap = new int[21][19];
        for (int i = 0; i < 21; i++) Arrays.fill(puzzleBoxIdMap[i], -1);

        puzzleBoxIdMap[0][1] = R.id.puzzle_one_tv_box_1a;
        puzzleBoxIdMap[0][2] = R.id.puzzle_one_tv_box_1b;
        puzzleBoxIdMap[0][3] = R.id.puzzle_one_tv_box_1c;
        puzzleBoxIdMap[0][4] = R.id.puzzle_one_tv_box_1d;
        puzzleBoxIdMap[0][5] = R.id.puzzle_one_tv_box_1e;
        puzzleBoxIdMap[0][6] = R.id.puzzle_one_tv_box_1f;
        puzzleBoxIdMap[0][7] = R.id.puzzle_one_tv_box_1g;
        puzzleBoxIdMap[0][8] = R.id.puzzle_one_tv_box_1h;
        puzzleBoxIdMap[0][9] = R.id.puzzle_one_tv_box_1i;
        puzzleBoxIdMap[0][10] = R.id.puzzle_one_tv_box_1j;
        puzzleBoxIdMap[0][11] = R.id.puzzle_one_tv_box_1k;
        puzzleBoxIdMap[1][6] = R.id.puzzle_one_tv_box_2a;
        puzzleBoxIdMap[2][6] = R.id.puzzle_one_tv_box_3a;
        puzzleBoxIdMap[3][6] = R.id.puzzle_one_tv_box_4a;
        puzzleBoxIdMap[3][7] = R.id.puzzle_one_tv_box_4b;
        puzzleBoxIdMap[3][8] = R.id.puzzle_one_tv_box_4c;
        puzzleBoxIdMap[3][9] = R.id.puzzle_one_tv_box_4d;
        puzzleBoxIdMap[3][10] = R.id.puzzle_one_tv_box_4e;
        puzzleBoxIdMap[3][11] = R.id.puzzle_one_tv_box_4f;
        puzzleBoxIdMap[3][12] = R.id.puzzle_one_tv_box_4g;
        puzzleBoxIdMap[4][3] = R.id.puzzle_one_tv_box_5a;
        puzzleBoxIdMap[4][6] = R.id.puzzle_one_tv_box_5b;
        puzzleBoxIdMap[4][16] = R.id.puzzle_one_tv_box_5c;
        puzzleBoxIdMap[5][3] = R.id.puzzle_one_tv_box_6a;
        puzzleBoxIdMap[5][6] = R.id.puzzle_one_tv_box_6b;
        puzzleBoxIdMap[5][16] = R.id.puzzle_one_tv_box_6c;
        puzzleBoxIdMap[6][0] = R.id.puzzle_one_tv_box_7a;
        puzzleBoxIdMap[6][3] = R.id.puzzle_one_tv_box_7b;
        puzzleBoxIdMap[6][6] = R.id.puzzle_one_tv_box_7c;
        puzzleBoxIdMap[6][11] = R.id.puzzle_one_tv_box_7d;
        puzzleBoxIdMap[6][16] = R.id.puzzle_one_tv_box_7e;
        puzzleBoxIdMap[7][0] = R.id.puzzle_one_tv_box_8a;
        puzzleBoxIdMap[7][3] = R.id.puzzle_one_tv_box_8b;
        puzzleBoxIdMap[7][6] = R.id.puzzle_one_tv_box_8c;
        puzzleBoxIdMap[7][11] = R.id.puzzle_one_tv_box_8d;
        puzzleBoxIdMap[7][13] = R.id.puzzle_one_tv_box_8e;
        puzzleBoxIdMap[7][16] = R.id.puzzle_one_tv_box_8f;
        puzzleBoxIdMap[8][0] = R.id.puzzle_one_tv_box_9a;
        puzzleBoxIdMap[8][3] = R.id.puzzle_one_tv_box_9b;
        puzzleBoxIdMap[8][5] = R.id.puzzle_one_tv_box_9c;
        puzzleBoxIdMap[8][6] = R.id.puzzle_one_tv_box_9d;
        puzzleBoxIdMap[8][7] = R.id.puzzle_one_tv_box_9e;
        puzzleBoxIdMap[8][8] = R.id.puzzle_one_tv_box_9f;
        puzzleBoxIdMap[8][11] = R.id.puzzle_one_tv_box_9g;
        puzzleBoxIdMap[8][13] = R.id.puzzle_one_tv_box_9h;
        puzzleBoxIdMap[8][16] = R.id.puzzle_one_tv_box_9i;
        puzzleBoxIdMap[9][0] = R.id.puzzle_one_tv_box_10a;
        puzzleBoxIdMap[9][3] = R.id.puzzle_one_tv_box_10b;
        puzzleBoxIdMap[9][6] = R.id.puzzle_one_tv_box_10c;
        puzzleBoxIdMap[9][11] = R.id.puzzle_one_tv_box_10d;
        puzzleBoxIdMap[9][13] = R.id.puzzle_one_tv_box_10e;
        puzzleBoxIdMap[9][16] = R.id.puzzle_one_tv_box_10f;
        puzzleBoxIdMap[10][0] = R.id.puzzle_one_tv_box_11a;
        puzzleBoxIdMap[10][1] = R.id.puzzle_one_tv_box_11b;
        puzzleBoxIdMap[10][2] = R.id.puzzle_one_tv_box_11c;
        puzzleBoxIdMap[10][3] = R.id.puzzle_one_tv_box_11d;
        puzzleBoxIdMap[10][4] = R.id.puzzle_one_tv_box_11e;
        puzzleBoxIdMap[10][5] = R.id.puzzle_one_tv_box_11f;
        puzzleBoxIdMap[10][6] = R.id.puzzle_one_tv_box_11g;
        puzzleBoxIdMap[10][7] = R.id.puzzle_one_tv_box_11h;
        puzzleBoxIdMap[10][11] = R.id.puzzle_one_tv_box_11i;
        puzzleBoxIdMap[10][13] = R.id.puzzle_one_tv_box_11j;
        puzzleBoxIdMap[10][16] = R.id.puzzle_one_tv_box_11k;
        puzzleBoxIdMap[11][0] = R.id.puzzle_one_tv_box_12a;
        puzzleBoxIdMap[11][3] = R.id.puzzle_one_tv_box_12b;
        puzzleBoxIdMap[11][6] = R.id.puzzle_one_tv_box_12c;
        puzzleBoxIdMap[11][9] = R.id.puzzle_one_tv_box_12d;
        puzzleBoxIdMap[11][10] = R.id.puzzle_one_tv_box_12e;
        puzzleBoxIdMap[11][11] = R.id.puzzle_one_tv_box_12f;
        puzzleBoxIdMap[11][12] = R.id.puzzle_one_tv_box_12g;
        puzzleBoxIdMap[11][13] = R.id.puzzle_one_tv_box_12h;
        puzzleBoxIdMap[11][14] = R.id.puzzle_one_tv_box_12i;
        puzzleBoxIdMap[11][15] = R.id.puzzle_one_tv_box_12j;
        puzzleBoxIdMap[11][16] = R.id.puzzle_one_tv_box_12k;
        puzzleBoxIdMap[11][17] = R.id.puzzle_one_tv_box_12l;
        puzzleBoxIdMap[11][18] = R.id.puzzle_one_tv_box_12m;
        puzzleBoxIdMap[12][3] = R.id.puzzle_one_tv_box_13a;
        puzzleBoxIdMap[12][6] = R.id.puzzle_one_tv_box_13b;
        puzzleBoxIdMap[12][11] = R.id.puzzle_one_tv_box_13c;
        puzzleBoxIdMap[12][13] = R.id.puzzle_one_tv_box_13d;
        puzzleBoxIdMap[12][16] = R.id.puzzle_one_tv_box_13e;
        puzzleBoxIdMap[13][3] = R.id.puzzle_one_tv_box_14a;
        puzzleBoxIdMap[13][5] = R.id.puzzle_one_tv_box_14b;
        puzzleBoxIdMap[13][6] = R.id.puzzle_one_tv_box_14c;
        puzzleBoxIdMap[13][7] = R.id.puzzle_one_tv_box_14d;
        puzzleBoxIdMap[13][8] = R.id.puzzle_one_tv_box_14e;
        puzzleBoxIdMap[13][9] = R.id.puzzle_one_tv_box_14f;
        puzzleBoxIdMap[13][10] = R.id.puzzle_one_tv_box_14g;
        puzzleBoxIdMap[13][11] = R.id.puzzle_one_tv_box_14h;
        puzzleBoxIdMap[13][13] = R.id.puzzle_one_tv_box_14i;
        puzzleBoxIdMap[13][16] = R.id.puzzle_one_tv_box_14j;
        puzzleBoxIdMap[14][3] = R.id.puzzle_one_tv_box_15a;
        puzzleBoxIdMap[14][6] = R.id.puzzle_one_tv_box_15b;
        puzzleBoxIdMap[14][8] = R.id.puzzle_one_tv_box_15c;
        puzzleBoxIdMap[14][11] = R.id.puzzle_one_tv_box_15d;
        puzzleBoxIdMap[14][13] = R.id.puzzle_one_tv_box_15e;
        puzzleBoxIdMap[14][16] = R.id.puzzle_one_tv_box_15f;
        puzzleBoxIdMap[15][3] = R.id.puzzle_one_tv_box_16a;
        puzzleBoxIdMap[15][6] = R.id.puzzle_one_tv_box_16f;
        puzzleBoxIdMap[15][8] = R.id.puzzle_one_tv_box_16b;
        puzzleBoxIdMap[15][11] = R.id.puzzle_one_tv_box_16c;
        puzzleBoxIdMap[15][13] = R.id.puzzle_one_tv_box_16d;
        puzzleBoxIdMap[15][16] = R.id.puzzle_one_tv_box_16e;
        puzzleBoxIdMap[16][3] = R.id.puzzle_one_tv_box_17a;
        puzzleBoxIdMap[16][8] = R.id.puzzle_one_tv_box_17b;
        puzzleBoxIdMap[16][11] = R.id.puzzle_one_tv_box_17c;
        puzzleBoxIdMap[16][13] = R.id.puzzle_one_tv_box_17d;
        puzzleBoxIdMap[16][16] = R.id.puzzle_one_tv_box_17e;
        puzzleBoxIdMap[17][3] = R.id.puzzle_one_tv_box_18a;
        puzzleBoxIdMap[17][8] = R.id.puzzle_one_tv_box_18b;
        puzzleBoxIdMap[18][8] = R.id.puzzle_one_tv_box_19a;
        puzzleBoxIdMap[18][9] = R.id.puzzle_one_tv_box_19b;
        puzzleBoxIdMap[18][10] = R.id.puzzle_one_tv_box_19c;
        puzzleBoxIdMap[18][11] = R.id.puzzle_one_tv_box_19d;
        puzzleBoxIdMap[18][12] = R.id.puzzle_one_tv_box_19e;
        puzzleBoxIdMap[19][8] = R.id.puzzle_one_tv_box_20a;
        puzzleBoxIdMap[20][0] = R.id.puzzle_one_tv_box_21a;
        puzzleBoxIdMap[20][1] = R.id.puzzle_one_tv_box_21b;
        puzzleBoxIdMap[20][2] = R.id.puzzle_one_tv_box_21c;
        puzzleBoxIdMap[20][3] = R.id.puzzle_one_tv_box_21d;
        puzzleBoxIdMap[20][4] = R.id.puzzle_one_tv_box_21e;
        puzzleBoxIdMap[20][5] = R.id.puzzle_one_tv_box_21f;
        puzzleBoxIdMap[20][6] = R.id.puzzle_one_tv_box_21g;
        puzzleBoxIdMap[20][7] = R.id.puzzle_one_tv_box_21h;
        puzzleBoxIdMap[20][8] = R.id.puzzle_one_tv_box_21i;
        puzzleBoxIdMap[20][9] = R.id.puzzle_one_tv_box_21j;
        puzzleBoxIdMap[20][10] = R.id.puzzle_one_tv_box_21k;
        puzzleBoxIdMap[20][11] = R.id.puzzle_one_tv_box_21l;
        puzzleBoxIdMap[20][12] = R.id.puzzle_one_tv_box_21m;
        puzzleBoxIdMap[20][13] = R.id.puzzle_one_tv_box_21n;

        String[] question = getResources().getStringArray(R.array.soal_tts_1),
                key = getResources().getStringArray(R.array.kunci_tts_1);

        ArrayList<CrossWord> listWord = new ArrayList<>();
        int i = 0;
        CrossWord crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[0][1], puzzleBoxIdMap[0][2], puzzleBoxIdMap[0][3],
                    puzzleBoxIdMap[0][4], puzzleBoxIdMap[0][5], puzzleBoxIdMap[0][6],
                    puzzleBoxIdMap[0][7], puzzleBoxIdMap[0][8], puzzleBoxIdMap[0][9],
                    puzzleBoxIdMap[0][10], puzzleBoxIdMap[0][11]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[0][6], puzzleBoxIdMap[1][6], puzzleBoxIdMap[2][6],
                    puzzleBoxIdMap[3][6], puzzleBoxIdMap[4][6], puzzleBoxIdMap[5][6],
                    puzzleBoxIdMap[6][6], puzzleBoxIdMap[7][6], puzzleBoxIdMap[8][6],
                    puzzleBoxIdMap[9][6], puzzleBoxIdMap[10][6], puzzleBoxIdMap[11][6],
                    puzzleBoxIdMap[12][6], puzzleBoxIdMap[13][6], puzzleBoxIdMap[14][6],
                    puzzleBoxIdMap[15][6]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[3][6], puzzleBoxIdMap[3][7], puzzleBoxIdMap[3][8],
                    puzzleBoxIdMap[3][9], puzzleBoxIdMap[3][10], puzzleBoxIdMap[3][11],
                    puzzleBoxIdMap[3][12]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[4][3], puzzleBoxIdMap[5][3], puzzleBoxIdMap[6][3],
                    puzzleBoxIdMap[7][3], puzzleBoxIdMap[8][3], puzzleBoxIdMap[9][3],
                    puzzleBoxIdMap[10][3], puzzleBoxIdMap[11][3], puzzleBoxIdMap[12][3],
                    puzzleBoxIdMap[13][3], puzzleBoxIdMap[14][3], puzzleBoxIdMap[15][3],
                    puzzleBoxIdMap[16][3], puzzleBoxIdMap[17][3]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[4][16], puzzleBoxIdMap[5][16], puzzleBoxIdMap[6][16],
                    puzzleBoxIdMap[7][16], puzzleBoxIdMap[8][16], puzzleBoxIdMap[9][16],
                    puzzleBoxIdMap[10][16], puzzleBoxIdMap[11][16], puzzleBoxIdMap[12][16],
                    puzzleBoxIdMap[13][16], puzzleBoxIdMap[14][16], puzzleBoxIdMap[15][16],
                    puzzleBoxIdMap[16][16]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[6][0], puzzleBoxIdMap[7][0], puzzleBoxIdMap[8][0],
                    puzzleBoxIdMap[9][0], puzzleBoxIdMap[10][0], puzzleBoxIdMap[11][0]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[6][11], puzzleBoxIdMap[7][11], puzzleBoxIdMap[8][11],
                    puzzleBoxIdMap[9][11], puzzleBoxIdMap[10][11], puzzleBoxIdMap[11][11],
                    puzzleBoxIdMap[12][11], puzzleBoxIdMap[13][11], puzzleBoxIdMap[14][11],
                    puzzleBoxIdMap[15][11], puzzleBoxIdMap[16][11]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[7][13], puzzleBoxIdMap[8][13], puzzleBoxIdMap[9][13],
                    puzzleBoxIdMap[10][13], puzzleBoxIdMap[11][13], puzzleBoxIdMap[12][13],
                    puzzleBoxIdMap[13][13], puzzleBoxIdMap[14][13], puzzleBoxIdMap[15][13],
                    puzzleBoxIdMap[16][13]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[8][5], puzzleBoxIdMap[8][6], puzzleBoxIdMap[8][7],
                    puzzleBoxIdMap[8][8]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[10][0], puzzleBoxIdMap[10][1], puzzleBoxIdMap[10][2],
                    puzzleBoxIdMap[10][3], puzzleBoxIdMap[10][4], puzzleBoxIdMap[10][5],
                    puzzleBoxIdMap[10][6], puzzleBoxIdMap[10][7]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[11][9], puzzleBoxIdMap[11][10], puzzleBoxIdMap[11][11],
                    puzzleBoxIdMap[11][12], puzzleBoxIdMap[11][13], puzzleBoxIdMap[11][14],
                    puzzleBoxIdMap[11][15], puzzleBoxIdMap[11][16], puzzleBoxIdMap[11][17],
                    puzzleBoxIdMap[11][18]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[13][5], puzzleBoxIdMap[13][6], puzzleBoxIdMap[13][7],
                    puzzleBoxIdMap[13][8], puzzleBoxIdMap[13][9], puzzleBoxIdMap[13][10],
                    puzzleBoxIdMap[13][11]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[13][8], puzzleBoxIdMap[14][8], puzzleBoxIdMap[15][8],
                    puzzleBoxIdMap[16][8], puzzleBoxIdMap[17][8], puzzleBoxIdMap[18][8],
                    puzzleBoxIdMap[19][8], puzzleBoxIdMap[20][8]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[18][8], puzzleBoxIdMap[18][9], puzzleBoxIdMap[18][10],
                    puzzleBoxIdMap[18][11], puzzleBoxIdMap[18][12]
                });
        listWord.add(crossWord);
        crossWord = new CrossWord(question[i], key[i++],
                new int[]{
                    puzzleBoxIdMap[20][0], puzzleBoxIdMap[20][1], puzzleBoxIdMap[20][2],
                    puzzleBoxIdMap[20][3], puzzleBoxIdMap[20][4], puzzleBoxIdMap[20][5],
                    puzzleBoxIdMap[20][6], puzzleBoxIdMap[20][7], puzzleBoxIdMap[20][8],
                    puzzleBoxIdMap[20][9], puzzleBoxIdMap[20][10], puzzleBoxIdMap[20][11],
                    puzzleBoxIdMap[20][12], puzzleBoxIdMap[20][13]
                });
        listWord.add(crossWord);

        helper = new PuzzleHelper(puzzleBoxIdMap, listWord);
    }

    @Override
    public void onClick(View view) {
        deactivateBox();
        activateBox(view.getId());
    }
}
