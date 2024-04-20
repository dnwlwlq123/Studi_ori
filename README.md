# Studi

### 🎯서비스 목표
>____혼자서 공부하는 것은 어렵고, 협업을 통해 발전하는 경험은 더욱 가치 있습니다.____
그러나 적절한 팀원을 찾는 것은 때로는 매우 어려운 일입니다. **Stuid는** 이러한 문제를 해결하기 위해 
공부나 프로젝트를 함께할 팀원을 찾는 데 어려움을 겪는 학생들과 개발자들을 위한 플랫폼입니다.

### 📌프로젝트 소개  
> - 스터디 인원 및 팀 프로젝트 팀원을 모집하는 플랫폼 서비스
> - 개발 인원 총 5명 ( 박정연, 최교순, 김용환, 김태진, 이동우)
> - 개발 기간 : 3주 (2024.04.01 ~ 2024.04.22) 
- 배포 URL : [Studi 사이트↗️](http://studi-6th.duckdns.org:8090/)
- 👽 위의 URL 을 통해 산출물을 경험해 보실 수 있습니다. 
- 관리자  : ID:`admin` password: `1234`
- Test 회원 :  ID: `user` password: `1234`
---
### ⚙️ 개발 환경
- 프레임워크 : Spring Framework 
- IDE : intelliJ
- Back : Java 17, Maven,  Mybatis, Mysql
- Front : JSP, JQuery, ajax, bootstrap
- 인프라, CI/CD : Naver Cloud Platform, JenKins
- 협업 도구 : Github, Figma, notion

---
### 🎁핵심 기능
- 팀원 매칭: 사용자는 자신의 관심 분야와 프로젝트에 대한 정보를 등록하여, 해당 분야나 프로젝트에 관심 있는 팀원들을 찾을 수 있습니다.
- 프로젝트 게시판: 사용자는 자신이 진행 중이거나 참여하고 싶은 프로젝트를 게시하여 다른 사용자들과 협업할 수 있습니다.
- 커뮤니티 기능: 각종 토론과 정보 공유를 할 수 있는 커뮤니티를 형성할 수 있습니다.
- 채팅 기능: 팀원 간의 원활한 소통을 위해 내장된 채팅 기능을 통해 쉽게 소통할 수 있습니다.

---
### 🎨 구현 서비스
- **로그인**
  - OAuth 2.0 기반으로 네이버가 제공하는 API에 접근하여 로그인 기능
  - 아이디 중복 체크 기능
  - 이메일 인증 기능 


- 프로젝트 및 스터디 모집 게시판
  - 프로젝트 및 스터디 게시글 작성 기능
    - 모집인원, 모집유형, 사용할 개발 언어 선택
  - 게시글 페이징 처리 기능
  - 쿠키를 이용한 조회수 기능


- **라운지(커뮤니티 기능)**
  - Jquery, Ajax로 게시글 비동기로 가져오는 **무한 스크롤** 기능
  - Modal을 활용한 **게시글 작성** 기능
  - 내용이 긴 게시글은 `...`으로 말 줄임 표시하는 `더보기, 접기` 기능
  - Modal을 활용한 **댓글** 작성 & 보기 기능
  - **좋아요** 기능
    - 이전에 `좋아요`를 눌렀던 게시글 표시
  - 아코디언을 이용한 공지사항 목록 표시 기능


- **관리자 페이지 기능**
  - chat.js를 이용한 프로젝트 및 스터디 게시글 데이터 시각화 기능
  - 회원 목록 조회 및 검색 기능
  - 신고자 관리 기능
  - 공지사항 작성 및 삭제 기능


---
### 메인 화면
<img src="https://github.com/JungYeon22/Studi/assets/105910143/86507575-2184-4a78-bedd-8c6698ae298f" style="width: 50%">

### 프로젝트 및 스터디 모집 게시판
<img src="https://github.com/JungYeon22/Studi/assets/105910143/7e9ed2d2-834f-451f-b5eb-c0eae1240327" style="width: 50%">

### 라운지 화면
<img src="https://github.com/JungYeon22/Studi/assets/105910143/95301ac9-17a7-402e-bedf-7056e361e9c1" style="width: 50%">
