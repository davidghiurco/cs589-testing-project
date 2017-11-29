//***********************************************
//********** ACCOUNT CLASS DRIVER ***************
//***********************************************

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
            // Print reminder of the usage every 20 method invocations
            if (num_calls_since_last_print >= 20) {
                usage();
                num_calls_since_last_print = 0;
            }

            System.out.print("> ");
            input = scan.readLine();
            num_calls_since_last_print++;
            switch (input) {
                case "0": { // open
                    System.out.println("    Account class - Open Method");

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
                    System.out.println("    Account class - Deposit Method");

                    System.out.println("Enter deposit amount: ");
                    int deposit = Integer.parseInt(scan.readLine());

                    status = a.deposit(deposit);
                    System.out.println("    The value returned by the method is: " + status + "\n");
                    break;
                }
                case "2": { // withdraw
                    System.out.println("    Account class - Withdraw Method");

                    System.out.println("Enter withdraw amount: ");
                    int withdraw = Integer.parseInt(scan.readLine());

                    status = a.withdraw(withdraw);
                    System.out.println("    The value returned by the method is: " + status + "\n");
                    break;
                }
                case "3": { // balance
                    System.out.println("    Account class - Balance Method");

                    status = a.balance();
                    System.out.println("    The value returned by the method is: " + status + "\n");
                    System.out.println("\n\n    OUTPUT: " + status);
                    break;
                }
                case "4": { // lock
                    System.out.println("    Account class - Lock Method");

                    System.out.println("Enter lock number: ");
                    int lock_number = Integer.parseInt(scan.readLine());
                    status = a.lock(lock_number);

                    System.out.println("    The value returned by the method is: " + status + "\n");;
                    break;

                }
                case "5": { // unlock
                    System.out.println("    Account class - Unlock Method");

                    System.out.println("Enter lock number: ");
                    int lock_number = Integer.parseInt(scan.readLine());
                    status = a.unlock(lock_number);

                    System.out.println("    The value returned by the method is: " + status + "\n");
                    break;
                }
                case "6": { // login
                    System.out.println("    Account class - Login Method");

                    System.out.println("Enter account number: ");
                    int account_number = Integer.parseInt(scan.readLine());
                    status = a.login(account_number);

                    System.out.println("    The value returned by the method is: " + status + "\n");
                    break;

                }
                case "7": { // pin
                    System.out.println("    Account class - Pin Method");

                    System.out.println("Enter pin number: ");
                    int pin_number = Integer.parseInt(scan.readLine());
                    status = a.pin(pin_number);

                    System.out.println("    The value returned by the method is: " + status + "\n");
                    break;
                }
                case "8": { // logout
                    System.out.println("    Account class - Logout Method");

                    status = a.logout();
                    System.out.println("    The value returned by the method is: " + status + "\n");;
                    break;
                }
                case "a": { // show_balance
                    System.out.println("    Account class - show_balance() testing-oriented method");

                    System.out.println("        balance = " + a.show_balance());
                    break;
                }
                case "b": { // show_state
                    System.out.println("    Account class - show_state() testing-oriented method");

                    System.out.println("        " + a.show_state() + " state");
                    break;
                }
                case "c": { // show_num_pin_tries
                    System.out.println("    Account class - show_num_pin_tries() testing-oriented method");

                    System.out.println("    Number of pin attempts: " + a.show_num_pin_tries());
                    break;
                }
                case "d": { // show_locked_flag
                    System.out.println("    Account class - show_locked_flag() testing-oriented method\n");

                    System.out.println("    Flag = " + a.show_locked_flag());
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
                     "         a. show_balance\n" +
                     "         b. show state\n" +
                     "         c. show_num_pin_tries\n" +
                     "         d. show_locked_flag\n" +
                     "\n" +
                     "         q. Quit Account driver"
        );

    }
}
