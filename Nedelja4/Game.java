// Almir Pelinkovic 23/133
// Aleksandar Filipovic 24/012
package Nedelja4;

class Player {
    private String imeP;
    private int x;
    private int y;
    private int width;
    private int height;
    private int health;

    
    public Player(String imeP, int x, int y, int width, int height, int health) {
        this.imeP = imeP;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setHealth(health);
    }

    // Ispis podataka o igracu
    @Override
    public String toString() {
        return "Player [x=" + x + ", y=" + y + ", width=" + width +
               ", height=" + height + ", health=" + health + "]";
    }

   
    public String getImeP() {
        return imeP;
    }

   
    public void setImeP(String imeP) {
        this.imeP = imeP;
    }

    
    public int getX() {
        return x;
    }

    
    public void setX(int x) {
        this.x = x;
    }

    
    public int getY() {
        return y;
    }

    
    public void setY(int y) {
        this.y = y;
    }

    
    public int getWidth() {
        return width;
    }

    
    public void setWidth(int width) {
        this.width = width;
    }

    
    public int getHeight() {
        return height;
    }

    
    public void setHeight(int height) {
        this.height = height;
    }

    
    public int getHealth() {
        return health;
    }

    // Postavlja health i provjerava da li je izmedju 0 i 100
    public void setHealth(int health) {
        if (health >= 0 && health <= 100) {
            this.health = health;
        } else {
            System.out.println("Greska, health mora biti izmedju 0 i 100");
        }
    }
}


class Enemy {
    private String imeE;
    private int x;
    private int y;
    private int width;
    private int height;
    private int damage;

    
    public Enemy(String imeE, int x, int y, int width, int height, int damage) {
        this.imeE = imeE;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setDamage(damage);
    }

    // Ispis podataka o neprijatelju
    @Override
    public String toString() {
        return "Enemy [x=" + x + ", y=" + y + ", width=" + width +
               ", height=" + height + ", damage=" + damage + "]";
    }

    
    public String getImeE() {
        return imeE;
    }

    
    public void setImeE(String imeE) {
        this.imeE = imeE;
    }

    
    public int getX() {
        return x;
    }

    
    public void setX(int x) {
        this.x = x;
    }

    
    public int getY() {
        return y;
    }

    
    public void setY(int y) {
        this.y = y;
    }

    
    public int getWidth() {
        return width;
    }

    
    public void setWidth(int width) {
        this.width = width;
    }

    
    public int getHeight() {
        return height;
    }

    
    public void setHeight(int height) {
        this.height = height;
    }

    
    public int getDamage() {
        return damage;
    }

    // Postavlja damage i provjerava da li je izmedju 0 i 100
    public void setDamage(int damage) {
        if (damage >= 0 && damage <= 100) {
            this.damage = damage;
        } else {
            System.out.println("Greska, damage mora biti izmedju 0 i 100");
        }
    }
}


public class Game {
    private Player player;
    private Enemy[] enemies;
    private String dnevnikDogadjaja;

    
    public Game(Player player, Enemy[] enemies, String dnevnikDogadjaja) {
        this.player = player;
        this.enemies = enemies;
        this.dnevnikDogadjaja = dnevnikDogadjaja;
    }

    
    public Player getPlayer() {
        return player;
    }

    
    public void setPlayer(Player player) {
        this.player = player;
    }

    
    public Enemy[] getEnemies() {
        return enemies;
    }

    
    public void setEnemies(Enemy[] enemies) {
        this.enemies = enemies;
    }

    
    public String getDnevnikDogadjaja() {
        return dnevnikDogadjaja;
    }

    
    public void setDnevnikDogadjaja(String dnevnikDogadjaja) {
        this.dnevnikDogadjaja = dnevnikDogadjaja;
    }

   //Proverava da li dolazi do prekpapanja(sudara) kordinata Playera i Enemyja
    public static boolean checkCollision(Player p, Enemy e) {
        boolean sudar = p.getX() < e.getX() + e.getWidth() &&
                        p.getX() + p.getWidth() > e.getX() &&
                        p.getY() < e.getY() + e.getHeight() &&
                        p.getY() + p.getHeight() > e.getY();

        if (sudar) {
            decreaseHealth(p, e);
        }

        return sudar;
    }

    // Smanjuje health igraca za damage neprijatelja
    public static void decreaseHealth(Player p, Enemy e) {
        int noviHealth = p.getHealth() - e.getDamage();

        if (noviHealth < 0) {
            noviHealth = 0;
        }

        p.setHealth(noviHealth);
    }

    // Dodaje neprijatelja u prvi slobodan slot niza
    public void addEnemy(Enemy e) {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] == null) {
                enemies[i] = e;

                dnevnikDogadjaja += "Dodat je novi neprijatelj na poziciji x: "
                        + e.getX() + ", y: " + e.getY() + "\n";

                System.out.println("Neprijatelj uspjesno dodat!");
                return;
            }
        }
    }

    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
}