package paquete;

import java.util.ArrayList;

public class TeamMaker {
    private int numberOfTeams;
    private int maxValue;
    private Players players;
    private ArrayList<Team> teams;

    public int getMaxValue() {
        return maxValue;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public Players getPlayers() {
        return players;
    }

    public TeamMaker(int numberOfTeams, int maxValue, Players players) {
        this.numberOfTeams = numberOfTeams;
        this.maxValue = maxValue;
        this.players = players;

        this.teams = new ArrayList<Team>();

        for (int idx = 1; idx <= this.getNumberOfTeams(); idx++) {
            Team team = new Team("Equipo número " + idx, this.getMaxValue());
            this.teams.add(team);
        }
    }

    public void print()
    {
        for (Team team : this.teams) {
            team.print();
        }
    }

    public void makeTeamsMode1(){
        //OBJETIVO: Generar equipos contemplando únicamente no sobrepasar el valor máximo
        //CONJUNTO DE CANDIDATOS: Atributo this.players
        for(Team tem : this.teams){
            int posicion=0;
            while(players.getFirstPlayer(tem.getBudget()) != null){ //FUNCIÓN DE SOLUCIÓN
                Player a = players.getFirstPlayer(tem.getBudget()); //FUNCIÓN DE SELECCIÓN
                if(a != null){ //FUNCIÓN DE FACTIBILIDAD
                    tem.addPlayer(a);
                    players.removePlayer(a);
                    tem.setBudget(tem.getBudget()-a.getValue());
                }
                posicion++;
            }  
        }
    }

    public void makeTeamsMode2(int minNumberOfPlayersPerTeam) {
        //OBJETIVO: Generar equipos contemplando:
        //  - no sobrepasar el valor máximo
        //  - que al menos haya minNumberOfPlayersPerTeam jugadores por equipo
       
        //CONJUNTO DE CANDIDATOS: Atributo this.players
        
        for(Team tem : this.teams){
            int posicion=0;
            while(posicion < players.getNumberOfPlayers()){ //FUNCIÓN DE SOLUCIÓN
                Players b = tem.getPlayers();
                Player a = players.getFirstPlayer(tem.getBudget()); //FUNCIÓN DE SELECCIÓN
                b.sortByValue();
                if(a != null){ //FUNCIÓN DE FACTIBILIDAD
                    tem.addPlayer(a);
                    players.removePlayer(a);
                    tem.setBudget(tem.getBudget()-a.getValue());
                }else if(b.getNumberOfPlayers() < minNumberOfPlayersPerTeam){
                    Player p = b.getFirstPlayer();
                    b.removePlayer(p);
                    tem.setBudget(tem.getBudget()+p.getValue());
                    players.addPlayer(p);
                }
                posicion++;
            }             
        }
    }
    
}
