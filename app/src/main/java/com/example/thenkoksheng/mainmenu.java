
package com.example.thenkoksheng;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.graphics.Color;
        import android.os.CountDownTimer;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.GridLayout;
        import android.view.View;
        import android.widget.Button;

        import android.widget.EditText;
        import android.widget.TextView;

        import org.w3c.dom.Text;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Random;

public class mainmenu extends AppCompatActivity implements View.OnClickListener {
    private List<Button> buttonLIst;
    private CountDownTimer timer;
    private int score =0 ;
    private Button highlighted;
    private List<Text> Highscorelist;

    private void gamestart() {
        int lvnum = getIntent().getIntExtra("level" , 1);
        int lvrsc = getResources().getIdentifier("level" +lvnum,"layout",getPackageName());
        setContentView(lvrsc);
        GridLayout gridlayout = findViewById(R.id.gridlayout);

        //using looping to get the child of grid layout
        for (int i=0 ; i <gridlayout.getChildCount();i++){
            View child = gridlayout.getChildAt(i);
            if (child instanceof Button){
                Button button =(Button) child;
                if (button.isClickable()) {
                    button.setBackgroundColor(Color.parseColor("#ADD8E6"));
            }}
        }


    }
    private void endgame(){
        if (timer != null){
            timer.cancel();
        }
        byebye(score);
    }

    private void byebye(int score){
        endlevelinfo(score);
    }


    private void gridLayout(){

        GridLayout gridlayout = findViewById(R.id.gridlayout);
        buttonLIst= new ArrayList<>();
        //using looping to get the child of grid layout
        for (int i=0 ; i <gridlayout.getChildCount();i++){
            View child = gridlayout.getChildAt(i);
            if (child instanceof Button){
                Button button =(Button) child;
                button.setOnClickListener(this);
                buttonLIst.add(button);
            }
        }
    }

    private void random_highlighted(){
        int getid = new Random().nextInt(buttonLIst.size());
        highlighted = buttonLIst.get(getid);
        highlighted.setBackgroundColor(Color.BLUE);
    }

    private void deactivatebutton(){
        highlighted.setBackgroundColor(Color.LTGRAY);
        highlighted.setClickable(false); //making the button unclickable
        buttonLIst.remove(highlighted); //remove the button so there will no repeated
        if (!buttonLIst.isEmpty()){
            random_highlighted();
        }
        else{
            endgame();
        }
    }

    private void counter(){
        timer = new CountDownTimer(5000 ,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TextView remaintime =findViewById(R.id.timer);
                remaintime.setText("TIMER :"+(millisUntilFinished/1000)+"s") ;

            }

            @Override
            public void onFinish() {
                endgame();
            }
        }.start();
    }

    public void onBackPressed() {
        //using te back pressed button function to get back to the level selction part
        Intent intent = new Intent(this, levelselect.class);
        startActivity(intent);

        // Finish the current activity
        finish();
    }

    private void endlevelinfo(int score) {
        AlertDialog.Builder info = new AlertDialog.Builder(this);
        info.setTitle("Congratulatiion , Level Completed!!!");
        info.setMessage("Score" + score);
        info.setPositiveButton("Back to Main Menu ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent it = new Intent(mainmenu.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        });
        info.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        AlertDialog dialog = info.create();
        dialog.show();
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gamestart();
        gridLayout();
        random_highlighted();
        counter();
    }

    @Override
    public void onClick(View v) {
        //if touch the highlighted button will having a score increase of 10
        if (v==highlighted){
            score =score +10 ;
            TextView showscore = findViewById(R.id.score);
            showscore.setText("Score:"+score);
            deactivatebutton();
        }

    }
}