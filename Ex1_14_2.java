/*-< 演習：Ex1_14_2 >---------------------------------
コマンドライン引数から1つ以上の数値を受け取り、この1つ1つの数値を購入した商品の定価としたとき、
合計金額を求め、その金額に応じた値引きを利かせ、最後に消費税（8％とする）をのせた金額を表示するプログラムを作りたい。
mainメソッドの内容は書き換えずに処理が通るようなメソッドを仕様に従って書いてください。
----------------------------------------------------*/
public class Ex1_14_2 {

	//！！！mainメソッドの処理は書き換えないでください！！！
	public static void main (String[] args) {

		int totalPrice = 0 ;                                 //購入した商品の合計金額

		//コマンドライン引数から購入した商品の合計金額（定価）を取得
		for(int i = 0 ; i < args.length ; i++ ){
			totalPrice += Integer.parseInt( args[i] );
		}

		//discountメソッドを使って値引きを適用し、値引き後の金額を取得
		int discountedPrice = discount( totalPrice );        //値引き後の金額

		//calcTaxPaymentメソッドを使って支払金額（税込）を取得
		int taxPayment = calcTaxPayment( discountedPrice );  //支払金額（税込）

		//支払金額（税込）を表示
		System.out.println("値引き後の支払金額：" + taxPayment + "円" );

	}


	/*
	**以下の仕様を持つメソッドcalcTaxPaymentを作成してください。
	**  - 引数として受け取った値の税込価格（消費税は8％とする）を計算して返す
	**  - 税込価格は整数（小数点以下切り捨て）で返す
	*/
	static int calcTaxPayment( int result ){        //アンダーバーを適切な内容に書き換えてください
		//消費税
		final double TAX = 1.08;
		int taxIncludedPrice = (int)(result*TAX);
		return taxIncludedPrice ;




	}


	/*
	**以下の仕様を持つメソッドdiscountを作成してください。
	**  - 引数として受け取った値が1000円以上5000円以下の場合、1000円より大きい分について10％割引にする
	**  - 引数として受け取った値が5000円より大きい場合、1000円より大きく5000円以下の分について10％割引、5000円より大きい分について20％割引にする
	**  - 値引き額は小数点以下切り捨てで計算する（キャストを使いましょう）
	**  - 割引金額の上限は5000円とする
	*/
	static int discount( int result ){            //アンダーバーを適切な内容に書き換えてください
		//引数が1000円以上の場合5000円以下の場合
		final int DISCOUNT_RANGE1 = 1000;
		//引数として受け取った値が5000円以以上の場合
		final int DISCOUNT_RANGE2 = 5000;
		//割引が10%以下
		final double DISOUNT__VALUE1 = 0.1;
		//割引が20%以下
		final double DISCOUNT_VALUE2 = 0.2;
		//上限5000円の場合
		final int DICOUNT_MAX= 5000;


		//resultが1000円以上5000円以下の場合
		if(DISCOUNT_RANGE1 <= result && result <= DISCOUNT_RANGE2) {
			result = (int)((result - DISCOUNT_RANGE1)*DISOUNT__VALUE1);
		//resultが5000円を超えた場合
		}else if(result > DICOUNT_MAX){
			result = (int)((result - DISCOUNT_RANGE2)*DISCOUNT_VALUE2);
		}else {

		}
		return result;


	}
}
