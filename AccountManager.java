package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountManager {
    private List accounts;

    public AccountManager() {
        accounts = new ArrayList();
    }

    public void addAccount(account acc) {
        accounts.add(acc);
    }

    public account findAccount(String username) {
        for (Iterator it = accounts.iterator(); it.hasNext();) {
            account acc = (account) it.next();
            if (acc.getUserName().equals(username)) {
                return acc;
            }
        }
        return null;
    }
}
