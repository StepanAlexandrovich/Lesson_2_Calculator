package java.android.lesson_2_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        TextView textView = findViewById(R.id.textViewResult);

        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);

        findViewById(R.id.buttonResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Double result = Double.parseDouble(editText1.getText().toString()) + Double.parseDouble(editText2.getText().toString());
                  textView.setText("" + result);
            }
        });
    }
}