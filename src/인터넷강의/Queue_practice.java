package 인터넷강의;
import java.util.*;

public class Queue_practice<T> {
    //제네릭타입을 이용해서 다양한 데이터 타입을 활용함

    private ArrayList<T> queue = new ArrayList<>();

    void enqueue(T o){

        queue.add(o);
    }

    T dequeue(){
        if(queue.isEmpty()){
            return null;
        }
        return queue.remove(0);

    }

    public static void main(String[] args) {

        //큐
        //줄을 서는 행위와 유사
        //
        Queue<Integer> queue_int = new LinkedList<>();

        queue_int.add(1); //추가
        queue_int.offer(2); //성공적으로 추가하면 true값을 리턴함

        System.out.println(queue_int);

        queue_int.poll(); //큐의 첫번째 값 반환, 해당값은 큐에서 삭제
        queue_int.remove(); //poll과 동일

        //ArrayList클래스를 이용해서 enqueue,dequeue 기능 구현해보기
        Queue_practice<Integer> qp =new Queue_practice<>();
        //클래스객체 생성해서 클래스의 변수와 함수사용하기
        qp.enqueue(1);
        qp.enqueue(2);
        qp.enqueue(3);

        System.out.println(qp.dequeue());
        System.out.println(qp.dequeue());

        System.out.println(qp.queue.get(0));


    }


}

class MyQueue<T>{
    private ArrayList<T> queue = new ArrayList<T>();

    public void enqueue(T item){
        queue.add(item);
    }

    public T dequeue(){
        if(queue.isEmpty()){
            return null;
        }
        return queue.remove(0);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<Integer>();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());


    }

}
