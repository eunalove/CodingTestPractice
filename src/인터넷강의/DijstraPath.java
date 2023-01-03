package 인터넷강의;

import java.util.*;

public class DijstraPath {

    class Graph{
        int n;
        int maps[][];

        public Graph(int n){
            this.n = n;
            maps = new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    maps[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        public void input(int i, int j, int w){
            maps[i][j] = w;
            maps[j][i] = w;

        }

        public void dijkstra(int v){

            int distance[] = new int[n];
            boolean[] check = new boolean[n];

            for(int i=0; i<n; ++i){
                distance[i] = Integer.MAX_VALUE;
            }
            //시작노드
            distance[v]=0;
            check[v]=true;

            for(int i=0; i<n; ++i){
                if(!check[i]&&maps[v][i] != Integer.MAX_VALUE){
                    distance[i] = maps[v][i];
                }
            }



        }



    }



}