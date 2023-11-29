package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
	
	public User() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	private Integer id; //社員ID
	private String name;//名前(ログイン)
	private String password;//パスワード(ログイン)
	private String work_id;//(所属部門)
	
	//private String work_name;//新規ユーザー登録する際にJSPに所属部門名を表示させる為に追加
	
}
