package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class IncidentManagement {

	private Integer id;//ID
	private Integer incident_id;//インシデントID
	private String incident_Name;//インシデント名
	private String incident_Content;//インシデント内容
	private Integer supported_person_id;//インシデント作成者のID
	private Date creation_Time;//インシデント作成時間
	private Date update_time;//インシデント更新時間
	private String status;//インシデントステータス(対応中、対応完了)

}
