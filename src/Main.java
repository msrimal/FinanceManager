import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Main extends Application {
    @Override

    public void start(Stage primaryStage) throws Exception {
        //check if path is correct
        System.out.println(getClass().getResource("/FinanceView.fxml"));
        
        Parent root = FXMLLoader.load(getClass().getResource("FinanceView.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Personal Finance Manager");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}