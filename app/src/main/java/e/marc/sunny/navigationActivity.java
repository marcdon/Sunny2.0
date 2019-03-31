package e.marc.sunny;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class navigationActivity extends AppCompatActivity {

    public FirebaseAuth.AuthStateListener authListener;
    public FirebaseAuth auth;
    public String user;

    public Button signOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    }

    public void onClickLogout (View view) {
        FirebaseAuth.getInstance().signOut();
        Intent intent =new Intent(navigationActivity.this, UserloginActivity.class);
        startActivity(intent);
        finish();

    }

    public void onClickaccountdetailsbtn (View view) {
        Intent intent = new Intent(navigationActivity.this, sunnyPasswordActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClicksummarybtn (View view) {
        Intent intent = new Intent(navigationActivity.this, sunnyPasswordActivity.class); //change
        startActivity(intent);
        finish();
    }

    public void onClickdashboardbtn (View view) {
        Intent intent = new Intent(navigationActivity.this, sunnyPasswordActivity.class); //change
        startActivity(intent);
        finish();
    }
    public void onClickboardsbtn (View view) {
        Intent intent = new Intent(navigationActivity.this, BoardLocater.class); //change
        startActivity(intent);
        finish();
    }
}
