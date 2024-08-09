import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
    private ArrayList<Vertex> vertices;
    public Graph (Scanner input) {
        this.vertices = new ArrayList<>();

        int numVertices = input.nextInt();
        input.nextLine();  // Consume the newline

        // Create vertices
        for (int i = 0; i < numVertices; i++) {
            addVertex();
        }

        // Read edges
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.equals("-1")) break;

            String[] parts = line.split(",");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            addEdge(v1, v2);
        }
        // Print the degree of each vertex for testing
        for (Vertex vertex : vertices) {
            System.out.println(vertex.getVertexNumber() + ":" + vertex.getDegree());
        }

    }

    public static void main(String[] args) {
        // Create a new instance of Graph, which will automatically add vertices and edges
        Scanner input = new Scanner(System.in);
        new Graph(input);
    }

    public void addVertex(){
        Vertex object = new Vertex(vertices.size());
        vertices.add(object);
    }
    public Vertex getVertex (int vertexNumber){
        if (vertexNumber >= 0 && vertexNumber < vertices.size()) {
            return vertices.get(vertexNumber);
        } else {
            throw new IndexOutOfBoundsException("Vertex number out of bounds");
        }
    }
    public void addEdge(int vertexNumber1, int vertexNumber2) {
        Vertex v1 = getVertex(vertexNumber1);
        Vertex v2 = getVertex(vertexNumber2);

        // Add each vertex to the other's adjacency list
        v1.addAdjacency(v2);
        v2.addAdjacency(v1);
    }

}
