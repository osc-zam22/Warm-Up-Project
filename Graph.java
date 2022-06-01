public class Graph {
    
    private int [][] matrix;

    public Graph(int numVert)
    {
        this.matrix = new int [numVert][numVert];
    }

    public void setEdgeWeight(int weight , int vertex1 , int vertex2)
    {
        matrix[vertex1][vertex2] = weight;
    }

    public int getWeight(int vertex1 , int vertex2)
    {
        return matrix[vertex1][vertex2];
    }
}
