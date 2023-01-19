package test;

public class 시혁Bot {

    String talk(String name) {
        if(name=="이수정") return name + " 사랑해";
        else return name + "은 누구세요";
    }

    public static void main(String[] args) {
        시혁Bot 시혁 = new 시혁Bot();
        String myGirfriend = "이수정";
        String myPet = "땡";
        String res1 = 시혁.talk(myGirfriend);
        String res2 = 시혁.talk(myPet);

        System.out.println(res1);
        System.out.println(res2);
    }
}
