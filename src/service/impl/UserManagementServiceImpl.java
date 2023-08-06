package service.impl;

import enums.Exceptions;
import exception.EmptyListException;
import exception.InvalidOptionException;
import exception.UserNotFoundException;
import exception.WrongFormatException;
import service.UserManagementService;
import service.UserService;

import java.util.InputMismatchException;

import static util.MenuUtil.entryMenu;
import static service.impl.UserServiceImpl.getService;

public class UserManagementServiceImpl implements UserManagementService {
    @Override
    public void managament() {
        while (true) {
            try {
                int option = entryMenu();
                UserService userService =getService();
                switch (option) {
                    case 0:
                        System.exit(-1);
                        break;
                    case 1:
                        userService.register();
                        break;
                    case 2:
                        userService.show();
                        break;
                    case 3:
                        userService.update();
                        break;
                    case 4:
                        userService.delete();
                        break;
                    case 5:
                        userService.search();
                        break;
                    default:
                        throw new InvalidOptionException(Exceptions.INVALID_OPTION);
                }
            }catch (InvalidOptionException | UserNotFoundException | WrongFormatException | EmptyListException |
                    InputMismatchException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
