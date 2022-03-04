/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication30;

/**
 *
 * @author Lucia Cristiani
 * @version 1.0
 */
public class Fecha {

    private int dia;
    private int mes;
    private int año;

    /*
    * Constructor por defecto
    
    */
    
    public Fecha() {
    }

    /**
    * Constructor con parámetros
    * @param dia para obtener el día de nacimiento de la persona
    * @param mes para obtener el mes de nacimiento de la persona
    * @param año para obtener el año de nacimiento de la persona
    */
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    /**
    * Métodos getters y setters
    
    */
    public void setDia(int d) {
        dia = d;
    }

    public void setMes(int m) {
        mes = m;
    }

    public void setAño(int a) {
        año = a;
    }
    /*
    * @ return dia devuelve el dia de nacimiento
    */
    
    public int getDia() {
        return dia;
    }
   
    /**
     * @return mes devuelve el mes de nacimiento
     */
    public int getMes() {
        return mes;
    }
    // Método getter
    /**
     * 
     * @return año devuelve el año de nacimiento
     * 
     */
    public int getAño() {
        return año;
    }

    
    /**
    * Comprobar si la fecha es correcta
    */
   
    public boolean fechaCorrecta() {
        boolean diaCorrecto, mesCorrecto, añoCorrecto;
        añoCorrecto = año > 0;
        mesCorrecto = mes >= 1 && mes <= 12;
        switch (mes) {
            case 2:
                if (esBisiesto()) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && añoCorrecto;
    }

    /**
    * Comprobar si el año es bisiesto
    */
    
    private boolean esBisiesto() {
        return (año % 4 == 0 && año % 100 != 0 || año % 400 == 0);
    }

    /**
     *  Calcula el dia siguiente
     */
    public void diaSiguiente() {
        dia++;
        if (!fechaCorrecta()) {
            dia = 1;
            mes++;
            if (!fechaCorrecta()) {
                mes = 1;
                año++;
            }

        }
    }

    /**
    * Método para comprobar si la fecha es mayor que la que se recibe 
    * @param f variable tipo Fecha que tiene dentro dia, mes, año
    * 
    */ 
    
  
    
    public boolean esMayorQue(Fecha f) {
        if (año > f.año) {
            return true;
        } else if (año == f.año && mes > f.mes) {
            return true;
        } else if (año == f.año && mes == f.mes && dia > f.dia) {
            return true;
        }
        return false;
    }

    /**
    * Método toString para mostrar la fecha
    
    */
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (dia < 10) {
            sb.append("0");
        }
        sb.append(dia);
        sb.append("-");
        if (mes < 10) {
            sb.append("0");
        }
        sb.append(mes);
        sb.append("-");

        sb.append(año);
        return sb.toString();
    }
} 
