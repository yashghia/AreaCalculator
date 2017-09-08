/* Name : Yash Ghia
   In class #2
   File Name : CalculatorAreaActivity
*/

package com.calculator.yash.areacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CalculateAreaActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    TextView tv;
    TextView length2;
    String shape ="";
    Double area=0.0;
    Boolean visible = true;
    TextView results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_area);
    }

    public void figure(View view){
        tv = (TextView) findViewById(R.id.shape);
        length2 = (TextView) findViewById(R.id.textLength2);
        et2 = (EditText) findViewById(R.id.length2);
        switch (view.getId()){
            case R.id.circle:
                tv.setText("Circle");
                shape = "Circle";
                length2.setVisibility(view.INVISIBLE);
                et2.setVisibility(view.INVISIBLE);
                visible = false;
                break;
            case R.id.triangle:
                tv.setText("Triangle");
                shape = "Triangle";
                length2.setVisibility(view.VISIBLE);
                et2.setVisibility(view.VISIBLE);
                visible=true;
                break;
            case R.id.square:
                tv.setText("Square");
                shape = "Square";
                length2.setVisibility(view.INVISIBLE);
                et2.setVisibility(view.INVISIBLE);
                visible = false;
                break;
        }
    }

    public void calculate(View view){
        et1 = (EditText) findViewById(R.id.length1);
        et2 = (EditText) findViewById(R.id.length2);
        results = (TextView) findViewById(R.id.showResults);
        if(shape!="") {
            Double len1 = Double.parseDouble(et1.getText().toString());
            if (visible) {
                Double len2 = Double.parseDouble(et2.getText().toString());
                area = len1 * len2 * 0.5;
            } else if (shape == "Square") {
                area = len1 * len1;
            } else if (shape == "Circle") {
                area = 3.1416 * len1 * len1;
            }
            results.setText(area.toString());
        }
        else
        {
            results.setText("Select a Shape");
        }
    }

    public void clear(View view){
        results = (TextView) findViewById(R.id.showResults);
        tv = (TextView) findViewById(R.id.shape);
        results.setText("");
        tv.setText("Select a Shape");

    }
}
