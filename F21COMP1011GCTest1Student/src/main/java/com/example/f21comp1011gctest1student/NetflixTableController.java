package com.example.f21comp1011gctest1student;

import com.example.f21comp1011gctest1student.Utility.DBUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectRatingComboBox.getItems().add("All ratings");
        selectRatingComboBox.getItems().addAll(DBUtility.getAllRating());
        tvCheckBox.setSelected(true);
        movieCheckBox.setSelected(true);
        showIdCol.setCellValueFactory(new PropertyValueFactory<>("showId"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        castCol.setCellValueFactory(new PropertyValueFactory<>("cast"));
        directorCol.setCellValueFactory(new PropertyValueFactory<>("director"));

        tableView.getItems().addAll(DBUtility.getAllNetflixShow());
        numOfShowsLabel.setText(String.valueOf(DBUtility.getAllNetflixShow().stream().count()));
    }

    @FXML
    void applyFilter(ActionEvent event)  {
        String rating = selectRatingComboBox.getSelectionModel().getSelectedItem();
        Boolean Movie = movieCheckBox.isSelected();
        Boolean TvShow = tvCheckBox.isSelected();
        tableView.getItems().clear();
        tableView.getItems().addAll(DBUtility.getSelectedSearch(rating));
        numOfShowsLabel.setText(String.valueOf(DBUtility.getSelectedSearch(rating).stream().count()));
        if (Movie == true)
        {
            tableView.getItems().clear();
            tableView.getItems().addAll(DBUtility.getSelectedSearchMovie());
            numOfShowsLabel.setText(String.valueOf(DBUtility.getSelectedSearchMovie().stream().count()));
        }
        if (TvShow == true)
        {
            tableView.getItems().clear();
            tableView.getItems().addAll(DBUtility.getSelectedSearchTV());
            numOfShowsLabel.setText(String.valueOf(DBUtility.getSelectedSearchTV().stream().count()));
        }
    }
}
