import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class FinanceChart {
    public static void displayChart(double income, double expense) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(income, "Amount", "Income");
        dataset.addValue(expense, "Amount", "Expense");

        JFreeChart barChart = ChartFactory.createBarChart(
                "Financial Overview",
                "Type",
                "Amount",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(barChart);
        JFrame frame = new JFrame("Finance Chart");
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
