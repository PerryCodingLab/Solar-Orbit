import java.lang.Math;
import processing.javafx.*;
Planet sun;

void setup(){
  frameRate(60);
  size(2000,1000);
  sun = new Planet(100,0,0,0);
  //sun.spawnMoons(6);
}

void mouseClicked(){
  sun.spawnMoons(6);
}

void draw(){
 background(0);
 translate(width/2,height/2);
 sun.show();
}
