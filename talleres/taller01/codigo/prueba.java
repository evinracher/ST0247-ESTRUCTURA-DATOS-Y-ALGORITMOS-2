/**
 *
 * @author Kevin
 */
public class prueba {
    
    public static void main(String args[]){
        DigraphAL graph = new DigraphAL(3);
        graph.addArc(0, 0, 1);
	System.out.println("Pruebas\nPruebas de obtener peso");
        System.out.println("Peso: "+graph.getWeight(0, 0));
        System.out.println("Peso: "+graph.getWeight(1, 0));
    }
    
    
    
    
}
