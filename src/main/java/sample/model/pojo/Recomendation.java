package sample.model.pojo;

public class Recomendation {
    private int id;
    private String text;

    public Recomendation() {
    }

    public Recomendation(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Recomendation{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
