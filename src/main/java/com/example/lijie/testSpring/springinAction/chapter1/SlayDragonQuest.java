/**
 * Created by lijie on 2017/7/24.
 */
package com.example.lijie.testSpring.springinAction.chapter1;

/**
 * auther lijie  2017/7/24.
 */
public class SlayDragonQuest implements Quest {
//    private PrintStream stream;

    public SlayDragonQuest() {
//        this.stream = stream;
    }

    @Override
    public void embark() {
//        stream.println("Embarking on quest to slay the dragon!");
        System.out.println("Embarking on quest to slay the dragon!");
    }
}