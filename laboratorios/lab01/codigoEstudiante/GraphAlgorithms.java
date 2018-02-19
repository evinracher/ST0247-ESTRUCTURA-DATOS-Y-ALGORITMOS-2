import java.util.ArrayList;
    
public class GraphAlgorithms{
    public int moreEdges(Digraph d){
	int mayor = 0;
	for(int i = 1; i < d.size(); ++i){
	    ArrayList<Integer> s = d.getSuccessors(i);
	    if(s.size() > d.getSuccessors(mayor).size()){
		mayor = s.size();
	    }
	}
	return mayor;
    }
}
