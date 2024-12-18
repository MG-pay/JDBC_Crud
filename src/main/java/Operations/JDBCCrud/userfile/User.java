package Operations.JDBCCrud.userfile;

public class User {
    private String name;
    private String email;
    private String gender;
    private String city;


    public User() {

    }

    public User(String name, String gender, String email, String city) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.city = city;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String city() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String gender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
