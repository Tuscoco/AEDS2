#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

char* combinador(char* str1,char* str2)
{

    int length = strlen(str1) + strlen(str2);
    char* resultado = (char*) malloc(length * sizeof(char));
    bool acabou = false;
    char* maior;
    char* menor;
    
    if(strlen(str1) > strlen(str2) || strlen(str1) == strlen(str2)){

        maior = str1;
        menor = str2;

        for(int i = 0,j = 0;i < length;i++,j++){

            resultado[i] = maior[j];

            if(menor[j] == '\0'){

                acabou = true;

            }

            if(!acabou){

                resultado[i + 1] = menor[j];
                i++;

            }

        }

    }else if(strlen(str2) > strlen(str1)){

        maior = str2;
        menor = str1;

        for(int i = 0,j = 0;i < length;i++,j++){

            resultado[i] = menor[j];

            if(maior[j] == '\0'){

                acabou = true;

            }

            if(!acabou){

                resultado[i + 1] = maior[j];
                i++;

            }

        }

    }

    resultado[length] = '\0';

    return resultado;

}

int main()
{

    char str1[1000],str2[1000];
    char* resultado;

    while((scanf(" %s %s", str1, str2)) == 2){

        resultado = combinador(str1,str2);

        printf("%s\n", resultado);

    }

    free(resultado);

    return 0;

}