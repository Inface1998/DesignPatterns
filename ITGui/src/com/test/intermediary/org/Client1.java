package com.test.intermediary.org;

import org.junit.Test;

/**
 * @author : zhanghj
 */
public class Client1 {
    @Test
    public void test(){
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        Player p4 = new Player();
        p1.win(p3,5);
        p2.win(p1,10);
        p3.win(p4,10);
        p4.win(p3,7);
        System.out.println("私人剩余的钱"+p1.money+","+p2.money+","+p3.money+","+p4.money);
    }
}

class Player{
    public int money = 100;
    public void win(Player player,int money){
        player.money -= money;
        this.money = money;
    }
}
