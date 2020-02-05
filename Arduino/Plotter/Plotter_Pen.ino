#include<Servo.h>
Servo pen; 

int Pin0 = 2;
int Pin1 = 3;
int Pin2 = 4;
int Pin3 = 5;
int Pin4 = 8;
int Pin5 = 9;
int Pin6 = 10;
int Pin7 = 11;
int servo_pin= 6;

int stepin,ch;
void setup()
{
  pinMode(Pin0, OUTPUT);
  pinMode(Pin1, OUTPUT);
  pinMode(Pin2, OUTPUT);
  pinMode(Pin3, OUTPUT);
  pinMode(Pin4, OUTPUT);
  pinMode(Pin5, OUTPUT);
  pinMode(Pin6, OUTPUT);
  pinMode(Pin7, OUTPUT);
  Serial.begin(9600);
  pen.attach(servo_pin);
}
void penUp()
{
     pen.write(45);
}
void penDown()
{
    pen.write(-45);
}
void rotate(int p1,int p2,int p3,int p4,int mode)
{
  switch (mode) 
    {
      case 0: digitalWrite(p1, LOW); digitalWrite(p2, LOW); digitalWrite(p3, LOW); digitalWrite(p4, HIGH); break;
      case 1: digitalWrite(p1, LOW); digitalWrite(p2, LOW); digitalWrite(p3, HIGH); digitalWrite(p4, HIGH);break;
      case 2: digitalWrite(p1, LOW); digitalWrite(p2, LOW); digitalWrite(p3, HIGH); digitalWrite(p4, LOW);  break;
      case 3: digitalWrite(p1, LOW);  digitalWrite(p2, HIGH);  digitalWrite(p3, HIGH); digitalWrite(p4, LOW);  break;
      case 4: digitalWrite(p1, LOW); digitalWrite(p2, HIGH); digitalWrite(p3, LOW); digitalWrite(p4, LOW); break;
      case 5: digitalWrite(p1, HIGH);  digitalWrite(p2, HIGH); digitalWrite(p3, LOW); digitalWrite(p4, LOW); break;
      case 6: digitalWrite(p1, HIGH); digitalWrite(p2, LOW); digitalWrite(p3, LOW); digitalWrite(p4, LOW); break;
      case 7: digitalWrite(p1, HIGH); digitalWrite(p2, LOW); digitalWrite(p3, LOW); digitalWrite(p4, HIGH); break;
      default: digitalWrite(p1, LOW); digitalWrite(p2, LOW); digitalWrite(p3, LOW); digitalWrite(p4, LOW);  break;
    }
}
// left Anticlockwise
//forward clockwise
void LeftUp(int arg,int mode, int step)
{
  for(int x=0;x<arg;x++)
   {     for (stepin=mode; stepin < 8 && stepin>=0; stepin+=step)
         {    rotate(Pin0,Pin1,Pin2,Pin3,stepin);
              Serial.println(stepin);
         }
   }
}

void RightDown(int arg,int mode, int step)
{
  for(int x=0;x<arg;x++)
   {     for (stepin=mode; stepin < 8 && stepin>=0; stepin+=step)
         {    rotate(Pin4,Pin5,Pin6,Pin7,stepin);
              Serial.println(stepin);
         }
   }
}
void fd(int arg)
{
  RightDown(arg,0,1);
}
void bk(int arg)
{
  RightDown(arg,7,-1);
}
void lt(int arg)
{
  LeftUp(arg,7,-1);
}
void rt(int arg)
{
  LeftUp(arg,0,1);
}
void sqr()
{
  penDown();
  bk(7500);
  rt(7400);
  fd(7500);
  lt(7400);
  penDown();
  penUp();
  delay(1500);
}
void circle()
{
  penUp();
  rt(4500);
  penDown();

  penDown();
  for (int i=0;i<10000;i++)
  {
    fd(5);
    rt()
  }
}
void loop() 
{
  /*
  if (Serial.available()>0)
  {
  Serial.print("1. Left to right\n2. Right to left\n3. Forward\n4. Backwards\n Enter ypur choice: ");
  ch=Serial.read();
  switch(ch)
  {
    case 1: LeftUp(0,1);  break;
    case 2: LeftUp(7,-1); break;
    case 3: RightDown(0,1);   break;
    case 4: RightDown(7,-1);  break;
   default
  }
  */
 sqr();
  
  }

