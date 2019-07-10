package netcafe.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import netcafe.entity.Member;

import java.net.URL;
import java.util.ResourceBundle;

public class MemberController implements Initializable {
    @FXML
    private TableView<Member> tableView;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXTextField txtAvatar;

    @FXML
    private JFXTextField txtRemainTime;

    @FXML
    private JFXTextField txtFullname;

    @FXML
    private JFXTextField txtStatus;

    @FXML
    private TableColumn<Member, String> clnUsername;

    @FXML
    private TableColumn<Member, String> clnAvatar;

    @FXML
    private TableColumn<Member, Integer> clnRemainTime;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.tableView.setRowFactory(tv -> {
            TableRow<Member> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()){
                    Member rowData = row.getItem();
                    txtUsername.setText(rowData.getUsername());
                    txtAvatar.setText(rowData.getAvatar());
                    txtRemainTime.setText(String.valueOf(rowData.getRemainTime()));
                }
            });
            return row;
        });
        this.clnUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        this.clnAvatar.setCellValueFactory(new PropertyValueFactory<>("imageAvatar"));
        this.clnRemainTime.setCellValueFactory(new PropertyValueFactory<>("RemainTime"));
    }
}
