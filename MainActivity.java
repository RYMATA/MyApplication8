package pasha.samsung.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Button buttonSingle;
    private TextView User1Name;
    private TextView User1Email;
    private TextView User2Email;
    private TextView User2Name;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }

    private void initUi() {
        User1Name =findViewById(R.id.User1Name);
         User1Email = findViewById(R.id.User1Email);
         User2Email =findViewById(R.id.User2Email);
         User2Name =findViewById(R.id.User1Name);
        buttonSingle = findViewById(R.id.Button);

    }
    @Override
    protected void onStart() {
        super.onStart();
        initObservers();
    }


    private void initObservers() {
        Observable.getUserList(buttonSingle).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        Log.d("SINGLE", "Данные получены от источника: " + s);
                         String[] User =  s.split(":");
                        User1Name.setText(User[0]);
                        User1Name.setText(User[1]);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
