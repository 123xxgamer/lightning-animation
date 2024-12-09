Lightning[] bolts;
int currentBolt;
int rate;

void setup() {
  size (500, 500);
  rate=180;
  frameRate(rate);
  strokeWeight(2);

  //at most 4 lightning bolts.
  bolts = new Lightning[4];

  //always start with 1 lightning bolt
  bolts[0] = new Lightning(40);
}//setup

void draw() {
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

void keyPressed() {
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

void updateBolts(Lightning[] bs) {
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

void drawBolts(Lightning[] bs) {
  for (int i=0; i<bs.length; i++) {
    if (bs[i]!=null) {
      bs[i].display();
    }
  }
}//drawBolts

int findAvailableIndex(Lightning[] bs) {
  for (int i=0; i<bs.length; i++) {
    if (bs[i]==null) {
      return i;
    }
  }
  return -1;
}//findAvailableIndex
