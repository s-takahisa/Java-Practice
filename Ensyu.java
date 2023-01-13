
public class Ensyu {

	public static void main(String[] args) {

		int coinA = args.length;		//使用可能なコイン
		/*　args.lengthは値として入れるのでしょうか？*/
		int coinChe = 0;	//確認された金額
		int coinSum = 0;    //合計金額



		for( int i = 0; i < coinA ; i ++ ) {
			//文字を数値に変換する
			coinChe = Integer.parseInt(args[i]);
			//確認されたコインを分岐する。
					//正常なコインの場合
			if( coinA == 10 || coinA == 50 || coinA == 100 || coinA == 500) {
				//合計金額の上書き
				coinSum = coinSum + coinChe ;
							//↑今あるコインの合計

			}else if(coinA == 1 || coinA == 5 ){//使用不可のコインの場合
				System.out.println("警告:"+ coinChe  + "円玉は使えません。");

			}else { //それ以外の不適切な数値の場合
				System.out.println("警告:"+ coinChe+ "は硬貨として適切ではありません。");

			}
		System.out.println("ただ今の合計金額は"+ coinSum  + "円です。");


	}
}

}

