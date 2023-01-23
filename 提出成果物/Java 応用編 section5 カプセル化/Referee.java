package Kapsel;
class Referee {

	// ・フィールド　初期化しないこと
	 //- name (String型)			プレイヤー名
		//審判のなまえ
		private String referee ;
		//名前
		private String name;
		//出す手
		private String handStatus;
		//ジャンケンの手を定義
		final String JANKEN_GHU= "グー";
		final String JANKEN_CHOKI = "チョキ";
		final String JANKEN_PA = "パー";

		//コンストラクタ
		Referee(String refName){
			this.referee = refName;
		}

		//プレイヤーの手のメソッド
		public void refPlayerHand(Player_class_2 playerHands) {

			//それぞれのプレイヤーがどんな手を出したか、それぞれ審判が確認する。
			//「グー」だった場合
			if( (playerHands.getHandStatus()).equals(JANKEN_GHU)) {
				System.out.println(referee + "「" + playerHands.getName()  + "さんの手はグーでした。」");
			//「チョキ」だった場合
			}else if((playerHands.getHandStatus()).equals(JANKEN_CHOKI)) {
				System.out.println(referee + "「" + playerHands.getName()  + "さんの手はチョキでした。」");
			//「パー」だった場合
			}else if((playerHands.getHandStatus()).equals(JANKEN_PA)) {
				System.out.println(referee + "「" + playerHands.getName()  + "さんの手はパーでした。」");
			}
		}
			// ＜シナリオ４＞
			// 勝敗の結果を画面に表示
			//  ※初めに[結果は・・・」というメッセージを画面に表示。

			//jankenResult メソッド
			//Player_class_2クラスから　仮引数を定義
			public void jankenResult(Player_class_2 player1, Player_class_2 player2) {
			System.out.println( referee + "「結果は・・・」");
			//勝敗を定義
			//あいこの場合
					if(player1.getHandStatus() == player2.getHandStatus()) {
						System.out.println(referee + "「あいこ！勝負つかず！」");
				//あいこでない場合は「(nameの値)さんの勝利！」というメッセージを画面に表示
				//player_1が勝利の場合
					}else if(player1.getHandStatus().equals(JANKEN_GHU) && player2.getHandStatus().equals(JANKEN_CHOKI)) {
						System.out.println( referee + "「" + player1.getName() + "さんの勝利」");
					}else if(player1.getHandStatus().equals(JANKEN_CHOKI) && player2.getHandStatus().equals(JANKEN_PA)) {
						System.out.println( referee + "「" +player1.getName()  + "さんの勝利」");
					}else if(player1.getHandStatus().equals(JANKEN_PA) && player2.getHandStatus().equals(JANKEN_GHU)) {
						System.out.println( referee + "「" +player1.getName()  + "さんの勝利」");

					//player_2が勝利の場合
					}else if(player2.getHandStatus().equals(JANKEN_GHU) && player1.getHandStatus().equals(JANKEN_CHOKI)) {
						System.out.println( referee + "「" +player2.getName() + "さんの勝利」");
					}else if(player2.getHandStatus().equals(JANKEN_CHOKI) && player1.getHandStatus().equals(JANKEN_PA)) {
						System.out.println( referee + "「" +player2.getName() + "さんの勝利」");
					}else if(player2.getHandStatus().equals(JANKEN_PA) && player1.getHandStatus().equals(JANKEN_GHU)) {
						System.out.println( referee + "「" +player2.getName() + "さんの勝利」");
					}
			}

			//refereeのgetter
			public String getReferee() {
				return this.referee;
			}
}
