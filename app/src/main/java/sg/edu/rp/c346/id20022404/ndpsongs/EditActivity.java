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

import java.text.BreakIterator;

public class EditActivity extends AppCompatActivity {
    EditText etID, etTitle, etSingers, etYear;
    RadioGroup etRG;
    RadioButton etRating, star1, star2, star3, star4, star5;
    Button btnUpdate, btnDelete, btnCancel;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etID = findViewById(R.id.etID);
        etTitle = findViewById(R.id.etTitle2);
        etSingers = findViewById(R.id.etSingers2);
        etYear = findViewById(R.id.etYear);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        etRG = findViewById(R.id.etRG);
        etRating = findViewById(etRG.getCheckedRadioButtonId());
        star1 = findViewById(R.id.opt1);
        star2 = findViewById(R.id.opt2);
        star3 = findViewById(R.id.opt3);
        star4 = findViewById(R.id.opt4);
        star5 = findViewById(R.id.opt5);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("id");

        etID.setText(data.getId());
        etTitle.setText(data.getTitle());
        etSingers.setText(data.getSinger());
        etYear.setText(data.getYear());

        if(data.getRating() == 1) {
            star1.setChecked(true);
        } else if (data.getRating() == 2) {
            star2.setChecked(true);
        } else if (data.getRating() == 3) {
            star3.setChecked(true);
        } else if (data.getRating() == 4){
            star4.setChecked(true);
        } else {
            star5.setChecked(true);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);

                int rating = etRG.getCheckedRadioButtonId();

                if (etRG.getCheckedRadioButtonId() == R.id.opt1) {
                    rating = 1;
                } else if (etRG.getCheckedRadioButtonId() == R.id.opt2) {
                    rating = 2;
                } else if (etRG.getCheckedRadioButtonId() == R.id.opt3) {
                    rating = 3;
                } else if (etRG.getCheckedRadioButtonId() == R.id.opt4) {
                    rating = 4;
                } else if (etRG.getCheckedRadioButtonId() == R.id.opt5) {
                    rating = 5;
                } else {
                    rating = 0;
                }

                if (etTitle.length() != 0 && etSingers.length() != 0 && etYear.length() != 0 && rating != 0) {


                    data.setTitle(etTitle.getText().toString());
                    data.setSinger(etSingers.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setRating(rating);
                    dbh.updateSong(data);
                    dbh.close();
                    Toast.makeText(EditActivity.this, "Updated successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditActivity.this, "Error: Empty field is not allowed!", Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteSong(data.getId());

                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}