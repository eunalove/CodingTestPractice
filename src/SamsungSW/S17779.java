package SamsungSW;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

class S17779{

    static int N;
    static int[][] Arr= new int[20][20];
    static int Mark[][] = new int[20][20];
    //선거구를 별도의 어레이에 마킹한다. 굳이..?
    private static final int INF = 987654321; //임의의 큰 값

    static void fill(int r, int c, int value){
        if(r < 0 || r> N-1 || c<0 || c>N-1) return;
        //유효한 행과 열임
        if(Mark[r][c] != 0) return;

        Mark[r][c] = value;
        fill(r-1, c, value);
        fill(r+1, c, value);
        fill(r, c-1, value);
        fill(r, c+1, value);



    }

    static int solve4() {
        int ret = INF;
        //5번 선거구를 지정하자 그러려면 x,y,d1,d2가 필요한데 없어
        //그럼 x,y,d1,d2를 모두 고려하기 위해 for문으로 죄다 돌려버리자

        for(int x=0; x<=N-3; x++){
            for(int y=1; y<=N-2; y++){
                //이차원 배열은 행이 가로고 열이 세로임
                //그 의미를 이제 확실하게 알앗다 x,y따위는 생각하지 않는다
                for(int d1=1; x+d1 <=N-2 && y-d1 >=0; d1++){
                    for(int d2=1; x+d1+d2 <=N-1 && y+d2<= N-1; d2++){
                        //x+d1+d2 <=N && y+d2<= N; d2++ 이걸로 하면 어케됨?
                        //얘도 잘됨
                        //이러면 모든 경우의 수를 돌게 되겠지?

                        for(int i=0; i<N; i++){
                            Arrays.fill(Mark[i],0);
                            //0으로 초기화
                        }

                        for(int i=0; i<= d1; i++){
                            Mark[x+i][y-i] =5;
                            Mark[x+d2+i][y+d2-i] =5;
                        }

                        for(int i=0; i<=d2; i++){
                            Mark[x+i][y+i] =5;
                            Mark[x+d1+i][y-d1+i] =5;
                        }

                        //경계면을 5로 해주기

                        for(int r=x-1; r>=0; r--)
                            Mark[r][y] = 1;

                        for(int c= y+d2+1; c<=N-1; c++)
                            Mark[x+d2][c]= 2;

                        for(int c=y-d1-1; c>=0; c--)
                            Mark[x+d1][c] =3;

                        for(int r= x+d1+d2+1; r<=N-1; r++)
                            Mark[r][y-d1+d2]=4;

                        //이제 경계를 1,2,3,4 다 만들어줬음

                        //모서리부터 시작해서 1,2,3,4를 다 채워줘야함

                        fill(0,0,1);
                        fill(0,N-1,2);
                        fill(N-1,0,3);
                        fill(N-1,N-1,4);

                        //각 선거구의 인구수를 구한다.
                        int people[] = new int[6];
                        for(int r=0; r<N; r++){
                            for(int c=0; c<N; c++){
                                people[Mark[r][c]] += Arr[r][c];


                            }
                        }

                        people[5] += people[0];

                        //가장 큰 인구수와 가장 작은 인구수의 차이 구하기

                        int minP= INF, maxP= 0;
                        for(int i=1; i<=5; i++){
                            minP = Math.min(minP, people[i]);
                            //둘 중 작은값을 가져옴
                            maxP = Math.max(maxP, people[i]);
                        }

                        ret = Math.min(ret, maxP- minP);


                    }
                }
            }
        }

        return ret;

    }


    public static void main(String[] args) {
        //먼저 입력값 받기
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve4());

    }

}