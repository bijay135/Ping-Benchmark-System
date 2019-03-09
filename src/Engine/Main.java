package Engine;

import Interface.GraphWindow;
import javafx.application.Application;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {
    public static Alert serverErrorAlert = new Alert(Alert.AlertType.ERROR);
    public static Stage stage;
    public static Scene scene3;
  
    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        
        Parent initialWindow = FXMLLoader.load(getClass().getResource("/Interface/InitialWindow.fxml"));
        Scene scene1 = new Scene(initialWindow,1024,768);
        
        stage.toFront();
        stage.setResizable(false);
        stage.setTitle("Ping Benchmark System"+
        "                                                            "+
        "Developed By : Bijay Shah");
        
        stage.setScene(scene1);
        serverErrorAlert.initOwner(stage);
        stage.show();
        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
    }   
      
    public static void backgroundTask(){
        Timer timer = new Timer(); 
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Data.counter++;
                            
                    Ping.startPing(Server.getSelectedServer());
                           
                    Variance.calculateVariance();
                                    
                    Platform.runLater(() -> {
                        GraphWindow.refreshButton.fire();
                    });
                    // Data.printData();  For Debugging
                                                                                
                    if (Data.counter == 120) {
                        timer.cancel();
                        Index.calculateScore();
                        // Result.displayResult();  For Degugging
                    }               
                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },0,500);
    }
    
    public static void main(String[] args) {     
        launch(args);
    }
}
