/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sergi Julia
 */
//Me has plagiado mi trabajo 
public class Modelo_coches {
    String nombre;
    String telefono;
    double modeloCoche;
    double colorCoche;
    double extrasCoche;
    
    //Constructores
    //HasMap, Información + valor
    public Modelo_coches(){

    }
    
    //Constructor Selección del coche, todo
    public Modelo_coches(String nombre, String telefono, double modeloCoche, double colorCoche, double extrasCoche) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.modeloCoche = modeloCoche;
        this.colorCoche = colorCoche;
        this.extrasCoche = extrasCoche;
    }
    //Constructor Selección del coche, si no se ha seleccionado ningúnu extra del coche
    public Modelo_coches(String nombre, String telefono, double modeloCoche, double colorCoche) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.modeloCoche = modeloCoche;
        this.colorCoche = colorCoche;
    }

    //Getter y Setter Nombre y Teléfono
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //Getter y Setter Modelo-Color y Extras del coche
    public double getModeloCoche() {
        return modeloCoche;
    }

    public void setModeloCoche(double modeloCoche) {
        this.modeloCoche = modeloCoche;
    }

    public double getColorCoche() {
        return colorCoche;
    }

    public void setColorCoche(double colorCoche) {
        this.colorCoche = colorCoche;
    }

    public double getExtrasCoche() {
        return extrasCoche;
    }

    public void setExtrasCoche(double extrasCoche) {
        this.extrasCoche = extrasCoche;
    }
    
    //MIS PARÁMETROS
//    public boolean valTelfClient (){
//    
//    }
    //Suma del precio total de seleccionar el modelo del coche(JComboBoc) + el color del coche(JRadioButtons) *Campos obligatorios*
    public double sumModelColor(double modeloCoche, double colorCoche){
        double resultmodelcolor = modeloCoche + colorCoche;
        return resultmodelcolor;
    }
    //Suma del precio anterior (modelo del coche + el color del coche) + extras del coche (JCheckBoxes) *Campos opcionales*
    public double sumModColExras(double sumModelColor, double extrasCoche){
        double restotal = sumModelColor + extrasCoche;
        return restotal;
    }

}
