package com.example.ashwiniramachandra.humberdroid;


import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatabaseActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editFistname, editLastname, editMarks, editId;
    Button btnAdd, btnView, btnDelete, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grades);
        myDb = new DatabaseHelper(this);

        editFistname = (EditText)findViewById(R.id.editText_firstname);
        editLastname = (EditText)findViewById(R.id.editText_lastname);
        editMarks = (EditText)findViewById(R.id.editText_marks);
        editId = (EditText)findViewById(R.id.editText_id);
        btnAdd = (Button)findViewById(R.id.button_add);
        btnView = (Button)findViewById(R.id.button_view);
        btnUpdate = (Button)findViewById(R.id.button_update);
        btnDelete = (Button)findViewById(R.id.button_delete);
        Add();
        View();
        Delete();
        Update();
    }

    public void Add(){

        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insert(editFistname.getText().toString(), editLastname.getText().toString(),
                                editMarks.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(DatabaseActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(DatabaseActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void Update(){
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.update(editId.getText().toString(), editFistname.getText().toString(),
                                editLastname.getText().toString(),editMarks.getText().toString());
                        if (isUpdate == true)
                            Toast.makeText(DatabaseActivity.this, "Data Update", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(DatabaseActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
                    }
                });
    }


    public void Delete(){

        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Integer deletedRows = myDb.delete(editId.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(DatabaseActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(DatabaseActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                    }

                });
    }

    public void View(){

        btnView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount()== 0){
                            //show message
                            showMessage("Error","No data found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id :" + res.getString(0) + "\n");
                            buffer.append("Firstname :" + res.getString(1) + "\n");
                            buffer.append("Lastname :" + res.getString(2) + "\n");
                            buffer.append("Marks :" + res.getString(3) + "\n\n");
                        }
                        //show all data
                        showMessage("Data", buffer.toString());
                    }
                });
    }

    public void showMessage(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
