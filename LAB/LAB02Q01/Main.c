#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* combinador(char* str1,char* str2)
{

    int length = strlen(str1) + strlen(str2);

    char* resultado = (char*) malloc(length * sizeof(char));

    int j = 0;

    while(str1[j] != '\0'){

    }

    return resultado;

}

int main()
{

    char str1[1000],str2[1000];

    for(int i = 0;i < 3;i++){

        scanf(" [^\n] [^\n] ", str1,str2);

        char* resultado = combinador(str1,str2);

        printf(" %s\n", resultado);

    }

    return 0;

}