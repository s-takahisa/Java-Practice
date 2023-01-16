public class Ensyu {
	public static void main(String[] args) {

		//使用可能なコイン
		int coinUse = args.length;
		//確認された金額
		int coinCheck = 0;
		//合計金額
		int coinSum = 0;
		//文字を数値に変換する
		for(int i = 0; i < coinUse ; i++) {
			//確認されたコインを分岐する。
			coinCheck = Integer.parseInt(args[i]);
			//正常なコインの場合
			if(coinCheck == 10 || coinCheck == 50 || coinCheck == 100 || coinCheck == 500) {
				//合計金額の上書き
				coinSum += coinCheck;

			//使用不可のコインの場合
			}else if(coinCheck == 1 || coinCheck == 5){
				System.out.println("警告:"+ coinCheck  + "円玉は使えません。");
			//それ以外の不適切な数値の場合
			}else{
				System.out.println("警告:"+ coinCheck+ "は硬貨として適切ではありません。");
			}
		}
				System.out.println("ただ今の合計金額は"+ coinSum + "円です。");
	}

}

