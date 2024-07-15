# JFrame을 활용한 미니 프로젝트 제작

## 프로젝트 명
### PC방 관리 프로그램

## 제작 기간
- 2024-04-08 ~ 2024-04-19



## 제작 의도
- 현재의 실력으로Java Swing을 통한 어플리케이션 제작에 문제가 없는지를 파악
- 데이터베이스와의 연동을 하고, 간단한 CRUD가 문제가 없는지 파악
- 스레드를 통해 남은 시간을 계산하고 화면을 업데이트할 수 있는지

## 프로그램의 흐름
- 회원가입 및 로그인
- 시간 충전
- 좌석 선택
- 이동
- 메인 화면

## 단계별 구동영상

### 회원가입 하기
https://github.com/KangJeongTaek/java_Jframe/assets/158122796/4c14dd73-8d8b-49e8-a588-ab0a9c27706f

### 아이디를 통한 비밀번호 찾기
https://github.com/KangJeongTaek/java_Jframe/assets/158122796/b900014c-f81b-4e07-8a8d-78b1cc55b04b

### 로그인 하기
https://github.com/KangJeongTaek/java_Jframe/assets/158122796/62ad783a-412c-421e-91b9-52d8c314747c

### 시간 충전하기
https://github.com/KangJeongTaek/java_Jframe/assets/158122796/bd6fa865-5801-40fc-9baf-196643c4dd0b

### 좌석 선택 , 좌석으로 이동
- 이동하는 것을 표현하기 위해 파란 점을 목적지까지 움직이게 만듦

https://github.com/KangJeongTaek/java_Jframe/assets/158122796/b7d0f878-efee-4db7-a13e-0b31be92c026

### 메인 화면에서 먹거리 주문하기
https://github.com/KangJeongTaek/java_Jframe/assets/158122796/9b1d27e6-0b6c-435f-91b5-11c7063c9351

### 메인 화면에서 시간 충전하기
https://github.com/KangJeongTaek/java_Jframe/assets/158122796/7d0f4d55-9cbb-4125-9f59-fc136dbb12d1

### 게임과 관련된 영상
- 참조 레포지토리
  - https://github.com/KangJeongTaek/java_snake
  - https://github.com/KangJeongTaek/java_tetris


## 마무리하며
### 성과
- 목표로 했던 모든 기능들은 구현 완료했다.
### 아쉬웠던 점
- 구현에만 초점을 맞추었다.
    - (1) 보안문제
    - (2) 예외 처리
    - (3) 동시 다발적인 프로그램 실행을 상정하지 않음(DB connection 등에서 문제가 발생할 것이라 예상됨)
- 현재 시간이 업데이트 될 때마다 DB에 저장되는 것이 아닌 시스템 종료 혹은 시간 충전 시에만 DB에 업데이트 해주고 있다.
- 재고, 그리고 좌석에 관련된 DB는 기간을 고려해 처음부터 고려 대상이 아니라 구현하지 않았다.
- 게임과 관련해서 실행 후 창을 닫고 다시 실행할 때마다, 새로운 객체를 생성하고 있는데 이게 맞는 로직인지 자신이 없다.






