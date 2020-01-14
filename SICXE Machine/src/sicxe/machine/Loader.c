# include <stdio.h>
# include <stdlib.h>
# include <string.h>
# include <time.h>

void main()
{
  int *memory;
    srand(time(0));
    char recordtype;
    int progaddr,prgmlen,start,len,length=0;
    char type;
    char name[8],record[150],tmp[10];

   FILE *ptr = fopen("C:\\Users\\USER\\github\\Netbeans-Projects\\SICXE Machine\\src\\sicxe\\machine\\objectcode.txt","r");

   while  (fscanf(ptr,"%[^\n]\n",record)!=EOF)
   {
        recordtype = record[0];
        if (recordtype=='H')
        {
            sprintf(name,"%c%c%c%c%c%c",record[2],record[3],record[4],record[5],record[6],record[7]);
            sprintf(tmp,"%c%c%c%c%c%c",record[9],record[10],record[11],record[12],record[13],record[14]);
            progaddr = strtol(tmp,NULL,16);
            if (progaddr==0)
                progaddr = (rand()%10)*1000;

            sprintf(tmp,"%c%c%c%c%c%c",record[16],record[17],record[18],record[19],record[20],record[21]);
            prgmlen = strtol(tmp,NULL,16);
            memory = (int*) calloc (prgmlen,sizeof(int));

            for(int i=0;i<prgmlen;i++)
              memory[i]=-1;
        }
        else if (recordtype=='T')
        {
          sprintf(tmp,"%c%c%c%c%c%c",record[2],record[3],record[4],record[5],record[6],record[7]);
          start = strtol(tmp,NULL,16);
          sprintf(tmp,"%c%c",record[9],record[10]);
          len = strtol(tmp,NULL,16);

          for (int i=12 ;record[i]!='\0'; i+=2)
          {
            if (record[i]=='^')
                i+=0x1;
            sprintf(tmp,"%c%c",record[i],record[i+1]);
            memory[start] = strtol(tmp,NULL,16);
            start += 0x1;
            length+= 0x1;
          }
        }
        else if (recordtype=='M')
        {
          sprintf(tmp,"%c%c%c%c%c%c",record[2],record[3],record[4],record[5],record[6],record[7]);
          start = strtol(tmp,NULL,16);
          sprintf(tmp,"%c%c",record[9],record[10]);
          len = strtol(tmp,NULL,16);

          switch (len)
          {
            case 4 :
            case 3 : memory[start] = progaddr/0x100;
                     memory[start+0x1] = progaddr%0x100;
                     break;
            case 5 :
            case 6 : memory[start] = progaddr/0x10000;
                     memory[start+0x1] = (progaddr%0x100)/0x100;
                     memory[start+0x2] = progaddr&0x100;
                     break;
          }
        }
        if (recordtype=='E')
            break;
   }
   fclose(ptr);


   ptr = fopen("file-memory.txt","w");
   for (int i=0x0;i<=prgmlen;i+=0x1)
  {
      if(memory[i]!=-1)
        //printf("%X\t%02X\n",i+progaddr,memory[i]);
        fprintf(ptr,"%X\t%X\n",i+progaddr,memory[i]);
  }
  fclose(ptr);
}
