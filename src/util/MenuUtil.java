package util;
import static util.InputUtil.inputRequiredInt;

public class MenuUtil {
    public static int entryMenu(){
        System.out.println("----------------User Management System----------------\n" +
                "[0].Finish Program!\n" +
                "[1].Register User\n" +
                "[2].Show All Users\n" +
                "[3].Update User\n" +
                "[4].Delete User\n" +
                "[5].Search User\n" +
                "------------------------------------------------");
        return InputUtil.inputRequiredInt("Choose an option: ");
    }
}
