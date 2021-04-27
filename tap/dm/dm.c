#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>

#define MAX 8

int max = 0;
double poids = 0;
typedef struct {
  int x, y;
} point;

double dist(point A, point B) {
  return abs((int) (A.x - B.x)) + abs((int) (A.y - B.y));
}

void maxi(double tab[MAX][MAX]){
    max = 0;
    for (int i = 0; i < 8; i++)
    {
        for (int j = i+1; j < 8; j++)
        {  
            if(max < tab[i][j])
                max = tab[i][j];
        }
    }
}

int mini(double tab[MAX][MAX], bool parc[MAX]){
    int min = max;
    int x;
    int y;
    for(int i = 0; i < MAX; i ++){
        for(int j = 0; j < MAX; j ++){
            if(tab[i][j]<min && i != j){
                    min = tab[i][j];
                    x = i;
                    y = j;

            }
        }
    }
    printf("%d - %d\n",x,y);
    parc[x] = true;
    parc[y] = true;
    poids += tab[x][y];
    return min;
}

void min(double tab[MAX][MAX], bool parc[MAX]){
    int small = max;
    int x, y;
    for (int i = 0; i < 8; i++)
    {
        if(parc[i]){
            for (int j = 0; j < 8; j++)
            {
                if(!parc[j]){
                    //printf("%d %d %lf\n",i,j, tab[i][j]);
                    if(small > tab[i][j] && i != j){
                        small = tab[i][j];
                        x = i;
                        y = j;
                    }

                }
            }
        }
    }
    parc[y] = true;
    poids += tab[x][y];
    printf("%d - %d\n",x,y);
}

bool isAllTrue(bool tab[MAX]){
    for(int i =0; i < MAX; i ++){
        //printf("%d -> %d\n",i,tab[i]);
        if(!tab[i])
            return false;
    }
    return true;
}

int
main(void)
{

    point v0 = {.x=4, .y=17};
    point v1 = {.x=1, .y=17};
    point v2 = {.x=12, .y=0};
    point v3 = {.x=4, .y=11};
    point v4 = {.x=13, .y=16};
    point v5 = {.x=6, .y=1};
    point v6 = {.x=2, .y=20};
    point v7 = {.x=13, .y=0};

/*
    point v0 = {.x=13, .y=1};
    point v1 = {.x=20, .y=4};
    point v2 = {.x=0, .y=11};
    point v3 = {.x=9, .y=3};
    point v4 = {.x=0, .y=12};
    point v5 = {.x=20, .y=0};
    point v6 = {.x=18, .y=9};
    point v7 = {.x=2, .y=12};
*/
    point points[8] = {v0, v1, v2, v3, v4, v5, v6, v7};


    int nb_arretes = 0;

    double distTab[MAX][MAX];
    bool parcourus[] = {false,false,false,false,false,false,false,false};

    for (int i = 0; i < 8; i++)
    {
        for (int j = i+1; j < 8; j++)
        {
            double val = dist(points[i], points[j]);
            distTab[i][j] = val;
            distTab[j][i] = val;
            printf("dist(v%d, v%d) = %f\n", i, j, val);
            nb_arretes ++;
        }
    }

    maxi(distTab);
    mini(distTab,parcourus);
    max+=1;
    printf("lol\n");

    while(!isAllTrue(parcourus)){
        min(distTab,parcourus);
    }
    printf("%lf\n",poids);


    int poid_arbre = dist(v0, v6) + dist(v6, v1) + dist(v1, v3) + dist(v3, v5) + dist(v5, v2) + dist(v2, v7) + dist(v7, v4) + dist(v4, v0);
    printf("poid arbre couvrant = %d\n", poid_arbre);

    /*
    int tourne_dfs = dist(v0, v1) + dist(v1, v4) + dist(v4, v6) + dist(v6, v5) + dist(v5, v2) + dist(v2, v7) + dist(v7, v3) + dist(v3, v0);
    printf("longueur tourné dfs = %d\n", tourne_dfs);

    int tourne_im = dist(v0, v2) + dist(v2, v7) + dist(v7, v3) + dist(v3, v5) + dist(v5, v4) + dist(v4, v1) + dist(v1, v6) + dist(v6, v0);
    printf("longueur tourné insertion min = %d\n", tourne_im);*/

    return 0;
}