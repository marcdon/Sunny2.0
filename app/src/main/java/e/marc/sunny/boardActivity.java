package e.marc.sunny;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class boardActivity extends AppCompatActivity {

    public FirebaseAuth.AuthStateListener authListener;
    public FirebaseAuth auth;
    public String user;

    public Button signOutBtn;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        ArrayList<sunnyItem> itemList = new ArrayList<sunnyItem>();

        itemArrayAdapter itemArrayAdapter = new itemArrayAdapter(R.layout.layout, itemList);
        recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);

        // Populating list items
        for(int i=0; i<100; i++) {
            itemList.add(new sunnyItem("Item " + i));
        }


    }

    public void onClickLogout (View view) {
        FirebaseAuth.getInstance().signOut();
        Intent intent =new Intent(boardActivity.this, UserloginActivity.class);
        startActivity(intent);
        finish();

    }
}

