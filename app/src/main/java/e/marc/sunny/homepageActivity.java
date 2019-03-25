package e.marc.sunny;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.allyants.boardview.Item;
import com.allyants.boardview.BoardView;
import com.allyants.boardview.SimpleBoardAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.*;


public class homepageActivity extends AppCompatActivity {


    ArrayList<SimpleBoardAdapter.SimpleColumn> data = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        BoardView boardView = findViewById(R.id.boardView);

        //create Item

        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");

        data.add(new SimpleBoardAdapter.SimpleColumn("Column 1", list));
        data.add(new SimpleBoardAdapter.SimpleColumn("Column 2", list));
        data.add(new SimpleBoardAdapter.SimpleColumn("Column 3", list));
        data.add(new SimpleBoardAdapter.SimpleColumn("Column 4", list));


        SimpleBoardAdapter boardAdapter = new SimpleBoardAdapter(this,data);
        boardView.setAdapter(boardAdapter);

        boardView.setOnItemClickListener(new BoardView.ItemClickListener() {
            @Override
            public void onClick(View view, int colum_pos, int item_pos) {
               //Toast.makeText(homepageActivity.this, " " +data.get(colum_pos).items.get(item_pos), LENGTH_SHORT).show();
            }
        });

        boardView.setOnHeaderClickListener(new BoardView.HeaderClickListener() {
            @Override
            public void onClick(View view, int i) {
                //Toast.makeText(homepageActivity.this, ""+data.get(i).header, LENGTH_SHORT).show();
            }
        });

    }
}
