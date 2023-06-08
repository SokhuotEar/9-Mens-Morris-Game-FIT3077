package sample.ninemensmorris;

public class PlayerNameHolder {

    private static final PlayerNameHolder instance = new PlayerNameHolder();

    private String PlayerName1;

    private String PlayerName2;

    private PlayerNameHolder(){};

    public static  PlayerNameHolder getInstance(){
        return instance;

    }

    public String getPlayerName1() {
        return PlayerName1;
    }

    public String getPlayerName2() {
        return PlayerName2;
    }

   public void setUserName1(String PlayerName1){
        this.PlayerName1 = PlayerName1;
   }

    public void setUserName2(String PlayerName2){
        this.PlayerName2 = PlayerName2;
    }

}
