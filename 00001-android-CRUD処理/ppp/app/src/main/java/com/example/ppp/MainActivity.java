package com.example.ppp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Button add, view, update, delete;
    EditText roll_no, name;
    TextView text;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button)findViewById(R.id.add);
        view = (Button)findViewById(R.id.view);
        update = (Button)findViewById(R.id.update);
        delete = (Button)findViewById(R.id.delete);
        roll_no = (EditText)findViewById(R.id.roll_no);
        name = (EditText)findViewById(R.id.name);
        text = (TextView)findViewById(R.id.text);

        RealmConfiguration config = new RealmConfiguration.Builder(getApplicationContext()).name("myrealm.realm").build();
        Realm.setDefaultConfiguration(config);
    }

    public void clickAction(View view){
        switch (view.getId()){
            case R.id.add:  addRecord();
                break;
            case R.id.view: viewRecord();
                break;
            case R.id.update:   updateRecord();
                break;
            case R.id.delete:   deleteRecord();
        }
    }

    public void addRecord(){
        realm.beginTransaction();

        Student student = realm.createObject(Student.class);
        student.setRoll_no(Integer.parseInt(roll_no.getText().toString()));
        student.setName(name.getText().toString());

        realm.commitTransaction();
    }

    public void viewRecord(){
        RealmResults<Student> results = realm.where(Student.class).findAll();

        text.setText("");

        for(Student student : results){
            text.append(student.getRoll_no() + " " + student.getName() + "\n");
        }
    }

    public void updateRecord(){
        RealmResults<Student> results = realm.where(Student.class).equalTo("roll_no", Integer.parseInt(roll_no.getText().toString())).findAll();

        realm.beginTransaction();

        for(Student student : results){
            student.setName(name.getText().toString());
        }

        realm.commitTransaction();
    }

    public void deleteRecord(){
        RealmResults<Student> results = realm.where(Student.class).equalTo("roll_no", Integer.parseInt(roll_no.getText().toString())).findAll();

        realm.beginTransaction();

        results.get(0).removeFromRealm();

        realm.commitTransaction();
    }

    @Override
    protected void onDestroy() {
        realm.close();
        super.onDestroy();
    }
}