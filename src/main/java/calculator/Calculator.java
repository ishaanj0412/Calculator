package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import javafx.util.Pair;

public class Calculator {
    private static Logger logger;

    public Calculator() {
        logger  = LogManager.getLogger(Calculator.class);
    }

    public static void menu(){
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public int myAdd(int num1, int num2){
        logger.info("[ADDITION] - SUCCESSFUL!");
        return num1+num2;
    }

    public int mySub(int num1, int num2){
        logger.info("[SUBTRACTION] - SUCCESSFUL!");
        return num1-num2;
    }

    public int myMul(int num1, int num2){
        logger.info("[MULTIPLICATION] - SUCCESSFUL!");
        return num1*num2;
    }

    public Pair<Boolean, Double> myDiv(int num1, int num2){
        if(num2==0){
            logger.error("[DIVISION] - INVALID INPUT!");
            return new Pair<Boolean, Double>(false, (double)-1);
        }

        logger.info("[DIVISI0N] - SUCCESSFUL!");
        return new Pair<Boolean, Double>(true, (double)num1/num2);
    }
    public static void main(String[] args) {

        Calculator cal = new Calculator();
        logger.info("Start of Execution");

        Scanner sc = new Scanner(System.in);

        System.out.println("-------------");
        System.out.println("Calculator");
        System.out.println("-------------");

        int choice=-1;

        do{
            Calculator.menu();

            choice = sc.nextInt();

            int num1, num2, ans;

            switch(choice){
                case 1:
                    logger.info("START OP: ADDITION");
                    System.out.println("Enter first number: ");
                    num1 = sc.nextInt();
                    System.out.println("Enter second number: ");
                    num2 = sc.nextInt();
                    ans = cal.myAdd(num1, num2);
                    System.out.println("Sum of " + num1 + " and " + num2 + " is " + ans);
                    logger.info("END OP: ADDITION");
                    break;

                case 2:
                    logger.info("START OP: SUBTRACTION");
                    System.out.println("Enter first number: ");
                    num1 = sc.nextInt();
                    System.out.println("Enter second number: ");
                    num2 = sc.nextInt();
                    ans = cal.mySub(num1, num2);
                    System.out.println("Subtraction of " + num1 + " and " + num2 + " is " + ans);
                    logger.info("END OP: SUBTRACTION");
                    break;

                case 3:
                    logger.info("START OP: MULTIPLICATION");
                    System.out.println("Enter first number: ");
                    num1 = sc.nextInt();
                    System.out.println("Enter second number: ");
                    num2 = sc.nextInt();
                    ans = cal.myMul(num1, num2);
                    System.out.println("Multiplication of " + num1 + " and " + num2 + " is " + ans);
                    logger.info("END OP: MULTIPLICATION");
                    break;

                case 4:
                    logger.info("START OP: DIVISION");
                    System.out.println("Enter first number: ");
                    num1 = sc.nextInt();
                    System.out.println("Enter second number: ");
                    num2 = sc.nextInt();
                    Pair<Boolean, Double> ansdiv = cal.myDiv(num1, num2);
                    if(!ansdiv.getKey()) {
                        System.out.println("Invalid input!");
                    }
                    else {
                        System.out.println("Division of " + num1 + " by " + num2 + " is " + ansdiv.getValue());
                    }
                    logger.info("END OP: DIVISION");
                    break;

                case 5:
                    System.out.println("GoodBye");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 5);

        logger.info("End of Execution");
        sc.close();
    }
}