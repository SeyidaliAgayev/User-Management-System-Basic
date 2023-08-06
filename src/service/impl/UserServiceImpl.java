package service.impl;

import enums.Exceptions;
import enums.StatusEnum;
import exception.EmptyListException;
import exception.UserNotFoundException;
import exception.WrongFormatException;
import globalData.GlobalData;
import model.User;
import service.UserService;
import util.InputUtil;


import static helper.UserServiceHelper.*;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl alma;

    private UserServiceImpl() {
    }

    public static UserServiceImpl getService() {
        return alma == null ? alma = new UserServiceImpl() : alma ;
    }

    @Override
    public boolean register() {
        int count = InputUtil.inputRequiredInt("How many user will be registered: ");
        if (GlobalData.users == null) {
            GlobalData.users = new User[count];
            for (int i = 0; i < GlobalData.users.length; i++) {
                registerHelper();
            }
            System.out.println(StatusEnum.REGISTER_SUCCESSFULLY);
        } else {
            User[] tempUser = GlobalData.users;
            GlobalData.users = new User[GlobalData.users.length + count];
            for (int i = 0; i < GlobalData.users.length; i++) {
                if (i < tempUser.length) {
                    GlobalData.users[i] = tempUser[i];
                } else {
                    registerHelper();
                }
            }
            System.out.println(StatusEnum.REGISTER_SUCCESSFULLY);
        }
        int nullCount = 0;
        for (User user : GlobalData.users) {
            if (user == null) {
                nullCount++;
            }
        }
        User[] users = GlobalData.users;
        GlobalData.users = new User[GlobalData.users.length - nullCount];
        for (int i = 0; i < GlobalData.users.length; i++) {
            GlobalData.users[i] = users[i];
        }
        return true;
    }

        @Override
        public void show () {
        if (GlobalData.users == null || GlobalData.users.length == 0)
            throw new EmptyListException(Exceptions.EMPTY_LIST_EXCEPTION);

            System.out.println("----------------------User List----------------------");
            for (User user: GlobalData.users) {
                System.out.println(user);
            }
        }

        @Override
        public boolean update () {
            if (GlobalData.users == null || GlobalData.users.length == 0)
                throw new EmptyListException(Exceptions.EMPTY_LIST_EXCEPTION);
            long id = InputUtil.inputRequiredLong("Which user do you want to update: ");
            boolean isTrue = false;

            for (int i = 0; i < GlobalData.users.length; i++) {
                if (GlobalData.users[i].getId() == id) {
                    String parameter = InputUtil.inputRequiredString("Which parameter of user do you want to update: ");
                    String[] parameterString = parameter.toLowerCase().split(",");
                    for (String str: parameterString) {
                        switch (str) {
                            case "name":
                                GlobalData.users[i].setName(InputUtil.inputRequiredString("Enter the changed name: "));
                                isTrue = true;
                                break;
                            case "surname":
                                GlobalData.users[i].setSurname(InputUtil.inputRequiredString("Enter the changed surname: "));
                                isTrue = true;
                                break;
                            default:
                                throw new WrongFormatException(Exceptions.WRONG_FORMAT);
                        }
                    }
                    if (isTrue) {
                        GlobalData.users[i].setUpdateDate(nowDate());
                        System.out.println(StatusEnum.UPDATE_SUCCESSFULLY);
                    }
                } else {
                    throw new UserNotFoundException(Exceptions.USER_NOT_FOUND);
                }
            }
            return true;
    }

        @Override
        public boolean delete () {
            if (GlobalData.users == null || GlobalData.users.length == 0)
                throw new EmptyListException(Exceptions.EMPTY_LIST_EXCEPTION);
            long id = InputUtil.inputRequiredLong("Which user do you want to delete: ");

            for (int i = 0; i < GlobalData.users.length; i++) {
                if (GlobalData.users[i].getId() == id) {
                    User[] users = GlobalData.users;
                    GlobalData.users = new User[GlobalData.users.length -1];

                    int k = 0;
                    for (User user:GlobalData.users) {
                        if (user.getId() == id) {
                            continue;
                        }
                        GlobalData.users[k] = user;
                        k++;
                    }
                    System.out.println(StatusEnum.DELETE_SUCCESSFULLY);
                    break;
                }
            }
            return false;
        }
        @Override
        public void search () {

        UserService userService = getService();
            if (GlobalData.users == null || GlobalData.users.length == 0)
                throw new EmptyListException(Exceptions.EMPTY_LIST_EXCEPTION);
            else{
            String key = InputUtil.inputRequiredString("Search user by (name/surname): ");
                for (User user: GlobalData.users) {
                    if (user.getName().contains(key) || user.getSurname().contains(key)) {
                        System.out.println(user);
                    } else {
                        throw new UserNotFoundException(Exceptions.USER_NOT_FOUND);
                    }
                }
            }
        }
    }

