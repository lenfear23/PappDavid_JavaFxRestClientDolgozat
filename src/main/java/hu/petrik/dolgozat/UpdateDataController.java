package hu.petrik.dolgozat;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateDataController extends Controller {
    @FXML
    private TextField nameField;
    @FXML
    private TextField jobtitleField;
    @FXML
    private TextField companyField;
    @FXML
    private TextField statusField;
    @FXML
    private Button updateButton;

    private Datas datas;

    public void setPerson(Datas datas) {
        this.datas = datas;
        nameField.setText(this.datas.getName());
        jobtitleField.setText(this.datas.getJobtitle());
        companyField.setText(this.datas.getCompany());
        statusField.setText(this.datas.getStatus());
    }



    @FXML
    public void updateClick(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        String jobtitle = jobtitleField.getText().trim();
        String company = companyField.getText().trim();
        String status = statusField.getText().trim();
        if (name.isEmpty()) {
            warning("Name is required");
            return;
        }
        if (jobtitle.isEmpty()) {
            warning("Job title is required");
            return;
        }
        if (company.isEmpty()){
            warning("Company name is required");
            return;
        }
        if (status.isEmpty()){
            warning("Status value is required");
            return;
        }
        this.datas.setName(name);
        this.datas.setJobtitle(jobtitle);
        this.datas.setCompany(company);
        this.datas.setStatus(status);
        Gson converter = new Gson();
        String json = converter.toJson(this.datas);
        try {
            String url = App.BASE_URL + "/" + this.datas.getId();
            Response response = RequestHandler.put(url, json);
            if (response.getResponseCode() == 200) {
                Stage stage = (Stage) this.updateButton.getScene().getWindow();
                stage.close();
            } else {
                String content = response.getContent();
                error(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
