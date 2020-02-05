#include<Servo.h>
Servo pen; 
void setup() 
{
  pen.attach(6);
}
void penUp()
{
     pen.write(45);
}
void penDown()
{
    pen.write(-45);
}
void loop() 
{
   //for (int i=0;i<180;i++)
  penUp();
  delay(500);
 //  penDown();
   delay(1500);
}
