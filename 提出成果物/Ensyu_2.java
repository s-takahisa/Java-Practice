public class Ensyu_2 {

	public static void main(String[] args) {

		//定数
		final String CAKE_SH= "ショートケーキ";
		final int PRICE_CAKE_SH = 320 ;
		final String CAKE_MN= "モンブラン";
		final int PRICE_CAKE_MN = 350;
		final String CAKE_CHO = "チョコレートケーキ";
		final int PRICE_CAKE_CHO = 370 ;
		final String CAKE_TL = "いちごのタルト";
		final int PRICE_CAKE_TL = 400 ;
		final String CAKE_CHE= "チーズケーキ";
		final int PRICE_CAKE_CHE = 300 ;

		//ケーキの名前
		String cakeName = "";
		//ケーキの個数
		int cakeCount = 0 ;
		//ケーキの合計金額
		int totalPrice = 0;
		//支払い金額
		int payment = 0 ;
		//処理対象のケーキの値段
		int checkCakePrice  = 0;

		//適用される割引
		final int discountApplying = 1000;
		//割引
		final double discount = 0.8;
		//消費税
		final double tax = 1.08;


		for (int i = 0 ; i < args.length ; i++) {
			if(i % 2 == 0) {
				cakeName  = args[i];
				switch(cakeName) {
					case CAKE_SH :
						checkCakePrice = PRICE_CAKE_SH ;
						break;

					case CAKE_MN :
						checkCakePrice = PRICE_CAKE_MN ;
						break;

					case CAKE_CHO :
						checkCakePrice = PRICE_CAKE_CHO ;
						break;

					case CAKE_TL :
						checkCakePrice = PRICE_CAKE_TL ;
						break;

					case CAKE_CHE :
						checkCakePrice = PRICE_CAKE_CHE ;
						break;
				}

			}else{
				  cakeCount = Integer.parseInt(args[i]);
				  totalPrice += checkCakePrice * cakeCount ;

				  if(totalPrice > discountApplying) {
					payment = (int) (totalPrice * tax * discount) ;
			 	  }else{
					payment = (int) (totalPrice * tax);
				  }
				  System.out.println("合計金額は" + payment + "円です。");
			}
		}
	}
}

