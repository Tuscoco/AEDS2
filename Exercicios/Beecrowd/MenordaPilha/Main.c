#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int cont = 0;

void op(char* str,int* array){

    if(strcmp(str,"POP") == 0){

        if(cont == 0){

            printf("EMPTY\n");

        }else{

            cont--;

        }

    }else if(strcmp(str,"MIN") == 0){

        if(cont == 0){

            printf("EMPTY\n");

        }else{

            int menor = array[0];

            for(int i = 1;i < cont;i++){

                if(menor > array[i]){

                    menor = array[i];

                }

            }

            printf("%d\n",menor);

        }

    }else{
        
        int num;

        sscanf(str, "PUSH %d", &num);

        array[cont] = num;
        cont++;


    }

}

int main()
{

    int n;
    
    scanf("%d",&n);
    getchar();

    int* array = (int*) malloc(n * sizeof(int));

    for(int i = 0;i < n;i++){

        char str[20];

        fgets(str, sizeof(str), stdin);
        str[strcspn(str,"\n")] = '\0';

        op(str,array);

    }

    free(array);

    return 0;

}