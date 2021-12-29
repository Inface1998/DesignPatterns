package com.test.intermediary.improve;

import org.junit.Test;

/**
 * @author : zhanghj
 */
public class Client2 {
    @Test
    public void test(){
        Group group = new Group();
        Player p1 = new Player(group);
        Player p2 = new Player(group);
        Player p3 = new Player(group);
        Player p4 = new Player(group);
        // player1 赢了 5 元
        p1.change(5);
        // player2 赢了 20 元
        p2.change(20);
        // player3 输了 12 元
        p3.change(-12);
        // player4 输了 3 元
        p4.change(-3);

        // 输出：四人剩余的钱：105,120,88,97
        System.out.println("四人剩余的钱：" + p1.money + "," + p2.money + "," + p3.money + "," + p4.money);

    }

}
class Group{
    public int money;
}
class Player{
    public int money = 100;
    public Group group;
    public Player(Group group){
        this.group = group;
    }
    public void change(int money){
        group.money += money;
        this.money += money;
    }
}

