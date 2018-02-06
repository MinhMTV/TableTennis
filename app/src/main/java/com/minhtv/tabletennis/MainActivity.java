package com.minhtv.tabletennis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int count1 = 0;
    int count2 = 0;
    int win1 = 0;
    int win2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startGame(View view) {


        EditText checkName = (EditText) findViewById(R.id.player1);
        String editName1 = checkName.getText().toString();

        EditText checkName2 = (EditText) findViewById(R.id.player2);
        String editName2 = checkName2.getText().toString();


        displayName1(editName1);
        displayName2(editName2);


        win1 = 0;
        win2 = 0;
        Reset();
        displayGameWon1(win1);
        displayGameWon2(win2);

    }


    public void Count1(View view) {
        int difference = count1 - count2;
        if (difference < 0)
            difference = difference * -1;

        count1 = count1 + 1;
        display(count1);
        displaybutton1(count1);


        if (count1 > 11 && difference > 1) {

            if (win1 >= 2) {
                win1 = win1 + 1;
                displayGameWon1(win1);
                Toast toast = Toast.makeText(this, R.string.toast_Win1, Toast.LENGTH_SHORT);
                toast.show();
                Reset();

                return;

            } else {
                win1 = win1 + 1;
                displayGameWon1(win1);
                Reset();

            }

        }
    }


    public void Count2(View view) {
        int difference = count1 - count2;
        if (difference < 0)
            difference = difference * -1;

        count2 = count2 + 1;
        display2(count2);
        displaybutton2(count2);



        if (count2 > 11 && difference > 1) {

            if (win2 >= 2) {

                win2 = win2 + 1;
                displayGameWon2(win2);
                Toast toast = Toast.makeText(this, R.string.toast_Win2, Toast.LENGTH_SHORT);
                toast.show();
                Reset();

                return;

            } else {
                win2 = win2 + 1;
                displayGameWon2(win2);
                Reset();


            }

        }

    }

    private void Reset() {
        count1 = 0;
        count2 = 0;
        display(count1);
        displaybutton1(count1);
        display2(count2);
        displaybutton2(count2);

    }


    //display number of the button counter1
    private void displaybutton1(int number) {
        TextView Button_Score1 = (TextView) findViewById(R.id.button_count1);
        Button_Score1.setText("" + number);
    }


    //display number of the button counter2
    private void displaybutton2(int number) {
        TextView Button_Score2 = (TextView) findViewById(R.id.button_count2);
        Button_Score2.setText("" + number);
    }


    //display number of the Score1
    private void display(int number) {
        TextView Score1 = (TextView) findViewById(R.id.counter1);

        Score1.setText("" + number);
    }

    //display number of the Score2
    private void display2(int number) {
        TextView Score2 = (TextView) findViewById(R.id.counter2);
        Score2.setText("" + number);
    }

    //display number of the Score1
    private void displayName1(String name) {
        TextView name1 = (TextView) findViewById(R.id.name1);
        name1.setText(name);

    }

    //display name of Player2
    private void displayName2(String name) {
        TextView name2 = (TextView) findViewById(R.id.name2);
        name2.setText(name);

    }

    //display number of Wins of Player1
    private void displayGameWon1(int number) {
        TextView win1 = (TextView) findViewById(R.id.display_1);
        win1.setText("" + number);

    }

    //display number of Wins of Player1
    private void displayGameWon2(int number) {
        TextView win2 = (TextView) findViewById(R.id.display_2);
        win2.setText("" + number);

    }




}