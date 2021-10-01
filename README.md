# Spring_miniproject
java, oracleDB, jdbc, mybatis, javascript, jquery, html5, css, tomcat을 사용하여 기본적인 프로젝트를 구성하였습니다.


#구현 설명

Maven 프로젝트 기반으로 작성하였으며, pom.xml을 통해 dependencies를 지정함. 기본적으로 Spring 프레임워크 5.0을 기반으로 작성함. repository를 이용하여 오라클 JDBC를 가져오고, 메이븐에서 제공하는 여러 디펜던시로 서블렛, 아파치 톰캣, 파일 업로드 라이브러리, 등을 다운 받음. 사실 생각보다 호환이 안되서 디펜던시를 여러번 갈아치웠었음. 맞는 버전이 아니면 에러 발생.

#프론트 엔드

그외에 기본적인 프론트엔드는 java server page(jsp)로 구현, jsp로 구현하여 쉽게 자바로 html을 구현함. jstl로 웹페이지에 for문과 if문등을 구현.

#백엔드

서블렛 파일에선 스프링 어노테이션을 사용하여 java를 서블렛으로 지정. 스프링 라이브러리 사용. ModelAndView 객체를 리턴하여 불러올 서블렛 지정, 혹은 연산후에 실행할 페이지를 지정.
웹브라우저가 닫힐때 까지 유지되는 httpSession 을 사용하여 로그인 기능 유지
파일 업로드를 위하여 MultipartHttpServletRequest를 사용하고, 기본 경로 안에 /photo 폴더를 만들어 서버에 업로드

#데이터베이스

멤버 등록이나 파일정보는 MemberDAO를 통하여 @Autowired 된 sqlSessionFactory를 사용하여 Mybatis로 연결 Mybatis는 Spring-mvc-.xml 파일로 불러와서 bean으로 저장하여 사용할 준비 함 그리고 DAO를 통하여 MemberFile.xml에 지정된 명령어로 명령을 수행하여 데이터 베이스에 저장함. 모든 sql이 sqlmap 폴더 밑의 xml 파일에 저장되어 있고, 이 정보와 경로는 spring-mvc.xml에 저장됨.
OracleDB와의 연결은 Mybatis를 통해 mybatis-config.xml 파일과 Member.xml로 작성하였습니다. OracleDB의 설정은 db.properties.txt 파일에 저장해 놓았습니다.



기능은 로그인 기능과 로그아웃 기능, 회원 전체 리스트 기능, 회원 가입과 파일 업로드, 회원 수정과 탈퇴 기능으로 구성되어 있습니다. 



