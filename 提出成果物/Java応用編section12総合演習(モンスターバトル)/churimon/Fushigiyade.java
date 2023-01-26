package churimon;

public class Fushigiyade extends Monster3{
	//コンストラクタ１（引数なし）
	Fushigiyade(){
		//メソッド character(String) は型 Monster3 で未定義
		//Monster3にてsetterでフィールドの値が変更されているため、
		//setフィールド名を呼び出す。
		super.setCharacter("フシギヤデ");
	}
	//コンストラクタ2（[コンストラクタ2(引数2つ:トレーナー,名前)]）
	Fushigiyade(String tName, String mName){
		super.setTrainer(tName);
		super.setName(mName);
		super.setCharacter("フシギヤデ");
	}
	//コンストラクタ3（引数3つ:トレーナー,名前,初期レベル)
	Fushigiyade(String tName, String mName, int level){
		super.setTrainer(tName);
		super.setName(mName);
		super.setLv(level);
		super.setCharacter("フシギヤデ");
	}
		// [levelUpメソッド(オーバーライド)]
		//Monster3にてgetter/setterでフィールドの値が変更されているため、
		//格フィールドのsetフィールド名の中身をオーバーライドする。
		//getterにて戻り値を返しているため、getterで定義する。
		public void levelUp(int lvUp) {
			setLv(getLv() + 1 * lvUp);
			setHpMax(getHpMax() + 31 *lvUp);
			setAtk(getAtk() + 6 * lvUp);
			setDef(getDef() + 7 * lvUp);
			setSpd(getSpd() + 8 * lvUp);
			setHp(getHpMax());
		}
}