package com.galy7she.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btLogin;
	//�����û�����admin��ƥ���������123456
	//����û���¼����֤����ʹ��Toast��ʾ������½�ɹ������ߡ���½ʧ�ܡ�
	private EditText etUsername;
	private EditText etPassword;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_3);
		//1.��ʼ��һ��Button���������EditTest����
		btLogin = (Button) findViewById(R.id.bt_login);
		etUsername = (EditText) findViewById(R.id.et_username);
		etPassword = (EditText) findViewById(R.id.et_userpassword);
		InnerOnClickListener  onclickListener = new InnerOnClickListener();
		//3.����������������Ϊ��ť���õ��������
		btLogin.setOnClickListener(onclickListener);
		//4.Ϊ2��EditTest���ü�����
		TextWatcher watcher = new InnerTextWacther();
		etUsername.addTextChangedListener(watcher);
		etPassword.addTextChangedListener(watcher);
	}
	//3.2.ʹ���ڲ���ʵ��TextWatcher
	private class InnerTextWacther implements TextWatcher {

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			//�ı�����֮ǰ
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			//����ʱ
			
		}

		@Override
		public void afterTextChanged(Editable s) {
			// �����
			String name = etUsername.getText().toString();
			String password = etPassword.getText().toString();
			
			btLogin.setEnabled(name.length()>=4 && password.length() >=3);
			
		}
		
	}
	//2.1.ʹ���ڲ���ʵ��OnClickLisetener
	private class InnerOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			//1.��ȡ������û���������
			String name = etUsername.getText().toString().trim();
			String password = etPassword.getText().toString();
			//2.1�ж��û���������ϲ��Ϸ�
			if(name.length() < 4) {
				Toast.makeText(MainActivity.this, "�û������Ϸ�������", Toast.LENGTH_LONG).show();
				return;
			}
			if(password.length() < 4) {
				Toast.makeText(MainActivity.this, "���벻�Ϸ�������", Toast.LENGTH_LONG).show();
				return;
			}
			//2.2�ж��û���������������ȷ
			if("admin".equals(name) &&  "123456".equals(password)) {
				Toast.makeText(MainActivity.this, "��½�ɹ�", Toast.LENGTH_LONG).show();
				return;
			}else {
				Toast.makeText(MainActivity.this, "��½ʧ��", Toast.LENGTH_LONG).show();
				return;
			}
					
		}
		
	}
	
	
} 	