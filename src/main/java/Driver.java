import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
    public static void main(String[] args) throws IOException{
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        String input = "initial";
        int status;
        usage();
        Account a = new Account();

        int num_calls_since_last_print = 0;
        while(!input.equals("q")) {
            // Print reminder of the usage very 3 method invocations
            if (num_calls_since_last_print >= 3) {
                usage();
                num_calls_since_last_print = 0;
            }

            System.out.print("> ");
            input = scan.readLine();
            num_calls_since_last_print++;
            switch (input) {
                case "0": { // open
                    System.out.println("    Account class - Open Method\n");

                    System.out.println("Enter initial balance: ");
                    int balance = Integer.parseInt(scan.readLine());
                    System.out.println("Enter pin number: ");
                    int pin = Integer.parseInt(scan.readLine());
                    System.out.println("Enter account number: ");
                    int account_number = Integer.parseInt(scan.readLine());

                    status = a.open(balance, pin, account_number);
                    System.out.println("    The value returned by the method is: " + status + "\n");
                    break;
                }
                case "1": { // deposit
                    System.out.println("    Account class - Deposit Method\n");

                    System.out.println("Enter deposit amount: ");
                    int deposit = Integer.parseInt(scan.readLine());

                    status = a.deposit(deposit);
                    System.out.println("    The value returned by the method is: " + status + "\n");
                    break;
                }
                case "2": { // withdraw
                    System.out.println("    Account class - Withdraw Method\n");

                    System.out.println("Enter withdraw amount: ");
                    int withdraw = Integer.parseInt(scan.readLine());

                    status = a.withdraw(withdraw);
                    System.out.println("    The value returned by the method is: " + status + "\n");
                    break;
                }
                case "3": { // balance
                    System.out.println("    Account class - Balance Method\n");

                    status = a.balance();
                    System.out.println("    The value returned by the method is: " + status + "\n");
                    System.out.println("\n\n    OUTPUT: " + status);
                    break;
                }
                case "4": { // lock
                    System.out.println("    Account class - Lock Method\n");

                    System.out.println("Enter lock number: ");
                    int lock_number = Integer.parseInt(scan.readLine());
                    status = a.lock(lock_number);

                    System.out.println("    The value returned by the method is: " + status + "\n");;
                    break;

                }
                case "5": { // unlock
                    System.out.println("    Account class - Unlock Method\n");

                    System.out.println("Enter lock number: ");
                    int lock_number = Integer.parseInt(scan.readLine());
                    status = a.unlock(lock_number);

                    System.out.println("    The value returned by the method is: " + status + "\n");
                    break;
                }
                case "6": { // login
                    System.out.println("    Account class - Login Method\n");

                    System.out.println("Enter account number: ");
                    int account_number = Integer.parseInt(scan.readLine());
                    status = a.login(account_number);

                    System.out.println("    The value returned by the method is: " + status + "\n");
                    break;

                }
                case "7": { // pin
                    System.out.println("    Account class - Pin Method\n");

                    System.out.println("Enter pin number: ");
                    int pin_number = Integer.parseInt(scan.readLine());
                    status = a.pin(pin_number);

                    System.out.println("    The value returned by the method is: " + status + "\n");
                    break;
                }
                case "8": { // logout
                    System.out.println("    Account class - Logout Method\n");

                    status = a.balance();
                    System.out.println("    The value returned by the method is: " + status + "\n");;
                    break;
                }
                case "a": { // show_balance
                    System.out.println("    Account class - show_balance() testing-oriented method\n");

                    System.out.println("        balance = " + a.show_balance());
                    break;
                }
                case "b": { // show_state
                    System.out.println("    Account class - show_state() testing-oriented method\n");

                    System.out.println("        " + a.show_state() + " state");
                    break;
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
             "  DRIVER for the Account Class\n" +
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
                     "         a. Show balance\n" +
                     "         b. Show state\n" +
                     "         c. ????\n" +
                     "\n" +
                     "         q. Quit Account driver"
        );

    }
}
