/*-< 演習：Ex1_10_4 >---------------------------------
コメントに従って2次元配列からデータを抽出して画面に表示する
プログラムを作ってください。
----------------------------------------------------*/
class Ex1_10_4 {
	public static void main (String[] args) {

		//出力元の2次元配列
		String[][] animals = {
		                       {"モコ" ,"トイプードル" ,"4歳" ,"メス"},
		                       {"ポチ" ,"シバイヌ　　" ,"6歳" ,"オス"},
		                       {"ムギ" ,"パピヨン　　" ,"2歳" ,"オス"},
		                       {"ブブ" ,"ブルドッグ　" ,"3歳" ,"メス"},
		                       {"シロ" ,"秋田犬　　　" ,"8歳" ,"オス"}
		                     };


		/*
		**以下の条件を満たす2次元配列のデータ抽出&表示する処理を書いてください。
		**  - for文を2つ組み合わせる
		**  - 「animals.length」「 animals[i].length」
		**  - 出力結果は以下になる
		**       モコ / トイプードル / 4歳 / メス
		**       ポチ / シバイヌ　　 / 6歳 / オス
		**       ムギ / パピヨン　　 / 2歳 / オス
		**       ブブ / ブルドッグ　 / 3歳 / メス
		**       シロ / 秋田犬　　　 / 8歳 / オス
		*/

		String display ="";      //1行分の出力文字

		//--------------------------------
		//1行ずつ文字列を生成して出力する
		//--------------------------------
		for( int i = 0 ; i < animals.length ; i++ ){

			//1行分の出力文字を名前（animals[i][0]）で初期化
			//（同時に前ループに格納した値をクリア）
			display = animals[i][0] ;

			//1行分の出力文字を生成
			//（animals配列の2次元目、インデックス1以降のデータをスラッシュ付きで結合していく）
			for( int j = 1 ; j < animals[i].length ; j++){

				display += " / " + animals[i][j] ;

			}

			//生成した1行分の出力文字を出力
			System.out.println( display );

		}
	}
}
