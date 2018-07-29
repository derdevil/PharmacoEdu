package projas.wse.elektro.um.pharmacoedu.materi.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Materi implements Parcelable {

    private String title;
    private String subtitle;
    private String fileSource;

    public Materi() {
    }

    public Materi(String title, String subtitle, String fileSource) {
        this.title = title;
        this.subtitle = subtitle;
        this.fileSource = fileSource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getFileSource() {
        return fileSource;
    }

    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
    }

    protected Materi(Parcel in) {
        title = in.readString();
        subtitle = in.readString();
        fileSource = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(subtitle);
        dest.writeString(fileSource);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Materi> CREATOR = new Parcelable.Creator<Materi>() {
        @Override
        public Materi createFromParcel(Parcel in) {
            return new Materi(in);
        }

        @Override
        public Materi[] newArray(int size) {
            return new Materi[size];
        }
    };
}