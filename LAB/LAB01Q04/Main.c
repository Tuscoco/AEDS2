#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int maiusculas(char* str,int c,int n){

    if(c == strlen(str)){
        
        return n;

    }else{

        int ascii = str[c];

        if(ascii >= 65 && ascii <= 90){
            
            n++;

        }

    }

    return maiusculas(str,c + 1,n);

}

int chamarMaiusculas(char* str){
    return maiusculas(str,0,0);
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

            resultado = chamarMaiusculas(str);

            printf("%d\n",resultado);

        }

    }while(!fim(str));

    return 0;

}