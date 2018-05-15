package sample.model.pojo;

public class Suppler {
    private int id;
    private String name;
    private String adress;
    private String phone;
    private String email;

    public Suppler() {
    }

    public Suppler(int id, String name, String adress, String phone, String email) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Suppler{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
