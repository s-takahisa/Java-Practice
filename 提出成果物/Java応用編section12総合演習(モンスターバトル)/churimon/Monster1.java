package churimon;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster1 {
		//モンスター１の情報
		//---------------フィールド---------------
		//種族
		String character = "(unknown)" ;
		//トレーナー
		String trainer= "(wild)" ;
		//名前
		String name= "(noname)" ;
		//レベル
		int lv = 1;
		//HP
		int hp = 80;
		//攻撃
		int atk = 15;
		//防御
		int def = 10;
		//素早さ
		int spd = 10;
		//HP初期値
		int hpMax = 80;
		//わざ（名前）
		String wazaName = "たいあたり";
		//わざ（ダメージ倍率）
		String wazaDamage = "1.0";

		//---------------toStringメソッドでのオーバーライド---------------
		public String toString(){
		//情報をString型の変数をstatusとする。
			String status =  "[" + name + " lv" + lv + " HP" + hp + "/" + hpMax + " ] (status)character:" + character
					 		+ " trainer:" + trainer + " atk:" + atk + " def:" + def + " spd:" + spd + " wazaName:"+ wazaName
					 		+ " wazaDamage:" + wazaDamage;
			return status;
		}
		//---------------levelUpメソッド---------------
		//引数を「レベル」int型の仮引数をlvUp
		void  levelUp(int lvUp) {
			lv = lv + 1 * lvUp;
			hpMax = hpMax + 30 *lvUp;
			atk  =  atk + 5 * lvUp;
			def  =	def + 5 * lvUp;
			spd = spd + 5 * lvUp;
			hp = hpMax;
		}
		//---------------setWazaメソッド---------------
		//引数1を「わざ名」仮引数1をwazaN、引数2を「わざのダメージ倍率」仮引数2をdmg
		void setWaza(String techniqueName , String techniqueDamageRate) {
		//バリデーションチェック
		//引数２のバリデーションチェックで引数2が「X、、、X.X(Xは0〜9の数字のいずれか)」型式か
		//正規表現を定義
			final String VALIDATE =  "^[0-9]+\\.[0-9]$";
		//matchesメソッド（Stringクラス）を使用し、正規表現を用いたチェックを行う。
			if(techniqueDamageRate.matches(VALIDATE)) {
				wazaName = techniqueName;
				wazaDamage = techniqueDamageRate;
			}else {
				System.out.println("「[ERROR]わざの設定に失敗しました");
			}
		}
		//---------------getStatusメソッド---------------
		String getStatus() {
		//引数なしで戻り値は相手にね渡しするダメージ
		//ステータス情報(一部フィールドの情報)を文字列で返します。
		//[ (nameの値) lv(lvの値) HP(hpの値)/(hpMaxの値) ]
		//【例】[ ピカ丸 lv20 HP500/688 ]
			String status = "[" + name + " lv" + lv + " HP" + hp + "/" + hpMax + "]";
			return status;
		}
		//---------------useWazaメソッド---------------
		int useWaza() {
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
		int damaged(int damage) {
		//ダメージ減算率
		//ダメージをBigDecimalにて定義
			BigDecimal damageSubtract = new BigDecimal(damage);
		//ダメージ減さん率120を定義
			BigDecimal damageSubtractRate120 = new BigDecimal("120");
		//防御をBigDecimalで定義
			BigDecimal defense = new BigDecimal(def);
		//ダメージ減算率:1 / (1+ぼうぎょ÷120) ※小数第3位切り捨て
			BigDecimal damageSubtractRate1 = new BigDecimal("1");
			BigDecimal damageSubtractRate = damageSubtractRate1.divide(damageSubtractRate1.add(defense.divide(damageSubtractRate120, RoundingMode.DOWN ) ), 2, RoundingMode.DOWN ) ;
		//変数damageSubtractRateに実際にうけたダメージを計算する。
		//値渡しされたダメージ値×ダメージ減算率の変数をdamage
			int resultDamage = ( damageSubtractRate.multiply( damageSubtract ) ).intValue();
		//HP>ダメージであればダメージを差し引いた値 をHPに代入
				if(hp > resultDamage) {
					hp = hp - resultDamage;
		//HP<ダメージであればHPに0を代入します。
				}else if(hp < resultDamage){
					hp = 0;
				}
		//実際に受けるダメージ(int型)
				return resultDamage;
		}
}







