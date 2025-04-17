import java.util.List;

public class AIPredictor {
    public static void predict(List<Transaction> transactions) {
        double totalIncome = 0;
        double totalExpense = 0;
        for (Transaction t : transactions){
            if(t.getType().equalsIgnoreCase("Income"))
                totalIncome += t.getAmount();
            else
                totalExpense += t.getAmount();
        }

        double predictedSavings = totalIncome - totalExpense;
        System.out.println("Predicted savings this month: $" + predictedSavings);
    }
}