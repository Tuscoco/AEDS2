#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

char* substituir(char* str,char c,char s)
{

    int length = strlen(str);

    for(int i = 0;i < length;i++){

        if(str[i] == c){

            str[i] = s;

        }

    }

    char* resultante = str;

    return resultante;

}

bool fim(char* str)
{

    bool resultado = false;

    if(strcmp(str,"FIM") == 0){

        resultado = true;

    }

    return resultado;

}

int main()
{

    srand(4);

    char str[1000];

    do{

        scanf(" %[^\n]", str);

        if(!fim(str)){

            int num1 = 97 + rand() % (122 - 97 + 1);
            char c = (char) num1;
            int num2 = 97 + rand() % (122 - 97 + 1);
            char s = (char) num2;

            char* subs = substituir(str,c,s);

            printf("%s\n", subs);

        }

    }while(!fim(str));

    return 0;

}