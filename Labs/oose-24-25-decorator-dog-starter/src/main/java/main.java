public class main {

    public static void main (String[] args){
        WolfDecorator wolf = new WolfDecorator(new ForestLevel());
        System.out.println(wolf.generateLevel());
    }
    
}