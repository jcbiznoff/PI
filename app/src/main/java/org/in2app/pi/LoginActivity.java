package org.in2app.pi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * login activity
 * Created by jaychung on 1/2/16.
 */
public class LoginActivity extends AppCompatActivity {
    Firebase mFirebaseRef;
    private View parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        parentLayout = findViewById(R.id.activity_login_root);
        ButterKnife.bind(this);
        Firebase.setAndroidContext(this);
        mFirebaseRef = new Firebase("https://in2-pi.firebaseio.com");
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btnLogin)
    public void onLoginClicked(){
        mFirebaseRef.authWithPassword("jenny@example.com", "correcthorsebatterystaple", authResultHandler);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btnSignUp)
    public void onSignupClicked(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }


    // Create a handler to handle the result of the authentication
    Firebase.AuthResultHandler authResultHandler = new Firebase.AuthResultHandler() {
        @Override
        public void onAuthenticated(AuthData authData) {
            // Authenticated successfully with payload authData
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        @Override
        public void onAuthenticationError(FirebaseError firebaseError) {
            // Authenticated failed with error firebaseError
            Snackbar.make(parentLayout ,firebaseError.getMessage(), Snackbar.LENGTH_LONG).show();
        }
    };

}
