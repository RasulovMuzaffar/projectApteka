package sample.model.pojo;

import java.io.Serializable;

public class Medicine implements Serializable{
    private int id;
    private String nameRu;
    private String nameEn;
    private String barCode;
    private int idClass;
    private int idRecommend;

    public Medicine() {
    }

    public Medicine(int id, String nameRu, String nameEn, String barCode, int idClass, int idRecommend) {
        this.id = id;
        this.nameRu = nameRu;
        this.nameEn = nameEn;
        this.barCode = barCode;
        this.idClass = idClass;
        this.idRecommend = idRecommend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public int getIdRecommend() {
        return idRecommend;
    }

    public void setIdRecommend(int idRecommend) {
        this.idRecommend = idRecommend;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", nameRu='" + nameRu + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", barCode='" + barCode + '\'' +
                ", idClass=" + idClass +
                ", idRecommend=" + idRecommend +
                '}';
    }
}
