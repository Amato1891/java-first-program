import com.h2.BestLoanRates;
import com.h2.MortgageCalculator;
import com.h2.SavingsCalculator;
import com.h2.Utilities;

import java.util.Arrays;

import java.util.Map;

public class Finance {

    public final static String BEST_LOAN_RATES = "bestLoanRates";
    public final static String SAVINGS_CALCULATOR = "savingsCalculator";
    public final static String MORTGAGE_CALCULATOR = "mortgageCalculator";

    public final static Map<String, String> commandsToUsage = Map.of(
            BEST_LOAN_RATES, "\nTo use the bestLoanRates feature, pass the CLI argument \"bestLoanRates\" \n",
            SAVINGS_CALCULATOR, "\n\nTo use the savingsCalculator feature, pass the argument " + Utilities.ANSI_CYAN + "\"savingsCalculator\"" + Utilities.ANSI_RESET + " followed by" + Utilities.ANSI_CYAN + " <credits separated by ','> <debits separated by ','> \n\n" + Utilities.ANSI_RESET,
            MORTGAGE_CALCULATOR, "\nTo use the mortgageCalculator feature, pass the argument " + Utilities.ANSI_CYAN + "\"mortgageCalculator\"" + Utilities.ANSI_RESET + " followed by" + Utilities.ANSI_CYAN + " <loanAmount> <termInYears> <annualRate>\n" + Utilities.ANSI_RESET);

    private static boolean validateCommandArguments(String[] args) {

        switch (args[0]) {
            case BEST_LOAN_RATES:
                return (args.length == 1);
            case SAVINGS_CALCULATOR:
                return (args.length == 3);
            case MORTGAGE_CALCULATOR:
                return (args.length == 4);
        }
        return (false);
    }

    private static void executeCommand(String command, String[] arguments) {
        switch (command) {
            case BEST_LOAN_RATES:
                System.out.println("\nFinding best loan rates ...\n");
                BestLoanRates.main(arguments);
                return;
            case SAVINGS_CALCULATOR:
                System.out.println("\nFinding your net savings ...\n");
                SavingsCalculator.main(arguments);
                return;
            case MORTGAGE_CALCULATOR:
                System.out.println("\nFinding your monthly payment ...\n");
                MortgageCalculator.main(arguments);
                return;
        }

    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println(
                    Utilities.ANSI_GREEN + "\n\n*****************************************************************************************************************************************\n" +
                            "** " + Utilities.ANSI_RESET + "To use the Finance App pass one of these arguments," + Utilities.ANSI_CYAN + " \"bestLoanRates\" \"savingsCalculator\" \"mortgageCalculator\"" + Utilities.ANSI_RESET + Utilities.ANSI_GREEN + " **"
                            + "\n*****************************************************************************************************************************************\n\n" + Utilities.ANSI_RESET);
            return;
        }

        String command = args[0];
        if (!commandsToUsage.containsKey(command)) {
            System.out.println(command + ": command not found");
            return;
        }

        boolean isValidCommand = validateCommandArguments(args);
        if (!isValidCommand) {
            System.out.println(commandsToUsage.get(args[0]));
            return;
        }

        executeCommand(command, Arrays.copyOfRange(args, 1, args.length));
    }
}
