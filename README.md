

![세모](https://github.com/focandlol/gathering/assets/50188319/41a23c0d-8be3-4ea8-be22-6f1c8d328a1b)


</br>

# 소개

> 세모는 모임을 운영하고자 하는 사용자들과 모임에 참여하고자 하는 사용자들을 대상으로 하는 웹 어플리케이션 입니다.

</br>

# 목적
```
최근 코로나19가 종식되고 모임이 활성화됨에 따라 사용자들이 더 쉽게 모임을 생성 및 참여할 수 있게 도와주고자 함

회원 가입 및 로그인, 프로필, 번개 모임(순간적인 모임) 및 동호회(지속적인 모임) 생성 및 참여, 채팅방, 번개 게시판, 동호회 게시판 등의 기능을 구현하여
사용자들이 효율적으로 모임을 생성 및 운영하고 참여할 수 있는 환경을 제공하는 것을 목표로 함.

또한 매너등급 시스템, 호스트의 초대를 통한 참여 기능과 피드백 기능을 통해 모임이 파투 날 확률을 줄이고 사용자에게 깨끗한 모임 환경을 제공.
```
</br>

# 담당
> ### 고경민 : Backend
</br>

> ### 이지호 : Frontend
</br>

> ### 박영민 : Frontend(모바일)
</br>

# 기능
### 사용자 기능

> ##### 1.메인페이지

![메인](https://github.com/focandlol/gathering/assets/50188319/d5e1dfdd-d486-40f2-9d82-1a6ee0553f92)
------------------
> ##### 2.번게 게시판(순간적인 모임)

![번1](https://github.com/focandlol/gathering/assets/50188319/585b6d29-0b4b-4945-9ca5-7fc8f3d5508c)
![번개](https://github.com/focandlol/gathering/assets/50188319/9606e337-7117-421a-86b4-4a858731b905)
------------------
> ##### 3.동호회 게시판(지속적인 모임)
![동1](https://github.com/focandlol/gathering/assets/50188319/0cad8c82-cecb-48a1-8c7e-ed11ed9e7329)
------------------
### 관리자 기능
> ##### 1.관리자 페이지
![구성3](https://github.com/focandlol/gathering/assets/50188319/764dc9a4-fbb3-4b7f-a3c7-790b6d0c372f)

</br></br></br>

# 구성
 
> ### 1.index페이지

<div align="center">
 
![인덱스](https://github.com/focandlol/gathering/assets/50188319/9cd92420-161a-46df-9832-5c81d9c57e26)  

</div>

#### 카테고리별 모임 게시글 이동, 최신순으로 모임 노출 및 바로가기 
------------------
</br></br></br>

> ### 2. 회원가입

<div align="center">
 
![회가](https://github.com/focandlol/gathering/assets/50188319/b1925fe2-53bc-4267-be82-100adb90e64a)
![gmail](https://github.com/focandlol/gathering/assets/50188319/460d0b6e-e935-4551-88ce-7bad71143842)
</div>

#### Java Mail Sender를 이용한 이메일 인증, 카카오 주소 api를 이용한 주소 찾기 기능
------------------
</br></br></br>

> ### 3. 프로필

<div align="center">
 
![프로필](https://github.com/focandlol/gathering/assets/50188319/eb1637fe-1392-4590-b501-76b34191e8f0)
</div>

#### CRUD
#### 매너 점수 확인 및 프로필 이미지 변경 기능
#### 현재 참가중인 번개 모임, 동호회 확인 및 즉시 이동
------------------
</br></br></br>

> ### 4. 번개 게시판

<div align="center">
 
![번개 게시판](https://github.com/focandlol/gathering/assets/50188319/4ef8c0af-3dcf-4aba-a313-0984044ca04a)
</div>

#### 번개 모임을 위한 게시판
#### 게시글 검색 기능 및 페이징
------------------
</br></br></br>

> ### 5. 번개 게시글

<div align="center">
 
![번개 내부](https://github.com/focandlol/gathering/assets/50188319/73e86dc0-4fc3-4bf9-a81b-560de97206a5)
</div>

#### CRUD
#### 회원 관리, 댓글을 통한 가입 요청 및 신청자 프로필에서 매너 점수 확인 후 초대
#### kakao map api를 이용하여 모임 위치 지도에 마킹
------------------
</br></br></br>

> ### 6. 번개 모임 채팅방
<div align="center">
 
![채팅방](https://github.com/focandlol/gathering/assets/50188319/d7c5b3d5-d8db-4e9b-963f-bed488a86d0b) 
</div>

#### Spring websocket을 활용한 모임 참가자들 간 채팅방
------------------
</br></br></br>

> ### 7. 피드백

<div align="center">
 
![피드백](https://github.com/focandlol/gathering/assets/50188319/b891ab67-b4fd-40c0-8c35-322ade5ccd1b)
</div>

#### 모임 종료 후 불참 및 불량 인원 신고
#### 관리자 확인 후 신고 인원 매너 점수 하락
------------------
</br></br></br>

> ### 8. 동호회 게시판

<div align="center">
 
![동호회 외부](https://github.com/focandlol/gathering/assets/50188319/1dd73cc9-b534-4389-9087-270f04c35397)
</div>

#### 동호회를 위한 게시판
#### 게시글 검색 기능 및 페이징
------------------
</br></br></br>

> ### 9. 동호회 게시글

<div align="center">
 
![동호회 내부](https://github.com/focandlol/gathering/assets/50188319/2bcccee1-ebbc-4c66-ab0e-7d2c216eaa44)
</div>

#### CRUD
#### 회원 관리 기능
------------------
</br></br></br>

> ### 10. 동호회 가입 신청 페이지

<div align="center">
 
![가입 신청](https://github.com/focandlol/gathering/assets/50188319/cb63c9fe-311d-4757-90a5-5d8db0969dcf)
</div>

#### 가입 요청 및 신청자 프로필에서 매너 점수 확인 후 초대
------------------
</br></br></br>

> ### 11. 동호회 공지사항 페이지

<div align="center">
 
![공지사항](https://github.com/focandlol/gathering/assets/50188319/755e65e9-cb34-4091-b8ce-23bdd417b03d)
</div>

#### CRUD
#### 알림사항 및 중요사항 작성
------------------
</br></br></br>

> ### 12. 동호회 채팅

<div align="center">
 
![동호회 채팅](https://github.com/focandlol/gathering/assets/50188319/2e970005-c7d8-4eb7-bdcd-3175cd8bc408)
</div>

#### Spring websocket을 활용한 모임 참가자들 간 채팅방
------------------
</br></br></br>

> ### 13. 동호회 앨범

<div align="center">
 
![앨범](https://github.com/focandlol/gathering/assets/50188319/398bb700-d67a-4786-8f27-4c18a8b2cb94)
</div>

#### Querydsl, ajax를 활용한 무한 스크롤 앨범 페이지
#### no-offset 방식 사용
------------------
</br></br></br>

> ### 14. 반응형 모바일 웹

<div align="center">

![모바일](https://github.com/focandlol/gathering/assets/50188319/c240b61b-9af4-4231-a909-2d0f48c89698)
![모동](https://github.com/focandlol/gathering/assets/50188319/9194f6ef-8235-4a26-9d4e-048fe6f3b217)
![모번](https://github.com/focandlol/gathering/assets/50188319/e6db50fe-be54-48a9-88bc-f051ffbe510f)

</div>

------------------
</br></br></br>

# 프로젝트 아키텍처
<div align="center">
 
![프로젝트 아키텍처](https://github.com/focandlol/gathering/assets/50188319/1fcdd3a9-3fe4-4db3-91ec-e03383d71356)

</div>

------------------
</br></br>

# 서비스 아키텍처
<div align="center">
 
![서비스 아키텍처](https://github.com/focandlol/gathering/assets/50188319/25eb105b-35c8-49d5-b29c-f00ea28386d1)

</div>

------------------
</br></br>

# ERD
<div align="center">
 
![erd](https://github.com/focandlol/gathering/assets/50188319/593d4fce-3d18-46c8-bb83-4363a1f1403b)

</div>

 ------------------

 
