#include <stdio.h>
#include <stdlib.h>

void escreverArquivo(int n)
{

    FILE *f = fopen("tp1q9.txt","w");
    double v;

    for(int i = 0;i < n;i++){

        scanf("%lf",&v);

        fprintf(f,"%lf\n",v);

    }

    fclose(f);

}

void lerArquivo(int n)
{

    FILE *f = fopen("tp1q9.txt","r");
    double v;

    long size = sizeof(double);
    
    fseek(f,0,SEEK_END);
    
    long length = ftell(f);

    long pos = ftell(f);

    for(int i = 0;i < n;i++){

        do{

            fseek(f, pos--, SEEK_SET);

        }while(ftell(f) > 0 && fgetc(f) != '\n');

        if (ftell(f) != 0) {

            fseek(f, pos + 2, SEEK_SET);

        } else {

            fseek(f, 0, SEEK_SET);

        }
        
        fscanf(f,"%lf",&v);
        
        if(v != 0){
            printf("%g\n",v);
        }

    }

    fclose(f);

}

int main()
{

    int n;

    scanf("%d",&n);

    escreverArquivo(n);

    lerArquivo(n);

    return 0;

}