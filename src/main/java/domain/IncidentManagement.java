package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class IncidentManagement {
	
	//11月22日11:55分IncidentManagementDaoImplのfindByIdの
	//IncidentManagement incident =  new IncidentManagement() ;のエラー内容を解消する為にコンストラクタ追加
	public IncidentManagement() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	private Integer id;//ID
	private Integer incident_id;//インシデントID
	private String incident_Name;//インシデント名
	private String incident_Content;//インシデント内容
	private Integer supported_person_id;//インシデント作成者のID
	private Date creation_Time;//インシデント作成時間
	private Date update_time;//インシデント更新時間
	private String status;//インシデントステータス(対応中、対応完了)
	private String user_name;//インシデント作成者名をJSPで表示させる為に追加 
	//Userの全ての情報が必要なら以下の情報でおｋ
	//private User user;
	//一旦確認の為
	private String IncidentId_Name;//インシデントID名をJSPで表示させる為に追加
	//private ServiceManagment serviceManagment;
	
}
