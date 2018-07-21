package cloudninegui;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FileBrowserDialogMain extends Application {

    // Starten über Terminal:
    // java -cp cloudninegui.jar cloudninegui.FileBrowserDialogMain

    private HostServices hostServices;

    String myFavouriteDirectory = "/Users/Shared/favoriteDirectoriesFile";

    public String getMyFavouriteDirectory() {
        return myFavouriteDirectory;
    }

    public void setMyFavouriteDirectory(String myFavouriteDirectory) {
        this.myFavouriteDirectory = myFavouriteDirectory;
    }

    public HostServices getMyHostServices() {
        return hostServices;
    }

    public void setHostServices(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.setHostServices(hostServices);
        String fxmlFile = "/fxml/fileBrowserDialog.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        FileBrowserDialogController controller = loader.getController();
        controller.setMyFavoriteDirectories(myFavouriteDirectory);
        controller.setHostServices(getHostServices());

        this.setHostServices(controller.getHostServices());

        primaryStage.setTitle("Filterpictures CSV Extractor");
        primaryStage.setScene(new Scene(rootNode, 500, 375));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    // To start from commandline
    // mvn clean install
    // java -cp fileBrowserDialog-1.0-SNAPSHOT.jar sample.FileBrowserDialogMain
}
