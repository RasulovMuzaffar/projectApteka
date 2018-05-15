package sample.model.pojo;

public class Manufacturer {
    private int id;
    private String state;
    private String name;

    public Manufacturer() {
    }

    public Manufacturer(int id, String state, String name) {
        this.id = id;
        this.state = state;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
