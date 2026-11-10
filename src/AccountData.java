
import java.util.ArrayList;

public class AccountData {

    public ArrayList<Account> setUpData() {
        ArrayList<Account> listAccount = new ArrayList<>();
        listAccount.add(new Account("0123456789", "1234abcd"));
        listAccount.add(new Account("0123456789", "123456ab"));
        listAccount.add(new Account("0123456781", "1234abcd"));
        return listAccount;
    }
}
