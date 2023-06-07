public class entity {

    //attributes
    int id;
    int[] coordinates;
    String skin;
    //constructor vacio
    public entity(){

    }


    //constructor con atributos
    public entity(int id, int[] coordinates, String skin){
        this.id = id;
        this.coordinates = coordinates;
        this.skin = skin;

    }


    //getter (traeme, muestrame un attributo)
    public int getId(){
        return id;
    }

    //setter (poner o cambiar un attributo)
    public void setId(int id){
        this.id = id;
    }

    public int[] getCoordinates(){
        return coordinates;
    }

    public void setCoordinates(int[] coordinates){
        this.coordinates = coordinates;
    }

    public String getSkin(){
        return skin;
    }

    public void setSkin(String skin){
        this.skin = skin;
    }

}
