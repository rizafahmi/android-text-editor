package com.example.texteditor;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private EditText filenameEditText, contentEditText;
	private Button saveButton;
	private ListView fileListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		filenameEditText = (EditText) findViewById(R.id.filenameEditText);
		contentEditText = (EditText) findViewById(R.id.contentEditText);
		saveButton = (Button) findViewById(R.id.saveButton);
		fileListView = (ListView) findViewById(R.id.fileListView);
	}
}
