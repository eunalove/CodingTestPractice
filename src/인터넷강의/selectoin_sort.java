package 인터넷강의;
import java.util.*;

public class selectoin_sort {

    static int[] arrs = new int[100];

    public static void main(String[] args) {
        //선택정렬

        int nums[] = {1,2,3};
        Arrays.sort(nums);

        Integer nums2[] = {1,2,3};
        Arrays.sort(nums2, Collections.reverseOrder());

        ArrayList<Integer> nums3 = new ArrayList<>();
        nums3.add(3);
        nums3.add(2);
        nums3.add(1);

        Collections.sort(nums3);

        for(int i=0; i<nums3.size(); i++){
            System.out.println(nums3.get(i));

        }

        //피보나치수열

        //1 1 2 3 5 8 ~
        arrs[1]=1;
        arrs[2]=1;

        for(int i=3; i<100; i++){
            arrs[i] = arrs[i-1]+ arrs[i-2];

        }

        fibo(99);

        //다익스트라

        //최단경로문제란? 두 노드를 잇는 가장 짧은 경로찾기
        //가중치 그래프에서 간선의 가중치 합이 최소가 되도록하는 경로찾기









    }

    private static int fibo(int i) {
        int result =0;

        if(i==1){
            result=1;

        }else if(i==2) {
            result = 2;
        }else{
            if(i<2){
                result=1;
            }else{
                result = fibo(i-1)+fibo(i-2);
            }

        }
        return result;

    }
}
