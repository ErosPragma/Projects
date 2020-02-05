def display(a):
    for i in range(3):
        tmp=''
        for j in range (3):
            tmp=tmp+" \t "+a[i][j]
        print tmp,"\n"
        
def enter(a,n):
    num=raw_input("Enter the coordinate: ").strip()
    if len(num)==2:
        r=int(num[:1])-1
        c=int(num[1:])-1
        if (r>2 or c>2) :
            print "Wrong Entry, Please Re-enter"
            return -1
        elif  a[r][c]!='_':
            print "Wrong Entry, Please Re-enter"
            return -1
        else:
            if n%2!=0:
                a[r][c]='X'
            else:
                a[r][c]='O'
            display(a)
            if check(a)==1:
                return 1
            return 0
    else:
        return -1

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
n=0
t=-1
display(a)
while n<8:
    n+=1
    temp=enter (a,n)
    if temp==1:
        t=0
        break
    elif temp==-1:
        temp=enter(a,n)
if n%2==1:
    player=n%2
else:
    player=2
if t==0:
    print "\n\nTIC TOE\nPlayer",player," WON "
else:
    print "\n\nNobody Wins"
raw_input()
