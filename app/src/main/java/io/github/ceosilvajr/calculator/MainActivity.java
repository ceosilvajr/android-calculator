package io.github.ceosilvajr.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private TextView tvNumberDisplay;

  private Button btnClear;
  private Button btnPositiveNegative;
  private Button btnPercentage;
  private Button btnDivide;
  private Button btnMultiply;
  private Button btnMinus;
  private Button btnAdd;
  private Button btnDot;
  private Button btnEquals;

  private Button btn0;
  private Button btn1;
  private Button btn2;
  private Button btn3;
  private Button btn4;
  private Button btn5;
  private Button btn6;
  private Button btn7;
  private Button btn8;
  private Button btn9;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
  }

  private void initView() {
    tvNumberDisplay = (TextView) findViewById(R.id.tvNumberDisplay);

    btnClear = (Button) findViewById(R.id.btnClear);
    btnPositiveNegative = (Button) findViewById(R.id.btnPositiveNegative);
    btnPercentage = (Button) findViewById(R.id.btnPercentage);
    btnDivide = (Button) findViewById(R.id.btnDivide);
    btnMultiply = (Button) findViewById(R.id.btnMultiply);
    btnMinus = (Button) findViewById(R.id.btnMinus);
    btnAdd = (Button) findViewById(R.id.btnAdd);
    btnDot = (Button) findViewById(R.id.btnDot);
    btnEquals = (Button) findViewById(R.id.btnEquals);

    btn0 = (Button) findViewById(R.id.btn0);
    btn1 = (Button) findViewById(R.id.btn1);
    btn2 = (Button) findViewById(R.id.btn2);
    btn3 = (Button) findViewById(R.id.btn3);
    btn4 = (Button) findViewById(R.id.btn4);
    btn5 = (Button) findViewById(R.id.btn5);
    btn6 = (Button) findViewById(R.id.btn6);
    btn7 = (Button) findViewById(R.id.btn7);
    btn8 = (Button) findViewById(R.id.btn8);
    btn9 = (Button) findViewById(R.id.btn9);
  }
}
