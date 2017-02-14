package romanroe;

import io.reactivex.Observable;

public final class Main {

    public static void main(String[] args) {

        Observable<Integer> obs$ = Observable.fromCallable(1, 2, 3);
        obs$.subscribe(i -> {
            System.out.println(i);
        });



    }


}
