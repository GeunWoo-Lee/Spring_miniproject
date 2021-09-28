# Spring_miniproject
java, oracleDB, jdbc, mybatis, javascript, jquery, html5, css, tomcat을 사용하여 기본적인 프로젝트를 구성하였습니다.

메이븐 프로젝트를 기반으로 구성하였고, pom.xml을 통해 호환되는 플러그인과 디펜던시들을 가지고 왔습니다. 

Spring MVC 구조를 사용하여 어노테이션으로 Controller와 Repository, Service를 구분하였습니다. 

전반적인 설정은 spring-mvc.xml을 통하여 스프링에 필요한 라이브러리와 인코딩, mybatis 그리고 view를 설정하였습니다.  

OracleDB와의 연결은 Mybatis를 통해 mybatis-config.xml 파일과 Member.xml로 작성하였습니다. OracleDB의 설정은 db.properties.txt 파일에 저장해 놓았습니다.



기능은 로그인 기능과 로그아웃 기능, 회원 전체 리스트 기능, 회원 가입과 파일 업로드, 회원 수정과 탈퇴 기능으로 구성되어 있습니다. 



