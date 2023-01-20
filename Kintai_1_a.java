import java.sql.Time;

public class Kintai_1_a {

	public static void main(String[] args) {

		// 計算用の数値を定数で用意
		final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60; // 1時間のミリ秒換算
		final long ONE_MIN_BY_MILLI_SEC  = 1000 * 60;      // 1分のミリ秒換算
		final int  ONE_HOUR_BY_MIN       = 60;             // 1時間の分換算

		// バイトの開始時間と終了時間をコマンドライン引数から受け取る
		Time startTime  = Time.valueOf(args[0]);
		Time finishTime = Time.valueOf(args[1]);

		// getTimeメソッドを使って労働時間をミリ秒（0.001秒単位）で取得する
		// ※getTime()メソッドの戻り値はlong型であることに注意
		long workingTime = finishTime.getTime() - startTime.getTime();


		// ミリ秒で取得した労働時間を○時間△分の形式に直す
		int workingHour = (int)( workingTime / ONE_HOUR_BY_MILLI_SEC );                      // 時間に換算
		int workingMin  = (int)( ( workingTime / ONE_MIN_BY_MILLI_SEC ) % ONE_HOUR_BY_MIN ); // 分に換算



		//給与
		int salary = 0;
		//時給
		//final int hourlyWage = 900;
		final int HOURLYWAGE = 900;
		//分給
		//int minutesWage = HOURLYWAGE/60;
		final int MINUTESWAGE = HOURLYWAGE /60;
		//残業代の倍率
		final double overtimeWorkMagnification = 1.25;

		//分単位に変換
		long workingTimeMinues = workingTime / ONE_MIN_BY_MILLI_SEC;
		//休憩時間を省いた実労働時間（分単位）
		//long actualWorkingHours = 0;
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

		// 出力
		System.out.println("本日の労働時間は" + result + "時間" + workingMin + "分です。");

		//給与
		//残業代が発生する場合
		if(actualWorkingMinutes > 480) {
			salary = (int)((HOURLYWAGE * result) + (actualWorkingMinutes-(MINUTESWAGE * overtimeWorkMagnification)));
		//残業代が発生しない場合
		}else if(actualWorkingMinutes < 480){
			salary = (int)(HOURLYWAGE * result);

		}
		System.out.println("給与は" + salary + "円です");
	}
}


