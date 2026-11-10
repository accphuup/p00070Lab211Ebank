
import java.util.ResourceBundle;
import java.util.Scanner;

public class Validate {

    private static final Scanner sc = new Scanner(System.in);

    private ResourceBundle bundle;

    public int checkInputUserChoice(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String input = sc.nextLine().trim();
                int number = Integer.parseInt(input);
                if (number >= 1 && number <= 3) {
                    return number;
                } else {
                    System.out.println("Input must be in range 1-3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid format!Please enter again!");
            }
        }
    }

    public void setLanguage(int choice) {
        if (choice == 1) {
            bundle = ResourceBundle.getBundle("Vi");
        } else {
            bundle = ResourceBundle.getBundle("En");
        }
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public String checkInputAccountNumber() {
        String accountNumber = bundle.getString("account_number");
        String messageError = bundle.getString("account_error");

        while (true) {
            System.out.print(accountNumber);
            String input = sc.nextLine().trim();

            if (input.length() != 10) {
                System.out.println(messageError);
            } else {
                boolean flag = true;

                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if (c < '0' || c > '9') {
                        System.out.println(messageError);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return input;
                } else {
                    System.out.println(messageError);
                }
            }

        }
    }

    public String checkInputPassword() {
        String password = bundle.getString("password");
        String messageError = bundle.getString("password_error");

        while (true) {
            System.out.print(password);
            String input = sc.nextLine().trim();
            if (input.length() >= 8 && input.length() <= 31) {
                int countNumber = 0;
                int countCharacter = 0;
                boolean flag = true;

                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if (c >= '0' && c <= '9') {
                        countNumber++;
                    } else {
                        if ((c < 'A' && c > 'Z') || (c < 'a' && c > 'z')) {
                            System.out.println(messageError);
                            flag = false;
                            break;
                        }
                        countCharacter++;
                    }
                }
                if (flag && countCharacter > 0 && countNumber > 0) {
                    return input;
                } else {
                    System.out.println(messageError);
                }
            } else {
                System.out.println(messageError);
            }
        }
    }

    public String checkInputCaptcha() {
        String captcha = bundle.getString("captcha");
        String messageError = bundle.getString("captcha_error");

        while (true) {
            System.out.print(captcha);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(messageError);
            } else {
                return input;
            }
        }
    }

}
