#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    
    char comando[256];
    
    system("clear");
    
    snprintf(comando, sizeof(comando), "gcc %s -o exec", argv[1]);
    system(comando);

    system("./exec < pub.in > saida.out");
    
    system("diff pub.out saida.out");

    return 0;

}