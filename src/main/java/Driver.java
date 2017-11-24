import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String input = "initial";
        int status = 0;
        usage();
        Account a = new Account();
        while(!input.equals("q")) {

            input = scan.readLine();
            switch (input) {
                case "0": { // open
                    System.out.println("    Account class");
                    System.out.println("    Open Method\n\n");

                    System.out.println("Enter initial balance: ");
                    int balance = Integer.parseInt(scan.readLine());
                    System.out.println("Enter pin number: ");
                    int pin = Integer.parseInt(scan.readLine());
                    System.out.println("Enter account number: ");
                    int account_number = Integer.parseInt(scan.readLine());

                    status = a.open(balance, pin, account_number);
                    System.out.println("    The value returned by the method is: " + status);
                    break;
                }
                case "1": {

                }
                case "2": {

                }
                case "3": {

                }
                case "4": {

                }
                case "5": {

                }
                case "6": {

                }
                case "7": {

                }
                case "8": {

                }
                case "a": {

                }
                case "b": {

                }
                case "q": { // quit
                    break;
                }
                default: {
                    System.out.println("Invalid operation: " + input);
                    break;
                }
            }
        }
    }

    private static void usage() {
        System.out.println(
             "            DRIVER for the Account Class\n" +
                     "\n" +
                     "         0. open\n" +
                     "         1. deposit\n" +
                     "         2. withdraw\n" +
                     "         3. balance\n" +
                     "         4. lock\n" +
                     "         5. unlock\n" +
                     "         6. login\n" +
                     "         7. pin\n" +
                     "         8. logout\n" +
                     "\n" +
                     "         Testing-related methods\n" +
                     "         a. Show_balance\n" +
                     "         b. Show state\n" +
                     "         c. ????\n" +
                     "\n" +
                     "         q. Quit Account driver"
        );

    }
}
