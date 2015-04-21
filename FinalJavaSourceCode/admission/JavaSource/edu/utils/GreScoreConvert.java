package edu.utils;

public class GreScoreConvert {

	/**
	 * return the verbal score of an old version transformed into that of new version
	 * @param verbet score of old version  
	 * @return int
	 */

	public static int verbConv(int verbt) {
		int verb = 130;
		switch (verbt) {
		case 800:
		case 790:
		case 780:
		case 770:
		case 760:
			verb = 170;
			break;
		case 750:
		case 740:
			verb = 169;
			break;

		case 730:
		case 720:
			verb = 168;
			break;
		case 710:
			verb = 167;
			break;
		case 700:
			verb = 166;
			break;
		case 690:
		case 680:
			verb = 165;
			break;
		case 670:
		case 660:
			verb = 164;
			break;
		case 650:
			verb = 163;
			break;
		case 640:
		case 630:
			verb = 162;
			break;
		case 620:
			verb = 161;
			break;
		case 610:
		case 600:
			verb = 160;
			break;
		case 590:
			verb = 159;
			break;
		case 580:
		case 570:
			verb = 158;
			break;
		case 560:
			verb = 157;
			break;
		case 550:
		case 540:
			verb = 156;
			break;
		case 530:
			verb = 155;
			break;
		case 520:
		case 510:
			verb = 154;
			break;
		case 500:
			verb = 153;
			break;
		case 490:
		case 480:
			verb = 152;
			break;
		case 470:
		case 460:
			verb = 151;
			break;
		case 450:
			verb = 150;
			break;
		case 440:
		case 430:
			verb = 149;
			break;
		case 420:
			verb = 148;
			break;
		case 410:
			verb = 147;
			break;
		case 400:
		case 390:
			verb = 146;
			break;
		case 380:
			verb = 145;
			break;
		case 370:
			verb = 144;
			break;
		case 360:
		case 350:
			verb = 143;
			break;
		case 340:
			verb = 142;
			break;
		case 330:
			verb = 141;
			break;
		case 320:
			verb = 140;
			break;
		case 310:
			verb = 139;
			break;
		case 300:
			verb = 138;
			break;
		case 290:
			verb = 137;
			break;
		case 280:
			verb = 135;
			break;
		case 270:
			verb = 134;
			break;
		case 260:
			verb = 133;
			break;
		case 250:
			verb = 132;
			break;
		case 240:
			verb = 131;
			break;
		case 230:
		case 220:
		case 210:
		case 200:
			verb = 130;
			break;
		default:
			verb = 130;
			break;
		}
		return verb;
	}

	/**
	 * return the quantity score of an old version transformed into that of new version
	 * @param quant score of old version  
	 * @return int
	 */
	public static int quanConv(int quant) {
		int quan = 130;
		switch (quant) {
		case 800:
			quan = 166;
			break;
		case 790:
			quan = 164;
			break;
		case 780:
			quan = 163;
			break;
		case 770:
			quan = 161;
			break;
		case 760:
			quan = 160;
			break;
		case 750:
			quan = 159;
			break;
		case 740:
			quan = 158;
			break;
		case 730:
			quan = 157;
			break;
		case 720:
			quan = 156;
			break;
		case 710:
		case 700:
			quan = 155;
			break;
		case 690:
			quan = 154;
			break;
		case 680:
			quan = 153;
			break;
		case 670:
		case 660:
			quan = 152;
			break;
		case 650:
		case 640:
			quan = 151;
			break;
		case 630:
			quan = 150;
			break;
		case 620:
		case 610:
			quan = 149;
			break;
		case 600:
		case 590:
			quan = 148;
			break;
		case 580:
		case 570:
			quan = 147;
			break;
		case 560:
		case 550:
			quan = 146;
			break;
		case 540:
		case 530:
			quan = 145;
			break;
		case 520:
		case 510:
		case 500:
			quan = 144;
			break;
		case 490:
		case 480:
			quan = 143;
			break;
		case 470:
		case 460:
			quan = 142;
			break;
		case 450:
		case 440:
		case 430:
			quan = 141;
			break;
		case 420:
		case 410:
		case 400:
			quan = 140;
			break;
		case 390:
		case 380:
			quan = 139;
			break;
		case 370:
		case 360:
		case 350:
			quan = 138;
			break;
		case 340:
		case 330:
			quan = 137;
			break;
		case 320:
		case 310:
		case 300:
			quan = 136;
			break;
		case 290:
		case 280:
			quan = 135;
			break;
		case 270:
		case 260:
			quan = 134;
			break;
		case 250:
		case 240:
			quan = 133;
			break;
		case 230:
		case 220:
			quan = 132;
			break;
		case 210:
		case 200:
			quan = 131;
			break;
		default:
			quan = 131;
			break;
		}
		return quan;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreScoreConvert a = new GreScoreConvert();
		a.verbConv(800);
		System.out.println(a.verbConv(800));
	}
}
