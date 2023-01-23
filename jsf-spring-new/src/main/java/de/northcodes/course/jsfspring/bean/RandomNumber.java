package de.northcodes.course.jsfspring.bean;

import java.util.Random;

public class RandomNumber {
    Random rand = new Random();

    public int getRandomNumber(){
        return rand.nextInt(5000000);
    }


}
