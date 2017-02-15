package romanroe;


import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

public final class DemoSubject {

    public static void main(String[] args) throws InterruptedException {

        Subject<Integer> sub1 = ReplaySubject.createWithSize(3);
        sub1.onNext(1);
        sub1.onNext(2);
        sub1.onNext(3);
        sub1.onNext(4);
        sub1.onNext(5);
        sub1.subscribe(System.out::println);
        sub1.onNext(6);



    }


}
