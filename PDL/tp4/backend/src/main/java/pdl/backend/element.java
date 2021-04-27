package pdl.backend;

public class element{
    private String name;
    private long id;
    public element(String name, long id){
        this.name = name;
        this.id = id;
    }
    public String getOut(){
        return ("{id: "+this.id+", name: "+this.name+"}");
    }
    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getUrl(){
        return "images/"+id;
    }
    public String getLol(){
        return "ol";
    }
}