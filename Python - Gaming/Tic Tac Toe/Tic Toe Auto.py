from random import randrange
import string,time

def display(a):
    for i in range(3):
        tmp=''
        for j in range (3):
            tmp=tmp+" \t "+a[i][j]
        print tmp,"\n"

def randomInput(a,ch):
    r=randrange(0,3)
    c=randrange(0,3)
    if  a[r][c]!='_':
            randomInput(a,ch)
    else:
            print "\nLet the Computer Thinks....."
            time.sleep(1)
            a[r][c]=ch[2]

def enter(a,n,ch):
    r=input("Enter the row at where you need to input: ")-1
    c=input("Enter the col at where you need to input: ")-1

    if (r>2 or c>2) :
            print "Wrong Entry, Please Re-enter"
            return -1
    elif  a[r][c]!='_':
            print "Wrong Entry, Please Re-enter"
            return -1
    else:
            a[r][c]=ch[1]
    display(a)
    if check(a)==1:
            return 1

    if n!=5:
        randomInput(a,ch)
        display(a)
        if check(a)==1:
            return 2
    return 0


def check(a):
    for i in range(3):
        j=1
        tr=0
        tc=0
        while j<3:
            if a[i][0]==a[i][j] and a[i][j]!='_':
                tr+=1
            if a[0][i]==a[j][i] and a[j][i]!='_':
                tc+=1
            j+=1
        if tr==2 or tc==2:
            return 1
    if a[1][1]!='_':
        if(a[0][0]==a[1][1] and a[0][0]==a[2][2]) or (a[0][2]==a[1][1] and a[1][1]==a[2][0]):
            return 1
    return 0

a=[['_','_','_'],['_','_','_'],['_','_','_']]
ch=raw_input("Choose Your Lucky Character X or O ").capitalize()
if ch=='X':
        chPC='O'
else:
        chPC='X'
dic={1:ch,2:chPC}

t=-1
display(a)
for n in range(1,6):
    temp=enter(a,n,dic)
    if temp==-1:
        temp=enter(a,n,dic)
    elif temp==1 or temp==2:
        t=temp
        break


if t==1:
    print "\n\nTIC TAC TOE\nYou WON over the Computer ! ! !"
elif t==2:
    print "\n\nTIC TAC TOE\nSorry, You are not good enough for the Computer."
else:
    print "\n\nNobody Wins"
