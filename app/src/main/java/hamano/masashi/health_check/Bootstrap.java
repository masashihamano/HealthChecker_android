package hamano.masashi.health_check;

import android.app.Application;

import com.beardedhen.androidbootstrap.TypefaceProvider;

/**
 * Created by masashihamano on 2018/02/18.
 */

public class Bootstrap extends Application {
    @Override
    public  void onCreate() {
        super.onCreate();
        TypefaceProvider.registerDefaultIconSets();
    }
}
