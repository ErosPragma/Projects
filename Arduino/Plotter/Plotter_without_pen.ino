int Pin0 = 2;
int Pin1 = 3;
int Pin2 = 4;
int Pin3 = 5;
int Pin4 = 8;
int Pin5 = 9;
int Pin6 = 10;
int Pin7 = 11;

int stepin = 0;
boolean dir = false;

int x,y;
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

}

void LeftUp(int mode, int step)
{
  for(x=0;x<7500;x++)
  { 
  for (stepin=mode; stepin < 8 && stepin>=0; stepin+=step)
  {
    Serial.println(stepin);
    switch (stepin) 
    {
      case 0:
        digitalWrite(Pin0, LOW);
        digitalWrite(Pin1, LOW);
        digitalWrite(Pin2, LOW);
        digitalWrite(Pin3, HIGH);
        break;
      case 1:
        digitalWrite(Pin0, LOW);
        digitalWrite(Pin1, LOW);
        digitalWrite(Pin2, HIGH);
        digitalWrite(Pin3, HIGH);
        break;
      case 2:
        digitalWrite(Pin0, LOW);
        digitalWrite(Pin1, LOW);
        digitalWrite(Pin2, HIGH);
        digitalWrite(Pin3, LOW);
        break;
      case 3:
        digitalWrite(Pin0, LOW);
        digitalWrite(Pin1, HIGH);
        digitalWrite(Pin2, HIGH);
        digitalWrite(Pin3, LOW);
        break;
      case 4:
        digitalWrite(Pin0, LOW);
        digitalWrite(Pin1, HIGH);
        digitalWrite(Pin2, LOW);
        digitalWrite(Pin3, LOW);
        break;
      case 5:
        digitalWrite(Pin0, HIGH);
        digitalWrite(Pin1, HIGH);
        digitalWrite(Pin2, LOW);
        digitalWrite(Pin3, LOW);
        break;
      case 6:
        digitalWrite(Pin0, HIGH);
        digitalWrite(Pin1, LOW);
        digitalWrite(Pin2, LOW);
        digitalWrite(Pin3, LOW);
        break;
      case 7:
        digitalWrite(Pin0, HIGH);
        digitalWrite(Pin1, LOW);
        digitalWrite(Pin2, LOW);
        digitalWrite(Pin3, HIGH);
        break;
      default:
        digitalWrite(Pin0, LOW);
        digitalWrite(Pin1, LOW);
        digitalWrite(Pin2, LOW);
        digitalWrite(Pin3, LOW);
        break;
    }
    delay(1);
  }
}
}

void RightDown(int mode, int step)
{
  for(x=0;x<7500;x++)
   for (stepin=mode; stepin < 8 && stepin>=0; stepin+=step)
  {
    Serial.println(stepin);
    switch (stepin) {
      case 0:
        digitalWrite(Pin4, LOW);
        digitalWrite(Pin5, LOW);
        digitalWrite(Pin6, LOW);
        digitalWrite(Pin7, HIGH);
        break;
      case 1:
        digitalWrite(Pin4, LOW);
        digitalWrite(Pin5, LOW);
        digitalWrite(Pin6, HIGH);
        digitalWrite(Pin7, HIGH);
        break;
      case 2:
        digitalWrite(Pin4, LOW);
        digitalWrite(Pin5, LOW);
        digitalWrite(Pin6, HIGH);
        digitalWrite(Pin7, LOW);
        break;
      case 3:
        digitalWrite(Pin4, LOW);
        digitalWrite(Pin5, HIGH);
        digitalWrite(Pin6, HIGH);
        digitalWrite(Pin7, LOW);
        break;
      case 4:
        digitalWrite(Pin4, LOW);
        digitalWrite(Pin5, HIGH);
        digitalWrite(Pin6, LOW);
        digitalWrite(Pin7, LOW);
        break;
      case 5:
        digitalWrite(Pin4, HIGH);
        digitalWrite(Pin5, HIGH);
        digitalWrite(Pin6, LOW);
        digitalWrite(Pin7, LOW);
        break;
      case 6:
        digitalWrite(Pin4, HIGH);
        digitalWrite(Pin5, LOW);
        digitalWrite(Pin6, LOW);
        digitalWrite(Pin7, LOW);
        break;
      case 7:
        digitalWrite(Pin4, HIGH);
        digitalWrite(Pin5, LOW);
        digitalWrite(Pin6, LOW);
        digitalWrite(Pin7, HIGH);
        break;
      default:
        digitalWrite(Pin4, LOW);
        digitalWrite(Pin5, LOW);
        digitalWrite(Pin6, LOW);
        digitalWrite(Pin7, LOW);
        break;
    }
    delay(1);
  }
}
void loop() 
{
  /*// put your main code here, to run repeatedly:
  for(int i=0;i<3;i++)
  cw();
  for(int i=0;i<3;i++)
  {
   acw2();
  }
  for(int i=0;i<3;i++)
    {
      acw();
      cw2();
    }
  while(1);*/
 // LeftUp(0,1);//clockwise 
  //RightDown(7,-1);//anticlockwise
  LeftUp(7,-1);//anticlockwise
  //seRightDown(0,1);//clockwise
}

