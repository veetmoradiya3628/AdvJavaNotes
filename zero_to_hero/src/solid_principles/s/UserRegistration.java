package solid_principles.s;

public class UserRegistration {
    public static boolean registerUser(String username, String password) {
        return (UserValidator.validateUsername(username) && UserValidator.validatePassword(password));
    }
}
