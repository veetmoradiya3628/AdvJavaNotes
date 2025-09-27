package ooad;

abstract class User {
    int userId;

    public User(int userId) {
        this.userId = userId;
    }

    abstract boolean isAdmin();

}

class Admin extends User {

    public Admin(int userId) {
        super(userId);
    }

    @Override
    boolean isAdmin() {
        return true;
    }
}

class RegularUser extends User {
    private final boolean is_admin;
    public RegularUser(int userId) {
        super(userId);
        this.is_admin = false;
    }

    @Override
    boolean isAdmin() {
        return is_admin;
    }
}

public class PolymorphismTest {
    public static void main(String[] args) {
        User u1 = new Admin(1);
        System.out.println(u1.isAdmin());
        User u2 = new RegularUser(2);
        System.out.println(u2.isAdmin());

        System.out.println(u1.getClass());
        System.out.println(u2.getClass());

        System.out.println(u1.getClass().hashCode());
        System.out.println(u2.getClass().hashCode());

//        clone() methods for deep and shallow cloning
    }
}
