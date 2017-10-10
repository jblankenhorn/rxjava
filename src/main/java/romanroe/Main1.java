package romanroe;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public final class Main1 {

	public static void main(String[] args) throws InterruptedException {

		final Observable<Integer> obs1$ = Observable.just(1, 2, 3, 4);

/*
		obs1$
				.filter(item -> item > 1)
				.map(item -> item + "_")
				.subscribe(System.out::println);
*/
/*		final Observable<String> obs2$ = Observable.just("a", "b", "c");

		obs1$.zipWith(obs2$, (a, b) -> a + "-" + b)
				.subscribe(System.out::println);*/

		final Observable<Object> obs3$ = Observable.create(o -> {
			for (int i = 0; i < 5; i++) {

				o.onNext(i);
			}

		});

//		obs3$.subscribe(System.out::println);

		final Observable<Long> obs5$ =
				Observable.intervalRange(0, 5, 0, 1000, TimeUnit.MILLISECONDS);

		final Observable<Long> obs6$ =
				Observable.intervalRange(100, 5, 300, 500, TimeUnit.MILLISECONDS);

		/*obs5$.withLatestFrom(obs6$, (a, b) -> a + "-" + b)
				.subscribe(System.out::println);*/

		final Observable<Object> obsError = Observable.create(o -> {
			o.onNext(1);
			o.onNext(2);
			o.onError(new RuntimeException("Fehler???"));
			o.onNext(3);
		});

		obsError.subscribe(new Observer<Object>() {
			@Override
			public void onSubscribe(Disposable disposable) {
				System.out.println("sub");
			}

			@Override
			public void onNext(Object o) {
				System.out.println("next val = " + o);

			}

			@Override
			public void onError(Throwable throwable) {
				System.out.println("Error " + throwable.toString());

			}

			@Override
			public void onComplete() {

			}
		});

		Thread.sleep(10000);
	}


}
