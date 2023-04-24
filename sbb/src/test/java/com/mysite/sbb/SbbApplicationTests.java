package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private QuestionService questionService;
	@Test
	void testPagingJpa() {
		for(int i=1; i<=143 ; i++) {
			String subject=String.format("페이징 테이스 데이터:[%03d]", i);
			String content="null";
			this.questionService.create(subject, content);
					
		}
	}
	
//	@Test
	void contextLoads() {
		Question q1 = new Question();
		q1.setSubject("sbb subject");
		q1.setContent("sbb content");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1); // insert문을 메서드로 만들어 둔것
		
		Question q2 = new Question();
		q2.setSubject("sbb subject2");
		q2.setContent("sbb content2");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
		
	}
//	@Test
	void testJpa() {
		List<Question> all = this.questionRepository.findAll(); // select * from question;
		System.out.println( all.get(0).getSubject() + " " + all.get(1).getSubject() + " Test~~~~");
		assertEquals(2, all.size()); //assertEquals(기대값, 실제처리값)
	}
	
//	@Test
	void testJpaFindById() {
		Optional<Question> oq =this.questionRepository.findById(2); // select * from question where id=2;
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb subject2", q.getSubject());
		}
	}
	
//	@Test
//	void testJpaFindBySubject() {
//		Question q = this.questionRepository.findBySubject("sbb subject find");
//		assertEquals(21, q.getId());
//	}
	
	
//@Test
//	void testJpaFindByContentAndSubject() {
//		Question fcs = this.questionRepository.findByContentAndSubject("스프링부트 JPA사용법","JPA 추상메소드 만들기");
//		assertEquals(22, fcs.getId());
//	}
	
//	@Test
//	void testJpaFindByCreateDateBetween() {
//		List<Question> f = this.questionRepository.findByCreateDateBetween(LocalDateTime.of(2023, 05,01,0,0), LocalDateTime.of(2023, 06,30,0,0));
//		System.out.println(f.get(0).getCreateDate());
//		System.out.println(f.get(1).getCreateDate());
//		assertEquals(2, f.size());
//	}
	
//	@Test
	void testJpaFindBySubjectLike() {
		List<Question> ff = this.questionRepository.findBySubjectLike("%추상메소드%");
		System.out.println(ff.get(0).getSubject());
		System.out.println(ff.get(1).getSubject());
		System.out.println(ff.get(2).getSubject());
		assertEquals(3, ff.size());
	}
	
//	@Test
	void testUpdateJpa() {
		Optional<Question> oq = this.questionRepository.findById(1); //검색됨
		assertTrue(oq.isPresent()); //isPresent : value(oq값)가 있으면 true - 수정을 하려면 1번id가 존재해야함
		Question q = oq.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q);
	}
	
//	@Test //특정 단어 찾고 특정 단어 수정하기
	void testUpdateJpa2() {
		List<Question> qList = this.questionRepository.findBySubjectLike("%sbb%");
		assertEquals(20,qList.size()); //sbb 들어간 것이 20개 있는지 확인
		
		for(Question q2 : qList) {
			System.out.println(q2.getContent() + "원래 내용");
			String replaceDate = q2.getContent().replace("sbb", "kbs");
			q2.setContent(replaceDate);
			this.questionRepository.save(q2);
		}
	}
	
