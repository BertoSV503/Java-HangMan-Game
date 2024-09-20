import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) throws Exception {

        // Objeto Scanner que leera los datos ingresados por el usuario
        Scanner scanner = new Scanner(System.in);

        // Declaracion y asignacion de variables
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intento = 0;
        boolean palabraAdivinada = false;

        // Arreglos:
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // Bucle
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
            System.out.print(letrasAdivinadas[i]);
        }

        while (!palabraAdivinada && intento < intentosMaximos) {

            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas));

            System.out.println("Introduce una letra por favor: ");
            char letra = scanner.next().charAt(0);

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }

            }

            if(!letraCorrecta){
                intento++;
                System.out.println("INCORRECTO! Te quedan " + (intentosMaximos - intento) + " intentos.");
            }

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("FELICIDADES! Has adivinado la palabra secreta: " + palabraSecreta);
            }

        }

        if(!palabraAdivinada){
            System.out.println("Te has quedado sin intentos! GAME OVER");
        }

        scanner.close();

    }
}