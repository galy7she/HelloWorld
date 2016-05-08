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
	//假设用户名是admin，匹配的密码是123456
	//完成用户登录的验证，并使用Toast提示“”登陆成功“或者”登陆失败“
	private EditText etUsername;
	private EditText etPassword;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_3);
		//1.初始化一个Button对象和两个EditTest对象
		btLogin = (Button) findViewById(R.id.bt_login);
		etUsername = (EditText) findViewById(R.id.et_username);
		etPassword = (EditText) findViewById(R.id.et_userpassword);
		InnerOnClickListener  onclickListener = new InnerOnClickListener();
		//3.创建出监听器对象，为按钮配置点击监听器
		btLogin.setOnClickListener(onclickListener);
		//4.为2个EditTest配置监听器
		TextWatcher watcher = new InnerTextWacther();
		etUsername.addTextChangedListener(watcher);
		etPassword.addTextChangedListener(watcher);
	}
	//3.2.使用内部类实现TextWatcher
	private class InnerTextWacther implements TextWatcher {

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			//文本输入之前
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			//输入时
			
		}

		@Override
		public void afterTextChanged(Editable s) {
			// 输入后
			String name = etUsername.getText().toString();
			String password = etPassword.getText().toString();
			
			btLogin.setEnabled(name.length()>=4 && password.length() >=3);
			
		}
		
	}
	//2.1.使用内部类实现OnClickLisetener
	private class InnerOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			//1.获取输入的用户名和密码
			String name = etUsername.getText().toString().trim();
			String password = etPassword.getText().toString();
			//2.1判断用户名和密码合不合法
			if(name.length() < 4) {
				Toast.makeText(MainActivity.this, "用户名不合法！！！", Toast.LENGTH_LONG).show();
				return;
			}
			if(password.length() < 4) {
				Toast.makeText(MainActivity.this, "密码不合法！！！", Toast.LENGTH_LONG).show();
				return;
			}
			//2.2判断用户名和密码正不正确
			if("admin".equals(name) &&  "123456".equals(password)) {
				Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
				return;
			}else {
				Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_LONG).show();
				return;
			}
					
		}
		
	}
	
	
} 	