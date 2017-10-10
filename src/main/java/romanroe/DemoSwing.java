package romanroe;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public final class DemoSwing {

    public static void main(String[] args) throws InterruptedException {

        JFrame pane = new JFrame("RxJava");
        pane.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pane.setLayout(null);

        JTextField input = new JTextField("");
        input.setBounds(10, 10, 300, 40);
        input.setFont(new Font("monospaced", Font.BOLD, 20));
        pane.add(input);

        JButton button = new JButton("OK");
        button.setBounds(320, 10, 100, 40);
        pane.add(button);

        JTextArea result = new JTextArea("");
        result.setBounds(10, 60, 410, 400);
        result.setFont(new Font("monospaced", Font.BOLD, 20));
        pane.add(result);

        pane.setBounds(0, 0, 440, 500);
        pane.setVisible(true);
        connect(input, button, result);
    }

    private static void connect(JTextField input, JButton button, JTextArea result) {
        Observable<String> input$ = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observer) throws Exception {
                input.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        observer.onNext(input.getText());
                    }
                });
            }
        }).debounce(2000, TimeUnit.MILLISECONDS);

        Observable<String> button$ = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> observer) throws Exception {
                button.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        observer.onNext(input.getText());
                    }
                });
            }
        });

        result.setText((System.currentTimeMillis() / 1000) + ": start");





        Observable.merge(input$, button$)
                .distinctUntilChanged()
                .flatMap(Utils::createObservableReturn3ValuesIn3Seconds)
                .subscribe(t -> {
                    result.setText((System.currentTimeMillis() / 1000) + ": " + t + "\n" + result.getText());
                });
    }


}
