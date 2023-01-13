
public class Ensyu_2 {

	public static void main(String[] args) {


		final String cake_Sh = "ショートケーキ";
		final int Price_cake_Sh = 320 ;
		final String cake_mn= "モンブラン";
		final int price_cake_mn = 350;
		final String cake_cho = "チョコレートケーキ";
		final int price_cake_cho = 370 ;
		final String cake_tl = "いちごのタルト";
		final int price_cake_tl = 400 ;
		final String cake_che= "チーズケーキ";
		final int price_cake_che = 300 ;

		int cake = 0 ;					//ケーキ
		int cakeCount = 0 ;				//ケーキの個数
		int totalPrice = 0;				//ケーキの合計金額
		int payment = 0 ; 				//支払い金額
		String cakeName = "";			//ケーキの名前

		int discountApplying = 1000;    //適用される割引
		double discount = 0.2;  		//割引
		double tax = 1.08;				//消費税



		for(int i = 0; i < args.length ; i ++ ) {
			if( 1 % 2 == 0 ) {
				cakeName  = args[i];
				switch(cakeName) {
					case cake_Sh :
						cakeCount = Price_cake_Sh ;
						break;

					case cake_mn :
						cakeCount = price_cake_mn ;
						break;

					case cake_cho :
						cakeCount = price_cake_cho ;
						break;

					case cake_tl :
						cakeCount = price_cake_cho ;
						break;

					case cake_che :
						cakeCount = price_cake_cho ;
						break;
				}

			}else {

				cakeCount = Integer.parseInt( args[i] ) ;
				totalPrice += cake * cakeCount ;
			}
			if(totalPrice > discountApplying) {
				payment = (int) (totalPrice * tax * discount) ;

			}else {
				payment = (int) (totalPrice * tax);
			}




		}

		System.out.println("合計金額は" + payment + "円です。");
	}

}
