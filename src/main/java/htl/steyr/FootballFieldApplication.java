package htl.steyr;

import htl.steyr.footballfield.application.JavaFxApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FootballFieldApplication {

    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);
    }

}
