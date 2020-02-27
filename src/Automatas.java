// Nombre completo con mayusculas la primera letra, almenos 1 nombre y 2 apellidos.

import java.util.regex.*;
import java.util.Scanner;
public class Automatas {

    public static void main(String[] args) {
        System.out.println(evaluarCadena());
    }

    public static String recibirCadena() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nombre completo:\n");
        String nombre = scan.nextLine();
        System.out.println("nombre.matches('([A-Z][a-z]+\\s{1})+([A-Z][a-z]+\\s{1})*([A-Z][a-z]+\\s{1})+([A-Z][a-z]+)+'): "+nombre.matches("([A-Z][a-z]+\\s{1})+([A-Z][a-z]+\\s{1})*([A-Z][a-z]+\\s{1})+([A-Z][a-z]+)+"));
        return nombre;
    }

    public static String evaluarCadena(){

        boolean sonParientes = false;
        boolean sonTocayo = false;

        String nombre1 = Automatas.recibirCadena();
        String nombre2 = Automatas.recibirCadena();

        String eliminaEspacio = "\\s";
        Pattern pattern = Pattern.compile(eliminaEspacio, Pattern.CASE_INSENSITIVE);
        String[] cadenas = pattern.split(nombre1);
        int count = cadenas.length;
        switch (count){
            case 3:
                if (Pattern.matches(".*"+cadenas[0]+".*", nombre2)){
                    sonTocayo = true;
                }
                if (Pattern.matches(".*"+cadenas[1]+".*", nombre2)){
                    sonParientes = true;
                }
                if (Pattern.matches(".*"+cadenas[2]+".*", nombre2)){
                    sonParientes = true;
                }
                break;
            case 4:
                if (Pattern.matches(".*"+cadenas[0]+".*", nombre2)){
                    sonTocayo = true;
                }
                if (Pattern.matches(".*"+cadenas[1]+".*", nombre2)){
                    sonTocayo = true;
                }
                if (Pattern.matches(".*"+cadenas[2]+".*", nombre2)){
                    sonParientes = true;
                }
                if (Pattern.matches(".*"+cadenas[3]+".*", nombre2)){
                    sonParientes = true;
                }
                break;
            default:
                break;
        }
        if (sonTocayo && sonParientes){
            System.out.println("Tocayos y parientes");
        } else if (sonTocayo){
            System.out.println("Tocayos");
        } else if (sonParientes){
            System.out.println("Parientes");
        }


        String arreglo = nombre1+'\n'+nombre2;

        return arreglo;
    }

}


/*
 * find encuentra la ocurrencua de la expresion regular o la cadena
 * start donde inicia de la primera aparicion
 * end donde termina la ultima aparicion
 * */

