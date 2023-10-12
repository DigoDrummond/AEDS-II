#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>
typedef struct Jogador
{
    char id[100];
    char nome[100];
    char peso[100];
    char altura[100];
    char universidade[100];
    char anoNascimento[100];
    char cidadeNascimento[100];
    char estadoNascimento[100];
} Jogador;

int comp = 0;
int mov = 0;

Jogador clone(Jogador *jogador)
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

void imprimir(Jogador *jogador)
{
    printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s]\n", jogador->id, jogador->nome, jogador->altura, jogador->peso, jogador->anoNascimento, jogador->universidade, jogador->cidadeNascimento, jogador->estadoNascimento);
}

void ler(Jogador *jogador, char linha[1000])
{
    int pos[8];
    int virgulas = 0;
    for (int i = 0; i < strlen(linha); i++)
    {
        if (linha[i] == ',')
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
        strcpy(jogador->id, id);
    }
    else
    {
        strcpy(jogador->id, "nao informado");
    }

    cont = 0;

    if (pos[1] - (pos[0]) != 1)
    {
        for (int j = pos[0] + 1; j < pos[1]; j++)
        {
            nome[cont++] = linha[j];
        }
        nome[cont] = '\0';
        strcpy(jogador->nome, nome);
    }

    else
    {
        strcpy(jogador->nome, "nao informado");
    }
    cont = 0;

    if (pos[2] - (pos[1]) != 1)
    {
        for (int k = pos[1] + 1; k < pos[2]; k++)
        {
            altura[cont++] = linha[k];
        }
        altura[cont] = '\0';
        strcpy(jogador->altura, altura);
    }

    else
    {
        strcpy(jogador->altura, "nao informado");
    }

    cont = 0;

    if (pos[3] - (pos[2]) != 1)
    {
        for (int l = pos[2] + 1; l < pos[3]; l++)
        {
            peso[cont++] = linha[l];
        }
        peso[cont] = '\0';
        strcpy(jogador->peso, peso);
    }
    else
    {
        strcpy(jogador->peso, "nao informado");
    }

    cont = 0;
    if (pos[4] - (pos[3]) != 1)
    {
        for (int m = pos[3] + 1; m < pos[4]; m++)
        {
            universidade[cont++] = linha[m];
        }
        universidade[cont] = '\0';
        strcpy(jogador->universidade, universidade);
    }
    else
    {
        strcpy(jogador->universidade, "nao informado");
    }

    cont = 0;

    if (pos[5] - (pos[4]) != 1)
    {
        for (int n = pos[4] + 1; n < pos[5]; n++)
        {
            anoNascimento[cont++] = linha[n];
        }
        anoNascimento[cont] = '\0';
        strcpy(jogador->anoNascimento, anoNascimento);
    }
    else
    {
        strcpy(jogador->anoNascimento, "nao informado");
    }

    cont = 0;

    if (pos[6] - (pos[5]) != 1)
    {
        for (int o = pos[5] + 1; o < pos[6]; o++)
        {
            cidadeNascimento[cont++] = linha[o];
        }
        cidadeNascimento[cont] = '\0';

        strcpy(jogador->cidadeNascimento, cidadeNascimento);
    }
    else
    {
        strcpy(jogador->cidadeNascimento, "nao informado");
    }

    cont = 0;

    if ((strlen(linha) - 1) - (pos[6]) != 1)
    {
        for (int p = pos[6] + 1; p < strlen(linha) - 1; p++)
        {
            estadoNascimento[cont++] = linha[p];
        }
        estadoNascimento[cont] = '\0';
        strcpy(jogador->estadoNascimento, estadoNascimento);
    }
    else
    {
        strcpy(jogador->estadoNascimento, "nao informado");
    }
    cont = 0;
}
void removeIdDuplicado(Jogador *array, int *n)
{
    int i, j, k;
    for (i = 0; i < *n; i++)
    {
        for (j = i + 1; j < *n; j++)
        {
            if (strcmp(array[i].id, array[j].id) == 0)
            {
                for (k = j; k < (*n) - 1; k++)
                {
                    array[k] = array[k + 1];
                }
                (*n)--;
                j--;
            }
        }
    }
}

int getMax(int *array, int n)
{
    int maior = array[0];

    for (int i = 1; i < n; i++)
    {
        if (maior < array[i])
        {
            maior = array[i];
        }
    }
    return maior;
}
void radixSort(Jogador *array, int n)
{
    int maxId = 0;

    // Encontra o comprimento máximo do ID para determinar o número de dígitos
    for (int i = 0; i < n; i++)
    {
        int currentId = atoi(array[i].id);
        if (currentId > maxId)
        {
            maxId = currentId;
        }
    }

    // Classifica os jogadores com base no ID
    for (int exp = 1; maxId / exp > 0; exp *= 10)
    {
        radixCountingSort(array, n, exp);
    }
}

void radixCountingSort(Jogador *array, int n, int exp)
{
    Jogador output[n];
    int count[10] = {0};

    // Contagem do número de ocorrências para cada dígito
    for (int i = 0; i < n; i++)
    {
        int currentId = atoi(array[i].id);
        count[(currentId / exp) % 10]++;
    }

    // Atualiza o array de contagem para indicar as posições finais dos elementos
    for (int i = 1; i < 10; i++)
    {
        count[i] += count[i - 1];
    }

    // Constroi o array de saída com base nas posições finais do elemento no array de contagem
    for (int i = n - 1; i >= 0; i--)
    {
        int currentId = atoi(array[i].id);
        int position = (currentId / exp) % 10;
        output[count[position] - 1] = array[i];
        count[position]--;
    }

    // Copia o array de saída de volta para o array original
    for (int i = 0; i < n-1; i++)
    {
        array[i] = output[i];
    }
}

int main()
{
    clock_t t;
    t = clock();
    char entrada[1000];
    FILE *arq = fopen("/tmp/players.csv", "r");
    Jogador jogador[3922];
    char id[100];
    Jogador busca[3923];
    int cont = 0;

    fgets(entrada, sizeof(entrada), arq);
    int i = 0;
    while (fgets(entrada, 1000, arq) && i < 3922)
    {
        ler(&jogador[i], entrada);
        i++;
    }

    scanf("%s", id);
    while (strcmp(id, "FIM") != 0)
    {
        for (int j = 0; j < 3923; j++)
        {
            if (strcmp(jogador[j].id, id) == 0)
            {
                busca[cont++] = clone(&jogador[j]);
            }
        }
        scanf("%s", id);
    }

    radixSort(busca, cont - 1);

    for (int i = 0; i < cont; i++)
    {
        imprimir(&busca[i]);
    }
    t = clock() - t;

    FILE *log;
    log = fopen("matrícula_radixSort.txt", "w");
    fprintf(log, "Matricula: 802472\t Comparações: %d\t Movimentações: %d\t Execucao: %lfms", comp, mov, ((double)t) / ((CLOCKS_PER_SEC / 1000)));
    fclose(log);
    fclose(arq);
    return 0;
}