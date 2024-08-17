#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    
    char comando[256];
    
    system("clear");
    
    snprintf(comando, sizeof(comando), "gcc %s.c -o %s", argv[1],argv[1]);
    system(comando);

    snprintf(comando, sizeof(comando), "./%s < pub.in > saida.out", argv[1]);
    system(comando);
    
    system("diff pub.out saida.out");

    return 0;

}