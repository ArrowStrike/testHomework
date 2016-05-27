import java.util.Scanner;
import java.util.ArrayList;
/**
 * Created by Vladislavs on 26.05.2016..
 */
public class WhoeverWillPayForWhat {

    public static void main(String[] args) {
        ArrayList <Expense> list = new ArrayList();
        Scanner sc = new Scanner(System.in);

        System.out.print("How many payments have been on a vacation? ");
        int howManyPayments = Integer.valueOf(sc.nextLine());
        System.out.print("How many people have been on a vacation? ");
        int howManyPeople = Integer.valueOf(sc.nextLine());

        for (int i = 0; i<howManyPayments ; i++) {
            list.add(getExpenseFromUser(sc));
        }
        System.out.println("------------------------------");
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i).getName() + ": ");
            System.out.print(list.get(i).getService() + " - ");
            System.out.print(list.get(i).getAmount() + "$");
            System.out.println();
        }

        double totalAmount=0;
        for(int i=0;i<list.size();i++){
            totalAmount=totalAmount+list.get(i).getAmount();
        }
        double average=totalAmount/howManyPeople;
        System.out.println("------------------------------");
        System.out.println("Total: "+totalAmount+"$");
        System.out.println("Average: "+average+"$ to be paid by mate.");
        System.out.println("------------------------------");

        System.out.println("Expenses:");
        //Calculates the sum of all payments made by the person
        list.add(addNewField());
        double sumMadeByThePerson=0;
        int counterOfArrayFields=1;
        int counterOfPeople=0;
        double howMuchPaid=0;
        String whoPaidMore = new String();
            do {
                sumMadeByThePerson = sumMadeByThePerson + list.get(counterOfArrayFields-1).getAmount();
                if (!list.get(counterOfArrayFields).getName().equals(list.get(counterOfArrayFields - 1).getName())) {
                    System.out.println(list.get(counterOfArrayFields-1).getName() + ": " + sumMadeByThePerson);

                    counterOfPeople++;
                    if(howMuchPaid<sumMadeByThePerson){
                        howMuchPaid=sumMadeByThePerson;
                        whoPaidMore=list.get(counterOfArrayFields-1).getName();

                }
                    sumMadeByThePerson = 0;}
                counterOfArrayFields++;
            } while (counterOfPeople<howManyPeople);

        System.out.println("------------------------------");
        System.out.println("Transactions to be made:");
        //Then we determine who paid more and from this amount we subtract average to be paid by mate.
        //There we get sum that you should send to each of your friends
        //..
        sumMadeByThePerson=0;
        counterOfArrayFields=1;
        counterOfPeople=0;

        do {
            sumMadeByThePerson = sumMadeByThePerson + list.get(counterOfArrayFields-1).getAmount();
            if (!list.get(counterOfArrayFields).getName().equals(list.get(counterOfArrayFields - 1).getName())) {
                if(!(list.get(counterOfArrayFields-1).getName().equals(whoPaidMore))){
                System.out.println(list.get(counterOfArrayFields-1).getName() +" -> "+whoPaidMore+ ": " + (average-sumMadeByThePerson)+"$");
                }
                sumMadeByThePerson = 0;
                counterOfPeople++;
            }
            counterOfArrayFields++;
        } while (counterOfPeople<howManyPeople);


        System.out.println("------------------------------");
        System.out.println("Result:");
        // shows the amount of who paid and how much.
        //..
        sumMadeByThePerson=0;
        counterOfArrayFields=1;
        counterOfPeople=0;

        do {
            sumMadeByThePerson = sumMadeByThePerson + list.get(counterOfArrayFields-1).getAmount();
            if (!list.get(counterOfArrayFields).getName().equals(list.get(counterOfArrayFields - 1).getName())) {
                System.out.println((list.get(counterOfArrayFields - 1).getName())+": "+ average);
                sumMadeByThePerson = 0;
                counterOfPeople++;
            }
            counterOfArrayFields++;
        } while (counterOfPeople<howManyPeople);

    }
    public static Expense addNewField(){
        String name = "123";
        String service = "123";
        double amount = 123;

        Expense expense = new Expense(name, service, amount);
        return expense;
    }

    public static Expense getExpenseFromUser(Scanner sc){
        System.out.print("Enter name of your friend: ");
        String name = sc.nextLine();
        System.out.print("Service he has paid for: ");
        String service = sc.nextLine();
        System.out.print("The amount: ");
        double amount = Double.valueOf(sc.nextLine());

        Expense expense = new Expense(name, service, amount);
        return expense;
    }

}