#include <stdio.h>
#include <stdlib.h>

int main()
{

    system("clear");
    system("./exec < pub.in > saida.out");
    system("diff pub.out saida.out");

    return 0;

}