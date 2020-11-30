package java_colection.social_inner_class.data;

import java_colection.social_inner_class.dto.Account;
import java_colection.social_inner_class.dto.CreditAccount;
import java_colection.social_inner_class.dto.DebitAccount;
import java_colection.social_inner_class.dto.User;

import java.util.*;

public class DataUser {

    public Map<User, List<Account>> map = new TreeMap<>();

    public Map<User, List<Account>> mapAdd() {

        User user1 = new User("olia");
        List<Account> account1 = new ArrayList<>(Arrays.asList(new CreditAccount(1, 68546.2), new DebitAccount("1", 54789.6)));
        User user2 = new User("kolia");
        List<Account> account2 = new ArrayList<>(Arrays.asList(new CreditAccount(2, 1254789.35), new DebitAccount("2", 12598745.68)));
        User user3 = new User("sasha");
        List<Account> account3 = new ArrayList<>(Arrays.asList(new CreditAccount(3, 25446.2), new DebitAccount("3", 58789.6)));
        User user4 = new User("potap");
        List<Account> account4 = new ArrayList<>(Arrays.asList(new CreditAccount(4, 96546.2), new DebitAccount("4", 58949.6)));
        map.put(user1, account1);
        map.put(user2, account2);
        map.put(user3, account3);
        map.put(user4, account4);

        return map;
    }
}
