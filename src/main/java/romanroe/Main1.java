package romanroe;

public final class Main1 {

    public static void main(String[] args) throws InterruptedException {

//        Observable<Integer> obs1$ = Observable.just(1, 2, 3);
//        Observable<String> obs2$ = Observable.just("a", "b", "c");
//        obs1$.zipWith(obs2$, (a, b) -> a + "-" + b)
//                .subscribe(System.out::println);


//        Observable<Integer> obs3$ = Observable.create(e -> {
//            for (int i = 0; i < 5; i++) {
//                e.onNext(i);
//            }
//        });

//        Observable<Integer> obs4$ = Observable.create(e -> {
//            for (int i = 0; i < 5; i++) {
//                e.onNext(i);
//            }
//        });

//        obs3$
//                .zipWith(obs4$, (a, b) -> a + "-" + b)
//                .subscribe(System.out::println);


//        Observable<Long> obs5 = Observable.intervalRange(0, 5, 0, 1000, TimeUnit.MILLISECONDS);
//        Observable<Long> obs6 = Observable.intervalRange(100, 5, 3000, 500, TimeUnit.MILLISECONDS);
//        obs5
//                .withLatestFrom(obs6, (a, b) -> a + "-" + b)
//                .subscribe(System.out::println);


//        Observable<Object> obsError = Observable.create(o -> {
//            o.onNext(1);
//            o.onNext(2);
//            o.onError(new RuntimeException("e"));
//            o.onNext(3);
//        });

//        obsError.subscribe(new Observer<Object>() {
//            public void onSubscribe(Disposable d) {
//                System.out.println("onSubscribe");
//            }
//            public void onNext(Object aLong) {
//                System.out.println("aLong = " + aLong);
//            }
//            public void onError(Throwable e) {
//                System.out.println("onError:" + e.toString());
//            }
//            public void onComplete() {
//                System.out.println("onComplete");
//            }
//        });


//        Thread.sleep(10000);
    }


}
