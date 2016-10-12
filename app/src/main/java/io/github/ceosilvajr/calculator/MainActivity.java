package io.github.ceosilvajr.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  private EditText edtFirstNumber;
  private EditText edtSecondNumber;

  private TextView tvOperation;
  private TextView tvFirstNumber;
  private TextView tvSecondNumber;
  private TextView tvAnswer;

  private RadioGroup rgOperators;
  private RadioButton rbDivide;
  private RadioButton rbMultiply;
  private RadioButton rbAdd;
  private RadioButton rbMinus;

  private Button btnEquals;
  private Button btnClear;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
  }

  private void initView() {
    edtFirstNumber = (EditText) findViewById(R.id.edtFirstNumber);
    edtSecondNumber = (EditText) findViewById(R.id.edtSecondNumber);

    rgOperators = (RadioGroup) findViewById(R.id.rgOperators);
    rbDivide = (RadioButton) findViewById(R.id.rbDivide);
    rbMultiply = (RadioButton) findViewById(R.id.rbMultiply);
    rbMinus = (RadioButton) findViewById(R.id.rbMinus);
    rbAdd = (RadioButton) findViewById(R.id.rbAdd);

    btnEquals = (Button) findViewById(R.id.btnEquals);

    tvFirstNumber = (TextView) findViewById(R.id.tvFirstNumber);
    tvSecondNumber = (TextView) findViewById(R.id.tvSecondNumber);
    tvOperation = (TextView) findViewById(R.id.tvOperation);
    tvAnswer = (TextView) findViewById(R.id.tvAnswer);

    btnClear = (Button) findViewById(R.id.btnClear);

    btnEquals.setOnClickListener(new EqualClicked());
    btnClear.setOnClickListener(new ClearButtonClicked());
  }

  private class ClearButtonClicked implements View.OnClickListener {

    @Override public void onClick(View view) {
      tvFirstNumber.setText("0");
      tvSecondNumber.setText("0");
      tvAnswer.setText("0");
      tvOperation.setText("*");
      rbMultiply.setChecked(true);
      rbDivide.setChecked(false);
      rbAdd.setChecked(false);
      rbMinus.setChecked(false);
    }
  }

  private class EqualClicked implements View.OnClickListener {

    @Override public void onClick(View view) {

      String firstNumber = edtFirstNumber.getText().toString();
      String secondNumber = edtSecondNumber.getText().toString();

      if (!isValidateNumbers(firstNumber, secondNumber)) {
        return;
      }

      String answer = compute(Double.valueOf(firstNumber), Double.valueOf(secondNumber));

      tvFirstNumber.setText(firstNumber);
      tvSecondNumber.setText(secondNumber);
      tvAnswer.setText(answer);

      edtFirstNumber.setText("");
      edtSecondNumber.setText("");
    }

    private boolean isValidateNumbers(String firstNumber, String secondNumber) {
      if (firstNumber.length() == 0) {
        Toast.makeText(MainActivity.this, "Please input first number", Toast.LENGTH_SHORT).show();
        return false;
      } else if (secondNumber.length() == 0) {
        Toast.makeText(MainActivity.this, "Please input second number", Toast.LENGTH_SHORT).show();
        return false;
      }
      return true;
    }

    private String compute(double firstNumber, double secondNumber) {
      int radioButtonId = rgOperators.getCheckedRadioButtonId();
      double answer = 0;
      switch (radioButtonId) {
        case R.id.rbMultiply:
          answer = firstNumber * secondNumber;
          tvOperation.setText("*");
          break;
        case R.id.rbAdd:
          answer = firstNumber + secondNumber;
          tvOperation.setText("+");
          break;
        case R.id.rbDivide:
          answer = firstNumber / secondNumber;
          tvOperation.setText("/");
          break;
        case R.id.rbMinus:
          answer = firstNumber - secondNumber;
          tvOperation.setText("-");
          break;
      }
      return Double.toString(answer);
    }
  }
}
