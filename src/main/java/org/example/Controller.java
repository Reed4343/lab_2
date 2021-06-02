package org.example;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.sourceClass.PoorClient;
import org.example.sourceClass.RichClient;
import org.example.sourceClass.StudentClient;

public class Controller {
    private final RichClient rich = new RichClient();
    private final PoorClient poor = new PoorClient();
    private final StudentClient student = new StudentClient();

    @FXML
    private URL location;

    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;
    @FXML
    private ComboBox<String> ComboBox;

    @FXML
    void cash(ActionEvent event) {
        Util u = new Util();
        if (chekTextFieldEmpty()) {     //Проверка на введённые дынные
            u.messageBox("Ошибка", "Поля не заполнены");
        } else if (!chekTextFieldNumber()) {
            u.messageBox("Ошибка", "Введена неверная сумма");
        } else {
            if (ComboBox.getValue().equals("Богатый клиент")) {
                rich.get_cash(textField1.getText(), Integer.parseInt(textField2.getText()));
                u.messageBox("Богатый клиент", "Дорогой " + rich.get_name() + ", деньги в размере " + rich.get_money().get_summ() + "$ успешно сняты с вашего счета");
            } else if (ComboBox.getValue().equals("Бедный клиент")) {
                poor.get_cash(textField1.getText(), Integer.parseInt(textField2.getText()));
                u.messageBox("Бедный клиент", "Клиент под именем " + poor.get_name() + ", деньги в размере " + poor.get_money().get_summ() + "$ успешно сняты с вашего счета");
            }
            if (ComboBox.getValue().equals("Студент")) {
                student.get_cash(textField1.getText(), Integer.parseInt(textField2.getText()));
                u.messageBox("Студент", "Студент под именем " + student.get_name() + ", деньги в размере " + student.get_money().get_summ() + "$ успешно сняты с вашего счета");
            }
        }
    }

    @FXML
    void initialize() {
        setComboBox();
    }

    public void setComboBox() {
        ComboBox.getItems().removeAll(ComboBox.getItems());
        ComboBox.getItems().addAll("Богатый клиент", "Бедный клиент", "Студент");
        ComboBox.getSelectionModel().select("Студент");
    }

    public boolean chekTextFieldNumber() {
        try {
            Integer.parseInt(textField2.getText());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean chekTextFieldEmpty() {
        if (textField1.getText().equals("") || textField2.getText().equals("")) {
            return true;
        }
        return false;
    }
}