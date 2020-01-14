A#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

char name[6];
char mode='R';
int base=-1;
int length=0;
char a[10];

int STARTADDRESS,LOCCTR,hex,len,add,final=0,size=0;

int OPsearch(char val[])
{
    char op[10];
    FILE *fptr = fopen("OPTAB-XE.doc", "r");

    while  (fscanf(fptr,"%s %X %X\n", op,&hex,&len)!=EOF)
    {
      if (strcmp(op,val)==0)
      {
          fclose(fptr);
          int t=1,h,l;
          char o[25];
          FILE *ptr = fopen("file-OPTAB.txt","r");
          while (fscanf(fptr,"%s %X %X\n", o,&h,&l)!=EOF)
          {
              if (strcmp(o,op)==0)
              {
                  t=-1;
                  break;
              }
          }
          fclose(ptr);
          if (t==1)
          {
              FILE *ptr = fopen("file-OPTAB.txt","a");
              fprintf(ptr,"%s %X %X\n", op,hex,len);
              fclose(ptr);
          }
          return len;
      }
    }
    fclose(fptr);
    printf("Error.....Invalid Operation Code");
    exit(0);
}

int regbank(char ch)
{
    switch (ch)
    {
      case 'A': return 0;
      case 'X': return 1;
      case 'L': return 2;
      case 'B': return 3;
      case 'S': return 4;
      case 'T': return 5;
      case 'F': return 6;
      default : printf ("invalid Register");
              exit(0);
    }
}

int isNUM(char val[])
{
  int t;
  for ( int i=0; val[i]!='\0'; i++)
    if(isdigit(val[i])==0)
      return -1;
  return 0;
}

int SYMsearch(char val[])
{
  char op[10];
  FILE *fptr = fopen("file-SYMTAB.txt", "r");
  while  (fscanf(fptr,"%s %c %X\n", op,&mode,&add)!=EOF)
  {
    if (strcmp(op,val)==0)
    {
      fclose(fptr);
      return add;
    }
  }
  fclose(fptr);
  return -1;
}

int expr(char s[])
{

  int f=0;
  char sub[10],ch='+';
  strcpy(sub,"");
  strcat(s,"+");
  for (int i=0;i<strlen(s); i++)
  {
      if (s[i] == '+' || s[i] == '-')
      {
          if (isNUM(sub)==-1)
          {
            if (SYMsearch(sub)==-1)
            {
                printf("Invalid Symbol For expr");
                exit(0);
            }
            if (mode=='R')
                f = (ch=='+')? f+1 : f-1 ;
          }
          else
              add = strtol(sub,NULL,16);

          final = (ch=='+')? (final+add) : (final-add);
          ch = s[i];
          strcpy(sub,"");
          continue;
      }
      sprintf(sub,"%s%c",sub,s[i]);
  }
  mode = (f==0)? 'A' : 'R';
  return final;
}

int operandCal(char operand[25])
{
  if (strcmp(operand,"*")==0)
  {
      mode = 'R';
      return (LOCCTR);
  }
  else if (isNUM(operand)==0)
  {
      mode = 'A';
      return (strtol(operand,NULL,16));
  }
  else
      return expr(operand);
}

int value(char str[25])
{
  int v=0;
  char ch=str[1];
  if (ch=='w' || ch=='W')
  {
    size = 3;
    strcpy(str,strtok(str,"=W\'"));
    char tmp[25];
    for (int i=0;i<strlen(str);i++)
    {
      sprintf(tmp,"%c",str[i]);
      v = v*16 + strtol(tmp,NULL,16);
    }
  }
  else if (ch=='x' || ch=='X')
  {
    strcpy(str,strtok(str,"=X\'"));
    size = (strlen(str))/2;
    v=strtol(str,NULL,16);
  }
  else if (ch=='C' || ch=='c')
  {
    size = (strlen(str)*0x1)/2;
    for (int i=3; i<strlen(str)-1 ; i++)
    {
      char tmp[25];
      sprintf(tmp,"%X",str[i]);
      v = v*256 + strtol(tmp,NULL,16);
    }
  }
  else v=-1;
  return v;
}

int LITsearch(char operand[25])
{
  char name[10];
  int s,val;
  char str[25];
  strcpy(str,operand);
  int v=value(str);
  FILE *fptr = fopen("file-LITTAB.txt", "r");
  while  (fscanf(fptr,"%s %X %s %X\n", name,&val,a,&s)!=EOF)
  {
    //printf("%X %X\n",v,val);
    if (v==val || strcmp(name,operand)==0)
      return v;
  }
  fclose(fptr);
  return -1;
}

