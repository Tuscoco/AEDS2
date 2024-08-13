#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool palindromo(char* string)
{
    int length = strlen(string);
    bool resultado = true;
    int i = 0, j = 0;

    for(i = 0,j = length-1; i < length/2;i++, j--)
    {

        if(string[i] != string[j])
        {
            resultado = false;
            i = length;
        }
        
    }

    return resultado;
}

bool fim(char* string)
{
    bool fim = false;

    if(strcmp(string,"FIM") == 0)
    {
        fim = true;
    }

    return fim;
}

void limparBuffer()
{
    int n;
    while((n = getchar()) != '\n' && n != EOF);
}

int main()
{
    char str[1000];

    do
    {
        scanf("%[^\n\r]", str);
        limparBuffer();
        
        if(!fim(str))
        {
            if(palindromo(str))
            {
                printf("SIM\n");
            }else{
                printf("NAO\n");
            }
        }

    }while(!fim(str));

    return 0;
}