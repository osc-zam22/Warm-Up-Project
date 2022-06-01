public class Node
{
    private String name;
    private float lat , lon;
    private int pop;
    private Edge edge;


    public Node(String name , float lat , float lon , int pop)
    {

    }

    public void setName(String Name)
    {
        this.name = name;
    }
    public void setLat(float lat)
    {
        this.lat = lat;
    }
    public void setLon(float lon)
    {
        this.lon = lon;
    }
    public void setPop(int pop)
    {
        this.pop = pop;   
    }


}