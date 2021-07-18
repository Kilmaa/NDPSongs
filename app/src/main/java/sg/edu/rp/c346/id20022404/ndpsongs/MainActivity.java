package sg.edu.rp.c346.id20022404.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etTitle, etSingers, etYear;
    Button btnInsert, btnList;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnList = findViewById(R.id.btnList);
        rg = findViewById(R.id.rg);



        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                if (etTitle != null || etSingers != null || etYear != null || rg.getCheckedRadioButtonId() == -1) {
                    int rating = rg.getCheckedRadioButtonId();

                    if (rg.getCheckedRadioButtonId() == R.id.star1) {
                        rating = 1;
                    } else if (rg.getCheckedRadioButtonId() == R.id.star2) {
                        rating = 2;
                    } else if (rg.getCheckedRadioButtonId() == R.id.star3) {
                        rating = 3;
                    } else if (rg.getCheckedRadioButtonId() == R.id.star4) {
                        rating = 4;
                    } else if (rg.getCheckedRadioButtonId() == R.id.star5) {
                        rating = 5;
                    }

                    db.insertTask(etTitle.getText().toString(), etSingers.getText().toString(),
                            etYear.getText().toString(), rating);
                    Toast.makeText(MainActivity.this, "Inserted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error: Empty field is not allowed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,
                        ListActivity.class);
                startActivity(i);
            }
        });
    }
}