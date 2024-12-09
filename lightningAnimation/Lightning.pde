class Lightning {

  int numPoints;
  PVector[] points;

  Lightning(int numParts) {
    points=new PVector[numParts];
    points[0]= new PVector();
    points[0].x=int(random(width+1));
    points[0].y=0;
    numPoints=1;
  }//constructor

  PVector newPoint(PVector previous) {
    PVector newPoint = new PVector();
    newPoint.x=-15+random(30)+previous.x;
    newPoint.y=5+random(15)+previous.y;
    return newPoint;
  }//newPoint

  void addPoint() {
    if (points[numPoints-1]!=null) {
      points[numPoints]=newPoint(points[numPoints-1]);
      numPoints++;
    }
  }//addPoint

  void display() {
    
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

  boolean complete() {
    if (points[points.length-1]!=null) {
      return true;
    } else {
      return false;
    }
  }//complete
}//Lightning
