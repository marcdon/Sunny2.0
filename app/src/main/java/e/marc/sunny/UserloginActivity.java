package e.marc.sunny;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class UserloginActivity extends AppCompatActivity {

    public EditText email, password;
    public Button loginBtn;
    DatabaseReference databaseReference;
    FirebaseUser user;

    //global variables for loginScreen class.

    public FirebaseAuth Fauth;


    @Override
    public void onResume(){
        super.onResume();
        Fauth = FirebaseAuth.getInstance(); //takes user back to login page once logged in
        if (Fauth.getCurrentUser()!= null){
            Intent intent = new Intent(UserloginActivity.this, UserloginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        Fauth = FirebaseAuth.getInstance();


        Button loginButton = findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authaccount(); //calls the function
            }
        });
    }

    private void authaccount(){

        EditText accountemail = findViewById(R.id.email);
        EditText accountpassword = findViewById(R.id.password);

        String email = accountemail.getText().toString();
        String password = accountpassword.getText().toString();

        Fauth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(UserloginActivity.this, "Details Accepted",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = Fauth.getCurrentUser();
                            startActivity(new Intent(UserloginActivity.this, boardActivity.class));
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(UserloginActivity.this, "Login Failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }

}
