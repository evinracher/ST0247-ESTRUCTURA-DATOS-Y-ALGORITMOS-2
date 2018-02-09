
/**
 * 
 * 
 * @author Kevin Parra, Daniel Mesa, Felipe Olaya.
 * @version 08/02/2018 Clase#2
 */
import java.util.ArrayList;
public class TallerCom
{
    
    private ArrayList<String> combinationsAux(String base, String s, ArrayList<String> p)
    {
	//ArrayList<String> combination = new ArrayList<>();
        if(s.length() == 0)
	    {
		p.add(base);
	    }else
	    {   
		combinationsAux(base+s.charAt(0), s.substring(1), p);
		combinationsAux(base, s.substring(1), p);
	    }
	return p;
	
    }
    
    public ArrayList<String> combinations(String s)
    {
	ArrayList<String> p = new ArrayList<>();
        return combinationsAux("", s, p);
    }

    
    public static void main(String[] args )
    {
	TallerCom primero = new TallerCom();
	ArrayList<String> p = primero.combinations("abc");
	for(int i = 0; i < p.size(); i++)
	    {
		System.out.println(p.get(i));
	    }
    }
}
