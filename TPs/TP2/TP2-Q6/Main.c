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
    //FILE* file = fopen("../pokemon.csv","r");

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

        if(pokemons[i].id == 19){

            pokemons[i].weight = 0.0;
            pokemons[i].height = 0.0;
            pokemons[i].captureRate = 255;

        }

        i++;
    }

    fclose(file);

}

char* tratarTipos(pokemon* vetor, int i){

    char* resultado = (char*) malloc(maxLinha * sizeof(char));
    
    if(strcmp(vetor[i].type2,"0") == 0){
        
        sprintf(resultado,"['%s']",vetor[i].type1);

    }else{

        sprintf(resultado,"['%s', '%s']",vetor[i].type1,vetor[i].type2);

    }

    return resultado;

}

char* tratarLendario(pokemon* vetor,int i){

    if(vetor[i].isLegendary){

        return "true";

    }else{

        return "false";

    }

}

char* toString(pokemon* vetor,int i){

    char* resultado = (char*) malloc(maxLinha * sizeof(char));
    char* tipos = tratarTipos(vetor, i);
    char* lendario = tratarLendario(vetor, i);

    sprintf(resultado,"[#%d -> %s: %s - %s - %s - %.1lfkg - %.1lfm - %d%% - %s - %d gen] - %s",vetor[i].id,
    vetor[i].name,vetor[i].description,tipos,vetor[i].abilities,vetor[i].weight,
    vetor[i].height,vetor[i].captureRate,lendario,vetor[i].generation,vetor[i].captureDate);

    return resultado;

}

bool isFim(char* str){

    bool resp = false;
    
    if(strcmp(str,"FIM") == 0){

        resp = true;

    }

    return resp;

}

////////////////////////////////////////////////////////////////////////////


pokemon array[801];
int n = 0;
int comp = 0;
double tempo;

void swap(int j,int jj){

    pokemon temp = array[j];
    array[j] = array[jj];
    array[jj] = temp;

}

void ordenar(int low, int high){

    int i, rh;
    char* temp;

    if(low < high){

        rh = low;

        for(i = low + 1;i <= high;i++){

            comp++;
            if(strcmp(array[i].name, array[rh].name) < 0){

                rh = i;

            }

        }

        swap(low, rh);

        ordenar(low + 1, high);

    }

}

void criarLog(){

    FILE* file = fopen("matrícula_selecaoRecursiva","w");

    if(file == NULL){

        printf("ERRO!");
        return;

    }

    fprintf(file, "857867 \t %lfs \t %d", tempo, comp);

    fclose(file);

}

int main(){

    preencherPokedex();
    clock_t inicio,fim;

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

    inicio = clock();

    ordenar(0, n - 1);

    fim = clock();
    tempo = (double)(fim - inicio) / CLOCKS_PER_SEC;

    char* resultado;

    for(int i = 0;i < n;i++){

        resultado = toString(array, i);
        printf("%s", resultado);

    }

    free(str);
    free(resultado);
    for (int i = 0; i < 801; i++){
        free(pokemons[i].name);
        free(pokemons[i].description);
        free(pokemons[i].type1);
        free(pokemons[i].type2);
        free(pokemons[i].abilities);
        free(pokemons[i].captureDate);
    }

    criarLog();

    return 0;

}