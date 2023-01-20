import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Kintai_2_a {

	public static void main(String[] args) {
		//  WorkingResult.csvのパス ※「C:\WorkSpace」直下に配置していない場合は適宜変更してください。
		final String WORKING_RESULT_FILE_PATH = "/Applications/Eclipse_2019-12.app/Contents/workspace/JavaPractice/src/WorkingResult.csv";
		// コンマ
		final String COMMA = ",";

		// 計算用の数値を定数で用意
		// 1時間のミリ秒換算
		final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60;
		// 1分のミリ秒換算
		final long ONE_MIN_BY_MILLI_SEC  = 1000 * 60;
		 // 1時間の分換算
		final int  ONE_HOUR_BY_MIN       = 60;

		//ファイルから読み込んだデータの格納用
		List<String> workingResults = new ArrayList<String>();

		//  WorkingResult.csvを読み込む
		//try{}　オブジェクト指向編にて学習するが、囲まないとエラーになる
		try {
			// WorkingResult.csvの読み込み準備
			File workingResultFile = new File(WORKING_RESULT_FILE_PATH);
			BufferedReader br = new BufferedReader(new FileReader(workingResultFile));

			// WorkingResult.csvを1行ずつ読み込んで順次ArrayListに格納する
			//日_出勤時_退勤時_労働時間の内容を読み込んでいる。
			String recode = br.readLine();
			while (recode != null) {
				workingResults.add(recode);
				recode = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}

		//----------------------------一月分の給与
		//月給
		//日々の日給から加算していく。
		//日給　+  当日日までの合計金額を加算していく。例：1/3分の日給を1/1〜1/2までの合計金額に加算。
		int monthlyPay = 0 ;


		// ArrayListから1行ずつ取り出して日付/出勤時間/退勤時間に振り分け
		for (int i = 0; i < workingResults.size() ; i++) {

			// 1行ずつ文字列を取り出す
			String workingRecode    = workingResults.get(i);
			// splitメソッドを用いてカンマ区切りで文字列を分解＆配列にそれぞれ格納
			String[] forSplitRecode = workingRecode.split(COMMA);

			// 出勤日
			Date workingDate = Date.valueOf(forSplitRecode[0]);
			 // 出勤時間
			Time startTime   = Time.valueOf(forSplitRecode[1]);
			// 退勤時間
			Time finishTime  = Time.valueOf(forSplitRecode[2]);

			// getTimeメソッドを使って労働時間をミリ秒（0.001秒単位）で取得する
			long workingTime = finishTime.getTime() - startTime.getTime();

			// ミリ秒で取得した労働時間を○時間△分の形式に直す
	           // 時間に換算
			int workingHour = (int)( workingTime / ONE_HOUR_BY_MILLI_SEC );
			// 分に換算
			int workingMin  = (int)( ( workingTime / ONE_MIN_BY_MILLI_SEC ) % ONE_HOUR_BY_MIN );


			// ーーーーーーーーーーーーーーー下記は１日の給与計算と勤務時間の時給ーーーーーーーーーーーーーーーーーーーーー
			//給与
			int salary = 0;
			//時給
			final int HOURLYWAGE = 900;
			//分給
			final int MINUTESWAGE = HOURLYWAGE /60;
			//残業代の倍率
			final double overtimeWorkMagnification = 1.25;
			//分単位に変換
			long workingTimeMinues = workingTime / ONE_MIN_BY_MILLI_SEC;
			//休憩時間を省いた実労働時間（分単位）
			long actualWorkingMinutes = 0;

			//休憩(分で表記)
			final long REST_SHORT = 45;
			final long REST_LONG = 60;

			//労働時間が6時間未満の場合
			if(workingTimeMinues < 360) {
				actualWorkingMinutes = (int)(workingTimeMinues);
			//労働時間が6〜8時間の場合
			}else if(360 <= workingTimeMinues && workingTimeMinues <= 480){
				actualWorkingMinutes = (int)(workingTimeMinues-REST_SHORT);
			//労働時間が8時間以上の場合、または8時間丁度の場合
			}else if(workingTimeMinues > 480 || workingTimeMinues == 480){
				actualWorkingMinutes = (int)(workingTimeMinues-REST_LONG);
			}
			//時間単位に変換
			long result = actualWorkingMinutes / ONE_HOUR_BY_MIN;
			//給与
			//残業代が発生する場合
			if(actualWorkingMinutes > 480) {
				salary = (int)((HOURLYWAGE * result) + (actualWorkingMinutes-(MINUTESWAGE * overtimeWorkMagnification)));
			//残業代が発生しない場合
			}else if(actualWorkingMinutes < 480){
				salary = (int)(HOURLYWAGE * result);
			}
			//日給　+  当日日までの合計金額を加算していく。例：1/3分の日給を1/1〜1/2までの合計金額に加算。
			monthlyPay += salary;

		}

			// 出力
			System.out.println( "今月の給与は" + monthlyPay  + "です。" );
	}
}
