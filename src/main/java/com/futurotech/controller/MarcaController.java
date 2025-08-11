package com.futurotech.controller;

import java.util.List;
import java.util.Optional;

import com.futurotech.controller.entity.MarcaEntity;
import com.futurotech.controller.entity.TipoMarcacionEntity;
import com.futurotech.dao.MarcaDAO;
import com.futurotech.model.marcadorModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MarcaController {

    @FXML
    private Button btnRegistrar;

    @FXML
    private ComboBox<TipoMarcacionEntity> cmbTipoMarcacion;

    @FXML
    private TableColumn<MarcaEntity, String > colFechaHora;

    @FXML
    private TableColumn<MarcaEntity, String> colNombre;

    @FXML
    private TableColumn<MarcaEntity, TipoMarcacionEntity > colTipoMarcacion;

    @FXML
    private TableView<MarcaEntity> tblRegistros;

    @FXML
    private TextField txtNombre;

    private ObservableList <MarcaEntity> lstMarca = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        //Columnas y combo

        MarcaDAO marcaDAO = new MarcaDAO();
        List<marcadorModel> marcasGuardadas = marcaDAO.obtenerTodas();
        for (marcadorModel marcador : marcasGuardadas) {
            MarcaEntity marcaEntity = new MarcaEntity();
            marcaEntity.setNombre(marcador.getNombre());
            marcaEntity.setFechaHora(LocalDateTime.parse(marcador.getFechaHora()));
            TipoMarcacionEntity tipoMarca = new TipoMarcacionEntity();
            tipoMarca.setTipoMarca(marcador.getTipoMarcacion());
            marcaEntity.setTipoMarca(tipoMarca);
            lstMarca.add(marcaEntity);
        }

        tblRegistros.setItems(lstMarca);
        llenarComboTipoMarcacion();
        //Configurar las columnas de la tabla
        colNombre.setCellValueFactory(new PropertyValueFactory<MarcaEntity, String>("nombre"));
        colTipoMarcacion.setCellValueFactory(new PropertyValueFactory<MarcaEntity, TipoMarcacionEntity>("tipoMarca"));
        colFechaHora.setCellValueFactory(new  PropertyValueFactory<MarcaEntity, String>("fechaHoraFormateada"));


        llenarComboTipoMarcacion()
        ;}
          private void llenarComboTipoMarcacion() {
            List<TipoMarcacionEntity> lstTipoMarca = new ArrayList <TipoMarcacionEntity>();

            TipoMarcacionEntity objTipoMarcacion = new TipoMarcacionEntity();
            objTipoMarcacion.setTipoMarca("Entrada");
            lstTipoMarca.add(objTipoMarcacion);
            objTipoMarcacion = new TipoMarcacionEntity();
            objTipoMarcacion.setTipoMarca("Salida");
            lstTipoMarca.add(objTipoMarcacion);
            cmbTipoMarcacion.getItems().addAll(lstTipoMarca);
            
           

      
            
    }

    @FXML
    void registrar(ActionEvent event) {
        try {
            String nombre = txtNombre.getText();
            TipoMarcacionEntity tipoMarca = cmbTipoMarcacion.getValue();

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }
            if (tipoMarca == null) {
                throw new IllegalArgumentException("Debe seleccionar un tipo de marcación.");
            }
            Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
            confirmDialog.setTitle("Confirmar registro");
            confirmDialog.setHeaderText("¿Está seguro de registrar esta marca?");
            confirmDialog.setContentText("Nombre: " + nombre + "\nTipo: " + tipoMarca);
            
            Optional<ButtonType> result = confirmDialog.showAndWait();
            if (result.isPresent()&& result.get()==ButtonType.OK) {
                LocalDateTime fechaHora = LocalDateTime.now();
                MarcaEntity objMarca = new MarcaEntity();
                objMarca.setNombre(nombre);
                objMarca.setFechaHora(fechaHora);
                objMarca.setTipoMarca(tipoMarca);
                lstMarca.add(objMarca);
                tblRegistros.setItems(lstMarca);

                //Llenar el objeto marcadorModel
                marcadorModel marcador = new marcadorModel();
                marcador.setNombre(nombre);
                marcador.setTipoMarcacion(tipoMarca.getTipoMarca());
                marcador.setFechaHora(fechaHora.toString());
                marcador.setFeCreacion(LocalDate.now());
                marcador.setUsrCreacion("admin");
                txtNombre.clear();         
                //Invocar al DAO para insertar el registro
                MarcaDAO marcaDAO = new MarcaDAO();  
                marcaDAO.insertar(marcador);
                

            }
            } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de validación");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();


} 
       

}

}
