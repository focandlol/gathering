![image](https://github.com/focandlol/gathering/assets/50188319/0c82d9eb-d4c5-4556-aaaa-702f6892d670)

<br>

# 프로젝트 개요

최근 코로나19가 종식되고 모임이 활성화됨에 따라 사용자들이 더 쉽게 모임을 생성 및 참여할 수 있게 도와주고자 함. 회원 가입 및 로그인, 프로필, 번개 모임(순간적인 모임) 및 동호회(지속적인 모임) 생성 및 참여, 채팅방, 번개 게시판, 동호회 게시판 등의 기능을 구현하여 사용자들이 효율적으로 모임을 생성 및 운영하고 참여할 수 있는 환경을 제공하는 것을 목표로 함. 또한 매너등급 시스템, 호스트의 초대를 통한 참여 기능과 피드백 기능을 통해 모임이 파투 날 확률을 줄이고 사용자에게 깨끗한 모임 환경을 제공.

---

<br>

# 시스템 설계

## 1.기능 설명

<div align="center">
   
![image](https://github.com/focandlol/gathering/assets/50188319/508c3ba4-bc03-4bb9-bde1-9457a2d71899)

</div>

⚫ 회원가입 : 카카오 주소 찾기 Api를 활용한 주소입력 구현, java mail sender와 ajax를 활용한 이메일 인증 구현

---

⚫ 번개게시판 : 호스트가 글을 작성하면 댓글을 통해 가입 신청이 가능함. 호스트는 댓글 작성자의 프로필에서 매너등급을 확인한 후 모임에 초대.
   
   ---피드백 : 모임 종료 후 피드백을 통한 불건전한 참가자 신고 후 관리자가 확인 후 피신고자 매너 등급 하락.
   
---
⚫ 동호회게시판 : 효율적인 동호회 관리를 위한 게시판. 회원 관리, 공지 사항 작성, 동호회 앨범 서비스를 제공.
   
   ---앨범 : querydsl과 ajax을 활용한 No-offset 방식의 무한스크롤 앨범 페이지 구현.
   
---
⚫ 채팅방 : Spring websocket과 socketjs를 활용해서 모임 단위의 실시간 채팅방 구현.

---
⚫ 관리자 : 신고사항 처리, 문의 사항 처리. 회원 관리 구현.

---
⚫ 모바일 웹 : Media Query를 활용해 기기별 화면 크기에 따른 구성 요소들의 재배치 구현.

---
<br><br>

## 2.개발 환경, 도구 및 언어
![image](https://github.com/focandlol/gathering/assets/50188319/f7ae8471-1792-4858-ae88-549aea23820f)
<br><br>

## 3.기능 설계 및 진척사항


### 3-1. 메인 페이지
![image](https://github.com/focandlol/gathering/assets/50188319/7cbefad9-0c34-4b46-8c67-7cea200acceb)

### 3-2. 번개 게시판
![image](https://github.com/focandlol/gathering/assets/50188319/21bb9b16-c7be-4eb1-a559-43d618dd2291)
![image](https://github.com/focandlol/gathering/assets/50188319/d65d0201-6beb-48f3-b5f8-add81a8fef05)

### 3-3. 동호회 게시판
 ![image](https://github.com/focandlol/gathering/assets/50188319/301e556a-df03-4c3e-a5d6-29e69c757f18)

 ### 3-4. 관리자 페이지
 ![image](https://github.com/focandlol/gathering/assets/50188319/7c2d91c3-be16-4295-a5ce-17dba383640f)

<br><br>

### 진척 사항 
![진척](https://github.com/focandlol/gathering/assets/50188319/27779099-36bc-4e22-b70c-20d30ccc5207)

## 4.ERD


![image](https://github.com/focandlol/gathering/assets/50188319/0ecf1629-065d-4c59-8270-39dceb4efc9f)
<br>

---

<br>

# Overview

<br>

### 1.메인 페이지


 ![image](https://github.com/focandlol/gathering/assets/50188319/b5a2c4af-10a2-4a7d-ae02-cee34ece5de1)

<br>

### 2.회원가입 페이지


![image](https://github.com/focandlol/gathering/assets/50188319/6d898ce2-d4db-44eb-805d-60cbf04cbd8d)
![image](https://github.com/focandlol/gathering/assets/50188319/98ebba46-db2e-46ed-9e25-a2a626ac7108)

<br>

### 3.프로필 페이지


![image](https://github.com/focandlol/gathering/assets/50188319/8c10ec39-65fa-4b2e-bd22-207eab83b676)

<br>

### 4.번개 게시판


![image](https://github.com/focandlol/gathering/assets/50188319/74c6617d-e579-446f-b5ef-82d935712fbc)

<br>

### 5.번개 게시글


![image](https://github.com/focandlol/gathering/assets/50188319/8273915c-a976-4d10-876f-7ed08a617e8b)

<br>

### 6.번개 채팅방


![image](https://github.com/focandlol/gathering/assets/50188319/9e2119a7-7bd2-4c37-b36f-39594b2fa9a7)

<br>

### 7.피드백


 ![image](https://github.com/focandlol/gathering/assets/50188319/7a347e34-d6d6-4e11-a51e-dcd895329c68)

<br>

### 8.동호회 게시판


![image](https://github.com/focandlol/gathering/assets/50188319/d1626c16-1ca0-4779-bf22-b3bc333595c7)

<br>

### 9.동호회 게시글


![image](https://github.com/focandlol/gathering/assets/50188319/d8587a84-4e21-45fa-955c-86f356bb2dfb)

<br>

### 10.동호회 가입신청 페이지


![image](https://github.com/focandlol/gathering/assets/50188319/913b67c2-1969-4720-a7a6-6791ecff3bfe)

<br>

### **11. 동호회 공지사항 페이지** 


![image](https://github.com/focandlol/gathering/assets/50188319/d1445a9e-c754-4660-86c5-208a354175fd)

<br>

### 12. 동호회 채팅방


![image](https://github.com/focandlol/gathering/assets/50188319/3da109e3-a42d-4f28-aea5-6e4594a41701)

<br>

### 13. 동호회 앨범 페이지


![image](https://github.com/focandlol/gathering/assets/50188319/19fc599d-81fe-4e91-b93a-04d839309968)

<br>
   
### 14. 반응형 모바일 웹



<div align="center">

![image](https://github.com/focandlol/gathering/assets/50188319/4ee9b330-ef60-4e33-afb1-083511078670)
![image](https://github.com/focandlol/gathering/assets/50188319/2bc8f53e-9567-4e43-9384-d5bd368c012a)
![image](https://github.com/focandlol/gathering/assets/50188319/3f0b5dec-9462-48db-a079-729736440166)

</div>

---

<br>


# 팀 구성


>## Backend 및 Database : 고경민
       
>## Frontend : 이지호
       
>## Mobile Frontend : 박영민



