
package org.tukorea.di.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MemberSampleMain {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ctx = new GenericXmlApplicationContext("applicationContext.xml");

		MemberService memberService = ctx.getBean(MemberService.class);  // by Class name

		while (true) {
			System.out.println("--------------------------------");
			System.out.println("		학생 정보 관리 프로그램		");
			System.out.println("--------------------------------");
			System.out.println("1. 전체 학생 정보 출력");
			System.out.println("2. 개인 학생 정보 출력");
			System.out.println("3. 개인 학생 정보 생성");
			System.out.println("4. 개인 학생 정보 삭제");
			System.out.println("5. 개인 학생 정보 수정");
			System.out.println("9. 프로그램 종료");

			int sel;

			try {
				sel = Integer.parseInt(br.readLine());
				switch (sel) {
					case 1:
						allStudent();
						break;
					case 2:
						individualStudent();
						break;
					case 3:
						studentCreate();
						break;
					case 4:
						deleteStudent();
						break;
					case 5:
						updateStudent();
						break;
					case 9:
						System.out.println("안녕히 가세요");
						return;
				}
			} catch (NumberFormatException e) {
				System.out.println("확인 후 입력하세요.");
				continue;
			}
		}
	}


	private static void allStudent() throws Exception {
		MemberService memberService = ctx.getBean(MemberService.class);

		List<StudentVO> list = memberService.readMemberList();
		for(StudentVO svo : list) {
			System.out.println(svo);
		}
	}


	private static void individualStudent() throws Exception {
		System.out.println("번호 선택 : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String studentId = br.readLine();

		MemberService memberService = ctx.getBean(MemberService.class);

		try {
			StudentVO studentVO = memberService.readMember(studentId);
			System.out.println("id = " + studentVO.getId());
			System.out.println("username = " + studentVO.getUsername());
			System.out.println("snum = " + studentVO.getSnum());
			System.out.println("depart = " + studentVO.getDepart());
			System.out.println("mobile = " + studentVO.getMobile());
			System.out.println("email = " + studentVO.getEmail());
		} catch (NullPointerException e) {
			System.out.println("해당 유저 id가 존재하지 않습니다.");
		}

		br.close();
	}

	private static void studentCreate() throws Exception {
		System.out.println("--------------------------------");
		System.out.println("			학생 등록				");
		System.out.println("--------------------------------");
		Scanner scan = new Scanner(System.in);

		System.out.print("id = ");
		String id = scan.next();

		System.out.print("passwd = ");
		String passwd = scan.next();

		System.out.print("username = ");
		String username = scan.next();

		System.out.print("snum = ");
		String snum = scan.next();

		System.out.print("depart = ");
		String depart = scan.next();

		System.out.print("mobile = ");
		String mobile = scan.next();

		System.out.print("email = ");
		String email = scan.next();

		MemberService memberService = ctx.getBean(MemberService.class);

		try {
			StudentVO student = new StudentVO(id, passwd, username, snum, depart, mobile, email);
			memberService.addMember(student);
			System.out.println("회원 가입 완료");
		} catch (DuplicateKeyException e) {
			System.out.println("이미 있는 id입니다.");
		}

	}

	private static void deleteStudent() throws Exception {
		MemberService memberService = ctx.getBean(MemberService.class);
		Scanner scan = new Scanner(System.in);

		System.out.print("삭제할 회원 id 입력 = ");
		String id = scan.next();

		memberService.deleteStudent(id);
	}

	private static void updateStudent() throws Exception {
		MemberService memberService = ctx.getBean(MemberService.class);
		Scanner scan = new Scanner(System.in);

		System.out.print("update 할 회원 id 입력 = ");
		String id = scan.next();

		System.out.print("passwd = ");
		String passwd = scan.next();

		System.out.print("username = ");
		String username = scan.next();

		System.out.print("snum = ");
		String snum = scan.next();

		System.out.print("depart = ");
		String depart = scan.next();

		System.out.print("mobile = ");
		String mobile = scan.next();

		System.out.print("email = ");
		String email = scan.next();

		StudentVO student = new StudentVO(id, passwd, username, snum, depart, mobile, email);

		try {
			memberService.updateStudent(student);
		}catch (EmptyResultDataAccessException e){
			System.out.println("업데이트 할 회원이 없습니다");
		}

	}
}
