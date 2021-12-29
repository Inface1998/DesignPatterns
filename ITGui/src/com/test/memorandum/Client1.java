package com.test.memorandum;

import org.junit.Test;

/**
 * @author : zhanghj
 */
public class Client1{
    @Test
    public void test(){
        Player player = new Player();
        //save game;
        int saveLife = player.getLife();
        int saveMagic = player.getMagic();
        //fight with boss
        player.fightBoss();
        //read file
        player.setLife(saveLife);
        player.setMagic(saveMagic);
    }
}
class Player {
    private int life = 100;
    private int magic = 100;
    public void fightBoss(){
        life -= 100;
        magic -= 100;
        if (life <= 0){
            System.out.println("Sacrifice");
        }
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }
}
