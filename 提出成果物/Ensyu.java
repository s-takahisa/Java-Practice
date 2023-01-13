public class Ensyu {
	public static void main(String[] args) {

		//使用可能なコイン
		int coinUse = args.length;
		//確認された金額
		int coinChe = 0;
		//合計金額
		int coinSum = 0;
		//文字を数値に変換する
		for( int i = 0; i < coinUse ; i++ ) {
			//確認されたコインを分岐する。
			coinChe = Integer.parseInt(args[i]);
			//正常なコインの場合
			if( coinChe == 10 || coinChe == 50 || coinChe == 100 || coinChe == 500) {
				//合計金額の上書き
				coinSum += coinChe ;

			//使用不可のコインの場合
			}else if(coinChe == 1 || coinChe == 5 ){
				System.out.println("警告:"+ coinChe  + "円玉は使えません。");
			//それ以外の不適切な数値の場合
			}else {
				System.out.println("警告:"+ coinChe+ "は硬貨として適切ではありません。");
			}
		}
				System.out.println("ただ今の合計金額は"+ coinSum  + "円です。");
	}

}

