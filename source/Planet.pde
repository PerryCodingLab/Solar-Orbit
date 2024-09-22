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
  
  void spawnMoons(int total){
   moons = new Planet[total];
   for(int i = 0; i < moons.length; i++){
     float d = random(200,500);
     float a = random(0, 300);
     float s = random(650, 5000);
     double radiusNew = radius * random(0.05, 0.5);
      moons[i] = new Planet(radiusNew*0.4, d, a, s); 
   }
  }
    
  void show(){
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
