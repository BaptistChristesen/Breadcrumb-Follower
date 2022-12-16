import kareltherobot.*;

public class BreadCrumbFollower extends Robot
{
    public BreadCrumbFollower(int s, int a, Direction d, int b)
    {
        super(s,a,d,b);
    }

    // complete the following method (plus others as needed)
    public void travel()
    {
        if(nextToABeeper() && frontIsClear()){
            move();
            travel();
        }
        else if(!nextToABeeper()){
            basicReset();
            turnLeft();
            move();
            if(!nextToABeeper()){
                basicReset();
                turnAround();
                if(frontIsClear()){
                    move();
                    travel();
                }
                else{
                    turnOff();
                }
            }
            else{
                travel();
            }
        }  
        else if(nextToABeeper()){
            turnLeft();
            move();
            travel();
            }
    }
    // turn around to face opposite direction
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }
    
    // two wrongs don't make a right, but three lefts do!
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    // prevents from moving through a wall
    public void move()
    {
        if(frontIsClear())
            super.move();
    }
    public void advReset(){
        turnAround();
        move();
        turnAround();
        turnRight();
    }
    public void basicReset(){
        turnAround();
        move();
        turnAround();
    }
}