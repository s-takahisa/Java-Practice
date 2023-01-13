public class Ensyu {
	public static void main(String[] args) {

		int coinA = args.length;
		//使用可能なコイン
		int coinChe = 0;
		//確認された金額
		int coinSum = 0;
		//合計金額
		for( int i = 0; i < coinA ; i++ ) {
		//文字を数値に変換する
			coinChe = Integer.parseInt(args[i]);
			//確認されたコインを分岐する。

			//正常なコインの場合
			if( coinChe == 10 || coinChe == 50 || coinChe == 100 || coinChe == 500) {
				//合計金額の上書き
					coinSum += coinChe ;
								//↑今あるコインの合計
				}else if(coinChe == 1 || coinChe == 5 ){
				//使用不可のコインの場合
					System.out.println("警告:"+ coinChe  + "円玉は使えません。");
				}else {
				//それ以外の不適切な数値の場合
					System.out.println("警告:"+ coinChe+ "は硬貨として適切ではありません。");
			}
		}
		System.out.println("ただ今の合計金額は"+ coinSum  + "円です。");
	}

}

