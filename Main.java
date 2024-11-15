import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0, choice = 0, choice2 = 0;
        String finalans = "n";
        accounts acc[] = new accounts[5];

        do {
            JCASH();
            Menu();
            choice = input.nextInt();

            switch (choice) {
                case 1: // Account Creation
                    clearScreen();
                    JCASH();
                    if (count == 5) {
                        System.out.println("Maximum number of accounts reached.\n");
                        break;
                    } else {
                        System.out.println("ACCOUNT CREATION");
                        System.out.println("Choose Account Type: ");
                        System.out.println("1. Savings");
                        System.out.println("2. Current");
                        System.out.println("3. Go Back");
                        System.out.print("Enter choice: ");
                        choice2 = input.nextInt();
                        input.nextLine();

                        switch (choice2) {
                            case 1: // Savings Account
                                clearScreen();
                                JCASH();
                                acc[count] = new Savings();
                                createAccount(acc[count], input);
                                count++;
                                break;

                            case 2: // Current Account
                                clearScreen();
                                JCASH();
                                acc[count] = new Current();
                                createAccount(acc[count], input);
                                count++;
                                break;

                            case 3: // Go Back
                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }
                        if (choice2 != 3) {
                            clearScreen();
                            JCASH();
                            System.out.println("Account with Account Number " + acc[count - 1].getAccountNo() + " Created!\n");
                        }
                    }
                    break;

                case 2: // Account Settings
                    clearScreen();
                    JCASH();
                    System.out.println("ACCOUNT SETTINGS");
                    System.out.print("Enter Account Number: \t");
                    int accNo = input.nextInt();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (acc[i].getAccountNo() == accNo) {
                            found = true;
                            System.out.print("Enter Pin: \t\t");
                            if (acc[i].verify(input.nextInt())) {
                                System.out.println("1. Balance Inquiry");
                                System.out.println("2. Account Details");
                                System.out.println("3. Delete Account");
                                System.out.print("Enter choice: ");
                                choice2 = input.nextInt();
                                input.nextLine();

                                switch (choice2) {
                                    case 1:
                                        System.out.println("Balance: PHP " + acc[i].getBalance());
                                        break;

                                    case 2:
                                        acc[i].getDetails();
                                        break;

                                    case 3:
                                        System.out.println("Account Deleted!");
                                        acc[i] = null;
                                        break;

                                    default:
                                        System.out.println("Invalid choice.");
                                }
                            } else {
                                System.out.println("All attempts used. Going back to main menu.");
                            }
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.\n");
                    }
                    break;

                case 3: // Transactions
                    clearScreen();
                    JCASH();
                    System.out.println("TRANSACTIONS");
                    System.out.print("Enter Account Number: \t");
                    accNo = input.nextInt();
                    found = false;

                    for (int i = 0; i < count; i++) {
                        if (acc[i].getAccountNo() == accNo) {
                            found = true;

                            System.out.print("Enter Pin: \t\t");
                            if (acc[i].verify(input.nextInt())) {
                                System.out.println("1. Deposit");
                                System.out.println("2. Withdraw");
                                System.out.println("3. Go Back");
                                System.out.print("Enter choice: ");
                                choice2 = input.nextInt();

                                switch (choice2) {
                                    case 1: // Deposit
                                        System.out.print("Enter Deposit Amount: \t");
                                        int depositAmount = input.nextInt();
                                        acc[i].deposit(depositAmount);
                                        System.out.println("Deposit successful! New balance: PHP " + acc[i].getBalance());
                                        break;

                                    case 2: // Withdraw
                                        System.out.print("Enter Withdrawal Amount: \t");
                                        int withdrawAmount = input.nextInt();
                                        acc[i].withdraw(withdrawAmount);
                                        System.out.println("Withdrawal successful! New balance: PHP " + acc[i].getBalance());
                                        break;

                                    case 3: // Go Back
                                        System.out.println("Returning to main menu...");
                                        break;

                                    default:
                                        System.out.println("Invalid choice.");
                                }
                            } else {
                                System.out.println("All attempts used. Going back to main menu.");
                            }
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4: // Display Users
                    clearScreen();
                    JCASH();
                    if (count == 0) {
                        System.out.println("No accounts to display.\n");
                    } else {
                        System.out.println("DISPLAY USERS");
                        Display(acc, count);
                    }
                    System.out.println("Press Enter to Continue...");
                    input.nextLine();
                    input.nextLine();
                    break;

                case 5: // Exit
                    clearScreen();
                    JCASH();
                    input.nextLine();
                    System.out.print("Are You Sure You Want To Exit? Y|N: ");
                    finalans = input.nextLine();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (finalans.equalsIgnoreCase("N"));
        System.out.println("Have a Nice Day!");
        authors();
    }

    public static void Menu() {
        System.out.println("1. Create Account");
        System.out.println("2. Account Settings");
        System.out.println("3. Transactions");
        System.out.println("4. Display Users");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    public static void JCASH() {
        System.out.println("------------------------------");
        System.out.println("\tJ-CASH BANKING");
        System.out.println("------------------------------");
    }

    public static void authors() {
        System.out.println("Thank you for using J-CASH Banking.");
        System.out.println("Marlo Veluz");
        System.out.println("Dominic Madlangbayan");
        System.out.println("Mark Gamboa");
        System.out.println("Ronn Rosarito");
    }

    public static void Display(accounts[] acc, int count) {
        for (int i = 0; i < count; i++) {
            if (acc[i] != null) {
                System.out.println("Account Number: " + acc[i].getAccountNo());
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void createAccount(accounts account, Scanner input) {
        account.setAccountNo();
        System.out.println("Account Number: \t" + account.getAccountNo());
        System.out.print("Enter Year of Birth: \t");
        account.setYoB(input.nextInt());
        input.nextLine();
        System.out.print("Enter Name: \t\t");
        account.setName(input.nextLine());
        System.out.print("Initial Deposit (PHP): \t");
        account.setInitialDepo(input.nextInt());
        System.out.print("Set Pin: \t\t");
        account.setPin(input.nextInt());
    }
}
