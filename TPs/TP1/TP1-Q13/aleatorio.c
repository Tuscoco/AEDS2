#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

char* substituir(char* str,char c,char s,int cont)
{

    if(str[cont] == '\0'){
        return;
    }

    if(str[cont] == c){

        str[cont] = s;

    }

    return substituir(str,c,s,cont + 1);

}

char* chamarSubstituir(char* str,char c,char s){
    return substituir(str,c,s,0);
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

            char c = (char) (97 + rand() % (122 - 97 + 1));
            char s = (char) (97 + rand() % (122 - 97 + 1));

            char* subs = chamarSubstituir(str,c,s);

            printf("%s\n", subs);

        }

    }while(!fim(str));

    return 0;

}