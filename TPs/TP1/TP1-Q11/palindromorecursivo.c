#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool fim(char* string){

    bool fim = false;

    if(strcmp(string,"FIM") == 0){
        fim = true;
    }

    return fim;

}

bool ehPalindromo(char* string,int c){

    bool resultado;

    if(c == strlen(string)/2){

        resultado = true;

    }else if(string[c] != string[strlen(string)-c-1]){

        resultado = false;

    }else{
        
        return ehPalindromo(string,c + 1);

    }

    return resultado;

}

bool chamarEhPalindromo(char* string){
    bool result = ehPalindromo(string,0);
    return result;
}

void limparBuffer()
{
    int n;
    while((n = getchar()) != '\n' && n != EOF);
}

int main()
{

    char str[1000];

    do{

        scanf("%[^\n]",str);
        limparBuffer();

        if(!fim(str)){

            if(chamarEhPalindromo(str)){

                printf("SIM\n");

            }else{

                printf("NAO\n");

            }

        }
        
    }while(!fim(str));

    return 0;

}