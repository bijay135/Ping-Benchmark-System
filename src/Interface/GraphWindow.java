package Interface;

import Engine.Data;
import Engine.Main;
import Engine.Ping;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javax.imageio.ImageIO;

public class GraphWindow extends FinalWindowController {
    public static int iterationCount = 0;
    
    public static BorderPane graphWindow = new BorderPane();
    public static Scene scene2 = new Scene(graphWindow,1024,768);
    
    public static Button refreshButton = new Button();
    static Button loadButton = new Button();
    
    static NumberAxis xAxis = new NumberAxis(), yAxis = new NumberAxis();
    static LineChart lineChart = new LineChart(xAxis, yAxis);
    static XYChart.Series series = new XYChart.Series();
    
    static LineChart drawGraph(){
        lineChart.getData().add(series);
        
        return lineChart;
    }
    
    public void plotGraph() throws InterruptedException {
        refreshButton.setOnAction((ActionEvent event) -> {
            iterationCount++;
            
            if(Ping.getPingResult() == false || Data.pingData[iterationCount] == 0){
                if(iterationCount == 120) {
                    try {
                        saveAsPng();
                        finalWindowResources();
                        loadButton.fire();
                    } 
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                
                return;
            }
            
            series.getData().add(new XYChart.Data(iterationCount,Data.pingData[iterationCount]));
            
            if(iterationCount == 120) {
                try {
                    saveAsPng();
                    finalWindowResources();
                    loadButton.fire();
                    } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void finalWindow(){
        loadButton.setOnAction((ActionEvent event) -> {
            Main.stage.setScene(Main.scene3);
        });
    }
    
    public void saveAsPng() throws IOException {
        WritableImage image = scene2.snapshot(null);
        File file = new File(System.getProperty("user.home"),"Pictures/lineChart.png");
        ImageIO.write(SwingFXUtils.fromFXImage(image,null),"png",file);
    }
    
    public void finalWindowResources() throws Exception{
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/Interface/FinalWindow.fxml"));
        Parent finalWindow = loader2.load();
        FinalWindowController controller2 = loader2.getController();
        controller2.loadChartImage();
        controller2.setTextField();
        controller2.setTextArea();
        controller2.saveHistory();
        Main.scene3 = new Scene(finalWindow,1024,768);
    }
    
    public static void clearChart(){
        iterationCount = 0;
        series.getData().clear();
    }
}
