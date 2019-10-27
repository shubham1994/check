import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DFS {

	private LinkedList<Integer> adj[];
	int V;
	int[] arr = new int[50];
	int count = 0;

	/**
	 * @param v
	 */
	public DFS(int v) {
		this.V = v;
		adj = new LinkedList[100];

		for (int i = 0; i < 100; i++) {
			adj[i] = new LinkedList();
		}
	}

	public void add(int i, int j) {
		adj[i].add(j);
		adj[j].add(i);
	}
	
	
	void DFSUtil(int v, boolean[] visited) { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        //System.out.print(v+" "); 
        // Recur for all the vertices 
        // adjacent to this vertex 
      Iterator<Integer> i = adj[v].iterator();
      
      while(i.hasNext())
      {
    	  int n = i.next();
    	  if(!visited[n])
    		  DFSUtil(n,visited);
        } 
  
    } 

	void connectedComponents() { 
        // Mark all the vertices as not visited 
        boolean[] visited = new boolean[100];
        int c =0;
        for(int v = 1; v <= V; v++) {
        	
        	//System.out.println(visited[v]);
            
        	if(!visited[v]) { 
                // print all reachable vertices 
                // from vc++ 
                c++;
            	DFSUtil(v,visited); 
                System.out.println(); 
            } 
        } 
        
        if(c==1)
        {
        	System.out.println(1);
        }
        else
        {
        	System.out.println(0);
        	System.out.println(c);
        }
        
    } 
     	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("enter the no of nodes");

		Scanner sc = new Scanner(System.in);

		int no = sc.nextInt();

		DFS d = new DFS(no);

		System.out.println("enter the no of edges");
		int edges = sc.nextInt();

		for (int i = 0; i < edges; i++) {
			int e1 = sc.nextInt();
			int e2 = sc.nextInt();
			d.add(e1, e2);
		}

		 d.connectedComponents();
	}

}
