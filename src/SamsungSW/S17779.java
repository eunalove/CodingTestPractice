package SamsungSW;

import java.util.Arrays;
import java.util.Scanner;

public class S17779 {
    private static final int INF = 987654321; //임의의 큰 값
    static int N;
    static int Arr[][] = new int[20][20];
    static int Mark[][] = new int[20][20];

    static void fill(int r, int c, int value){
        if(r < 0 || r> N-1 || c <0|| c> N-1) return; //이런 경우 그냥 종료함
        if(Mark[r][c] != 0) return; //경계선을 만났다면 종료함

        Mark[r][c] = value;
        fill(r-1,c,value);
        fill(r+1,c,value);
        fill(r,c-1,value);
        fill(r,c+1,value);
        //상하좌우를 만날때까지 입력받은 value값으로 다 채워주게 된다

    }

    static int solve3() {
        int ret = INF;
        //리턴할 값을 ret에 저장함 최소값을 차지해야하니까 초기값은 큰 값으로

        for(int x= 0; x <= N-3; x++){
            for(int y=1; y<= N-2; y++){
                for(int d1 = 1; x+d1<= N-2 && y-d1 >= 0; d1++){
                    for(int d2=1; x+d1+d2 <= N-1 && y+d2 <= N-1; d2++){
                        for(int i=0; i<N; i++)
                            Arrays.fill(Mark[i], 0);
                            //0으로 초기화함

                            //경계만을 마킹해본다

                            for(int i=0; i<= d1; i++){
                                Mark[x+i][y-i] =5;
                                Mark[x+d2+i][y+d2-i] =5;
                            }

                            for(int i=0; i<=d2; i++){
                                Mark[x+i][y+i] =5;
                                Mark[x+d1+i][y-d1+i] =5;
                            }

                            //이제 경계선이 다 연결되었을것이다.

                        //이제 꼭짓점을 기준으로 구역의 선을 만들어줘야함
                        for(int r= x -1; r>=0; r--)
                            Mark[r][y] =1;
                        for(int c = y+d2 +1; c < N; c++)
                                Mark[x+d2][c] =2;
                        for(int c = y-d1-1; c>=0; c--)
                            Mark[x+d1][c] =3;
                        for(int r= x+d1+d2+1; r<N; r++)
                            Mark[r][y-d1+d2] =4;

                        //5마킹 후 1,2,3,4 구역들을 경계선면을 그어주었다.
                        //경계선이 다 만들어졌으니 꼭짓점을 기준으로 선거구들을 채워주어야한다.

                        fill(0,0,1);
                        fill(0,N-1,2);
                        fill(N-1,0,3);
                        fill(N-1,N-1,4);

                        //Mark에 모든 선거구가 채워졌다.성능 상 5번을 채우기보다는
                        //0번 선거구로 두고 각각의 0번부터 5번까지 값을 구한뒤
                        //0번을 5번에 더해주면 된다.

                        int people[] = new int[6];
                        for(int r=0; r<N; r++)
                            for(int c=0; c<N; c++)
                                //0,0이라고 하면 1이 나온다.
                                //1번 선거구에 속하는 인구들을 다 누적할것임
                                people[Mark[r][c]] += Arr[r][c];

                        people[5] += people[0];

                        int minP=INF, maxP=0;
                        for(int i=1; i<=5; i++) {
                            minP = Math.min(minP, people[i]);
                            maxP = Math.max(maxP, people[i]);
                        }

                        ret = Math.min(ret, maxP - minP);
                    }
                }
            }
        }
        
        return ret;
        

    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Arr[i][j] = sc.nextInt();

                System.out.println(solve3());
            }
        }



    }

}
