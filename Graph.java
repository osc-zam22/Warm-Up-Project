import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Graph {
    
    private double [][] matrix;

    public Graph(int numVert)
    {
        this.matrix = new double [numVert][numVert];
    }

    public void setEdgeWeight(double weight , int vertex1 , int vertex2)
    {
        matrix[vertex1][vertex2] = weight;
    }

    public double getWeight(int vertex1 , int vertex2)
    {
        return matrix[vertex1][vertex2];
    }
    public double[][] getMatrix()
    {
        return this.matrix;
    }

    public void setEdge( int city, int connection , Double weight)
    {
        this.matrix[city][connection] = weight; 
    }

    // public void printGraph(List<City> database)
    // {
    //     for(int i = 0 ; i < database.size() ; i++ )
    //     {
    //         System.out.printf("The distances between %s the other Cities is: \n"
    //                      , database.get(i));
    //         for (int j = 0 ; j < database.size() ; j++)
    //         {
    //             if (matrix[i][j] != 0)
    //             {
    //                 System.out.printf("-%s" , database.get(j));
    //             }
    //         }
    //     }
    // }


}
