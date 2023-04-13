
import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        // 1.a) Dado un String y una letra, que cuente la cantidad de apariciones de la letra en el String
        String texto = "Este es un hermoso texto con 91 caracteres alfanumericos sin acentos y un caracter especial.".toLowerCase();
        char letra = 'e';

        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == letra) {
                contador++;
            }
        }

        System.out.println("Se encuentran " + contador + " repeticiones del carácter '" + letra + "'.");

        // 1.b) Dados 3 números y un orden (ascendente o decreciente) que ordene los mismos y los retorne en un vector de 3
        int num1 = 9;
        int num2 = 2000000000;
        int num3 = 15;
        char orden = 'd';


        if (orden == 'a') {
            System.out.print("Orden ascendente: ");
        } else {
            System.out.print("Orden descendente: ");
        }

        int[] arrayDevuelto = ordenarValores(num1, num2, num3, orden);
        System.out.println(Arrays.toString(arrayDevuelto));

        // 1.c) c. Dado un vector de números, y un número X, que sume todos los números > X y retorne el resultado
        int[] vector = leerNumeros(25, 3, 72);
        int sumarMayores = 48;

        int suma = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > sumarMayores) {
                suma += vector[i];
            }
        }

        System.out.println("Arreglo " + Arrays.toString(vector) + "\nMayores al número " + sumarMayores + " suma: " + suma);

        // 2) Genere una clase que tenga los métodos para realizar la “codificación” y decodificación de un string, dado un número de desplazamiento.

        String abecedario = "abcdefghijklmnñopqrstuvwxyz ";
        String textoACodificar = "Este es un hermoso texto al que se le van a quitar las mayusculas y va a ser codificado";
        textoACodificar = textoACodificar.toLowerCase();
        int desplazamiento = 3;

        String textoCodificado = coDeCodificar(abecedario, textoACodificar, desplazamiento, true);
        String textoDecodificado = coDeCodificar(abecedario, textoCodificado, desplazamiento, false);

        System.out.println("El texto \""+textoACodificar+"\"\nFue codificado a: \""+textoCodificado +"\"\nY nuevamente decodificado a: \""+textoDecodificado+"\"");

        // 3) Realizar el ejercicio 1 (De esta misma guía) enviando los valores por parámetro.
        System.out.println("----- Ejercicio 3 -----");
        // 3.a) Dado un String y una letra, que cuente la cantidad de apariciones de la letra en el String
        String texto3 = args[0];
        char letra3 = args[1].charAt(0);

        int contador3 = 0;
        for (int i = 0; i < texto3.length(); i++) {
            if (texto3.charAt(i) == letra3) {
                contador3++;
            }
        }

        System.out.println("Se encuentran " + contador3 + " repeticiones del carácter '" + letra3 + "'.");

        // 3.b) Dados 3 números y un orden (ascendente o decreciente) que ordene los mismos y los retorne en un vector de 3
        int num13 = Integer.parseInt(args[2]);
        int num23 = Integer.parseInt(args[3]);
        int num33 = Integer.parseInt(args[4]);
        char orden3 = args[5].charAt(0);

        if (orden3 == 'a') {
            System.out.print("Orden ascendente: ");
        } else {
            System.out.print("Orden descendente: ");
        }

        int[] arrayDevuelto3 = ordenarValores(num13, num23, num33, orden3);
        System.out.println(Arrays.toString(arrayDevuelto3));

        // 3.c) c. Dado un vector de números, y un número X, que sume todos los números > X y retorne el resultado
        int[] vector3 = leerNumeros(Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]));
        int sumarMayores3 = Integer.parseInt(args[9]);

        int suma3 = 0;
        for (int i = 0; i < vector3.length; i++) {
            if (vector3[i] > sumarMayores3) {
                suma3 += vector3[i];
            }
        }

        System.out.println("Arreglo " + Arrays.toString(vector3) + "\nMayores al número " + sumarMayores3 + " suma: " + suma3);
    }

    /* Reciclado de ejercicio 2 */
    static int[] ordenarValores(int a, int b, int c, char orden) {
        int[] respuesta;
        boolean esAscendente = (orden == 'a');

        if (estaOrdenado(a, b, esAscendente) && estaOrdenado(a, c, esAscendente)) {
            if (estaOrdenado(b, c, esAscendente)) {
                respuesta = new int[]{a, b, c};
            } else {
                respuesta = new int[]{a, c, b};
            }
        } else if (estaOrdenado(b, a, esAscendente) && estaOrdenado(b, c, esAscendente)) {
            if (estaOrdenado(a, c, esAscendente)) {
                respuesta = new int[]{b, a, c};
            } else {
                respuesta = new int[]{b, c, a};
            }
        } else if (estaOrdenado(a, b, esAscendente)) {
            respuesta = new int[]{c, a, b};
        } else {
            respuesta = new int[]{c, b, a};
        }
        return respuesta;
    }

    static boolean estaOrdenado(int a, int b, boolean ascendente) {
        return ((ascendente && a < b) || (!ascendente && a > b));
    }

    static int[] leerNumeros(int cantidadDeNumeros, int min, int max) {
        int[] numeros = new int[cantidadDeNumeros];

        Random rand = new Random();
        for (int i = 0; i < cantidadDeNumeros; i++) {
            numeros[i] = rand.nextInt((max - min) + 1) + min;
        }

        return numeros;
    }

    static String coDeCodificar(String abecedario, String textoACodificar, int desplazamiento, boolean codificar) {
        String resultado = "";
        for (int i = 0; i < textoACodificar.length(); i++) {
            char caracterDelTexto = textoACodificar.charAt(i);
            int desplazamientoDelTexto;
            if (codificar)
                desplazamientoDelTexto = (desplazamiento + abecedario.indexOf(caracterDelTexto)) % abecedario.length();
            else
                desplazamientoDelTexto = (abecedario.length() + abecedario.indexOf(caracterDelTexto) - desplazamiento) % abecedario.length();
            resultado += abecedario.charAt(desplazamientoDelTexto);
        }
        return resultado;
    }
}
