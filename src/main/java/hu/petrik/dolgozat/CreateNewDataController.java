package hu.petrik.dolgozat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class CreateNewDataController extends Controller {
    @FXML
    private TextField nameField;
    @FXML
    private TextField jobtitleField;
    @FXML
    private TextField companyField;
    @FXML
    private TextField statusField;
    @FXML
    private Button submitButton;



    @FXML
    public void submitClick(ActionEvent actionEvent) {
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
        Datas newDatas = new Datas(0, name, jobtitle, company, status);
        Gson converter = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = converter.toJson(newDatas);
        try {
            Response response = RequestHandler.post(App.BASE_URL, json);
            if (response.getResponseCode() == 201) {
                warning("Thank you! \n Data is added");
                nameField.setText("");
                jobtitleField.setText("");
                companyField.setText("");
                statusField.setText("");
            } else {
                String content = response.getContent();
                error(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
