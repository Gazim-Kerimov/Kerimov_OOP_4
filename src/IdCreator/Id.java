package IdCreator;

public class Id {
    private static int id = 1;
    public static int getId(){
        return id++;
    }

}
