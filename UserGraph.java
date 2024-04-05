package queuecode2;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class UserGraph {
	 LinkedList<Integer>[] adj; 
	int V; 
    // Constructor 
    public UserGraph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i = 0; i < v; i++) 
            adj[i] = new LinkedList<Integer>(); 
    } 
  
	// We use Hashmap to store the edges in the graph
	private Map<SignUp, List<SignUp>> map = new HashMap<>();
	SignUp s = new SignUp();

	// new vertex to the graph
	public void addVertex(SignUp s) {
		map.put(s, new LinkedList<SignUp>());
	}
	// This function adds the edge

	public void addEdge(SignUp i, SignUp j, boolean bidirectional) {
		if (!map.containsKey(i))
			addVertex(i);
		if (!map.containsKey(j))
			addVertex(j);
		map.get(i).add(j);
		if (bidirectional == true) {
			map.get(j).add(i);
		}
	}

	// This function gives the count of vertices
	public void getVertexCount() {
		System.out.println("The graph has " + map.keySet().size() + " vertex");
	}

	// This function gives the count of edges
	public void getEdgesCount(boolean bidirection) {
	int count = 0;
		for (SignUp v : map.keySet()) {
			count += map.get(v).size();
		}
		if (bidirection == true) {
			count = count / 2;
		}
		System.out.println("The graph has " + count + " edges.");
	}

	// This function gives whether
	// a vertex is present or not.
	public void hasVertex(SignUp s) {
		if (map.containsKey(s)) {
			System.out.println("The graph contains " + s + " as a vertex.");
		} else {
			System.out.println("The graph does not contain " + s + " as a vertex.");
		}
	}

	// This function gives whether an edge is present or not.
	public void hasEdge(SignUp s, SignUp d) {
		if (map.get(s).contains(d)) {
			System.out.println("The graph has an edge between " + s + " and " + d + ".");
		} else {
			System.out.println("The graph has no edge between " + s + " and " + d + ".");
		}
	}

	public void bfs(Queue queue, Boolean[] visited, int[] parent) {
		SignUp current = queue.poll();
		for (int i : adj[current]) {
			// If adjacent vertex is not visited earlier
			// mark it visited by assigning true value
			if (!visited[i]) {
				// set current as parent of this vertex
				parent[i] = current;
				// Mark this vertex visited
				visited[i] = true;
				// Push to the end of queue
				queue.add(i);
			}
		}
	}

	public int isIntersecting(Boolean[] s_visited, Boolean[] t_visited) {
		for (int i = 0; i < V; i++) {
// if a vertex is visited by both front 
// and back BFS search return that node 
// else return -1 
			if (s_visited[i] && t_visited[i])
				return i;
		}
		return -1;
	}

	public void printPath(int[] s_parent, int[] t_parent, SignUp s, int t, int intersectNode) {
		LinkedList<Integer> path = new LinkedList<Integer>();
		path.add(intersectNode);
		i = intersectNode;
		while (i != s) {
			path.add(s_parent[i]);
			i = s_parent[i];
		}
		Collections.reverse(path);
		i = intersectNode;
		while (i != t) {
			path.add(t_parent[i]);
			i = t_parent[i];
		}
		System.out.println("*****Path*****");
		for (int it : path)
			System.out.print(it + " ");
		System.out.println();
	}

// Method for bidirectional searching 
	public SignUp biDirSearch(SignUp s, SignUp t) {
// Booleanean array for BFS started from 
// source and target(front and backward BFS) 
// for keeping track on visited nodes 
		Boolean[] s_visited = new Boolean[V];
		Boolean[] t_visited = new Boolean[V];
// Keep track on parents of nodes 
// for front and backward search 
		int[] s_parent = new int[V];
		int[] t_parent = new int[V];
// queue for front and backward search 
		Queue<Integer> s_queue = new LinkedList<Integer>();
		Queue<Integer> t_queue = new LinkedList<Integer>();
		int intersectNode = -1;
// necessary initialization 
		for (int i = 0; i < V; i++) {
			s_visited[i] = false;
			t_visited[i] = false;
		}
		s_queue.add(s);
		s_visited[s] = true;
// parent of source is set to -1 
		s_parent[s] = -1;
		t_queue.add(t);
		t_visited[t] = true;
// parent of target is set to -1 
		t_parent[t] = -1;
		while (!s_queue.isEmpty() && !t_queue.isEmpty()) {
// Do BFS from source and target vertices 
			bfs(s_queue, s_visited, s_parent);
			bfs(t_queue, t_visited, t_parent);
// check for intersecting vertex 
			intersectNode = isIntersecting(s_visited, t_visited);
// If intersecting vertex is found 
// that means there exist a path 
			if (intersectNode != -1) {
				System.out.printf("Path exist between %d and %d\n", s, t);
				System.out.printf("Intersection at: %d\n", intersectNode);
				// print the path and exit the program
				printPath(s_parent, t_parent, s, t, intersectNode);
				System.exit(0);
			}
		}
		return -1;
	}
}
