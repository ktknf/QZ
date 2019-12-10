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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {

    EditText ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        ans=findViewById(R.id.ans);

        Bundle extras = getIntent().getExtras();
        String answer = extras.getString("answer");
        int id= extras.getInt("id");
        id=id+1;

        Log.d("logloglog", "onCreate: " +answer +"   "+ id);


        Resources res = getResources();
        String mDrawableName = "q"+id;
        int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID );
        ImageView img=findViewById(R.id.img);
        img.setImageDrawable(drawable);

    }


    public void checkAnswer(View v) {
        String submitted= String.valueOf(ans.getText());
        Log.d("logloglog", "checkAnswer: "+submitted);
    }

}
