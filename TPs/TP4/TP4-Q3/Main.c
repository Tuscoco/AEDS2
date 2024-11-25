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

    //FILE* file = fopen("/tmp/pokemon.csv","r");
    FILE* file = fopen("../pokemon.csv","r");

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

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

typedef struct No{

    pokemon elemento;
    struct No *esq, *dir;
    int nivel;

}No;

No* novoNo(pokemon x){

    No* novo = (No*) malloc(sizeof(No));
    novo->elemento = x;
    novo->esq = NULL;
    novo->dir = NULL;
    novo->nivel = 1;

    return novo;

}

/////////////////////////////

No* raiz;

void start(){

    raiz = NULL;

}

int altura(No* n){

    return (n == NULL) ? 0 : n->nivel;

}

int fatorBalanceamento(No* n){

    return (n == NULL) ? 0 : altura(n->dir) - altura(n->esq);

}

void atualizarAltura(No* n){

    if(n != NULL){

        int alturaEsq = altura(n->esq);
        int alturaDir = altura(n->dir);

        n->nivel = (alturaEsq > alturaDir ? alturaEsq : alturaDir) + 1;

    }

}

No* rotacionarDir(No* no){

    No* noEsq = no->esq;
    No* noEsqDir = noEsq->dir;

    noEsq->dir = no;
    no->esq = noEsqDir;

    atualizarAltura(no);
    atualizarAltura(noEsq);

    return noEsq;

}

No* rotacionarEsq(No* no){

    No* noDir = no->dir;
    No* noDirEsq = noDir->esq;

    noDir->esq = no;
    no->dir = noDirEsq;

    atualizarAltura(no);
    atualizarAltura(noDir);

    return noDir;

}

No* balancear(No* no){

    atualizarAltura(no);

    int fator = fatorBalanceamento(no);

    if(fator == 2){

        if(fatorBalanceamento(no->dir) < 0){

            no->dir = rotacionarDir(no->dir);

        }

        no = rotacionarEsq(no);

    }else if(fator == -2){

        if(fatorBalanceamento(no->esq) > 0){

            no->esq = rotacionarEsq(no->esq);

        }

        no = rotacionarDir(no);

    }

    return no;

}

No* inserir(No* no, pokemon x){

    if(no == NULL){

        return novoNo(x);

    }

    if(strcmp(x.name, no->elemento.name) < 0){

        no->esq = inserir(no->esq, x);

    }else if(strcmp(x.name, no->elemento.name) > 0){

        no->dir = inserir(no->dir, x);

    }else{

        return no;

    }

    return balancear(no);

}

void insercao(pokemon x){

    raiz = inserir(raiz, x);

}

bool pesquisa(No* no, char* str){

    if(no == NULL){

        return false;

    }else if(strcmp(str, no->elemento.name) == 0){

        return true;

    }else if(strcmp(str, no->elemento.name) < 0){

        printf("esq ");
        return pesquisa(no->esq, str);

    }else{

        printf("dir ");
        return pesquisa(no->dir, str);

    }

}

bool pesquisar(char* str){

    printf("raiz ");
    return pesquisa(raiz, str);

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

int main(){

    preencherPokedex();
    start();

    char* str = (char*) malloc(20 * sizeof(char));

    do{

        fgets(str, 20, stdin);
        str[strcspn(str, "\n")] = 0;

        if(!isFim(str)){

            int num = atoi(str);

            insercao(pokemons[num - 1]);

        }

    }while(!isFim(str));

    do{

        fgets(str, 20, stdin);
        str[strcspn(str, "\n")] = 0;

        if(!isFim(str)){

            printf("%s\n", str);
            //printf("=>");

            if(pesquisar(str)){

                printf("SIM\n");

            }else{

                printf("NAO\n");

            }

        }

    }while(!isFim(str));

    free(str);

    return 0;

}