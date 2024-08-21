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

    for(int i = 1;i <= n;i++){

        fseek(f,(-i * length),SEEK_END);
        
        fscanf(f,"%lf",&v);
        
        printf("%g\n",v);

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