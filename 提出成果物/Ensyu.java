
public class Ensyu {

	public static void main(String[] args) {

		int coinA = 0;		//使用可能なコイン
		int coinB = 0;		//使用不可のコイン
		int coinOut = 0;	//不適切な数値
		int coinSum = 0;    //合計金額



		for( int i = 0; i < coinA ; i ++ ) {
			coinA = Integer.parseInt(args[i]);
			if( coinA == 10 || coinA == 50 || coinA == 100 || coinA == 500) {
				coinSum += coinA ;

			}else if(coinB == 1 || coinB == 5 ){		//使用不可の場合
				System.out.println("警告:"+ coinB  + "円玉は使えません。");

			}else { //それ以外として考えると
				System.out.println("警告:"+ coinOut + "は硬貨として適切ではありません。");

		}
		System.out.println("ただ今の合計金額は"+ coinSum  + "円です。");


	}
}

}

