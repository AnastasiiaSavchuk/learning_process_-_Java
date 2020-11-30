package java_colection.social_inner_class.service;

import java_colection.social_inner_class.dto.Account;

public interface UserService<T extends Account> {

    void showAllUser();

    void showAllAccount();
}
