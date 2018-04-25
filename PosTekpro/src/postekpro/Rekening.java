package postekpro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rekening {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("isi")
    @Expose
    private Isi isi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Isi getIsi() {
        return isi;
    }

    public void setIsi(Isi isi) {
        this.isi = isi;
    }

}
