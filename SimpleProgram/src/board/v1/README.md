
## 기능명세
>파일(클래스) 구조화

1. Board : 게시판에 들어갈 속성을 정의한 클래스
2. BoardCreate : 게시글 새로 입력하는 클래스
3. BoardSelect : 게시글을 읽어오는 클래스
4. BoardUpdate : 게시글을 수정하는 클래스
5. BoardDelete : 게시글을 삭제하는 클래스


## DB 
### 생성

[sqldb -> board1]

```sql
create table board1( 
    bno INT AUTO_INCREMENT PRIMARY KEY, 
    btitle VARCHAR(30) NOT NULL, 
    bcontent VARCHAR,
    bdate DATE);
```


- AUTO_INCREMENT를 작성할 때는 _를 사용하고 타입을 꼭 작성해야 한다.

### CREATE
```sql
INSERT INTO board1 VALUES(null,'리눅스', '리눅스에서 중요한 것은 커널이다.', sysdate());
```
INSERT 전체로 하는 경우
  - AUTO_INCREMENT를 설정한 경우 bno 자리에 null을 넣어주어야 한다.
  - Date인 bdate에는 함수인 sysdate()를 작성해야 한다.

sysdate()는 now()로 적을 수 있다.
   - sysdate() : UTC 기준 일정한 시간 반환한다.
   - now() : mysql의 서버 타입에 따른 시간을 반환한다.
