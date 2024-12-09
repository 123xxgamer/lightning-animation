/* autogenerated by Processing revision 1293 on 2024-12-09 */
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class lightningAnimation extends PApplet {

Lightning[] bolts;
int currentBolt;
int rate;

public void setup() {
  /* size commented out by preprocessor */;
  rate=180;
  frameRate(rate);
  strokeWeight(2);

  //at most 4 lightning bolts.
  bolts = new Lightning[4];

  //always start with 1 lightning bolt
  bolts[0] = new Lightning(40);
}//setup

public void draw() {
  frameRate(rate);
  background(20,20,60);

  updateBolts(bolts);

  drawBolts(bolts);

  if (random(10)<1) {
    int i=findAvailableIndex(bolts);
    if (i!=-1) {
      bolts[i]=new Lightning(40);
    }
  }
}//draw

public void keyPressed() {
  if (key=='1') {
    rate=15;
  }
  if (key=='2') {
    rate=25;
  }
  if (key=='3') {
    rate=45;
  }
  if (key=='4') {
    rate=75;
  }
  if (key=='5') {
    rate=125;
  }
  if (key=='6') {
    rate=185;
  }
  if (key=='7') {
    rate=255;
  }
  if (key=='8') {
    rate=400;
  }
}

public void updateBolts(Lightning[] bs) {
  for (int i=0; i<bs.length; i++) {
    if (bs[i]!=null) {
      if (bs[i].complete()) {
        bs[i]=null;
      } else {
        bs[i].addPoint();
      }
    }
  }
}//updateBolts

public void drawBolts(Lightning[] bs) {
  for (int i=0; i<bs.length; i++) {
    if (bs[i]!=null) {
      bs[i].display();
    }
  }
}//drawBolts

public int findAvailableIndex(Lightning[] bs) {
  for (int i=0; i<bs.length; i++) {
    if (bs[i]==null) {
      return i;
    }
  }
  return -1;
}//findAvailableIndex
class Lightning {

  int numPoints;
  PVector[] points;

  Lightning(int numParts) {
    points=new PVector[numParts];
    points[0]= new PVector();
    points[0].x=PApplet.parseInt(random(width+1));
    points[0].y=0;
    numPoints=1;
  }//constructor

  public PVector newPoint(PVector previous) {
    PVector newPoint = new PVector();
    newPoint.x=-15+random(30)+previous.x;
    newPoint.y=5+random(15)+previous.y;
    return newPoint;
  }//newPoint

  public void addPoint() {
    if (points[numPoints-1]!=null) {
      points[numPoints]=newPoint(points[numPoints-1]);
      numPoints++;
    }
  }//addPoint

  public void display() {
    
    stroke(100,170,200);
    for (int i=0; i<numPoints-1; i++) {
      line(points[i].x-2, points[i].y, points[i+1].x-2, points[i+1].y);
    }
    for (int i=0; i<numPoints-1; i++) {
      line(points[i].x+2, points[i].y, points[i+1].x+2, points[i+1].y);
    }
    stroke(200,225,255);
    for (int i=0; i<numPoints-1; i++) {
      line(points[i].x, points[i].y, points[i+1].x, points[i+1].y);
    }
    
  }//display

  public boolean complete() {
    if (points[points.length-1]!=null) {
      return true;
    } else {
      return false;
    }
  }//complete
}//Lightning


  public void settings() { size(500, 500); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "lightningAnimation" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}