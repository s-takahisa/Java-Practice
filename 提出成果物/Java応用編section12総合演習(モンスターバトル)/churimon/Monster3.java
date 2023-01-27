package churimon;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster3 {
	//モンスター１の情報
	//---------------フィールドは初期値なし---------------
	//種族
	private String character;
	//トレーナー
	private String trainer;
	//名前
	private String name;
	//レベル
	private int lv;
	//HP
	private int hp;
	//攻撃
	private int atk;
	//防御
	private int def;
	//素早さ
	private int spd;
	//HP初期値
	private int hpMax;
	//わざ（名前）
	private String wazaName;
	//わざ（ダメージ倍率）
	private String wazaDamage;

	//---------------コンストラクタ---------------
	//----コンストラクタ1(引数なし)---------------
	Monster3() {
		//種族
		this.character = "(unknown)";
		//トレーナー
		this.trainer = "(wild)";
		//名前
		this.name = "(noname)";
		//レベル
		this.lv = 1;
		//HP
		this.hp = 80;
		//攻撃
		this.atk = 15;
		//防御
		this.def = 10;
		//素早さ
		this.spd = 10;
		//HP初期値
		this.hpMax = 80;
		//わざ（名前）
		this.wazaName = "たいあたり";
		//わざ（ダメージ倍率）
		this.wazaDamage = "1.0";
	}

	//----コンストラクタ2（引数1:トレーナー(String型),引数2:なまえ(String型)）---------------
	Monster3(String tName, String mName) {
		//名前とトレーナーのみ変更でそのほかは初期値で定義
		this();
		this.trainer = tName;
		this.name = mName;
	}

	//----コンストラクタ3（引数1:トレーナー(String型),引数2:なまえ(String型) , 引数3:初期レベル(int型)--------
	Monster3(String tName, String mName, int level) {
		this(tName, mName);
		this.lv = level;
		//レベルが1以上の時、レベルに見合った分のステータスの上昇する。
		if (level > 1) {
			levelUp(level + 1);
		//レベルが1の時、ステータスに変化がない。
		} else if (level == 1) {
		}
	}

	//---------------toStringメソッドでのオーバーライド---------------
	public String toString() {
		//情報をString型の変数をstatusとする。
		String status = "[" + name + " lv" + lv + " HP" + hp + "/" + hpMax + " ] (status)character:" + character
				+ " trainer:" + trainer + " atk:" + atk + " def:" + def + " spd:" + spd + " wazaName:" + wazaName
				+ " wazaDamage:" + wazaDamage;
		return status;
	}

	//---------------levelUpメソッド---------------
	//引数を「レベル」int型の仮引数をlvUp
	public void levelUp(int lvUp) {
		lv = lv + 1 * lvUp;
		hpMax = hpMax + 30 * lvUp;
		atk = atk + 5 * lvUp;
		def = def + 5 * lvUp;
		spd = spd + 5 * lvUp;
		hp = hpMax;
	}

	//---------------setWazaメソッド---------------
	//引数1を「わざ名」仮引数1をwnm、引数2を「わざのダメージ倍率」仮引数2をdmg
	public void setWaza(String techniqueName, String techniqueDamageRate) {
		//バリデーションチェック
		//引数２のバリデーションチェックで引数2が「X、、、X.X(Xは0〜9の数字のいずれか)」型式か
		//正規表現を定義ß
		final String VALIDATE = "^[0-9]+\\.[0-9]$";
		//matchesメソッド（Stringクラス）を使用し、正規表現を用いたチェックを行う。
		if (techniqueDamageRate.matches(VALIDATE)) {
			wazaName = techniqueName;
			wazaDamage = techniqueDamageRate;
		} else {
			System.out.println("「[ERROR]わざの設定に失敗しました");
		}
	}

	//---------------getStatusメソッド---------------
	public String getStatus() {
		//引数なしで戻り値は相手にね渡しするダメージ
		//ステータス情報(一部フィールドの情報)を文字列で返します。
		//[ (nameの値) lv(lvの値) HP(hpの値)/(hpMaxの値) ]
		//【例】[ ピカ丸 lv20 HP500/688 ]
		String status = "[" + name + " lv" + lv + " HP" + hp + "/" + hpMax + "]";
		return status;
	}

	//---------------useWazaメソッド---------------
	public int useWaza() {
		//※BigDecimal型からint型へ変換(同時に小数点以下を切り捨て)する際はintValueメソッドを使用。
		//相手に値渡しするダメージ:こうげき×わざのダメージ倍率 ※BigDecimalを使用。
		//攻撃を変数atkDamageのインスタンス化する。
		BigDecimal atkDamage = new BigDecimal(atk);
		//わざを変数wazaDmgのインスタンス化する。
		BigDecimal techniqueDamage = new BigDecimal(wazaDamage);
		//攻撃×わざのダメージを定義する。そしてintValueメソッドで小数点以下を切り捨て。
		//値渡しされたダメージ値×ダメージ減算率、int型への変換はintValueメソッドで
		int damage = (atkDamage.multiply(techniqueDamage)).intValue();
		return damage;
	}

	//---------------damagedメソッド---------------
	//int型の仮引数をdmgdとする。
	public int damaged(int damage) {
		//ダメージ減算率
		//ダメージをBigDecimalにて定義
		BigDecimal damageSubtract = new BigDecimal(damage);
		//ダメージ減さん率120を定義
		BigDecimal damageSubtractRate120 = new BigDecimal("120");
		//防御をBigDecimalで定義
		BigDecimal defense = new BigDecimal(def);
		//ダメージ減算率:1 / (1+ぼうぎょ÷120) ※小数第3位切り捨て
		BigDecimal damageSubtractRate1 = new BigDecimal("1");
		BigDecimal damageSubtractRate = damageSubtractRate1.divide(
				damageSubtractRate1.add(defense.divide(damageSubtractRate120, RoundingMode.DOWN)), 2,
				RoundingMode.DOWN);
		//変数damageSubtractRateに実際にうけたダメージを計算する。
		//値渡しされたダメージ値×ダメージ減算率の変数をdamage
		int resultDamage = (damageSubtractRate.multiply(damageSubtract)).intValue();
		//HP>ダメージであればダメージを差し引いた値 をHPに代入
		if (hp > resultDamage) {
			hp = hp - resultDamage;
			//HP<ダメージであればHPに0を代入します。
		} else if (hp < resultDamage) {
			hp = 0;
		}
		//実際に受けるダメージ(int型)
		return resultDamage;
	}

	//-----------getter/setter--------------
	//格フィールドごとにgetter/setterを作成していく。
	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpd() {
		return spd;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getAtk() {
		return atk;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public String getWazaName() {
		return wazaName;
	}

	public void setWazaName(String wazaName) {
		this.wazaName = wazaName;
	}

	public String getWazaDamage() {
		return wazaDamage;
	}

	public void setWazaDamage(String wazaDamage) {
		this.wazaDamage = wazaDamage;
	}

}
