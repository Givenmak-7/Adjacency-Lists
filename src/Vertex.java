import java.util.ArrayList;
import java.util.LinkedList;

public class Vertex {

    int vertexNumber;
    int colour;
    LinkedList<Vertex> adjacencies;

    public Vertex(int number) {
        this.vertexNumber = number;
        this.adjacencies = new LinkedList<>();
    }


    public  void addAdjacency (Vertex object){
        adjacencies.add(object);
    }
    public boolean isAdjacency (Vertex object){
        return adjacencies.contains(object);
    }

    public int getDegree (){
        return adjacencies.size();
    }

    public int getVertexNumber(){
        return vertexNumber;
    }
}