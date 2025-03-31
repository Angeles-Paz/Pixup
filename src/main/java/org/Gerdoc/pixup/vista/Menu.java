package org.Gerdoc.pixup.vista;

public class Menu {

    public static void principal() {
        System.out.println( "welcome");
        System.out.println( "Selecciona una opción");
        System.out.println( "1.- Consola");
        System.out.println( "2.- Ventana");
        System.out.println( "3.- Salir");
    }
    public static void menu() {
        System.out.println( "Selecciona una opción");
        System.out.println( "1.- Catalogo");
        System.out.println( "2.- Pendiente");
        System.out.println( "3.- Salir");
    }
    public static void catalogo() {
        System.out.println( "Selecciona una opción");
        System.out.println( "1.- Estado");
        System.out.println( "2.- Municipio");
        System.out.println( "3.- Colonia");
        System.out.println( "4.- Domicilio");
        System.out.println( "5.- Salir");
    }
    public static void datos() {
        System.out.println( "Selecciona una opción");
        System.out.println( "1.- Alta");
        System.out.println( "2.- Baja");
        System.out.println( "3.- Cambio");
        System.out.println( "4.- Consulta");
        System.out.println( "5.- Salir");
    }

    public static void opcionInvalida() {
        System.out.println("Opción invalida");
    }
    public static void  Ventana(){
        System.out.println("Ventana aun no disponible");
    }
    public static void  Pendiente(){
        System.out.println("Opciones aun  no disponibles");
    }
    public static void Id() {
        System.out.println("Ingrese el id");
    }
    public static void IDUsuario(){
        System.out.println("Ingrese el id del usuario");
    }
    public static void IDColonia(){
        System.out.println("Ingrese el id de la colonia");
    }
    public static void IDTipoDomicilio() {
        System.out.println("Ingrese el del tipo de domicilio ");
    }
    public static void nombre() {
        System.out.println("Ingrese el nombre");
    }
    public static void cp() {
        System.out.println("Ingrese el codigo postal");
    }
    public static void calle(){
        System.out.println("Ingrese la calle");
    }
    public static void numExterior(){
        System.out.println("Ingresa el número exterior");

    }
    public static void numInterior(){
        System.out.println("Ingresa el número interior");

    }
}