
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {

        LoginManager manager = new LoginManager();
        Validate validate = new Validate();

        displayMenu();
        int choice = validate.checkInputUserChoice("Please choice one option: ");
        if (choice == 3) {
            System.out.println("Exit program...");
            return;
        }
        validate.setLanguage(choice);

        ResourceBundle bundle = validate.getBundle();

         // Loop the login process.
        while (true) {
            
             // Account number entered by the user
            String accountNumber = validate.checkInputAccountNumber();
            if (!manager.checkAccountExist(accountNumber)) {
                System.out.println(bundle.getString("login_error1"));
                System.out.println("------------------------------");
                System.out.println(bundle.getString("login_again"));
            } else {
                
                 // Password entered by the user.
                String password = validate.checkInputPassword();
                if (!manager.checkLogin(accountNumber, password)) {
                    System.out.println(bundle.getString("login_error2"));
                    System.out.println(bundle.getString("login_failed"));
                    System.out.println("------------------------------");
                    System.out.println(bundle.getString("login_again"));
                } else {
                    String captcha = manager.generateCaptcha();
                    System.out.println(bundle.getString("captcha") + captcha);

                    String inputCaptcha = validate.checkInputCaptcha();

                    while (!manager.verifyCaptcha(inputCaptcha, captcha)) {
                        System.out.println(bundle.getString("captcha_error"));
                        inputCaptcha = validate.checkInputCaptcha();
                    }
                    System.out.println(bundle.getString("login_status"));
                   
                }

            }
        }
    }

    public static void displayMenu() {
        System.out.println("--------------Login Program------------------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }
}
