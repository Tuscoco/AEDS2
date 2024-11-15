#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>
#include <math.h>

#define maxLinha 160
#define MAXTAM 801

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

char* tratarTipos(pokemon vetor){

    char* resultado = (char*) malloc(maxLinha * sizeof(char));
    
    if(strcmp(vetor.type2,"0") == 0){
        
        sprintf(resultado,"['%s']",vetor.type1);

    }else{

        sprintf(resultado,"['%s', '%s']",vetor.type1,vetor.type2);

    }

    return resultado;

}

char* tratarLendario(pokemon vetor){

    if(vetor.isLegendary){

        return "true";

    }else{

        return "false";

    }

}

char* toString(pokemon vetor){

    char* resultado = (char*) malloc(maxLinha * sizeof(char));
    char* tipos = tratarTipos(vetor);
    char* lendario = tratarLendario(vetor);

    sprintf(resultado,"[#%d -> %s: %s - %s - %s - %.1lfkg - %.1lfm - %d%% - %s - %d gen] - %s",vetor.id,
    vetor.name,vetor.description,tipos,vetor.abilities,vetor.weight,
    vetor.height,vetor.captureRate,lendario,vetor.generation,vetor.captureDate);

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

//CELULA
typedef struct Celula{

    pokemon elemento;
    struct Celula *prox;

}Celula;

Celula *novaCelula(pokemon elemento){

    Celula *nova = (Celula*) malloc(sizeof(Celula));
    nova->elemento = elemento;
    nova->prox = NULL;
    
    return nova;

}

//FILA CIRCULAR
Celula *primeiro, *ultimo;
int cont = 0;
pokemon tmp;

void start(){

    primeiro = novaCelula(tmp);
    primeiro->elemento.name = "Removido";
    primeiro->prox = novaCelula(tmp);
    ultimo = primeiro->prox;
    ultimo->elemento.name = "Removido";

    ultimo->prox = novaCelula(tmp);
    ultimo = ultimo->prox;
    ultimo->elemento.name = "Removido";

    ultimo->prox = novaCelula(tmp);
    ultimo = ultimo->prox;
    ultimo->elemento.name = "Removido";

    ultimo->prox = novaCelula(tmp);
    ultimo = ultimo->prox;
    ultimo->elemento.name = "Removido";

    ultimo->prox = novaCelula(tmp);
    ultimo = ultimo->prox;
    ultimo->elemento.name = "Removido";

    ultimo->prox = primeiro;
    ultimo = ultimo->prox;

}

void media(){

    Celula *i = primeiro;
    int quant = 0;
    float total = 0;

    for(int j = 0;j < 6;j++){

        if(strcmp(i->elemento.name, "Removido") != 0){

            total += i->elemento.captureRate;
            quant++;

        }

        i = i->prox;

    }

    if(quant > 0){

        float med = total/quant;
        printf("Média: %d\n", (int) roundf(med));

    }

}

void inserir(pokemon pok){

    ultimo->elemento = pok;
    ultimo = ultimo->prox;
    cont++;

    media();

}

pokemon remover(){

    pokemon elemento = primeiro->elemento;
    primeiro->elemento.name = "Removido";
    primeiro = primeiro->prox;
    cont--;

    return elemento;

}

void mostrar(Celula *i){

    for(int j = 0;j < 5;j++){

        printf("[%d] %s", j, toString(i->elemento));
        i = i->prox;


    }

}

void imprimir(){

    Celula *i = primeiro;

    mostrar(i);

}


////////////////////////////////////////////////////////////////////////////

int main(){

    preencherPokedex();
    start();

    char* str = (char*) malloc(20 * sizeof(char));

    do{

        fgets(str, 20, stdin);
        str[strcspn(str, "\n")] = 0;

        if(!isFim(str)){

            int num = atoi(str);

            inserir(pokemons[num - 1]);

        }

    }while(!isFim(str));

    int test;

    scanf("%d",&test);
    getchar();

    for(int i = 0;i < test;i++){

        fgets(str, 20, stdin);
        str[strcspn(str, "\n")] = 0;

        char* tok = strtok(str, " ");

        if(strcmp(tok, "I") == 0){

            tok = strtok(NULL, " ");

            int novo = atoi(tok);

            inserir(pokemons[novo - 1]);

        }else if(strcmp(tok, "R") == 0){

            pokemon rem = remover();

            printf("(R) %s\n", rem.name);

        }

    }

    printf("\n");

    imprimir();

    free(str);

    return 0;

}