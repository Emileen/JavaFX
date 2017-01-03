package sample;

/**
 * Created by emileenmarianayagam on 1/3/17.
 */
public class Contact {
    public String name;
    public String phone;
    public String email;

    public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
    }

    @Override
    public String toString(){
        return String.format ("%s %s %s\n", name, phone, email);

    }




}
