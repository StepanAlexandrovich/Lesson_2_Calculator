package java.android.lesson_2_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Logic logic;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logic = new Logic();
        textView = findViewById(R.id.textView);

        // numbers
        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.buttonDot).setOnClickListener(this);
        // action
        findViewById(R.id.buttonPlus).setOnClickListener(this);
        findViewById(R.id.buttonMinus).setOnClickListener(this);
        findViewById(R.id.buttonMultiply).setOnClickListener(this);
        findViewById(R.id.buttonShare).setOnClickListener(this);
        // result
        findViewById(R.id.buttonEquals).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
              // numbers
            case R.id.button0: logic.inputNumber("0"); break;
            case R.id.button1: logic.inputNumber("1"); break;
            case R.id.button2: logic.inputNumber("2"); break;
            case R.id.button3: logic.inputNumber("3"); break;
            case R.id.button4: logic.inputNumber("4"); break;
            case R.id.button5: logic.inputNumber("5"); break;
            case R.id.button6: logic.inputNumber("6"); break;
            case R.id.button7: logic.inputNumber("7"); break;
            case R.id.button8: logic.inputNumber("8"); break;
            case R.id.button9: logic.inputNumber("9"); break;
            case R.id.buttonDot: logic.inputNumber("."); break;
              // action
            case R.id.buttonPlus: logic.inputAction("+"); break;
            case R.id.buttonMinus: logic.inputAction("-"); break;
            case R.id.buttonMultiply: logic.inputAction("X"); break;
            case R.id.buttonShare: logic.inputAction("/"); break;
              // result
            case R.id.buttonEquals: logic.result(); break;
        }

        textView.setText(logic.getText());
    }
}