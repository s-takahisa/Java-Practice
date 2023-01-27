package churimon;

//検証用クラス
class TestMonster {
	public static void main (String[] args) {

		//Monster1の検証
		//検証対象のクラスをインスタンス化
		Monster1 t = new Monster1();
		//検証対象のメソッド実行
		t.levelUp(3);
		t.setWaza("たいあたり","1.0");
		t.getStatus();
		t.useWaza();
		t.damaged(0);
		//検証対象のメソッド実行後のフィールド確認
		System.out.println(t);

		//Monster2の検証
		//検証対象のクラスをインスタンス化
		Monster2 t2 = new Monster2();
		t2.levelUp(3);
		t2.setWaza("たいあたり","1.0");
		t2.getStatus();
		t2.useWaza();
		t2.damaged(0);
		//検証対象のメソッド実行後のフィールド確認
		System.out.println(t2);

		//Monster3の検証
		//検証対象のクラスをインスタンス化
		Monster3 t3 = new Monster3();
		t3.levelUp(11);
		t3.setWaza("たいあたり","1.0");
		t3.getStatus();
		t3.useWaza();
		t3.damaged(70);
		//検証対象のメソッド実行後のフィールド確認
		System.out.println(t3);
	}
}