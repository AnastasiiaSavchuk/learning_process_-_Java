package home_11.inner_class;

import java_colection.social_inner_class.service.impl.UserServiceImpl;

public class Main {

    private static UserServiceImpl userService = new UserServiceImpl();

    public static void main(String[] args) {

        System.out.println("All user's in Bank : ");
        userService.showAllUser();

        System.out.println("All Bank's account :");
        userService.showAllAccount();
    }
}
