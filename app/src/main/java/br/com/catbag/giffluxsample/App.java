package br.com.catbag.giffluxsample;

import android.app.Application;

import com.umaplay.fluxxan.Fluxxan;

import br.com.catbag.giffluxsample.models.AppState;
import br.com.catbag.giffluxsample.models.ImmutableAppState;
import br.com.catbag.giffluxsample.reducers.GifReducer;

/**
 * Created by niltonvasques on 10/12/16.
 */

public class App extends Application {

    private static Fluxxan<AppState> fluxxan = null;

    public static Fluxxan<AppState> getFluxxan() {
        return fluxxan;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializeFluxxan();
    }

    private void initializeFluxxan() {
        AppState state = ImmutableAppState.builder().build();
        fluxxan = new Fluxxan<>(state);
        fluxxan.registerReducer(new GifReducer());
        fluxxan.start();
    }

    public void onTerminate() {
        super.onTerminate();
        fluxxan.stop();
    }
}
