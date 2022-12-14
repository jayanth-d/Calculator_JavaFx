package com.example.calculater;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    public void initialize(){
        add.setDisable(true);
        minus.setDisable(true);
        multiply.setDisable(true);
        divide.setDisable(true);
    }
    @FXML
    Button add;
    @FXML
    Button minus;
    @FXML
    Button multiply;
    @FXML
    Button divide;
    @FXML
    TextField textField1;
    @FXML
    TextField textField2;
    @FXML
    Label result;
    @FXML//if you don't want to use the annotation make the method public
    protected void onClick(ActionEvent e){
        try {
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());
            if(e.getSource().equals(add)){
                result.setText("The Sum : "+(num1+num2));
            } else if (e.getSource().equals(minus)) {
                result.setText("The Difference : "+(num1-num2));
            }else if(e.getSource().equals(multiply)){
                result.setText("The Product "+(num1*num2));
            } else if (e.getSource().equals(divide)) {
                if(num2 != 0) {
                    result.setText("The Quotient : " + (num1 / num2));
                }else {
                    result.setText("Division Not Possible");
                }
            }
        }catch (NumberFormatException i){
            result.setText("Enter only Integers!!!");
        }
    }

    @FXML
    protected void listenToTextField(){
        String text1 = textField1.getText();
        String text2 = textField2.getText();
        boolean disable = (text1.isEmpty()||text1.trim().isEmpty())||(text2.isEmpty()||text2.trim().isEmpty());
        add.setDisable(disable);
        minus.setDisable(disable);
        multiply.setDisable(disable);
        divide.setDisable(disable);
    }
}