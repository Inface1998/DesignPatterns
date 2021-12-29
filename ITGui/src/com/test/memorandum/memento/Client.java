package com.test.memorandum.memento;

import org.junit.Test;

/**
 * @author : zhanghj
 */
public class Client {
    @Test
    public void test(){
        Player player = new Player();
        Memento memento = player.saveState();
        player.fightBoss();
        player.restoreState(memento);
    }
}
