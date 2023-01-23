package 中級編;

public class No_46_admission {

	public static void main(String[] args) {
		//美術館の入場料
		int galleryAdmission = 0;
		//一人分の入場料
		final int ADMISSION_PATERN_A = 600;
		//5人以上20人未満のグループなら一人550円
		final int ADMISSION_PATERN_B = 550;
		//20人以上の団体なら一人500円
		final int ADMISSION_PATERN_C = 500;

		//人数
		int people = 0;
		//最終的な合計金額
		int sum = 0;

		//5人未満のグループなら一人600円
		if(people < 5) {
			galleryAdmission = ADMISSION_PATERN_A * people;

		//5人以上20人未満のグループなら一人550円
		}else if(5 <= people && people <= 20 ) {
			galleryAdmission = ADMISSION_PATERN_B * people;

		//20人以上の団体なら一人500円
		}else if(20 <= people) {
			galleryAdmission = ADMISSION_PATERN_C * people;
		}
		System.out.println(people + "名で" +  "入場料は" + sum + "円になります。");
	}

}