void addLITTAB(char operand[25])
{
      char ch;
      int v=0;
      ch=operand[1];
      char str[25];
      strcpy(str,operand);
      v=value(str);
      if (v==-1)
      {
          printf("Invalid Literal");
          exit(0);
      }

      if (LITsearch(operand)==-1)
      {
        FILE *lptr = fopen("file-LITTAB.txt","a");
        fprintf(lptr,"%s %X - %X\n",operand,v,size);
        fclose(lptr);
      }
}

char *calculate(int LOCCTR, char opcode[25],char operand[25])
{
    char *instruction = (char *) malloc(10*sizeof(char));
    FILE *lptr=fopen("file-list.txt","a");
    fprintf(lptr,"%X %s %s ",LOCCTR,opcode,operand);
    strcpy(instruction,"");

    if (strcmp(opcode,"BASE")==0)
    {
        base = SYMsearch(operand);
        FILE *ptr=fopen("file-BASETAB.txt","a");
        fprintf(ptr,"Y %04X\n",base);
        fclose(ptr);
    }
    else if (strcmp(opcode,"NOBASE")==0)
    {
        base=-1;
        FILE *ptr=fopen("file-BASETAB.txt","a");
        fprintf(ptr,"N ----\n");
        fclose(ptr);
    }
    else if (strcmp(opcode,"RSUB")==0)
        strcpy(instruction,"4F0000");
    else if (strcmp(opcode,"BYTE")==0)
    {
    	char val[20];
    	strcpy(val,"");
    	if (operand[0]=='C' || operand[0]=='c')
		  {
			for (int i=2; i<strlen(operand)-1 ; i++)
			sprintf(val,"%s%X",val,operand[i]);
		  }
		  else
		  {
			for (int i=2; i<strlen(operand)-1 ; i++)
			sprintf(val,"%s%c",val,operand[i]);
		  }
        sprintf(instruction,"%lX",strtol(val,NULL,16));
    }
    else if (strcmp(opcode,"WORD")==0)
    {
        len = 0x3*(int)strtol(operand,NULL,16);
        sprintf(instruction,"%06X",(int)strtol(operand,NULL,16));
    }
    else if (strcmp(opcode,"EQU")==0)
        sprintf(operand,"%X",operandCal(operand));
    else if (strcmp(opcode,"RESW")==0 || strcmp(opcode,"RESB")==0);
    else if (strcmp(opcode,"*")==0)
    {
      sprintf(instruction,"%X",LITsearch(operand));
      goto L;
    }
    else
    {
          len = OPsearch(opcode);

          if (len==1)
              sprintf(instruction,"%X",hex);
          else if (len==2)
          {
              int t;
              if (strlen(operand)==3)
                  t = regbank(operand[2]);
              else t = 0;
              sprintf(instruction,"%02X%X%X",hex,regbank(operand[0]),t);
          }
          else
          {
              int t = len-3;
              char ch=operand[0];
              if (operand[strlen(operand)-2]==',')
                  t = t | 8 ;
              strcpy(operand,strtok(operand,"#@,"));

              if (ch=='#')
              {
                  hex = hex | 1;
                  if (operand[0]!='0' && strtol(operand,NULL,10)==0)
                  {
                      add = SYMsearch(operand);
                      if (add==-1)
                      {
                        printf("Program Error");
                        exit(0);
                      }
                      if (len==3)
                      {
                          t=2;
                          add = add - LOCCTR - len;
                      }
                  }
                  else
                      add = (int)strtol(operand,NULL,10);

                  if (len == 4)
                      sprintf(instruction,"%02X%X%05X", (hex | 1) ,t,add);
                  else
                      sprintf(instruction,"%02X%X%03X", (hex | 1) ,t,add);
              }
              else if (ch=='=')
              {
                  add = LITsearch(operand);
                  if (add!=-1)
                  {
                      add = strtol(a,NULL,16);
                      sprintf(instruction,"%02X2%03X",(hex|3),(add-(LOCCTR+len)) );
                  }
                  else
                  {
                      printf("\nInvalid Literal");
                      exit(0);
                  }
              }
              else
              {
                  hex = (ch=='@') ? (hex | 2) : (hex | 3);
                  if (LITsearch(operand)!=-1)
                      ;
                  else if (SYMsearch(operand)==-1 )
                  {
                      printf("Invalid Symbol");
                      exit(0);
                  }

                  //printf("*%X %X\n",base,add);
                  if (len == 4)
                      sprintf(instruction,"%02X%X%05X",hex,t,add);
                  else if ( (-add+(LOCCTR+len)) < 0x1000 )
                      sprintf(instruction,"%02X%X%03X",hex,(t | 2),(0xFFF & (add-(LOCCTR+len))));
                  else if ( (add-base) < 0x1000 )
                  {
                    sprintf(instruction,"%02X%X%03X",hex,(t | 4),(add-base));
                  }
                  else
                  {
                      printf("Program incorrect...");
                      exit(0);
                  }
              }
          }
    }
  L:
    fprintf(lptr,"\t%s\n",instruction);
    fclose(lptr);
    return instruction;
}

