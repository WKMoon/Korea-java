import java.util.Scanner;

public class BusinessClass {
    Scanner sc = new Scanner(System.in);
    Grade[] arr = new Grade[10];
    int i = 0;
    void input(){
        while(true){
            System.out.println("어느 학생의 성적을 입력하시겠습니까?");
            System.out.println("1.초등학생 2.중학생 3.고등학생");
            System.out.println("선택-->");
            int student = sc.nextInt();

            switch(student){
                case 1:
                    System.out.print("과목명: ");
                    String eSubject = sc.next();
                    System.out.print("시험: ");
                    System.out.print("중간고사: ");
                    int eMidTerm = sc.nextInt();
                    System.out.print("기말고사: ");
                    int eFinalTerm = sc.nextInt();
                    System.out.print("수행평가: ");
                    int eAssignment = sc.nextInt();

                    Grade eG = new Element(eSubject, eMidTerm, eFinalTerm, eAssignment);
                    arr[i++] = eG;
                    break;
                case 2:
                    System.out.print("과목명: ");
                    String mSubject = sc.next();
                    System.out.print("담당교사: ");
                    String mTeacher = sc.next();
                    System.out.print("시험: ");
                    System.out.print("중간고사: ");
                    int mMidTerm = sc.nextInt();
                    System.out.print("기말고사: ");
                    int mFnalTerm = sc.nextInt();
                    System.out.print("수행평가: ");
                    int mAssignment = sc.nextInt();
                    System.out.print("출석점수: ");
                    int mAttend = sc.nextInt();
                    System.out.print("봉사점수: ");
                    int mVolunteer = sc.nextInt();

                    Grade mG = new Middle(mSubject, mTeacher, mMidTerm, mFnalTerm, mAssignment,mAttend,mVolunteer);
                    arr[i++] = mG;
                    break;
                case 3:
                    System.out.print("과목명: ");
                    String hSubject = sc.next();
                    System.out.print("담당교사: ");
                    String hTeacher = sc.next();
                    System.out.print("시험: ");
                    System.out.print("중간고사: ");
                    int hMidTerm = sc.nextInt();
                    System.out.print("기말고사: ");
                    int hFnalTerm = sc.nextInt();
                    System.out.print("수행평가: ");
                    int hAssignment = sc.nextInt();
                    System.out.print("출석점수: ");
                    int hAttend = sc.nextInt();
                    System.out.print("봉사점수: ");
                    int hVolunteer = sc.nextInt();
                    System.out.print("표준편차: ");
                    double hGap = sc.nextDouble();
                    Grade hG = new High(hSubject, hTeacher, hMidTerm, hFnalTerm, hAssignment,hAttend,hVolunteer, hGap);
                    arr[i++] = hG;
                    break;
            }//end switch

            System.out.println("계속 입력하시겠습니까? (y/n)");
            String ans = sc.next();
            if(ans.equals("n")){
                break;
            }
        }//end while

    }//end buy

    void output(Grade[] arr){
        String result = "";

        for(int j = 0; j < arr.length; j++){
            if(arr[j] == null){
                break;
            }//end if
            else if(arr[j].toString().equals("초등학생")){
                System.out.println("-------------------------");
                System.out.println("초등학생 성적입니다.");
                System.out.println("-------------------------");
                System.out.println("과목명: " + arr[j].subject);
                System.out.println("시험: 중간고사:" + arr[j].midTerm + ", 기말고사: " + arr[j].finalTerm + ", 수행평가: " + arr[j].assignment);
                System.out.println("점수: " + arr[j].testCalc());
            }//end if
            else if(arr[j].toString().equals("중학생")){
                System.out.println("-------------------------");
                System.out.println("중학생 성적입니다.");
                System.out.println("-------------------------");
                System.out.println("과목명: " + arr[j].subject);
                System.out.println("담당교사: " + arr[j].teacher);
                System.out.println("시험: 중간고사:" + arr[j].midTerm + ", 기말고사: " + arr[j].finalTerm + ", 수행평가: " + arr[j].assignment + ", 출석점수: " + arr[j].attend + ", 봉사점수: " + arr[j].volunteer);
                System.out.println("점수: " + arr[j].testCalc());
            }//end if
            else if(arr[j].toString().equals("고등학생")){
                System.out.println("-------------------------");
                System.out.println("고등학생 성적입니다.");
                System.out.println("-------------------------");
                System.out.println("과목명: " + arr[j].subject);
                System.out.println("담당교사: " + arr[j].teacher);
                System.out.println("시험: 중간고사:" + arr[j].midTerm + ", 기말고사: " + arr[j].finalTerm + ", 수행평가: " + arr[j].assignment + ", 출석점수: " + arr[j].attend + ", 봉사점수: " + arr[j].volunteer);
                System.out.println("점수: " + arr[j].testCalc());
                System.out.println("표준편차: " + arr[j].gap);
            }//end if

        }//end for
    }//end output
}//end bc
