package pasha.samsung.myapplication;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;

import java.io.IOException;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/**
 * Created by Samsung on 27.02.2019.
 */

public class Observable {
    public static Single<String> getUserList(final Button button) {
        return Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(final SingleEmitter<String> emitter) throws Exception {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        JsonPlaceholderApi api = new JsonPlaceholderApi("https://jsonplaceholder.typicode.com/comments");
                        try {
                            User user = api.getUser(1);
                            User user2 = api.getUser(2);
                            String User1 =user.toString();
                            String User2 =user2.toString();
                            emitter.onSuccess(User1+":"+User2);

                            Log.d(UserTask.class.getName(), String.format("user1:%s\nuser2:%s", user.toString(), user2.toString()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        }

                });
            }
        });
    }
}
