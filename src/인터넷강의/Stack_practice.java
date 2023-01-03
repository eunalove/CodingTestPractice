package 인터넷강의;
import java.util.ArrayList;
import java.util.Stack;

public class Stack_practice<T> {

    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item){
        stack.add(item);
    }

    /*

      public E push(E item) {
        addElement(item);

        return item;
    }

    push가보면 코드 이런데 왜 void형인거임??
    이해안가네?

     */



    public T pop(){
        if(stack.isEmpty()){
            return null;
        }

        return stack.remove(stack.size()-1);
        //아 맞다.. remove하면 그 값을 리턴해주는거 까먹고 있었다
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        //스택
        //한쪽 끝에서만 자료를 넣거나 뺼 수 있음
        //큐는 FIFO 스택은 LIFO
        //장점: 데이터 저장/읽기 속도가 빠름
        //스택은 단순하고 빠른 성능을 위해 사용되므로 보통 배열을 활용해서 구현함
        //그럴경우 이런 단점이 생김
        //단점: 데이터 최대 갯수를 미리 정해야함, 미리 최대갯수만큼 저장공간 확보해야함

        Stack<Integer> stack_int = new Stack<>();
        stack_int.push(1);
        stack_int.push(2);
        System.out.println(stack_int.push(3)); //push 성공 시 해당 아이템을 리턴함

        System.out.println(stack_int.pop()); //push 성공 시 해당 아이템을 리턴함

        //ArrayList를 이용해서 push,pop 기능 구현해보기

        Stack_practice<Integer> stack_practice = new Stack_practice<>();
        stack_practice.push(1);
        System.out.println(stack_practice.pop());


    }
}
