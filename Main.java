import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {

    //static List<City> citiesList = new ArrayList<>();

    //static Scanner reader = new Scanner("LATowns.txt");

    public static void main(String [] args) {
        File file = new File("LATownsShortList.txt");
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
                    System.out.println("not a valid population");
                }
                //System.out.println(temp.toString());
                citiesList.add(temp);
            }
            quickSort(citiesList, 0, citiesList.size()-1);

            Graph citiesDataBase = new Graph(citiesList.size());


            constructGraph(citiesDataBase, citiesList.size(), citiesList);


            System.out.println("debugging test print\n");
            printGraph(citiesList , citiesDataBase);


            System.out.println("greedy solution test run");
            greedySolution(citiesDataBase, 0, citiesList);

            System.out.println("Done");


            // debugging code
            // Iterator iter = citiesList.iterator();

            // while(iter.hasNext())
            // {
            //     System.out.println(iter.next().toString());
            // }



            } catch (FileNotFoundException e1) {
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
        // double [][] matrix = graph.getMatrix();
        for(int i = 0 ; i < verts ; i++)
        {
            for(int j = 0 ; j < verts ; j++)
            {
                graph.setEdge(i, j , City.distance(list.get(i), list.get(j)));
            }
        }
    }

    public static void DFS(Graph graph , List<City> database)
    {
        Set<City> visited = new HashSet<>();
        Stack<City> stack = new Stack<>();
        stack.push(database.get(0));
        // int counter = 0;
        while(!stack.empty())
        {
            City curr = stack.pop(); 
            if(!visited.contains(curr))
            {
                for(int i = 0 ; i < database.size() ; i++ )
                {
                    
                }
            }

        }
    }

    public static void printConnection(Graph graph , int curr , int destination , List <City> list)
    {
        System.out.printf("%s is %f KM away from %s\n" , list.get(curr).getName() , graph.getWeight(curr, destination)
                            , list.get(destination).getName());
    }



    public static void printGraph(List<City> database , Graph graph)
    {
        for(int i = 0 ; i < database.size() ; i++ )
        {
            System.out.printf("\n\n***Connections for %s ***\n\n" , database.get(i).getName());
            for (int j = 0 ; j < database.size() ; j++)
            {
                printConnection(graph, i, j, database);
            }
        }
    }


    // public static void greedySolution(Graph graph , int origin , List<City> list)
    // {
    //     // creates necessary data structs
    //     List<Integer> visited = new ArrayList<>();
    //     Queue<Integer> path = new LinkedList<Integer>();
    //     path.add(origin);
    //     double totalTraveled = 0;
    //     while(!path.isEmpty())
    //     {
    //         System.out.println("inside breadth search");
    //         int current = path.poll();
    //         if(!visited.contains(current))
    //         {
    //             visited.add(current);
    //             int currLowest = (int)Float.MAX_VALUE;
    //             for(int i = 0 ; i < list.size() ; i++)
    //             {
    //                 if(graph.getWeight(current, i) != 0)
    //                 {
    //                     if (graph.getWeight(current, i) < currLowest && !visited.contains(currLowest))
    //                     {
    //                         currLowest = i;
    //                     }
    //                 }
    //             }
    //             path.add(currLowest);
    //         }
    //     }
    //     System.out.println("The path taken between the cities is:\n");
    //     for(int i = 0 ; i < visited.size(); i++)
    //     {
    //         System.out.printf("%d : %s\n" ,  i , list.get(visited.get(i)).getName());
    //     }
    // }

    public static void greedySolution(Graph graph , int origin , List<City> cities)
    {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> path = new LinkedList<>();
        path.add(origin);
        while(!path.isEmpty())
        {
            int currentLocation = path.poll();
            if(!visited.contains(currentLocation))
            {
                visited.add(currentLocation);
                double low = Float.MAX_VALUE;
                for(int i = 0 ; i < cities.size() ; i++)
                {
                     if (graph.getWeight(currentLocation, i ) < low && graph.getWeight(currentLocation, i) != 0)
                     {
                        low = i
                     }
                }
            }
        }
    }

}
