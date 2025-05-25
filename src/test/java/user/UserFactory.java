package user;

import utils.PropertyReader;

public class UserFactory {

    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemooo.user"),
                PropertyReader.getProperty("saucedemooo.password"));
    }

    public static User withlockedUserPermission() {
        return new User(PropertyReader.getProperty("saucedemooo.locked.user=locked_out_user"),
                PropertyReader.getProperty("saucedemooo.password"));
    }

    public static User withHRPermission() {
        return new User(PropertyReader.getProperty("hr-link.email.as.employeeHR"),
                PropertyReader.getProperty("hr-link.password.as.employeeHR"));
    }
}
