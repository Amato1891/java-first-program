package com.h2;
import java.util.Scanner;
import java.util.Map;

public class BestLoanRates {

    public static final Map<Integer,Float> bestRates =
            Map.of(1, 5.50f, 2, 3.45f, 3, 2.67f, 4 , 1.86f, 5, 0.94f);

    public static float getRates(int loanTermInYears) {

        if(bestRates.containsKey(loanTermInYears)) {
            return bestRates.get(loanTermInYears);
        } else {
            return(0.0f);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name");

        String name = scanner.nextLine();

        System.out.println("Hello " + name);

        System.out.println("Enter the loan term (in years)");

        int loanTermInYears = scanner.nextInt();

        float bestRate = getRates(loanTermInYears);

        if (bestRate == 0.0f) {
            System.out.println(Utilities.ANSI_RED + "No available rates for term: " + loanTermInYears + " years" + Utilities.ANSI_RESET);
        } else {
            System.out.println(Utilities.ANSI_GREEN + "Best Available Rate: " + getRates(loanTermInYears) + "%\n" + Utilities.ANSI_RESET);
        }

        scanner.close();
    }
}
