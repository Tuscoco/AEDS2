#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>

#define maxLinha 160

typedef struct pokemon
{
    
    int id;
    int generation;
    char* name;
    char* description;
    char* type1;
    char* type2;
    char* abilities;
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    char* captureDate;

}pokemon;

pokemon pokemons[801];

void substring(const char *original, char *data, int length){

    strncpy(data, original + (strlen(original) - 11), length);
    data[length] = '\0';

}

void preencherPokedex(){

    FILE* file = fopen("/tmp/pokemon.csv","r");
    //FILE* file = fopen("pokemon.csv","r");

    if(file == NULL){
        printf("Erro!");

        return;
    }

    char linha[maxLinha];

    fgets(linha, maxLinha, file);

    int i = 0;

    while(fgets(linha, maxLinha, file) && i < 801){

        char data[13];
        substring(linha, data, 12);
        char* token1 = strtok(linha,"\"");
        char* primeiraParte = token1;
        char* token2 = strtok(NULL,"\"");
        char* habilidades = token2 ? strdup(token2) : NULL;
        char* token3 = strtok(NULL,"\"");
        char* segundaParte = token3;


        char* tok = strtok(primeiraParte,",");
        pokemons[i].id = atoi(tok);

        tok = strtok(NULL,",");
        pokemons[i].generation = atoi(tok);

        tok = strtok(NULL,",");
        pokemons[i].name = strdup(tok ? tok : "");

        tok = strtok(NULL,",");
        pokemons[i].description = strdup(tok ? tok : "");

        tok = strtok(NULL,",");
        pokemons[i].type1 = strdup(tok ? tok : "");

        tok = strtok(NULL,",");
        pokemons[i].type2 = (tok && strlen(tok) > 0) ? strdup(tok) : strdup("0");

        pokemons[i].abilities = habilidades ? habilidades : strdup("");

        char* tok2 = strtok(segundaParte,",");
        pokemons[i].weight = (tok2 && strlen(tok2) > 0) ? strtod(tok2, NULL) : 0;

        tok2 = strtok(NULL,",");
        pokemons[i].height = (tok2 && strlen(tok2) > 0) ? strtod(tok2, NULL) : 0;

        tok2 = strtok(NULL,",");
        pokemons[i].captureRate = atoi(tok2);

        tok2 = strtok(NULL,",");
        pokemons[i].isLegendary = (tok2 && atoi(tok2) != 0);

        tok2 = strtok(NULL,",");
        pokemons[i].captureDate = strdup(data);

        i++;
    }

    fclose(file);

}

char* tratarTipos(int n){

    char* resultado = (char*) malloc(maxLinha * sizeof(char));
    
    if(strcmp(pokemons[n - 1].type2,"0") == 0){
        
        sprintf(resultado,"['%s']",pokemons[n - 1].type1);

    }else{

        sprintf(resultado,"['%s', '%s']",pokemons[n - 1].type1,pokemons[n - 1].type2);

    }

    return resultado;

}

char* tratarLendario(int n){

    if(pokemons[n - 1].isLegendary){

        return "true";

    }else{

        return "false";

    }

}

char* toString(int n){

    char* resultado = (char*) malloc(maxLinha * sizeof(char));
    char* tipos = tratarTipos(n);
    char* lendario = tratarLendario(n);

    sprintf(resultado,"[#%d -> %s: %s - %s - %s - %.1lfkg - %.1lfm - %d%% - %s - %d gen] - %s",pokemons[n - 1].id,
    pokemons[n - 1].name,pokemons[n - 1].description,tipos,pokemons[n - 1].abilities,pokemons[n - 1].weight,
    pokemons[n - 1].height,pokemons[n - 1].captureRate,lendario,pokemons[n - 1].generation,pokemons[n - 1].captureDate);

    return resultado;

}

bool isFim(char* str){

    bool resp = false;
    
    if(strcmp(str,"FIM") == 0){

        resp = true;

    }

    return resp;

}


pokemon array[801];
int n = 0;
int comp = 0;
double tempo;


void swap(int j,int jj){

    pokemon temp = array[j];
    array[j] = array[jj];
    array[jj] = temp;

}

void ordenar(){

    bool swapped = true;

    for(int i = (n - 1);i > 0 && swapped;i--){

        swapped = false;

        for(int j = 0;j < i;j++){

            if(strcmp(array[j].name,array[j + 1].name) > 0){

                swap(j,j + 1);
                swapped = true;

            }

        }

    }

}

bool pesquisa(char* pok){

    bool resultado = false;

    int esq = 0,dir = n - 1,meio;

    while(esq <= dir){

        meio = (dir + esq)/2;

        comp++;
        if(strcmp(pok, array[meio].name) == 0){

            resultado = true;
            esq = n;

        }

        comp++;
        if(strcmp(pok, array[meio].name) > 0){

            esq = meio + 1;

        }else{

            dir = meio - 1;

        }

    }

    return resultado;

}

void criarLog(){

    FILE* file = fopen("matrícula_binaria.txt","w");

    if(file == NULL){

        printf("ERRO!");
        return;

    }

    fprintf(file, "857867 \t %lfs \t %d", tempo, comp);

    fclose(file);

}

int main(){

    clock_t inicio,fim;

    inicio = clock();

    preencherPokedex();

    char* str = (char*) malloc(20 * sizeof(char));

    do{

        fgets(str, 20, stdin);
        str[strcspn(str, "\n")] = 0;

        if(!isFim(str)){

            int num = atoi(str);

            array[n] = pokemons[num - 1];

            n++;

        }

    }while(!isFim(str));

    ordenar();

    do{

        fgets(str, 20, stdin);
        str[strcspn(str, "\n")] = 0;

        if(!isFim(str)){

            if(pesquisa(str) == true){

                printf("SIM\n");

            }else{

                printf("NAO\n");

            }

        }

    }while(!isFim(str));

    fim = clock();

    tempo = (double)(fim - inicio) / CLOCKS_PER_SEC;

    criarLog();

    return 0;

}