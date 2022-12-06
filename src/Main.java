import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = s.nextLine();

        Bank bank = new Bank();
        BagelShop bagel = new BagelShop(name,100,1,bank);
        CreditCard card1 = new CreditCard("card1", "12345");
        CreditCard card2 = new CreditCard("card2", "67890");

        BankApp bankApp = new BankApp(name);
        System.out.println(bankApp);
        int userInput = s.nextInt();
        System.out.println(bankApp.action(bagel,bank,card1,card2,"12345","67890", userInput,1,1));
        while((userInput > 0) && (userInput < 8)){
            System.out.println(bankApp);
            userInput = s.nextInt();
            System.out.println(bankApp.action(bagel,bank,card1,card2,"12345","67890",userInput, 1,1));
        }
    }

}

