package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class IncidentManagement {

	private Integer InCId;//ID
	private Integer incident_id;//インシデントID
	private String incident_Name;//インシデント名
	private String incident_Content;//インシデント内容
	private Date Creation_Time;//インシデント作成時間
	private Date update_time;//インシデント更新時間
	private String Status;//インシデントステータス(対応中、対応完了)

}
