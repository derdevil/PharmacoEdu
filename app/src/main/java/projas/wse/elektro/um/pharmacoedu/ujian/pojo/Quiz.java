package projas.wse.elektro.um.pharmacoedu.ujian.pojo;

public class Quiz {

    private String soal, jwbnA, jwbnB, jwbnC, jwbnD, jwbnE,
            kunci, pilihan;
    private int jmlMenjawab;

    public Quiz() {
    }

    public Quiz(String soal, String jwbnA, String jwbnB, String jwbnC, String jwbnD, String jwbnE, String kunci) {
        this.soal = soal;
        this.jwbnA = jwbnA;
        this.jwbnB = jwbnB;
        this.jwbnC = jwbnC;
        this.jwbnD = jwbnD;
        this.jwbnE = jwbnE;
        this.kunci = kunci;
        pilihan = "-";
        jmlMenjawab = 0;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getJwbnA() {
        return jwbnA;
    }

    public void setJwbnA(String jwbnA) {
        this.jwbnA = jwbnA;
    }

    public String getJwbnB() {
        return jwbnB;
    }

    public void setJwbnB(String jwbnB) {
        this.jwbnB = jwbnB;
    }

    public String getJwbnC() {
        return jwbnC;
    }

    public void setJwbnC(String jwbnC) {
        this.jwbnC = jwbnC;
    }

    public String getJwbnD() {
        return jwbnD;
    }

    public void setJwbnD(String jwbnD) {
        this.jwbnD = jwbnD;
    }

    public String getJwbnE() {
        return jwbnE;
    }

    public void setJwbnE(String jwbnE) {
        this.jwbnE = jwbnE;
    }

    public String getKunci() {
        return kunci;
    }

    public void setKunci(String kunci) {
        this.kunci = kunci;
    }

    public String getPilihan() {
        return pilihan;
    }

    public void setPilihan(String pilihan) {
        this.pilihan = pilihan;
    }

    public void setJmlMenjawab(int jmlMenjawab) {
        this.jmlMenjawab = jmlMenjawab;
    }

    public void increaseJmlMenjawab() {
        jmlMenjawab++;
    }

    public void decreaseJmlMenjawab() {
        jmlMenjawab--;
    }

    public boolean isLimitReached() {
        return jmlMenjawab >= 2;
    }
}
