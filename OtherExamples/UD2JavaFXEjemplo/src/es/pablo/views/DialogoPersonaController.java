package es.pablo.views;

import es.pablo.logica.Logica;
import es.pablo.models.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DialogoPersonaController extends BaseController {

    private Persona personaModificar;


    @FXML
    private Button altaButton;

    @FXML
    private TextField nombreTf;

    @FXML
    private TextField apellidosTf;


    @FXML
    void altaModificarPersona(ActionEvent event) {
        //Diferenciamos el caso de si queremos modificar o alta
        //En este caso es una modificación porque tenemos algo en personaModificar
        if (personaModificar!=null)
        {
            personaModificar.setNombre(nombreTf.getText());
            personaModificar.setApellidos(apellidosTf.getText());
            Logica.getInstance().modificarPersona(personaModificar);
        }
        else {
            Persona persona = new Persona(nombreTf.getText(), apellidosTf.getText());
            Logica.getInstance().addPersona(persona);
        }
        //Como obtener un Stage desde un evento
        Stage stage = getStage();
        stage.close();
    }

    public void setPersonaModificar(Persona personaModificar)
    {
        this.personaModificar = personaModificar;
        nombreTf.setText(personaModificar.getNombre());
        apellidosTf.setText(personaModificar.getApellidos());
    }

}