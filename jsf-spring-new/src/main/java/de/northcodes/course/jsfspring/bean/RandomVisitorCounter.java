package de.northcodes.course.jsfspring.bean;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Random;


@ManagedBean
@SessionScoped
public class RandomVisitorCounter {
    private int visNum=540000;
    Random random = new Random();
    public RandomVisitorCounter() {
        this.visNum = random.nextInt(540000);

    }

    public void setVisNum(int visNum) {
        this.visNum = visNum;
    }
    public int getVisNum() {
        return visNum;
    }






}
