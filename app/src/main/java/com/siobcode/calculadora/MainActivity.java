package com.siobcode.calculadora;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btnadd;
    Button btnmultiply;
    Button btndivide;
    Button btnminus;
    Button btnequal;
    Button btndelete;
    EditText edtresult;
    char operador = 0;
    String res;
    boolean bandResulBorrado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtresult = (EditText) findViewById(R.id.edtResult);

        OyenteClic objDetectaClic = new OyenteClic();

        //Button1
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(objDetectaClic);
        //Button2
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(objDetectaClic);
        //Button3
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(objDetectaClic);
        //Button4
        btn4 = (Button) findViewById(R.id.btnfour);
        btn4.setOnClickListener(objDetectaClic);
        //Button5
        btn5 = (Button) findViewById(R.id.btnfive);
        btn5.setOnClickListener(objDetectaClic);
        //Button6
        btn6 = (Button) findViewById(R.id.btnsix);
        btn6.setOnClickListener(objDetectaClic);
        //Button7
        btn7 = (Button) findViewById(R.id.btnseven);
        btn7.setOnClickListener(objDetectaClic);
        //Button8
        btn8 = (Button) findViewById(R.id.btneight);
        btn8.setOnClickListener(objDetectaClic);
        //Button9
        btn9 = (Button) findViewById(R.id.btnnine);
        btn9.setOnClickListener(objDetectaClic);
        //Button0
        btn0 = (Button) findViewById(R.id.btnzero);
        btn0.setOnClickListener(objDetectaClic);

        //ButtonAdd
        btnadd = (Button) findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = edtresult.getText().toString();
                operador = '+';
                edtresult.setText("");
            }
        });
        //ButtonMultiply
        btnmultiply = (Button) findViewById(R.id.btnmultiply);
        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = edtresult.getText().toString();
                operador = '*';
                edtresult.setText("");
            }
        });
        //ButtonMinus
        btnminus = (Button) findViewById(R.id.btnminus);
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = edtresult.getText().toString();
                operador = '-';
                edtresult.setText("");
            }
        });
        //Buttonsdivide
        btndivide = (Button) findViewById(R.id.btndivide);
        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = edtresult.getText().toString();
                operador = '/';
                edtresult.setText("");
            }
        });

        //Button delete
        btndelete = (Button) findViewById(R.id.btndelete);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtresult.setText("0");
            }
        });

        //Buttonequal
        btnequal = (Button) findViewById(R.id.btnequal);
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (operador == ('+')) {
                    int Result = Integer.parseInt(res) + Integer.parseInt(edtresult.getText().toString());
                    edtresult.setText(String.valueOf(Result));
                }

               else if (operador == ('*')) {
                    int Result1 = Integer.parseInt(res) * Integer.parseInt(edtresult.getText().toString());
                    edtresult.setText(String.valueOf(Result1));
                }

               else if (operador == ('/')) {
                    int Result2 = Integer.parseInt(res) / Integer.parseInt(edtresult.getText().toString());
                    edtresult.setText(String.valueOf(Result2));
                }

               else if (operador == ('-')) {
                    int Result3 = Integer.parseInt(res) - Integer.parseInt(edtresult.getText().toString());
                    edtresult.setText(String.valueOf(Result3));
                }
            }
        });
    }
    //Declatation de clase oyente\
    class OyenteClic implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if ((operador != 0) && !bandResulBorrado) {
                edtresult.setText(((Button) v).getText());
                bandResulBorrado = true;
            } else if (edtresult.getText().toString().compareTo("0") == 0)
                edtresult.setText(((Button) v).getText());
            else
                edtresult.setText(edtresult.getText() + ((Button) v).getText().toString());
        }
    }//OyenteClic

}//Main Activitye

