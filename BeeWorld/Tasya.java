import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tasya here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tasya extends Actor
{
    /**
     * Act - do whatever the Tasya wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        aksiPlayer();
        //fire();
    }
    void aksiPlayer(){
        if(Greenfoot.isKeyDown("Left")){
            setLocation(getX()-3,getY());
        }
        if(Greenfoot.isKeyDown("Right")){
            setLocation(getX()+3,getY());
        }
        if(Greenfoot.isKeyDown("Up")){
            setLocation(getX(),getY()-3);
        }
        if(Greenfoot.isKeyDown("Down")){
            setLocation(getX(),getY()+3);
        }
    }
    
    
    
    
}
