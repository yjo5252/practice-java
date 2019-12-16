
# 입출력 스트림


## 1. 바이트 스트림을 다루는 클래스 계층 구조 

### 입력 스트림

- InputStream  (최상위 추상 클래스)
- FileInputStream 
- DataInputStream 

### 출력 스트림

- OutputStream (추상위 클래스)
- FileOutputStream 
- DataOutputStream 


## 2. 문자 스트림을 다루는 클래스 계층 구조 

### 입력 스트림 

- Reader (최상위 추상 클래스) 
- InputStreamReader
- FileReader
- BufferedReader

### 출력 스트림

- Writer
- OutputStreamWriter
- FileWriter
- BufferedWriter

## 3. 용어 정리 
### 바이트 스트림 클래스 
* 바이트 스트림 : 바이너리 값을 읽고 쓰는 스트림
* InputStream/OutputStream: 바이트 입출력 스트림을 다루는 모든 클래스의 수퍼 클래스 
* FileInputStream/FileOutputStream : 파일로부터 바이트 단위로 읽거나 저장하는 클래스 
* DataInputStream/DataOutputStream : 자바의 기본 데이터 타입의 변수를 바이너리 값 그대로 입출력

### 문자 스트림 클래스 
* 문자 스트림 : 유니코드로 된 문자를 입출력하는 스트림
* Reader/Writer : 문자 스트림을 다루는 모든 클래스의 슈퍼 클래스 
* InputStreamReader/OutputStreamReader : 바이트를 읽어 문자로 인코딩하여 입력 / 문자를 바이트로 디코딩하여 출력
* FileReader/FileWriter : 텍스트 파일에서 문자 데이터 입출력
