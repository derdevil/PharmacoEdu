package projas.wse.elektro.um.pharmacoedu.tts.helper;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import projas.wse.elektro.um.pharmacoedu.R;
import projas.wse.elektro.um.pharmacoedu.tts.pojo.CrossWord;

public class PuzzleHelper {

    public final int BG_ACTIVE_BOX = R.drawable.bg_tts_box_active,
            BG_PASSIVE_BOX = R.drawable.bg_tts_box_passive;

    public int puzzleBoxIdMap[][];
    public ArrayList<CrossWord> listWord;

    public PuzzleHelper(int[][] puzzleBoxIdMap, ArrayList<CrossWord> listWord) {
        this.puzzleBoxIdMap = puzzleBoxIdMap;
        this.listWord = listWord;
    }

    public PuzzleHelper(ArrayList<CrossWord> listWord) {
        this.listWord = listWord;
    }

    public CrossWord findObjectById (int boxId) {
        for (CrossWord crossWord : listWord) {
            for (int id : crossWord.getBoxId()) {
                if (id == boxId) return crossWord;
            }
//            int index = Arrays.binarySearch(crossWord.getBoxId(), boxId);
//            if (index >= 0 && index < crossWord.getBoxId().length)
        }
        return null;
    }

    public int findNextNeighbourId(int boxId) {
        CrossWord crossWord = findObjectById(boxId);
        int[] boxes = crossWord.getBoxId();
        for (int i=0; i<boxes.length; i++) {
            if (boxes[i] == boxId) {
                if (i+1 < boxes.length) return boxes[i+1];
                else return boxes[i];
            }
        }

        return boxId;
    }

    public int[] findBoxPositionById (int boxId) {
        for (int i=0; i<puzzleBoxIdMap.length; i++) {
            for (int j=0; j<puzzleBoxIdMap[i].length; j++) {
                if (puzzleBoxIdMap[i][j] == boxId) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public ArrayList<Integer> findBoxNeighbour (int row, int col) {
        int tempRow = row, tempCol = col;
        ArrayList<Integer> neighbours = new ArrayList<>();
        if (puzzleBoxIdMap == null) return neighbours;

        while (--tempRow >= 0 && puzzleBoxIdMap[tempRow][col] != -1)
            neighbours.add(puzzleBoxIdMap[tempRow][col]);
        tempRow = row;
        while (++tempRow < puzzleBoxIdMap.length && puzzleBoxIdMap[tempRow][col] != -1)
            neighbours.add(puzzleBoxIdMap[tempRow][col]);

        //if(!neighbours.isEmpty()) return neighbours;

        while (--tempCol >= 0 && puzzleBoxIdMap[row][tempCol] != -1)
            neighbours.add(puzzleBoxIdMap[row][tempCol]);
        tempCol = col;
        while (++tempCol < puzzleBoxIdMap[row].length && puzzleBoxIdMap[row][tempCol] != -1)
            neighbours.add(puzzleBoxIdMap[row][tempCol]);

        return neighbours;
    }

    public String addTextPadding(String text) {
        return text;
    }

}
