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

    fseek(f,0,SEEK_END);
    long length = ftell(f);

    for(long i = length - 8;i >= 0;i -= 8){

        fseek(f,i,SEEK_SET);
        
        fscanf(f,"%lf",&v);
        printf("%lf\n",v);

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