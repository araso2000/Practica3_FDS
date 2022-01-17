package paquete;

public class Main {

    public static void main(String[] args) {

        Players allPlayers = new Players();
        allPlayers.load("listado_jugadores.csv");
        allPlayers.sortByValue();
        allPlayers.print();

        TeamMaker generator = new TeamMaker(3, 40000000, allPlayers);
        //generator.makeTeamsMode1();
        generator.makeTeamsMode2(11);
        generator.print();
    }
}