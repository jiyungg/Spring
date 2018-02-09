package com.iot.spring.z_task;

public class NamesFilter {
	private final String namesStr = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";
	private String[] namesArr;
	NamesFilter(){
		namesArr = namesStr.split(",");
	}
	public static void main(String[] args) {
		NamesFilter nf = new NamesFilter();
		int kimCnt = 0;
		int leeCnt = 0;
		int ljyCnt = 0;
		for(String name : nf.namesArr) {
			if(name.substring(0,1).equals("김")) {
				kimCnt++;
				continue;
			}
			if(name.substring(0,1).equals("이")) {
				if(name.equals("이재영")) {
					ljyCnt++;
				}
				leeCnt++;
				continue;
			}
		}
		System.out.println("김씨 : " + kimCnt);
		System.out.println("이씨 : " + leeCnt);
	}
}
