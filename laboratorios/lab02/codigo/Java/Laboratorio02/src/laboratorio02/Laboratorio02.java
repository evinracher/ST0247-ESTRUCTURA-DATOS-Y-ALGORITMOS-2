package laboratorio02;

/**
 *
 * @author Kevin Parra, Daniel Mesa
 */
public class Laboratorio02 {

    /**
     * main para ejecucion del programa
     */
    public static void main(String[] args) {
        for(int i = 4; i <= 34; i++)
        {
            System.out.println("tiempo en milisegundos " + i+"= " +Taller2.tomarTiempo(i));
        }
    }
}
