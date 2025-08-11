package com.futurotech.controller;

import java.util.List;


import com.futurotech.controller.entity.MarcaEntity;
import com.futurotech.controller.entity.TipoMarcacionEntity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
            
            //Asignar la lista observable a la tabla
            tblRegistros.setItems(lstMarca);
 
            
    }

    @FXML
    void registrar(ActionEvent event) {
        String nombre = txtNombre.getText();
        TipoMarcacionEntity tipoMarca = cmbTipoMarcacion.getValue();
        LocalDateTime fechaHora = LocalDateTime.now();
        MarcaEntity objMarca = new MarcaEntity();

        objMarca.setNombre(nombre);
        objMarca.setTipoMarca(tipoMarca);
        objMarca.setFechaHora(fechaHora);
          
        lstMarca.add(objMarca);
    }

}
