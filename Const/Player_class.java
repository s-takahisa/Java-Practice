package Const;
class Player_class {

	/* ・フィールド　初期化しないこと
	 - name (String型)			プレイヤー名
	 - handStatus(String型)		ジャンケンの手 */
		//名前
		String name;
		//出す手
		String handStatus ;


		//ジャンケンの手を定義
		final String JANKEN_GHU= "グー";
		final String JANKEN_CHOKI = "チョキ";
		final String JANKEN_PA = "パー";



	 	//コンストラクタ
	 	//＜引数＞
	 	//String型の文字列を一つ受け取る。
	 	//＜処理＞
	 	//引数で受け取った文字列をnameに設定。

		Player_class(String temporaryName){
			this.name = temporaryName;
		}




	 	//- makeHandStatusメソッド
	 	//	makeHandStatus
	 	//	＜引数/戻り値＞なし
		void MakeHandStatus(){
			//ジャンケンの手を受け取った時ランダムに設定する。
			int jankenRandam = (int)(Math.random() * 3);
		 	//	＜処理＞
		 	//	handStatusに「ぐー」「チョキ」「パー」のいずれかをランダムに設定
			switch(jankenRandam) {
			case JANKEN_GHU:
				System.out.println();
				break;


			}

		}



}



