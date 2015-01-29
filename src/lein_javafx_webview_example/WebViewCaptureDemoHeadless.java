// Taken from
// https://gist.github.com/jewelsea/5632958

package lein_javafx_webview_example;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.beans.value.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.*;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.NumberStringConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;

public class WebViewCaptureDemoHeadless extends Application {
  private static final String HOME_LOC = "http://docs.oracle.com/javafx/2/get_started/animation.htm";

  private WebView webView;
  private WebEngine webEngine;

  private File captureFile = new File("cap.png");

  public static void main(String[] args) { Application.launch(WebViewCaptureDemoHeadless.class); }

  @Override public void start(Stage stage) throws Exception {
    webView = new WebView();
    webEngine = webView.getEngine();

    webView.setPrefSize(1000, 8000);

    ScrollPane webViewScroll = new ScrollPane();
    webViewScroll.setContent(webView);
    webViewScroll.setPrefSize(800, 300);

    final PauseTransition pt = new PauseTransition();
    pt.setDuration(Duration.millis(500));
    pt.setOnFinished(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        WritableImage image = webView.snapshot(null, null);
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        try {
          ImageIO.write(bufferedImage, "png", captureFile);

          System.out.println("Captured WebView to: " + captureFile.getAbsoluteFile());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });

    webView.setPrefWidth(1000);
    webView.setPrefHeight(8000);

    webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
	    @Override
		public void changed(ObservableValue<? extends State> ov, State t, State t1) {
		if (t1 == Worker.State.SUCCEEDED) {
		    pt.play();
		}
	    }
	});

    webView.getEngine().load(HOME_LOC);

    VBox layout = new VBox(10);
    layout.setStyle("-fx-padding: 10; -fx-background-color: cornsilk;");
    layout.getChildren().setAll(
        webViewScroll
    );

    stage.setScene(new Scene(layout));
    stage.show();
  }

}

