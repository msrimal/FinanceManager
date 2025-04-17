import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;


public class FinanceController {
    @FXML private TextField amountField;
    @FXML private TextField categoryField;
    @FXML private ComboBox<String> typeBox;
    @FXML private DatePicker datePicker;
    @FXML private TableView<Transaction> table;


    private DatabaseManager db;
    private ObservableList<Transaction> data;

    public void initialize() {
        db = new DatabaseManager();
        typeBox.setItems(FXCollections.observableArrayList("Income", "Expense"));
        loadTable();
    }

    private void loadTable() {
        List<Transaction> transactions = db.getTransactions();
        data = FXCollections.observableArrayList(transactions);
        table.setItems(data);
    }

    @FXML private void addTransaction() {
        double amount = Double.parseDouble(amountField.getText());
        String type = typeBox.getValue();
        String category = categoryField.getText();
        String date = datePicker.getValue().toString();
        Transaction t = new Transaction(amount, type, category, date);
        db.addTransaction(t);
        data.add(t);
        AIPredictor.predict(t);
    }
}
