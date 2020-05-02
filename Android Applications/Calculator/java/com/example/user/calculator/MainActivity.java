package com.example.user.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
    private Button btnClear;
    private Button btnPercent;
    private Button btnBackspace;
    private Button btnDiv;
    private Button btnMul;
    private Button btnSub;
    private Button btnAdd;
    private Button btnDot;
    private Button btnEqual;

    private TextView input;
    private TextView output;

    private String value1="0";
    private String value2="0";

    private String inputString = "";
    private String outputString = "";

    private int verify()    {
        if (inputString.length()!=0)
        {
            char ch = inputString.charAt(inputString.length()-1);
            if (ch=='+' || ch=='-' || ch=='/' || ch=='*')
                return 0;
            return 1;
        }
        return 0;
    }

    private void calculate(char ch)
    {

        char opr=' ';

        if (inputString.indexOf('+')!=-1)
            opr = '+';
        else if (inputString.indexOf('-')!=-1)
            opr = '-';
        else if (inputString.indexOf('*')!=-1)
            opr = '*';
        else if (inputString.indexOf('/')!=-1)
            opr = '/';
        else
            opr = ' ';

        if (ch=='0' || ch=='.')
        {
            if (opr == ' ')
            {
                if ((ch=='0' && Float.parseFloat(value1)==0) || (ch=='.'&& value1.indexOf('.')==-1) )
                {
                    value1 += ch;
                    outputString = value1;
                    inputString = value1;
                }
            }
            if (opr != ' ')
            {
                value2 += ch;
                inputString += ch;
                switch(opr)
                {
                    case '+' : outputString = String.valueOf(Float.parseFloat(value1)+Float.parseFloat(value2));
                        break;
                    case '*' : outputString = String.valueOf(Float.parseFloat(value1)*Float.parseFloat(value2));
                        break;
                    case '-' : outputString = String.valueOf(Float.parseFloat(value1)-Float.parseFloat(value2));
                        break;
                    case '/' : outputString = String.valueOf(Float.parseFloat(value1)/Float.parseFloat(value2));
                        break;
                }
            }
        }
        else if (ch=='1' || ch=='2' || ch=='3' || ch=='4' || ch=='5' || ch=='6' || ch=='7' ||ch=='8' || ch=='9')
        {
            inputString += ch;
            if (opr == ' ')
            {
                value1 = value1+ch;
                outputString = value1;
            }
            else
                value2 += ch;
            switch(opr)
            {
                case '+' : outputString = String.valueOf(Float.parseFloat(value1)+Float.parseFloat(value2));
                    break;
                case '*' : outputString = String.valueOf(Float.parseFloat(value1)*Float.parseFloat(value2));
                    break;
                case '-' : outputString = String.valueOf(Float.parseFloat(value1)-Float.parseFloat(value2));
                    break;
                case '/' : outputString = String.valueOf(Float.parseFloat(value1)/Float.parseFloat(value2));
                    break;
            }
        }
        else if (ch == '%')
        {
            value1 = String.valueOf(Float.parseFloat(value1)/100);
            outputString = value1;
            value2 = "0";
            inputString = value1;
        }
        else
        {
            if (opr == ' ')
            {
                outputString = String.valueOf(Float.parseFloat(value1));
                value2="0";
            }
            else
            {
                switch(opr)
                {
                    case '+' : value1 = String.valueOf(Float.parseFloat(value1)+Float.parseFloat(value2));
                                break;
                    case '*' : value1 = String.valueOf(Float.parseFloat(value1)*Float.parseFloat(value2));
                                break;
                    case '-' : value1 = String.valueOf(Float.parseFloat(value1)-Float.parseFloat(value2));
                                break;
                    case '/' : value1 = String.valueOf(Float.parseFloat(value1)/Float.parseFloat(value2));
                                break;
                }
                outputString = value1;
                value2 = "0";
            }

            if (ch != '<')
                inputString = value1+ch;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnPercent = (Button)findViewById(R.id.btnPercent);
        btnBackspace = (Button)findViewById(R.id.btnBackspace);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnAdd = (Button)findViewById(R.id.btnSub);
        btnSub = (Button)findViewById(R.id.btnAdd);
        btnDot = (Button)findViewById(R.id.btnDot);
        btnEqual = (Button)findViewById(R.id.btnEqual);
        input   = (TextView)findViewById(R.id.input);
        output  = (TextView)findViewById(R.id.output);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (inputString=="")
                {
                    value1 = "0";
                    inputString="0";
                    outputString="0";
                }
                else
                    calculate('0');
                input.setText(inputString);
                output.setText(String.valueOf(Float.parseFloat(outputString)));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('1');
                input.setText(inputString);
                output.setText(String.valueOf(Float.parseFloat(outputString)));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('2');
                input.setText(inputString);
                output.setText(String.valueOf(Float.parseFloat(outputString)));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('3');
                input.setText(inputString);
                output.setText(String.valueOf(Float.parseFloat(outputString)));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('4');
                input.setText(inputString);
                output.setText(String.valueOf(Float.parseFloat(outputString)));
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('5');
                input.setText(inputString);
                output.setText(String.valueOf(Float.parseFloat(outputString)));
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('6');
                input.setText(inputString);
                output.setText(String.valueOf(Float.parseFloat(outputString)));
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('7');
                input.setText(inputString);
                output.setText(String.valueOf(Float.parseFloat(outputString)));
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('8');
                input.setText(inputString);
                output.setText(String.valueOf(Float.parseFloat(outputString)));
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('9');
                input.setText(inputString);
                output.setText(String.valueOf(Float.parseFloat(outputString)));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString="";
                outputString="";
                value1="0";
                value2="0";
                input.setText("");
                output.setText("");
            }
        });

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputString.length()!=0)
                {
                    inputString = inputString.substring(0,inputString.length()-1);
                    char opr=' ';

                    if (inputString.indexOf('+')!=-1)
                        opr = '+';
                    else if (inputString.indexOf('-')!=-1)
                        opr = '-';
                    else if (inputString.indexOf('*')!=-1)
                        opr = '*';
                    else if (inputString.indexOf('/')!=-1)
                        opr = '/';
                    else
                        opr = ' ';

                    if (opr==' ' && Float.parseFloat(value1)!=0)
                        value1 = value1.substring(0,value1.length()-1);

                    if (opr!=' ' && Float.parseFloat(value2)!=0)
                        value2 = value2.substring(0,value2.length()-1);

                    switch(opr)
                    {
                        case '+' : outputString = String.valueOf(Float.parseFloat(value1)+Float.parseFloat(value2));
                            break;
                        case '*' : outputString = String.valueOf(Float.parseFloat(value1)*Float.parseFloat(value2));
                            break;
                        case '-' : outputString = String.valueOf(Float.parseFloat(value1)-Float.parseFloat(value2));
                            break;
                        case '/' : outputString = String.valueOf(Float.parseFloat(value1)/Float.parseFloat(value2));
                            break;
                        case ' ' : outputString = inputString;
                    }
                    input.setText(inputString);
                    output.setText(String.valueOf(Float.parseFloat(outputString)));
                    

                }

            }
        });



        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verify()==1)
                {
                    calculate('%');
                    input.setText(inputString);
                    output.setText(String.valueOf(Float.parseFloat(outputString)));
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verify()==1)
                {
                    calculate('/');
                    input.setText(inputString);
                    output.setText(String.valueOf(Float.parseFloat(outputString)));
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verify()==1)
                {
                    calculate('*');
                    input.setText(inputString);
                    output.setText(String.valueOf(Float.parseFloat(outputString)));
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verify()==1)
                {
                    calculate('-');
                    input.setText(inputString);
                    output.setText(String.valueOf(Float.parseFloat(outputString)));
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verify()==1)
                {
                    calculate('+');
                    input.setText(inputString);
                    output.setText(String.valueOf(Float.parseFloat(outputString)));
                }
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputString=="")
                {
                    value1 = "0.";
                    inputString="0.";
                    outputString="0.";
                }
                else
                    calculate('.');
                input.setText(inputString);
                output.setText(String.valueOf(Float.parseFloat(outputString)));
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Float.parseFloat(value1)==0 && Float.parseFloat(value2)==0 )
                {
                    inputString="0";
                    outputString="0";
                    input.setText("0");
                    output.setText("0");
                }
                else
                {
                    inputString = outputString;
                    input.setText(outputString);
                    value1 = outputString;
                    value2 = "0";
                    output.setText(String.valueOf(Float.parseFloat(outputString)));
                }
            }
        });
    }

}
