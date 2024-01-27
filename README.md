![세모](https://private-user-images.githubusercontent.com/50188319/281732629-41a23c0d-8be3-4ea8-be22-6f1c8d328a1b.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDIwMTYsIm5iZiI6MTcwNjM0MTcxNiwicGF0aCI6Ii81MDE4ODMxOS8yODE3MzI2MjktNDFhMjNjMGQtOGJlMy00ZWE4LWJlMjItNmYxYzhkMzI4YTFiLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3NDgzNlomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWQ3NDkxMjcwYzg4NDI5NjBlNGY3Mzg4OTAyMjViNmJmMDE4MGE5NzUyNDNkOThlOTU2ZWRkYWM3YjM0YWYzY2UmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0._gKTEWYciyNfilHd7VBleAMC6saNEyiakJr4M3CgDSI)

<br>

# 프로젝트 개요

최근 코로나19가 종식되고 모임이 활성화됨에 따라 사용자들이 더 쉽게 모임을 생성 및 참여할 수 있게 도와주고자 함. 회원 가입 및 로그인, 프로필, 번개 모임(순간적인 모임) 및 동호회(지속적인 모임) 생성 및 참여, 채팅방, 번개 게시판, 동호회 게시판 등의 기능을 구현하여 사용자들이 효율적으로 모임을 생성 및 운영하고 참여할 수 있는 환경을 제공하는 것을 목표로 함. 또한 매너등급 시스템, 호스트의 초대를 통한 참여 기능과 피드백 기능을 통해 모임이 파투 날 확률을 줄이고 사용자에게 깨끗한 모임 환경을 제공.

# 시스템 설계

## 1.기능 설명
![image](https://github.com/focandlol/gathering/assets/50188319/508c3ba4-bc03-4bb9-bde1-9457a2d71899)

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
![프로젝트 아키텍처](https://private-user-images.githubusercontent.com/50188319/281726710-7fa31809-ec33-490f-8cc7-2c3a720b929b.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzMzk3MTksIm5iZiI6MTcwNjMzOTQxOSwicGF0aCI6Ii81MDE4ODMxOS8yODE3MjY3MTAtN2ZhMzE4MDktZWMzMy00OTBmLThjYzctMmMzYTcyMGI5MjliLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MTAxOVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWE4NDlmYjlmZWY0ZTAyNzE4MjRmYmFiNTg3NTViOGFiYTI0ZTM5Zjk1NzgzMmQ0MjVhMTc0NGJmZGJlNTgyNDImWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.6cK1V1Xw5js1fP0dc1QFYaQ4KWgpNpXaNZ-1V-64dDs)

<br><br>

## 3.기능 설계 및 진척사항


### 3-1. 메인 페이지
![메인](https://private-user-images.githubusercontent.com/50188319/281681476-d5e1dfdd-d486-40f2-9d82-1a6ee0553f92.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzMzk4NTcsIm5iZiI6MTcwNjMzOTU1NywicGF0aCI6Ii81MDE4ODMxOS8yODE2ODE0NzYtZDVlMWRmZGQtZDQ4Ni00MGYyLTlkODItMWE2ZWUwNTUzZjkyLlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MTIzN1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTk5Njg3ZWNlYzg3MGJlMDgxMDE3MDljODgyMWQ0MWM0ZjBlOWVkNWI2ODQ1ZThjN2M2ZDM5YThjYjNhNzdlMzImWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.2zENGFy8ZWtm4v8pnTaLTGQk5b6QQkm_HzU-knXaq1g)

### 3-2. 번개 게시판
![번1](https://private-user-images.githubusercontent.com/50188319/282292039-585b6d29-0b4b-4945-9ca5-7fc8f3d5508c.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDE2MDksIm5iZiI6MTcwNjM0MTMwOSwicGF0aCI6Ii81MDE4ODMxOS8yODIyOTIwMzktNTg1YjZkMjktMGI0Yi00OTQ1LTljYTUtN2ZjOGYzZDU1MDhjLlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3NDE0OVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTBmMDlkOTk0YjBiNjJlMGJjYWE1YWFjZTZkMGI5ZGJmMmE1ZGU0MDA0NGUyODY1MmUwNWZiNzdhYjY5OGJhMWMmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.OVWV5DYHc5ROKRlem7G9AGgd50r92ph0VCiWeAPo-WI)
![번개](https://private-user-images.githubusercontent.com/50188319/281680309-9606e337-7117-421a-86b4-4a858731b905.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDAwMDMsIm5iZiI6MTcwNjMzOTcwMywicGF0aCI6Ii81MDE4ODMxOS8yODE2ODAzMDktOTYwNmUzMzctNzExNy00MjFhLTg2YjQtNGE4NTg3MzFiOTA1LlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MTUwM1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTU4Mjg1OTI3OThmNGI3MjY2ZjA5NzBjZDQ3ZjA4Y2ZiODFlNjIyOWE0MDYzMWEyMzA1YjBiMmU0MjcwZWNmMzEmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.zIwxy2lfiEOdAE5y6sueuIxVndgVHowAQT52l2QtrxQ)

### 3-3. 동호회 게시판
 ![동호회](https://private-user-images.githubusercontent.com/50188319/281680516-506be925-a811-43bb-99b5-600887d6d8cf.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDAwMzQsIm5iZiI6MTcwNjMzOTczNCwicGF0aCI6Ii81MDE4ODMxOS8yODE2ODA1MTYtNTA2YmU5MjUtYTgxMS00M2JiLTk5YjUtNjAwODg3ZDZkOGNmLlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MTUzNFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTA4Yjc1YjBlMjY0NzUzNzVkYmU3ZTIzNDdkNmFjOWExMzMwZGQzM2UwOGE0NjYxYjcwMGUwYjg2MDNmZWQ1MTUmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.mAJOlRnFX0ZqnO4e2LBQphAxzaG3g03k2Kn9jhM_Q9g)

 ### 3-4. 관리자 페이지
 ![구성3](https://private-user-images.githubusercontent.com/50188319/281679503-764dc9a4-fbb3-4b7f-a3c7-790b6d0c372f.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDAwOTQsIm5iZiI6MTcwNjMzOTc5NCwicGF0aCI6Ii81MDE4ODMxOS8yODE2Nzk1MDMtNzY0ZGM5YTQtZmJiMy00YjdmLWEzYzctNzkwYjZkMGMzNzJmLlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MTYzNFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWRkZDVhMDk0OWJlZjYxNWVmZjYwYmFkNGJlMzIwMWNjYTg5MjM4M2ZmMGNiMWM5MWI5ZjQ0YzU0OTZkZjVmMmYmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.gmN2zQw4zL_WRaKscFgI8gNPKu37sZFxEkjybh1UFkc)

<br><br>

## 진척 사항 
![진척](https://github.com/focandlol/gathering/assets/50188319/27779099-36bc-4e22-b70c-20d30ccc5207)

## 4.ERD


 ![erd](https://private-user-images.githubusercontent.com/50188319/281728312-593d4fce-3d18-46c8-bb83-4363a1f1403b.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDAyNTgsIm5iZiI6MTcwNjMzOTk1OCwicGF0aCI6Ii81MDE4ODMxOS8yODE3MjgzMTItNTkzZDRmY2UtM2QxOC00NmM4LWJiODMtNDM2M2ExZjE0MDNiLlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MTkxOFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTYwZjRlNWZmYTQ3MWUxZGI1NDU2ZDFhYmFkZTQ4OWJjMGJiYzZjOGJmNzYxZDgyYjYwNzRkNWZhYTA1MzliMzYmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.pt6w1xEVI1HOyvOfjBLmneuXFbYOTncWS4-YLV72uzs)


### 1.메인 페이지
 ![인덱스](https://private-user-images.githubusercontent.com/50188319/281697800-9cd92420-161a-46df-9832-5c81d9c57e26.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDA2OTcsIm5iZiI6MTcwNjM0MDM5NywicGF0aCI6Ii81MDE4ODMxOS8yODE2OTc4MDAtOWNkOTI0MjAtMTYxYS00NmRmLTk4MzItNWM4MWQ5YzU3ZTI2LlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MjYzN1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTk4ZjhmMGRkOTQ3ZmQxNTZiMWUwYzc5ZGNiNzM3NTU2ZmJkNGZlNmIyZWZjZmRhMDdkYTUzNmIwNTMwZDFkOWMmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.R-F_wXBB0-ME_1vrtkU-GRJLQc0v2zKAEQUGs42cvHo)

### 2.회원가입 페이지
![회가](https://private-user-images.githubusercontent.com/50188319/281699920-b1925fe2-53bc-4267-be82-100adb90e64a.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDA3NjYsIm5iZiI6MTcwNjM0MDQ2NiwicGF0aCI6Ii81MDE4ODMxOS8yODE2OTk5MjAtYjE5MjVmZTItNTNiYy00MjY3LWJlODItMTAwYWRiOTBlNjRhLlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3Mjc0NlomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTkyNGJjNzhkYzllNjM3ZTcyZGU3MmIxMjVlYjQwN2I4ODlhYjllZWMwZGY5NTM0MWMxYTEzYTk2ZWYyOTYxM2MmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.7oXP9VKW1Vtbk6_Mc1Xw0IAonU7GGGTw1UjwUwRiLjA)
![gmail](https://private-user-images.githubusercontent.com/50188319/281700240-460d0b6e-e935-4551-88ce-7bad71143842.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDA4NDksIm5iZiI6MTcwNjM0MDU0OSwicGF0aCI6Ii81MDE4ODMxOS8yODE3MDAyNDAtNDYwZDBiNmUtZTkzNS00NTUxLTg4Y2UtN2JhZDcxMTQzODQyLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MjkwOVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTA1NjBkM2YwNmVlZDU4ZTEyMjUzNGY4M2M3NDQ3OWRiYjA1N2FhY2ZlMjM1NzdlMWJlZDA2MjNjNjFjMGJmOTImWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.z7II6p3fXmOejUbKVKK1HCgHfWgWuDiClnmqKEcuvDo)

### 3.프로필 페이지
![프로필](https://private-user-images.githubusercontent.com/50188319/281703336-eb1637fe-1392-4590-b501-76b34191e8f0.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDA5MTMsIm5iZiI6MTcwNjM0MDYxMywicGF0aCI6Ii81MDE4ODMxOS8yODE3MDMzMzYtZWIxNjM3ZmUtMTM5Mi00NTkwLWI1MDEtNzZiMzQxOTFlOGYwLlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MzAxM1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWFhMzlkZDI1YzM3N2VkZDQ4MDViYzY1NGQ4MjQ2ZDYzMWViMDdjOTQ0ZWRjMzJmOGUzMGI4NzA3M2VlZjU4ZWEmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.llHbrYRYBGKRle0_Q17B83q1-3MVNxwVdbjBxPaevCk)

### 4.번개 게시판
![번개 게시판](https://private-user-images.githubusercontent.com/50188319/281703741-4ef8c0af-3dcf-4aba-a313-0984044ca04a.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDA5NDYsIm5iZiI6MTcwNjM0MDY0NiwicGF0aCI6Ii81MDE4ODMxOS8yODE3MDM3NDEtNGVmOGMwYWYtM2RjZi00YWJhLWEzMTMtMDk4NDA0NGNhMDRhLlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MzA0NlomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWVhN2RlMDYzOTliZjUwNTNlNzQ1M2Y1ZjZlNGJmMWU0ODM1NjkzNzg0YTE3YzNiODY1MTNiMTkzMTMxZDA4ZWYmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.9DHnFrMlsoxNM7VneW0zmF-7xy5O77xUGMQHa_KrAOA)

### 5.번개 게시글
![번개 내부](https://private-user-images.githubusercontent.com/50188319/281705178-73e86dc0-4fc3-4bf9-a81b-560de97206a5.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDA5OTQsIm5iZiI6MTcwNjM0MDY5NCwicGF0aCI6Ii81MDE4ODMxOS8yODE3MDUxNzgtNzNlODZkYzAtNGZjMy00YmY5LWE4MWItNTYwZGU5NzIwNmE1LlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MzEzNFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTBmY2M1NDRjNzExMGJhOGU4NWU4ODAyNjNiMDc2NmZjOThlOWM3MTJmYTBkNjE3NzQyNGY4OWU4ZGNiMWYzOWEmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.Jl7_lxG_KRZUC936G0uuSxfdiyOdYKoqCAk6eEOFHwc)

### 6.번개 채팅방
![채팅방](https://private-user-images.githubusercontent.com/50188319/281705752-d7c5b3d5-d8db-4e9b-963f-bed488a86d0b.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDEwMjIsIm5iZiI6MTcwNjM0MDcyMiwicGF0aCI6Ii81MDE4ODMxOS8yODE3MDU3NTItZDdjNWIzZDUtZDhkYi00ZTliLTk2M2YtYmVkNDg4YTg2ZDBiLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MzIwMlomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWM2YzRlY2UxYzJiN2QzNGJlOWRmNGI0NTI1MzA4NzQyMWI3MjA0ZWIzNzI2ZTEyMDBhNWYxOWZiNDljYTdkM2YmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.SXakBjOtxKkbui38QG4ioh-QSR_JkfLMIhVT0tJQTKU)

### 7.피드백
 ![피드백](https://private-user-images.githubusercontent.com/50188319/281710993-b891ab67-b4fd-40c0-8c35-322ade5ccd1b.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDEwNDksIm5iZiI6MTcwNjM0MDc0OSwicGF0aCI6Ii81MDE4ODMxOS8yODE3MTA5OTMtYjg5MWFiNjctYjRmZC00MGMwLThjMzUtMzIyYWRlNWNjZDFiLlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MzIyOVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTdkOWI2N2RhZGJiYTU2NDQwNmFmNzRjNzVjNGY1MDU3MWRjOTE4NzQyNmNmOTY2Mjk3YmMyODgxYzZiNDRiYTAmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.eLWV0mf809hZ_hEWm2IORmHvcyS7KErkMxTimQkXZ80)

### 8.동호회 게시판
![동호회 외부](https://private-user-images.githubusercontent.com/50188319/281714187-1dd73cc9-b534-4389-9087-270f04c35397.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDEwODgsIm5iZiI6MTcwNjM0MDc4OCwicGF0aCI6Ii81MDE4ODMxOS8yODE3MTQxODctMWRkNzNjYzktYjUzNC00Mzg5LTkwODctMjcwZjA0YzM1Mzk3LlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MzMwOFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTVlZDQyMzUwNDlmODcwYzJkODJjMWI1MDg2ZmVlMjM5MjY0OGY0NGE2MjFhZjIwOThiY2ZkYjFkOTBkNWVkMjQmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.PauV1Ib5fdU08a3-ESM-dTiksK1WGRAo5Z_f_0iRw44)

### 9.동호회 게시글
![동호회 내부](https://private-user-images.githubusercontent.com/50188319/281714406-2bcccee1-ebbc-4c66-ab0e-7d2c216eaa44.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDExNDIsIm5iZiI6MTcwNjM0MDg0MiwicGF0aCI6Ii81MDE4ODMxOS8yODE3MTQ0MDYtMmJjY2NlZTEtZWJiYy00YzY2LWFiMGUtN2QyYzIxNmVhYTQ0LlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MzQwMlomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTU5ZTYyZWM5YjRhZWVlODk2ZmFmYTMzMGFkZmFmMDU1MzNhZDcyZWZjMTA5YWUzYTRiOGU0MGY1MTY4NTQxYTUmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.sj58qTPkvmKgNjRMXrcldjOlWBGY8U9zBjuLTb7MXpw)

### 10.동호회 가입신청 페이지
![가입 신청](https://private-user-images.githubusercontent.com/50188319/281714504-cb63c9fe-311d-4757-90a5-5d8db0969dcf.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDExNzEsIm5iZiI6MTcwNjM0MDg3MSwicGF0aCI6Ii81MDE4ODMxOS8yODE3MTQ1MDQtY2I2M2M5ZmUtMzExZC00NzU3LTkwYTUtNWQ4ZGIwOTY5ZGNmLlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MzQzMVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWQ1MDY1ZjMwNzVlODJjYjYwZTA1ODMxMTgxNzIzMDMxN2EyNzkyYzhjOWM0ZGIzOThiYmEzMWRlN2YxZmI4NTYmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.bihMjL8VnGbodYEd7TQHGnuAi3zW9r7tEpV8oFsfed4)

### 11. 동호회 공지사항 페이지
![공지사항](https://private-user-images.githubusercontent.com/50188319/281714828-755e65e9-cb34-4091-b8ce-23bdd417b03d.PNG?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDE0NDcsIm5iZiI6MTcwNjM0MTE0NywicGF0aCI6Ii81MDE4ODMxOS8yODE3MTQ4MjgtNzU1ZTY1ZTktY2IzNC00MDkxLWI4Y2UtMjNiZGQ0MTdiMDNkLlBORz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MzkwN1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWUwYjg1NzAxZmExNjhkMGU2YWM4OTkyZTY2MzgwMDQwYjc2MGFiOTgwMDIzN2YxMzViZTM0MzFlNWVmNzc4NjYmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.pIHWRnkEbOQ8-2o6B5Qw5TeGiwoF_DkYj6ehpdFxnZE)

### 12. 동호회 채팅방
![동호회 채팅](https://private-user-images.githubusercontent.com/50188319/281719664-2e970005-c7d8-4eb7-bdcd-3175cd8bc408.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDE1MTAsIm5iZiI6MTcwNjM0MTIxMCwicGF0aCI6Ii81MDE4ODMxOS8yODE3MTk2NjQtMmU5NzAwMDUtYzdkOC00ZWI3LWJkY2QtMzE3NWNkOGJjNDA4LnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3NDAxMFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTg4N2E0MjIzMzAzMmI4N2FiZjg2NGY4ZjA5OWI5ZGQ3YmYzNmMyN2Y2Y2U4MjliZTliZmQ5NWE3OWFlMmUzNmYmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.xwb3G1hhKbc8VhCXdTZ4u_eGe5MJ4pjm76Isnlxhv9I)

### 13. 동호회 앨범 페이지
![앨범](https://private-user-images.githubusercontent.com/50188319/281724094-398bb700-d67a-4786-8f27-4c18a8b2cb94.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDEyNjAsIm5iZiI6MTcwNjM0MDk2MCwicGF0aCI6Ii81MDE4ODMxOS8yODE3MjQwOTQtMzk4YmI3MDAtZDY3YS00Nzg2LThmMjctNGMxOGE4YjJjYjk0LnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MzYwMFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTMxNzY2NGU5ZjY5ODJmMjlkOGIwZmJhMzUwZTM4OTBmOWVkZDQyZjBhZDUxYzA4NDUwOWI4ODM3YjY5ODc5MTMmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.VB9Abm70I-rqHtRh9zrpUYw9jhEzMyj9Tde_mj2QRKM)

### 14. 반응형 모바일 웹
![모바일](https://private-user-images.githubusercontent.com/50188319/282275905-c240b61b-9af4-4231-a909-2d0f48c89698.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDEzNjYsIm5iZiI6MTcwNjM0MTA2NiwicGF0aCI6Ii81MDE4ODMxOS8yODIyNzU5MDUtYzI0MGI2MWItOWFmNC00MjMxLWE5MDktMmQwZjQ4Yzg5Njk4LnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3Mzc0NlomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTAzNTZmZjdlMTk2MTAxNTlhM2Q4NzQyMzNhYTQxYjJlZmRjYWE0YmFjZmVhMTdlNmE3MjI1YzY2YjFlM2EyYTQmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.sDLR24JWXj-IqNv49ot4t97OQWNGZuNCvEFzV1uWmz8)
![모동](https://private-user-images.githubusercontent.com/50188319/282275912-9194f6ef-8235-4a26-9d4e-048fe6f3b217.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDEzODEsIm5iZiI6MTcwNjM0MTA4MSwicGF0aCI6Ii81MDE4ODMxOS8yODIyNzU5MTItOTE5NGY2ZWYtODIzNS00YTI2LTlkNGUtMDQ4ZmU2ZjNiMjE3LnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MzgwMVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWY4NGI2OGJiMzA0NDA4Zjk1YWU3NGNlOTZkY2RiMWE0YmQ5MDlhNWQ3YWU0NzI5MDJmZDkzMTFkNTI2NmQ4ZTkmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.ddXe-lksFnHF4YX87I9As8SqvoYXWq8t97Yg5P2BlpA)
![모번](https://private-user-images.githubusercontent.com/50188319/282275926-e6db50fe-be54-48a9-88bc-f051ffbe510f.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDYzNDEzOTUsIm5iZiI6MTcwNjM0MTA5NSwicGF0aCI6Ii81MDE4ODMxOS8yODIyNzU5MjYtZTZkYjUwZmUtYmU1NC00OGE5LTg4YmMtZjA1MWZmYmU1MTBmLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDAxMjclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQwMTI3VDA3MzgxNVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTI1ZjkwNjFmMDIyMTkyNTNkMTZmMDRkZjgwMWJiYmNhODhkNDhlZDhmYzUzYjI3NTNkMzdlOWY3MWVmMWYwYWQmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0JmFjdG9yX2lkPTAma2V5X2lkPTAmcmVwb19pZD0wIn0.DO05FN5GhbSZ4lj169PPQ8yxbObOSVBYuSCmKhNVWAU)


