
# 1. api 명세


| 기능      | Method | URL                       | request |response| 상태코드    |
|---------|--------|---------------------------|---------|---|---------|
| 일정 등록   | POST   | /api/post         | 요청 body |response| 등록정보    |
| 일정 조회   | GET    | /api/sget/{id}    | 요청 body |response| 단건 응답정보 |
| 일정 목록조회 | GET    | /api/sget         | 요청 body |response| 다건 응답정보 |
| 일정 수정   | PUT    | /api/sput/{id}    | 요청 body |response| 수정정보    |
| 일정 삭제   | DELETE | /api/sdelete/{id} | 요청 body |response| -       |

# 2. ERD

| Column Name   | Data Type         | 의미                                |
|---------------|-------------------|-----------------------------------|
| `_id` | INT AUTOINCREMENT | Primary Key, 일정의 고유 식별자           |
| `task`        | VARCHAR           | 할일, 일정 내용                         |
| `manager`     | VARCHAR           | 담당자명                              |
| `password`    | VARCHAR           | 비밀번호, 서버에 일정 수정을 요청할 때 비밀번호 같이 사용 |
| `first_date`  | DATETIME          | 작성일, 날짜와 시간 포함                    |
| `last_date`   | DATETIME          | 수정일, 일정이 마지막으로 수정된 날짜와 시간         |
