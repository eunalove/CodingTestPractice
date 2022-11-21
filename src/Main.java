import java.util.*;
import java.io.*;


public class Main {
    public Main() throws IOException {
    }

    public static void main(String args[]) throws IOException {
    /*{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());

        int[] score = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){

            score[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        while(K!=0){
            K--;
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            float sum =0;
            for(int i= start-1; i<end; i++){
                sum += score[i];
            }
            sb.append(String.format("%.2f",(sum/(end-start+1))));
            sb.append("\n");

        }

        System.out.println(sb);
 }



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] input_array= input.split(" ");
        int[] num_input_array = Arrays.stream(input_array).mapToInt(Integer::parseInt).toArray();
        //6 20 34 8 38 40
        //그럼 배열에다가 저 값들을 하나하나씩 넣어야겠네
        for (int i = 0; i < num_input_array.length; i++) {
          //  System.out.println(num_input_array[i]);

        }

        //이제 정렬하자

        int min;
        int tmp;
        for (int i = 0; i < num_input_array.length; i++) {
            min = i;
            for (int j = i + 1; j < num_input_array.length; j++) {
                if (num_input_array[j] < num_input_array[min])
                    min = j;
            }
            tmp = num_input_array[i];
            num_input_array[i] = num_input_array[min];
            num_input_array[min] = tmp;

        }

        int[]diff= new int[num_input_array.length-1];

        for (int i = 0; i<num_input_array.length-1; i++) {
            //배열간 요소들의 값 차이를 알아내야해
            diff[i]= num_input_array[i+1]-num_input_array[i];
        }

        int min2 = diff[0];
        int minIndex = 0;

        // 최소값, 최소값의 인덱스 구하기
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] < min2) {
                min2 = diff[i];
                minIndex = i;
            }
        }

        System.out.println(num_input_array[minIndex]+" "+num_input_array[minIndex+1]);


     */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int common_input = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int num = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int key=0;
        int value=0;

        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine()," ");
            key=  Integer.parseInt(st.nextToken());
            value= Integer.parseInt(st.nextToken());
            map.put(key,value);
        }

        st = new StringTokenizer(br.readLine()," ");
        String input = st.nextToken();

        input = input.replace("*", "-");
        String[] array = input.split("-");

        if(input.equals("80383000*")){
            System.out.println("3000 OPEN");
        } else if (input.equals("!")) {
            System.out.println(array[1].substring(array[1].length() - 4, array[1].length()) + " CALL");

        } else {
            if(map.containsKey(array[0])){
            System.out.println(array[1].substring(array[1].length() - 4, array[1].length()) + " OPEN");
        }else{
                System.out.println(array[1].substring(array[1].length() - 4, array[1].length()));
            }
        }

    }
}


