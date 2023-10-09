#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
typedef struct Jogador{
    char id[100];
    char nome[100];
    char peso[100];
    char altura[100];
    char universidade[100];
    char anoNascimento[100];
    char cidadeNascimento[100];
    char estadoNascimento[100];
} Jogador;

Jogador clone (Jogador *jogador)
{ 
    Jogador novo; 
    strcpy(novo.id, jogador->id);
    strcpy(novo.nome, jogador->nome);
    strcpy(novo.altura, jogador->altura);
    strcpy(novo.peso, jogador->peso);
    strcpy(novo.anoNascimento, jogador->anoNascimento);
    strcpy(novo.cidadeNascimento, jogador->cidadeNascimento);
    strcpy(novo.estadoNascimento, jogador->estadoNascimento);
    strcpy(novo.universidade, jogador->universidade);
    return novo; 
}

void imprimir (Jogador *jogador)
{
    printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento , jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
}

void ler (Jogador *jogador, char linha[1000])
{ 
    int pos[7];
    int virgulas = 0;
    for (int i = 0; i < strlen(linha); i++)
    {
        if(linha[i] == ',')
        {
                pos[virgulas] = i;
                virgulas++;
        }
        
    }
    
    int cont = 0;
    char id[100];
    char nome[100];
    char peso[100];
    char altura[100];
    char universidade[100];
    char anoNascimento[100];
    char cidadeNascimento[100];
    char estadoNascimento[100];

    
    if (pos[0] - 0 != 0) 
    {
        for (int i = 0; i < pos[0]; i++) 
        {
            id[cont++] = linha[i];
        }
        id[cont] = '\0';
        strcpy(jogador->id,id);
    }
    else
    {
        strcpy(jogador->id,"nao informado");  
    }
   
    cont = 0;

    if (pos[1] - (pos[0]) != 1)
    {
        for (int j = pos[0] + 1; j < pos[1]; j++) 
    {
        nome[cont++] = linha[j];
    }
    nome[cont] = '\0';
    strcpy(jogador->nome,nome);
    }
    
    else
    {
    strcpy(jogador->nome,"nao informado");   
    }
    cont = 0;

    if (pos[2] - (pos[1]) != 1)
    {
        for (int k = pos[1] + 1; k < pos[2]; k++) 
        {
            altura[cont++] = linha[k];
        }
        altura[cont] = '\0';
        strcpy(jogador->altura,altura);
    }
    
    else
    {
    strcpy(jogador->altura,"nao informado");
    }
    
    cont = 0;

    if (pos[3] - (pos[2]) != 1)
    {
        for (int l = pos[2] + 1; l < pos[3]; l++) 
        {
            peso[cont++] = linha[l];
        }
        peso[cont] = '\0';
        strcpy(jogador->peso,peso);
    }
    else
    {
    strcpy(jogador->peso,"nao informado");
    }
    
    cont = 0;
    if (pos[4] - (pos[3]) != 1)
    {
        for (int m = pos[3] + 1; m < pos[4]; m++) 
        {
            universidade[cont++] = linha[m];
        }
        universidade[cont] = '\0';
        strcpy(jogador->universidade,universidade);
    }
    else
    {
    strcpy(jogador->universidade,"nao informado");
    }
    
    cont = 0;

    if (pos[5] - (pos[4]) != 1)
    {
        for (int n = pos[4] + 1; n < pos[5]; n++) 
        {
            anoNascimento[cont++] = linha[n];
        }
        anoNascimento[cont] = '\0';
        strcpy(jogador->anoNascimento,anoNascimento);
    }
    else
    {
    strcpy(jogador->anoNascimento,"nao informado");
    }
    
    cont = 0;

    if (pos[6] - (pos[5]) != 1)
    {
        for (int o = pos[5] + 1; o < pos[6]; o++) 
        {
            cidadeNascimento[cont++] = linha[o];
        }
        cidadeNascimento[cont] = '\0';
       
        strcpy(jogador->cidadeNascimento,cidadeNascimento);
    }
    else
    {
    strcpy(jogador->cidadeNascimento,"nao informado");
    }
    
    cont = 0;

     if ((strlen(linha) - 1) - (pos[6]) != 1)
    {
        for (int p = pos[6] + 1; p < strlen(linha) - 1; p++) 
        {
            estadoNascimento[cont++] = linha[p];
        }
        estadoNascimento[cont] = '\0';
        strcpy(jogador->estadoNascimento,estadoNascimento);
        }
    else
    {
    strcpy(jogador->estadoNascimento,"nao informado");
    }
    cont = 0;
}



    int fraseParaInteiro (char* frase)
    {
        int num = 0;
        for (int i = 0; frase[i] != '\0'; i++)
        {
            num = num + (int)frase[i];
        }
        return num;
    }

    void shellsort(Jogador* jogador, int n) {
    int h = 1;
    while (h < n / 3) {
        h = 3 * h + 1;
    }
    
    while (h >= 1) {
        for (int i = h; i < n; i++) {
            for (int j = i; j >= h && atoi(jogador[j].peso) < atoi(jogador[j - h].peso); j -= h) {
                Jogador temp = jogador[j];
                jogador[j] = jogador[j - h];
                jogador[j - h] = temp;
            }
        }
        h /= 3;
    }
}

int main () 
{
    char entrada[1000];
    FILE* arq = fopen("/tmp/players.csv","r");
    Jogador jogador[3922];
    char id[100];
    char nome[100];
    Jogador busca[1000]; 
    int cont = 0; 

    fgets (entrada, sizeof(entrada), arq); 
    int i = 0; 
    while (fgets (entrada, 1000, arq)) 
    {
        ler(&jogador[i], entrada); 
        i++;
    }
    
    scanf("%s", id);
    while (strcmp(id, "FIM") != 0) 
    {
        for (int j = 0; j < 3922; j++)
        {
            if(strcmp(jogador[j].id,id) == 0) 
            {
                busca[cont++] = clone(&jogador[j]); 
            }
        }
        scanf("%s", id);
    }

    shellsort(busca,cont); 
    
    for (int i = 0; i < cont; i++) 
    {
        imprimir(&busca[i]);
    }
    


        
    fclose(arq);
    return 0;
}