void pass1(char source[])
{
  char line[150],label[10],opcode[10],operand[25];

  FILE *sptr = fopen("file-SYMTAB.txt", "w");
  fclose(sptr);
  FILE *fptr = fopen("openfile.sic", "r");
  FILE *wptr = fopen("file-intermediate.txt", "w");

  while (fscanf(fptr,"%[^\n]\n", line) != EOF)
  {
    //strupr(line);
    //printf("%s\n",line);
    strcpy(label,"");
    strcpy(opcode,"");
    strcpy(operand,"0");
    char* tmp = strtok(line, " ");
    strcpy(opcode,tmp);
    tmp = strtok(NULL, " ");
    if (tmp!=NULL)
      strcpy(operand,tmp);
    tmp = strtok(NULL, " ");
    if (tmp!=NULL)
    {
          strcpy(label,opcode);
          strcpy(opcode,operand);
          strcpy(operand,tmp);
    }
    int l=0;
    if (strcmp(operand,"START")==0 || strcmp(operand,"RSUB")==0)
    {
        strcpy(label,opcode);
        strcpy(opcode,operand);
    }
    if (strcmp(opcode,"START")==0)
    {
      if (strcmp(label,"")==0)
        strcpy(label,"000000");
      strcpy (name,label);
      if (strcmp(operand,"")!=0)
        STARTADDRESS=(int)strtol(operand, NULL, 16);
      else
        STARTADDRESS=0x00;
      LOCCTR = STARTADDRESS;
    }

    else if (strcmp(opcode,"BASE")==0 || strcmp(opcode,"NOBASE")==0);

    else if (strcmp(opcode,"END")==0 || strcmp(opcode,"LTORG")==0)
    {
        char name[20];
        int v,s;
        char a[25],st[100];
        FILE *ptr = fopen ("file-LITTAB.txt","r");
        FILE *fptr = fopen ("file-LITTAB-tmp.txt","w");

        while  (fscanf(ptr,"%s %X %s %X\n", name,&v,a,&s)!=EOF)
        {
          if (strcmp(a,"-")==0)
          {
            fprintf(fptr,"%s %X %X %X\n", name,v,LOCCTR,s);
            fprintf(wptr,"%X * %s\n",LOCCTR,name);
            LOCCTR += s;
          }
          else
          fprintf(fptr,"%s %X %s %X\n", name,v,a,s);
        }
        fclose(fptr);
        fclose(ptr);

        ptr = fopen ("file-LITTAB-tmp.txt","r");
        fptr = fopen ("file-LITTAB.txt","w");
        while  (fscanf(ptr,"%[^\n]\n", st)!=EOF)
        fprintf(fptr,"%s\n", st);
        fclose(fptr);
        fclose(ptr);
      if (strcmp(opcode,"LTORG")==0)
        continue;
      else if (strcmp(opcode,"END")==0)
      {
        fprintf(wptr,"%X %s %s\n", LOCCTR,opcode,operand);
        break;
      }
    }
    else if (strcmp(opcode,"ORG")==0)
    {
        int val = operandCal(operand);
        if (val == -1)
            printf("Invalid Symbol for ORG");
        else
            LOCCTR = add;
        continue;
    }
    else if (strcmp(opcode,"EQU")==0)
    {
        int final=operandCal(operand);
        sptr = fopen("file-SYMTAB.txt", "a");
        fprintf(sptr,"%s %c %X\n",label,mode,final);
        fclose(sptr);
    }
    else
    {
          char op[10];

          if (strcmp(label,"")!=0)
          {
              if ( SYMsearch(label)==-1)
              {
                sptr = fopen("file-SYMTAB.txt", "a");
                fprintf(sptr,"%s R %X\n",label,LOCCTR);
                fclose(sptr);
              }
              else
              {
                printf("Duplicate Symbol...");
                fprintf(wptr,"%X %s %s\n", LOCCTR,opcode,operand);
                goto L1;
              }
          }

          if (strcmp(opcode,"WORD")==0)
            l= 0x3;
          else if (strcmp(opcode,"RESW")==0)
            l= ((int)strtol(operand, NULL, 10)*0x3);
          else if (strcmp(opcode,"RESB")==0)
            l= ((int)strtol(operand, NULL, 10)*0x1);
          else if (strcmp(opcode,"BYTE")==0)
          {
            char ch=operand[0];
            if (ch=='C' || ch=='c')
                l= 0x1*(strlen(operand)-0x3);
            else if (ch=='x' || ch=='X')
                l= (0x1*(strlen(operand)-0x3)/0x2);
          }
          else
                l= OPsearch(opcode);

          if (operand[0]=='=')
          {
            addLITTAB(operand);
            fprintf(wptr,"%X %s %s\n", LOCCTR,opcode,operand);
            LOCCTR += l;
            continue;
          }
          if (strcmp(opcode,"RESB")==0 ||strcmp(opcode,"RESW")==0)
                sprintf(operand,"%X",l);

    }
    fprintf(wptr,"%X %s %s\n", LOCCTR,opcode,operand);
    LOCCTR += l;
  }
  length = LOCCTR - STARTADDRESS ;
  L1:
  fclose(wptr);
  fclose(fptr);
}

