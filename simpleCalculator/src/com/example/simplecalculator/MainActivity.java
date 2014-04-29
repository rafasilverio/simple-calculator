package com.example.simplecalculator;

import com.example.simplecalculator.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
 * @author Rafael Silvério da Silva <rafasilverio0@gmail.com>
 * @version 0.1 - http://github.com/rafasilverio/
 * */
//Main
public class MainActivity extends ActionBarActivity {
	TextView res;
	double resultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		res = (TextView) findViewById(R.id.textView2);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	//Sum
	public void sum(View v) {
		try {
			resultado = doubleNumberOne() + doubleNumberTwo();
			setTextRes(resultado);
		} catch (Exception ex) {
			Toast.makeText(getApplicationContext(), "Entre com algum valor!",
					Toast.LENGTH_LONG).show();
		}
	}
	
	//Substraction
	public void subtraction(View v) {
		try {
			resultado = doubleNumberOne() - doubleNumberTwo();
			setTextRes(resultado);
		} catch (Exception ex) {
			Toast.makeText(getApplicationContext(), "Entre com algum valor!",
					Toast.LENGTH_LONG).show();
		}
	}
	
	//Division
	public void division(View v) {
		try {
			resultado = doubleNumberOne() / doubleNumberTwo();
			setTextRes(resultado);
		} catch (Exception ex) {
			Toast.makeText(getApplicationContext(), "Entre com algum valor!",
					Toast.LENGTH_LONG).show();
		}
	}
	
	//Multiplication
	public void multiplication(View v) {
		try {
			resultado = doubleNumberOne() * doubleNumberTwo();
			setTextRes(resultado);
		} catch (Exception ex) {
			Toast.makeText(getApplicationContext(), "Entre com algum valor!",
					Toast.LENGTH_LONG).show();
		}
	}
	
	//Clear fields
	public void clear(View v){
		EditText numberOne = (EditText) findViewById(R.id.numberOne);
		numberOne.setText("");
		
		EditText numberTwo = (EditText) findViewById(R.id.numberTwo);
		numberTwo.setText("");
		
		TextView text = (TextView) findViewById(R.id.textView2);
		text.setText("");
	}

	//NumberOne
	private Double doubleNumberOne() {
		EditText numberOne = (EditText) findViewById(R.id.numberOne);
		return Double.valueOf(numberOne.getText().toString());
	}

	//NumberTwo
	private Double doubleNumberTwo() {
		EditText numberTwo = (EditText) findViewById(R.id.numberTwo);
		return Double.valueOf(numberTwo.getText().toString());
	}

	//SetResult
	private void setTextRes(double resultado) {
		TextView text = (TextView) findViewById(R.id.textView2);
		text.setText(String.valueOf(resultado));
	}
}
