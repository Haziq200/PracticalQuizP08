package sg.edu.rp.dmsd.practicalquizp08;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etAge;

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

         String sName = prefs.getString("Name","Name:");
         etName.setText(sName);

         int iAge = prefs.getInt("Age",0);
         etAge.setText(String.valueOf(iAge));
    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        int intAge = Integer.parseInt(etAge.getText().toString());

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor prefsEdit = prefs.edit();

        prefsEdit.putString("Name",strName);
        prefsEdit.putInt("Age",intAge);

        prefsEdit.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        etName = findViewById(R.id.editTextName);
        etAge = findViewById(R.id.editTextAge);



    }
}
