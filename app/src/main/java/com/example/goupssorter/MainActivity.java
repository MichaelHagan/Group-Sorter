package com.example.goupssorter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;


class student {
    String name;
    int index;
}

public class MainActivity extends AppCompatActivity {

    int groupN;
    int randS;
    int checker;
    int schecker=0;
    int moves = 0;
    String print1;
    Random ra = new Random();

    student real[] = new student[23];
    student flux[] = new student [23];
    student starboys[] = new student [6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loader();
    }

    private void loader(){

         schecker = 0;
         moves = 0;


        for (checker = 0; checker<23; checker++){
            real[checker] = new student();}
        for (checker = 0; checker<23; checker++){
            flux[checker] = new student();
        }
        for (checker = 0; checker<6; checker++){
            starboys[checker] = new student();
        }

        for (checker = 0; checker<23; checker++) {
            if(checker == 10 || checker == 13){
                real[checker].index = schecker + 2;
                schecker = schecker + 2;
            }
            else{
                real[checker].index = schecker + 1;
                schecker++;
            }
        }

        names();

        while (moves<21) {
            randS = ra.nextInt(6);
            if (starboys[randS].index != 0) {
                flux[moves].index = starboys[randS].index;
                flux[moves].name = starboys[randS].name;
                starboys[randS].index = 0;
                moves = moves + 4;
            }
        }
        real[2].index = 0;
        real[8].index = 0;
        real[9].index = 0;
        real[11].index = 0;
        real[15].index = 0;
        real[18].index = 0;

        moves = 0;

        while (moves<23) {
            randS = ra.nextInt(23);
            if (real[randS].index != 0 && flux[moves].name == null) {
                flux[moves].index = real[randS].index;
                flux[moves].name = real[randS].name;
                real[randS].index = 0;
                moves++;
            }
            if(real[randS].index != 0 && flux[moves].name != null){
                ++moves;
                flux[moves].index = real[randS].index;
                flux[moves].name = real[randS].name;
                real[randS].index = 0;
                moves++;
            }
        }

        names();
        display(display1());


    }

    public void submit(View v) {
        EditText inputter = (EditText) findViewById(R.id.inputView1);
        groupN = Integer.parseInt(inputter.getText().toString());

        display(display2());

    }

    public void names() {

        starboys[0].index = 3;
        starboys[1].index = 9;
        starboys[2].index = 10;
        starboys[3].index = 13;
        starboys[4].index = 18;
        starboys[5].index = 21;

        starboys[0].name = "Alfred Adomako Botchway";
        starboys[1].name = "Benedict Oppong";
        starboys[2].name = "Charles Takyi Appiagyei";
        starboys[3].name = "Samuel Amoah";
        starboys[4].name = "Caleb Henry Amoh";
        starboys[5].name = "Gideon Bosokah";

        real[0].name = "Francis Tanoh";
        real[1].name = "Ato Bondzie Kwasin";
        real[2].name = "Alfred Adomako Botchway";
        real[3].name = "Gabriel Kofi Kuenyegah Jnr.";
        real[4].name = "Roland Owusu Nkum";
        real[5].name = "Solomon Boateng";
        real[6].name = "Rudolph Azzu";
        real[7].name = "Justice Evans Osei Bonsu";
        real[8].name = "Benedict Oppong";
        real[9].name = "Charles Takyi Appiagyei";
        real[10].name = "Dereck Stevens";
        real[11].name = "Samuel Amoah";
        real[12].name = "Halima Daud Nuhu";
        real[13].name = "Abdul Kasiru Zakaria";
        real[14].name = "Schubert Miah";
        real[15].name = "Caleb Henry Amoh";
        real[16].name = "Shadrack Fobiri";
        real[17].name = "Priscilla Bedzrah";
        real[18].name = "Gideon Bosokah";
        real[19].name = "Mensborn Agyei Boateng";
        real[20].name = "Festus Yeboah-Agyekum";
        real[21].name = "Prince Amponsah";
        real[22].name = "Michael Idun Hagan";

    }

    public String display1() {
        String print;
        schecker=0;

        for (checker = 0; checker<23; checker++) {
            if(checker == 10 || checker == 13){
                real[checker].index = schecker + 2;
                schecker = schecker + 2;
            }
            else{
                real[checker].index = schecker+ 1;
                schecker++;
            }
        }


        print = "Index		\t\t		Name\n";
        print = print + "_____		\t\t		____\n";

        for (int results = 0; results < 23; results++) {

            if (real[results].index < 10) {
                print = print + "ED/CSC/16/000" + real[results].index + "			" + real[results].name + "\n";
            }

            if (real[results].index >= 10) {
                print = print + "ED/CSC/16/00" + real[results].index + "			" + real[results].name + "\n";
            }


        }

        print = print + "\nEnter number of members per group: \n";

        return print;
    }

    public String display2() {
        int counter=0;
        int yo = 1;

        print1 = "GROUP "+ yo + "\n";
        print1 = print1 + "Index		\t\t		Name\n";
        print1 = print1+ "_____		\t\t		____\n";

        for (int check2 = 0; check2 < 23; check2++) {


            if (flux[check2].index < 10) {
                print1 = print1 + "ED/CSC/16/000" + flux[check2].index + "			" + flux[check2].name + "\n";
                counter++;
            }

            if (flux[check2].index >= 10) {
                print1 = print1 +"ED/CSC/16/00" + flux[check2].index + "			" + flux[check2].name + "\n";
                counter++;
            }

            if (counter == groupN && check2!=22) {
                print1 = print1 +"\nGROUP " + (++yo) + "\n";
                print1 = print1 +"Index		\t\t		Name\n";
                print1 = print1 +"_____		\t\t		____\n";
                counter = 0;

            }
        }

        return print1;
    }

    public void display(String scanner) {
        TextView print = (TextView) findViewById(R.id.display1);
        print.setText(scanner);
    }

    public void Reset(View v){
        print1 = null;
        loader();

    }

    public void sharer(View v){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,print1 );
        sendIntent.setType("text/plain");

        if (print1 == null){

            Toast empty = new Toast(this);
            empty.makeText(this,"Sort groups first",Toast.LENGTH_SHORT).show();

;        }

        else{

            startActivity(sendIntent);

        }
    }


}
