# ai_mosaic_project

<br>



## 1. 서비스 소개

AISAIC 서비스의 구조는 다음 사진과 같다.

<img width="679" alt="스크린샷 2023-08-09 오후 11 18 15" src="https://github.com/minju7346/ai_mosaic_project/assets/58619427/3a30684b-3c14-4a13-8885-2f094bd0cc6c">

‘AISAIC‘는 사용자가 제공한 정보에 기반하여 시각 콘텐츠 속 얼굴을 모자이크 처리해주는 AI 프레임워크 및 이를 적용한 모바일 어플리케이션이다. 사용자들은 영상 속에서 자신을 제외한 타인의 얼굴을 자동으로 모자이크 처리를 할 수 있다.

<br>

<br>
<br>
<br>

- 실행화면
  
<img width="336" alt="스크린샷 2023-08-09 오후 11 19 08" src="https://github.com/minju7346/ai_mosaic_project/assets/58619427/9bc43c35-4afa-4b1a-966d-98c721155011">

<br>
<br>
<br>
<br>
<br>
<br>

## 2. 서버 개발 환경
   
Framwork :　Java Spring 

Editor : IntelliJ

Package : Spring Boot, JPA, Oauth, Lombok, etc

Cloud : AWS(EC2, RDS, S3)

<br>
<br>
<br>
<br>
<br>
<br>

# 3. 데이터베이스

## 3.1 ERD와 테이블 구성

<img width="591" alt="스크린샷 2023-08-09 오후 11 12 24" src="https://github.com/minju7346/ai_mosaic_project/assets/58619427/970d4a00-d8a2-403e-8bbe-b01175a401e4">

<img width="975" alt="스크린샷 2023-08-09 오후 11 12 39" src="https://github.com/minju7346/ai_mosaic_project/assets/58619427/603d900f-0d60-4f3c-b3b5-8c57ccd7b911">

<br>
<br>
<br>
<br>
<br>
<br>

## 3.2 테이블 구조

1) login_request 테이블
: 사용자가 소셜 로그인을 통해 생성된 사용자 정보 값을 관리

<img width="878" alt="스크린샷 2023-08-09 오후 11 13 08" src="https://github.com/minju7346/ai_mosaic_project/assets/58619427/db38ad1b-524e-4db0-922a-d37c0b80e6ae">

2) registrant 테이블 
: 사용자가 AI모델에게 제공할 등록인의 이미지 파일과 이름을 관리

<img width="887" alt="스크린샷 2023-08-09 오후 11 13 30" src="https://github.com/minju7346/ai_mosaic_project/assets/58619427/a752d2d7-dcc5-4769-90b5-5d83172abe1c">


3）file 테이블
: 영상 파일(mp4)를 관리할 테이블

<img width="893" alt="스크린샷 2023-08-09 오후 11 13 49" src="https://github.com/minju7346/ai_mosaic_project/assets/58619427/1f299d34-a132-4569-829d-a20cd4952f51">


4) user 테이블
  : 등록인과 영상 업로드 시 유저 구별에 필요한 유저 정보를 담고있음

<img width="885" alt="스크린샷 2023-08-09 오후 11 14 35" src="https://github.com/minju7346/ai_mosaic_project/assets/58619427/16f15c85-fcb0-41d3-9931-5b6ce14d6ea6">

<br>
<br>
<br>
<br>
<br>
<br>

## 4. 서버 구동 순서

 1) IntelliJ를 통한 스프링 부트 빌드 파일 생성(jar파일 생성)
  ->intelliJ내 Gradled의 bootJar을 통해 빌드 후 생성된 jar파일 사용
 2) FTP서비스인 FileZila를 통해 EC2서버로 빌드 파일 전송

<img width="925" alt="스크린샷 2023-08-09 오후 11 15 06" src="https://github.com/minju7346/ai_mosaic_project/assets/58619427/d54e309f-c870-4e43-9473-68bb53b351ce">

3) EC2에서 jar명령어를 통해 스프링 부트 파일 실행
   > java –jar ‘jar 파일명‘

<img width="947" alt="스크린샷 2023-08-09 오후 11 15 28" src="https://github.com/minju7346/ai_mosaic_project/assets/58619427/acc02c8a-4d04-4eb0-8c7f-2d02af94c6e3">


<br>
<br>
<br>
<br>
<br>
<br>

## 5. 기능별 설명

1) Login Controller, 로그인 관련 API

- /login/kakao(POST)
: 카카오 계정을 통한 로그인 객체로 id, email, name값을 클라이언트로부터 받아서 객체를 저장하고, ID에 대한 토큰 값을 생성하여 클라이언트로 리턴함


- /login/naver(POST)
: 네이버 계정을 통한 로그인 객체로 id, email, name값을 클라이언트로부터 받아서 객체를 저장하고, ID에 대한 토큰 값을 생성하여 클라이언트로 리턴함


- /login/google(POST)
: 구글 계정을 통한 로그인 객체로 id, email, name값을 클라이언트로부터 받아서 객체를 저장하고, ID에 대한 토큰 값을 생성하여 클라이언트로 리턴함

2) Registrant Controller, 등록인 관련 API
- /registrant/print(GET), 토큰 인증
: 클라이언트가 요청 시 보낸 헤더 값을 통해 ID값으로 유저를 구분하고, 유저 ID 값을 기반으로 등록인들의 리스트를 클라이언트로 리턴함

 - /registrant/add(GET)
: 등록인을 추가하는 화면을 출력함

- /registrant/save(POST) , 토큰 인증
: 해당 토큰에 해당하는 유저 ID를 기반으로 등록인의 정보를 Json형식으로 받아와서 등록인 개객체를 생성한 후, 생성 값을 Mysql에 저장함

3) S3 Controller, S3 관련 API

- /S3/upload-image(POST)
: S3에 있는 img디렉토리에 등록인 사진 이미지 파일을 저장함

- /S3/upload-video(POST)
: S3에 있는 video디렉토리에 유저가 모자이크 처리하고자 하는 영상 파일을 저장함

- /S3/download(POST)
: S3에 있는 video/convert디렉토리로부터 AI 렌더링을 거쳐 모자이크 처리된 영상을 클라이언트로 다운로드함

- /S3/delete(POST)
: S3에 저장되어 있는 파일 중 유저가 삭제하고자 하는 파일명을 파라미터로 전달받아 S3에서 파일을 삭제함
