package romanroe;

import io.reactivex.Observable;

public final class Utils {

    public static Observable<String> createObservableReturn3ValuesIn3Seconds(String input) {
        return Observable.create(observer -> {
            (new Thread(() -> {
                for (long i = 0; i < 3; i++) {
                    observer.onNext(i + ": " + input);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        observer.onError(e);
                    }
                }
                observer.onComplete();
            })).start();
            ;
        });
    }

}
