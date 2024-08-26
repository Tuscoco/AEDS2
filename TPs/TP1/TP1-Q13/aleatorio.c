#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

void substituir(char* str,char c,char s,int cont)
{

    if(cont == strlen(str)){

        str = str;

    }else if(str[cont] != c){

        str[cont] = str[cont];

        substituir(str,c,s,cont + 1);

    }else{

        str[cont] = s;

        substituir(str,c,s,cont + 1);

    }

}

void chamarSubstituir(char* str,char c,char s){
    substituir(str,c,s,0);
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

    char c;
    char s;
    srand(4);

    char* str = (char*) malloc(1000 * sizeof(char));

    //char c = ('a' + (rand() % 26));
    //char s = ('a' + (rand() % 26));

    do{

        scanf(" %[^\n]", str);

        if(!fim(str)){

            c = (char)('a' + (rand() % 26));
            s = (char)('a' + (rand() % 26));

            chamarSubstituir(str,c,s);

            printf("%s\n", str);

        }

    }while(!fim(str));

    return 0;

}