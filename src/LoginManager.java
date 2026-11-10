
import java.util.ArrayList;
import java.util.Random;

public class LoginManager {

    private final ArrayList<Account> listAccounts = new AccountData().setUpData();

    public boolean checkAccountExist(String accountNumber) {
        for (Account account : listAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLogin(String accountNumber, String password) {
        for (Account account : listAccounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String generateCaptcha() {
        Random rd = new Random();
        String charCaptcha = "ABCDEFGHIKL123456789";
        String result = "";
        for (int i = 0; i < 5; i++) {
            int index = rd.nextInt(charCaptcha.length());
            result += charCaptcha.charAt(index);
        }
        return result;
    }

    public boolean verifyCaptcha(String captchaInput, String generateCaptcha) {
        if (generateCaptcha.contains(captchaInput)) {
            return true;
        }
        return false;
    }
}
