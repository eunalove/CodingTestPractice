package 인터넷강의;

public class backtraking {

    class node{
    int h, w;
    }


    static int N, M, K;
    static int init_map[][];
    static int map[][] = new int[N][M];

    static char[] what = "UDLR".toCharArray();
    static char[] game;

    static int max =0;

    static void init()
    {

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = init_map[i][j];
            }
        }
    }

    static void up(){
        System.out.println("업");
    }
    static void down(){
        System.out.println("다운");
    }
    static void left(){
        System.out.println("왼");
    }
    static void right(){
        System.out.println("오");
    }

    static int game_start() {
        init();
        for (int i = 0; i < K; i++) {
            switch (game[i]) {
                case 'U':
                    up();
                    break;
                case 'D':
                    down();
                    break;
                case 'L':
                    left();
                    break;
                case 'R':
                    right();
                    break;

            }

        }

        int max = 0;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (max < map[i][j])
                    max = map[i][j];
            }
        }
            return max;

    }
        static void DFS(int idx, int n){
            game[n] = what[idx];
            if(n <= 4){
                int temp = game_start();
                if(max < temp) max = temp;
                return;
            }

            for(int i=0; i<4; i++){
                DFS(i,n+1);
            }

        }


    public static void main(String[] args) {
        N= 5;
        M=5;
        K=3;
        init_map= new int[][]{
                {0, 0, 0, 0, 2},
                {0, 9, 4, 0, 0},
                {0, 0, 0, 2, 0},
                {0, 1, 5, 1, 3},
                {10, 0, 0, 0, 0}
        };

        for(int i=0; i<4; i++){
            DFS(i,0);
        }

      //  System.out.println("max:"+max);

    }



}
