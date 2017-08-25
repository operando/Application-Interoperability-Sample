package sample.interoperability.application.operando.os.com.subapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent i = new Intent();
//        i.setComponent(new ComponentName("com.os.operando.application.interoperability.sample", "com.os.operando.application.interoperability.sample.SettingAliasActivity"));
//        startActivity(i);

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sample"));
        i.setPackage("com.os.operando.application.interoperability.sample");
        startActivity(i);

        try {
            Context context = createPackageContext("com.os.operando.application.interoperability.sample", CONTEXT_RESTRICTED);
            Log.d(TAG, context.getSharedPreferences("master_app", MODE_PRIVATE).getInt("int", 0) + "");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
