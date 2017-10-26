package romanroe;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public final class Main1 {

	public static void main(String[] args) throws InterruptedException {




		final Observable<Integer> obs1$ = Observable.just(1, 2, 3, 4);

//		obs1$
//				.filter(value -> value > 2)
//				.map(value -> value * 2)
//				.map(value -> value + "__")
//				.subscribe(value -> System.out.println(value));

		final Observable<String> obs2$ = Observable.just("a", "b", "c");
//
//		obs1$.zipWith(obs2$, (a, b) -> a + "-" + b)
//				.subscribe(System.out::println);


		final Observable<Object> obs3$ = Observable.create(o -> {

			for (int i = 0; i < 5; i++) {
				// wird nur aufgerufen, wenn auch subscribed wird
				System.out.println("onNext");
				o.onNext(i);
			}

		});

//		obs3$.subscribe(System.out::println);



		final Observable<Long> obs5$ =
				Observable.intervalRange(0, 15, 0, 500, TimeUnit.MILLISECONDS);

		final Observable<Long> obs6$ =
				Observable.intervalRange(100, 5, 300, 700, TimeUnit.MILLISECONDS);



//		obs5$.withLatestFrom(obs6$, (a, b) -> a + "-" + b)
//				.subscribe(System.out::println);







		final Observable<Object> obsError = Observable.create(o -> {
			o.onNext(1);
			o.onNext(2);
			throw new RuntimeException("asdasd");

//			o.onError(new RuntimeException("Fehler???"));
//			o.onNext(3);
		});

		obsError.subscribe(System.out::println);

//		obsError.subscribe(new Observer<Object>() {
//			@Override
//			public void onSubscribe(Disposable disposable) {
//				System.out.println("sub");
//			}
//
//			@Override
//			public void onNext(Object o) {
//				System.out.println("next val = " + o);
//
//			}
//
//			@Override
//			public void onError(Throwable throwable) {
//				System.out.println("Error " + throwable.toString());
//
//			}
//
//			@Override
//			public void onComplete() {
//
//			}
//		});


		Thread.sleep(10000);
	}


}
