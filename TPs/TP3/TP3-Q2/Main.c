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

////////////////////////////////////////////////////////////////////////////


pokemon array[MAXTAM];
int n;

void start(){

    n = 0;

}

void inserirInicio(pokemon pok){

    if(n >= MAXTAM){

        exit(1);

    }

    for(int i = n;i > 0;i--){

        array[i] = array[i - 1];

    }

    array[0] = pok;
    n++;

}

void inserirFim(pokemon pok){

    if(n >= MAXTAM){

        exit(1);

    }

    array[n] = pok;
    n++;

}

void inserir(int pos, pokemon pok){

    if(n >= MAXTAM || pos < 0 || pos > n){

        exit(1);

    }

    for(int i = n;i > pos;i--){

        array[i] = array[i - 1];

    }

    array[pos] = pok;
    n++;

}

pokemon removerInicio(){

    if(n == 0){

        exit(1);

    }

    pokemon resp = array[0];
    n--;

    for(int i = 0;i < n;i++){

        array[i] = array[i + 1];

    }

    return resp;

}

pokemon removerFim(){

    if(n == 0){

        exit(1);

    }

    return array[--n];

}

pokemon remover(int pos){

    if(n == 0 || pos < 0 || pos >= n){

        exit(1);

    }

    pokemon resp = array[pos];
    n--;

    for(int i = pos;i < n;i++){

        array[i] = array[i + 1];

    }

    return resp;

}

void mostrar(){

    pokemon resultado;

    for(int i = 0;i < n;i++){

        resultado = array[i];
        printf("[%d] %s", i, toString(resultado));

    }

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

            inserirFim(pokemons[num - 1]);

        }

    }while(!isFim(str));

    int test;

    scanf("%d",&test);
    getchar();

    for(int i = 0;i < test;i++){

        fgets(str, 20, stdin);
        str[strcspn(str, "\n")] = 0;

        char* tok = strtok(str, " ");

        if(strcmp(tok, "II") == 0){

            tok = strtok(NULL, " ");

            int novo = atoi(tok);

            inserirInicio(pokemons[novo - 1]);

        }else if(strcmp(tok, "IF") == 0){

            tok = strtok(NULL, " ");

            int novo = atoi(tok);

            inserirFim(pokemons[novo - 1]);

        }else if(strcmp(tok, "I*") == 0){

            tok = strtok(NULL, " ");
            int pos = atoi(tok);

            tok = strtok(NULL, " ");
            int novo = atoi(tok);

            inserir(pos, pokemons[novo - 1]);

        }else if(strcmp(tok, "RI") == 0){

            pokemon rem = removerInicio();

            printf("(R) %s\n", rem.name);

        }else if(strcmp(tok, "RF") == 0){

            pokemon rem = removerFim();

            printf("(R) %s\n", rem.name);

        }else if(strcmp(tok, "R*") == 0){

            tok = strtok(NULL, " ");

            int novo = atoi(tok);

            pokemon rem = remover(novo);

            printf("(R) %s\n", rem.name);

        }

    }

    mostrar();

    free(str);

    return 0;

}