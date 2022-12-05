package htl.steyr.footballfield.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

@Component
public class AbstractController implements IDialogConfirmedPublisher {

    private Object[] params;
    private ArrayList<IDialogConfirmedSubscriber> subs = new ArrayList<>();

    @Override
    public void addSubscriber(IDialogConfirmedSubscriber sub) {
        subs.add(sub);
    }

    public void closeWindow(Stage s) {
        s.close();
    }

    public void setObjects(Object ... list) {
        params = list;
    }

    public static Object openDialog(URL resource, String title, Window owner, IDialogConfirmedSubscriber ... subs) {
        Object result = null;
        try {
            FXMLLoader loader = new FXMLLoader(resource);
            loader.setControllerFactory(JavaFxApplication.getSpringContext()::getBean);
            Parent root = loader.load();

            result = loader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(title);

            if (owner != null) {
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(owner);
            }

            if (subs != null && subs.length > 0 && result instanceof AbstractController) {
                for (IDialogConfirmedSubscriber sub : subs) {
                    ((AbstractController) result).addSubscriber(sub);
                }
            }

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    protected ArrayList<IDialogConfirmedSubscriber> getSubscribers() {
        return subs;
    }

    protected Object[] getParams() {
        return params;
    }
}
