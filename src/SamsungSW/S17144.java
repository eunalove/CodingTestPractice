package SamsungSW;

import java.util.Scanner;

public class S17144 {
    static int R,C,T;
    //입력으로 받아야하는 값
    static int[][] Arr = new int[50][50];
    //격자정보를 받기 위해 Arr를 정의한다.
    static int CleanRow;
    //공기청정기의 위치를 저장하기 위해 변수를 정의함
    static int[] Dr= {-1,1,0,0};
    //순서는 상하좌우
    static int[] Dc = {0,0,-1,1};
    //마찬가지로 상하좌우

    static int solve17144(){
        for(int t=0; t<T; ++t){
            //미세먼지 확산
            int[][] diffusion = new int[50][50];
            //델타 값을 저장할 배열 만들어주기
            for(int i=0; i<R; ++i){
                for(int j=0; j<C; ++j){
                    //각 칸을 확인한다.
                    if(Arr[i][j]<5) continue;
                    int quantity = Arr[i][j]/5;
                    //미세먼지가 확산되어 있는 양
                    for(int k=0; k<4; ++k){
                        //4방향으로 확산하므로
                        int nr= i+ Dr[k], nc= j+ Dc[k];
                        //현재 로우, 컬럼 값에 델타 값더하기
                        //각각에 맞는 상하좌우로 값을 구할 수 있음
                        if(nr <0 || nr > R-1 || nc <0 || nc> C-1) continue;
                        //격자를 벗어나는 경우는 그냥 스킵한다
                        if(Arr[nr][nc] == -1) continue;
                        //공기청정기가 있는 칸이라면 확산되지 않으므로 스킵함

                        //여기까지 확산이 되었다
                        diffusion[nr][nc] += quantity;
                        //델타값을 디피전 어레이에 누적한다.
                        diffusion[i][j] -= quantity;
                        //그리고 현재 위치에는 확산된 만큼 빼줘야함

                    }
                }
            }

            //최종적으로 어레이값을 변경해줌
            for(int i=0; i<R; ++i)
                for(int j=0; j<C; ++j)
                    Arr[i][j] += diffusion[i][j];

            //공기청정기 동작 시작
            //위쪽은 반시계, 아래쪽은 반시계방향으로 회전함

            for(int i=CleanRow-1; i>=1; --i)
                Arr[i][0] = Arr[i-1][0];

            for(int j=0; j<= C-2; ++j)
                Arr[0][j] = Arr[0][j+1];

            for(int i=0; i<=CleanRow-1; ++i)
                Arr[i][C-1] = Arr[i+1][C-1];

            for(int j=C-1; j>=2; --j)
                Arr[CleanRow][j] = Arr[CleanRow][j-1];

            Arr[CleanRow][1] =0;



            for (int i = CleanRow+2; i <= R - 2; ++i) {
                Arr[i][0] = Arr[i + 1][0];
            }

            for (int i = 0; i <= C - 2; ++i) {
                Arr[R - 1][i] = Arr[R - 1][i + 1];
            }

            for (int i = R - 1; i >= CleanRow + 2; --i) {
                Arr[i][C - 1] = Arr[i - 1][C - 1];
            }

            for (int i = C - 1; i >= 2; --i) {
                Arr[CleanRow+1][i] = Arr[CleanRow+1][i - 1];
            }

            Arr[CleanRow+1][1] =0;

        }


        int sum = 0;
        for(int i=0; i<R; ++i){
            for(int j=0; j<C; ++j){
                if(Arr[i][j]>0)
                    sum += Arr[i][j];
            }
        }
        return sum;

    }






    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();

        for(int i=0; i<R; ++i){
            for(int j=0; j<C; ++j){
                Arr[i][j] = sc.nextInt();
                if(Arr[i][j] == -1 && Arr[i-1][j] == -1){
                    //두번째 -1을 받았을 떄 공기청정기 위치를 확인함
                    //지금 i,j라서 i+1은 안됨
                    CleanRow = i-1;

                }
            }
        }
        //여기까지 입력은 다 받았으니 solve()를 통해 정답을 도출해보자

        System.out.println(solve17144());

    }

}
