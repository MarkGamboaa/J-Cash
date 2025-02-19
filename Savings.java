public class Savings extends accounts {
    private double interest;
    private int limit;

    public Savings(){
        super();
        interest = 0.0625;
        limit = 10000;
    }

    public void checkInterest(){
        int balance = this.getBalance();
        for(int i = 0; i < 10; i++){
            balance += balance * this.interest;
        }
        System.out.println("The balance after 10 years with an interest rate of 6.25% is: " + balance); 
    }

    @Override
    public void withdraw(int amount){
        while(true){
            if(amount > limit){
                System.out.println("You have exceeded the limit of withdrawal.");
                break;
            }
            else if(this.getBalance() - amount < 0){
                System.out.println("Insufficient funds.");
                break;
            }
            else if(amount <= 0){
                System.out.println("Invalid amount.");
                break;
            }
            else{
                this.setBalance(this.getBalance() - amount);
                break; // Exit after successful withdrawal
            }
        }
    }
}
