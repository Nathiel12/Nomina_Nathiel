package com.nathiel.nomina;

import com.fasterxml.jackson.databind.deser.impl.PropertyValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class NominaController {

    private GuardarEmpleado Archivo= new GuardarEmpleado("data/Empleados.json");
    private ObservableList<Empleado> empleadosObservable = FXCollections.observableArrayList();
    private double salarioNeto;

    @FXML
    private TableView<Empleado> TableViewEmpleado;

    @FXML
    private TableColumn<Empleado, String> colApellido;

    @FXML
    private TableColumn<Empleado, String> colBanco;

    @FXML
    private TableColumn<Empleado, String> colCargo;

    @FXML
    private TableColumn<Empleado, String> colCedula;

    @FXML
    private TableColumn<Empleado, Double> colISR;

    @FXML
    private TableColumn<Empleado, String> colNombre;

    @FXML
    private TableColumn<Empleado, Double> colSFS;

    @FXML
    private TableColumn<Empleado, Double> colSalarioBR;

    @FXML
    private TableColumn<Empleado, Double> colSalarioNeto;

    @FXML
    private TabPane tabPane;

    @FXML
    private TextField Apellido;

    @FXML
    private TextField NumeroCuenta;

    @FXML
    private ComboBox<String> Banco;

    @FXML
    private ComboBox<String> Forma_Contacto;

    @FXML
    private ComboBox<String> Tipo_Cuenta;

    @FXML
    private TextField Cargo;

    @FXML
    private TextField Cedula;

    @FXML
    private TextField CodigoEmpleado;

    @FXML
    private TextField Telefono;

    @FXML
    private TextField Email;

    @FXML
    private TextField Fax;

    @FXML
    private Button Limpiar;

    @FXML
    private TextField Nombre;

    @FXML
    private Tab PaginaConsultar;

    @FXML
    private Tab PaginaRegistro;

    @FXML
    private Button Registrar;

    @FXML
    private TextField Salario;


    @FXML
    void OnClickBancos(ActionEvent event) {

    }

    @FXML
    void OnClickLimpiar(ActionEvent event) {
        Apellido.clear();
        Nombre.clear();
        Cargo.clear();
        Cedula.clear();
        Banco.getSelectionModel().clearSelection();
        Salario.clear();
        NumeroCuenta.clear();
        Forma_Contacto.getSelectionModel().clearSelection();
        Tipo_Cuenta.getSelectionModel().clearSelection();
        Email.clear();
        Telefono.clear();
        Fax.clear();
        CodigoEmpleado.clear();
    }

    @FXML
    void OnClickRegistrar(ActionEvent event) {
        String formaSeleccionada=Forma_Contacto.getSelectionModel().getSelectedItem();
        String tipoSeleccionado=Tipo_Cuenta.getSelectionModel().getSelectedItem();

        String bancoSeleccionado = Banco.getSelectionModel().getSelectedItem();

        Empleado nuevoEmpleado = new Empleado(
        Nombre.getText(),
        Cedula.getText(),
        Double.parseDouble(Salario.getText()),
        Cargo.getText(),
        Apellido.getText(),
        bancoSeleccionado,
        salarioNeto,
        NumeroCuenta.getText(),
        Email.getText(),
        Telefono.getText(),
        Fax.getText(),
        CodigoEmpleado.getText(),
        tipoSeleccionado,
        formaSeleccionada
        );

        empleadosObservable.add(nuevoEmpleado);
        Archivo.agregarEmpleado(nuevoEmpleado);

    }

    @FXML
    void OnClickTabConsultar(Event event) {
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
    }

    @FXML
    void OnClickTabRegistro(Event event) {
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
    }

    @FXML
    void TFApellido(ActionEvent event) {

    }
    @FXML
    void TFNumeroCuenta(ActionEvent event) {

    }

    @FXML
    void TFCargo(ActionEvent event) {

    }

    @FXML
    void TFCedula(ActionEvent event) {

    }

    @FXML
    void TFNombre(ActionEvent event) {

    }

    @FXML
    void TFSalario(ActionEvent event) {

    }
    @FXML private void initialize(){
        Banco.getItems().addAll("Banco BHD", "Banco Popular","BanReservas");
        Forma_Contacto.getItems().addAll("Email", "Telefono", "Fax");
        Tipo_Cuenta.getItems().addAll("CC","CA", "TC", "TD","PRESTAMO","CHEQUE","CUENTA_CONTABLE");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colSalarioBR.setCellValueFactory(new PropertyValueFactory<>("salario"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colSFS.setCellValueFactory(new PropertyValueFactory<>("SFS"));
        colISR.setCellValueFactory(new PropertyValueFactory<>("ISR"));
        colSalarioNeto.setCellValueFactory(new PropertyValueFactory<>("salarioNeto"));
        colBanco.setCellValueFactory(new PropertyValueFactory<>("banco"));

        TableViewEmpleado.setItems(empleadosObservable);
    }
}