package Interface;

import Engine.Data;
import Engine.Index;
import Engine.Main;
import Engine.Variance;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FinalWindowController {
    @FXML
    private TextField varianceResult;
    @FXML
    private TextField ratingResult;
    @FXML
    public TextArea detailsArea;
    @FXML
    private ImageView lineChartImage;
    
    public void loadChartImage(){
        File file = new File(System.getProperty("user.home"),"Pictures/lineChart.png");
        Image image = new Image(file.toURI().toString());
        lineChartImage.setImage(image);
    }
    public void setTextField() {
        varianceResult.setText(""+Variance.getVariance()+"");
        ratingResult.setText(""+Index.getScore()+"/10");
    }
    
    public void setTextArea(){
        Index.scoreDetails();
        detailsArea.appendText(Index.d1+Index.d2+Index.d3+Index.d4+Index.d5+Index.d6);
    }

    @FXML
    private void reRunBenchmark(ActionEvent event) {
        Data.clearData();
        Variance.clearVariance();
        GraphWindow.clearChart();
        Main.backgroundTask();
        Main.stage.setScene(GraphWindow.scene2);
    }
}
