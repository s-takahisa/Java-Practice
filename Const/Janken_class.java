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

		//ジャンケンの手を定義
		final String JANKEN_GHU= "グー";
		final String JANKEN_CHOKI = "チョキ";
		final String JANKEN_PA = "パー";
		//プレイヤー2名をコマンドラインから引数を受け取る。
		//プレイヤー１
		String playerName_1 = args[0];
		//プレイヤー２
		String playerName_2 = args[1];
		//二人をインスタンス化させる
		Player_class jankenPlayer = new Player_class();








		System.out.println("じゃんけん・・・ぽん！！！！！");
		System.out.println("さんの手");






	}

}
