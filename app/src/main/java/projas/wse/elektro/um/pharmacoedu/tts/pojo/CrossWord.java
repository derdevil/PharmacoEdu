package projas.wse.elektro.um.pharmacoedu.tts.pojo;

import java.util.Arrays;
import java.util.Random;

public class CrossWord {

    private String question;
    private String key;
    private String randomKey;
    private int[] boxId;

    public CrossWord(String question, String key, int[] boxId) {
        this.question = question;
        this.key = key.toUpperCase();
        this.boxId = boxId;
        generateRandomKey();
    }

    private void generateRandomKey() {
        Random rand = new Random();
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char temp[] = new char[14];
        Arrays.fill(temp, '-');

        int length = key.length();
        randomKey = "";
        for (int i=0; i<length; i++) {
            char c = key.charAt(i);
            if (!randomKey.contains(String.valueOf(c)))
                randomKey += c;
        }

        length = word.length();
        while (randomKey.length() < 14) randomKey += word.charAt(rand.nextInt(length));

        randomKey = randomKey.toUpperCase();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRandomKey() {
        return randomKey;
    }

    public void setRandomKey(String randomKey) {
        this.randomKey = randomKey;
    }

    public int[] getBoxId() {
        return boxId;
    }

    public void setBoxId(int[] boxId) {
        this.boxId = boxId;
    }
}
