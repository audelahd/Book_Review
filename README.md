# :collision: Spring_Project0705 :collision:

![header](https://capsule-render.vercel.app/api?type=waving&color=e9ec69&height=300&section=header&text=Book%20Review&fontColor=ffffff&fontSize=70&animation=fadeIn)

## :books: 도서 리뷰 페이지
:heavy_check_mark: JAVA 언어와 JSP 기법을 사용해 만들었던 게시판 형식의 페이지 <br>
:heavy_check_mark: Spring으로 제작하여 기능 & 흐름 파악에 집중 <br><br>


### :pushpin: 프로그램 소개 
:notebook_with_decorative_cover: 도서 리뷰 웹사이트 <br>
:date: 0705 - 0728 약 3주간 진행 <br><br>

### :computer: 개발 환경 
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/apache tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=white"> <img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"> 
 <br> <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<br><br>

### :bulb: 다이어그램
 <details>
 <summary> 다이어그램 확인하기 </summary>
   
 #### :black_nib:요구사항 명세서
 ![요구사항명세서](https://github.com/audelahd/Spring_project0705/assets/114639084/e8829116-1839-475d-9fd0-39acec976b62)

 #### :black_nib:ERD
 ![테이블관계설정](https://github.com/audelahd/Spring_project0705/assets/114639084/0b6050f7-2dc0-49da-8541-3e66c9ba275c)

 #### :black_nib:유스케이스 
![Usecase](https://github.com/audelahd/Spring_project0705/assets/114639084/b0891cb0-8f1b-475e-9c2c-a10b420415cd)

 #### :black_nib:클래스 다이어그램 
 ![Class](https://github.com/audelahd/Spring_project0705/assets/114639084/751d6b98-ea68-4170-b19a-3ea92b6f9af5)

 </details>

### :pushpin:코드 설명
<details>
<summary> 리뷰 관련 코드</summary>

#### :page_with_curl:SQL문을 작성한 xml 파일 
<br><br>![board_mybatis_mappers_board](https://github.com/audelahd/Spring_project0705/assets/114639084/469f12b5-1c58-4ca6-9960-160d8035bd4c)
<br><br>![board_mybatis_mappers_board_2](https://github.com/audelahd/Spring_project0705/assets/114639084/fae56f0f-d074-4266-a317-c727e1d3b761)
<br><br>
#### :page_with_curl:SQL문으로 나온 정보/결과 값을 Service에 전달하는 DAO
<br><br>![board_dao_boardDAO](https://github.com/audelahd/Spring_project0705/assets/114639084/adc87681-7d26-4a94-afe2-845a514eb898)
<br><br>![board_dao_boardDAOImpl_1](https://github.com/audelahd/Spring_project0705/assets/114639084/de123fba-b95e-40e5-974b-b99edd8bdf15)
<br><br>![board_dao_boardDAOImpl_2](https://github.com/audelahd/Spring_project0705/assets/114639084/777df211-1a25-4f31-bc3a-3e5cd8572e6f)
<br><br>
#### :page_with_curl:컨트롤러에서 호출되는 Service
<br><br>![board_service_boardService](https://github.com/audelahd/Spring_project0705/assets/114639084/0054e7d0-2f61-401a-927a-89b392b3869f)
<br><br>![board_service_boardServiceImpl_1](https://github.com/audelahd/Spring_project0705/assets/114639084/d73f4a22-fa6f-4794-9fa6-89cd61570255)
<br><br>![board_service_boardServiceImpl_2](https://github.com/audelahd/Spring_project0705/assets/114639084/de10b6a6-7fe7-4b46-a702-0116823a4c49)
<br><br>
#### :page_with_curl:컨트롤러
![board_controller_boardController](https://github.com/audelahd/Spring_project0705/assets/114639084/65dccc46-9f5b-4f72-b0ce-e424bc90ae89)
<br><br>![board_controller_boardControllerImpl_1](https://github.com/audelahd/Spring_project0705/assets/114639084/94fa233f-1281-41d4-b408-4efe8bc6df93)
<br><br>![board_controller_boardControllerImpl_2](https://github.com/audelahd/Spring_project0705/assets/114639084/f0da6922-a90f-46a9-a482-47bcb3fff2b3)
<br><br>![board_controller_boardControllerImpl_3](https://github.com/audelahd/Spring_project0705/assets/114639084/5d6752e9-5035-445d-a30e-f7a53b9833fe)
<br><br>![board_controller_boardControllerImpl_4](https://github.com/audelahd/Spring_project0705/assets/114639084/c6bb8ccd-55c5-465f-81bb-151af82c7526)
<br><br>![board_controller_boardControllerImpl_5](https://github.com/audelahd/Spring_project0705/assets/114639084/fb687a9b-d95c-4a8b-bd51-a93df3dfb61e)
<br><br>

##### :page_with_curl:VO - Getter&Setter 외 수정사항
  ![board_vo_articleVO](https://github.com/audelahd/Spring_project0705/assets/114639084/00a276bc-99b4-40dc-ad31-f57b13697938)
<br><br>출력할 때 숫자보다 별 아이콘이 보기 편할 것이라고 가정해서 별 아이콘을 String 형식으로 리턴한다. <br><br>

</details>

<details>
<summary> 책 관련 코드</summary>
  
  #### :page_with_curl:SQL문을 작성한 xml 파일 
  <br><br>![book_mybatis_mappers_book](https://github.com/audelahd/Spring_project0705/assets/114639084/bff5076b-cf35-4493-b05d-59c2a45583b5)
<br><br>
  #### :page_with_curl:SQL문으로 나온 정보/결과 값을 Service에 전달하는 DAO
  <br><br>![book_dao_bookDAO](https://github.com/audelahd/Spring_project0705/assets/114639084/c84bed75-788e-47d8-841d-61f5cc52f018)
<br><br>![book_dao_bookDAOImpl](https://github.com/audelahd/Spring_project0705/assets/114639084/e4bdc7f8-c2cc-4215-a897-2e524318796f)
<br><br>
  #### :page_with_curl:컨트롤러에서 호출되는 Service
 <br><br> ![book_service_bookService](https://github.com/audelahd/Spring_project0705/assets/114639084/13f7790d-1429-458e-ac77-6d29adc05165)
<br><br>![book_service_bookServiceImpl](https://github.com/audelahd/Spring_project0705/assets/114639084/fe10fdf4-663d-408f-84a2-f643c768ea94)
<br><br>
  #### :page_with_curl:컨트롤러
 <br><br> ![book_controller_bookController](https://github.com/audelahd/Spring_project0705/assets/114639084/f3c4fcb7-7358-4b31-b558-b97946cb22bd)
<br><br>![book_controller_bookControllerImpl](https://github.com/audelahd/Spring_project0705/assets/114639084/17c3a631-a5cc-446e-8f22-cb5d0faf6b94)
<br><br>
</details>

<details>
<summary> 회원 관련 코드</summary>

  #### :page_with_curl:SQL문을 작성한 xml 파일 
  <br><br>![member_mybatis_mappers_member](https://github.com/audelahd/Spring_project0705/assets/114639084/43e1aae7-ab39-4f73-9489-d7c204335cfa)
<br><br>
  #### :page_with_curl:SQL문으로 나온 정보/결과 값을 Service에 전달하는 DAO
<br><br>  ![member_dao_memberDAO](https://github.com/audelahd/Spring_project0705/assets/114639084/2b3189c2-190a-4d4f-b98f-fb4e52d28e05)
<br><br>![member_dao_memberDAOImpl](https://github.com/audelahd/Spring_project0705/assets/114639084/fca15e60-7c3a-409b-ba9e-0af696a805ac)
<br><br>
  #### :page_with_curl:컨트롤러에서 호출되는 Service
 <br><br> ![member_service_memberService](https://github.com/audelahd/Spring_project0705/assets/114639084/381ef817-93c0-4cd7-95ba-bb581d3773ee)
<br><br>![member_service_memberServiceImpl](https://github.com/audelahd/Spring_project0705/assets/114639084/c2f0bb4a-543a-403b-b763-e7796ac76651)
<br><br>
  #### :page_with_curl:컨트롤러
  <br><br>![member_controller_memberController](https://github.com/audelahd/Spring_project0705/assets/114639084/3286233a-4ce5-4771-85da-90a3b1c61d04)
<br><br>![member_controller_memberControllerImpl_1](https://github.com/audelahd/Spring_project0705/assets/114639084/c19a4ed1-7637-4cb1-b5a3-40cf266841db)
<br><br>![member_controller_memberControllerImpl_2](https://github.com/audelahd/Spring_project0705/assets/114639084/ec91d2af-5099-4d06-8435-28a6bb19e92f)
<br><br>
  
</details>
<br><br>

### :movie_camera: 시연 영상
![2023-07-31-17-19-00](https://github.com/audelahd/Spring_project0705/assets/114639084/6d911a97-7637-4f8f-8dc8-012ebe8fa8d8)
<br><br><br>

### :mag: 셀프 피드백
:heavy_plus_sign: 더 무겁고 독특한 기능을 넣지 못한 점이 아쉬웠다. <br>
:o: 데이터를 조회하고 전달하는 과정이 많은 프로그램인 만큼, 코드의 흐름에 익숙해졌다. <br>
:o: css쪽에 자신이 없어 항상 기능에만 집중했는데 이번에 css도 직접 만져서 설정해 레이아웃의 구성을 전보다 다루기 능숙해졌다. <br> <br> <br>
