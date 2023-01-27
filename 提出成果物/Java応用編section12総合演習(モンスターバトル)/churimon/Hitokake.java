package churimon;

public class Hitokake extends Monster3 {
	//コンストラクタ１（引数なし）
	Hitokake() {
		//メソッド character(String) は型 Monster3 で未定義
		//Monster3にてsetterでフィールドの値が変更されているため、
		//setフィールド名を呼び出す。
		super.setCharacter("ヒトカケ");
	}

	//コンストラクタ2（[コンストラクタ2(引数2つ:トレーナー,名前)]）
	Hitokake(String tName, String mName) {
		super.setTrainer(tName);
		super.setName(mName);
		super.setCharacter("ヒトカケ");
	}

	//コンストラクタ3（引数3つ:トレーナー,名前,初期レベル)
	Hitokake(String tName, String mName, int level) {
		super.setTrainer(tName);
		super.setName(mName);
		super.setLv(level);
		super.setCharacter("ヒトカケ");
	}

	// [levelUpメソッド(オーバーライド)]
	//Monster3にてgetter/setterでフィールドの値が変更されているため、
	//格フィールドのsetフィールド名の中身をオーバーライドする。
	//getterにて戻り値を返しているため、getterで定義する。
	public void levelUp(int lvUp) {
		setLv(getLv() + 1 * lvUp);
		setHpMax(getHpMax() + 29 * lvUp);
		setAtk(getAtk() + 8 * lvUp);
		setDef(getDef() + 5 * lvUp);
		setSpd(getSpd() + 9 * lvUp);
		setHp(getHpMax());
	}
}
