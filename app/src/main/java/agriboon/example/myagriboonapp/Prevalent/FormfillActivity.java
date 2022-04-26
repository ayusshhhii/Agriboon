package agriboon.example.myagriboonapp.Prevalent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import agriboon.example.myagriboonapp.Fragments.OrdersFragment;
import agriboon.example.myagriboonapp.HomeActivity;
import agriboon.example.myagriboonapp.R;

public class FormfillActivity extends AppCompatActivity {

    private Button saveformbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formfill);

        saveformbutton = (Button) findViewById(R.id.formsavebtn);


        saveformbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FormfillActivity.this, "Saved successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FormfillActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}