package helper;

import enums.Exceptions;
import exception.UserNotFoundException;
import exception.WrongFormatException;
import globalData.GlobalData;
import model.User;
import util.InputUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;


import static util.InputUtil.*;

public class UserServiceHelper {
    static int userCount = 0;
    private static Long id = 0L;
    public static User fillUser() {
        try {
            String name = inputRequiredString("Enter the name: ");
            String surname = inputRequiredString("Enter the surname: ");
            LocalDate birthday = birthdayHelperService();
            LocalDateTime registerDate = nowDate();
            LocalDateTime updateDate = null;
            return new User(++id, name, surname, birthday,registerDate,null);
        } catch (WrongFormatException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    public static User findById(int id) {
        User user = new User();
        if (GlobalData.users == null) {
            System.out.println("-----------------------\n" +
                    "User doesn't exist!\n" +
                    "-----------------------");
        } else {
            System.out.println("Note: If you don't want to change selected field just press enter!");
            for (int i = 0; i < GlobalData.users.length; i++) {
                if (GlobalData.users[i].getId() == id) {
                    user = GlobalData.users[i];
                    break;
                } else {
                    throw new UserNotFoundException(Exceptions.USER_NOT_FOUND);
                }
            }
        }
        return user;
    }

    public static LocalDate birthdayHelperService() {
        try {
            String str1 = inputRequiredString("Enter the Birth Date(day-month-years): ");
            String[] str2 = str1.split("-");
            int day = Integer.parseInt(str2[0]);
            int month = Integer.parseInt(str2[1]);
            int years = Integer.parseInt(str2[2]);
            return LocalDate.of(day, month, years);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public static void registerHelper() {
        User user = fillUser();
        if (user != null) {
            GlobalData.users[userCount] = user;
            userCount++;
        }
    }
    public static LocalDateTime nowDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.withNano(0);
    }
}

