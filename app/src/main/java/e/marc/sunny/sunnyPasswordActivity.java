package e.marc.sunny;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class sunnyPasswordActivity extends AppCompatActivity {

    public EditText resetEmail;
    public Button resetPasswordBtn, goBackBtn;
    public ImageView logoHolder;
   // public ProgressBar progressBar;
    public FirebaseAuth auth;
    public TextView resetPasswordMSG;
    public LinearLayout resetpasswordholder,msgHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunny_password);

        auth = FirebaseAuth.getInstance();

        resetEmail = (EditText) findViewById(R.id.resetEmail);
        resetPasswordBtn = (Button) findViewById(R.id.resetPasswordBtn);
        goBackBtn = (Button) findViewById(R.id.goBackBtn);
        logoHolder = (ImageView) findViewById(R.id.logoHolder);
        resetPasswordMSG = (TextView) findViewById(R.id.resetPasswordMSG);

        Button goBackBtn = (Button) findViewById(R.id.goBackBtn);
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sunnyPasswordActivity.this, SignupActivity.class));
            }
        });

        resetPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = resetEmail.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Please enter your email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(sunnyPasswordActivity.this, "Instructions have been sent to your email", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(sunnyPasswordActivity.this, "Password failed", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });
    }

}
