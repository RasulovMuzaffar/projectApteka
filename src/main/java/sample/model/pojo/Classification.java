package sample.model.pojo;

public class Classification {
    private int id;
    private String clas;

    public Classification() {
    }

    public Classification(int id, String clas) {
        this.id = id;
        this.clas = clas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "id=" + id +
                ", clas='" + clas + '\'' +
                '}';
    }
}
