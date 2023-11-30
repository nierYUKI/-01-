package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Paging {
	//常に表示予定の10ページ部分を使う変数
	private int pageForm;
	private int pageTo;
	
	//現在表示しているページ番号
	private int currentPage;
	
	//1ページあたりの件数(コントローラから取得)
	private int recordPerPage;
	
	//表示されるインシデント総数(DBから取得)
	private int totalRecordConut;
	
	//ページの総数(インシデント総数によって変化する)
	private int totalPageCount;
	
	
	public Paging(int recordPerPage, int totalRecordCount) {
		
		this.recordPerPage = recordPerPage;
		this.totalPageCount = totalRecordCount;
		
		//計算のあまりが0以上だったら、1を足してページの総数を求める
		if(this.totalRecordConut % this.recordPerPage > 0) {
			this.totalPageCount = this.totalRecordConut / this.recordPerPage + 1;
			
		}else {
			this.totalPageCount = this.totalRecordConut /this.recordPerPage;
		}
		}
//実際にページングを行う際はこのメソッドが呼び出される
	public void moveTo(int page) {
		//現在のページを更新
		this.currentPage = page;
		
		//表示するページング機能の例
		//1 	2 3 4 - 10 / 1	2 3 4 	4
		//1	- 3 4 5 - 10 / 1	2 3 4		5
		//1 - 7 8 9 	10 / 1 	2 3 4 - 6
		//「pageFrom」が「2」より小さくなることはない
		this.pageForm = Math.max(page - 1,2);
		if(this.totalPageCount > 3) {
			//「pageTo」の求め方は、pageFromに「2」をたす、ただし「totalPageCount-1」を超えることはない
			this.pageTo = Math.min(this.pageForm + 2, this.totalPageCount - 1);
		}else {
			//「totalPageCount」が「2」以下ならば、計算は不要
			this.pageTo = this.totalPageCount;
		}
		//「pageFrom」は「pageTo - 2」または「2」の大きい方なので、格納しなおす
		this.pageForm = Math.max(this.pageTo - 2,2);
	
	}
}

