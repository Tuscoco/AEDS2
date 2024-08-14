#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int maiusculas(char* str){

    int resultado = 0;
    int length = strlen(str);

    for(int i = 0;i < length;i++){

        int ascii = str[i];

        if(ascii >= 65 && ascii <= 90){

            resultado++;

        }

    }

    return resultado;

}

bool fim(char* str){

    bool resultado = false;

    if(strcmp(str,"FIM") == 0){

        resultado = true;

    }

    return resultado;

}

void limparBuffer()
{
    int n;
    while((n = getchar()) != '\n' && n != EOF);
}

int main()
{

    char str[1000];
    int resultado;

    do{

        scanf("%[^\n]", str);
        limparBuffer();

        if(!fim(str)){

            resultado = maiusculas(str);

            printf("%d\n",resultado);

        }

    }while(!fim(str));

    return 0;

}