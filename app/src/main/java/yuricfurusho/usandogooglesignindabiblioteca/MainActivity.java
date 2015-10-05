package yuricfurusho.usandogooglesignindabiblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.livetouch.fragments.GoogleSignInFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            GoogleSignInFragment googleSignInFragment = new GoogleSignInFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragContainer, googleSignInFragment, GoogleSignInFragment.class.getSimpleName())
                    .commit();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getSupportFragmentManager().findFragmentByTag(GoogleSignInFragment.class.getSimpleName()).onActivityResult(requestCode, resultCode, data);
    }
}
