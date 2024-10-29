#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void ordenar(char array[][50], int cont){

    for(int i = 1;i < cont;i++){

        char tmp[50];
        strcpy(tmp, array[i]);
        int j = i - 1;

        while((j >= 0) && (strlen(array[j]) < strlen(tmp))){

            strcpy(array[j + 1], array[j]);
            j--;

        }

        strcpy(array[j + 1], tmp);

    }

}

void separar(char* str){

    char array[50][50];
    int cont = 0;

    char strCopy[1000];
    strcpy(strCopy, str);

    char* tok = strtok(strCopy, " ");
    while(tok != NULL && cont < 50){

        strcpy(array[cont], tok);
        cont++;
        tok = strtok(NULL," ");

    }

    ordenar(array,cont);

    str[0] = '\0';
    for(int i = 0;i < cont;i++){

        strcat(str, array[i]);
        if(i < cont - 1){

            strcat(str, " ");

        }

    }

}

int main(){

    int n;
    char* str = malloc(1000 * sizeof(char));

    scanf("%d",&n);
    getchar();

    for(int i = 0;i < n;i++){

        fgets(str, 1000, stdin);
        str[strcspn(str, "\n")] = '\0';

        separar(str);

        printf("%s\n", str);

    }

    free(str);

    return 0;

}