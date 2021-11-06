package com.example.f21comp1011gctest1student;

import com.example.f21comp1011gctest1student.Utility.DBUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class NetflixTableController implements Initializable {

    @FXML
    private TableView<NetflixShow> tableView;

    @FXML
    private TableColumn<NetflixShow, String> showIdCol;

    @FXML
    private TableColumn<NetflixShow, String> typeCol;

    @FXML
    private TableColumn<NetflixShow, String> titleCol;

    @FXML
    private TableColumn<NetflixShow, String> ratingCol;

    @FXML
    private TableColumn<NetflixShow, String> directorCol;

    @FXML
    private TableColumn<NetflixShow, String> castCol;

    @FXML
    private CheckBox movieCheckBox;

    @FXML
    private CheckBox tvCheckBox;

    @FXML
    private ComboBox<String> selectRatingComboBox;

    @FXML
    private Label numOfShowsLabel;

    private ArrayList<NetflixShow> netflixShows;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        netflixShows = DBUtility.getAllNetflixShow("All", "All rating");


        showIdCol.setCellValueFactory(new PropertyValueFactory<>("showId"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        castCol.setCellValueFactory(new PropertyValueFactory<>("cast"));
        directorCol.setCellValueFactory(new PropertyValueFactory<>("director"));

        tableView.getItems().addAll(netflixShows);
        selectRatingComboBox.getItems().add("All rating");
        selectRatingComboBox.getItems().addAll(getRatingFromTable());

        updateLabel();

        tvCheckBox.setSelected(true);
        movieCheckBox.setSelected(true);


    }

    @FXML
    void applyFilter(ActionEvent event)  {
        tableView.getItems().clear();

        String ratingSelected = selectRatingComboBox.getSelectionModel().getSelectedItem();
        String type = "All";

        if (ratingSelected == null)
            ratingSelected = "All rating";

        if(movieCheckBox.isSelected() && !tvCheckBox.isSelected())
            type = "Movie";
        else if(!movieCheckBox.isSelected() && tvCheckBox.isSelected())
            type = "TV Show";
        else if(!movieCheckBox.isSelected() && !tvCheckBox.isSelected())
            type = "none";


        tableView.getItems().addAll(DBUtility.getAllNetflixShow(type, ratingSelected));
        updateLabel();
    }

    private void updateLabel() {
        numOfShowsLabel.setText("Number of Movies/Shows: " + tableView.getItems().size());
    }


    // get rating from table view
    private TreeSet<String> getRatingFromTable() {
        TreeSet<String> rating = new TreeSet<>();

        for (NetflixShow netflixShow: tableView.getItems())
            rating.add(netflixShow.getRating());

        return rating;
    }
}
