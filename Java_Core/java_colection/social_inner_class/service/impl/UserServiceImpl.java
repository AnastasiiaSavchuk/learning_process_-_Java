package java_colection.social_inner_class.service.impl;

import java_colection.social_inner_class.data.DataUser;
import java_colection.social_inner_class.dto.Account;
import java_colection.social_inner_class.dto.User;
import java_colection.social_inner_class.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    DataUser dataUser = new DataUser();
    Map<User, List<Account>> map = dataUser.mapAdd();

    @Override
    public void showAllUser() {
        for (User user : map.keySet()) {
            System.out.println(user);
        }
    }

    @Override
    public void showAllAccount() {
        for (List<Account> value : map.values()) {
            System.out.println(value);
        }
    }
}
