#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

char* verificarBola(int* array,int tam)
{
    int n = tam;
    char* resultado = (char*) malloc(100 * sizeof(char));
    bool acabou = false;

    while(!acabou){

        for(int i = 0;i < n - 1;i++){

            if(array[i] == array[i + 1]){
                array[i] = 1;
            }else{
                array[i] = -1;
            }

        }

        n--;

        if(n == 1){
            acabou = true;
        }

    }
    
    if(array[0] == 1){
        resultado = "preta";
    }else if(array[0] == -1){
        resultado = "branca";
    }

    return resultado;

}

int main()
{

    int n;
    scanf("%d",&n);

    int* array = (int*) malloc(n * sizeof(int));

    for(int i = 0;i < n;i++){
        scanf("%d",&array[i]);
    }

    char* resultado = verificarBola(array,n);

    printf("%s\n", resultado);

    return 0;

}