import java.util.Random;
import java.util.Scanner;

public abstract class accounts {
    private int accountNo;
    private String name;
    private int pin;
    private int YoB;
    private int balance;

    Scanner input = new Scanner(System.in);

    public accounts() {
        name = " ";
        pin = 0;
        accountNo = 0;
        YoB = 0;
    }

    public void setAccountNo() {
        Random accountNo = new Random();
        this.accountNo = accountNo.nextInt(900) + 100;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPin(int pin) {
        while (true) {
            if (pin <= 999 || pin >= 10000) {
                System.out.println("PIN must contain 4 digits.");
                System.out.print("Enter PIN: ");
                pin = input.nextInt();
            } else {
                this.pin = pin;
                break;
            }
        }
    }

    public void setYoB(int yob) {
        while (true) {
            if (2024 - yob <= 17) {
                System.out.println("You must be 18 years old or older to create an account.");
                System.out.print("Enter Year of Birth: ");
                yob = input.nextInt();
            } else {
                this.YoB = yob;
                break;
            }
        }
    }

    public void setInitialDepo(int initialDepo) {
        while (true) {
            if (initialDepo <= 2999) {
                System.out.println("Initial deposit must be at least PHP 3000.");
                System.out.print("Enter Initial Deposit: \t");
                initialDepo = input.nextInt();
            } else {
                this.balance = initialDepo;
                break;
            }
        }
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountNo() {
        return this.accountNo;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    public void getDetails() {
        System.out.println("Name: \t\t\t" + getName());
        System.out.println("Account Number: \t" + getAccountNo());
        System.out.println("Balance: \t\tPHP " + getBalance());
    }

    public boolean verify(int enteredPin) {
        int attempt = 3;
        while (attempt > 0) {
            if (enteredPin != this.pin) {
                attempt--;
                System.out.println("Incorrect Pin.");
                if (attempt != 0) {
                    System.out.print("Enter Pin Again: ");
                    enteredPin = input.nextInt();
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than PHP 0.");
        } else {
            this.balance += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than PHP 0.");
        } else if (amount > this.balance) {
            System.out.println("Insufficient funds.");
        } else {
            this.balance -= amount;
        }
    }
}
