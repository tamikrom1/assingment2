import java.util.*;


public class Main {
    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> history = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<BankAccount> accountRequest = new LinkedList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        BankAccount[] fixedAccounts = new BankAccount[3];

        fixedAccounts[0] = new BankAccount(1,"John", 20000);
        fixedAccounts[1] = new BankAccount(2,"Smith", 100000);
        fixedAccounts[2] = new BankAccount(3,"James", 50000);

        System.out.println("Fixed accounts: ");
        for(BankAccount acc:fixedAccounts){
            System.out.println(acc);
        }

        accounts.addAll(Arrays.asList(fixedAccounts));
        System.out.println("======================================");
        while(true){
            System.out.println("1 Enter Bank");
            System.out.println("2 Enter ATM");
            System.out.println("3 Admin area");
            System.out.println("4 exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1: bankMenu();break;
                case 2: atmMenu();break;
                case 3: adminMenu();break;
                case 4: return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void bankMenu(){
        while(true) {
            System.out.println("\n===========Bank Menu============");
            System.out.println("1 Request account");
            System.out.println("2 Deposit");
            System.out.println("3 Withdraw");
            System.out.println("4 Back");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    requestAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void atmMenu(){
        while (true) {
            System.out.println("\n======ATM MENU=========");
            System.out.println("1 Balance");
            System.out.println("2 Withdraw");
            System.out.println("3 Back");

            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Username");
            String name = scanner.nextLine();

            BankAccount acc = findAccounts(name);
            if (acc == null) {
                System.out.println("Not found");
                return;
            }

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + acc.getBalance());
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void adminMenu(){
        while(true) {
            System.out.println("\n===============ADMIN MENU================");
            System.out.println("1 process request");
            System.out.println("2 show requests");
            System.out.println("3 add bill");
            System.out.println("4 process bill");
            System.out.println("5 show bills");
            System.out.println("6 show last transaction");
            System.out.println("7 undo transaction");
            System.out.println("8 add account");
            System.out.println("9 show accounts list");
            System.out.println("10 search account by username");
            System.out.println("11 back");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    processRequest();break;
                case 2:
                    showRequest();break;
                case 3:
                    addBill();break;
                case 4:
                    processBill();break;
                case 5:
                    showBill();break;
                case 6:
                    showTransaction();break;
                case 7:
                    undoTransaction();break;
                case 8:
                    addAccounts();break;
                case 9:
                    showAccountsList();break;
                case 10:
                    searchByUsername();break;
                case 11:return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static BankAccount findAccounts(String username){
        for(BankAccount acc : accounts){
            if (acc.getUsername().equalsIgnoreCase(username)){
                return acc;
            }
        }
        return null;
    }

    static void addAccounts(){
        System.out.println("Username: ");
        String username = scanner.nextLine();

        System.out.println("Balance: ");
        int balance = scanner.nextInt();
        scanner.nextLine();

        int accountNumber = accounts.size() + 1;
        accounts.add(new BankAccount(accountNumber,username,balance));
        System.out.println("Account added");
    }

    static void showAccountsList(){
        System.out.println("Account List:");
        for(BankAccount acc: accounts){
            System.out.println(acc);
        }
    }

    static void searchByUsername(){
        System.out.println("Username: ");
        String name = scanner.nextLine();

        for(BankAccount acc: accounts){
            if(acc.getUsername().equalsIgnoreCase(name)){
                System.out.println("Found" + acc);
                return;
            }
            System.out.println("Not found");
        }
    }

    static void deposit(){
        System.out.println("Username: ");
        String name = scanner.nextLine();

        BankAccount acc = findAccounts(name);

        if(acc!=null){
            System.out.println("Deposit: ");
            int amount = scanner.nextInt();

            acc.setBalance(acc.getBalance() + amount);
            history.push("Deposit: " + amount + " to " + name);
            System.out.println("New balance: " + acc.getBalance());
        }else{
            System.out.println("Not found");
        }
    }

    static void withdraw(){
        System.out.println("Username: ");
        String name = scanner.nextLine();

        BankAccount acc = findAccounts(name);

        if(acc!=null){
            System.out.println("Withdraw: ");
            int amount = scanner.nextInt();

            if (acc.getBalance()>=amount) {
                acc.setBalance(acc.getBalance() - amount);
                history.push("Withdraw: " + amount + " from " + name);
                System.out.println("New balance: " + acc.getBalance());
            }else{
                System.out.println("Balance cant be negative");
            }
        }else{
            System.out.println("Not found: ");
        }
    }

    static void showTransaction(){
        if(!history.isEmpty()){
            System.out.println("Last transaction: " + history.peek());
        }else{
            System.out.println("No transaction");
        }
    }

    static void undoTransaction(){
        if(!history.isEmpty()){
            System.out.println("Undo: " + history.pop());
        }else{
            System.out.println("No transaction");
        }
    }

    static void addBill(){
        System.out.println("Enter bill name: ");
        String bill = scanner.nextLine();

        billQueue.add(bill);
        System.out.println("Added: " + bill);
    }

    static void processBill(){
        if(!billQueue.isEmpty()){
            String bill = billQueue.poll();
            System.out.println("Processing: " + bill);
        }else{
            System.out.println("No bills");
        }
    }

    static void showBill(){
        if(!billQueue.isEmpty()){
            System.out.println("Queue: " + billQueue);
        }else{
            System.out.println("Queue is empty");
        }
    }

    static void requestAccount(){
        System.out.println("Username: ");
        String name = scanner.nextLine();

        BankAccount newAcc = new BankAccount(accounts.size() + 1, name,0) ;

        accountRequest.add(newAcc);
        System.out.println("Account request submitted");
    }

    static void processRequest(){
        if(!accountRequest.isEmpty()){
            BankAccount acc = accountRequest.poll();
            accounts.add(acc);

            System.out.println("Account created: " + acc.getUsername());
        }else{
            System.out.println("No requests");
        }
    }

    static void showRequest(){
        if(!accountRequest.isEmpty()){
            System.out.println("Requests: ");
            for (BankAccount acc: accountRequest){
                System.out.println(acc.getUsername());
            }
        }else {
            System.out.println("No requests");
        }
    }


}