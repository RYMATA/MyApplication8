package pasha.samsung.myapplication;

/**
 * Created by Samsung on 27.02.2019.
 */

public class User {
    protected int id;

    protected String name;

    protected String username;

    protected String email;



    protected String phone;

    protected String website;




    public User(int userId, String userName, String userEmail) {
    }

    public User(int id, String name, String username, String email, String phone, String website) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;

        this.phone = phone;
        this.website = website;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +

                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }








}
