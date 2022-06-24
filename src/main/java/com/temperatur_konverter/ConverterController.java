package com.temperatur_konverter;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

public class ConverterController {

   @FXML
   private Button convert;

   @FXML
   private Label errorMessage, result;

   @FXML
   private TextField inputNumber;

   @FXML
   private RadioButton fahrenheit, celsius;

   @FXML
   private ToggleGroup values;


   @FXML 
   private void test(){

    if (fahrenheit.isSelected()) {
        
        errorMessage.setText("Test Fahrenheit erfolgreich");
    } else if (celsius.isSelected()){
        
        result.setText("Text Celsius erfolgreich");
    }
    
   }

   @FXML
   private void converter(){
    errorMessage.setVisible(false);
    result.setVisible(false);
    celsius.setStyle("");
    fahrenheit.setStyle("");
    
    try {
        double userInput = Double.parseDouble(inputNumber.getText().toString());
        result.setVisible(true);
        if (fahrenheit.isSelected()) {
            double fahrenheitResult =  userInput * 1.8 +32;
            BigDecimal bd = new BigDecimal(String.valueOf(fahrenheitResult));
            BigDecimal fahrenheitResultRounded = bd.setScale(1, RoundingMode.FLOOR);
            result.setText(fahrenheitResultRounded+" °Fahrenheit");
        } else if (celsius.isSelected()){
            double celsiusResult = (userInput - 32) * 5/9;
            BigDecimal bd = new BigDecimal(String.valueOf(celsiusResult));
            BigDecimal celsiusResultRounded = bd.setScale(1, RoundingMode.FLOOR);
            result.setText(celsiusResultRounded +" °Celsius");
        } else{
            result.setVisible(false);
            errorMessage.setVisible(true);
            errorMessage.setText("Bitte Auswahl treffen!");
            celsius.setStyle("-fx-border-color: red");
            fahrenheit.setStyle("-fx-border-color: red");
            
        }
        
    } catch (Exception e) {
        errorMessage.setVisible(true);
       errorMessage.setText("Bitte eine gültige Zahl eingeben!");
    }
   }



}
