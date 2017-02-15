package romanroe;


import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public final class DemoSubject {

    public static void main(String[] args) throws InterruptedException {

        Subject<Integer> obs$ = BehaviorSubject.createDefault(99);
        obs$.subscribe(System.out::println);
        obs$.onNext(1);
        obs$.onNext(2);
        obs$.onNext(3);


//        obs$.observeOn(Schedulers.io()).map(i -> ioBound(i));
//        obs$.observeOn(Schedulers.computation()).map(i -> heavyOnCpu(i));


    }


}
