package com.example.texteditor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText filenameEditText, contentEditText;
	private Button saveButton;
	private ListView fileListView;
	
	String[] savedFiles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		filenameEditText = (EditText) findViewById(R.id.filenameEditText);
		contentEditText = (EditText) findViewById(R.id.contentEditText);
		saveButton = (Button) findViewById(R.id.saveButton);
		fileListView = (ListView) findViewById(R.id.fileListView);
		
		saveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String filename = filenameEditText.getText().toString();
				String content = contentEditText.getText().toString();
				
				FileOutputStream fos;
				
				try {
					fos = openFileOutput(filename, Context.MODE_PRIVATE);
					fos.write(content.getBytes());
					fos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				Toast.makeText(MainActivity.this, "Saved!", Toast.LENGTH_LONG).show();
				
				showSavedFiles();
			}
		});
		
		showSavedFiles();
	}

	protected void showSavedFiles() {
		savedFiles = getApplicationContext().fileList();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, savedFiles);
		
		fileListView.setAdapter(adapter);
		
	}
}
