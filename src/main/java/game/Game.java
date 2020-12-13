package game;

import character.Hero;
import character.Warrior;
import exceptions.GameOverException;
import exceptions.InvalidTypeException;
import exceptions.NoEmptySlotException;
import fight.Fight;
import fileservice.FileService;
import inventory.Food;
import inventory.PricedItem;
import inventory.Weapon;
import repository.HeroRepository;
import repository.NpcRepository;
import trade.TradeMode;
import trade.Trader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final char[][] map = new char[10][30];
    private Location h;
    private final NpcRepository npcRepository;
    private Hero hero;
    private int victories = 0;



    public static void main(String[] args) {
        Game game = new Game();
        game.chooseHero();
        try {
            game.loadMap();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        game.showMap();
        game.playerMove();
        System.out.println(game.hero);
    }

    public void checkMapTile(int row, int col) throws GameOverException, NoEmptySlotException {
        char ch = map[row][col];
        switch (ch){
            case '_':break;
            case '~': hero.getDamage(1);break;
            case '.': hero.getDamage(5);break;
            case '?': hero.addNewItem(new Weapon("Scythe of Death",50, 150));break;
            case 'E': Fight fight = new Fight(hero, npcRepository.getRandomEnemies());
            fight.executeFight();
            if(!hero.isDead()){
                victories++;
            }
            break;
            case 'T': trade();break;
            case 'F': endOfGame();break;
            default:
                System.out.println("Hmm something goes wrong");break;

        }
    }

    private void trade() {
        Trader trader = new Trader();
        trader.addItem(new PricedItem(new Food("Apple",1,15,10),5));
        TradeMode tradeMode = new TradeMode(trader,hero);
        tradeMode.showAvailableItem();
        System.out.println("If you want to buy something type name of it:");
        var in  = new Scanner(System.in);
        try {
            tradeMode.buyItem(in.next());
        } catch (NoEmptySlotException e) {
            e.printStackTrace();
        }
    }

    private void endOfGame() {
        System.out.println("Your hero reach the final destination");
        System.out.println("The number of fallen enemies is " + victories);
        System.exit(0);
    }

    public void playerMove()
    {
        System.out.println("Make move or other action, in case you dont remember typ help");
        var in = new Scanner(System.in);
        String next = in.next();
        playerActions(next);
    }

    private void playerActions(String next) {
        switch (next)
        {
            case "w":move(-1,0);playerMove();break;
            case "s":move(1,0);playerMove();break;
            case "a":move(0,-1);playerMove();break;
            case "d":move(0,1);playerMove();break;
            case "help":showHelp();playerMove();break;
            case "weapon": if(hero instanceof Warrior){
                hero.showEquipment();
                System.out.println("Give item number to assign as weapon.");
                var in = new Scanner(System.in);
                try {
                    ((Warrior) hero).assignWeapon(in.nextInt()-1);
                } catch (InvalidTypeException | NoEmptySlotException e) {
                    e.printStackTrace();
                }
            } ;playerMove();break;
            case "eat": hero.showEquipment();
                System.out.println("Give item number to consume to regain HP.");
                var in = new Scanner(System.in);
                hero.consumeFood(in.nextInt());playerMove();break;
            case "inventory": hero.showEquipment();playerMove();break;
            default:
                System.out.println("Typed word is invalid try again ");playerMove();break;
        }
    }

    public void move(int row, int col){
        if(h.getRow()+row>=0 && h.getCol()+col>=0){
            h.setRow(h.getRow()+row);
            h.setCol(h.getCol()+col);
            showMap();
            try {
                checkMapTile(h.getRow(),h.getCol());
            } catch (GameOverException | NoEmptySlotException e) {
                e.printStackTrace();
            }
        }
    }

    public Game() {
        npcRepository = new NpcRepository();
        h = new Location(9,0);
    }

    public void chooseHero(){
        HeroRepository repository = new HeroRepository();
        repository.showList();
        Scanner in = new Scanner(System.in);
        System.out.println("Write hero name you want to choose.");
        String name = in.next();
        Hero hero = repository.chooseHero(name);
        if(hero !=null){
            this.hero = hero;
        }
    }

    public void showHelp(){
        var sb = new StringBuilder();
        sb.append("HELP\n").append("type one of WASD to move character\n")
                .append("type inventory - to show equipment\n")
                .append("type eat - to consume food, (if hero have it)\n")
                .append("type weapon - to assign weapon if your charachter is warrior\n")
                .append("type help - to show this help text again.\n");
        System.out.println(sb);
    }

    public Location getH() {
        return h;
    }

    public void showMap(){
        System.out.println("new map after mover.");
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 30; col++) {
                if(row == h.getRow() && col == h.getCol()){
                    System.out.print('H');
                }else
                    System.out.print(map[row][col]);
            }
            System.out.println();
        }
    }

    public void loadMap() throws IOException, URISyntaxException {
        List<String> stringList = FileService.getMap();
        for (int row = 0; row < stringList.size(); row++) {
            for (int col = 0; col < stringList.get(row).length(); col++) {
                map[row][col] = stringList.get(row).charAt(col);
            }
        }
    }
}

class Location{
    private int row;
    private int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
