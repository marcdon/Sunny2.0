package e.marc.sunny;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {


    public FirebaseAuth.AuthStateListener authListener;
    public FirebaseAuth auth;
    public String user;

    public Button signOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    }

    public void onClickLogout (View view) {
        FirebaseAuth.getInstance().signOut();
        Intent intent =new Intent(DashboardActivity.this, UserloginActivity.class);
        startActivity(intent);
        finish();

    }
}
