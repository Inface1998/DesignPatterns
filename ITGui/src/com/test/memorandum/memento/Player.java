package com.test.memorandum.memento;

/**
 * @author : zhanghj
 */
public class Player {
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
    //saveFile
    public Memento saveState(){
        return new Memento(life,magic);
    }
    //readFile
    public void restoreState(Memento memento){
        this.life = memento.life;
        this.magic = memento.magic;
    }
}
