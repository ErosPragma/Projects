import turtle
from random import randint
from time import sleep

class Diagram:
  def Dia(self,ch):
    wn=turtle.Screen()
    tod=turtle.Turtle()
    turtle.setup(width=300,height=400)
    turtle.speed(10)
    tod.hideturtle()
    tod.pensize(5)
    
    if ch in range(1,11):
        tod.fd(50)
        tod.bk(100)
        tod.fd(35)
        tod.lt(90)
        if ch==1:           
          return 1
        tod.pensize(2)
        tod.fd(150)
        if ch==2:           
          return 1
        tod.rt(90)
        tod.fd(50)
        if ch==3:             
            return 1
        tod.rt(90)
        tod.fd(30)
        if ch==4:           
          return 1
        tod.lt(90)
        tod.pensize(3)
        for i in range (108):
          tod.fd(1)
          tod.rt(5)
        if ch==5:           
          return 1
        tod.lt(90)
        tod.fd(50)
        if ch==6:           
          return 1
        tod.bk(40)
        tod.lt(40)
        tod.fd(15)
        tod.bk(15)
        if ch==7:           
          return 1
        tod.rt(90)
        tod.fd(15)
        tod.bk(15)
        if ch==8:             
            return 1
        tod.lt(50)
        tod.fd(40)
        tod.rt(40)
        tod.fd(15)
        tod.bk(15)
        if ch==9:
            return 1
        tod.lt(90)
        tod.fd(15)
        turtle.bye()

def extraction():
    source=['fruit','vegetable']
    file=source[randint(0,len(source)-1)]
    f=open(file+".txt")
    datas=list(f.read().split("\n"))
    f.close()
    quest=datas[randint(0,len(datas)-1)].lower()
    return quest,file

def space(d):
    s='\t'
    for i in range(2*d):
        s+=' '
    return s

def display(q):
    st=''
    for i in q:
        st+=i+" "
    return st
  
def main():
    question,tag=extraction()
    d=Diagram()
    draw=d.Dia
    qlist=[]
    plist=[]
    chlist=[]
    for i in question:
        qlist.append(i)
        if i!=' ':
            plist.append('_')
        else:
            plist.append(' ')
    print "\nQUESTION :- A ",tag
          
    n=1
    
    while n<=10:
        ch=raw_input("\n"+display(plist)+"\tEnter a Choice: ")[0]
        if ch in chlist:
            sleep(2)
            print space(len(qlist)),"Entered Character Already Tried.Plaese Re-enter"
            n-=1
        else:
            print space(len(qlist)),"Wait... Pray for the best to Happen !!! "
            if n<5:
              sleep(8)
            draw(n-1)
            chlist.append(ch)
            if ch in qlist:
                for i in range(len(qlist)):
                    if qlist[i]==ch:
                        plist[i]=ch
                display(plist)
                n-=1
            else:
                draw (n)
                print space(len(qlist)),"Better luck next time. Entered Choice not in the word."
                display(plist)
        if '_' not in plist:
            print "\n\nYou WON ! ! !\nThe Answer is ",question.lower().capitalize()
            break
        n+=1
    else:
        print "\n\nYou Hang the Man \nThe Answer is ",question.lower().capitalize()
            
main()
"""
ch=input("\n\nWould you like to Retry (Y/S) : ").lower()
if ch=='y':
  main()
"""
