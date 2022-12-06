import java.util.Scanner;
public class BankApp {
    private String name;
    private boolean cardISOpen;


    Scanner s = new Scanner(System.in);

    public BankApp(String name) {
        this.name = name;
        cardISOpen = false;
    }


    public String toString() {
        String menu = "\nPlease input an action. Only 1-7 are appropriate actions. " +
                "\n1:Make a purchase at the bagel shop." +
                "\n2:Return a purchase at the bagel shop." +
                "\n3:Make a payment on the credit card." +
                "\n4:Open a second credit card" +
                "\n5:Compare credit card balances." +
                "\n6:As the bagel owner deposit profits into the bank" +
                "\n7:As the bagel owner check your inventory";
        return menu;
    }

    public String action(BagelShop bagel, Bank bank, CreditCard card1, CreditCard card2, String personalPIN1, String personalPIN2, int userInput, int quantity, int payment) {
        if (((userInput == 1) || (userInput == 2) || (userInput == 3)) && (!cardISOpen)) {
            if ((userInput == 1)) {
                bagel.payForBagels(card1, quantity, personalPIN1);
                return "The payment was successful\n" + card1;
            }
            else if ((userInput == 2)){
                bagel.returnBagels(card1, quantity, personalPIN1);
                return "The return was successful\n" + card1;
            }
            else if ((userInput == 3)) {
                bank.makePayment(card1, payment);
                return "The payment was successful\n" + card1;
            }
        }
        if (((userInput == 1) || (userInput == 2) || (userInput == 3)) && (cardISOpen)) {
            System.out.println("What card would you like to you? Only card1 and card2 are appropriate responses");
            String userInput2 = s.nextLine();
            if (((userInput == 1) && (userInput2.equals("card1"))) || ((userInput == 1) && (!cardISOpen))) {
                bagel.payForBagels(card1, quantity, personalPIN1);
                return "The payment was successful\n" + card1;
            } else if ((userInput == 1) && userInput2.equals("card2")) {
                bagel.payForBagels(card2, quantity, personalPIN2);
                return "The payment was successful\n" + card2;
            }
            else if (((userInput == 2) && (userInput2.equals("card1"))) || ((userInput == 2) && (!cardISOpen))){
                    bagel.returnBagels(card1, quantity, personalPIN1);
                    return "The return was successful\n" + card1;
                } else if ((userInput == 2) && userInput2.equals("card2")) {
                bagel.returnBagels(card2, quantity, personalPIN2);
                return "The return was successful\n" + card2;
            }
             else if (((userInput == 3) && (userInput2.equals("card1"))) || ((userInput == 3) && (!cardISOpen))) {
                    bank.makePayment(card1, payment);
                return "The payment was successful\n" + card1;
                } else if ((userInput == 3) && userInput2.equals("card2")) {
                    bank.makePayment(card2, payment);
                return "The payment was successful\n" + card2;
                }
        } else if (userInput == 4) {
            if (!cardISOpen) {
                cardISOpen = true;
                return "Your second credit card is opened";
            } else {
                return "Your second credit card is already opened";
            }
        } else if (userInput == 5) {
            if(bank.lowerBalance(card1,card2) == null){
                return "Both credit cards have the same balance";
            } else{
                return (bank.lowerBalance(card1, card2).getAccountHolder()) + " has the lower balance";
            }
        } else if (userInput == 6) {
            bagel.depositProfits();
            return "The profits have been deposited into the bank.";
        } else if (userInput == 7) {
            return bagel.toString();
        }
        return "This response is invalid";
    }
}