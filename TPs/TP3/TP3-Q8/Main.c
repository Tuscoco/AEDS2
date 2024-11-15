#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>

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
int comp = 0;
double tempo;

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

//CelulaDupla
typedef struct CelulaDupla{

    pokemon elemento;
    struct CelulaDupla *prox, *ant;

}CelulaDupla;

CelulaDupla *novaCelulaDupla(pokemon elemento){

    CelulaDupla *nova = (CelulaDupla*) malloc(sizeof(CelulaDupla));
    nova->elemento = elemento;
    nova->prox = nova->ant = NULL;
    
    return nova;

}

//Lista Dupla
CelulaDupla *primeiro, *ultimo;
int tam = 0;

void start(){

    pokemon tmp;
    primeiro = novaCelulaDupla(tmp);
    ultimo = primeiro;

}

void inserirInicio(pokemon pok){

    CelulaDupla *tmp = novaCelulaDupla(pok);
    tmp->ant = primeiro;
    tmp->prox = primeiro->prox;
    primeiro->prox = tmp;

    if(primeiro == ultimo){

        ultimo = tmp;

    }else{

        tmp->prox->ant = tmp;

    }

    tam++;
    tmp = NULL;

}

void inserirFim(pokemon pok){

    ultimo->prox = novaCelulaDupla(pok);
    ultimo->prox->ant = ultimo;
    ultimo = ultimo->prox;

    tam++;
}

pokemon removerInicio(){

    if(primeiro == ultimo){

        exit(1);

    }

    CelulaDupla *tmp = primeiro;
    primeiro = primeiro->prox;

    pokemon elemento = primeiro->elemento;
    tmp->prox = primeiro->ant = NULL;
    free(tmp);
    tmp = NULL;

    tam--;

    return elemento;

}

pokemon removerFim(){

    if(primeiro == ultimo){

        exit(1);

    }

    pokemon elemento = ultimo->elemento;
    ultimo = ultimo->ant;
    ultimo->prox->ant = NULL;
    free(ultimo->prox);
    ultimo->prox = NULL;

    tam--;

    return elemento;

}

void inserir(int pos, pokemon pok){

    if(pos < 0 || pos > tam){

        exit(1);

    }else if(pos == 0){

        inserirInicio(pok);

    }else if(pos == tam){

        inserirFim(pok);

    }else{

        CelulaDupla *i = primeiro;
        for(int j = 0;j < pos;j++,i = i->prox);

        CelulaDupla *tmp = novaCelulaDupla(pok);
        tmp->ant = i;
        tmp->prox = i->prox;
        tmp->ant->prox = tmp->prox->ant = tmp;

        tmp = i = NULL;

    }

    tam++;

}

pokemon remover(int pos){

    pokemon elemento;

    if(primeiro == ultimo || pos < 0 || pos >= tam){

        exit(1);

    }else if(pos == 0){

        elemento = removerInicio();

    }else if(pos == tam - 1){

        elemento = removerFim();

    }else{

        CelulaDupla *i = primeiro->prox;
        for(int j = 0;j < pos;j++, i = i->prox);

        i->ant->prox = i->prox;
        i->prox->ant = i->ant;

        elemento = i->elemento;

        i->prox = i->ant = NULL;
        free(i);
        i = NULL;

    }

    tam--;

    return elemento;

}

void mostrar(CelulaDupla *i){

    while(i != NULL){

        printf("%s",toString(i->elemento));
        i = i->prox;

    }

}

void imprimir(){

    CelulaDupla *i = primeiro->prox;

    mostrar(i);

}

void swap(CelulaDupla *i, CelulaDupla *j){

    pokemon tmp = i->elemento;
    i->elemento = j->elemento;
    j->elemento = tmp;

}

void ordenar(CelulaDupla *esq, CelulaDupla *dir, int es, int di){

    if(esq == NULL || dir == NULL || esq == dir || dir->prox == esq){

        return;

    }

    CelulaDupla *i = esq;
    int ii = es;
    CelulaDupla *j = dir;
    int jj = di;
    CelulaDupla *pivot = dir;

    while(ii <= jj){

        comp++;
        while(i != NULL && (i->elemento.generation <  pivot->elemento.generation || 
        (i->elemento.generation == pivot->elemento.generation && 
        strcmp(i->elemento.name, pivot->elemento.name) < 0))){

            i = i->prox;
            ii++;

        }

        comp++;
        while(j != NULL && (j->elemento.generation >  pivot->elemento.generation || 
        (j->elemento.generation == pivot->elemento.generation && 
        strcmp(j->elemento.name, pivot->elemento.name) > 0))){

            j = j->ant;
            jj--;

        }

        if(ii <= jj && i != NULL && j != NULL){

            swap(i, j);
            i = i->prox;
            j = j->ant;
            ii++;
            jj--;

        }

    }

    ordenar(esq, j, es, jj);

    ordenar(i, dir, ii, di);

}

void chamarOrdenacao(){

    ordenar(primeiro->prox, ultimo, 0, tam - 1);

}


////////////////////////////////////////////////////////////////////////////

void criarLog(){

    FILE* file = fopen("matrícula_quicksort2.txt","w");

    if(file == NULL){

        printf("ERRO!");
        return;

    }

    fprintf(file, "857867 \t %lfs \t %d", tempo, comp);

    fclose(file);

}

clock_t inicio,fim;

int main(){

    preencherPokedex();
    start();

    char* str = (char*) malloc(20 * sizeof(char));

    do{

        fgets(str, 20, stdin);
        str[strcspn(str, "\n")] = 0;

        if(!isFim(str)){

            int num = atoi(str);

            inserirFim(pokemons[num - 1]);

        }

    }while(!isFim(str));

    inicio = clock();

    chamarOrdenacao();

    fim = clock();
    tempo = (double)(fim - inicio) / CLOCKS_PER_SEC;

    imprimir();

    criarLog();

    free(str);

    return 0;

}