//  문제4)  subject가 "수정된 제목"을 찾아서 삭제하기
//  1단계 찾기
//  2단계 테스팅 해보기 1개인가? 
//  3단계 get 출력해주고
//  4단계 delete 삭제하기
//  5단계 테스팅 해보기 0개인가?
//	@Test
//	void testfindBySubjectDelete() {
//		List<Question> q = this.questionRepository.findBySubject("수정된 제목"); //1단계 찾기
//		assertEquals(1, q.size() ); //2단계 테스팅 해보기 1개인가? 
//		System.out.println( q.get(0).getSubject()  + " : 찾은 레코드 내용 삭제할 예정" );  //   3단계 get 출력해주고
//    	this.questionRepository.delete(q.get(0)); //   4단계 delete 삭제하기
//   	q = this.questionRepository.findBySubject("수정된 제목"); //5단계 찾기
//		assertEquals(0, q.size() );// 0개인가?
//	}
	
	
//	@Test
	void testAnswer() {
		Optional<Question> answerO = this.questionRepository.findById(20); //1. 질문게시판 자료 검색
		assertTrue(answerO.isPresent()); //2. 존재하는지 테스트
		Question q3 = answerO.get(); //3.존재하면 값을 가져와서 Question q3에 담는다
		
		Answer a = new Answer(); //setter를 넣어주기 위해서 객체화가 필요하다
		//sql : insert into answer(content, create_date, question_id) value('20번 답변내용',now(),20)
		a.setContent("이게 진짜 20번 답이다!!!"); //setter로 값을 넣어준다(sql의 insert 역할)-answer 테이블의 컬럼 중 하나인 content
		a.setCreateDate(null); //answer 테이블의 컬럼 중 하나인 create_date
		a.setQuestion(q3); // 6.setQuestion() 안에 질문게시판 자료를 넣어준다
		Answer createdData = this.answerRepository.save(a); //7.답글 저장하기
		
		//8.테스팅코드 짜기
		//Answer 테이벌 안에 question_id가 20인게 있느냐? 있으면 통과,없으면 불통
		assertEquals(20, createdData.getQuestion().getId());
	}
		


	//문제1. 답변 게시판에 id가 3번인 것 찾기 
//	@Test 
	void testFindAnswerNo3() {
		Optional<Answer> no3 = this.answerRepository.findById(3);
		assertTrue(no3.isPresent()); //id 3인 답변 있는지
	}
	
	//문제2. 답변 게시판에 content가 "답변"이라고 유사일치 Like 하는 것 찾아보기
//	@Test
	void testFindAnswer() {
		List<Answer> aList = this.answerRepository.findByContentLike("%답변%");
		System.out.println(aList.get(0).getContent()+ "0!!!!!!!!");
		System.out.println(aList.get(1).getContent()+ "1!!!!!!!!");
		System.out.println(aList.get(2).getContent()+ "2!!!!!!!!");
		System.out.println(aList.get(3).getContent()+ "3!!!!!!!!");
		System.out.println(aList.get(4).getContent()+ "4!!!!!!!!");
		assertEquals(5, aList.size());
	}
	
	//문제3. 답변 게시판 id가 3,4,5인 것 찾기 in
//	@Test
	void testFindAnswer345() {
		//답변게시판에 3,4,5를 넣을 추상메소드를 만들어야함
		Integer[] iArr = {3,4,5};
		List<Answer> a345 = this.answerRepository.findByIdIn(iArr);
		//3,4,5 찾기
		for(int i=0; i<iArr.length;i++) {
			System.out.println(iArr[i]+" : "+ a345.get(i).getContent());
			assertEquals(iArr[i], a345.get(i).getId());
		}
	}
		
	//답변에 연결된 질문 찾기

//		@Test
		void testAnQ(){
			Optional<Question> oqAnQ=this.questionRepository.findById(20);
			assertTrue(oqAnQ.isPresent());
			Question q=oqAnQ.get();
			System.out.println(q.getId()+" "+q.getContent()+" "+q.getSubject()+" "+q.getAnswerList());
			
			List<Answer> answerList = q.getAnswerList();
			System.out.println(answerList.get(0).getContent() + "-->20번질문의 첫번째 답변");
			System.out.println(answerList.get(1).getContent() + "-->20번질문의 두번째 답변");
			System.out.println(answerList.get(2).getContent() + "-->20번질문의 세번째 답변");
			assertEquals(4, answerList.get(0).getId());
		}
		
	
				
				
				

	
	
	
	



	
	
}

