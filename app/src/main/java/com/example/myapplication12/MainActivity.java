package com.example.myapplication12;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{
           EditText name; String st; StringBuilder result=new StringBuilder();
    RadioGroup radioGroup;  Button btn;
    RadioButton genderradioButton;;
        String[] country = { "India", "USA", "China", "Japan", "Other"};
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //Getting the instance of Spinner and applying OnItemSelectedListener on it

            addListenerOnButtonClick();
        }

        //Performing action onItemSelected and onNothing selected
        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
           // Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_SHORT).show();
            st=country[position];
            result.append("\n Country:"+st);
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }


    public void addListenerOnButtonClick(){
            name=(EditText)findViewById(R.id.Uname);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                genderradioButton = (RadioButton) findViewById(selectedId);


                result.append("Name:"+name.getText().toString());

                result.append("\n Gender:"+genderradioButton.getText());
                  another();

                //Displaying the message on the toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }

        });
    }
    public void another(){   Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);}
}

