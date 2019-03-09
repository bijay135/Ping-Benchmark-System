package Interface;

import Engine.Main;
import Engine.Server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class InitialWindowController extends GraphWindow {      
    @FXML
    private ToggleGroup Servers;
    
    @FXML
    private void server1Button(ActionEvent event) {
        Server.serverChoice(1);
    }
    
    @FXML
    private void server2Button(ActionEvent event) {
        Server.serverChoice(2);
    }

    @FXML
    private void server3Button(ActionEvent event) {
        Server.serverChoice(3);
    }
    
    @FXML
    private void startButton(ActionEvent event) throws InterruptedException {
        if(Server.getSelectedServer() == null){
            Server.serverChoice(1);
        }
        if(Server.isReachable()){
            // System.out.println("Sending Ping Request to "+Server.getSelectedServer()+"\n");  For Debugging
            Main.backgroundTask();
            
            lineChart.setStyle("CHART_COLOR_1 : #0000cd;");
            yAxis.setLabel("Ping Round Trip Time in MS");
            lineChart.setAnimated(true);
            lineChart.setCreateSymbols(true);
            series.setName("Internet Connection Stability Benchmark Graph");
            graphWindow.setCenter(lineChart);
        
            drawGraph();
            plotGraph();
            finalWindow();  
            
            scene2.getStylesheets().add("LineChart.css");
            lineChart.applyCss();
            Main.stage.setScene(scene2);
        }
        else{
            Main.serverErrorAlert.setHeaderText("\t\tServer Unreachable");
            Main.serverErrorAlert.setContentText("Check your internet connection or try a different server");
            Main.serverErrorAlert.show();
        }
    }   
}
