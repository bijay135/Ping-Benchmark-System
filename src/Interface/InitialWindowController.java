package Interface;

import Database.ConnectionUtility;
import Engine.Main;
import Engine.Server;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class InitialWindowController extends GraphWindow {      
    @FXML
    private ToggleGroup Servers;
    @FXML
    private TextArea historyArea;
    
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
    
    public void loadHistory() throws Exception{
        Connection con  = ConnectionUtility.getConnection();
        
        ResultSet rs = con.createStatement().executeQuery("select * from history");
        while (rs.next()) {
            historyArea.appendText(rs.getString(1)+"  |  ");
            historyArea.appendText("Ping Variance: "+rs.getString(2)+"  |  ");
            historyArea.appendText("Stability Rating: "+rs.getString(3)+"/10"+"\n");
        }
        //System.out.println("Successfully Retrived");  For Debugging
        
        ConnectionUtility.closeConnection();
    }
}