void pass2()
{
  char opcode[10],operand[25],record[80],instruction[20];
  int tempstart,LOCCTR;
  FILE *sptr = fopen("file-list.txt", "w");
  fclose(sptr);
  FILE *fptr = fopen("file-intermediate.txt", "r");
  FILE *wptr = fopen("objectcode.txt", "w");
  strcpy(record,"");

  tempstart=STARTADDRESS;
  while (fscanf(fptr,"%X %s %s\n", &LOCCTR,opcode,operand) != EOF)
  {
      if (strcmp(opcode,"START")==0)
      {
          fprintf(wptr,"H^%s^%06X^%06X\n",name,STARTADDRESS,length);
          strcpy(record,"");
          continue;
      }
      else if (strcmp(opcode,"END")==0)
          break;

      strcpy(instruction, calculate(LOCCTR,opcode,operand));


    if ((LOCCTR - tempstart + len) > 0x1E || strcmp(opcode,"RESW")==0 || strcmp(opcode,"RESB")==0 )
    {
      if (strcmp(record,"")!=0)
      	fprintf(wptr,"T^%06X^%02X^%s\n",tempstart,(LOCCTR-tempstart),record);
      tempstart=LOCCTR;
      strcpy(record,"");
      strcpy(instruction,"");
      continue;
    }
    if (strcmp(opcode,"WORD")==0 || strcmp(opcode,"BYTE")==0)
    {
      fprintf(wptr,"T^%06X^%02X^%s%s\n",tempstart,(LOCCTR-tempstart+strlen(instruction)/2),record,instruction);
      tempstart=LOCCTR + strlen(instruction)/2;
      strcpy(record,"");
      strcpy(instruction,"");
      continue;
    }
     if (strcmp(instruction,"")!=0)
           sprintf(record,"%s%s^",record,instruction);
    }
    if (strcmp(record,"")!=0)
        fprintf(wptr,"T^%06X^%02X^%s\n",tempstart,(LOCCTR-tempstart),record);
    fprintf(wptr,"E^%06X\n",(int)strtol(operand, NULL, 16));

    fclose(fptr);
    fclose(wptr);
}

void main()
{
    char source[15];
    strcpy(source,"sourcecode.doc");
    FILE *ptr = fopen("file-LITTAB.txt","w");
    fclose(ptr);
    ptr = fopen("file-LITTAB-tmp.txt","w");
    fclose(ptr);
    ptr = fopen("file-OPTAB.txt","w");
    fclose(ptr);
    ptr = fopen("file-BASETAB.txt","w");
    fprintf(ptr,"N ----\n");
    fclose(ptr);
    pass1(source);
    //printf("PROGRAM NAME: %s\nSTARTADDRESS: %X\nLENGTH: %X\nPass 1 completed successfully...",name,STARTADDRESS,length);
    pass2();
    //printf("\nPass 2 completed successfully...");
}
