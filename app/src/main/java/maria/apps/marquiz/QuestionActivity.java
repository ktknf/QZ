package maria.apps.marquiz;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {

    EditText ans;
    String answer;
    String[] Answers;
    int id;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        getSupportActionBar().hide();

        ans=findViewById(R.id.ans);

        Bundle extras = getIntent().getExtras();
        answer = extras.getString("answer");
        Answers = extras.getStringArray("answers");
        id= extras.getInt("id");
        count= extras.getInt("count");
        id=id+1;

        Log.d("logloglog", "onCreate: " +answer +"   "+ id);



        Resources res = getResources();
        String mDrawableName = "q"+id;
        int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID );
        ImageView img=findViewById(R.id.img);
        img.setImageDrawable(drawable);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void checkAnswer(View v) {
        String submitted= String.valueOf(ans.getText()).replace(" ","");
        Log.d("logloglog", "checkAnswer: "+submitted);
        String right=answer.replace(" ","");
        if(submitted.equals("exit"))
        {
            this.finishAffinity();

        }

        else if(submitted.equals(right))
        {
            Toast.makeText(QuestionActivity.this, "درسته!",
                    Toast.LENGTH_LONG).show();
            if(count<id+1)
            {
                Toast.makeText(QuestionActivity.this, "پایان سوالات",
                        Toast.LENGTH_LONG).show();
            }
            else {
                //Log.d("logloglog", "checkAnswer: "+count);

                Intent i = new Intent(QuestionActivity.this, QuestionActivity.class);
                i.putExtra("answer", Answers[id]);
                i.putExtra("answers", Answers);
                i.putExtra("count", count);
                i.putExtra("id", id);
                startActivity(i);
            }
        }
        else
        {
            Toast.makeText(QuestionActivity.this, "متاسفم،غلطه!",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {

    }


}



