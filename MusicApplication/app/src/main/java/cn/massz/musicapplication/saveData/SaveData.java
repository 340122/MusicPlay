package cn.massz.musicapplication.saveData;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 定义保存用户名和密码的方法，读取用户名和密码的方法
 * @author pc-student
 *
 */
public class SaveData {
	//保存用户名和密码
	public static boolean saveInfo(Context context,String phone,String password){
		SharedPreferences sp =  context.getSharedPreferences("data",context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString("phone", phone);
		editor.putString("password", password);
		editor.commit();
		return true;

	}


	//读取用户名和密码
	public static Map<String,String> getInfo(Context context){
		SharedPreferences sp = context.getSharedPreferences("data", context.MODE_PRIVATE);
		String name = sp.getString("phone", "");
		String psd = sp.getString("password", "");
		Map<String,String> usermap = new HashMap<>();
		usermap.put("name", name);
		usermap.put("psd", psd);
		return usermap;
	}


}
