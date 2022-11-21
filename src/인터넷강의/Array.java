package 인터넷강의;
import java.util.*;

public class Array {
    public static void main(String[] args) {
        //배열은 같은 종류의 데이터를 효율적으로 저장함
        //빠른 접근이 가능하지만 데이터 추가/삭제가 어려움

        Integer[] data_list = new Integer[10];
        data_list[0] = 1;

        Integer data_list1[] = {5, 4, 3, 2, 1};
        Integer[] data_list2 = {1, 2, 3, 4, 5};

        System.out.println(data_list2[0]);

        System.out.println(Arrays.toString(data_list2));


        //배열은 고정적 크기
        //그래서 가변적 크기를 위해 ArrayList클래스를 제공함

        //+) List와 ArrayList 선언의 차이점
        //List는 인터페이스고 ArrayList는 클래스임
        //인터페이스는 추상메서드로만 구현되어 있기 때문에 인터페이스를
        //싱속받는 클래스는 정의된 추상메소드를 모두 구현해야함
        //따라서 다양한 클래스를 상속받는 특정 인터페이스는 동일한
        //메서드를 제공함
        //코드의 유연함을 제공하는 다형성(하나의 객체가 여러가지 타입을 가짐)이엇다고...
        List<Integer> list1 = new ArrayList<Integer>();
        list1 = new Vector<Integer>();
        list1 = new LinkedList<Integer>();
        list1 = new Stack<Integer>();
        ArrayList<Integer> list2 = new ArrayList<>();
        //인스턴스 생성 시 타입을 추정함

        list1.add(1); //추가
        list1.add(2);
        list1.get(0); //검색

        list1.set(0, 5); //변경
        list1.get(0);
        System.out.println(Arrays.toString(list1.toArray()));

        list1.remove(0); //삭제
        list1.size();

        Integer data_list3[][] = {{1, 2, 3}, {4, 5, 6}};

        System.out.println(data_list3[0][1]);

        Integer data_list4[][][] = {
                {
                        {1, 2, 3},
                        {4, 5, 6}
                },
                {
                        {7,8,9},
                        {10,11,12}
                }
            };
        System.out.println(data_list4[1][1][0]);


        String dataset[] ={
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                        " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                        " when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                        " It has survived not only five centuries",
                        " but also the leap into electronic typesetting",
                        " remaining essentially unchanged. " ,
                        "It was popularised in the 1960s with the release of " ,
                        "Letraset sheets containing Lorem Ipsum passages, " ,
                        "and more recently with desktop publishing software" ,
                        " Zlike Aldus PageMaker including versions of Lorem Ipsum."
        };

        //글자 갯수세기
        int count =0;
        for(int i=0; i<dataset.length;i++){
            if(dataset[i].contains("Z"))
            {
                count++;
            }
        }
        System.out.println("count:"+count);

    }
}

/*
Primitive VS Wrapper클래스
Wrapper는 null을 용이하게 처리할 수 있고 ArrayList등 객체 핸들링이
가능함
int와 Integer 차이가 뭐더라
객체인가 아닌가의 차이였던거 같음
 */
