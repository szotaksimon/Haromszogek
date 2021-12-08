package com.example.haromszogek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class HelloController {

    @FXML
    public ListView<String> listViewHibak;
    @FXML
    public ListView<DHaromszog> listViewDerekszog;
    @FXML
    private Button buttonAdatokBetoltese;

    @FXML
    private void onButtonAdatokBetolteseClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Szöveges állomány megnyitása");
        FileChooser.ExtensionFilter extensionFilter =
                new FileChooser.ExtensionFilter("Szöveges állományok (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);

        File fajl = fileChooser.showOpenDialog(null);
        fajlBeolvas(fajl.toString());
    }

    private void fajlBeolvas(String fajl){
        try{
            FileReader fr = new FileReader(fajl);
            BufferedReader br = new BufferedReader(fr);

            int i = 1;
            String sor = br.readLine();
            while(sor != null){
                try{
                    DHaromszog dh = new DHaromszog(sor, i++);
                }catch (Exception e){
                    listViewHibak.getItems().add(e.getMessage());
                }finally {
                    sor = br.readLine();
                }
            }

            fr.close();
            br.close();
        }catch (IOException ioe){
            System.err.println(ioe.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}