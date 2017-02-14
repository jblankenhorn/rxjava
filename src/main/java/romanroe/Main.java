package romanroe;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public final class Main {

    public static void main(String[] args) throws InterruptedException {

//        Observable<Integer> obs1$ = Observable.just(1, 2, 3);
//        Observable<String> obs2$ = Observable.just("a", "b", "c");
//        obs1$.zipWith(obs2$, (a, b) -> a + "-" + b)
//                .subscribe(System.out::println);


        Observable<Integer> obs3$ = Observable.create(e -> (new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                e.onNext(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    throw new RuntimeException(e1);
                }
            }
        })).start());

        Observable<Integer> obs4$ = Observable.create(e -> (new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                e.onNext(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    throw new RuntimeException(e1);
                }
            }
        })).start());

//        obs3$
//                .zipWith(obs4$, (a, b) -> a + "-" + b)
//                .subscribe(System.out::println);


        Observable<Long> obs5 = Observable.intervalRange(0, 5, 0, 1000, TimeUnit.MILLISECONDS);
        Observable<Long> obs6 = Observable.intervalRange(100, 5, 3000, 500, TimeUnit.MILLISECONDS);
        obs5
                .withLatestFrom(obs6, (a, b) -> a + "-" + b)
                .subscribe(System.out::println);


        Thread.sleep(10000);
    }


}
