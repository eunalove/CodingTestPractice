package 인터넷강의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Time_complexity {

    //어느 알고리즘이 더 좋은지 분석
    //시간복잡도가 공간복잡도보다 더 좋음

    //성능에 영향을 미치는 주요 요소는 반복문임
    //빅오 표기법- 알고리즘 최악의 실행시간을 표기

    public static void main(String[] args) throws IOException {

        int n=0;
        if (n>10){
            System.out.println(n);
        }
        //딱 한번 실행됨 O(n)

        for(int num=0; num<3; num++){
            for(int index=0; index<n; index++){
                System.out.println(index);
            }
        }
        //n에 따라 3n으로 실행됨 상수는 크게 작용하지 않으므로 O(n)

        for(int i=0; i<3; i++){
            for(int num=0; num<n; num++){
                for(int index=0; index<n; index++){
                    System.out.println(index);
                }
            }
        }
        //n에 따라 3n의 제곱으로 실행됨 O(n의제곱)


    }




}
