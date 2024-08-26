### 1. App04_intent
#### 1. MainActivity
> : 사용자가 입력한 두 숫자의 합계 계산하여 결과 표시
<details>
  <summary>calss</summary>

  + ##### <mark>MainActivitySub</mark>
  > 두 숫자 합계 계산하여 결과값 전달
</details>


#### 2. MainActivity2
> : 사용자 입력 및 출력을 다른 액티비티에서 처리
<details>
  <summary>input, output</summary>

  + ##### <mark>MainActivity2_Input</mark>
  > 이름, 나이, 전화번호 입력받아 MainActivity2 로 반환

  + #### <mark>MainActivity2_Out</mark>
  > MainActivity2 에서 전달받은 이름, 나이, 전화번호 데이터 출력
</details>


#### 3. MainActivity2_recycler
> : RecyclerView 의 데이터 출력을 Adapter class 에서 구현
<details>
  <summary>class</summary>

  + ##### <mark>MyAdapter</mark>
    > 단순 문자열 리스트를 RecyclerView 에 표시하는 Adapter class
</details>


#### 4. MainActivity3
> : Dialog 표시 및 CustomDialog 결과값 처리


#### 5. MainActivity3_memo
> : RecyclerView 의 데이터를 Adapter class 에서 구현
<details>
  <summary>class</summary>

  + ##### <mark>memo</mark>
  > no, title, timestamp 저장하는 data class
  
</details>

<br>

### 2. App05

<br>

### 3. App06-1
#### 1. MainActivity
> : RecyclerView 의 데이터 추가, 수정, 삭제를 Adapter class 에서 구현
<details>
  <summary>class</summary>
  
+ ##### <mark>Phone</mark>
  > name, tel 저장하는 data class
  
+ ##### <mark>PhoneAdapter</mark>
  > MainActivity 의 RecyclerView 에 Phone 목록 표시하는 Adapter class
  + addItem(아이템 추가)
    > 'phoneList' 데이터 추가
  + updateItem(아이템 수정)
    > 'phoneList' 특정 데이터 수정
  + deleteItem(아이템 삭제)
    > 'phoneList' 특정 데이터 삭제
  + OnItemClickLister Interface
    > RecyclerView 아이템 클릭 시 해당 위치 처리하도록 인터페이스 정의
  + itemView.setOnClickListener
    > RecyclerView 아이템 클릭 시 onItemClick 메서드 호출
</details>


#### 2. MainActivity2
> : RecyclerView 의 데이터 추가, 수정, 삭제를 MainActivity2 에서 구현
<details>
  <summary>class</summary>

+ ##### <mark>Friend</mark>
  > resourceId, name, msg 저장하는 data class
  
+ ##### <mark>FriendAdapter</mark>
  > MainActivity2 의 RecyclerView 에 Phone 목록 표시하는 Adapter class
  + OnItemClickLister Interface
    > RecyclerView 아이템 클릭 시 해당 위치 처리하도록 인터페이스 정의
  + itemView.setOnClickListener
    > RecyclerView 아이템 클릭 시 onItemClick 메서드 호출
</details>

<br>

### 4. App06-2
> App06-3 에서 다시 시작

<br>
<br>

## 5. App06-3
