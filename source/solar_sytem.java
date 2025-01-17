/* autogenerated by Processing revision 1293 on 2024-09-22 */
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.lang.Math;
import processing.javafx.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class solar_sytem extends PApplet {



Planet sun;

public void setup(){
  frameRate(60);
  /* size commented out by preprocessor */;
  sun = new Planet(100,0,0,0);
  //sun.spawnMoons(6);
}

public void mouseClicked(){
  sun.spawnMoons(6);
}

public void draw(){
 background(0);
 translate(width/2,height/2);
 sun.show();
}
class Planet {
  double radius;
  float HorAngle;
  float distance;
  float orbitSpeed;
  float axis;
  Planet[] moons;
  
  Planet(double r, float d, float a, float s){
    radius = r;
    distance = d;
    HorAngle = a;
    orbitSpeed = s;
    //axis = HorAngle* Math.sin();
  }
  
  public void spawnMoons(int total){
   moons = new Planet[total];
   for(int i = 0; i < moons.length; i++){
     float d = random(200,500);
     float a = random(0, 300);
     float s = random(650, 5000);
     double radiusNew = radius * random(0.05f, 0.5f);
      moons[i] = new Planet(radiusNew*0.4f, d, a, s); 
   }
  }
    
  public void show(){
    float h = (float)(distance * Math.sin(HorAngle));
    float w = (float)(distance * Math.cos(HorAngle));
    
    if (orbitSpeed != 0) {
      float rot = (float)(((frameCount%orbitSpeed)/orbitSpeed) * 360);
      rotate(radians(rot));
    }
    //translate(w, h);
     ellipse(h,w,(float)radius*2, (float)radius*2); 
     if (moons != null) {
       for(int i = 0; i < moons.length; i++){
         
         moons[i].show();
         
       }
     }
  }
}


  public void settings() { size(2000, 1000); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "solar_sytem" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
