import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    //static List<City> citiesList = new ArrayList<>();

    //static Scanner reader = new Scanner("LATowns.txt");

    public static void main(String [] args) {
        File file = new File("LATowns.txt");
        Scanner reader;
        try {
            reader = new Scanner(file);
            List<City> citiesList = new ArrayList<>();
            System.out.println("hello world");
            reader.nextLine();
            while(reader.hasNext())
            {
                City temp = new City();
                temp.setName(reader.next());
                temp.setLatitude(reader.nextFloat());
                temp.setLongitude(reader.nextFloat());
                try {
                    temp.setPop(reader.nextInt());
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("not a valid population");
                }
                //System.out.println(temp.toString());
                citiesList.add(temp);
            }
            quickSort(citiesList, 0, citiesList.size()-1);

            Graph citiesDataBase = new Graph(citiesList.size());


            constructGraph(citiesDataBase, citiesList.size(), citiesList);
            citiesDataBase.printGraph(citiesList);


            // debugging code
            // Iterator iter = citiesList.iterator();

            // while(iter.hasNext())
            // {
            //     System.out.println(iter.next().toString());
            // }



            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                System.out.println("Error found exiting");
                System.exit(0);
            }

    }


    // sorting function for the cities list
    public static void quickSort(List<City> list , int low, int high)
    {
        if(low < high)
        {
            int pivot = split(list , low , high);
            quickSort(list, low, pivot-1);
            quickSort(list, pivot+1, high);
        }
    }
    public static int split(List<City> list , int low, int high) 
    {
        City pivot = list.get(high);
        int i = low -1;
        for(int j = low ; j <= high-1 ; j++)
        {
            if(list.get(j).compareTo(pivot) < 0)
            {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i+1, high);
        return i+1;
    }


    static public void constructGraph(Graph graph , int verts , List<City> list)
    {
        double [][] matrix = graph.getMatrix();
        for(int i = 0 ; i < verts ; i++)
        {
            for(int j = 0 ; j < verts ; j++)
            {
                matrix[i][j] = City.distance(list.get(i), list.get(j));
            }
        }
    }
}
