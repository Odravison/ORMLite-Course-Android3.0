package odravison.com.br.ormliteexample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

import odravison.com.br.ormliteexample.R;
import odravison.com.br.ormliteexample.model.User;
import odravison.com.br.ormliteexample.persistence.DataBase;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private EditText loginField;
    private EditText passwordField;

    DataBase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button) findViewById(R.id.save_button);
        loginField = (EditText) findViewById(R.id.login_field);
        passwordField = (EditText) findViewById(R.id.password_field);

        database = new DataBase(this);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User(loginField.getText().toString(), passwordField.getText().toString());
                try {
                    database.insertUser(user);
                } catch (SQLException e) {
                    Toast.makeText(MainActivity.this,
                            "Deu erro na hora de salvar",
                            Toast.LENGTH_SHORT);
                }

            }
        });


    }
}
