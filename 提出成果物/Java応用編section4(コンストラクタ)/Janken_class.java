package Const;

public class Janken_class {

	public static void main(String[] args) {
		/*　mainメソッド
		　<シナリオ１>
		コマンドライン引数により二つの文字列を受け取る。
		（じゃんけんを行う2名のプレイヤーの名前として利用）
		   <シナリオ２>
		   2名のプレイヤーを場に登場させる。（インスタンス化させる）
		   インスタンス化の際はコマンドライン引数で受け取った文字列をそれぞれコンストラクタに渡す。
		   <シナリオ３＞
		   それぞれのプレイヤーに手を握らせる。
		   ※握らせる前に「じゃんけん・・・ぽん！！！！！１」というメッセージを画面に表示。
		   ※それぞれのプレイヤーがどんな手を出したか、それぞれ
		   「(nameの値)さんのて：（handStatusの値）」の型たいで画面に表示
		   ＜シナリオ４＞
		   勝敗の結果を画面に表示
		   ※　初めに[結果は・・・」というメッセージを画面に表示。
		   ※　あいこだった場合は「あいこ！勝負つかず！」というメッセージを画面に表示
		   ※　あいこでない場合は「(nameの値)さんの勝利！」というメッセージを画面に表示
		   */

		//<シナリオ１>
		//ジャンケンの手を定義
		final String JANKEN_GHU= "グー";
		final String JANKEN_CHOKI = "チョキ";
		final String JANKEN_PA = "パー";
		//プレイヤー2名をコマンドラインから引数を受け取る。
		//プレイヤー１
		String playerName_1 = args[0];
		//プレイヤー２
		String playerName_2 = args[1];
		//<シナリオ２>
		//二人をインスタンス化させる
		//プレイヤー１
		Player_class jankenPlayer_1 = new Player_class(playerName_1);
		//プレイヤー2
		Player_class jankenPlayer_2 = new Player_class(playerName_2);
		//コンストラクタに文字列の値を渡す。

		//<シナリオ３＞
		// それぞれのプレイヤーに手を握らせる。
		//Player_classの情報をそれぞれのPlayerに結びつける。
		jankenPlayer_1.makeHandStatus();
		jankenPlayer_2.makeHandStatus();

		// ※握らせる前に「じゃんけん・・・ぽん！！！！！１」というメッセージを画面に表示。
		System.out.println("じゃんけん・・・ぽん！！！！！");

		//※それぞれのプレイヤーがどんな手を出したか、それぞれ
		// (nameの値)さんのて：（handStatusの値）」の型たいで画面に表示
		System.out.println( playerName_1 + "さんの手:" + jankenPlayer_1.handStatus);
		System.out.println( playerName_2 + "さんの手:" + jankenPlayer_2.handStatus);

		// ＜シナリオ４＞
		// 勝敗の結果を画面に表示
		//  ※初めに[結果は・・・」というメッセージを画面に表示。
		System.out.println("結果は・・・");
		//勝敗を定義
		//あいこの場合
			if(jankenPlayer_1.handStatus == jankenPlayer_2.handStatus) {
				System.out.println("あいこ！勝負つかず！");

		//あいこでない場合は「(nameの値)さんの勝利！」というメッセージを画面に表示
		//player_1が勝利の場合
			}else if(jankenPlayer_1.handStatus.equals(JANKEN_GHU) && jankenPlayer_2.handStatus.equals(JANKEN_CHOKI)) {
				System.out.println( playerName_1 + "さんの勝利");
			}else if(jankenPlayer_1.handStatus.equals(JANKEN_CHOKI) && jankenPlayer_2.handStatus.equals(JANKEN_PA)) {
				System.out.println( playerName_1 + "さんの勝利");
			}else if(jankenPlayer_1.handStatus.equals(JANKEN_PA) && jankenPlayer_2.handStatus.equals(JANKEN_GHU)) {
				System.out.println( playerName_1 + "さんの勝利");

			//player_2が勝利の場合
			}else if(jankenPlayer_2.handStatus.equals(JANKEN_GHU) && jankenPlayer_1.handStatus.equals(JANKEN_CHOKI)) {
				System.out.println( playerName_2 + "さんの勝利");
			}else if(jankenPlayer_2.handStatus.equals(JANKEN_CHOKI) && jankenPlayer_1.handStatus.equals(JANKEN_PA)) {
				System.out.println( playerName_2 + "さんの勝利");
			}else if(jankenPlayer_2.handStatus.equals(JANKEN_PA) && jankenPlayer_1.handStatus.equals(JANKEN_GHU)) {
				System.out.println( playerName_2 + "さんの勝利");
		}
	}
}
