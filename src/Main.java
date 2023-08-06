import service.UserManagementService;
import service.impl.UserManagementServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserManagementService userManagementService = new UserManagementServiceImpl();
        userManagementService.managament();

    }
}